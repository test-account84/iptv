package M4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t extends y4.a implements Iterable {
    public static final Parcelable.Creator CREATOR = new u();
    public final Bundle f;

    public t(Bundle bundle) {
        this.f = bundle;
    }

    public static /* bridge */ /* synthetic */ Bundle I(t tVar) {
        return tVar.f;
    }

    public final int H() {
        return this.f.size();
    }

    public final Bundle J() {
        return new Bundle(this.f);
    }

    public final Double K(String str) {
        return Double.valueOf(this.f.getDouble("value"));
    }

    public final Long L(String str) {
        return Long.valueOf(this.f.getLong("value"));
    }

    public final Object M(String str) {
        return this.f.get(str);
    }

    public final String N(String str) {
        return this.f.getString(str);
    }

    public final Iterator iterator() {
        return new s(this);
    }

    public final String toString() {
        return this.f.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.e(parcel, 2, J(), false);
        y4.c.b(parcel, a);
    }
}
