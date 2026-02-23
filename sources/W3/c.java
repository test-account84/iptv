package w3;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import q3.a;
import r5.j;
import s5.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final List a;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, b.class.getClassLoader());
            return new c(arrayList);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i) {
            return new c[i];
        }
    }

    public static final class b implements Parcelable {
        public final long a;
        public final long c;
        public final int d;
        public static final Comparator e = new d();
        public static final Parcelable.Creator CREATOR = new a();

        public class a implements Parcelable.Creator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(long j, long j2, int i) {
            d4.a.a(j < j2);
            this.a = j;
            this.c = j2;
            this.d = i;
        }

        public static /* synthetic */ int a(b bVar, b bVar2) {
            return c(bVar, bVar2);
        }

        public static /* synthetic */ int c(b bVar, b bVar2) {
            return q.j().e(bVar.a, bVar2.a).e(bVar.c, bVar2.c).d(bVar.d, bVar2.d).i();
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.c == bVar.c && this.d == bVar.d;
        }

        public int hashCode() {
            return j.b(Long.valueOf(this.a), Long.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            return k0.D("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.a), Long.valueOf(this.c), Integer.valueOf(this.d));
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.a);
            parcel.writeLong(this.c);
            parcel.writeInt(this.d);
        }
    }

    public c(List list) {
        this.a = list;
        d4.a.a(!a(list));
    }

    public static boolean a(List list) {
        if (list.isEmpty()) {
            return false;
        }
        long j = ((b) list.get(0)).c;
        for (int i = 1; i < list.size(); i++) {
            if (((b) list.get(i)).a < j) {
                return true;
            }
            j = ((b) list.get(i)).c;
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((c) obj).a);
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return q3.b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return q3.b.b(this);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public /* synthetic */ void populateMediaMetadata(R0.b bVar) {
        q3.b.c(this, bVar);
    }

    public String toString() {
        return "SlowMotion: segments=" + this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.a);
    }
}
