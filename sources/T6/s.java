package t6;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.Map;
import u6.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s {
    public static final s a = new s();
    public static final c6.a b;

    static {
        c6.a h = new e6.d().i(c.a).j(true).h();
        kotlin.jvm.internal.l.d(h, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        b = h;
    }

    public final b a(A5.f fVar) {
        kotlin.jvm.internal.l.e(fVar, "firebaseApp");
        Context l = fVar.l();
        kotlin.jvm.internal.l.d(l, "firebaseApp.applicationContext");
        String packageName = l.getPackageName();
        PackageInfo packageInfo = l.getPackageManager().getPackageInfo(packageName, 0);
        String valueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(com.google.android.recaptcha.internal.e.a(packageInfo)) : String.valueOf(packageInfo.versionCode);
        String c = fVar.p().c();
        kotlin.jvm.internal.l.d(c, "firebaseApp.options.applicationId");
        String str = Build.MODEL;
        kotlin.jvm.internal.l.d(str, "MODEL");
        String str2 = Build.VERSION.RELEASE;
        kotlin.jvm.internal.l.d(str2, "RELEASE");
        n nVar = n.LOG_ENVIRONMENT_PROD;
        kotlin.jvm.internal.l.d(packageName, "packageName");
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = valueOf;
        }
        String str4 = Build.MANUFACTURER;
        kotlin.jvm.internal.l.d(str4, "MANUFACTURER");
        return new b(c, str, "1.0.2", str2, nVar, new a(packageName, str3, valueOf, str4));
    }

    public final c6.a b() {
        return b;
    }

    public final r c(A5.f fVar, q qVar, v6.f fVar2, Map map) {
        kotlin.jvm.internal.l.e(fVar, "firebaseApp");
        kotlin.jvm.internal.l.e(qVar, "sessionDetails");
        kotlin.jvm.internal.l.e(fVar2, "sessionsSettings");
        kotlin.jvm.internal.l.e(map, "subscribers");
        return new r(j.SESSION_START, new u(qVar.b(), qVar.a(), qVar.c(), qVar.d(), new f(d((u6.b) map.get(b.a.PERFORMANCE)), d((u6.b) map.get(b.a.CRASHLYTICS)), fVar2.b()), null, 32, null), a(fVar));
    }

    public final d d(u6.b bVar) {
        return bVar == null ? d.COLLECTION_SDK_NOT_INSTALLED : bVar.b() ? d.COLLECTION_ENABLED : d.COLLECTION_DISABLED;
    }
}
