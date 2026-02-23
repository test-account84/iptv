package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class hs {
    private final Context a;
    private final Handler b;
    private final hp c;
    private final AudioManager d;
    private hr e;
    private int f;
    private int g;
    private boolean h;

    public hs(Context context, Handler handler, hp hpVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = handler;
        this.c = hpVar;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
        af.t(audioManager);
        this.d = audioManager;
        this.f = 3;
        this.g = g(audioManager, 3);
        this.h = i(audioManager, this.f);
        hr hrVar = new hr(this);
        try {
            cq.au(applicationContext, hrVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.e = hrVar;
        } catch (RuntimeException e) {
            cd.f("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    public static /* bridge */ /* synthetic */ Handler c(hs hsVar) {
        return hsVar.b;
    }

    public static /* bridge */ /* synthetic */ void d(hs hsVar) {
        hsVar.h();
    }

    private static int g(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            cd.f("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i, e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    private final void h() {
        int g = g(this.d, this.f);
        boolean i = i(this.d, this.f);
        if (this.g == g && this.h == i) {
            return;
        }
        this.g = g;
        this.h = i;
        gc.z(((fy) this.c).a).g(30, new fv(g, i));
    }

    private static boolean i(AudioManager audioManager, int i) {
        return cq.a >= 23 ? Z.a(audioManager, i) : g(audioManager, i) == 0;
    }

    public final int a() {
        return this.d.getStreamMaxVolume(this.f);
    }

    public final int b() {
        if (cq.a >= 28) {
            return Y.a(this.d, this.f);
        }
        return 0;
    }

    public final void e() {
        hr hrVar = this.e;
        if (hrVar != null) {
            try {
                this.a.unregisterReceiver(hrVar);
            } catch (RuntimeException e) {
                cd.f("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            this.e = null;
        }
    }

    public final void f(int i) {
        if (this.f == 3) {
            return;
        }
        this.f = 3;
        h();
        fy fyVar = (fy) this.c;
        l y = gc.y(gc.B(fyVar.a));
        if (y.equals(gc.x(fyVar.a))) {
            return;
        }
        gc.E(fyVar.a, y);
        gc.z(fyVar.a).g(29, new fw(y, 0));
    }
}
