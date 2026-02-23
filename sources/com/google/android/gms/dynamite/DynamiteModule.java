package com.google.android.gms.dynamite;

import G4.j;
import G4.k;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class DynamiteModule {
    public static Boolean h = null;
    public static String i = null;
    public static boolean j = false;
    public static int k = -1;
    public static Boolean l;
    public static j q;
    public static k r;
    public final Context a;
    public static final ThreadLocal m = new ThreadLocal();
    public static final ThreadLocal n = new G4.f();
    public static final b.a o = new com.google.android.gms.dynamite.a();
    public static final b b = new com.google.android.gms.dynamite.b();
    public static final b c = new c();
    public static final b d = new d();
    public static final b e = new e();
    public static final b f = new f();
    public static final b g = new g();
    public static final b p = new h();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class a extends Exception {
        public /* synthetic */ a(String str, G4.i iVar) {
            super(str);
        }

        public /* synthetic */ a(String str, Throwable th, G4.i iVar) {
            super(str, th);
        }
    }

    public interface b {

        public interface a {
            int a(Context context, String str, boolean z);

            int b(Context context, String str);
        }

        public static class b {
            public int a = 0;
            public int b = 0;
            public int c = 0;
        }

        b a(Context context, String str, a aVar);
    }

    public DynamiteModule(Context context) {
        r.m(context);
        this.a = context;
    }

    public static int a(Context context, String str) {
        try {
            Class loadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (q.b(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get((Object) null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    public static int c(Context context, String str) {
        return f(context, str, false);
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0226: MOVE (r6 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:168:0x0226 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x027b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.dynamite.DynamiteModule e(android.content.Context r18, com.google.android.gms.dynamite.DynamiteModule.b r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 772
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$b, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x00ad A[Catch: all -> 0x0036, TryCatch #12 {, blocks: (B:76:0x0026, B:78:0x0032, B:79:0x00b6, B:117:0x003b, B:83:0x0042, B:85:0x0048, B:88:0x004e, B:90:0x0052, B:94:0x005c, B:96:0x0064, B:99:0x006b, B:102:0x0097, B:103:0x009f, B:107:0x0072, B:109:0x0078, B:110:0x0089, B:111:0x00a2, B:114:0x00a5, B:115:0x00ad, B:118:0x003e), top: B:75:0x0026, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0175 A[Catch: all -> 0x00e9, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00e9, blocks: (B:3:0x0002, B:9:0x00de, B:66:0x00e4, B:11:0x0108, B:42:0x0167, B:32:0x0175, B:53:0x01c7, B:54:0x01ca, B:49:0x01bf, B:70:0x00ed, B:129:0x01cc, B:5:0x0003, B:73:0x0009, B:74:0x0025, B:81:0x00db, B:86:0x0049, B:104:0x00a0, B:112:0x00a3, B:123:0x00b9, B:8:0x00dd, B:126:0x00bf), top: B:2:0x0002, inners: #1, #9 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01bd -> B:24:0x01c2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01bf -> B:24:0x01c2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int f(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.f(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int g(android.content.Context r8, java.lang.String r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.g(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static DynamiteModule h(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    public static void i(ClassLoader classLoader) {
        k kVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor((Class[]) null).newInstance((Object[]) null);
            if (iBinder == null) {
                kVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                kVar = queryLocalInterface instanceof k ? (k) queryLocalInterface : new k(iBinder);
            }
            r = kVar;
        } catch (NoSuchMethodException e2) {
            e = e2;
            throw new a("Failed to instantiate dynamite loader", e, null);
        } catch (ClassNotFoundException e3) {
            e = e3;
            throw new a("Failed to instantiate dynamite loader", e, null);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new a("Failed to instantiate dynamite loader", e, null);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new a("Failed to instantiate dynamite loader", e, null);
        } catch (InstantiationException e6) {
            e = e6;
            throw new a("Failed to instantiate dynamite loader", e, null);
        }
    }

    public static boolean j(Cursor cursor) {
        G4.h hVar = (G4.h) m.get();
        if (hVar == null || hVar.a != null) {
            return false;
        }
        hVar.a = cursor;
        return true;
    }

    public static boolean k(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals((Object) null) || bool.equals(l)) {
            return true;
        }
        boolean z = false;
        if (l == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (w4.i.h().j(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            l = Boolean.valueOf(z);
            if (z && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                j = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    public static j l(Context context) {
        j jVar;
        synchronized (DynamiteModule.class) {
            j jVar2 = q;
            if (jVar2 != null) {
                return jVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    jVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    jVar = queryLocalInterface instanceof j ? (j) queryLocalInterface : new j(iBinder);
                }
                if (jVar != null) {
                    q = jVar;
                    return jVar;
                }
            } catch (Exception e2) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e2.getMessage());
            }
            return null;
        }
    }

    public Context b() {
        return this.a;
    }

    public IBinder d(String str) {
        try {
            return (IBinder) this.a.getClassLoader().loadClass(str).newInstance();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e2) {
            throw new a("Failed to instantiate module class: ".concat(String.valueOf(str)), e2, null);
        }
    }
}
