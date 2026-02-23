package H5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k extends G5.D {
    public static final Parcelable.Creator CREATOR = new j();
    public String f;
    public String g;
    public List h;
    public List i;
    public b j;

    public k() {
    }

    public static k c(List list, String str) {
        List list2;
        Object obj;
        com.google.android.gms.common.internal.r.m(list);
        com.google.android.gms.common.internal.r.g(str);
        k kVar = new k();
        kVar.h = new ArrayList();
        kVar.i = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            G5.B b = (G5.B) it.next();
            if (b instanceof G5.J) {
                list2 = kVar.h;
                obj = (G5.J) b;
            } else {
                if (!(b instanceof G5.M)) {
                    throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: " + b.J());
                }
                list2 = kVar.i;
                obj = (G5.M) b;
            }
            list2.add(obj);
        }
        kVar.g = str;
        return kVar;
    }

    public final String H() {
        return this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, this.f, false);
        y4.c.t(parcel, 2, this.g, false);
        y4.c.x(parcel, 3, this.h, false);
        y4.c.x(parcel, 4, this.i, false);
        y4.c.r(parcel, 5, this.j, i, false);
        y4.c.b(parcel, a);
    }

    public final String zzc() {
        return this.g;
    }

    public k(String str, String str2, List list, List list2, b bVar) {
        this.f = str;
        this.g = str2;
        this.h = list;
        this.i = list2;
        this.j = bVar;
    }
}
