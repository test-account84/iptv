package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class d extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR = new a();
    public final long[][] a;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel, (a) null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    }

    public d(Parcel parcel) {
        super(parcel);
        this.a = new long[parcel.readInt()][];
        int i = 0;
        while (true) {
            long[][] jArr = this.a;
            if (i >= jArr.length) {
                return;
            }
            jArr[i] = parcel.createLongArray();
            i++;
        }
    }

    public void a(Drawable drawable, int i) {
        if (this.a[i] == null || !(drawable instanceof pl.droidsonroids.gif.a)) {
            return;
        }
        ((pl.droidsonroids.gif.a) drawable).j(r3.h.t(r4, r3.g));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.a.length);
        for (long[] jArr : this.a) {
            parcel.writeLongArray(jArr);
        }
    }

    public /* synthetic */ d(Parcel parcel, a aVar) {
        this(parcel);
    }

    public d(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.a = new long[drawableArr.length][];
        for (int i = 0; i < drawableArr.length; i++) {
            Drawable drawable = drawableArr[i];
            if (drawable instanceof pl.droidsonroids.gif.a) {
                this.a[i] = ((pl.droidsonroids.gif.a) drawable).h.j();
            } else {
                this.a[i] = null;
            }
        }
    }
}
