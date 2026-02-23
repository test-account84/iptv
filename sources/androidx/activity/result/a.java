package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final int a;
    public final Intent c;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(int i, Intent intent) {
        this.a = i;
        this.c = intent;
    }

    public static String d(int i) {
        return i != -1 ? i != 0 ? String.valueOf(i) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + d(this.a) + ", data=" + this.c + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.c == null ? 0 : 1);
        Intent intent = this.c;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }

    public a(Parcel parcel) {
        this.a = parcel.readInt();
        this.c = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
