package M4;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzoy;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j5 {
    public String a;
    public boolean b;
    public zzgi c;
    public BitSet d;
    public BitSet e;
    public Map f;
    public Map g;
    public final /* synthetic */ b h;

    public /* synthetic */ j5(b bVar, String str, i5 i5Var) {
        this.h = bVar;
        this.a = str;
        this.b = true;
        this.d = new BitSet();
        this.e = new BitSet();
        this.f = new s.a();
        this.g = new s.a();
    }

    public static /* bridge */ /* synthetic */ BitSet b(j5 j5Var) {
        return j5Var.d;
    }

    public final zzfp a(int i) {
        Iterable iterable;
        List list;
        zzfo zzb = zzfp.zzb();
        zzb.zza(i);
        zzb.zzc(this.b);
        zzgi zzgiVar = this.c;
        if (zzgiVar != null) {
            zzb.zzd(zzgiVar);
        }
        zzgh zze = zzgi.zze();
        zze.zzb(U4.J(this.d));
        zze.zzd(U4.J(this.e));
        Map map = this.f;
        if (map == null) {
            iterable = null;
        } else {
            Iterable arrayList = new ArrayList(map.size());
            for (Integer num : this.f.keySet()) {
                int intValue = num.intValue();
                Long l = (Long) this.f.get(num);
                if (l != null) {
                    zzfq zzc = zzfr.zzc();
                    zzc.zzb(intValue);
                    zzc.zza(l.longValue());
                    arrayList.add((zzfr) zzc.zzaD());
                }
            }
            iterable = arrayList;
        }
        if (iterable != null) {
            zze.zza(iterable);
        }
        Map map2 = this.g;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            List arrayList2 = new ArrayList(map2.size());
            for (Integer num2 : this.g.keySet()) {
                zzgj zzd = zzgk.zzd();
                zzd.zzb(num2.intValue());
                List list2 = (List) this.g.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd.zza(list2);
                }
                arrayList2.add((zzgk) zzd.zzaD());
            }
            list = arrayList2;
        }
        zze.zzc(list);
        zzb.zzb(zze);
        return (zzfp) zzb.zzaD();
    }

    public final void c(n5 n5Var) {
        int a = n5Var.a();
        if (n5Var.c != null) {
            this.e.set(a, true);
        }
        Boolean bool = n5Var.d;
        if (bool != null) {
            this.d.set(a, bool.booleanValue());
        }
        if (n5Var.e != null) {
            Map map = this.f;
            Integer valueOf = Integer.valueOf(a);
            Long l = (Long) map.get(valueOf);
            long longValue = n5Var.e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.f.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (n5Var.f != null) {
            Map map2 = this.g;
            Integer valueOf2 = Integer.valueOf(a);
            ArrayList arrayList = (List) map2.get(valueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.g.put(valueOf2, arrayList);
            }
            if (n5Var.c()) {
                arrayList.clear();
            }
            zzoy.zzc();
            h z = this.h.a.z();
            String str = this.a;
            l1 l1Var = m1.a0;
            if (z.B(str, l1Var) && n5Var.b()) {
                arrayList.clear();
            }
            zzoy.zzc();
            boolean B = this.h.a.z().B(this.a, l1Var);
            Long valueOf3 = Long.valueOf(n5Var.f.longValue() / 1000);
            if (!B) {
                arrayList.add(valueOf3);
            } else {
                if (arrayList.contains(valueOf3)) {
                    return;
                }
                arrayList.add(valueOf3);
            }
        }
    }

    public /* synthetic */ j5(b bVar, String str, zzgi zzgiVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, i5 i5Var) {
        this.h = bVar;
        this.a = str;
        this.d = bitSet;
        this.e = bitSet2;
        this.f = map;
        this.g = new s.a();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.g.put(num, arrayList);
        }
        this.b = false;
        this.c = zzgiVar;
    }
}
