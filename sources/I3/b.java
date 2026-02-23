package i3;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b {
    public final long a;
    public final List b;

    public static final class a {
        public final String a;
        public final String b;
        public final long c;
        public final long d;

        public a(String str, String str2, long j, long j2) {
            this.a = str;
            this.b = str2;
            this.c = j;
            this.d = j2;
        }
    }

    public b(long j, List list) {
        this.a = j;
        this.b = list;
    }

    public w3.b a(long j) {
        long j2;
        if (this.b.size() < 2) {
            return null;
        }
        long j3 = j;
        long j4 = -1;
        long j5 = -1;
        long j6 = -1;
        long j7 = -1;
        boolean z = false;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            a aVar = (a) this.b.get(size);
            boolean equals = "video/mp4".equals(aVar.a) | z;
            if (size == 0) {
                j3 -= aVar.d;
                j2 = 0;
            } else {
                j2 = j3 - aVar.c;
            }
            long j8 = j3;
            j3 = j2;
            if (!equals || j3 == j8) {
                z = equals;
            } else {
                j7 = j8 - j3;
                j6 = j3;
                z = false;
            }
            if (size == 0) {
                j4 = j3;
                j5 = j8;
            }
        }
        if (j6 == -1 || j7 == -1 || j4 == -1 || j5 == -1) {
            return null;
        }
        return new w3.b(j4, j5, this.a, j6, j7);
    }
}
