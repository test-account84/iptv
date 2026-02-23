package de.blinkt.openvpn.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        public static class a implements b {
            public IBinder a;

            public a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void U(String str, String str2, String str3, String str4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.api.IOpenVPNStatusCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

        public static b A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("de.blinkt.openvpn.api.IOpenVPNStatusCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(iBinder) : (b) queryLocalInterface;
        }
    }

    void U(String str, String str2, String str3, String str4);
}
