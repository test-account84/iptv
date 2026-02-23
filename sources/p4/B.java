package P4;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends y4.a implements com.google.android.gms.common.api.h {
    public static final Parcelable.Creator CREATOR = new c();
    public final int f;
    public int g;
    public Intent h;

    public b(int i, int i2, Intent intent) {
        this.f = i;
        this.g = i2;
        this.h = intent;
    }

    public final Status getStatus() {
        return this.g == 0 ? Status.k : Status.o;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f;
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, i2);
        y4.c.l(parcel, 2, this.g);
        y4.c.r(parcel, 3, this.h, i, false);
        y4.c.b(parcel, a);
    }
}
