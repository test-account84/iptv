package P4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends y4.a implements com.google.android.gms.common.api.h {
    public static final Parcelable.Creator CREATOR = new i();
    public final List f;
    public final String g;

    public h(List list, String str) {
        this.f = list;
        this.g = str;
    }

    public final Status getStatus() {
        return this.g != null ? Status.k : Status.o;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        List list = this.f;
        int a = y4.c.a(parcel);
        y4.c.v(parcel, 1, list, false);
        y4.c.t(parcel, 2, this.g, false);
        y4.c.b(parcel, a);
    }
}
