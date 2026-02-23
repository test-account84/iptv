package androidx.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final UUID a;
    public final int c;
    public final Bundle d;
    public final Bundle e;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i) {
            return new f[i];
        }
    }

    public f(Parcel parcel) {
        this.a = UUID.fromString(parcel.readString());
        this.c = parcel.readInt();
        this.d = parcel.readBundle(f.class.getClassLoader());
        this.e = parcel.readBundle(f.class.getClassLoader());
    }

    public Bundle a() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public Bundle d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public UUID e() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a.toString());
        parcel.writeInt(this.c);
        parcel.writeBundle(this.d);
        parcel.writeBundle(this.e);
    }

    public f(e eVar) {
        this.a = eVar.g;
        this.c = eVar.b().i();
        this.d = eVar.a();
        Bundle bundle = new Bundle();
        this.e = bundle;
        eVar.g(bundle);
    }
}
