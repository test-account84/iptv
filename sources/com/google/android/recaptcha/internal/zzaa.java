package com.google.android.recaptcha.internal;

import G8.N;
import G8.i;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaClient;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.UUID;
import o8.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaa implements RecaptchaClient, RecaptchaTasksClient {

    @Nullable
    private static zzaa zzb;
    private static String zzd;

    @NotNull
    private final zzda zzf;

    @NotNull
    public static final zzw zza = new zzw(null);

    @NotNull
    private static final String zzc = UUID.randomUUID().toString();

    @NotNull
    private static final kotlinx.coroutines.sync.b zze = kotlinx.coroutines.sync.d.b(false, 1, (Object) null);

    public zzaa(@NotNull zzda zzdaVar) {
        this.zzf = zzdaVar;
    }

    public static final /* synthetic */ zzaa zza() {
        return zzb;
    }

    public static final /* synthetic */ String zzc() {
        return zzc;
    }

    public static final /* synthetic */ String zzd() {
        return zzd;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.b zze() {
        return zze;
    }

    public static final /* synthetic */ void zzf(zzaa zzaaVar) {
        zzb = zzaaVar;
    }

    public static final /* synthetic */ void zzg(String str) {
        zzd = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object execute-gIAlu-s(@org.jetbrains.annotations.NotNull com.google.android.recaptcha.RecaptchaAction r6, @org.jetbrains.annotations.NotNull o8.d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzx
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzx r0 = (com.google.android.recaptcha.internal.zzx) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzx r0 = new com.google.android.recaptcha.internal.zzx
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = p8.c.d()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            k8.k.b(r7)
            goto L4b
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            k8.k.b(r7)
            G8.L r7 = com.google.android.recaptcha.internal.zzp.zzb()
            o8.g r7 = r7.t()
            com.google.android.recaptcha.internal.zzy r2 = new com.google.android.recaptcha.internal.zzy
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.zzc = r3
            java.lang.Object r7 = G8.i.g(r7, r2, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            k8.j r7 = (k8.j) r7
            java.lang.Object r6 = r7.i()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaa.execute-gIAlu-s(com.google.android.recaptcha.RecaptchaAction, o8.d):java.lang.Object");
    }

    @NotNull
    public final Task executeTask(@NotNull RecaptchaAction recaptchaAction) {
        return zzb.zza(i.b(zzp.zzb(), (g) null, (N) null, new zzz(this, recaptchaAction, null), 3, (Object) null));
    }

    @NotNull
    public final zzda zzb() {
        return this.zzf;
    }
}
