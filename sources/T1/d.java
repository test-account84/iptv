package t1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public String a;
    public String c;
    public String d;
    public Date e;
    public f f;
    public String g;
    public String h;
    public boolean i;

    public static class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    }

    public d() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        Date date = this.e;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        f fVar = this.f;
        parcel.writeInt(fVar == null ? -1 : fVar.ordinal());
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
    }

    public d(Parcel parcel) {
        this.a = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        long readLong = parcel.readLong();
        this.e = readLong == -1 ? null : new Date(readLong);
        int readInt = parcel.readInt();
        this.f = readInt != -1 ? f.values()[readInt] : null;
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readByte() != 0;
    }
}
