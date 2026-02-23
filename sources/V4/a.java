package v4;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends y4.a {
    public static final Parcelable.Creator CREATOR = new d();
    public Intent f;

    public a(Intent intent) {
        this.f = intent;
    }

    public Intent H() {
        return this.f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.r(parcel, 1, this.f, i, false);
        y4.c.b(parcel, a);
    }
}
