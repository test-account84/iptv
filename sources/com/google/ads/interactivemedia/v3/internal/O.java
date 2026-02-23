package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o implements Comparator, Parcelable {
    public static final Parcelable.Creator CREATOR = new m(1);
    public final String a;
    public final int b;
    private final n[] c;
    private int d;

    public o(Parcel parcel) {
        this.a = parcel.readString();
        n[] nVarArr = (n[]) cq.G((n[]) parcel.createTypedArray(n.CREATOR));
        this.c = nVarArr;
        this.b = nVarArr.length;
    }

    public static o c(o oVar, o oVar2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (oVar != null) {
            str = oVar.a;
            for (n nVar : oVar.c) {
                if (nVar.b()) {
                    arrayList.add(nVar);
                }
            }
        } else {
            str = null;
        }
        if (oVar2 != null) {
            if (str == null) {
                str = oVar2.a;
            }
            int size = arrayList.size();
            for (n nVar2 : oVar2.c) {
                if (nVar2.b()) {
                    UUID uuid = nVar2.a;
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            arrayList.add(nVar2);
                            break;
                        }
                        if (((n) arrayList.get(i)).a.equals(uuid)) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new o(str, (List) arrayList);
    }

    public final n a(int i) {
        return this.c[i];
    }

    public final o b(String str) {
        return cq.V(this.a, str) ? this : new o(str, false, this.c);
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        UUID uuid = i.a;
        return uuid.equals(nVar.a) ? !uuid.equals(nVar2.a) ? 1 : 0 : nVar.a.compareTo(nVar2.a);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (cq.V(this.a, oVar.a) && Arrays.equals(this.c, oVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        String str = this.a;
        int hashCode = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.c);
        this.d = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeTypedArray(this.c, 0);
    }

    public o(String str, List list) {
        this(str, false, (n[]) list.toArray(new n[0]));
    }

    private o(String str, boolean z, n... nVarArr) {
        this.a = str;
        nVarArr = z ? (n[]) nVarArr.clone() : nVarArr;
        this.c = nVarArr;
        this.b = nVarArr.length;
        Arrays.sort(nVarArr, this);
    }

    public o(String str, n... nVarArr) {
        this(str, true, nVarArr);
    }

    public o(List list) {
        this(null, false, (n[]) list.toArray(new n[0]));
    }
}
