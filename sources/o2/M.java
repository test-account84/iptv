package O2;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m extends Binder {
    public static final int c;
    public final s5.y a;

    static {
        c = d4.k0.a >= 30 ? l.a() : 65536;
    }

    public m(List list) {
        this.a = s5.y.r(list);
    }

    public static s5.y a(IBinder iBinder) {
        int readInt;
        y.a p = s5.y.p();
        int i = 1;
        int i2 = 0;
        while (i != 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i2);
                try {
                    iBinder.transact(1, obtain, obtain2, 0);
                    while (true) {
                        readInt = obtain2.readInt();
                        if (readInt == 1) {
                            p.h((Bundle) d4.a.e(obtain2.readBundle()));
                            i2++;
                        }
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    i = readInt;
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        return p.k();
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.a.size();
        int readInt = parcel.readInt();
        while (readInt < size && parcel2.dataSize() < c) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) this.a.get(readInt));
            readInt++;
        }
        parcel2.writeInt(readInt < size ? 2 : 0);
        return true;
    }
}
