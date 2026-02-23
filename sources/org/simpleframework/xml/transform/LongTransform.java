package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class LongTransform implements Transform {
    public Long read(String str) {
        return Long.valueOf(str);
    }

    public String write(Long l) {
        return l.toString();
    }
}
