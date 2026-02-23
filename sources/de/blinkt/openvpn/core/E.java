package de.blinkt.openvpn.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public enum e implements Parcelable {
    LEVEL_CONNECTED,
    LEVEL_VPNPAUSED,
    LEVEL_CONNECTING_SERVER_REPLIED,
    LEVEL_CONNECTING_NO_SERVER_REPLY_YET,
    LEVEL_NONETWORK,
    LEVEL_NOTCONNECTED,
    LEVEL_START,
    LEVEL_AUTH_FAILED,
    LEVEL_WAITING_FOR_USER_INPUT,
    UNKNOWN_LEVEL;

    public static final Parcelable.Creator CREATOR = new a();

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return e.values()[parcel.readInt()];
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
