package f6;

import f6.d;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements c6.f {
    public static final Charset f = Charset.forName("UTF-8");
    public static final c6.d g = c6.d.a("key").b(f6.a.b().c(1).a()).a();
    public static final c6.d h = c6.d.a("value").b(f6.a.b().c(2).a()).a();
    public static final c6.e i = new e();
    public OutputStream a;
    public final Map b;
    public final Map c;
    public final c6.e d;
    public final i e = new i(this);

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.a.values().length];
            a = iArr;
            try {
                iArr[d.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.a.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.a.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(OutputStream outputStream, Map map, Map map2, c6.e eVar) {
        this.a = outputStream;
        this.b = map;
        this.c = map2;
        this.d = eVar;
    }

    public static /* synthetic */ void a(Map.Entry entry, c6.f fVar) {
        r(entry, fVar);
    }

    public static ByteBuffer k(int i2) {
        return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static d p(c6.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2;
        }
        throw new c6.c("Field has no @Protobuf config");
    }

    public static int q(c6.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2.tag();
        }
        throw new c6.c("Field has no @Protobuf config");
    }

    public static /* synthetic */ void r(Map.Entry entry, c6.f fVar) {
        fVar.add(g, entry.getKey());
        fVar.add(h, entry.getValue());
    }

    public c6.f add(c6.d dVar, double d) {
        return b(dVar, d, true);
    }

    public c6.f b(c6.d dVar, double d, boolean z) {
        if (z && d == 0.0d) {
            return this;
        }
        s((q(dVar) << 3) | 1);
        this.a.write(k(8).putDouble(d).array());
        return this;
    }

    public c6.f c(c6.d dVar, float f2, boolean z) {
        if (z && f2 == 0.0f) {
            return this;
        }
        s((q(dVar) << 3) | 5);
        this.a.write(k(4).putFloat(f2).array());
        return this;
    }

    public c6.f d(c6.d dVar, Object obj, boolean z) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            s((q(dVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            s(bytes.length);
            this.a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                d(dVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m(i, dVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return b(dVar, ((Double) obj).doubleValue(), z);
        }
        if (obj instanceof Float) {
            return c(dVar, ((Float) obj).floatValue(), z);
        }
        if (obj instanceof Number) {
            return h(dVar, ((Number) obj).longValue(), z);
        }
        if (obj instanceof Boolean) {
            return j(dVar, ((Boolean) obj).booleanValue(), z);
        }
        if (!(obj instanceof byte[])) {
            c6.e eVar = (c6.e) this.b.get(obj.getClass());
            if (eVar != null) {
                return m(eVar, dVar, obj, z);
            }
            c6.g gVar = (c6.g) this.c.get(obj.getClass());
            return gVar != null ? n(gVar, dVar, obj, z) : obj instanceof c ? add(dVar, ((c) obj).getNumber()) : obj instanceof Enum ? add(dVar, ((Enum) obj).ordinal()) : m(this.d, dVar, obj, z);
        }
        byte[] bArr = (byte[]) obj;
        if (z && bArr.length == 0) {
            return this;
        }
        s((q(dVar) << 3) | 2);
        s(bArr.length);
        this.a.write(bArr);
        return this;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public f add(c6.d dVar, int i2) {
        return f(dVar, i2, true);
    }

    public f f(c6.d dVar, int i2, boolean z) {
        if (z && i2 == 0) {
            return this;
        }
        d p = p(dVar);
        int i3 = a.a[p.intEncoding().ordinal()];
        if (i3 == 1) {
            s(p.tag() << 3);
            s(i2);
        } else if (i3 == 2) {
            s(p.tag() << 3);
            s((i2 << 1) ^ (i2 >> 31));
        } else if (i3 == 3) {
            s((p.tag() << 3) | 5);
            this.a.write(k(4).putInt(i2).array());
        }
        return this;
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public f add(c6.d dVar, long j) {
        return h(dVar, j, true);
    }

    public f h(c6.d dVar, long j, boolean z) {
        if (z && j == 0) {
            return this;
        }
        d p = p(dVar);
        int i2 = a.a[p.intEncoding().ordinal()];
        if (i2 == 1) {
            s(p.tag() << 3);
            t(j);
        } else if (i2 == 2) {
            s(p.tag() << 3);
            t((j >> 63) ^ (j << 1));
        } else if (i2 == 3) {
            s((p.tag() << 3) | 1);
            this.a.write(k(8).putLong(j).array());
        }
        return this;
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public f add(c6.d dVar, boolean z) {
        return j(dVar, z, true);
    }

    public f j(c6.d dVar, boolean z, boolean z2) {
        return f(dVar, z ? 1 : 0, z2);
    }

    public final long l(c6.e eVar, Object obj) {
        b bVar = new b();
        try {
            OutputStream outputStream = this.a;
            this.a = bVar;
            try {
                eVar.encode(obj, this);
                this.a = outputStream;
                long a2 = bVar.a();
                bVar.close();
                return a2;
            } catch (Throwable th) {
                this.a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final f m(c6.e eVar, c6.d dVar, Object obj, boolean z) {
        long l = l(eVar, obj);
        if (z && l == 0) {
            return this;
        }
        s((q(dVar) << 3) | 2);
        t(l);
        eVar.encode(obj, this);
        return this;
    }

    public final f n(c6.g gVar, c6.d dVar, Object obj, boolean z) {
        this.e.b(dVar, z);
        gVar.encode(obj, this.e);
        return this;
    }

    public f o(Object obj) {
        if (obj == null) {
            return this;
        }
        c6.e eVar = (c6.e) this.b.get(obj.getClass());
        if (eVar != null) {
            eVar.encode(obj, this);
            return this;
        }
        throw new c6.c("No encoder for " + obj.getClass());
    }

    public final void s(int i2) {
        while (true) {
            long j = i2 & (-128);
            OutputStream outputStream = this.a;
            if (j == 0) {
                outputStream.write(i2 & 127);
                return;
            } else {
                outputStream.write((i2 & 127) | 128);
                i2 >>>= 7;
            }
        }
    }

    public final void t(long j) {
        while (true) {
            long j2 = (-128) & j;
            OutputStream outputStream = this.a;
            if (j2 == 0) {
                outputStream.write(((int) j) & 127);
                return;
            } else {
                outputStream.write((((int) j) & 127) | 128);
                j >>>= 7;
            }
        }
    }

    public c6.f add(c6.d dVar, Object obj) {
        return d(dVar, obj, true);
    }
}
