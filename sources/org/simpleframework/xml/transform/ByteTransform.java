package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ByteTransform implements Transform {
    public Byte read(String str) {
        return Byte.valueOf(str);
    }

    public String write(Byte b) {
        return b.toString();
    }
}
