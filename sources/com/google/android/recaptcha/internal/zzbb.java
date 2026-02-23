package com.google.android.recaptcha.internal;

import G8.L;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import k8.k;
import k8.q;
import l8.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbb extends l implements p {
    final /* synthetic */ String[] zza;
    final /* synthetic */ zzbc zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbb(String[] strArr, zzbc zzbcVar, String str, o8.d dVar) {
        super(2, dVar);
        this.zza = strArr;
        this.zzb = zzbcVar;
        this.zzc = str;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        return new zzbb(this.zza, this.zzb, this.zzc, dVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (o8.d) obj2).invokeSuspend(q.a);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        p8.c.d();
        k.b(obj);
        String[] strArr = this.zza;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("\"" + str + "\"");
        }
        zzbc.zza(this.zzb).evaluateJavascript(this.zzc + "(" + s.A(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (w8.l) null, 62, (Object) null) + ")", (ValueCallback) null);
        return q.a;
    }
}
