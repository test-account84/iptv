package com.google.ads.interactivemedia.v3.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bqn extends bon {
    private static final Map a = new ConcurrentHashMap();
    private int d = -1;
    protected bsx c = bsx.c();

    public static bqn aB(bqn bqnVar, bpb bpbVar) throws bqw {
        bqb bqbVar = bqb.a;
        bpg l = bpbVar.l();
        bqn aA = bqnVar.aA();
        try {
            bsi c = bsa.a().c(aA);
            c.h(aA, bpi.q(l), bqbVar);
            c.f(aA);
            l.z(0);
            e(aA);
            e(aA);
            return aA;
        } catch (bqw e) {
            if (e.k()) {
                throw new bqw(e);
            }
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof bqw) {
                throw e2.getCause();
            }
            throw new bqw(e2);
        } catch (bsw e3) {
            throw e3.a();
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof bqw) {
                throw e4.getCause();
            }
            throw e4;
        }
    }

    public static bqn aC(bqn bqnVar, bpb bpbVar, bqb bqbVar) throws bqw {
        bpg l = bpbVar.l();
        bqn aA = bqnVar.aA();
        try {
            bsi c = bsa.a().c(aA);
            c.h(aA, bpi.q(l), bqbVar);
            c.f(aA);
            l.z(0);
            e(aA);
            return aA;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof bqw) {
                throw e.getCause();
            }
            throw e;
        } catch (bqw e2) {
            if (e2.k()) {
                throw new bqw(e2);
            }
            throw e2;
        } catch (bsw e3) {
            throw e3.a();
        } catch (IOException e4) {
            if (e4.getCause() instanceof bqw) {
                throw e4.getCause();
            }
            throw new bqw(e4);
        }
    }

    public static bqn aD(bqn bqnVar, byte[] bArr, bqb bqbVar) throws bqw {
        bqn f = f(bqnVar, bArr, bArr.length, bqbVar);
        e(f);
        return f;
    }

    public static bqs aE() {
        return bqo.f();
    }

    public static bqt aF() {
        return bsb.e();
    }

    public static bqt aG(bqt bqtVar) {
        int size = bqtVar.size();
        return bqtVar.d(size == 0 ? 10 : size + size);
    }

    public static Object aH(Method method, Object obj, Object... objArr) {
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

    public static Object aI(brs brsVar, String str, Object[] objArr) {
        return new bsc(brsVar, str, objArr);
    }

    public static void aL(Class cls, bqn bqnVar) {
        a.put(cls, bqnVar);
        bqnVar.aJ();
    }

    public static final boolean aN(bqn bqnVar, boolean z) {
        byte byteValue = ((Byte) bqnVar.aP(1)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean l = bsa.a().c(bqnVar).l(bqnVar);
        if (z) {
            bqnVar.i(2, true != l ? null : bqnVar);
        }
        return l;
    }

    public static bpz aQ(brs brsVar, Object obj, brs brsVar2, bqq bqqVar, int i, btk btkVar, Class cls) {
        return new bpz(brsVar, brsVar2, new bqm(bqqVar, i, btkVar, false));
    }

    public static bpz aR(brs brsVar, brs brsVar2, int i, btk btkVar, Class cls) {
        Collections.emptyList();
        return new bpz(brsVar, brsVar2, new bqm(null, i, btkVar, true));
    }

    public static bqn az(Class cls) {
        Map map = a;
        bqn bqnVar = (bqn) map.get(cls);
        if (bqnVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                bqnVar = (bqn) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (bqnVar == null) {
            bqnVar = (bqn) ((bqn) btf.g(cls)).aP(6);
            if (bqnVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, bqnVar);
        }
        return bqnVar;
    }

    private final int c(bsi bsiVar) {
        return bsiVar == null ? bsa.a().c(this).a(this) : bsiVar.a(this);
    }

    private static void e(bqn bqnVar) throws bqw {
        if (bqnVar != null && !bqnVar.bd()) {
            throw new bsw().a();
        }
    }

    private static bqn f(bqn bqnVar, byte[] bArr, int i, bqb bqbVar) throws bqw {
        bqn aA = bqnVar.aA();
        try {
            bsi c = bsa.a().c(aA);
            c.i(aA, bArr, 0, i, new boq(bqbVar));
            c.f(aA);
            return aA;
        } catch (IndexOutOfBoundsException unused) {
            throw bqw.i();
        } catch (bqw e) {
            if (e.k()) {
                throw new bqw(e);
            }
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof bqw) {
                throw e2.getCause();
            }
            throw new bqw(e2);
        } catch (bsw e3) {
            throw e3.a();
        }
    }

    public final bqn aA() {
        return (bqn) aP(4);
    }

    public final void aJ() {
        bsa.a().c(this).f(this);
        aK();
    }

    public final void aK() {
        this.d &= Integer.MAX_VALUE;
    }

    public final void aM(int i) {
        this.d = (this.d & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean aO() {
        return (this.d & Integer.MIN_VALUE) != 0;
    }

    public final Object aP(int i) {
        return i(i, null);
    }

    public final int at(bsi bsiVar) {
        if (aO()) {
            int c = c(bsiVar);
            if (c >= 0) {
                return c;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + c);
        }
        int i = this.d & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int c2 = c(bsiVar);
        if (c2 >= 0) {
            this.d = (this.d & Integer.MIN_VALUE) | c2;
            return c2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + c2);
    }

    public final int aw() {
        return bsa.a().c(this).b(this);
    }

    public final int ax() {
        int i;
        if (aO()) {
            i = c(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.d & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = c(null);
                if (i < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
                this.d = (this.d & Integer.MIN_VALUE) | i;
            }
        }
        return i;
    }

    public final bqj ay() {
        return (bqj) aP(5);
    }

    public final /* synthetic */ brs ba() {
        return (bqn) aP(6);
    }

    public final boolean bd() {
        return aN(this, true);
    }

    public final /* synthetic */ brr bp() {
        return (bqj) aP(5);
    }

    public final /* synthetic */ brr bq() {
        bqj bqjVar = (bqj) aP(5);
        bqjVar.be(this);
        return bqjVar;
    }

    public final void br(bpk bpkVar) throws IOException {
        bsa.a().c(this).j(this, bpl.a(bpkVar));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return bsa.a().c(this).k(this, (bqn) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (aO()) {
            return aw();
        }
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int aw = aw();
        this.b = aw;
        return aw;
    }

    public abstract Object i(int i, Object obj);

    public final String toString() {
        return bru.a(this, super.toString());
    }
}
