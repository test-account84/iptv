package J4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h extends y4.a {
    public static final Parcelable.Creator CREATOR = new s();
    public final List f;
    public final int g;
    public final String h;
    public final String i;

    public static final class a {
        public final List a = new ArrayList();
        public int b = 5;
        public String c = "";

        public a a(f fVar) {
            com.google.android.gms.common.internal.r.n(fVar, "geofence can't be null.");
            com.google.android.gms.common.internal.r.b(fVar instanceof zzbe, "Geofence must be created using Geofence.Builder.");
            this.a.add((zzbe) fVar);
            return this;
        }

        public a b(List list) {
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar != null) {
                        a(fVar);
                    }
                }
            }
            return this;
        }

        public h c() {
            com.google.android.gms.common.internal.r.b(!this.a.isEmpty(), "No geofence has been added to this request.");
            return new h(this.a, this.b, this.c, null);
        }

        public a d(int i) {
            this.b = i & 7;
            return this;
        }
    }

    public h(List list, int i, String str, String str2) {
        this.f = list;
        this.g = i;
        this.h = str;
        this.i = str2;
    }

    public int H() {
        return this.g;
    }

    public String toString() {
        return "GeofencingRequest[geofences=" + this.f + ", initialTrigger=" + this.g + ", tag=" + this.h + ", attributionTag=" + this.i + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = y4.c.a(parcel);
        y4.c.x(parcel, 1, this.f, false);
        y4.c.l(parcel, 2, H());
        y4.c.t(parcel, 3, this.h, false);
        y4.c.t(parcel, 4, this.i, false);
        y4.c.b(parcel, a2);
    }
}
