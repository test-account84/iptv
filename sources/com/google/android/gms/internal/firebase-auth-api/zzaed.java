package com.google.android.gms.internal.firebase-auth-api;

import A5.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaed {
    private static final Map zza = new s.a();
    private static final Map zzb = new s.a();

    public static String zza(String str) {
        zzaec zzaecVar;
        Map map = zza;
        synchronized (map) {
            zzaecVar = (zzaec) map.get(str);
        }
        if (zzaecVar == null) {
            throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
        }
        return zza(zzaecVar.zzb(), zzaecVar.zza(), zzaecVar.zzb().contains(":")) + "emulator/auth/handler";
    }

    public static String zzb(String str) {
        zzaec zzaecVar;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzaecVar = (zzaec) map.get(str);
        }
        if (zzaecVar != null) {
            str2 = "" + zza(zzaecVar.zzb(), zzaecVar.zza(), zzaecVar.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "www.googleapis.com/identitytoolkit/v3/relyingparty";
    }

    public static String zzc(String str) {
        zzaec zzaecVar;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzaecVar = (zzaec) map.get(str);
        }
        if (zzaecVar != null) {
            str2 = "" + zza(zzaecVar.zzb(), zzaecVar.zza(), zzaecVar.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "identitytoolkit.googleapis.com/v2";
    }

    public static String zzd(String str) {
        zzaec zzaecVar;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzaecVar = (zzaec) map.get(str);
        }
        if (zzaecVar != null) {
            str2 = "" + zza(zzaecVar.zzb(), zzaecVar.zza(), zzaecVar.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "securetoken.googleapis.com/v1";
    }

    private static String zza(String str, int i, boolean z) {
        StringBuilder sb;
        String str2;
        if (z) {
            sb = new StringBuilder("http://[");
            sb.append(str);
            str2 = "]:";
        } else {
            sb = new StringBuilder("http://");
            sb.append(str);
            str2 = ":";
        }
        sb.append(str2);
        sb.append(i);
        sb.append("/");
        return sb.toString();
    }

    public static void zza(f fVar, String str, int i) {
        String b = fVar.p().b();
        Map map = zza;
        synchronized (map) {
            map.put(b, new zzaec(str, i));
        }
        Map map2 = zzb;
        synchronized (map2) {
            try {
                if (map2.containsKey(b)) {
                    Iterator it = ((List) map2.get(b)).iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        zzaef zzaefVar = (zzaef) ((WeakReference) it.next()).get();
                        if (zzaefVar != null) {
                            zzaefVar.zza();
                            z = true;
                        }
                    }
                    if (!z) {
                        zza.remove(b);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zza(String str, zzaef zzaefVar) {
        Map map = zzb;
        synchronized (map) {
            try {
                if (map.containsKey(str)) {
                    ((List) map.get(str)).add(new WeakReference(zzaefVar));
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new WeakReference(zzaefVar));
                    map.put(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean zza(f fVar) {
        return zza.containsKey(fVar.p().b());
    }
}
