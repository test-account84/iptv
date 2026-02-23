package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ru implements rs {
    private final int a;
    private MediaCodecInfo[] b;

    public ru(boolean z, boolean z2) {
        int i = 1;
        if (!z && !z2) {
            i = 0;
        }
        this.a = i;
    }

    private final void f() {
        if (this.b == null) {
            this.b = new MediaCodecList(this.a).getCodecInfos();
        }
    }

    public final int a() {
        f();
        return this.b.length;
    }

    public final MediaCodecInfo b(int i) {
        f();
        return this.b[i];
    }

    public final boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    public final boolean d() {
        return true;
    }

    public final boolean e(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }
}
