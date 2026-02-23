package M4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s3 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ t3 a;

    public s3(t3 t3Var) {
        this.a = t3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityCreated(android.app.Activity r9, android.os.Bundle r10) {
        /*
            r8 = this;
            M4.t3 r0 = r8.a     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.l2 r0 = r0.a     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.z1 r0 = r0.d()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.x1 r0 = r0.v()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            java.lang.String r1 = "onActivityCreated"
            r0.a(r1)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            android.content.Intent r0 = r9.getIntent()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r0 != 0) goto L23
        L17:
            M4.t3 r0 = r8.a
            M4.l2 r0 = r0.a
            M4.I3 r0 = r0.K()
            r0.y(r9, r10)
            return
        L23:
            com.google.android.gms.internal.measurement.zzpb.zzc()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.t3 r1 = r8.a     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.l2 r1 = r1.a     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.h r1 = r1.z()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.l1 r2 = M4.m1.H0     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            r3 = 0
            boolean r1 = r1.B(r3, r2)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r1 != 0) goto L43
            android.net.Uri r3 = r0.getData()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
        L3b:
            r4 = r3
            goto L69
        L3d:
            r0 = move-exception
            goto Ld3
        L40:
            r0 = move-exception
            goto Lc0
        L43:
            android.net.Uri r1 = r0.getData()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r1 == 0) goto L52
            boolean r2 = r1.isHierarchical()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r2 != 0) goto L50
            goto L52
        L50:
            r4 = r1
            goto L69
        L52:
            android.os.Bundle r1 = r0.getExtras()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r1 == 0) goto L3b
            java.lang.String r2 = "com.android.vending.referral_url"
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r2 != 0) goto L3b
            android.net.Uri r3 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            goto L3b
        L69:
            if (r4 == 0) goto L17
            boolean r1 = r4.isHierarchical()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r1 != 0) goto L72
            goto L17
        L72:
            M4.t3 r1 = r8.a     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.l2 r1 = r1.a     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            r1.N()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            java.lang.String r1 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            java.lang.String r1 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r1 = r1.equals(r0)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r1 != 0) goto L9c
            java.lang.String r1 = "https://www.google.com"
            boolean r1 = r1.equals(r0)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r1 != 0) goto L9c
            java.lang.String r1 = "android-app://com.google.appcrawler"
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r0 == 0) goto L98
            goto L9c
        L98:
            java.lang.String r0 = "auto"
        L9a:
            r5 = r0
            goto L9f
        L9c:
            java.lang.String r0 = "gs"
            goto L9a
        L9f:
            java.lang.String r0 = "referrer"
            java.lang.String r6 = r4.getQueryParameter(r0)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            if (r10 != 0) goto Laa
            r0 = 1
            r3 = 1
            goto Lac
        Laa:
            r0 = 0
            r3 = 0
        Lac:
            M4.t3 r0 = r8.a     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.l2 r0 = r0.a     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.i2 r0 = r0.f()     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            M4.r3 r7 = new M4.r3     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            r0.z(r7)     // Catch: java.lang.Throwable -> L3d java.lang.RuntimeException -> L40
            goto L17
        Lc0:
            M4.t3 r1 = r8.a     // Catch: java.lang.Throwable -> L3d
            M4.l2 r1 = r1.a     // Catch: java.lang.Throwable -> L3d
            M4.z1 r1 = r1.d()     // Catch: java.lang.Throwable -> L3d
            M4.x1 r1 = r1.r()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r2 = "Throwable caught in onActivityCreated"
            r1.b(r2, r0)     // Catch: java.lang.Throwable -> L3d
            goto L17
        Ld3:
            M4.t3 r1 = r8.a
            M4.l2 r1 = r1.a
            M4.I3 r1 = r1.K()
            r1.y(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.s3.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.a.a.K().z(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.a.a.K().A(activity);
        z4 M = this.a.a.M();
        M.a.f().z(new s4(M, M.a.a().b()));
    }

    public final void onActivityResumed(Activity activity) {
        z4 M = this.a.a.M();
        M.a.f().z(new r4(M, M.a.a().b()));
        this.a.a.K().B(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.a.a.K().C(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
