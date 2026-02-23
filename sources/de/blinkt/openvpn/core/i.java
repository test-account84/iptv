package de.blinkt.openvpn.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import de.blinkt.openvpn.core.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface i extends IInterface {

    public static abstract class a extends Binder implements i {

        public static class a implements i {
            public IBinder a;

            public a(IBinder iBinder) {
                this.a = iBinder;
            }

            public IBinder asBinder() {
                return this.a;
            }

            public void g0(String str, int i, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IServiceStatus");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "de.blinkt.openvpn.core.IServiceStatus");
        }

        public static i A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("de.blinkt.openvpn.core.IServiceStatus");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new a(iBinder) : (i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            E K;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("de.blinkt.openvpn.core.IServiceStatus");
            }
            if (i == 1598968902) {
                parcel2.writeString("de.blinkt.openvpn.core.IServiceStatus");
                return true;
            }
            if (i != 1) {
                if (i == 2) {
                    E0(j.a.A(parcel.readStrongBinder()));
                } else {
                    if (i == 3) {
                        String B0 = B0();
                        parcel2.writeNoException();
                        parcel2.writeString(B0);
                        return true;
                    }
                    if (i == 4) {
                        g0(parcel.readString(), parcel.readInt(), parcel.readString());
                    } else {
                        if (i != 5) {
                            return super.onTransact(i, parcel, parcel2, i2);
                        }
                        K = O();
                    }
                }
                parcel2.writeNoException();
                return true;
            }
            K = K(j.a.A(parcel.readStrongBinder()));
            parcel2.writeNoException();
            b.a(parcel2, K, 1);
            return true;
        }
    }

    public static class b {
        public static /* synthetic */ void a(Parcel parcel, Parcelable parcelable, int i) {
            b(parcel, parcelable, i);
        }

        public static void b(Parcel parcel, Parcelable parcelable, int i) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i);
            }
        }
    }

    String B0();

    void E0(j jVar);

    ParcelFileDescriptor K(j jVar);

    E O();

    void g0(String str, int i, String str2);
}
