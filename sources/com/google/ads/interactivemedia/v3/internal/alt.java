package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsAdapter;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class alt {
    private final SecureSignalsAdapter a;
    private final Context b;
    private final String c;
    private final TaskCompletionSource d = new TaskCompletionSource();

    public alt(SecureSignalsAdapter secureSignalsAdapter, String str, Context context) {
        this.a = secureSignalsAdapter;
        this.c = str;
        this.b = context;
    }

    public static /* bridge */ /* synthetic */ SecureSignalsAdapter a(alt altVar) {
        return altVar.a;
    }

    public static /* bridge */ /* synthetic */ TaskCompletionSource d(alt altVar) {
        return altVar.d;
    }

    public final Task b() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.a.collectSignals(this.b, new als(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task c() {
        this.a.initialize(this.b, new alr(this));
        return this.d.getTask();
    }

    public final String e() {
        return this.c;
    }

    public final String f() {
        return this.a.getVersion().toString();
    }
}
