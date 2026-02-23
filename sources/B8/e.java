package B8;

import java.util.NoSuchElementException;
import l8.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class e extends y {
    public final long a;
    public final long c;
    public boolean d;
    public long e;

    public e(long j, long j2, long j3) {
        this.a = j3;
        this.c = j2;
        boolean z = false;
        if (j3 <= 0 ? j >= j2 : j <= j2) {
            z = true;
        }
        this.d = z;
        this.e = z ? j : j2;
    }

    public long b() {
        long j = this.e;
        if (j != this.c) {
            this.e = this.a + j;
        } else {
            if (!this.d) {
                throw new NoSuchElementException();
            }
            this.d = false;
        }
        return j;
    }

    public boolean hasNext() {
        return this.d;
    }
}
