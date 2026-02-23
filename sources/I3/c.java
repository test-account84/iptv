package i3;

import d3.j;
import d3.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends q {
    public final long b;

    public c(j jVar, long j) {
        super(jVar);
        d4.a.a(jVar.getPosition() >= j);
        this.b = j;
    }

    public long getLength() {
        return super.getLength() - this.b;
    }

    public long getPosition() {
        return super.getPosition() - this.b;
    }

    public long k() {
        return super.k() - this.b;
    }

    public void o(long j, Throwable th) {
        super.o(j + this.b, th);
    }
}
