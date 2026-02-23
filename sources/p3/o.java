package P3;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class o extends com.google.android.exoplayer2.decoder.a implements i {
    public i a;
    public long c;

    public int a(long j) {
        return ((i) d4.a.e(this.a)).a(j - this.c);
    }

    public List b(long j) {
        return ((i) d4.a.e(this.a)).b(j - this.c);
    }

    public long c(int i) {
        return ((i) d4.a.e(this.a)).c(i) + this.c;
    }

    public void clear() {
        super.clear();
        this.a = null;
    }

    public void d(long j, i iVar, long j2) {
        this.timeUs = j;
        this.a = iVar;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.c = j;
    }

    public int h() {
        return ((i) d4.a.e(this.a)).h();
    }
}
