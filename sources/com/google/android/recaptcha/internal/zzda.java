package com.google.android.recaptcha.internal;

import G8.L;
import G8.X0;
import G8.w;
import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k8.i;
import k8.m;
import l8.B;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzda {

    @NotNull
    public static final zzct zza = new zzct(null);
    public w zzb;

    @NotNull
    private final WebView zzc;

    @NotNull
    private final String zzd;

    @NotNull
    private final Context zze;

    @NotNull
    private final zzr zzf;

    @NotNull
    private final String zzg;

    @NotNull
    private final String zzh;

    @NotNull
    private final zzaj zzi;

    @NotNull
    private final Map zzj;

    @NotNull
    private final Map zzk;

    @NotNull
    private final Map zzl;

    @NotNull
    private final zzas zzm;

    @NotNull
    private final zzdk zzn;

    @NotNull
    private final kotlinx.coroutines.sync.b zzo;

    @NotNull
    private final zzcu zzp;

    public zzda(@NotNull WebView webView, @NotNull String str, @NotNull Context context, @NotNull zzr zzrVar, @NotNull String str2, @NotNull String str3, @NotNull zzaj zzajVar, @NotNull L l) {
        this.zzc = webView;
        this.zzd = str;
        this.zze = context;
        this.zzf = zzrVar;
        this.zzg = str2;
        this.zzh = str3;
        this.zzi = zzajVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzk = linkedHashMap;
        this.zzl = linkedHashMap;
        this.zzm = new zzba(new zzbc(webView, l), zzp.zzc(), context);
        this.zzn = zzdk.zzc();
        this.zzo = kotlinx.coroutines.sync.d.b(false, 1, (Object) null);
        zzcu zzcuVar = new zzcu(this);
        this.zzp = zzcuVar;
        this.zzj = zzq();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(zzcuVar, "RN");
        webView.setWebViewClient(new zzcs(this));
    }

    public static final /* synthetic */ Context zza(zzda zzdaVar) {
        return zzdaVar.zze;
    }

    public static final /* synthetic */ zzr zzc(zzda zzdaVar) {
        return zzdaVar.zzf;
    }

    public static final /* synthetic */ zzdk zze(zzda zzdaVar) {
        return zzdaVar.zzn;
    }

    public static final /* synthetic */ String zzh(zzda zzdaVar) {
        return zzdaVar.zzg;
    }

    public static final /* synthetic */ String zzi(zzda zzdaVar) {
        return zzdaVar.zzh;
    }

    public static final /* synthetic */ String zzj(zzda zzdaVar) {
        return zzdaVar.zzd;
    }

    public static final /* synthetic */ Map zzk(zzda zzdaVar) {
        return zzdaVar.zzj;
    }

    public static final /* synthetic */ Map zzl(zzda zzdaVar) {
        return zzdaVar.zzk;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.b zzn(zzda zzdaVar) {
        return zzdaVar.zzo;
    }

    private final zzh zzo(Exception exc) {
        return exc instanceof X0 ? new zzh(zzf.zzc, zzd.zzj) : exc instanceof zzh ? (zzh) exc : new zzh(zzf.zzc, zzd.zzu);
    }

    private final void zzp(List list, zzh zzhVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzkw zzkwVar = (zzkw) it.next();
            zzai zzaiVar = zzai.zza;
            String str = this.zzg;
            String str2 = this.zzh;
            zzai.zzd(new zzaf(zzkwVar, str, str2, str2, null), String.valueOf(zzhVar.zzb().zza()), zzhVar.zza().zza(), this.zze, this.zzf, null);
        }
    }

    private static final Map zzq() {
        Map f = B.f(new i[]{m.a(-4, zzd.zzA), m.a(-12, zzd.zzB), m.a(-6, zzd.zzw), m.a(-11, zzd.zzy), m.a(-13, zzd.zzC), m.a(-14, zzd.zzD), m.a(-2, zzd.zzx), m.a(-7, zzd.zzE), m.a(-5, zzd.zzF), m.a(-9, zzd.zzG), m.a(-8, zzd.zzQ), m.a(-15, zzd.zzz), m.a(-1, zzd.zzH), m.a(-3, zzd.zzJ), m.a(-10, zzd.zzK)});
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            f.put(-16, zzd.zzI);
        }
        if (i >= 27) {
            f.put(1, zzd.zzM);
            f.put(2, zzd.zzN);
            f.put(0, zzd.zzO);
            f.put(3, zzd.zzP);
        }
        if (i >= 29) {
            f.put(4, zzd.zzL);
        }
        return f;
    }

    @NotNull
    public final WebView zzb() {
        return this.zzc;
    }

    @NotNull
    public final zzas zzd() {
        return this.zzm;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzf(@org.jetbrains.annotations.NotNull com.google.android.recaptcha.RecaptchaAction r12, @org.jetbrains.annotations.NotNull o8.d r13) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzda.zzf(com.google.android.recaptcha.RecaptchaAction, o8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0014  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzg(@org.jetbrains.annotations.NotNull o8.d r10) {
        /*
            r9 = this;
            r0 = 1
            boolean r1 = r10 instanceof com.google.android.recaptcha.internal.zzcx
            if (r1 == 0) goto L14
            r1 = r10
            com.google.android.recaptcha.internal.zzcx r1 = (com.google.android.recaptcha.internal.zzcx) r1
            int r2 = r1.zzc
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L14
            int r2 = r2 - r3
            r1.zzc = r2
            goto L19
        L14:
            com.google.android.recaptcha.internal.zzcx r1 = new com.google.android.recaptcha.internal.zzcx
            r1.<init>(r9, r10)
        L19:
            java.lang.Object r10 = r1.zza
            java.lang.Object r2 = p8.c.d()
            int r3 = r1.zzc
            if (r3 == 0) goto L35
            if (r3 != r0) goto L2d
            com.google.android.recaptcha.internal.zzda r1 = r1.zzd
            k8.k.b(r10)     // Catch: java.lang.Exception -> L2b
            goto L76
        L2b:
            r10 = move-exception
            goto L80
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L35:
            k8.k.b(r10)
            com.google.android.recaptcha.internal.zzai r10 = com.google.android.recaptcha.internal.zzai.zza
            com.google.android.recaptcha.internal.zzaf r10 = new com.google.android.recaptcha.internal.zzaf
            com.google.android.recaptcha.internal.zzkw r4 = com.google.android.recaptcha.internal.zzkw.INIT_NATIVE
            java.lang.String r5 = r9.zzg
            java.lang.String r7 = r9.zzh
            r8 = 0
            r3 = r10
            r6 = r7
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.String r3 = r9.zzd
            com.google.android.recaptcha.internal.zzs r4 = new com.google.android.recaptcha.internal.zzs
            r4.<init>()
            com.google.android.recaptcha.internal.zzai.zzb(r10, r3, r4)
            r10 = 0
            G8.w r3 = G8.y.b(r10, r0, r10)
            r9.zzb = r3
            G8.w r3 = r9.zzm()
            int r3 = r3.hashCode()
            q8.b.b(r3)
            com.google.android.recaptcha.internal.zzcz r3 = new com.google.android.recaptcha.internal.zzcz     // Catch: java.lang.Exception -> L7e
            r3.<init>(r9, r10)     // Catch: java.lang.Exception -> L7e
            r1.zzd = r9     // Catch: java.lang.Exception -> L7e
            r1.zzc = r0     // Catch: java.lang.Exception -> L7e
            r4 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r10 = G8.Z0.c(r4, r3, r1)     // Catch: java.lang.Exception -> L7e
            if (r10 == r2) goto L7d
            r1 = r9
        L76:
            k8.j r10 = (k8.j) r10     // Catch: java.lang.Exception -> L2b
            java.lang.Object r10 = r10.i()     // Catch: java.lang.Exception -> L2b
            goto Ld3
        L7d:
            return r2
        L7e:
            r10 = move-exception
            r1 = r9
        L80:
            r10.getMessage()
            boolean r2 = r10 instanceof G8.X0
            if (r2 == 0) goto L98
            r3 = 2
            com.google.android.recaptcha.internal.zzkw[] r3 = new com.google.android.recaptcha.internal.zzkw[r3]
            com.google.android.recaptcha.internal.zzkw r4 = com.google.android.recaptcha.internal.zzkw.INIT_TOTAL
            r5 = 0
            r3[r5] = r4
            com.google.android.recaptcha.internal.zzkw r4 = com.google.android.recaptcha.internal.zzkw.INIT_NETWORK
            r3[r0] = r4
            java.util.List r0 = l8.k.h(r3)
            goto L9e
        L98:
            com.google.android.recaptcha.internal.zzkw r0 = com.google.android.recaptcha.internal.zzkw.INIT_TOTAL
            java.util.List r0 = l8.j.b(r0)
        L9e:
            com.google.android.recaptcha.internal.zzcu r3 = r1.zzp
            java.lang.Long r3 = r3.zza()
            if (r2 != 0) goto La7
            goto Lbe
        La7:
            if (r3 != 0) goto Laa
            goto Lb4
        Laa:
            long r2 = r3.longValue()
            r4 = 8000(0x1f40, double:3.9525E-320)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto Lbe
        Lb4:
            com.google.android.recaptcha.internal.zzh r10 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r2 = com.google.android.recaptcha.internal.zzf.zze
            com.google.android.recaptcha.internal.zzd r3 = com.google.android.recaptcha.internal.zzd.zzT
            r10.<init>(r2, r3)
            goto Lc2
        Lbe:
            com.google.android.recaptcha.internal.zzh r10 = r1.zzo(r10)
        Lc2:
            r1.zzp(r0, r10)
            k8.j$a r0 = k8.j.c
            com.google.android.recaptcha.RecaptchaException r10 = r10.zzc()
            java.lang.Object r10 = k8.k.a(r10)
            java.lang.Object r10 = k8.j.b(r10)
        Ld3:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzda.zzg(o8.d):java.lang.Object");
    }

    @NotNull
    public final w zzm() {
        w wVar = this.zzb;
        if (wVar != null) {
            return wVar;
        }
        return null;
    }
}
