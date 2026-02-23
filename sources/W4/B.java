package w4;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends y4.a {
    public final int f;
    public final int g;
    public final PendingIntent h;
    public final String i;
    public static final b j = new b(0);
    public static final Parcelable.Creator CREATOR = new s();

    public b(int i) {
        this(i, null, null);
    }

    public static String M(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i + ")";
                }
        }
    }

    public int H() {
        return this.g;
    }

    public String I() {
        return this.i;
    }

    public PendingIntent J() {
        return this.h;
    }

    public boolean K() {
        return (this.g == 0 || this.h == null) ? false : true;
    }

    public boolean L() {
        return this.g == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.g == bVar.g && com.google.android.gms.common.internal.q.b(this.h, bVar.h) && com.google.android.gms.common.internal.q.b(this.i, bVar.i);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.g), this.h, this.i);
    }

    public String toString() {
        q.a d = com.google.android.gms.common.internal.q.d(this);
        d.a("statusCode", M(this.g));
        d.a("resolution", this.h);
        d.a("message", this.i);
        return d.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f;
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, i2);
        y4.c.l(parcel, 2, H());
        y4.c.r(parcel, 3, J(), i, false);
        y4.c.t(parcel, 4, I(), false);
        y4.c.b(parcel, a);
    }

    public b(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f = i;
        this.g = i2;
        this.h = pendingIntent;
        this.i = str;
    }

    public b(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public b(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }
}
