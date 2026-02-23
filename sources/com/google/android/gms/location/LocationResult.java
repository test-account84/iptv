package com.google.android.gms.location;

import J4.F;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class LocationResult extends a implements ReflectedParcelable {
    public final List f;
    public static final List g = Collections.emptyList();
    public static final Parcelable.Creator CREATOR = new F();

    public LocationResult(List list) {
        this.f = list;
    }

    public List H() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f.size() != this.f.size()) {
            return false;
        }
        Iterator it = locationResult.f.iterator();
        Iterator it2 = this.f.iterator();
        while (it.hasNext()) {
            if (((Location) it2.next()).getTime() != ((Location) it.next()).getTime()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator it = this.f.iterator();
        int i = 17;
        while (it.hasNext()) {
            long time = ((Location) it.next()).getTime();
            i = (i * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f);
        StringBuilder sb = new StringBuilder(valueOf.length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.x(parcel, 1, H(), false);
        c.b(parcel, a);
    }
}
