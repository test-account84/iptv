package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class abj implements an {
    public static final Parcelable.Creator CREATOR = new abh(2);
    public final float a;
    public final int b;

    public abj(float f, int i) {
        this.a = f;
        this.b = i;
    }

    public final /* synthetic */ void a(ak akVar) {
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && abj.class == obj.getClass()) {
            abj abjVar = (abj) obj;
            if (this.a == abjVar.a && this.b == abjVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.a).hashCode() + 527) * 31) + this.b;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.a + ", svcTemporalLayerCount=" + this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeInt(this.b);
    }

    public /* synthetic */ abj(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readInt();
    }
}
