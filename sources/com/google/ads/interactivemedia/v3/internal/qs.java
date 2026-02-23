package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.os.HandlerThread;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class qs implements re {
    private final atq b;
    private final atq c;

    public qs(int i) {
        qr qrVar = new qr(i, 1);
        qr qrVar2 = new qr(i, 0);
        this.b = qrVar;
        this.c = qrVar2;
    }

    public final qt a(rd rdVar) throws IOException {
        MediaCodec mediaCodec;
        String str = rdVar.a.a;
        qt qtVar = null;
        try {
            af.o("createCodec:" + str);
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
                qt qtVar2 = new qt(mediaCodec, (HandlerThread) this.b.a(), (HandlerThread) this.c.a());
                try {
                    af.p();
                    qt.o(qtVar2, rdVar.b, rdVar.d, rdVar.e);
                    return qtVar2;
                } catch (Exception e) {
                    e = e;
                    qtVar = qtVar2;
                    if (qtVar != null) {
                        qtVar.i();
                    } else if (mediaCodec != null) {
                        mediaCodec.release();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodec = null;
        }
    }
}
