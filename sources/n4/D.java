package n4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d extends y4.a {
    public static final Parcelable.Creator CREATOR = new u0();
    public String f;
    public String g;
    public final List h;
    public String i;
    public Uri j;
    public String k;
    public String l;

    public d(String str, String str2, List list, List list2, String str3, Uri uri, String str4, String str5) {
        this.f = str;
        this.g = str2;
        this.h = list2;
        this.i = str3;
        this.j = uri;
        this.k = str4;
        this.l = str5;
    }

    public String H() {
        return this.f;
    }

    public String I() {
        return this.k;
    }

    public List J() {
        return null;
    }

    public String K() {
        return this.i;
    }

    public List L() {
        return Collections.unmodifiableList(this.h);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return t4.a.k(this.f, dVar.f) && t4.a.k(this.g, dVar.g) && t4.a.k(this.h, dVar.h) && t4.a.k(this.i, dVar.i) && t4.a.k(this.j, dVar.j) && t4.a.k(this.k, dVar.k) && t4.a.k(this.l, dVar.l);
    }

    public String getName() {
        return this.g;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f, this.g, this.h, this.i, this.j, this.k);
    }

    public String toString() {
        String str = this.f;
        String str2 = this.g;
        List list = this.h;
        return "applicationId: " + str + ", name: " + str2 + ", namespaces.count: " + (list == null ? 0 : list.size()) + ", senderAppIdentifier: " + this.i + ", senderAppLaunchUrl: " + String.valueOf(this.j) + ", iconUrl: " + this.k + ", type: " + this.l;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 2, H(), false);
        y4.c.t(parcel, 3, getName(), false);
        y4.c.x(parcel, 4, J(), false);
        y4.c.v(parcel, 5, L(), false);
        y4.c.t(parcel, 6, K(), false);
        y4.c.r(parcel, 7, this.j, i, false);
        y4.c.t(parcel, 8, I(), false);
        y4.c.t(parcel, 9, this.l, false);
        y4.c.b(parcel, a);
    }
}
