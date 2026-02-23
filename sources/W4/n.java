package w4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class n {
    public static n c;
    public final Context a;
    public volatile String b;

    public n(Context context) {
        this.a = context.getApplicationContext();
    }

    public static n a(Context context) {
        com.google.android.gms.common.internal.r.m(context);
        synchronized (n.class) {
            try {
                if (c == null) {
                    E.d(context);
                    c = new n(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c;
    }

    public static final A d(PackageInfo packageInfo, A... aArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            B b = new B(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < aArr.length; i++) {
                if (aArr[i].equals(b)) {
                    return aArr[i];
                }
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (!z) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            A[] aArr = D.a;
            if ((z ? d(packageInfo2, aArr) : d(packageInfo2, aArr[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (m.g(this.a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i) {
        O c2;
        int length;
        String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            c2 = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    com.google.android.gms.common.internal.r.m(c2);
                    break;
                }
                c2 = f(packagesForUid[i2], false, false);
                if (c2.a) {
                    break;
                }
                i2++;
            }
        } else {
            c2 = O.c("no pkgs");
        }
        c2.e();
        return c2.a;
    }

    public final O f(String str, boolean z, boolean z2) {
        O o;
        ApplicationInfo applicationInfo;
        String str2 = "null pkg";
        if (str == null) {
            return O.c("null pkg");
        }
        if (str.equals(this.b)) {
            return O.b();
        }
        if (E.e()) {
            o = E.b(str, m.g(this.a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(str, 64);
                boolean g = m.g(this.a);
                if (packageInfo != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        str2 = "single cert required";
                    } else {
                        B b = new B(packageInfo.signatures[0].toByteArray());
                        String str3 = packageInfo.packageName;
                        O a = E.a(str3, b, g, false);
                        if (!a.a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !E.a(str3, b, false, true).a) {
                            o = a;
                        } else {
                            str2 = "debuggable release cert app rejected";
                        }
                    }
                    o = O.c(str2);
                } else {
                    o = O.c(str2);
                }
            } catch (PackageManager.NameNotFoundException e) {
                return O.d("no pkg ".concat(str), e);
            }
        }
        if (o.a) {
            this.b = str;
        }
        return o;
    }
}
