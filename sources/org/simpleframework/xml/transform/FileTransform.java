package org.simpleframework.xml.transform;

import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class FileTransform implements Transform {
    public File read(String str) {
        return new File(str);
    }

    public String write(File file) {
        return file.getPath();
    }
}
