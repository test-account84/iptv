package org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface ContentProducer {
    void writeTo(OutputStream outputStream) throws IOException;
}
