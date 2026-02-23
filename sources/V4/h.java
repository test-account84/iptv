package v4;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h implements Parcelable {
    public static final Parcelable.Creator CREATOR = new f();
    public Messenger a;

    public h(IBinder iBinder) {
        this.a = new Messenger(iBinder);
    }

    public final IBinder a() {
        Messenger messenger = this.a;
        messenger.getClass();
        return messenger.getBinder();
    }

    public final void c(Message message) {
        Messenger messenger = this.a;
        messenger.getClass();
        messenger.send(message);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((h) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.a;
        messenger.getClass();
        parcel.writeStrongBinder(messenger.getBinder());
    }
}
