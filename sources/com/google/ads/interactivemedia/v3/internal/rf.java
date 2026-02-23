package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface rf {
    int a();

    int b(MediaCodec.BufferInfo bufferInfo);

    MediaFormat c();

    ByteBuffer f(int i);

    ByteBuffer g(int i);

    void h();

    void i();

    void j(int i, long j);

    void k(int i, boolean z);

    void l(Surface surface);

    void m(Bundle bundle);

    void n(int i);

    void p();

    void q(int i, int i2, long j, int i3);

    void r(int i, ec ecVar, long j);
}
