package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class en {
    private final AudioManager a;
    private final el b;
    private em c;
    private f d;
    private int e;
    private int f;
    private float g = 1.0f;
    private AudioFocusRequest h;

    public en(Context context, Handler handler, em emVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        af.s(audioManager);
        this.a = audioManager;
        this.c = emVar;
        this.b = new el(this, handler);
        this.e = 0;
    }

    public static /* bridge */ /* synthetic */ void c(en enVar, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                enVar.h(3);
                return;
            } else {
                enVar.g(0);
                enVar.h(2);
                return;
            }
        }
        if (i == -1) {
            enVar.g(-1);
            enVar.f();
        } else if (i == 1) {
            enVar.h(1);
            enVar.g(1);
        } else {
            cd.e("AudioFocusManager", "Unknown focus change type: " + i);
        }
    }

    private final void f() {
        if (this.e == 0) {
            return;
        }
        if (cq.a >= 26) {
            AudioFocusRequest audioFocusRequest = this.h;
            if (audioFocusRequest != null) {
                U.a(this.a, audioFocusRequest);
            }
        } else {
            this.a.abandonAudioFocus(this.b);
        }
        h(0);
    }

    private final void g(int i) {
        em emVar = this.c;
        if (emVar != null) {
            fy fyVar = (fy) emVar;
            boolean q = fyVar.a.q();
            gc.K(fyVar.a, q, i, gc.v(q, i));
        }
    }

    private final void h(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        em emVar = this.c;
        if (emVar != null) {
            gc.H(((fy) emVar).a);
        }
    }

    public final float a() {
        return this.g;
    }

    public final int b(boolean z, int i) {
        int requestAudioFocus;
        if (i == 1 || this.f != 1) {
            f();
            return z ? 1 : -1;
        }
        if (!z) {
            return -1;
        }
        if (this.e != 1) {
            if (cq.a >= 26) {
                AudioFocusRequest audioFocusRequest = this.h;
                if (audioFocusRequest == null) {
                    W.a();
                    V.a(this.f);
                    af.s(null);
                    throw null;
                }
                requestAudioFocus = T.a(this.a, audioFocusRequest);
            } else {
                AudioManager audioManager = this.a;
                el elVar = this.b;
                af.s(null);
                requestAudioFocus = audioManager.requestAudioFocus(elVar, 3, this.f);
            }
            if (requestAudioFocus != 1) {
                h(0);
                return -1;
            }
            h(1);
        }
        return 1;
    }

    public final void d() {
        this.c = null;
        f();
    }

    public final void e(f fVar) {
        if (cq.V(null, null)) {
            return;
        }
        this.d = null;
        this.f = 0;
        af.v(true, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }
}
