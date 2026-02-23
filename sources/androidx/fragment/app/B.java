package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.w;
import androidx.lifecycle.j;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final int[] a;
    public final ArrayList c;
    public final int[] d;
    public final int[] e;
    public final int f;
    public final String g;
    public final int h;
    public final int i;
    public final CharSequence j;
    public final int k;
    public final CharSequence l;
    public final ArrayList m;
    public final ArrayList n;
    public final boolean o;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.c = parcel.createStringArrayList();
        this.d = parcel.createIntArray();
        this.e = parcel.createIntArray();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.j = (CharSequence) creator.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) creator.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public androidx.fragment.app.a a(m mVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(mVar);
        int i = 0;
        int i2 = 0;
        while (i < this.a.length) {
            w.a aVar2 = new w.a();
            int i3 = i + 1;
            aVar2.a = this.a[i];
            if (m.F0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.a[i3]);
            }
            String str = (String) this.c.get(i2);
            aVar2.b = str != null ? mVar.f0(str) : null;
            aVar2.g = j.c.values()[this.d[i2]];
            aVar2.h = j.c.values()[this.e[i2]];
            int[] iArr = this.a;
            int i4 = iArr[i3];
            aVar2.c = i4;
            int i5 = iArr[i + 2];
            aVar2.d = i5;
            int i6 = i + 4;
            int i7 = iArr[i + 3];
            aVar2.e = i7;
            i += 5;
            int i8 = iArr[i6];
            aVar2.f = i8;
            aVar.d = i4;
            aVar.e = i5;
            aVar.f = i7;
            aVar.g = i8;
            aVar.f(aVar2);
            i2++;
        }
        aVar.h = this.f;
        aVar.k = this.g;
        aVar.v = this.h;
        aVar.i = true;
        aVar.l = this.i;
        aVar.m = this.j;
        aVar.n = this.k;
        aVar.o = this.l;
        aVar.p = this.m;
        aVar.q = this.n;
        aVar.r = this.o;
        aVar.x(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeStringList(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeIntArray(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.c.size();
        this.a = new int[size * 5];
        if (!aVar.i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.c = new ArrayList(size);
        this.d = new int[size];
        this.e = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            w.a aVar2 = (w.a) aVar.c.get(i2);
            int i3 = i + 1;
            this.a[i] = aVar2.a;
            ArrayList arrayList = this.c;
            Fragment fragment = aVar2.b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.a;
            iArr[i3] = aVar2.c;
            iArr[i + 2] = aVar2.d;
            int i4 = i + 4;
            iArr[i + 3] = aVar2.e;
            i += 5;
            iArr[i4] = aVar2.f;
            this.d[i2] = aVar2.g.ordinal();
            this.e[i2] = aVar2.h.ordinal();
        }
        this.f = aVar.h;
        this.g = aVar.k;
        this.h = aVar.v;
        this.i = aVar.l;
        this.j = aVar.m;
        this.k = aVar.n;
        this.l = aVar.o;
        this.m = aVar.p;
        this.n = aVar.q;
        this.o = aVar.r;
    }
}
