package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agt extends agq {
    private static final Pattern a = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final agr b;
    private ahi d;
    private aia h;
    private final List c = new ArrayList();
    private boolean e = false;
    private boolean f = false;
    private final String g = UUID.randomUUID().toString();

    public agt(ly lyVar, agr agrVar, byte[] bArr, byte[] bArr2) {
        this.b = agrVar;
        l(null);
        this.d = (agrVar.b() == ags.HTML || agrVar.b() == ags.JAVASCRIPT) ? new ahj(agrVar.a()) : new ahl(agrVar.f());
        this.d.j();
        agz.a().d(this);
        ahd.a().d(this.d.a(), lyVar.i());
    }

    private final void l(View view) {
        this.h = new aia(view);
    }

    public final void a(View view, agv agvVar, String str) {
        ly lyVar;
        if (this.f) {
            return;
        }
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!a.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                lyVar = null;
                break;
            } else {
                lyVar = (ly) it.next();
                if (lyVar.j().get() == view) {
                    break;
                }
            }
        }
        if (lyVar == null) {
            this.c.add(new ly(view, agvVar, str));
        }
    }

    public final void b() {
        if (this.f) {
            return;
        }
        this.h.clear();
        d();
        this.f = true;
        ahd.a().c(this.d.a());
        agz.a().e(this);
        this.d.c();
        this.d = null;
    }

    public final void c(View view) {
        if (this.f) {
            return;
        }
        com.google.ads.interactivemedia.v3.impl.data.i.e(view, "AdView is null");
        if (g() == view) {
            return;
        }
        l(view);
        this.d.b();
        Collection<agt> c = agz.a().c();
        if (c == null || c.isEmpty()) {
            return;
        }
        for (agt agtVar : c) {
            if (agtVar != this && agtVar.g() == view) {
                agtVar.h.clear();
            }
        }
    }

    public final void d() {
        if (this.f) {
            return;
        }
        this.c.clear();
    }

    public final void e() {
        if (this.e) {
            return;
        }
        this.e = true;
        agz.a().f(this);
        this.d.h(ahe.b().a());
        this.d.f(this, this.b);
    }

    public final View g() {
        return (View) this.h.get();
    }

    public final ahi h() {
        return this.d;
    }

    public final String i() {
        return this.g;
    }

    public final List j() {
        return this.c;
    }

    public final boolean k() {
        return this.e && !this.f;
    }
}
