package M4;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c2 extends E4 implements g {
    public final Map d;
    public final Map e;
    public final Map f;
    public final Map g;
    public final Map h;
    public final Map i;
    public final s.g j;
    public final zzr k;
    public final Map l;
    public final Map m;
    public final Map n;

    public c2(S4 s4) {
        super(s4);
        this.d = new s.a();
        this.e = new s.a();
        this.f = new s.a();
        this.g = new s.a();
        this.h = new s.a();
        this.l = new s.a();
        this.m = new s.a();
        this.n = new s.a();
        this.i = new s.a();
        this.j = new Z1(this, 20);
        this.k = new a2(this);
    }

    public static final Map q(zzff zzffVar) {
        s.a aVar = new s.a();
        if (zzffVar != null) {
            for (zzfj zzfjVar : zzffVar.zzp()) {
                aVar.put(zzfjVar.zzb(), zzfjVar.zzc());
            }
        }
        return aVar;
    }

    public static /* bridge */ /* synthetic */ zzc s(c2 c2Var, String str) {
        c2Var.i();
        com.google.android.gms.common.internal.r.g(str);
        if (!c2Var.C(str)) {
            return null;
        }
        if (!c2Var.h.containsKey(str) || c2Var.h.get(str) == null) {
            c2Var.o(str);
        } else {
            c2Var.p(str, (zzff) c2Var.h.get(str));
        }
        return (zzc) c2Var.j.snapshot().get(str);
    }

    public static /* bridge */ /* synthetic */ Map x(c2 c2Var) {
        return c2Var.d;
    }

    public final void A(String str) {
        h();
        this.h.remove(str);
    }

    public final boolean B(String str) {
        h();
        zzff t = t(str);
        if (t == null) {
            return false;
        }
        return t.zzs();
    }

    public final boolean C(String str) {
        zzff zzffVar;
        return (TextUtils.isEmpty(str) || (zzffVar = (zzff) this.h.get(str)) == null || zzffVar.zza() == 0) ? false : true;
    }

    public final boolean D(String str) {
        return "1".equals(e(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean E(String str, String str2) {
        Boolean bool;
        h();
        o(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean F(String str, String str2) {
        Boolean bool;
        h();
        o(str);
        if (D(str) && a5.Y(str2)) {
            return true;
        }
        if (G(str) && a5.Z(str2)) {
            return true;
        }
        Map map = (Map) this.f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean G(String str) {
        return "1".equals(e(str, "measurement.upload.blacklist_public"));
    }

    public final boolean H(String str, byte[] bArr, String str2, String str3) {
        i();
        h();
        com.google.android.gms.common.internal.r.g(str);
        zzfe zzfeVar = (zzfe) m(str, bArr).zzbB();
        n(str, zzfeVar);
        p(str, (zzff) zzfeVar.zzaD());
        this.h.put(str, (zzff) zzfeVar.zzaD());
        this.l.put(str, zzfeVar.zze());
        this.m.put(str, str2);
        this.n.put(str, str3);
        this.d.put(str, q((zzff) zzfeVar.zzaD()));
        this.b.V().n(str, new ArrayList(zzfeVar.zzf()));
        try {
            zzfeVar.zzc();
            bArr = ((zzff) zzfeVar.zzaD()).zzbx();
        } catch (RuntimeException e) {
            this.a.d().w().c("Unable to serialize reduced-size config. Storing full config instead. appId", z1.z(str), e);
        }
        l V = this.b.V();
        com.google.android.gms.common.internal.r.g(str);
        V.h();
        V.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (V.P().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                V.a.d().r().b("Failed to update remote config (got 0). appId", z1.z(str));
            }
        } catch (SQLiteException e2) {
            V.a.d().r().c("Error storing remote config. appId", z1.z(str), e2);
        }
        this.h.put(str, (zzff) zzfeVar.zzaD());
        return true;
    }

    public final boolean I(String str) {
        h();
        o(str);
        return this.e.get(str) != null && ((Set) this.e.get(str)).contains("app_instance_id");
    }

    public final boolean J(String str) {
        h();
        o(str);
        if (this.e.get(str) != null) {
            return ((Set) this.e.get(str)).contains("device_model") || ((Set) this.e.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean K(String str) {
        h();
        o(str);
        return this.e.get(str) != null && ((Set) this.e.get(str)).contains("enhanced_user_id");
    }

    public final boolean L(String str) {
        h();
        o(str);
        return this.e.get(str) != null && ((Set) this.e.get(str)).contains("google_signals");
    }

    public final boolean M(String str) {
        h();
        o(str);
        if (this.e.get(str) != null) {
            return ((Set) this.e.get(str)).contains("os_version") || ((Set) this.e.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean N(String str) {
        h();
        o(str);
        return this.e.get(str) != null && ((Set) this.e.get(str)).contains("user_id");
    }

    public final String e(String str, String str2) {
        h();
        o(str);
        Map map = (Map) this.d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final boolean l() {
        return false;
    }

    public final zzff m(String str, byte[] bArr) {
        if (bArr == null) {
            return zzff.zzg();
        }
        try {
            zzff zzffVar = (zzff) ((zzfe) U4.E(zzff.zze(), bArr)).zzaD();
            this.a.d().v().c("Parsed config. version, gmp_app_id", zzffVar.zzu() ? Long.valueOf(zzffVar.zzc()) : null, zzffVar.zzt() ? zzffVar.zzh() : null);
            return zzffVar;
        } catch (RuntimeException e) {
            e = e;
            this.a.d().w().c("Unable to merge remote config. appId", z1.z(str), e);
            return zzff.zzg();
        } catch (zzll e2) {
            e = e2;
            this.a.d().w().c("Unable to merge remote config. appId", z1.z(str), e);
            return zzff.zzg();
        }
    }

    public final void n(String str, zzfe zzfeVar) {
        HashSet hashSet = new HashSet();
        s.a aVar = new s.a();
        s.a aVar2 = new s.a();
        s.a aVar3 = new s.a();
        Iterator it = zzfeVar.zzg().iterator();
        while (it.hasNext()) {
            hashSet.add(((zzfb) it.next()).zzb());
        }
        for (int i = 0; i < zzfeVar.zza(); i++) {
            zzfc zzfcVar = (zzfc) zzfeVar.zzb(i).zzbB();
            if (zzfcVar.zzc().isEmpty()) {
                this.a.d().w().a("EventConfig contained null event name");
            } else {
                String zzc = zzfcVar.zzc();
                String b = L2.b(zzfcVar.zzc());
                if (!TextUtils.isEmpty(b)) {
                    zzfcVar.zzb(b);
                    zzfeVar.zzd(i, zzfcVar);
                }
                if (zzfcVar.zzf() && zzfcVar.zzd()) {
                    aVar.put(zzc, Boolean.TRUE);
                }
                if (zzfcVar.zzg() && zzfcVar.zze()) {
                    aVar2.put(zzfcVar.zzc(), Boolean.TRUE);
                }
                if (zzfcVar.zzh()) {
                    if (zzfcVar.zza() < 2 || zzfcVar.zza() > 65535) {
                        this.a.d().w().c("Invalid sampling rate. Event name, sample rate", zzfcVar.zzc(), Integer.valueOf(zzfcVar.zza()));
                    } else {
                        aVar3.put(zzfcVar.zzc(), Integer.valueOf(zzfcVar.zza()));
                    }
                }
            }
        }
        this.e.put(str, hashSet);
        this.f.put(str, aVar);
        this.g.put(str, aVar2);
        this.i.put(str, aVar3);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0082: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:131), block:B:33:0x0082 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.c2.o(java.lang.String):void");
    }

    public final void p(String str, zzff zzffVar) {
        if (zzffVar.zza() == 0) {
            this.j.remove(str);
            return;
        }
        this.a.d().v().b("EES programs found", Integer.valueOf(zzffVar.zza()));
        zzgt zzgtVar = (zzgt) zzffVar.zzo().get(0);
        try {
            zzc zzcVar = new zzc();
            zzcVar.zzd("internal.remoteConfig", new W1(this, str));
            zzcVar.zzd("internal.appMetadata", new X1(this, str));
            zzcVar.zzd("internal.logger", new Y1(this));
            zzcVar.zzc(zzgtVar);
            this.j.put(str, zzcVar);
            this.a.d().v().c("EES program loaded for appId, activities", str, Integer.valueOf(zzgtVar.zza().zza()));
            Iterator it = zzgtVar.zza().zzd().iterator();
            while (it.hasNext()) {
                this.a.d().v().b("EES program activity", ((zzgr) it.next()).zzb());
            }
        } catch (zzd unused) {
            this.a.d().r().b("Failed to load EES program. appId", str);
        }
    }

    public final int r(String str, String str2) {
        Integer num;
        h();
        o(str);
        Map map = (Map) this.i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final zzff t(String str) {
        i();
        h();
        com.google.android.gms.common.internal.r.g(str);
        o(str);
        return (zzff) this.h.get(str);
    }

    public final String u(String str) {
        h();
        return (String) this.n.get(str);
    }

    public final String v(String str) {
        h();
        return (String) this.m.get(str);
    }

    public final String w(String str) {
        h();
        o(str);
        return (String) this.l.get(str);
    }

    public final Set y(String str) {
        h();
        o(str);
        return (Set) this.e.get(str);
    }

    public final void z(String str) {
        h();
        this.m.put(str, (Object) null);
    }
}
