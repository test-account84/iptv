package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class vy {
    private final Spatializer a;
    private final boolean b;
    private Handler c;
    private Spatializer.OnSpatializerStateChangedListener d;

    private vy(Spatializer spatializer) {
        this.a = spatializer;
        this.b = J1.a(spatializer) != 0;
    }

    public static vy a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return new vy(K1.a(audioManager));
    }

    public final void b(wd wdVar, Looper looper) {
        if (this.d == null && this.c == null) {
            this.d = new vx(wdVar);
            Handler handler = new Handler(looper);
            this.c = handler;
            M1.a(this.a, new vw(handler, 0), this.d);
        }
    }

    public final void c() {
        Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.d;
        if (onSpatializerStateChangedListener == null || this.c == null) {
            return;
        }
        N1.a(this.a, onSpatializerStateChangedListener);
        Handler handler = this.c;
        int i = cq.a;
        handler.removeCallbacksAndMessages((Object) null);
        this.c = null;
        this.d = null;
    }

    public final boolean d(f fVar, s sVar) {
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(cq.f(("audio/eac3-joc".equals(sVar.l) && sVar.y == 16) ? 12 : sVar.y));
        int i = sVar.z;
        if (i != -1) {
            channelMask.setSampleRate(i);
        }
        return O1.a(this.a, fVar.a().a, channelMask.build());
    }

    public final boolean e() {
        return L1.a(this.a);
    }

    public final boolean f() {
        return P1.a(this.a);
    }

    public final boolean g() {
        return this.b;
    }
}
