package org.spongycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Encoder {
    int decode(String str, OutputStream outputStream) throws IOException;

    int decode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException;

    int encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException;
}
