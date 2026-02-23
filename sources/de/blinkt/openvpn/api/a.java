package de.blinkt.openvpn.api;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import de.blinkt.openvpn.api.b;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface a extends IInterface {

    public static abstract class a extends Binder implements a {
        public a() {
            attachInterface(this, "de.blinkt.openvpn.api.IOpenVPNAPIService");
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            h8.a Y0;
            int i3;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("de.blinkt.openvpn.api.IOpenVPNAPIService");
            }
            if (i == 1598968902) {
                parcel2.writeString("de.blinkt.openvpn.api.IOpenVPNAPIService");
                return true;
            }
            switch (i) {
                case 1:
                    List r0 = r0();
                    parcel2.writeNoException();
                    b.a(parcel2, r0, 1);
                    return true;
                case 2:
                    u(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    i3 = L(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    k(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    Y0 = Y0(parcel.readString());
                    parcel2.writeNoException();
                    b.b(parcel2, Y0, 1);
                    return true;
                case 6:
                    Y0 = D();
                    parcel2.writeNoException();
                    b.b(parcel2, Y0, 1);
                    return true;
                case 7:
                    disconnect();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    resume();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    R(b.a.A(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    w(b.a.A(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    F0(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    i3 = O0((ParcelFileDescriptor) b.c(parcel, ParcelFileDescriptor.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    Y0 = t(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    b.b(parcel2, Y0, 1);
                    return true;
                case 15:
                    q0(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    public static class b {
        public static /* synthetic */ void a(Parcel parcel, List list, int i) {
            e(parcel, list, i);
        }

        public static /* synthetic */ void b(Parcel parcel, Parcelable parcelable, int i) {
            f(parcel, parcelable, i);
        }

        public static /* synthetic */ Object c(Parcel parcel, Parcelable.Creator creator) {
            return d(parcel, creator);
        }

        public static Object d(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void e(Parcel parcel, List list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                f(parcel, (Parcelable) list.get(i2), i);
            }
        }

        public static void f(Parcel parcel, Parcelable parcelable, int i) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i);
            }
        }
    }

    Intent D();

    void F0(String str);

    boolean L(String str, String str2);

    boolean O0(ParcelFileDescriptor parcelFileDescriptor);

    void R(de.blinkt.openvpn.api.b bVar);

    Intent Y0(String str);

    void disconnect();

    void k(String str);

    void pause();

    void q0(String str, Bundle bundle);

    List r0();

    void resume();

    h8.a t(String str, boolean z, String str2);

    void u(String str);

    void w(de.blinkt.openvpn.api.b bVar);
}
