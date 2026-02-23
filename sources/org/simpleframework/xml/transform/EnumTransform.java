package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class EnumTransform implements Transform {
    private final Class type;

    public EnumTransform(Class cls) {
        this.type = cls;
    }

    public Enum read(String str) throws Exception {
        return Enum.valueOf(this.type, str);
    }

    public String write(Enum r1) throws Exception {
        return r1.name();
    }
}
