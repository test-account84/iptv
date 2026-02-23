package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.HashSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asv {
    private static final Object a = new Object();
    private final Context b;
    private final SharedPreferences c;
    private final String d;
    private final ash e;
    private boolean f;

    public asv(Context context, int i, ash ashVar, boolean z) {
        this.f = false;
        this.b = context;
        this.d = Integer.toString(apl.b(i));
        this.c = context.getSharedPreferences("pcvmspf", 0);
        this.e = ashVar;
        this.f = z;
    }

    private final File e(String str) {
        return new File(new File(this.b.getDir("pccache", 0), this.d), str);
    }

    private static String f(apm apmVar) {
        apn d = apo.d();
        d.e(apmVar.c().k());
        d.a(apmVar.c().j());
        d.b(apmVar.c().a());
        d.d(apmVar.c().c());
        d.c(apmVar.c().b());
        return C4.j.a(((apo) d.aY()).av());
    }

    private final String g() {
        return "FBAMTD".concat(String.valueOf(this.d));
    }

    private final String h() {
        return "LATMTD".concat(String.valueOf(this.d));
    }

    private final void i(int i, long j) {
        ash ashVar = this.e;
        if (ashVar != null) {
            ashVar.a(i, j);
        }
    }

    private final void j(int i, long j, String str) {
        ash ashVar = this.e;
        if (ashVar != null) {
            ashVar.b(i, j, str);
        }
    }

    private final apo k(int i) {
        SharedPreferences sharedPreferences;
        String g;
        int i2;
        if (i == 1) {
            sharedPreferences = this.c;
            g = h();
        } else {
            sharedPreferences = this.c;
            g = g();
        }
        String string = sharedPreferences.getString(g, (String) null);
        if (string == null) {
            return null;
        }
        try {
            return apo.h(bpb.t(C4.j.d(string)), this.f ? bqb.a() : bqb.b());
        } catch (bqw unused) {
            return null;
        } catch (NullPointerException unused2) {
            i2 = 2029;
            i(i2, System.currentTimeMillis());
            return null;
        } catch (RuntimeException unused3) {
            i2 = 2032;
            i(i2, System.currentTimeMillis());
            return null;
        }
    }

    public final boolean a(apm apmVar) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (a) {
            try {
                if (!com.google.ads.interactivemedia.v3.impl.data.av.d(new File(e(apmVar.c().k()), "pcbc"), apmVar.d().B())) {
                    i(4020, currentTimeMillis);
                    return false;
                }
                String f = f(apmVar);
                SharedPreferences.Editor edit = this.c.edit();
                edit.putString(h(), f);
                boolean commit = edit.commit();
                if (commit) {
                    i(5015, currentTimeMillis);
                } else {
                    i(4021, currentTimeMillis);
                }
                return commit;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b(apm apmVar, asu asuVar) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (a) {
            try {
                apo k = k(1);
                String k2 = apmVar.c().k();
                if (k != null && k.k().equals(k2)) {
                    i(4014, currentTimeMillis);
                    return false;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                File e = e(k2);
                if (e.exists()) {
                    j(4023, currentTimeMillis2, "d:" + (true != e.isDirectory() ? "0" : "1") + ",f:" + (true != e.isFile() ? "0" : "1"));
                    i(4015, currentTimeMillis2);
                } else if (!e.mkdirs()) {
                    j(4024, currentTimeMillis2, "cw:".concat(true != e.canWrite() ? "0" : "1"));
                    i(4015, currentTimeMillis2);
                    return false;
                }
                File e2 = e(k2);
                File file = new File(e2, "pcam.jar");
                File file2 = new File(e2, "pcbc");
                if (!com.google.ads.interactivemedia.v3.impl.data.av.d(file, apmVar.e().B())) {
                    i(4016, currentTimeMillis);
                    return false;
                }
                if (!com.google.ads.interactivemedia.v3.impl.data.av.d(file2, apmVar.d().B())) {
                    i(4017, currentTimeMillis);
                    return false;
                }
                if (!asuVar.a(file)) {
                    i(4018, currentTimeMillis);
                    com.google.ads.interactivemedia.v3.impl.data.av.c(e2);
                    return false;
                }
                String f = f(apmVar);
                long currentTimeMillis3 = System.currentTimeMillis();
                String string = this.c.getString(h(), (String) null);
                SharedPreferences.Editor edit = this.c.edit();
                edit.putString(h(), f);
                if (string != null) {
                    edit.putString(g(), string);
                }
                if (!edit.commit()) {
                    i(4019, currentTimeMillis3);
                    return false;
                }
                HashSet hashSet = new HashSet();
                apo k3 = k(1);
                if (k3 != null) {
                    hashSet.add(k3.k());
                }
                apo k4 = k(2);
                if (k4 != null) {
                    hashSet.add(k4.k());
                }
                for (File file3 : new File(this.b.getDir("pccache", 0), this.d).listFiles()) {
                    if (!hashSet.contains(file3.getName())) {
                        com.google.ads.interactivemedia.v3.impl.data.av.c(file3);
                    }
                }
                i(5014, currentTimeMillis);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final asq c(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (a) {
            try {
                apo k = k(1);
                if (k == null) {
                    i(4022, currentTimeMillis);
                    return null;
                }
                File e = e(k.k());
                File file = new File(e, "pcam.jar");
                if (!file.exists()) {
                    file = new File(e, "pcam");
                }
                File file2 = new File(e, "pcbc");
                File file3 = new File(e, "pcopt");
                i(5016, currentTimeMillis);
                return new asq(k, file, file2, file3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (a) {
            try {
                apo k = k(1);
                if (k == null) {
                    i(4025, currentTimeMillis);
                    return false;
                }
                File e = e(k.k());
                if (!new File(e, "pcam.jar").exists()) {
                    i(4026, currentTimeMillis);
                    return false;
                }
                if (new File(e, "pcbc").exists()) {
                    i(5019, currentTimeMillis);
                    return true;
                }
                i(4027, currentTimeMillis);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
