package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class v extends y4.a {
    public static final Parcelable.Creator CREATOR = new A();
    public final int f;
    public List g;

    public v(int i, List list) {
        this.f = i;
        this.g = list;
    }

    public final int H() {
        return this.f;
    }

    public final List I() {
        return this.g;
    }

    public final void J(p pVar) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(pVar);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, this.f);
        y4.c.x(parcel, 2, this.g, false);
        y4.c.b(parcel, a);
    }
}
