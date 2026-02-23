package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class FloatTransform implements Transform {
    public Float read(String str) {
        return Float.valueOf(str);
    }

    public String write(Float f) {
        return f.toString();
    }
}
