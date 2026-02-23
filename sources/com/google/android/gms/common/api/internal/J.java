package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface j {
    void f(String str, LifecycleCallback lifecycleCallback);

    LifecycleCallback g(String str, Class cls);

    Activity h();

    void startActivityForResult(Intent intent, int i);
}
