package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class DoubleTransform implements Transform {
    public Double read(String str) {
        return Double.valueOf(str);
    }

    public String write(Double d) {
        return d.toString();
    }
}
