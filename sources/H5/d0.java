package H5;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d0 implements y4.d {
    public static final Parcelable.Creator CREATOR = new g0();
    public b a;
    public b0 c;
    public G5.f0 d;

    public d0(b bVar) {
        b bVar2 = (b) com.google.android.gms.common.internal.r.m(bVar);
        this.a = bVar2;
        List a0 = bVar2.a0();
        this.c = null;
        for (int i = 0; i < a0.size(); i++) {
            if (!TextUtils.isEmpty(((f0) a0.get(i)).zza())) {
                this.c = new b0(((f0) a0.get(i)).g(), ((f0) a0.get(i)).zza(), bVar.b0());
            }
        }
        if (this.c == null) {
            this.c = new b0(bVar.b0());
        }
        this.d = bVar.Z();
    }

    public final G5.f a() {
        return this.c;
    }

    public final G5.u c() {
        return this.a;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.r(parcel, 1, c(), i, false);
        y4.c.r(parcel, 2, a(), i, false);
        y4.c.r(parcel, 3, this.d, i, false);
        y4.c.b(parcel, a);
    }

    public d0(b bVar, b0 b0Var, G5.f0 f0Var) {
        this.a = bVar;
        this.c = b0Var;
        this.d = f0Var;
    }
}
