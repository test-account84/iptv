package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final IntentSender a;
    public final Intent c;
    public final int d;
    public final int e;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public static final class b {
        public IntentSender a;
        public Intent b;
        public int c;
        public int d;

        public b(PendingIntent pendingIntent) {
            this(pendingIntent.getIntentSender());
        }

        public e a() {
            return new e(this.a, this.b, this.c, this.d);
        }

        public b b(Intent intent) {
            this.b = intent;
            return this;
        }

        public b c(int i, int i2) {
            this.d = i;
            this.c = i2;
            return this;
        }

        public b(IntentSender intentSender) {
            this.a = intentSender;
        }
    }

    public e(IntentSender intentSender, Intent intent, int i, int i2) {
        this.a = intentSender;
        this.c = intent;
        this.d = i;
        this.e = i2;
    }

    public Intent a() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public IntentSender e() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }

    public e(Parcel parcel) {
        this.a = parcel.readParcelable(IntentSender.class.getClassLoader());
        this.c = parcel.readParcelable(Intent.class.getClassLoader());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }
}
