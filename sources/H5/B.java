package H5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.firebase-auth-api.zzafn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b extends G5.u {
    public static final Parcelable.Creator CREATOR = new e();
    public zzafn f;
    public f0 g;
    public String h;
    public String i;
    public List j;
    public List k;
    public String l;
    public Boolean m;
    public d n;
    public boolean o;
    public G5.f0 p;
    public z q;
    public List r;

    public b(A5.f fVar, List list) {
        com.google.android.gms.common.internal.r.m(fVar);
        this.h = fVar.o();
        this.i = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.l = "2";
        O(list);
    }

    public G5.v H() {
        return this.n;
    }

    public /* synthetic */ G5.z I() {
        return new f(this);
    }

    public List J() {
        return this.j;
    }

    public String K() {
        Map map;
        zzafn zzafnVar = this.f;
        if (zzafnVar == null || zzafnVar.zzc() == null || (map = (Map) v.a(this.f.zzc()).a().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    public String L() {
        return this.g.K();
    }

    public boolean M() {
        G5.w a;
        Boolean bool = this.m;
        if (bool == null || bool.booleanValue()) {
            zzafn zzafnVar = this.f;
            String str = "";
            if (zzafnVar != null && (a = v.a(zzafnVar.zzc())) != null) {
                str = a.b();
            }
            boolean z = true;
            if (J().size() > 1 || (str != null && str.equals("custom"))) {
                z = false;
            }
            this.m = Boolean.valueOf(z);
        }
        return this.m.booleanValue();
    }

    public final A5.f N() {
        return A5.f.n(this.h);
    }

    public final synchronized G5.u O(List list) {
        try {
            com.google.android.gms.common.internal.r.m(list);
            this.j = new ArrayList(list.size());
            this.k = new ArrayList(list.size());
            for (int i = 0; i < list.size(); i++) {
                G5.O o = (G5.O) list.get(i);
                if (o.g().equals("firebase")) {
                    this.g = (f0) o;
                } else {
                    this.k.add(o.g());
                }
                this.j.add((f0) o);
            }
            if (this.g == null) {
                this.g = (f0) this.j.get(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final void P(zzafn zzafnVar) {
        this.f = (zzafn) com.google.android.gms.common.internal.r.m(zzafnVar);
    }

    public final /* synthetic */ G5.u Q() {
        this.m = Boolean.FALSE;
        return this;
    }

    public final void R(List list) {
        this.q = z.c(list);
    }

    public final zzafn S() {
        return this.f;
    }

    public final List T() {
        return this.k;
    }

    public final b U(String str) {
        this.l = str;
        return this;
    }

    public final void V(G5.f0 f0Var) {
        this.p = f0Var;
    }

    public final void W(d dVar) {
        this.n = dVar;
    }

    public final void X(boolean z) {
        this.o = z;
    }

    public final void Y(List list) {
        com.google.android.gms.common.internal.r.m(list);
        this.r = list;
    }

    public final G5.f0 Z() {
        return this.p;
    }

    public final List a0() {
        return this.j;
    }

    public final boolean b0() {
        return this.o;
    }

    public String g() {
        return this.g.g();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.r(parcel, 1, S(), i, false);
        y4.c.r(parcel, 2, this.g, i, false);
        y4.c.t(parcel, 3, this.h, false);
        y4.c.t(parcel, 4, this.i, false);
        y4.c.x(parcel, 5, this.j, false);
        y4.c.v(parcel, 6, T(), false);
        y4.c.t(parcel, 7, this.l, false);
        y4.c.d(parcel, 8, Boolean.valueOf(M()), false);
        y4.c.r(parcel, 9, H(), i, false);
        y4.c.c(parcel, 10, this.o);
        y4.c.r(parcel, 11, this.p, i, false);
        y4.c.r(parcel, 12, this.q, i, false);
        y4.c.x(parcel, 13, this.r, false);
        y4.c.b(parcel, a);
    }

    public final String zzd() {
        return S().zzc();
    }

    public final String zze() {
        return this.f.zzf();
    }

    public final List zzh() {
        z zVar = this.q;
        return zVar != null ? zVar.H() : new ArrayList();
    }

    public b(zzafn zzafnVar, f0 f0Var, String str, String str2, List list, List list2, String str3, Boolean bool, d dVar, boolean z, G5.f0 f0Var2, z zVar, List list3) {
        this.f = zzafnVar;
        this.g = f0Var;
        this.h = str;
        this.i = str2;
        this.j = list;
        this.k = list2;
        this.l = str3;
        this.m = bool;
        this.n = dVar;
        this.o = z;
        this.p = f0Var2;
        this.q = zVar;
        this.r = list3;
    }
}
