package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class s implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final String a;
    public final String c;
    public final boolean d;
    public final int e;
    public final int f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Bundle k;
    public final boolean l;
    public final int m;
    public Bundle n;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s createFromParcel(Parcel parcel) {
            return new s(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public s[] newArray(int i) {
            return new s[i];
        }
    }

    public s(Parcel parcel) {
        this.a = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt() != 0;
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
        this.l = parcel.readInt() != 0;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.a);
        sb.append(" (");
        sb.append(this.c);
        sb.append(")}:");
        if (this.d) {
            sb.append(" fromLayout");
        }
        if (this.f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f));
        }
        String str = this.g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.g);
        }
        if (this.h) {
            sb.append(" retainInstance");
        }
        if (this.i) {
            sb.append(" removing");
        }
        if (this.j) {
            sb.append(" detached");
        }
        if (this.l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }

    public s(Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.c = fragment.mWho;
        this.d = fragment.mFromLayout;
        this.e = fragment.mFragmentId;
        this.f = fragment.mContainerId;
        this.g = fragment.mTag;
        this.h = fragment.mRetainInstance;
        this.i = fragment.mRemoving;
        this.j = fragment.mDetached;
        this.k = fragment.mArguments;
        this.l = fragment.mHidden;
        this.m = fragment.mMaxState.ordinal();
    }
}
