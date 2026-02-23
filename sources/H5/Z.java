package H5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class z extends y4.a {
    public static final Parcelable.Creator CREATOR = new y();
    public final List f;
    public final List g;

    public z(List list, List list2) {
        this.f = list == null ? new ArrayList() : list;
        this.g = list2 == null ? new ArrayList() : list2;
    }

    public static z c(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            G5.B b = (G5.B) it.next();
            if (b instanceof G5.J) {
                arrayList.add((G5.J) b);
            } else if (b instanceof G5.M) {
                arrayList2.add((G5.M) b);
            }
        }
        return new z(arrayList, arrayList2);
    }

    public final List H() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add((G5.J) it.next());
        }
        Iterator it2 = this.g.iterator();
        while (it2.hasNext()) {
            arrayList.add((G5.M) it2.next());
        }
        return arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.x(parcel, 1, this.f, false);
        y4.c.x(parcel, 2, this.g, false);
        y4.c.b(parcel, a);
    }
}
