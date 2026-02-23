package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class aln implements OnSuccessListener {
    public final /* synthetic */ TaskCompletionSource a;

    public /* synthetic */ aln(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    public final void onSuccess(Object obj) {
        this.a.setResult((Map) obj);
    }
}
