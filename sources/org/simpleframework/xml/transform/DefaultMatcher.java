package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class DefaultMatcher implements Matcher {
    private Matcher matcher;
    private Matcher primitive = new PrimitiveMatcher();
    private Matcher stock = new PackageMatcher();
    private Matcher array = new ArrayMatcher(this);

    public DefaultMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    private Transform matchType(Class cls) throws Exception {
        return (cls.isArray() ? this.array : cls.isPrimitive() ? this.primitive : this.stock).match(cls);
    }

    public Transform match(Class cls) throws Exception {
        Transform match = this.matcher.match(cls);
        return match != null ? match : matchType(cls);
    }
}
