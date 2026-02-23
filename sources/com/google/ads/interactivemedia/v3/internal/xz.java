package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class xz implements DisplayManager.DisplayListener, xx {
    private final DisplayManager a;
    private xv b;

    private xz(DisplayManager displayManager) {
        this.a = displayManager;
    }

    public static xx c(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager != null) {
            return new xz(displayManager);
        }
        return null;
    }

    private final Display d() {
        return this.a.getDisplay(0);
    }

    public final void a() {
        this.a.unregisterDisplayListener(this);
        this.b = null;
    }

    public final void b(xv xvVar) {
        this.b = xvVar;
        this.a.registerDisplayListener(this, cq.A());
        xvVar.a(d());
    }

    public final void onDisplayAdded(int i) {
    }

    public final void onDisplayChanged(int i) {
        xv xvVar = this.b;
        if (xvVar == null || i != 0) {
            return;
        }
        xvVar.a(d());
    }

    public final void onDisplayRemoved(int i) {
    }
}
