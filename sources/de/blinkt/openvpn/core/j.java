package de.blinkt.openvpn.core;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface j extends IInterface {

    public static abstract class a extends Binder implements j {

        public static class a implements j {
            public IBinder a;

            public a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void Q(k kVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IStatusCallbacks");
                    b.a(obtain, kVar, 0);
                    this.a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }

            public void k0(long j, long j2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IStatusCallbacks");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void t0(String str, String str2, int i, e eVar, Intent intent) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IStatusCallbacks");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    b.a(obtain, eVar, 0);
                    b.a(obtain, intent, 0);
                    this.a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void y0(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("de.blinkt.openvpn.core.IStatusCallbacks");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static j A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("de.blinkt.openvpn.core.IStatusCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof j)) ? new a(iBinder) : (j) queryLocalInterface;
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

    void Q(k kVar);

    void k0(long j, long j2);

    void t0(String str, String str2, int i, e eVar, Intent intent);

    void y0(String str);
}
