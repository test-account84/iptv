package J4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m extends y4.a implements com.google.android.gms.common.api.h {
    public static final Parcelable.Creator CREATOR = new L();
    public final Status f;
    public final n g;

    public m(Status status, n nVar) {
        this.f = status;
        this.g = nVar;
    }

    public n H() {
        return this.g;
    }

    public Status getStatus() {
        return this.f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.r(parcel, 1, getStatus(), i, false);
        y4.c.r(parcel, 2, H(), i, false);
        y4.c.b(parcel, a);
    }
}
