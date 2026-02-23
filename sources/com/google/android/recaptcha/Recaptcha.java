package com.google.android.recaptcha;

import G8.L;
import G8.N;
import G8.i;
import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.internal.zzaa;
import com.google.android.recaptcha.internal.zzb;
import com.google.android.recaptcha.internal.zzp;
import com.google.android.recaptcha.internal.zzw;
import k8.k;
import k8.q;
import o8.d;
import o8.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class Recaptcha {

    @NotNull
    public static final Recaptcha INSTANCE = new Recaptcha();

    public static final class 1 extends l implements p {
        int zza;
        final /* synthetic */ Application zzb;
        final /* synthetic */ String zzc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(Application application, String str, d dVar) {
            super(2, dVar);
            this.zzb = application;
            this.zzc = str;
        }

        @NotNull
        public final d create(@Nullable Object obj, @NotNull d dVar) {
            return new 1(this.zzb, this.zzc, dVar);
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return create((L) obj, (d) obj2).invokeSuspend(q.a);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object d = c.d();
            int i = this.zza;
            k.b(obj);
            if (i == 0) {
                zzw zzwVar = zzaa.zza;
                Application application = this.zzb;
                String str = this.zzc;
                this.zza = 1;
                obj = zzw.zzb(zzwVar, application, str, null, null, this, 12, null);
                if (obj == d) {
                    return d;
                }
            }
            return obj;
        }
    }

    private Recaptcha() {
    }

    @NotNull
    public static final Task getTasksClient(Application application, String str) {
        return zzb.zza(i.b(zzp.zzb(), (g) null, (N) null, new 1(application, str, null), 3, (Object) null));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getClient-0E7RQCE(android.app.Application r6, java.lang.String r7, o8.d r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.Recaptcha$getClient$1
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = (com.google.android.recaptcha.Recaptcha$getClient$1) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = new com.google.android.recaptcha.Recaptcha$getClient$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.zza
            java.lang.Object r1 = p8.c.d()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            k8.k.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L4f
        L29:
            r6 = move-exception
            goto L56
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            k8.k.b(r8)
            k8.j$a r8 = k8.j.c     // Catch: java.lang.Throwable -> L29
            G8.L r8 = com.google.android.recaptcha.internal.zzp.zzb()     // Catch: java.lang.Throwable -> L29
            o8.g r8 = r8.t()     // Catch: java.lang.Throwable -> L29
            com.google.android.recaptcha.Recaptcha$getClient$2$1 r2 = new com.google.android.recaptcha.Recaptcha$getClient$2$1     // Catch: java.lang.Throwable -> L29
            r4 = 0
            r2.<init>(r6, r7, r4)     // Catch: java.lang.Throwable -> L29
            r0.zzc = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r8 = G8.i.g(r8, r2, r0)     // Catch: java.lang.Throwable -> L29
            if (r8 != r1) goto L4f
            return r1
        L4f:
            com.google.android.recaptcha.internal.zzaa r8 = (com.google.android.recaptcha.internal.zzaa) r8     // Catch: java.lang.Throwable -> L29
            java.lang.Object r6 = k8.j.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L60
        L56:
            k8.j$a r7 = k8.j.c
            java.lang.Object r6 = k8.k.a(r6)
            java.lang.Object r6 = k8.j.b(r6)
        L60:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.Recaptcha.getClient-0E7RQCE(android.app.Application, java.lang.String, o8.d):java.lang.Object");
    }
}
