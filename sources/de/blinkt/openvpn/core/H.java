package de.blinkt.openvpn.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        public static class a implements h {
            public IBinder a;

            public a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void H0(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IOpenVPNServiceInternal");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void T(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IOpenVPNServiceInternal");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean a(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IOpenVPNServiceInternal");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }

            public boolean protect(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IOpenVPNServiceInternal");
                    obtain.writeInt(i);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean s(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IOpenVPNServiceInternal");
                    obtain.writeString(str);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "de.blinkt.openvpn.core.IOpenVPNServiceInternal");
        }

        public static h A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("de.blinkt.openvpn.core.IOpenVPNServiceInternal");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof h)) ? new a(iBinder) : (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("de.blinkt.openvpn.core.IOpenVPNServiceInternal");
            }
            if (i == 1598968902) {
                parcel2.writeString("de.blinkt.openvpn.core.IOpenVPNServiceInternal");
                return true;
            }
            switch (i) {
                case 1:
                    i3 = protect(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    T(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    i3 = a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    H0(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    i3 = s(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    L0(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void H0(String str);

    void L0(String str);

    void T(boolean z);

    boolean a(boolean z);

    boolean protect(int i);

    boolean s(String str);
}
