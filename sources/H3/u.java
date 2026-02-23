package H3;

import O2.l1;
import O2.z0;
import android.text.TextUtils;
import com.google.android.exoplayer2.extractor.g;
import d3.w;
import d4.M;
import d4.Z;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u implements d3.i {
    public static final Pattern g = Pattern.compile("LOCAL:([^,]+)");
    public static final Pattern h = Pattern.compile("MPEGTS:(-?\\d+)");
    public final String a;
    public final Z b;
    public d3.k d;
    public int f;
    public final M c = new M();
    public byte[] e = new byte[1024];

    public u(String str, Z z) {
        this.a = str;
        this.b = z;
    }

    public void a(long j, long j2) {
        throw new IllegalStateException();
    }

    public void b(d3.k kVar) {
        this.d = kVar;
        kVar.n(new g.b(-9223372036854775807L));
    }

    public final w c(long j) {
        w e = this.d.e(0, 3);
        e.d(new z0.b().g0("text/vtt").X(this.a).k0(j).G());
        this.d.q();
        return e;
    }

    public int d(d3.j jVar, d3.t tVar) {
        d4.a.e(this.d);
        int length = (int) jVar.getLength();
        int i = this.f;
        byte[] bArr = this.e;
        if (i == bArr.length) {
            this.e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.e;
        int i2 = this.f;
        int read = jVar.read(bArr2, i2, bArr2.length - i2);
        if (read != -1) {
            int i3 = this.f + read;
            this.f = i3;
            if (length == -1 || i3 != length) {
                return 0;
            }
        }
        e();
        return -1;
    }

    public final void e() {
        M m = new M(this.e);
        Y3.i.e(m);
        long j = 0;
        long j2 = 0;
        for (String s = m.s(); !TextUtils.isEmpty(s); s = m.s()) {
            if (s.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = g.matcher(s);
                if (!matcher.find()) {
                    throw l1.a("X-TIMESTAMP-MAP doesn't contain local timestamp: " + s, null);
                }
                Matcher matcher2 = h.matcher(s);
                if (!matcher2.find()) {
                    throw l1.a("X-TIMESTAMP-MAP doesn't contain media timestamp: " + s, null);
                }
                j2 = Y3.i.d((String) d4.a.e(matcher.group(1)));
                j = Z.g(Long.parseLong((String) d4.a.e(matcher2.group(1))));
            }
        }
        Matcher a = Y3.i.a(m);
        if (a == null) {
            c(0L);
            return;
        }
        long d = Y3.i.d((String) d4.a.e(a.group(1)));
        long b = this.b.b(Z.k((j + d) - j2));
        w c = c(b - d);
        this.c.S(this.e, this.f);
        c.b(this.c, this.f);
        c.f(b, 1, this.f, 0, null);
    }

    public boolean h(d3.j jVar) {
        jVar.d(this.e, 0, 6, false);
        this.c.S(this.e, 6);
        if (Y3.i.b(this.c)) {
            return true;
        }
        jVar.d(this.e, 6, 3, false);
        this.c.S(this.e, 9);
        return Y3.i.b(this.c);
    }

    public void release() {
    }
}
