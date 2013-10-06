/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.internal.jdbc.query;

import static org.seasar.doma.internal.util.AssertionUtil.*;

import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.ArrayList;

import org.seasar.doma.internal.jdbc.entity.AbstractPostInsertContext;
import org.seasar.doma.internal.jdbc.entity.AbstractPreInsertContext;
import org.seasar.doma.internal.jdbc.sql.PreparedSqlBuilder;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.JdbcException;
import org.seasar.doma.jdbc.SqlKind;
import org.seasar.doma.jdbc.entity.Accessor;
import org.seasar.doma.jdbc.entity.EntityPropertyType;
import org.seasar.doma.jdbc.entity.EntityType;
import org.seasar.doma.jdbc.entity.GeneratedIdPropertyType;
import org.seasar.doma.jdbc.id.IdGenerationConfig;
import org.seasar.doma.message.Message;

/**
 * @author taedium
 * 
 */
public class AutoInsertQuery<E> extends AutoModifyQuery<E> implements
        InsertQuery {

    protected boolean nullExcluded;

    protected GeneratedIdPropertyType<? super E, E, ?, ?> generatedIdPropertyType;

    protected IdGenerationConfig idGenerationConfig;

    public AutoInsertQuery(EntityType<E> entityType) {
        super(entityType);
    }

    @Override
    public void prepare() {
        assertNotNull(method, config, entityType, entity, callerClassName,
                callerMethodName);
        executable = true;
        preInsert();
        prepareIdAndVersionPropertyTypes();
        prepareOptions();
        prepareTargetPropertyType();
        prepareIdValue();
        prepareVersionValue();
        prepareSql();
        assertNotNull(sql);
    }

    protected void preInsert() {
        AutoPreInsertContext<E> context = new AutoPreInsertContext<E>(
                entityType, method, config);
        entityType.preInsert(entity, context);
        if (context.getNewEntity() != null) {
            entity = context.getNewEntity();
        }
    }

    @Override
    protected void prepareIdAndVersionPropertyTypes() {
        super.prepareIdAndVersionPropertyTypes();
        generatedIdPropertyType = entityType.getGeneratedIdPropertyType();
        if (generatedIdPropertyType != null) {
            idGenerationConfig = new IdGenerationConfig(config, entityType);
            generatedIdPropertyType
                    .validateGenerationStrategy(idGenerationConfig);
            autoGeneratedKeysSupported = generatedIdPropertyType
                    .isAutoGeneratedKeysSupported(idGenerationConfig);
        }
    }

    protected void prepareTargetPropertyType() {
        targetPropertyTypes = new ArrayList<>(entityType
                .getEntityPropertyTypes().size());
        for (EntityPropertyType<E, ?, ?> p : entityType
                .getEntityPropertyTypes()) {
            if (!p.isInsertable()) {
                continue;
            }
            Accessor<E, ?, ?> accessor = p.getAccessor();
            accessor.load(entity);
            if (p.isId()) {
                if (p != generatedIdPropertyType
                        || generatedIdPropertyType
                                .isIncluded(idGenerationConfig)) {
                    targetPropertyTypes.add(p);
                }
                if (generatedIdPropertyType == null
                        && accessor.getWrapper().get() == null) {
                    throw new JdbcException(Message.DOMA2020,
                            entityType.getName(), p.getName());
                }
                continue;
            }
            if (p.isVersion()) {
                targetPropertyTypes.add(p);
                continue;
            }
            if (nullExcluded) {
                if (accessor.getWrapper().get() == null) {
                    continue;
                }
            }
            if (!isTargetPropertyName(p.getName())) {
                continue;
            }
            targetPropertyTypes.add(p);
        }
    }

    protected void prepareIdValue() {
        if (generatedIdPropertyType != null && idGenerationConfig != null) {
            E newEntity = generatedIdPropertyType.preInsert(entityType, entity,
                    idGenerationConfig);
            entity = newEntity;
        }
    }

    protected void prepareVersionValue() {
        if (versionPropertyType != null) {
            entity = versionPropertyType.setIfNecessary(entityType, entity, 1);
        }
    }

    protected void prepareSql() {
        PreparedSqlBuilder builder = new PreparedSqlBuilder(config,
                SqlKind.INSERT);
        builder.appendSql("insert into ");
        builder.appendSql(entityType.getQualifiedTableName());
        builder.appendSql(" (");
        for (EntityPropertyType<E, ?, ?> p : targetPropertyTypes) {
            builder.appendSql(p.getColumnName());
            builder.appendSql(", ");
        }
        builder.cutBackSql(2);
        builder.appendSql(") values (");
        for (EntityPropertyType<E, ?, ?> p : targetPropertyTypes) {
            Accessor<E, ?, ?> accessor = p.getAccessor();
            accessor.load(entity);
            builder.appendWrapper(accessor.getWrapper());
            builder.appendSql(", ");
        }
        builder.cutBackSql(2);
        builder.appendSql(")");
        sql = builder.build();
    }

    @Override
    public void generateId(Statement statement) {
        if (generatedIdPropertyType != null && idGenerationConfig != null) {
            E newEntity = generatedIdPropertyType.postInsert(entityType,
                    entity, idGenerationConfig, statement);
            entity = newEntity;
        }
    }

    @Override
    public void complete() {
        postInsert();
    }

    protected void postInsert() {
        AutoPostInsertContext<E> context = new AutoPostInsertContext<E>(
                entityType, method, config);
        entityType.postInsert(entity, context);
        if (context.getNewEntity() != null) {
            entity = context.getNewEntity();
        }
    }

    public void setNullExcluded(boolean nullExcluded) {
        this.nullExcluded = nullExcluded;
    }

    protected static class AutoPreInsertContext<E> extends
            AbstractPreInsertContext<E> {

        public AutoPreInsertContext(EntityType<E> entityType, Method method,
                Config config) {
            super(entityType, method, config);
        }
    }

    protected static class AutoPostInsertContext<E> extends
            AbstractPostInsertContext<E> {

        public AutoPostInsertContext(EntityType<E> entityType, Method method,
                Config config) {
            super(entityType, method, config);
        }
    }
}
