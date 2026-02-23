package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aid implements ajs {
    private final ajx a;
    private final String b;
    private final View c;
    private aic d;
    private Activity e;
    private boolean f;
    private final com.google.ads.interactivemedia.v3.impl.data.ag g;

    public aid(String str, ajx ajxVar, View view) {
        com.google.ads.interactivemedia.v3.impl.data.ag agVar = new com.google.ads.interactivemedia.v3.impl.data.ag();
        this.b = str;
        this.a = ajxVar;
        this.c = view;
        this.g = agVar;
        this.e = null;
        this.d = null;
        this.f = false;
    }

    public static /* bridge */ /* synthetic */ Activity a(aid aidVar) {
        return aidVar.e;
    }

    public static /* bridge */ /* synthetic */ ajx b(aid aidVar) {
        return aidVar.a;
    }

    public static /* bridge */ /* synthetic */ String d(aid aidVar) {
        return aidVar.b;
    }

    public static /* bridge */ /* synthetic */ void e(aid aidVar, Activity activity) {
        aidVar.e = activity;
    }

    private static int l(int i, float f) {
        return (int) Math.ceil(i / f);
    }

    private final DisplayMetrics m() {
        return this.c.getContext().getResources().getDisplayMetrics();
    }

    private static com.google.ads.interactivemedia.v3.impl.data.ay n(com.google.ads.interactivemedia.v3.impl.data.ay ayVar, float f) {
        com.google.ads.interactivemedia.v3.impl.data.ax builder = com.google.ads.interactivemedia.v3.impl.data.ay.builder();
        builder.left(l(ayVar.left(), f));
        builder.top(l(ayVar.top(), f));
        builder.height(l(ayVar.height(), f));
        builder.width(l(ayVar.width(), f));
        return builder.build();
    }

    public final com.google.ads.interactivemedia.v3.impl.data.b c(String str, String str2, String str3) {
        com.google.ads.interactivemedia.v3.impl.data.ay n = n(com.google.ads.interactivemedia.v3.impl.data.ay.builder().locationOnScreenOfView(this.c).build(), m().density);
        Rect rect = new Rect();
        boolean globalVisibleRect = this.c.getGlobalVisibleRect(rect);
        IBinder windowToken = this.c.getWindowToken();
        if (!globalVisibleRect || windowToken == null || !this.c.isShown()) {
            rect.set(0, 0, 0, 0);
        }
        com.google.ads.interactivemedia.v3.impl.data.ax builder = com.google.ads.interactivemedia.v3.impl.data.ay.builder();
        builder.left(rect.left);
        builder.top(rect.top);
        builder.height(rect.height());
        builder.width(rect.width());
        com.google.ads.interactivemedia.v3.impl.data.ay n2 = n(builder.build(), m().density);
        boolean z = (this.c.getGlobalVisibleRect(new Rect()) && this.c.isShown()) ? false : true;
        double streamVolume = ((AudioManager) this.c.getContext().getSystemService("audio")) != null ? r2.getStreamVolume(3) / r2.getStreamMaxVolume(3) : 0.0d;
        long currentTimeMillis = System.currentTimeMillis();
        com.google.ads.interactivemedia.v3.impl.data.a builder2 = com.google.ads.interactivemedia.v3.impl.data.b.builder();
        builder2.queryId(str);
        builder2.eventId(str2);
        builder2.appState(str3);
        builder2.nativeTime(currentTimeMillis);
        builder2.nativeVolume(streamVolume);
        builder2.nativeViewHidden(z);
        builder2.nativeViewBounds(n);
        builder2.nativeViewVisibleBounds(n2);
        return builder2.build();
    }

    public final void f() {
        this.a.d(this, this.b);
    }

    public final void g() {
        this.a.m(this.b);
    }

    public final void h(String str, String str2) {
        this.a.o(new ajr(ajp.activityMonitor, ajq.viewability, this.b, c(str, str2, "")));
    }

    public final void i() {
        Application a;
        if (!this.f || (a = com.google.ads.interactivemedia.v3.impl.data.k.a(this.c.getContext())) == null) {
            return;
        }
        aic aicVar = new aic(this);
        this.d = aicVar;
        a.registerActivityLifecycleCallbacks(aicVar);
    }

    public final void j(boolean z) {
        this.f = z;
    }

    public final void k() {
        aic aicVar;
        Application a = com.google.ads.interactivemedia.v3.impl.data.k.a(this.c.getContext());
        if (a == null || (aicVar = this.d) == null) {
            return;
        }
        a.unregisterActivityLifecycleCallbacks(aicVar);
    }
}
