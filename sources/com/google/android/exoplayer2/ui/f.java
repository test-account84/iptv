package com.google.android.exoplayer2.ui;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface f {

    public interface a {
        void C(f fVar, long j, boolean z);

        void D(f fVar, long j);

        void o(f fVar, long j);
    }

    void a(a aVar);

    void b(long[] jArr, boolean[] zArr, int i);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z);

    void setPosition(long j);
}
