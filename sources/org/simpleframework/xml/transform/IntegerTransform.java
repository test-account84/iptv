package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class IntegerTransform implements Transform {
    public Integer read(String str) {
        return Integer.valueOf(str);
    }

    public String write(Integer num) {
        return num.toString();
    }
}
