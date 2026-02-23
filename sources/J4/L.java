package J4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends y4.a {
    public static final Parcelable.Creator CREATOR = new K();
    public final List f;
    public final boolean g;
    public final boolean h;
    public I i;

    public l(List list, boolean z, boolean z2, I i) {
        this.f = list;
        this.g = z;
        this.h = z2;
        this.i = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.x(parcel, 1, Collections.unmodifiableList(this.f), false);
        y4.c.c(parcel, 2, this.g);
        y4.c.c(parcel, 3, this.h);
        y4.c.r(parcel, 5, this.i, i, false);
        y4.c.b(parcel, a);
    }
}
