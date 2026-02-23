package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class alk implements ayr {
    final /* synthetic */ TaskCompletionSource a;
    final /* synthetic */ String b;

    public alk(TaskCompletionSource taskCompletionSource, String str) {
        this.a = taskCompletionSource;
        this.b = str;
    }

    public final void a(Throwable th) {
        this.a.setException(new Exception("Failed to load image from: ".concat(String.valueOf(this.b)), th));
    }

    public final /* bridge */ /* synthetic */ void b(Object obj) {
        this.a.trySetResult((Bitmap) obj);
    }
}
