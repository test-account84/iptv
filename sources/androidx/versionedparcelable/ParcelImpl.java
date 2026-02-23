package androidx.versionedparcelable;

import M0.c;
import M0.d;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final d a;

    public static class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }

    public ParcelImpl(d dVar) {
        this.a = dVar;
    }

    public d a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        new c(parcel).L(this.a);
    }

    public ParcelImpl(Parcel parcel) {
        this.a = new c(parcel).u();
    }
}
