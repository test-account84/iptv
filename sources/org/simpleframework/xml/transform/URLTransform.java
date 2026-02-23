package org.simpleframework.xml.transform;

import java.net.URL;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class URLTransform implements Transform {
    public URL read(String str) throws Exception {
        return new URL(str);
    }

    public String write(URL url) throws Exception {
        return url.toString();
    }
}
