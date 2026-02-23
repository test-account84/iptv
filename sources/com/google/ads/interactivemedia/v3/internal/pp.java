package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class pp implements zh {
    private static final Pattern a = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern b = Pattern.compile("MPEGTS:(-?\\d+)");
    private final String c;
    private final co d;
    private zk f;
    private int h;
    private final cj e = new cj();
    private byte[] g = new byte[1024];

    public pp(String str, co coVar) {
        this.c = str;
        this.d = coVar;
    }

    private final aae f(long j) {
        aae i = this.f.i(0, 3);
        r rVar = new r();
        rVar.ae("text/vtt");
        rVar.V(this.c);
        rVar.ai(j);
        i.b(rVar.v());
        this.f.n();
        return i;
    }

    public final boolean C(zi ziVar) throws IOException {
        ziVar.k(this.g, 0, 6, false);
        this.e.D(this.g, 6);
        if (adg.d(this.e)) {
            return true;
        }
        ziVar.k(this.g, 6, 3, false);
        this.e.D(this.g, 9);
        return adg.d(this.e);
    }

    public final int a(zi ziVar, zy zyVar) throws IOException {
        int i;
        af.s(this.f);
        int b2 = (int) ziVar.b();
        int i2 = this.h;
        byte[] bArr = this.g;
        int length = bArr.length;
        if (i2 == length) {
            if (b2 != -1) {
                i = b2;
            } else {
                b2 = length;
                i = -1;
            }
            this.g = Arrays.copyOf(bArr, (b2 * 3) / 2);
            b2 = i;
        }
        byte[] bArr2 = this.g;
        int i3 = this.h;
        int a2 = ziVar.a(bArr2, i3, bArr2.length - i3);
        if (a2 != -1) {
            int i4 = this.h + a2;
            this.h = i4;
            if (b2 == -1 || i4 != b2) {
                return 0;
            }
        }
        cj cjVar = new cj(this.g);
        adg.c(cjVar);
        long j = 0;
        long j2 = 0;
        for (String r = cjVar.r(); !TextUtils.isEmpty(r); r = cjVar.r()) {
            if (r.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = a.matcher(r);
                if (!matcher.find()) {
                    throw as.a("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(r), null);
                }
                Matcher matcher2 = b.matcher(r);
                if (!matcher2.find()) {
                    throw as.a("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(r), null);
                }
                String group = matcher.group(1);
                af.s(group);
                j2 = adg.a(group);
                String group2 = matcher2.group(1);
                af.s(group2);
                j = co.f(Long.parseLong(group2));
            }
        }
        Matcher b3 = adg.b(cjVar);
        if (b3 == null) {
            f(0L);
        } else {
            String group3 = b3.group(1);
            af.s(group3);
            long a3 = adg.a(group3);
            long b4 = this.d.b(co.g((j + a3) - j2) % 8589934592L);
            aae f = f(b4 - a3);
            this.e.D(this.g, this.h);
            f.e(this.e, this.h);
            f.f(b4, 1, this.h, 0, null);
        }
        return -1;
    }

    public final void b(zk zkVar) {
        this.f = zkVar;
        zkVar.x(new aaa(-9223372036854775807L));
    }

    public final void c() {
    }

    public final void d(long j, long j2) {
        throw new IllegalStateException();
    }
}
