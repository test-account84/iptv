package P3;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public y a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return d4.d.d(b.K, (ArrayList) d4.a.e(readBundle.getParcelableArrayList("c")));
    }
}
