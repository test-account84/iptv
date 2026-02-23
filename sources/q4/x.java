package q4;

import android.os.RemoteException;
import java.util.List;
import p4.X;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class x {
    public static final t4.b a = new t4.b("MediaSessionUtils");

    public static int a(p4.h hVar, long j) {
        return j == 10000 ? hVar.L() : j != 30000 ? hVar.N() : hVar.M();
    }

    public static int b(p4.h hVar, long j) {
        return j == 10000 ? hVar.b0() : j != 30000 ? hVar.d0() : hVar.c0();
    }

    public static int c(p4.h hVar, long j) {
        return j == 10000 ? hVar.Q() : j != 30000 ? hVar.S() : hVar.R();
    }

    public static int d(p4.h hVar, long j) {
        return j == 10000 ? hVar.h0() : j != 30000 ? hVar.j0() : hVar.i0();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002c A[PHI: r1
      0x002c: PHI (r1v5 java.lang.String) = (r1v3 java.lang.String), (r1v4 java.lang.String) binds: [B:15:0x002a, B:18:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e(n4.m r4) {
        /*
            java.lang.String r0 = "com.google.android.gms.cast.metadata.SUBTITLE"
            boolean r1 = r4.e(r0)
            if (r1 != 0) goto L3c
            int r1 = r4.I()
            r2 = 1
            if (r1 == r2) goto L3a
            r2 = 2
            if (r1 == r2) goto L37
            r2 = 3
            java.lang.String r3 = "com.google.android.gms.cast.metadata.ARTIST"
            if (r1 == r2) goto L1d
            r2 = 4
            if (r1 == r2) goto L1b
            goto L3c
        L1b:
            r0 = r3
            goto L3c
        L1d:
            boolean r1 = r4.e(r3)
            if (r1 == 0) goto L24
            goto L1b
        L24:
            java.lang.String r1 = "com.google.android.gms.cast.metadata.ALBUM_ARTIST"
            boolean r2 = r4.e(r1)
            if (r2 == 0) goto L2e
        L2c:
            r0 = r1
            goto L3c
        L2e:
            java.lang.String r1 = "com.google.android.gms.cast.metadata.COMPOSER"
            boolean r2 = r4.e(r1)
            if (r2 == 0) goto L3c
            goto L2c
        L37:
            java.lang.String r0 = "com.google.android.gms.cast.metadata.SERIES_TITLE"
            goto L3c
        L3a:
            java.lang.String r0 = "com.google.android.gms.cast.metadata.STUDIO"
        L3c:
            java.lang.String r4 = r4.J(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.x.e(n4.m):java.lang.String");
    }

    public static List f(X x) {
        try {
            return x.zzf();
        } catch (RemoteException e) {
            a.d(e, "Unable to call %s on %s.", "getNotificationActions", X.class.getSimpleName());
            return null;
        }
    }

    public static int[] g(X x) {
        try {
            return x.zzg();
        } catch (RemoteException e) {
            a.d(e, "Unable to call %s on %s.", "getCompactViewActionIndices", X.class.getSimpleName());
            return null;
        }
    }
}
