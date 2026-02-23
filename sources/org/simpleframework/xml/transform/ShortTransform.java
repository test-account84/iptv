package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ShortTransform implements Transform {
    public Short read(String str) {
        return Short.valueOf(str);
    }

    public String write(Short sh) {
        return sh.toString();
    }
}
