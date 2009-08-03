/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
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
package org.seasar.doma.converter;

import java.sql.Date;

/**
 * {@link Date} へのコンバーターです。
 * 
 * @author taedium
 * 
 */
public class DateConverter implements Converter<Date> {

    /** デフォルトパターン */
    protected static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    /** 変換サポート */
    protected final ConversionSupport conversionSupport = new ConversionSupport();

    @Override
    public Date convert(Object value, String pattern) {
        if (value == null) {
            return null;
        }
        if (Date.class.isInstance(value)) {
            Date date = Date.class.cast(value);
            return new Date(date.getTime());
        }
        if (java.util.Date.class.isInstance(value)) {
            java.util.Date date = java.util.Date.class.cast(value);
            return new Date(date.getTime());
        }
        if (String.class.isInstance(value)) {
            java.util.Date date = parse(String.class.cast(value), pattern);
            return new Date(date.getTime());
        }
        throw new UnsupportedConversionException(value.getClass().getName(),
                Date.class.getName(), value);
    }

    /**
     * 文字列をパースします。
     * 
     * @param value
     *            文字列
     * @param pattern
     *            パターン
     * @return パースされた結果
     * @throws ConversionException
     *             変換に失敗した場合
     */
    protected java.util.Date parse(String value, String pattern) {
        String p = pattern != null ? pattern : DEFAULT_PATTERN;
        return conversionSupport.parseToDate(value, p);
    }
}
