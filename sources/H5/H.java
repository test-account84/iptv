package H5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.firebase-auth-api.zzyk;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends G5.C {
    public static final Parcelable.Creator CREATOR = new i();
    public final List f;
    public final k g;
    public final String h;
    public final G5.f0 i;
    public final b j;
    public final List k;

    public h(List list, k kVar, String str, G5.f0 f0Var, b bVar, List list2) {
        this.f = (List) com.google.android.gms.common.internal.r.m(list);
        this.g = (k) com.google.android.gms.common.internal.r.m(kVar);
        this.h = com.google.android.gms.common.internal.r.g(str);
        this.i = f0Var;
        this.j = bVar;
        this.k = (List) com.google.android.gms.common.internal.r.m(list2);
    }

    public static h I(zzyk zzykVar, FirebaseAuth firebaseAuth, G5.u uVar) {
        List<G5.B> zzc = zzykVar.zzc();
        ArrayList arrayList = new ArrayList();
        for (G5.B b : zzc) {
            if (b instanceof G5.J) {
                arrayList.add((G5.J) b);
            }
        }
        List<G5.B> zzc2 = zzykVar.zzc();
        ArrayList arrayList2 = new ArrayList();
        for (G5.B b2 : zzc2) {
            if (b2 instanceof G5.M) {
                arrayList2.add((G5.M) b2);
            }
        }
        return new h(arrayList, k.c(zzykVar.zzc(), zzykVar.zzb()), firebaseAuth.b().o(), zzykVar.zza(), (b) uVar, arrayList2);
    }

    public final G5.D H() {
        return this.g;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.x(parcel, 1, this.f, false);
        y4.c.r(parcel, 2, H(), i, false);
        y4.c.t(parcel, 3, this.h, false);
        y4.c.r(parcel, 4, this.i, i, false);
        y4.c.r(parcel, 5, this.j, i, false);
        y4.c.x(parcel, 6, this.k, false);
        y4.c.b(parcel, a);
    }
}
