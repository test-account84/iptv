package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class rt implements rs {
    private rt() {
    }

    public final int a() {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo b(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    public final boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    public final boolean d() {
        return false;
    }

    public final boolean e(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    public /* synthetic */ rt(byte[] bArr) {
    }
}
