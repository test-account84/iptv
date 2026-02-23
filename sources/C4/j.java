package c4;

import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class j implements Comparable {
    public final String a;
    public final long c;
    public final long d;
    public final boolean e;
    public final File f;
    public final long g;

    public j(String str, long j, long j2, long j3, File file) {
        this.a = str;
        this.c = j;
        this.d = j2;
        this.e = file != null;
        this.f = file;
        this.g = j3;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(j jVar) {
        if (!this.a.equals(jVar.a)) {
            return this.a.compareTo(jVar.a);
        }
        long j = this.c - jVar.c;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.e;
    }

    public boolean h() {
        return this.d == -1;
    }

    public String toString() {
        return "[" + this.c + ", " + this.d + "]";
    }
}
