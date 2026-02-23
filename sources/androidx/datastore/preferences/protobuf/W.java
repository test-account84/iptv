package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.y;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class w extends androidx.datastore.preferences.protobuf.a {
    private static Map defaultInstanceMap = new ConcurrentHashMap();
    protected m0 unknownFields = m0.e();
    protected int memoizedSerializedSize = -1;

    public static abstract class a extends a.a {
        public final w a;
        public w c;
        public boolean d = false;

        public a(w wVar) {
            this.a = wVar;
            this.c = (w) wVar.p(d.NEW_MUTABLE_INSTANCE);
        }

        public final w l() {
            w r = r();
            if (r.x()) {
                return r;
            }
            throw a.a.k(r);
        }

        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public w r() {
            if (this.d) {
                return this.c;
            }
            this.c.z();
            this.d = true;
            return this.c;
        }

        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a e = f().e();
            e.s(r());
            return e;
        }

        public void o() {
            if (this.d) {
                w wVar = (w) this.c.p(d.NEW_MUTABLE_INSTANCE);
                t(wVar, this.c);
                this.c = wVar;
                this.d = false;
            }
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public w f() {
            return this.a;
        }

        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public a i(w wVar) {
            return s(wVar);
        }

        public a s(w wVar) {
            o();
            t(this.c, wVar);
            return this;
        }

        public final void t(w wVar, w wVar2) {
            a0.a().d(wVar).a(wVar, wVar2);
        }
    }

    public static class b extends androidx.datastore.preferences.protobuf.b {
        public final w b;

        public b(w wVar) {
            this.b = wVar;
        }
    }

    public static class c extends m {
    }

    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static y.b A(y.b bVar) {
        int size = bVar.size();
        return bVar.w(size == 0 ? 10 : size * 2);
    }

    public static Object C(O o, String str, Object[] objArr) {
        return new c0(o, str, objArr);
    }

    public static w D(w wVar, InputStream inputStream) {
        return n(E(wVar, h.f(inputStream), o.b()));
    }

    public static w E(w wVar, h hVar, o oVar) {
        w wVar2 = (w) wVar.p(d.NEW_MUTABLE_INSTANCE);
        try {
            e0 d2 = a0.a().d(wVar2);
            d2.b(wVar2, i.P(hVar), oVar);
            d2.c(wVar2);
            return wVar2;
        } catch (IOException e) {
            if (e.getCause() instanceof z) {
                throw e.getCause();
            }
            throw new z(e.getMessage()).i(wVar2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof z) {
                throw e2.getCause();
            }
            throw e2;
        }
    }

    public static void F(Class cls, w wVar) {
        defaultInstanceMap.put(cls, wVar);
    }

    public static w n(w wVar) {
        if (wVar == null || wVar.x()) {
            return wVar;
        }
        throw wVar.j().a().i(wVar);
    }

    public static y.b t() {
        return b0.f();
    }

    public static w u(Class cls) {
        w wVar = (w) defaultInstanceMap.get(cls);
        if (wVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                wVar = (w) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (wVar == null) {
            wVar = ((w) p0.i(cls)).f();
            if (wVar == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, wVar);
        }
        return wVar;
    }

    public static Object w(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            Error cause = e.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw cause;
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        }
    }

    public static final boolean y(w wVar, boolean z) {
        byte byteValue = ((Byte) wVar.p(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = a0.a().d(wVar).d(wVar);
        if (z) {
            wVar.q(d.SET_MEMOIZED_IS_INITIALIZED, d2 ? wVar : null);
        }
        return d2;
    }

    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final a e() {
        return (a) p(d.NEW_BUILDER);
    }

    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final a b() {
        a aVar = (a) p(d.NEW_BUILDER);
        aVar.s(this);
        return aVar;
    }

    public int d() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = a0.a().d(this).e(this);
        }
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (f().getClass().isInstance(obj)) {
            return a0.a().d(this).i(this, (w) obj);
        }
        return false;
    }

    public void g(j jVar) {
        a0.a().d(this).h(this, k.P(jVar));
    }

    public int h() {
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int g = a0.a().d(this).g(this);
        this.memoizedHashCode = g;
        return g;
    }

    public void k(int i) {
        this.memoizedSerializedSize = i;
    }

    public Object m() {
        return p(d.BUILD_MESSAGE_INFO);
    }

    public final a o() {
        return (a) p(d.NEW_BUILDER);
    }

    public Object p(d dVar) {
        return s(dVar, null, null);
    }

    public Object q(d dVar, Object obj) {
        return s(dVar, obj, null);
    }

    public abstract Object s(d dVar, Object obj, Object obj2);

    public String toString() {
        return Q.e(this, super.toString());
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final w f() {
        return (w) p(d.GET_DEFAULT_INSTANCE);
    }

    public final boolean x() {
        return y(this, true);
    }

    public void z() {
        a0.a().d(this).c(this);
    }
}
