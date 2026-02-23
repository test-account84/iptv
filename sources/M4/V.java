package M4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v extends y4.a {
    public static final Parcelable.Creator CREATOR = new w();
    public final String f;
    public final t g;
    public final String h;
    public final long i;

    public v(v vVar, long j) {
        com.google.android.gms.common.internal.r.m(vVar);
        this.f = vVar.f;
        this.g = vVar.g;
        this.h = vVar.h;
        this.i = j;
    }

    public final String toString() {
        return "origin=" + this.h + ",name=" + this.f + ",params=" + String.valueOf(this.g);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        w.a(this, parcel, i);
    }

    public v(String str, t tVar, String str2, long j) {
        this.f = str;
        this.g = tVar;
        this.h = str2;
        this.i = j;
    }
}
