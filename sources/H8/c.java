package h8;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        public static class a implements c {
            public IBinder a;

            public a(IBinder iBinder) {
                this.a = iBinder;
            }

            public byte[] I0(String str, byte[] bArr, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.api.ExternalCertificateProvider");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    b.a(obtain, bundle, 0);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }

            public byte[] getCertificateChain(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.api.ExternalCertificateProvider");
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public byte[] x(String str, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.api.ExternalCertificateProvider");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static c A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("de.blinkt.openvpn.api.ExternalCertificateProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new a(iBinder) : (c) queryLocalInterface;
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

    byte[] I0(String str, byte[] bArr, Bundle bundle);

    byte[] getCertificateChain(String str);

    byte[] x(String str, byte[] bArr);
}
