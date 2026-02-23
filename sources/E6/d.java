package e6;

import c6.g;
import c6.h;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements d6.b {
    public static final c6.e e = new e6.a();
    public static final g f = new e6.b();
    public static final g g = new c();
    public static final b h = new b(null);
    public final Map a = new HashMap();
    public final Map b = new HashMap();
    public c6.e c = e;
    public boolean d = false;

    public class a implements c6.a {
        public a() {
        }

        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.d(d.this), d.e(d.this), d.f(d.this), d.g(d.this));
            eVar.d(obj, false);
            eVar.n();
        }

        public String encode(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    public static final class b implements g {
        public static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(Date date, h hVar) {
            hVar.add(a.format(date));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        o(String.class, f);
        o(Boolean.class, g);
        o(Date.class, h);
    }

    public static /* synthetic */ void a(Boolean bool, h hVar) {
        m(bool, hVar);
    }

    public static /* synthetic */ void b(Object obj, c6.f fVar) {
        k(obj, fVar);
    }

    public static /* synthetic */ void c(String str, h hVar) {
        l(str, hVar);
    }

    public static /* synthetic */ Map d(d dVar) {
        return dVar.a;
    }

    public static /* synthetic */ Map e(d dVar) {
        return dVar.b;
    }

    public static /* synthetic */ c6.e f(d dVar) {
        return dVar.c;
    }

    public static /* synthetic */ boolean g(d dVar) {
        return dVar.d;
    }

    public static /* synthetic */ void k(Object obj, c6.f fVar) {
        throw new c6.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public static /* synthetic */ void l(String str, h hVar) {
        hVar.add(str);
    }

    public static /* synthetic */ void m(Boolean bool, h hVar) {
        hVar.add(bool.booleanValue());
    }

    public c6.a h() {
        return new a();
    }

    public d i(d6.a aVar) {
        aVar.configure(this);
        return this;
    }

    public d j(boolean z) {
        this.d = z;
        return this;
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public d registerEncoder(Class cls, c6.e eVar) {
        this.a.put(cls, eVar);
        this.b.remove(cls);
        return this;
    }

    public d o(Class cls, g gVar) {
        this.b.put(cls, gVar);
        this.a.remove(cls);
        return this;
    }
}
