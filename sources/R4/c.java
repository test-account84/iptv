package r4;

import android.text.format.DateUtils;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.common.internal.r;
import java.text.DateFormat;
import java.util.Date;
import n4.m;
import n4.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public p4.i a;

    public static c f() {
        return new c();
    }

    public static final String p(long j) {
        return j >= 0 ? DateUtils.formatElapsedTime(j / 1000) : "-".concat(String.valueOf(DateUtils.formatElapsedTime((-j) / 1000)));
    }

    public final int a() {
        p4.i iVar = this.a;
        if (iVar == null || !iVar.q()) {
            return 0;
        }
        p4.i iVar2 = this.a;
        if (!iVar2.s() && iVar2.t()) {
            return 0;
        }
        int g = (int) (iVar2.g() - e());
        if (iVar2.r0()) {
            int d = d();
            g = Math.min(Math.max(g, d), c());
        }
        return Math.min(Math.max(g, 0), b());
    }

    public final int b() {
        long g;
        MediaInfo L;
        p4.i iVar = this.a;
        long j = 1;
        if (iVar != null && iVar.q()) {
            p4.i iVar2 = this.a;
            if (iVar2.s()) {
                Long i = i();
                if (i == null && (i = g()) == null) {
                    g = iVar2.g();
                    j = Math.max(g, 1L);
                } else {
                    j = i.longValue();
                }
            } else {
                if (iVar2.t()) {
                    p i2 = iVar2.i();
                    if (i2 != null && (L = i2.L()) != null) {
                        g = L.S();
                    }
                } else {
                    g = iVar2.p();
                }
                j = Math.max(g, 1L);
            }
        }
        return Math.max((int) (j - e()), 1);
    }

    public final int c() {
        p4.i iVar = this.a;
        if (iVar == null || !iVar.q() || !this.a.s()) {
            return b();
        }
        if (!this.a.r0()) {
            return 0;
        }
        long longValue = ((Long) r.m(g())).longValue() - e();
        return Math.min(Math.max((int) longValue, 0), b());
    }

    public final int d() {
        p4.i iVar = this.a;
        if (iVar == null || !iVar.q() || !this.a.s() || !this.a.r0()) {
            return 0;
        }
        long longValue = ((Long) r.m(h())).longValue() - e();
        return Math.min(Math.max((int) longValue, 0), b());
    }

    public final long e() {
        p4.i iVar = this.a;
        if (iVar == null || !iVar.q() || !this.a.s()) {
            return 0L;
        }
        p4.i iVar2 = this.a;
        Long j = j();
        if (j != null) {
            return j.longValue();
        }
        Long h = h();
        return h != null ? h.longValue() : iVar2.g();
    }

    public final Long g() {
        p4.i iVar;
        n4.r l;
        p4.i iVar2 = this.a;
        if (iVar2 == null || !iVar2.q() || !this.a.s() || !this.a.r0() || (l = (iVar = this.a).l()) == null || l.Q() == null) {
            return null;
        }
        return Long.valueOf(iVar.e());
    }

    public final Long h() {
        p4.i iVar;
        n4.r l;
        p4.i iVar2 = this.a;
        if (iVar2 == null || !iVar2.q() || !this.a.s() || !this.a.r0() || (l = (iVar = this.a).l()) == null || l.Q() == null) {
            return null;
        }
        return Long.valueOf(iVar.f());
    }

    public final Long i() {
        m o;
        Long j;
        p4.i iVar = this.a;
        if (iVar == null || !iVar.q() || !this.a.s() || (o = o()) == null || !o.e("com.google.android.gms.cast.metadata.SECTION_DURATION") || (j = j()) == null) {
            return null;
        }
        return Long.valueOf(j.longValue() + o.K("com.google.android.gms.cast.metadata.SECTION_DURATION"));
    }

    public final Long j() {
        p4.i iVar = this.a;
        if (iVar != null && iVar.q() && this.a.s()) {
            p4.i iVar2 = this.a;
            MediaInfo j = iVar2.j();
            m o = o();
            if (j != null && o != null && o.e("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA") && (o.e("com.google.android.gms.cast.metadata.SECTION_DURATION") || iVar2.r0())) {
                return Long.valueOf(o.K("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA"));
            }
        }
        return null;
    }

    public final Long k() {
        MediaInfo j;
        p4.i iVar = this.a;
        if (iVar == null || !iVar.q() || !this.a.s() || (j = this.a.j()) == null || j.R() == -1) {
            return null;
        }
        return Long.valueOf(j.R());
    }

    public final String l(long j) {
        p4.i iVar = this.a;
        if (iVar == null || !iVar.q()) {
            return null;
        }
        p4.i iVar2 = this.a;
        if (((iVar2 == null || !iVar2.q() || !this.a.s() || k() == null) ? 1 : 2) - 1 != 1) {
            return (iVar2.s() && j() == null) ? p(j) : p(j - e());
        }
        return DateFormat.getTimeInstance().format(new Date(((Long) r.m(k())).longValue() + j));
    }

    public final boolean m() {
        return n(a() + e());
    }

    public final boolean n(long j) {
        p4.i iVar = this.a;
        return iVar != null && iVar.q() && this.a.r0() && (((long) c()) + e()) - j < 10000;
    }

    public final m o() {
        MediaInfo j;
        p4.i iVar = this.a;
        if (iVar == null || !iVar.q() || (j = this.a.j()) == null) {
            return null;
        }
        return j.Q();
    }
}
