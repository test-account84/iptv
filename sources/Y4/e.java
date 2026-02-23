package y4;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class e {
    public static d a(byte[] bArr, Parcelable.Creator creator) {
        r.m(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        d dVar = (d) creator.createFromParcel(obtain);
        obtain.recycle();
        return dVar;
    }

    public static d b(String str, Parcelable.Creator creator) {
        return a(C4.c.a(str), creator);
    }

    public static byte[] c(d dVar) {
        Parcel obtain = Parcel.obtain();
        dVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static void d(d dVar, Intent intent, String str) {
        intent.putExtra(str, c(dVar));
    }

    public static String e(d dVar) {
        return C4.c.d(c(dVar));
    }
}
