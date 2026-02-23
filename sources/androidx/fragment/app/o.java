package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.m;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class o implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public ArrayList a;
    public ArrayList c;
    public b[] d;
    public int e;
    public String f;
    public ArrayList g;
    public ArrayList h;
    public ArrayList i;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public o[] newArray(int i) {
            return new o[i];
        }
    }

    public o() {
        this.f = null;
        this.g = new ArrayList();
        this.h = new ArrayList();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.a);
        parcel.writeStringList(this.c);
        parcel.writeTypedArray(this.d, i);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeStringList(this.g);
        parcel.writeTypedList(this.h);
        parcel.writeTypedList(this.i);
    }

    public o(Parcel parcel) {
        this.f = null;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.a = parcel.createTypedArrayList(s.CREATOR);
        this.c = parcel.createStringArrayList();
        this.d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.createStringArrayList();
        this.h = parcel.createTypedArrayList(Bundle.CREATOR);
        this.i = parcel.createTypedArrayList(m.m.CREATOR);
    }
}
