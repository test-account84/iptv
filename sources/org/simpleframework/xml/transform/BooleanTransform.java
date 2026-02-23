package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class BooleanTransform implements Transform {
    public Boolean read(String str) {
        return Boolean.valueOf(str);
    }

    public String write(Boolean bool) {
        return bool.toString();
    }
}
