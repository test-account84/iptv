package com.google.android.gms.common.api.internal;

import android.app.Activity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class i {
    public final Object a;

    public i(Activity activity) {
        com.google.android.gms.common.internal.r.n(activity, "Activity must not be null");
        this.a = activity;
    }

    public final Activity a() {
        return (Activity) this.a;
    }

    public final androidx.fragment.app.e b() {
        return (androidx.fragment.app.e) this.a;
    }

    public final boolean c() {
        return this.a instanceof Activity;
    }

    public final boolean d() {
        return this.a instanceof androidx.fragment.app.e;
    }
}
