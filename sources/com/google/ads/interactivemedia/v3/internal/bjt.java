package com.google.ads.interactivemedia.v3.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bjt {
    static final bkj a;
    static final bkj b;
    public static final /* synthetic */ int e = 0;
    final List c;
    final boolean d;
    private final ThreadLocal f;
    private final ConcurrentMap g;
    private final bkw h;
    private final bma i;

    static {
        bjl bjlVar = bjl.IDENTITY;
        a = bki.a;
        b = bki.b;
    }

    public bjt() {
        bky bkyVar = bky.a;
        throw null;
    }

    public static void h(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final bkl a(bof bofVar) {
        boolean z;
        bkl bklVar = (bkl) this.g.get(bofVar);
        if (bklVar != null) {
            return bklVar;
        }
        HashMap hashMap = (Map) this.f.get();
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f.set(hashMap);
            z = true;
        } else {
            z = false;
        }
        bjs bjsVar = (bjs) hashMap.get(bofVar);
        if (bjsVar != null) {
            return bjsVar;
        }
        try {
            bjs bjsVar2 = new bjs();
            hashMap.put(bofVar, bjsVar2);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                bkl a2 = ((bkm) it.next()).a(this, bofVar);
                if (a2 != null) {
                    bkl bklVar2 = (bkl) this.g.putIfAbsent(bofVar, a2);
                    if (bklVar2 != null) {
                        a2 = bklVar2;
                    }
                    bjsVar2.a(a2);
                    return a2;
                }
            }
            throw new IllegalArgumentException("GSON (${project.version}) cannot handle " + bofVar.toString());
        } finally {
            hashMap.remove(bofVar);
            if (z) {
                this.f.remove();
            }
        }
    }

    public final bkl b(Class cls) {
        return a(bof.a(cls));
    }

    public final bkl c(bkm bkmVar, bof bofVar) {
        if (!this.c.contains(bkmVar)) {
            bkmVar = this.i;
        }
        boolean z = false;
        for (bkm bkmVar2 : this.c) {
            if (z) {
                bkl a2 = bkmVar2.a(this, bofVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (bkmVar2 == bkmVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(bofVar)));
    }

    public final boj d(Writer writer) throws IOException {
        boj bojVar = new boj(writer);
        bojVar.n(this.d);
        bojVar.o(false);
        bojVar.p(false);
        return bojVar;
    }

    public final Object e(boh bohVar, bof bofVar) throws bjz, bkf {
        boolean v = bohVar.v();
        boolean z = true;
        bohVar.u(true);
        try {
            try {
                try {
                    try {
                        bohVar.r();
                        try {
                            return a(bofVar).read(bohVar);
                        } catch (EOFException e2) {
                            e = e2;
                            z = false;
                            if (!z) {
                                throw new bkf((Throwable) e);
                            }
                            bohVar.u(v);
                            return null;
                        }
                    } finally {
                        bohVar.u(v);
                    }
                } catch (EOFException e3) {
                    e = e3;
                }
            } catch (IllegalStateException e4) {
                throw new bkf((Throwable) e4);
            }
        } catch (AssertionError e5) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON ${project.version}): " + e5.getMessage());
            assertionError.initCause(e5);
            throw assertionError;
        } catch (IOException e6) {
            throw new bkf((Throwable) e6);
        }
    }

    public final Object f(String str, Class cls) throws bkf {
        Object obj;
        bof a2 = bof.a(cls);
        if (str == null) {
            obj = null;
        } else {
            boh bohVar = new boh(new StringReader(str));
            bohVar.u(false);
            Object e2 = e(bohVar, a2);
            if (e2 != null) {
                try {
                    if (bohVar.r() != 10) {
                        throw new bkf("JSON document was not fully consumed.");
                    }
                } catch (bok e3) {
                    throw new bkf((Throwable) e3);
                } catch (IOException e4) {
                    throw new bjz((Throwable) e4);
                }
            }
            obj = e2;
        }
        if (cls == Integer.TYPE) {
            cls = Integer.class;
        } else if (cls == Float.TYPE) {
            cls = Float.class;
        } else if (cls == Byte.TYPE) {
            cls = Byte.class;
        } else if (cls == Double.TYPE) {
            cls = Double.class;
        } else if (cls == Long.TYPE) {
            cls = Long.class;
        } else if (cls == Character.TYPE) {
            cls = Character.class;
        } else if (cls == Boolean.TYPE) {
            cls = Boolean.class;
        } else if (cls == Short.TYPE) {
            cls = Short.class;
        } else if (cls == Void.TYPE) {
            cls = Void.class;
        }
        return cls.cast(obj);
    }

    public final String g(Object obj) {
        if (obj == null) {
            bka bkaVar = bka.a;
            StringWriter stringWriter = new StringWriter();
            try {
                i(bkaVar, d(stringWriter));
                return stringWriter.toString();
            } catch (IOException e2) {
                throw new bjz((Throwable) e2);
            }
        }
        Class cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            j(obj, cls, d(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e3) {
            throw new bjz((Throwable) e3);
        }
    }

    public final void i(bjy bjyVar, boj bojVar) throws bjz {
        boolean s = bojVar.s();
        bojVar.o(true);
        boolean r = bojVar.r();
        bojVar.n(this.d);
        boolean q = bojVar.q();
        bojVar.p(false);
        try {
            try {
                blo.b(bjyVar, bojVar);
            } catch (IOException e2) {
                throw new bjz((Throwable) e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON ${project.version}): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            bojVar.o(s);
            bojVar.n(r);
            bojVar.p(q);
        }
    }

    public final void j(Object obj, Type type, boj bojVar) throws bjz {
        bkl a2 = a(bof.b(type));
        boolean s = bojVar.s();
        bojVar.o(true);
        boolean r = bojVar.r();
        bojVar.n(this.d);
        boolean q = bojVar.q();
        bojVar.p(false);
        try {
            try {
                a2.write(bojVar, obj);
            } catch (IOException e2) {
                throw new bjz((Throwable) e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON ${project.version}): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            bojVar.o(s);
            bojVar.n(r);
            bojVar.p(q);
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.c + ",instanceCreators:" + this.h + "}";
    }

    public bjt(bky bkyVar, bjm bjmVar, Map map, boolean z, boolean z2, int i, List list, bkj bkjVar, bkj bkjVar2, List list2) {
        this.f = new ThreadLocal();
        this.g = new ConcurrentHashMap();
        bkw bkwVar = new bkw(map, true, list2);
        this.h = bkwVar;
        this.d = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(bnw.U);
        arrayList.add(bmi.a(bkjVar));
        arrayList.add(bkyVar);
        arrayList.addAll(list);
        arrayList.add(bnw.A);
        arrayList.add(bnw.m);
        arrayList.add(bnw.g);
        arrayList.add(bnw.i);
        arrayList.add(bnw.k);
        bkl bjpVar = i == bkg.a ? bnw.t : new bjp();
        arrayList.add(bnw.c(Long.TYPE, Long.class, bjpVar));
        arrayList.add(bnw.c(Double.TYPE, Double.class, new bjn()));
        arrayList.add(bnw.c(Float.TYPE, Float.class, new bjo()));
        arrayList.add(bmg.a(bkjVar2));
        arrayList.add(bnw.o);
        arrayList.add(bnw.q);
        arrayList.add(bnw.b(AtomicLong.class, new bjq(bjpVar).nullSafe()));
        arrayList.add(bnw.b(AtomicLongArray.class, new bjr(bjpVar).nullSafe()));
        arrayList.add(bnw.s);
        arrayList.add(bnw.v);
        arrayList.add(bnw.C);
        arrayList.add(bnw.E);
        arrayList.add(bnw.b(BigDecimal.class, bnw.x));
        arrayList.add(bnw.b(BigInteger.class, bnw.y));
        arrayList.add(bnw.b(blb.class, bnw.z));
        arrayList.add(bnw.G);
        arrayList.add(bnw.I);
        arrayList.add(bnw.M);
        arrayList.add(bnw.O);
        arrayList.add(bnw.S);
        arrayList.add(bnw.K);
        arrayList.add(bnw.d);
        arrayList.add(blx.a);
        arrayList.add(bnw.Q);
        if (boe.a) {
            arrayList.add(boe.e);
            arrayList.add(boe.d);
            arrayList.add(boe.f);
        }
        arrayList.add(blu.a);
        arrayList.add(bnw.b);
        arrayList.add(new bma(bkwVar, 1));
        arrayList.add(new bma(bkwVar, 2));
        bma bmaVar = new bma(bkwVar, 0);
        this.i = bmaVar;
        arrayList.add(bmaVar);
        arrayList.add(bnw.V);
        arrayList.add(new bml(bkwVar, bjmVar, bkyVar, bmaVar, list2));
        this.c = Collections.unmodifiableList(arrayList);
    }
}
