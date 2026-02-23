package e6;

import android.util.Base64;
import android.util.JsonWriter;
import c6.g;
import c6.h;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e implements c6.f, h {
    public e a = null;
    public boolean b = true;
    public final JsonWriter c;
    public final Map d;
    public final Map e;
    public final c6.e f;
    public final boolean g;

    public e(Writer writer, Map map, Map map2, c6.e eVar, boolean z) {
        this.c = new JsonWriter(writer);
        this.d = map;
        this.e = map2;
        this.f = eVar;
        this.g = z;
    }

    public e a(double d) {
        r();
        this.c.value(d);
        return this;
    }

    public c6.f add(c6.d dVar, double d) {
        return f(dVar.b(), d);
    }

    public e b(int i) {
        r();
        this.c.value(i);
        return this;
    }

    public e c(long j) {
        r();
        this.c.value(j);
        return this;
    }

    public e d(Object obj, boolean z) {
        int i = 0;
        if (z && m(obj)) {
            throw new c6.c(String.format("%s cannot be encoded inline", new Object[]{obj == null ? null : obj.getClass()}));
        }
        if (obj == null) {
            this.c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    d(it.next(), false);
                }
                this.c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        i((String) key, entry.getValue());
                    } catch (ClassCastException e) {
                        throw new c6.c(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e);
                    }
                }
                this.c.endObject();
                return this;
            }
            c6.e eVar = (c6.e) this.d.get(obj.getClass());
            if (eVar != null) {
                return o(eVar, obj, z);
            }
            g gVar = (g) this.e.get(obj.getClass());
            if (gVar != null) {
                gVar.encode(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return o(this.f, obj, z);
            }
            if (obj instanceof f) {
                b(((f) obj).getNumber());
            } else {
                add(((Enum) obj).name());
            }
            return this;
        }
        if (obj instanceof byte[]) {
            return l((byte[]) obj);
        }
        this.c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                this.c.value(r7[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                c(jArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                this.c.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                this.c.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                d(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                d(obj2, false);
            }
        }
        this.c.endArray();
        return this;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e add(String str) {
        r();
        this.c.value(str);
        return this;
    }

    public e f(String str, double d) {
        r();
        this.c.name(str);
        return a(d);
    }

    public e g(String str, int i) {
        r();
        this.c.name(str);
        return b(i);
    }

    public e h(String str, long j) {
        r();
        this.c.name(str);
        return c(j);
    }

    public e i(String str, Object obj) {
        return this.g ? q(str, obj) : p(str, obj);
    }

    public e j(String str, boolean z) {
        r();
        this.c.name(str);
        return add(z);
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public e add(boolean z) {
        r();
        this.c.value(z);
        return this;
    }

    public e l(byte[] bArr) {
        r();
        if (bArr == null) {
            this.c.nullValue();
        } else {
            this.c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public final boolean m(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    public void n() {
        r();
        this.c.flush();
    }

    public e o(c6.e eVar, Object obj, boolean z) {
        if (!z) {
            this.c.beginObject();
        }
        eVar.encode(obj, this);
        if (!z) {
            this.c.endObject();
        }
        return this;
    }

    public final e p(String str, Object obj) {
        r();
        this.c.name(str);
        if (obj != null) {
            return d(obj, false);
        }
        this.c.nullValue();
        return this;
    }

    public final e q(String str, Object obj) {
        if (obj == null) {
            return this;
        }
        r();
        this.c.name(str);
        return d(obj, false);
    }

    public final void r() {
        if (!this.b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.a;
        if (eVar != null) {
            eVar.r();
            this.a.b = false;
            this.a = null;
            this.c.endObject();
        }
    }

    public c6.f add(c6.d dVar, int i) {
        return g(dVar.b(), i);
    }

    public c6.f add(c6.d dVar, long j) {
        return h(dVar.b(), j);
    }

    public c6.f add(c6.d dVar, Object obj) {
        return i(dVar.b(), obj);
    }

    public c6.f add(c6.d dVar, boolean z) {
        return j(dVar.b(), z);
    }
}
