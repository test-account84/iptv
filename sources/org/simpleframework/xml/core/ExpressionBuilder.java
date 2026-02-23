package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.LimitedCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ExpressionBuilder {
    private final Cache cache = new LimitedCache();
    private final Format format;
    private final Class type;

    public ExpressionBuilder(Detail detail, Support support) {
        this.format = support.getFormat();
        this.type = detail.getType();
    }

    private Expression create(String str) throws Exception {
        PathParser pathParser = new PathParser(str, new ClassType(this.type), this.format);
        Cache cache = this.cache;
        if (cache != null) {
            cache.cache(str, pathParser);
        }
        return pathParser;
    }

    public Expression build(String str) throws Exception {
        Expression expression = (Expression) this.cache.fetch(str);
        return expression == null ? create(str) : expression;
    }
}
