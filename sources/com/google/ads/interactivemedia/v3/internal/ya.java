package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ya implements Choreographer.FrameCallback, Handler.Callback {
    private static final ya b = new ya();
    public volatile long a = -9223372036854775807L;
    private final Handler c;
    private final HandlerThread d;
    private Choreographer e;
    private int f;

    private ya() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        this.d = handlerThread;
        handlerThread.start();
        Handler z = cq.z(handlerThread.getLooper(), this);
        this.c = z;
        z.sendEmptyMessage(0);
    }

    public static ya a() {
        return b;
    }

    public final void b() {
        this.c.sendEmptyMessage(1);
    }

    public final void c() {
        this.c.sendEmptyMessage(2);
    }

    public final void doFrame(long j) {
        this.a = j;
        Choreographer choreographer = this.e;
        af.s(choreographer);
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            try {
                this.e = Choreographer.getInstance();
            } catch (RuntimeException e) {
                cd.f("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e);
            }
            return true;
        }
        if (i == 1) {
            Choreographer choreographer = this.e;
            if (choreographer != null) {
                int i2 = this.f + 1;
                this.f = i2;
                if (i2 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        }
        if (i != 2) {
            return false;
        }
        Choreographer choreographer2 = this.e;
        if (choreographer2 != null) {
            int i3 = this.f - 1;
            this.f = i3;
            if (i3 == 0) {
                choreographer2.removeFrameCallback(this);
                this.a = -9223372036854775807L;
            }
        }
        return true;
    }
}
