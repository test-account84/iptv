package J4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d extends y4.a {
    public static final Parcelable.Creator CREATOR = new X();
    public static final Comparator j = new W();
    public final List f;
    public final String g;
    public final List h;
    public String i;

    public d(List list, String str, List list2, String str2) {
        com.google.android.gms.common.internal.r.n(list, "transitions can't be null");
        com.google.android.gms.common.internal.r.b(list.size() > 0, "transitions can't be empty.");
        com.google.android.gms.common.internal.r.m(list);
        TreeSet treeSet = new TreeSet(j);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            com.google.android.gms.common.internal.r.b(treeSet.add(cVar), String.format("Found duplicated transition: %s.", new Object[]{cVar}));
        }
        this.f = Collections.unmodifiableList(list);
        this.g = str;
        this.h = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.i = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            if (com.google.android.gms.common.internal.q.b(this.f, dVar.f) && com.google.android.gms.common.internal.q.b(this.g, dVar.g) && com.google.android.gms.common.internal.q.b(this.i, dVar.i) && com.google.android.gms.common.internal.q.b(this.h, dVar.h)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f.hashCode() * 31;
        String str = this.g;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.h;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.i;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f);
        String str = this.g;
        String valueOf2 = String.valueOf(this.h);
        String str2 = this.i;
        int length = valueOf.length();
        int length2 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 79 + length2 + valueOf2.length() + String.valueOf(str2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(valueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append("', mClients=");
        sb.append(valueOf2);
        sb.append(", mAttributionTag=");
        sb.append(str2);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.common.internal.r.m(parcel);
        int a = y4.c.a(parcel);
        y4.c.x(parcel, 1, this.f, false);
        y4.c.t(parcel, 2, this.g, false);
        y4.c.x(parcel, 3, this.h, false);
        y4.c.t(parcel, 4, this.i, false);
        y4.c.b(parcel, a);
    }
}
