package com.nytimes.android.external.cache;

import com.nytimes.android.external.cache.e;
import com.nytimes.android.external.cache.f;
import j$.util.concurrent.ConcurrentMap;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class k extends AbstractMap implements ConcurrentMap, j$.util.concurrent.ConcurrentMap {
    public static final Logger v = Logger.getLogger(k.class.getName());
    public static final y w = new a();
    public static final Queue x = new b();
    public final int a;
    public final int c;
    public final p[] d;
    public final int e;
    public final com.nytimes.android.external.cache.h f;
    public final com.nytimes.android.external.cache.h g;
    public final r h;
    public final r i;
    public final long j;
    public final com.nytimes.android.external.cache.x k;
    public final long l;
    public final long m;
    public final long n;
    public final Queue o;
    public final com.nytimes.android.external.cache.q p;
    public final com.nytimes.android.external.cache.u q;
    public final f r;
    public Set s;
    public Collection t;
    public Set u;

    public static final class A extends C {
        public volatile long e;
        public o f;
        public o g;

        public A(ReferenceQueue referenceQueue, Object obj, int i, o oVar) {
            super(referenceQueue, obj, i, oVar);
            this.e = Long.MAX_VALUE;
            this.f = k.r();
            this.g = k.r();
        }

        public long getAccessTime() {
            return this.e;
        }

        public o getNextInAccessQueue() {
            return this.f;
        }

        public o getPreviousInAccessQueue() {
            return this.g;
        }

        public void setAccessTime(long j) {
            this.e = j;
        }

        public void setNextInAccessQueue(o oVar) {
            this.f = oVar;
        }

        public void setPreviousInAccessQueue(o oVar) {
            this.g = oVar;
        }
    }

    public static final class B extends C {
        public volatile long e;
        public o f;
        public o g;
        public volatile long h;
        public o i;
        public o j;

        public B(ReferenceQueue referenceQueue, Object obj, int i, o oVar) {
            super(referenceQueue, obj, i, oVar);
            this.e = Long.MAX_VALUE;
            this.f = k.r();
            this.g = k.r();
            this.h = Long.MAX_VALUE;
            this.i = k.r();
            this.j = k.r();
        }

        public long getAccessTime() {
            return this.e;
        }

        public o getNextInAccessQueue() {
            return this.f;
        }

        public o getNextInWriteQueue() {
            return this.i;
        }

        public o getPreviousInAccessQueue() {
            return this.g;
        }

        public o getPreviousInWriteQueue() {
            return this.j;
        }

        public long getWriteTime() {
            return this.h;
        }

        public void setAccessTime(long j) {
            this.e = j;
        }

        public void setNextInAccessQueue(o oVar) {
            this.f = oVar;
        }

        public void setNextInWriteQueue(o oVar) {
            this.i = oVar;
        }

        public void setPreviousInAccessQueue(o oVar) {
            this.g = oVar;
        }

        public void setPreviousInWriteQueue(o oVar) {
            this.j = oVar;
        }

        public void setWriteTime(long j) {
            this.h = j;
        }
    }

    public static class C extends WeakReference implements o {
        public final int a;
        public final o c;
        public volatile y d;

        public C(ReferenceQueue referenceQueue, Object obj, int i, o oVar) {
            super(obj, referenceQueue);
            this.d = k.F();
            this.a = i;
            this.c = oVar;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public int getHash() {
            return this.a;
        }

        public Object getKey() {
            return get();
        }

        public o getNext() {
            return this.c;
        }

        public o getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public o getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public o getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public o getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public y getValueReference() {
            return this.d;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(o oVar) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(o oVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(o oVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(o oVar) {
            throw new UnsupportedOperationException();
        }

        public void setValueReference(y yVar) {
            this.d = yVar;
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    public static class D extends WeakReference implements y {
        public final o a;

        public D(ReferenceQueue referenceQueue, Object obj, o oVar) {
            super(obj, referenceQueue);
            this.a = oVar;
        }

        public void a(Object obj) {
        }

        public boolean b() {
            return false;
        }

        public int c() {
            return 1;
        }

        public y d(ReferenceQueue referenceQueue, Object obj, o oVar) {
            return new D(referenceQueue, obj, oVar);
        }

        public o getEntry() {
            return this.a;
        }

        public boolean isActive() {
            return true;
        }
    }

    public static final class E extends C {
        public volatile long e;
        public o f;
        public o g;

        public E(ReferenceQueue referenceQueue, Object obj, int i, o oVar) {
            super(referenceQueue, obj, i, oVar);
            this.e = Long.MAX_VALUE;
            this.f = k.r();
            this.g = k.r();
        }

        public o getNextInWriteQueue() {
            return this.f;
        }

        public o getPreviousInWriteQueue() {
            return this.g;
        }

        public long getWriteTime() {
            return this.e;
        }

        public void setNextInWriteQueue(o oVar) {
            this.f = oVar;
        }

        public void setPreviousInWriteQueue(o oVar) {
            this.g = oVar;
        }

        public void setWriteTime(long j) {
            this.e = j;
        }
    }

    public static final class F extends q {
        public final int c;

        public F(ReferenceQueue referenceQueue, Object obj, o oVar, int i) {
            super(referenceQueue, obj, oVar);
            this.c = i;
        }

        public int c() {
            return this.c;
        }

        public y d(ReferenceQueue referenceQueue, Object obj, o oVar) {
            return new F(referenceQueue, obj, oVar, this.c);
        }
    }

    public static final class G extends v {
        public final int c;

        public G(Object obj, int i) {
            super(obj);
            this.c = i;
        }

        public int c() {
            return this.c;
        }
    }

    public static final class H extends D {
        public final int c;

        public H(ReferenceQueue referenceQueue, Object obj, o oVar, int i) {
            super(referenceQueue, obj, oVar);
            this.c = i;
        }

        public int c() {
            return this.c;
        }

        public y d(ReferenceQueue referenceQueue, Object obj, o oVar) {
            return new H(referenceQueue, obj, oVar, this.c);
        }
    }

    public static final class I extends AbstractQueue {
        public final o a = new a();

        public class a extends d {
            public o a = this;
            public o c = this;

            public a() {
            }

            public o getNextInWriteQueue() {
                return this.a;
            }

            public o getPreviousInWriteQueue() {
                return this.c;
            }

            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            public void setNextInWriteQueue(o oVar) {
                this.a = oVar;
            }

            public void setPreviousInWriteQueue(o oVar) {
                this.c = oVar;
            }

            public void setWriteTime(long j) {
            }
        }

        public class b extends com.nytimes.android.external.cache.b {
            public b(o oVar) {
                super(oVar);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public o a(o oVar) {
                o nextInWriteQueue = oVar.getNextInWriteQueue();
                if (nextInWriteQueue == I.this.a) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(o oVar) {
            k.d(oVar.getPreviousInWriteQueue(), oVar.getNextInWriteQueue());
            k.d(this.a.getPreviousInWriteQueue(), oVar);
            k.d(oVar, this.a);
            return true;
        }

        public void clear() {
            o nextInWriteQueue = this.a.getNextInWriteQueue();
            while (true) {
                o oVar = this.a;
                if (nextInWriteQueue == oVar) {
                    oVar.setNextInWriteQueue(oVar);
                    o oVar2 = this.a;
                    oVar2.setPreviousInWriteQueue(oVar2);
                    return;
                } else {
                    o nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    k.t(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                }
            }
        }

        public boolean contains(Object obj) {
            return ((o) obj).getNextInWriteQueue() != n.INSTANCE;
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public o peek() {
            o nextInWriteQueue = this.a.getNextInWriteQueue();
            if (nextInWriteQueue == this.a) {
                return null;
            }
            return nextInWriteQueue;
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public o poll() {
            o nextInWriteQueue = this.a.getNextInWriteQueue();
            if (nextInWriteQueue == this.a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        public boolean isEmpty() {
            return this.a.getNextInWriteQueue() == this.a;
        }

        public Iterator iterator() {
            return new b(peek());
        }

        public boolean remove(Object obj) {
            o oVar = (o) obj;
            o previousInWriteQueue = oVar.getPreviousInWriteQueue();
            o nextInWriteQueue = oVar.getNextInWriteQueue();
            k.d(previousInWriteQueue, nextInWriteQueue);
            k.t(oVar);
            return nextInWriteQueue != n.INSTANCE;
        }

        public int size() {
            int i = 0;
            for (o nextInWriteQueue = this.a.getNextInWriteQueue(); nextInWriteQueue != this.a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }
    }

    public final class J implements Map.Entry {
        public final Object a;
        public Object c;

        public J(Object obj, Object obj2) {
            this.a = obj;
            this.c = obj2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.a.equals(entry.getKey()) && this.c.equals(entry.getValue());
        }

        public Object getKey() {
            return this.a;
        }

        public Object getValue() {
            return this.c;
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.c.hashCode();
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public class a implements y {
        public void a(Object obj) {
        }

        public boolean b() {
            return false;
        }

        public int c() {
            return 0;
        }

        public y d(ReferenceQueue referenceQueue, Object obj, o oVar) {
            return this;
        }

        public Object get() {
            return null;
        }

        public o getEntry() {
            return null;
        }

        public boolean isActive() {
            return false;
        }
    }

    public class b extends AbstractQueue {
        public Iterator iterator() {
            return new HashSet().iterator();
        }

        public boolean offer(Object obj) {
            return true;
        }

        public Object peek() {
            return null;
        }

        public Object poll() {
            return null;
        }

        public int size() {
            return 0;
        }
    }

    public abstract class c extends AbstractSet {
        public final ConcurrentMap a;

        public c(ConcurrentMap concurrentMap) {
            this.a = concurrentMap;
        }

        public void clear() {
            this.a.clear();
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        public int size() {
            return this.a.size();
        }

        public Object[] toArray() {
            return k.a(this).toArray();
        }

        public Object[] toArray(Object[] objArr) {
            return k.a(this).toArray(objArr);
        }
    }

    public static abstract class d implements o {
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public int getHash() {
            throw new UnsupportedOperationException();
        }

        public Object getKey() {
            throw new UnsupportedOperationException();
        }

        public o getNext() {
            throw new UnsupportedOperationException();
        }

        public o getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public o getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public o getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public o getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public y getValueReference() {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(o oVar) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(o oVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(o oVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(o oVar) {
            throw new UnsupportedOperationException();
        }

        public void setValueReference(y yVar) {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class e extends AbstractQueue {
        public final o a = new a();

        public class a extends d {
            public o a = this;
            public o c = this;

            public a() {
            }

            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            public o getNextInAccessQueue() {
                return this.a;
            }

            public o getPreviousInAccessQueue() {
                return this.c;
            }

            public void setAccessTime(long j) {
            }

            public void setNextInAccessQueue(o oVar) {
                this.a = oVar;
            }

            public void setPreviousInAccessQueue(o oVar) {
                this.c = oVar;
            }
        }

        public class b extends com.nytimes.android.external.cache.b {
            public b(o oVar) {
                super(oVar);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public o a(o oVar) {
                o nextInAccessQueue = oVar.getNextInAccessQueue();
                if (nextInAccessQueue == e.this.a) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(o oVar) {
            k.c(oVar.getPreviousInAccessQueue(), oVar.getNextInAccessQueue());
            k.c(this.a.getPreviousInAccessQueue(), oVar);
            k.c(oVar, this.a);
            return true;
        }

        public void clear() {
            o nextInAccessQueue = this.a.getNextInAccessQueue();
            while (true) {
                o oVar = this.a;
                if (nextInAccessQueue == oVar) {
                    oVar.setNextInAccessQueue(oVar);
                    o oVar2 = this.a;
                    oVar2.setPreviousInAccessQueue(oVar2);
                    return;
                } else {
                    o nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    k.s(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                }
            }
        }

        public boolean contains(Object obj) {
            return ((o) obj).getNextInAccessQueue() != n.INSTANCE;
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public o peek() {
            o nextInAccessQueue = this.a.getNextInAccessQueue();
            if (nextInAccessQueue == this.a) {
                return null;
            }
            return nextInAccessQueue;
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public o poll() {
            o nextInAccessQueue = this.a.getNextInAccessQueue();
            if (nextInAccessQueue == this.a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        public boolean isEmpty() {
            return this.a.getNextInAccessQueue() == this.a;
        }

        public Iterator iterator() {
            return new b(peek());
        }

        public boolean remove(Object obj) {
            o oVar = (o) obj;
            o previousInAccessQueue = oVar.getPreviousInAccessQueue();
            o nextInAccessQueue = oVar.getNextInAccessQueue();
            k.c(previousInAccessQueue, nextInAccessQueue);
            k.s(oVar);
            return nextInAccessQueue != n.INSTANCE;
        }

        public int size() {
            int i = 0;
            for (o nextInAccessQueue = this.a.getNextInAccessQueue(); nextInAccessQueue != this.a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class f {
        private static final /* synthetic */ f[] $VALUES;
        static final int ACCESS_MASK = 1;
        public static final f STRONG;
        public static final f STRONG_ACCESS;
        public static final f STRONG_ACCESS_WRITE;
        public static final f STRONG_WRITE;
        public static final f WEAK;
        public static final f WEAK_ACCESS;
        public static final f WEAK_ACCESS_WRITE;
        static final int WEAK_MASK = 4;
        public static final f WEAK_WRITE;
        static final int WRITE_MASK = 2;
        static final f[] factories;

        public enum a extends f {
            public a(String str, int i) {
                super(str, i, null);
            }

            public o newEntry(p pVar, Object obj, int i, o oVar) {
                return new u(obj, i, oVar);
            }
        }

        public enum b extends f {
            public b(String str, int i) {
                super(str, i, null);
            }

            public o copyEntry(p pVar, o oVar, o oVar2) {
                o copyEntry = super.copyEntry(pVar, oVar, oVar2);
                copyAccessEntry(oVar, copyEntry);
                return copyEntry;
            }

            public o newEntry(p pVar, Object obj, int i, o oVar) {
                return new s(obj, i, oVar);
            }
        }

        public enum c extends f {
            public c(String str, int i) {
                super(str, i, null);
            }

            public o copyEntry(p pVar, o oVar, o oVar2) {
                o copyEntry = super.copyEntry(pVar, oVar, oVar2);
                copyWriteEntry(oVar, copyEntry);
                return copyEntry;
            }

            public o newEntry(p pVar, Object obj, int i, o oVar) {
                return new w(obj, i, oVar);
            }
        }

        public enum d extends f {
            public d(String str, int i) {
                super(str, i, null);
            }

            public o copyEntry(p pVar, o oVar, o oVar2) {
                o copyEntry = super.copyEntry(pVar, oVar, oVar2);
                copyAccessEntry(oVar, copyEntry);
                copyWriteEntry(oVar, copyEntry);
                return copyEntry;
            }

            public o newEntry(p pVar, Object obj, int i, o oVar) {
                return new t(obj, i, oVar);
            }
        }

        public enum e extends f {
            public e(String str, int i) {
                super(str, i, null);
            }

            public o newEntry(p pVar, Object obj, int i, o oVar) {
                return new C(pVar.i, obj, i, oVar);
            }
        }

        public enum f extends f {
            public f(String str, int i) {
                super(str, i, null);
            }

            public o copyEntry(p pVar, o oVar, o oVar2) {
                o copyEntry = super.copyEntry(pVar, oVar, oVar2);
                copyAccessEntry(oVar, copyEntry);
                return copyEntry;
            }

            public o newEntry(p pVar, Object obj, int i, o oVar) {
                return new A(pVar.i, obj, i, oVar);
            }
        }

        public enum g extends f {
            public g(String str, int i) {
                super(str, i, null);
            }

            public o copyEntry(p pVar, o oVar, o oVar2) {
                o copyEntry = super.copyEntry(pVar, oVar, oVar2);
                copyWriteEntry(oVar, copyEntry);
                return copyEntry;
            }

            public o newEntry(p pVar, Object obj, int i, o oVar) {
                return new E(pVar.i, obj, i, oVar);
            }
        }

        public enum h extends f {
            public h(String str, int i) {
                super(str, i, null);
            }

            public o copyEntry(p pVar, o oVar, o oVar2) {
                o copyEntry = super.copyEntry(pVar, oVar, oVar2);
                copyAccessEntry(oVar, copyEntry);
                copyWriteEntry(oVar, copyEntry);
                return copyEntry;
            }

            public o newEntry(p pVar, Object obj, int i, o oVar) {
                return new B(pVar.i, obj, i, oVar);
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            STRONG = aVar;
            b bVar = new b("STRONG_ACCESS", 1);
            STRONG_ACCESS = bVar;
            c cVar = new c("STRONG_WRITE", 2);
            STRONG_WRITE = cVar;
            d dVar = new d("STRONG_ACCESS_WRITE", 3);
            STRONG_ACCESS_WRITE = dVar;
            e eVar = new e("WEAK", 4);
            WEAK = eVar;
            f fVar = new f("WEAK_ACCESS", 5);
            WEAK_ACCESS = fVar;
            g gVar = new g("WEAK_WRITE", 6);
            WEAK_WRITE = gVar;
            h hVar = new h("WEAK_ACCESS_WRITE", 7);
            WEAK_ACCESS_WRITE = hVar;
            $VALUES = new f[]{aVar, bVar, cVar, dVar, eVar, fVar, gVar, hVar};
            factories = new f[]{aVar, bVar, cVar, dVar, eVar, fVar, gVar, hVar};
        }

        private f(String str, int i) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static f getFactory(r rVar, boolean z, boolean z2) {
            return factories[(rVar == r.WEAK ? (char) 4 : (char) 0) | (z ? 1 : 0) | (z2 ? 2 : 0)];
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) $VALUES.clone();
        }

        public void copyAccessEntry(o oVar, o oVar2) {
            oVar2.setAccessTime(oVar.getAccessTime());
            k.c(oVar.getPreviousInAccessQueue(), oVar2);
            k.c(oVar2, oVar.getNextInAccessQueue());
            k.s(oVar);
        }

        public o copyEntry(p pVar, o oVar, o oVar2) {
            return newEntry(pVar, oVar.getKey(), oVar.getHash(), oVar2);
        }

        public void copyWriteEntry(o oVar, o oVar2) {
            oVar2.setWriteTime(oVar.getWriteTime());
            k.d(oVar.getPreviousInWriteQueue(), oVar2);
            k.d(oVar2, oVar.getNextInWriteQueue());
            k.t(oVar);
        }

        public abstract o newEntry(p pVar, Object obj, int i, o oVar);

        public /* synthetic */ f(String str, int i, a aVar) {
            this(str, i);
        }
    }

    public final class g extends i {
        public g() {
            super();
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            return d();
        }
    }

    public final class h extends c {
        public h(ConcurrentMap concurrentMap) {
            super(concurrentMap);
        }

        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = k.this.get(key)) != null && k.this.g.d(entry.getValue(), obj2);
        }

        public Iterator iterator() {
            return k.this.new g();
        }

        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && k.this.remove(key, entry.getValue());
        }
    }

    public abstract class i implements Iterator {
        public int a;
        public int c = -1;
        public p d;
        public AtomicReferenceArray e;
        public o f;
        public J g;
        public J h;

        public i() {
            this.a = k.this.d.length - 1;
            b();
        }

        public final void b() {
            this.g = null;
            if (e() || f()) {
                return;
            }
            while (true) {
                int i = this.a;
                if (i < 0) {
                    return;
                }
                p[] pVarArr = k.this.d;
                this.a = i - 1;
                p pVar = pVarArr[i];
                this.d = pVar;
                if (pVar.c != 0) {
                    this.e = this.d.g;
                    this.c = r0.length() - 1;
                    if (f()) {
                        return;
                    }
                }
            }
        }

        public boolean c(o oVar) {
            try {
                long a = k.this.q.a();
                Object key = oVar.getKey();
                Object m = k.this.m(oVar, a);
                if (m == null) {
                    this.d.C();
                    return false;
                }
                this.g = k.this.new J(key, m);
                this.d.C();
                return true;
            } catch (Throwable th) {
                this.d.C();
                throw th;
            }
        }

        public J d() {
            J j = this.g;
            if (j == null) {
                throw new NoSuchElementException();
            }
            this.h = j;
            b();
            return this.h;
        }

        public boolean e() {
            o oVar = this.f;
            if (oVar == null) {
                return false;
            }
            while (true) {
                this.f = oVar.getNext();
                o oVar2 = this.f;
                if (oVar2 == null) {
                    return false;
                }
                if (c(oVar2)) {
                    return true;
                }
                oVar = this.f;
            }
        }

        public boolean f() {
            while (true) {
                int i = this.c;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.e;
                this.c = i - 1;
                o oVar = (o) atomicReferenceArray.get(i);
                this.f = oVar;
                if (oVar != null && (c(oVar) || e())) {
                    return true;
                }
            }
        }

        public boolean hasNext() {
            return this.g != null;
        }

        public void remove() {
            com.nytimes.android.external.cache.o.c(this.h != null);
            k.this.remove(this.h.getKey());
            this.h = null;
        }
    }

    public final class j extends i {
        public j() {
            super();
        }

        public Object next() {
            return d().getKey();
        }
    }

    public final class k extends c {
        public k(ConcurrentMap concurrentMap) {
            super(concurrentMap);
        }

        public boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        public Iterator iterator() {
            return k.this.new j();
        }

        public boolean remove(Object obj) {
            return this.a.remove(obj) != null;
        }
    }

    public static class l implements y {
        public volatile y a;
        public final com.nytimes.android.external.cache.s c;
        public final com.nytimes.android.external.cache.t d;

        public l() {
            this(k.F());
        }

        public void a(Object obj) {
            if (obj != null) {
                h(obj);
            } else {
                this.a = k.F();
            }
        }

        public boolean b() {
            return true;
        }

        public int c() {
            return this.a.c();
        }

        public y d(ReferenceQueue referenceQueue, Object obj, o oVar) {
            return this;
        }

        public final com.nytimes.android.external.cache.j e(Throwable th) {
            return com.nytimes.android.external.cache.i.a(th);
        }

        public y f() {
            return this.a;
        }

        public com.nytimes.android.external.cache.j g(Object obj, com.nytimes.android.external.cache.f fVar) {
            try {
                this.d.e();
                this.a.get().getClass();
                throw null;
            } catch (Throwable th) {
                com.nytimes.android.external.cache.j e = i(th) ? this.c : e(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return e;
            }
        }

        public Object get() {
            return this.a.get();
        }

        public o getEntry() {
            return null;
        }

        public boolean h(Object obj) {
            return this.c.r(obj);
        }

        public boolean i(Throwable th) {
            return this.c.s(th);
        }

        public boolean isActive() {
            return this.a.isActive();
        }

        public l(y yVar) {
            this.c = com.nytimes.android.external.cache.s.t();
            this.d = com.nytimes.android.external.cache.t.c();
            this.a = yVar;
        }
    }

    public static class m implements com.nytimes.android.external.cache.d, Serializable {
        public final k a;

        public m(com.nytimes.android.external.cache.e eVar) {
            this(new k(eVar, null));
        }

        public void a(Object obj) {
            com.nytimes.android.external.cache.o.a(obj);
            this.a.remove(obj);
        }

        public Object b(Object obj) {
            return this.a.k(obj);
        }

        public void c() {
            this.a.clear();
        }

        public void put(Object obj, Object obj2) {
            this.a.put(obj, obj2);
        }

        public m(k kVar) {
            this.a = kVar;
        }
    }

    public enum n implements o {
        INSTANCE;

        public long getAccessTime() {
            return 0L;
        }

        public int getHash() {
            return 0;
        }

        public Object getKey() {
            return null;
        }

        public o getNext() {
            return null;
        }

        public o getNextInAccessQueue() {
            return this;
        }

        public o getNextInWriteQueue() {
            return this;
        }

        public o getPreviousInAccessQueue() {
            return this;
        }

        public o getPreviousInWriteQueue() {
            return this;
        }

        public y getValueReference() {
            return null;
        }

        public long getWriteTime() {
            return 0L;
        }

        public void setAccessTime(long j) {
        }

        public void setNextInAccessQueue(o oVar) {
        }

        public void setNextInWriteQueue(o oVar) {
        }

        public void setPreviousInAccessQueue(o oVar) {
        }

        public void setPreviousInWriteQueue(o oVar) {
        }

        public void setValueReference(y yVar) {
        }

        public void setWriteTime(long j) {
        }
    }

    public interface o {
        long getAccessTime();

        int getHash();

        Object getKey();

        o getNext();

        o getNextInAccessQueue();

        o getNextInWriteQueue();

        o getPreviousInAccessQueue();

        o getPreviousInWriteQueue();

        y getValueReference();

        long getWriteTime();

        void setAccessTime(long j);

        void setNextInAccessQueue(o oVar);

        void setNextInWriteQueue(o oVar);

        void setPreviousInAccessQueue(o oVar);

        void setPreviousInWriteQueue(o oVar);

        void setValueReference(y yVar);

        void setWriteTime(long j);
    }

    public static class p extends ReentrantLock {
        public final k a;
        public volatile int c;
        public long d;
        public int e;
        public int f;
        public volatile AtomicReferenceArray g;
        public final long h;
        public final ReferenceQueue i;
        public final ReferenceQueue j;
        public final Queue k;
        public final AtomicInteger l = new AtomicInteger();
        public final Queue m;
        public final Queue n;

        public class a implements Runnable {
            public final /* synthetic */ Object a;
            public final /* synthetic */ int c;
            public final /* synthetic */ l d;
            public final /* synthetic */ com.nytimes.android.external.cache.j e;

            public a(Object obj, int i, l lVar, com.nytimes.android.external.cache.j jVar) {
                this.a = obj;
                this.c = i;
                this.d = lVar;
                this.e = jVar;
            }

            public void run() {
                try {
                    p.this.r(this.a, this.c, this.d, this.e);
                } catch (Throwable th) {
                    k.v.log(Level.WARNING, "Exception thrown during refresh", th);
                    this.d.i(th);
                }
            }
        }

        public p(k kVar, int i, long j) {
            this.a = kVar;
            this.h = j;
            x(B(i));
            this.i = kVar.I() ? new ReferenceQueue() : null;
            this.j = kVar.J() ? new ReferenceQueue() : null;
            this.k = kVar.H() ? new ConcurrentLinkedQueue() : k.g();
            this.m = kVar.L() ? new I() : k.g();
            this.n = kVar.H() ? new e() : k.g();
        }

        public o A(Object obj, int i, o oVar) {
            return this.a.r.newEntry(this, com.nytimes.android.external.cache.o.a(obj), i, oVar);
        }

        public AtomicReferenceArray B(int i) {
            return new AtomicReferenceArray(i);
        }

        public void C() {
            if ((this.l.incrementAndGet() & 63) == 0) {
                a();
            }
        }

        public void D() {
            W();
        }

        public void E(long j) {
            V(j);
        }

        public Object F(Object obj, int i, Object obj2, boolean z) {
            int i2;
            lock();
            try {
                long a2 = this.a.q.a();
                E(a2);
                if (this.c + 1 > this.f) {
                    o();
                }
                AtomicReferenceArray atomicReferenceArray = this.g;
                int length = i & (atomicReferenceArray.length() - 1);
                o oVar = (o) atomicReferenceArray.get(length);
                o oVar2 = oVar;
                while (true) {
                    if (oVar2 == null) {
                        this.e++;
                        o A = A(obj, i, oVar);
                        Y(A, obj, obj2, a2);
                        atomicReferenceArray.set(length, A);
                        this.c++;
                        n(A);
                        break;
                    }
                    Object key = oVar2.getKey();
                    if (oVar2.getHash() == i && key != null && this.a.f.d(obj, key)) {
                        y valueReference = oVar2.getValueReference();
                        Object obj3 = valueReference.get();
                        if (obj3 != null) {
                            if (z) {
                                I(oVar2, a2);
                            } else {
                                this.e++;
                                m(obj, i, valueReference, com.nytimes.android.external.cache.p.REPLACED);
                                Y(oVar2, obj, obj2, a2);
                                n(oVar2);
                            }
                            unlock();
                            D();
                            return obj3;
                        }
                        this.e++;
                        if (valueReference.isActive()) {
                            m(obj, i, valueReference, com.nytimes.android.external.cache.p.COLLECTED);
                            Y(oVar2, obj, obj2, a2);
                            i2 = this.c;
                        } else {
                            Y(oVar2, obj, obj2, a2);
                            i2 = this.c + 1;
                        }
                        this.c = i2;
                        n(oVar2);
                    } else {
                        oVar2 = oVar2.getNext();
                    }
                }
                unlock();
                D();
                return null;
            } catch (Throwable th) {
                unlock();
                D();
                throw th;
            }
        }

        public boolean G(o oVar, int i) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.g;
                int length = (atomicReferenceArray.length() - 1) & i;
                o oVar2 = (o) atomicReferenceArray.get(length);
                for (o oVar3 = oVar2; oVar3 != null; oVar3 = oVar3.getNext()) {
                    if (oVar3 == oVar) {
                        this.e++;
                        o S = S(oVar2, oVar3, oVar3.getKey(), i, oVar3.getValueReference(), com.nytimes.android.external.cache.p.COLLECTED);
                        int i2 = this.c - 1;
                        atomicReferenceArray.set(length, S);
                        this.c = i2;
                        return true;
                    }
                }
                unlock();
                D();
                return false;
            } finally {
                unlock();
                D();
            }
        }

        public boolean H(Object obj, int i, y yVar) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.g;
                int length = (atomicReferenceArray.length() - 1) & i;
                o oVar = (o) atomicReferenceArray.get(length);
                for (o oVar2 = oVar; oVar2 != null; oVar2 = oVar2.getNext()) {
                    Object key = oVar2.getKey();
                    if (oVar2.getHash() == i && key != null && this.a.f.d(obj, key)) {
                        if (oVar2.getValueReference() != yVar) {
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                D();
                            }
                            return false;
                        }
                        this.e++;
                        o S = S(oVar, oVar2, key, i, yVar, com.nytimes.android.external.cache.p.COLLECTED);
                        int i2 = this.c - 1;
                        atomicReferenceArray.set(length, S);
                        this.c = i2;
                        return true;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    D();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    D();
                }
            }
        }

        public void I(o oVar, long j) {
            if (this.a.x()) {
                oVar.setAccessTime(j);
            }
            this.n.add(oVar);
        }

        public void J(o oVar, long j) {
            if (this.a.x()) {
                oVar.setAccessTime(j);
            }
            this.k.add(oVar);
        }

        public void K(o oVar, int i, long j) {
            i();
            this.d += i;
            if (this.a.x()) {
                oVar.setAccessTime(j);
            }
            if (this.a.z()) {
                oVar.setWriteTime(j);
            }
            this.n.add(oVar);
            this.m.add(oVar);
        }

        public Object L(Object obj, int i, com.nytimes.android.external.cache.f fVar, boolean z) {
            l y = y(obj, i, z);
            if (y == null) {
                return null;
            }
            com.nytimes.android.external.cache.j z2 = z(obj, i, y, fVar);
            if (z2.isDone()) {
                try {
                    return com.nytimes.android.external.cache.v.a(z2);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r8 = r5.getValueReference();
            r11 = r8.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r11 == null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            r2 = com.nytimes.android.external.cache.p.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        
            r9 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        
            r10.e++;
            r12 = S(r4, r5, r6, r12, r8, r9);
            r2 = r10.c - 1;
            r0.set(r1, r12);
            r10.c = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
        
            unlock();
            D();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
        
            if (r8.isActive() == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        
            r2 = com.nytimes.android.external.cache.p.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object M(java.lang.Object r11, int r12) {
            /*
                r10 = this;
                r10.lock()
                com.nytimes.android.external.cache.k r0 = r10.a     // Catch: java.lang.Throwable -> L46
                com.nytimes.android.external.cache.u r0 = r0.q     // Catch: java.lang.Throwable -> L46
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L46
                r10.E(r0)     // Catch: java.lang.Throwable -> L46
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r10.g     // Catch: java.lang.Throwable -> L46
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L46
                int r1 = r1 + (-1)
                r1 = r1 & r12
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L46
                r4 = r2
                com.nytimes.android.external.cache.k$o r4 = (com.nytimes.android.external.cache.k.o) r4     // Catch: java.lang.Throwable -> L46
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L6d
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L46
                int r3 = r5.getHash()     // Catch: java.lang.Throwable -> L46
                if (r3 != r12) goto L74
                if (r6 == 0) goto L74
                com.nytimes.android.external.cache.k r3 = r10.a     // Catch: java.lang.Throwable -> L46
                com.nytimes.android.external.cache.h r3 = r3.f     // Catch: java.lang.Throwable -> L46
                boolean r3 = r3.d(r11, r6)     // Catch: java.lang.Throwable -> L46
                if (r3 == 0) goto L74
                com.nytimes.android.external.cache.k$y r8 = r5.getValueReference()     // Catch: java.lang.Throwable -> L46
                java.lang.Object r11 = r8.get()     // Catch: java.lang.Throwable -> L46
                if (r11 == 0) goto L48
                com.nytimes.android.external.cache.p r2 = com.nytimes.android.external.cache.p.EXPLICIT     // Catch: java.lang.Throwable -> L46
            L44:
                r9 = r2
                goto L51
            L46:
                r11 = move-exception
                goto L79
            L48:
                boolean r3 = r8.isActive()     // Catch: java.lang.Throwable -> L46
                if (r3 == 0) goto L6d
                com.nytimes.android.external.cache.p r2 = com.nytimes.android.external.cache.p.COLLECTED     // Catch: java.lang.Throwable -> L46
                goto L44
            L51:
                int r2 = r10.e     // Catch: java.lang.Throwable -> L46
                int r2 = r2 + 1
                r10.e = r2     // Catch: java.lang.Throwable -> L46
                r3 = r10
                r7 = r12
                com.nytimes.android.external.cache.k$o r12 = r3.S(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L46
                int r2 = r10.c     // Catch: java.lang.Throwable -> L46
                int r2 = r2 + (-1)
                r0.set(r1, r12)     // Catch: java.lang.Throwable -> L46
                r10.c = r2     // Catch: java.lang.Throwable -> L46
                r10.unlock()
                r10.D()
                return r11
            L6d:
                r10.unlock()
                r10.D()
                return r2
            L74:
                com.nytimes.android.external.cache.k$o r5 = r5.getNext()     // Catch: java.lang.Throwable -> L46
                goto L1f
            L79:
                r10.unlock()
                r10.D()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nytimes.android.external.cache.k.p.M(java.lang.Object, int):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r9 = r6.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        
            if (r11.a.g.d(r14, r12) == false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        
            r12 = com.nytimes.android.external.cache.p.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
        
            r11.e++;
            r13 = S(r5, r6, r7, r13, r9, r12);
            r14 = r11.c - 1;
            r0.set(r1, r13);
            r11.c = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
        
            if (r12 != com.nytimes.android.external.cache.p.EXPLICIT) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
        
            unlock();
            D();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
        
            if (r12 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        
            if (r9.isActive() == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        
            r12 = com.nytimes.android.external.cache.p.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean N(java.lang.Object r12, int r13, java.lang.Object r14) {
            /*
                r11 = this;
                r11.lock()
                com.nytimes.android.external.cache.k r0 = r11.a     // Catch: java.lang.Throwable -> L4d
                com.nytimes.android.external.cache.u r0 = r0.q     // Catch: java.lang.Throwable -> L4d
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L4d
                r11.E(r0)     // Catch: java.lang.Throwable -> L4d
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r11.g     // Catch: java.lang.Throwable -> L4d
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L4d
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r13
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L4d
                r5 = r3
                com.nytimes.android.external.cache.k$o r5 = (com.nytimes.android.external.cache.k.o) r5     // Catch: java.lang.Throwable -> L4d
                r6 = r5
            L1f:
                r3 = 0
                if (r6 == 0) goto L7a
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L4d
                int r4 = r6.getHash()     // Catch: java.lang.Throwable -> L4d
                if (r4 != r13) goto L81
                if (r7 == 0) goto L81
                com.nytimes.android.external.cache.k r4 = r11.a     // Catch: java.lang.Throwable -> L4d
                com.nytimes.android.external.cache.h r4 = r4.f     // Catch: java.lang.Throwable -> L4d
                boolean r4 = r4.d(r12, r7)     // Catch: java.lang.Throwable -> L4d
                if (r4 == 0) goto L81
                com.nytimes.android.external.cache.k$y r9 = r6.getValueReference()     // Catch: java.lang.Throwable -> L4d
                java.lang.Object r12 = r9.get()     // Catch: java.lang.Throwable -> L4d
                com.nytimes.android.external.cache.k r4 = r11.a     // Catch: java.lang.Throwable -> L4d
                com.nytimes.android.external.cache.h r4 = r4.g     // Catch: java.lang.Throwable -> L4d
                boolean r14 = r4.d(r14, r12)     // Catch: java.lang.Throwable -> L4d
                if (r14 == 0) goto L4f
                com.nytimes.android.external.cache.p r12 = com.nytimes.android.external.cache.p.EXPLICIT     // Catch: java.lang.Throwable -> L4d
                goto L59
            L4d:
                r12 = move-exception
                goto L86
            L4f:
                if (r12 != 0) goto L7a
                boolean r12 = r9.isActive()     // Catch: java.lang.Throwable -> L4d
                if (r12 == 0) goto L7a
                com.nytimes.android.external.cache.p r12 = com.nytimes.android.external.cache.p.COLLECTED     // Catch: java.lang.Throwable -> L4d
            L59:
                int r14 = r11.e     // Catch: java.lang.Throwable -> L4d
                int r14 = r14 + r2
                r11.e = r14     // Catch: java.lang.Throwable -> L4d
                r4 = r11
                r8 = r13
                r10 = r12
                com.nytimes.android.external.cache.k$o r13 = r4.S(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L4d
                int r14 = r11.c     // Catch: java.lang.Throwable -> L4d
                int r14 = r14 - r2
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L4d
                r11.c = r14     // Catch: java.lang.Throwable -> L4d
                com.nytimes.android.external.cache.p r13 = com.nytimes.android.external.cache.p.EXPLICIT     // Catch: java.lang.Throwable -> L4d
                if (r12 != r13) goto L72
                goto L73
            L72:
                r2 = 0
            L73:
                r11.unlock()
                r11.D()
                return r2
            L7a:
                r11.unlock()
                r11.D()
                return r3
            L81:
                com.nytimes.android.external.cache.k$o r6 = r6.getNext()     // Catch: java.lang.Throwable -> L4d
                goto L1f
            L86:
                r11.unlock()
                r11.D()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nytimes.android.external.cache.k.p.N(java.lang.Object, int, java.lang.Object):boolean");
        }

        public void O(o oVar) {
            l(oVar, com.nytimes.android.external.cache.p.COLLECTED);
            this.m.remove(oVar);
            this.n.remove(oVar);
        }

        public boolean P(o oVar, int i, com.nytimes.android.external.cache.p pVar) {
            AtomicReferenceArray atomicReferenceArray = this.g;
            int length = (atomicReferenceArray.length() - 1) & i;
            o oVar2 = (o) atomicReferenceArray.get(length);
            for (o oVar3 = oVar2; oVar3 != null; oVar3 = oVar3.getNext()) {
                if (oVar3 == oVar) {
                    this.e++;
                    o S = S(oVar2, oVar3, oVar3.getKey(), i, oVar3.getValueReference(), pVar);
                    int i2 = this.c - 1;
                    atomicReferenceArray.set(length, S);
                    this.c = i2;
                    return true;
                }
            }
            return false;
        }

        public o Q(o oVar, o oVar2) {
            int i = this.c;
            o next = oVar2.getNext();
            while (oVar != oVar2) {
                o g = g(oVar, next);
                if (g != null) {
                    next = g;
                } else {
                    O(oVar);
                    i--;
                }
                oVar = oVar.getNext();
            }
            this.c = i;
            return next;
        }

        public boolean R(Object obj, int i, l lVar) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.g;
                int length = (atomicReferenceArray.length() - 1) & i;
                o oVar = (o) atomicReferenceArray.get(length);
                o oVar2 = oVar;
                while (true) {
                    if (oVar2 == null) {
                        break;
                    }
                    Object key = oVar2.getKey();
                    if (oVar2.getHash() != i || key == null || !this.a.f.d(obj, key)) {
                        oVar2 = oVar2.getNext();
                    } else if (oVar2.getValueReference() == lVar) {
                        if (lVar.isActive()) {
                            oVar2.setValueReference(lVar.f());
                        } else {
                            atomicReferenceArray.set(length, Q(oVar, oVar2));
                        }
                        unlock();
                        D();
                        return true;
                    }
                }
                unlock();
                D();
                return false;
            } catch (Throwable th) {
                unlock();
                D();
                throw th;
            }
        }

        public o S(o oVar, o oVar2, Object obj, int i, y yVar, com.nytimes.android.external.cache.p pVar) {
            m(obj, i, yVar, pVar);
            this.m.remove(oVar2);
            this.n.remove(oVar2);
            if (!yVar.b()) {
                return Q(oVar, oVar2);
            }
            yVar.a(null);
            return oVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object T(java.lang.Object r16, int r17, java.lang.Object r18) {
            /*
                r15 = this;
                r8 = r15
                r0 = r16
                r5 = r17
                r15.lock()
                com.nytimes.android.external.cache.k r1 = r8.a     // Catch: java.lang.Throwable -> L69
                com.nytimes.android.external.cache.u r1 = r1.q     // Catch: java.lang.Throwable -> L69
                long r6 = r1.a()     // Catch: java.lang.Throwable -> L69
                r15.E(r6)     // Catch: java.lang.Throwable -> L69
                java.util.concurrent.atomic.AtomicReferenceArray r9 = r8.g     // Catch: java.lang.Throwable -> L69
                int r1 = r9.length()     // Catch: java.lang.Throwable -> L69
                int r1 = r1 + (-1)
                r10 = r5 & r1
                java.lang.Object r1 = r9.get(r10)     // Catch: java.lang.Throwable -> L69
                r2 = r1
                com.nytimes.android.external.cache.k$o r2 = (com.nytimes.android.external.cache.k.o) r2     // Catch: java.lang.Throwable -> L69
                r11 = r2
            L25:
                r12 = 0
                if (r11 == 0) goto L6b
                java.lang.Object r4 = r11.getKey()     // Catch: java.lang.Throwable -> L69
                int r1 = r11.getHash()     // Catch: java.lang.Throwable -> L69
                if (r1 != r5) goto L91
                if (r4 == 0) goto L91
                com.nytimes.android.external.cache.k r1 = r8.a     // Catch: java.lang.Throwable -> L69
                com.nytimes.android.external.cache.h r1 = r1.f     // Catch: java.lang.Throwable -> L69
                boolean r1 = r1.d(r0, r4)     // Catch: java.lang.Throwable -> L69
                if (r1 == 0) goto L91
                com.nytimes.android.external.cache.k$y r13 = r11.getValueReference()     // Catch: java.lang.Throwable -> L69
                java.lang.Object r14 = r13.get()     // Catch: java.lang.Throwable -> L69
                if (r14 != 0) goto L72
                boolean r0 = r13.isActive()     // Catch: java.lang.Throwable -> L69
                if (r0 == 0) goto L6b
                int r0 = r8.e     // Catch: java.lang.Throwable -> L69
                int r0 = r0 + 1
                r8.e = r0     // Catch: java.lang.Throwable -> L69
                com.nytimes.android.external.cache.p r7 = com.nytimes.android.external.cache.p.COLLECTED     // Catch: java.lang.Throwable -> L69
                r1 = r15
                r3 = r11
                r5 = r17
                r6 = r13
                com.nytimes.android.external.cache.k$o r0 = r1.S(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L69
                int r1 = r8.c     // Catch: java.lang.Throwable -> L69
                int r1 = r1 + (-1)
                r9.set(r10, r0)     // Catch: java.lang.Throwable -> L69
                r8.c = r1     // Catch: java.lang.Throwable -> L69
                goto L6b
            L69:
                r0 = move-exception
                goto L96
            L6b:
                r15.unlock()
                r15.D()
                return r12
            L72:
                int r1 = r8.e     // Catch: java.lang.Throwable -> L69
                int r1 = r1 + 1
                r8.e = r1     // Catch: java.lang.Throwable -> L69
                com.nytimes.android.external.cache.p r1 = com.nytimes.android.external.cache.p.REPLACED     // Catch: java.lang.Throwable -> L69
                r15.m(r0, r5, r13, r1)     // Catch: java.lang.Throwable -> L69
                r1 = r15
                r2 = r11
                r3 = r16
                r4 = r18
                r5 = r6
                r1.Y(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L69
                r15.n(r11)     // Catch: java.lang.Throwable -> L69
                r15.unlock()
                r15.D()
                return r14
            L91:
                com.nytimes.android.external.cache.k$o r11 = r11.getNext()     // Catch: java.lang.Throwable -> L69
                goto L25
            L96:
                r15.unlock()
                r15.D()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nytimes.android.external.cache.k.p.T(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean U(java.lang.Object r16, int r17, java.lang.Object r18, java.lang.Object r19) {
            /*
                r15 = this;
                r8 = r15
                r0 = r16
                r5 = r17
                r15.lock()
                com.nytimes.android.external.cache.k r1 = r8.a     // Catch: java.lang.Throwable -> L67
                com.nytimes.android.external.cache.u r1 = r1.q     // Catch: java.lang.Throwable -> L67
                long r6 = r1.a()     // Catch: java.lang.Throwable -> L67
                r15.E(r6)     // Catch: java.lang.Throwable -> L67
                java.util.concurrent.atomic.AtomicReferenceArray r9 = r8.g     // Catch: java.lang.Throwable -> L67
                int r1 = r9.length()     // Catch: java.lang.Throwable -> L67
                r10 = 1
                int r1 = r1 - r10
                r11 = r5 & r1
                java.lang.Object r1 = r9.get(r11)     // Catch: java.lang.Throwable -> L67
                r2 = r1
                com.nytimes.android.external.cache.k$o r2 = (com.nytimes.android.external.cache.k.o) r2     // Catch: java.lang.Throwable -> L67
                r12 = r2
            L25:
                r13 = 0
                if (r12 == 0) goto L69
                java.lang.Object r4 = r12.getKey()     // Catch: java.lang.Throwable -> L67
                int r1 = r12.getHash()     // Catch: java.lang.Throwable -> L67
                if (r1 != r5) goto L9e
                if (r4 == 0) goto L9e
                com.nytimes.android.external.cache.k r1 = r8.a     // Catch: java.lang.Throwable -> L67
                com.nytimes.android.external.cache.h r1 = r1.f     // Catch: java.lang.Throwable -> L67
                boolean r1 = r1.d(r0, r4)     // Catch: java.lang.Throwable -> L67
                if (r1 == 0) goto L9e
                com.nytimes.android.external.cache.k$y r14 = r12.getValueReference()     // Catch: java.lang.Throwable -> L67
                java.lang.Object r1 = r14.get()     // Catch: java.lang.Throwable -> L67
                if (r1 != 0) goto L70
                boolean r0 = r14.isActive()     // Catch: java.lang.Throwable -> L67
                if (r0 == 0) goto L69
                int r0 = r8.e     // Catch: java.lang.Throwable -> L67
                int r0 = r0 + r10
                r8.e = r0     // Catch: java.lang.Throwable -> L67
                com.nytimes.android.external.cache.p r7 = com.nytimes.android.external.cache.p.COLLECTED     // Catch: java.lang.Throwable -> L67
                r1 = r15
                r3 = r12
                r5 = r17
                r6 = r14
                com.nytimes.android.external.cache.k$o r0 = r1.S(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L67
                int r1 = r8.c     // Catch: java.lang.Throwable -> L67
                int r1 = r1 - r10
                r9.set(r11, r0)     // Catch: java.lang.Throwable -> L67
                r8.c = r1     // Catch: java.lang.Throwable -> L67
                goto L69
            L67:
                r0 = move-exception
                goto La5
            L69:
                r15.unlock()
                r15.D()
                return r13
            L70:
                com.nytimes.android.external.cache.k r2 = r8.a     // Catch: java.lang.Throwable -> L67
                com.nytimes.android.external.cache.h r2 = r2.g     // Catch: java.lang.Throwable -> L67
                r3 = r18
                boolean r1 = r2.d(r3, r1)     // Catch: java.lang.Throwable -> L67
                if (r1 == 0) goto L9a
                int r1 = r8.e     // Catch: java.lang.Throwable -> L67
                int r1 = r1 + r10
                r8.e = r1     // Catch: java.lang.Throwable -> L67
                com.nytimes.android.external.cache.p r1 = com.nytimes.android.external.cache.p.REPLACED     // Catch: java.lang.Throwable -> L67
                r15.m(r0, r5, r14, r1)     // Catch: java.lang.Throwable -> L67
                r1 = r15
                r2 = r12
                r3 = r16
                r4 = r19
                r5 = r6
                r1.Y(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L67
                r15.n(r12)     // Catch: java.lang.Throwable -> L67
                r15.unlock()
                r15.D()
                return r10
            L9a:
                r15.I(r12, r6)     // Catch: java.lang.Throwable -> L67
                goto L69
            L9e:
                r3 = r18
                com.nytimes.android.external.cache.k$o r12 = r12.getNext()     // Catch: java.lang.Throwable -> L67
                goto L25
            La5:
                r15.unlock()
                r15.D()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nytimes.android.external.cache.k.p.U(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        public void V(long j) {
            if (tryLock()) {
                try {
                    j();
                    p(j);
                    this.l.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void W() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.a.u();
        }

        public Object X(o oVar, Object obj, int i, Object obj2, long j, com.nytimes.android.external.cache.f fVar) {
            Object L;
            return (!this.a.A() || j - oVar.getWriteTime() <= this.a.n || oVar.getValueReference().b() || (L = L(obj, i, fVar, true)) == null) ? obj2 : L;
        }

        public void Y(o oVar, Object obj, Object obj2, long j) {
            y valueReference = oVar.getValueReference();
            int weigh = this.a.k.weigh(obj, obj2);
            com.nytimes.android.external.cache.o.d(weigh >= 0, "Weights must be non-negative");
            oVar.setValueReference(this.a.i.referenceValue(this, oVar, obj2, weigh));
            K(oVar, weigh, j);
            valueReference.a(obj2);
        }

        public boolean Z(Object obj, int i, l lVar, Object obj2) {
            lock();
            try {
                long a2 = this.a.q.a();
                E(a2);
                int i2 = this.c + 1;
                if (i2 > this.f) {
                    o();
                    i2 = this.c + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.g;
                int length = i & (atomicReferenceArray.length() - 1);
                o oVar = (o) atomicReferenceArray.get(length);
                o oVar2 = oVar;
                while (true) {
                    if (oVar2 == null) {
                        this.e++;
                        o A = A(obj, i, oVar);
                        Y(A, obj, obj2, a2);
                        atomicReferenceArray.set(length, A);
                        this.c = i2;
                        n(A);
                        break;
                    }
                    Object key = oVar2.getKey();
                    if (oVar2.getHash() == i && key != null && this.a.f.d(obj, key)) {
                        y valueReference = oVar2.getValueReference();
                        Object obj3 = valueReference.get();
                        if (lVar != valueReference && (obj3 != null || valueReference == k.w)) {
                            m(obj, i, new G(obj2, 0), com.nytimes.android.external.cache.p.REPLACED);
                            unlock();
                            D();
                            return false;
                        }
                        this.e++;
                        if (lVar.isActive()) {
                            m(obj, i, lVar, obj3 == null ? com.nytimes.android.external.cache.p.COLLECTED : com.nytimes.android.external.cache.p.REPLACED);
                            i2--;
                        }
                        Y(oVar2, obj, obj2, a2);
                        this.c = i2;
                        n(oVar2);
                    } else {
                        oVar2 = oVar2.getNext();
                    }
                }
                unlock();
                D();
                return true;
            } catch (Throwable th) {
                unlock();
                D();
                throw th;
            }
        }

        public void a() {
            V(this.a.q.a());
            W();
        }

        public void a0() {
            if (tryLock()) {
                try {
                    j();
                } finally {
                    unlock();
                }
            }
        }

        public void b() {
            if (this.c != 0) {
                lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = this.g;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (o oVar = (o) atomicReferenceArray.get(i); oVar != null; oVar = oVar.getNext()) {
                            if (oVar.getValueReference().isActive()) {
                                l(oVar, com.nytimes.android.external.cache.p.EXPLICIT);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, (Object) null);
                    }
                    d();
                    this.m.clear();
                    this.n.clear();
                    this.l.set(0);
                    this.e++;
                    this.c = 0;
                    unlock();
                    D();
                } catch (Throwable th) {
                    unlock();
                    D();
                    throw th;
                }
            }
        }

        public void b0(long j) {
            if (tryLock()) {
                try {
                    p(j);
                } finally {
                    unlock();
                }
            }
        }

        public void c() {
            while (this.i.poll() != null) {
            }
        }

        public void d() {
            if (this.a.I()) {
                c();
            }
            if (this.a.J()) {
                e();
            }
        }

        public void e() {
            while (this.j.poll() != null) {
            }
        }

        public boolean f(Object obj, int i) {
            try {
                if (this.c == 0) {
                    return false;
                }
                o u = u(obj, i, this.a.q.a());
                if (u == null) {
                    return false;
                }
                return u.getValueReference().get() != null;
            } finally {
                C();
            }
        }

        public o g(o oVar, o oVar2) {
            if (oVar.getKey() == null) {
                return null;
            }
            y valueReference = oVar.getValueReference();
            Object obj = valueReference.get();
            if (obj == null && valueReference.isActive()) {
                return null;
            }
            o copyEntry = this.a.r.copyEntry(this, oVar, oVar2);
            copyEntry.setValueReference(valueReference.d(this.j, obj, copyEntry));
            return copyEntry;
        }

        public void h() {
            int i = 0;
            do {
                o poll = this.i.poll();
                if (poll == null) {
                    return;
                }
                this.a.v(poll);
                i++;
            } while (i != 16);
        }

        public void i() {
            while (true) {
                o oVar = (o) this.k.poll();
                if (oVar == null) {
                    return;
                }
                if (this.n.contains(oVar)) {
                    this.n.add(oVar);
                }
            }
        }

        public void j() {
            if (this.a.I()) {
                h();
            }
            if (this.a.J()) {
                k();
            }
        }

        public void k() {
            int i = 0;
            do {
                y poll = this.j.poll();
                if (poll == null) {
                    return;
                }
                this.a.w(poll);
                i++;
            } while (i != 16);
        }

        public void l(o oVar, com.nytimes.android.external.cache.p pVar) {
            m(oVar.getKey(), oVar.getHash(), oVar.getValueReference(), pVar);
        }

        public void m(Object obj, int i, y yVar, com.nytimes.android.external.cache.p pVar) {
            this.d -= yVar.c();
            if (this.a.o != k.x) {
                this.a.o.offer(com.nytimes.android.external.cache.r.a(obj, yVar.get(), pVar));
            }
        }

        public void n(o oVar) {
            if (this.a.h()) {
                i();
                if (oVar.getValueReference().c() > this.h && !P(oVar, oVar.getHash(), com.nytimes.android.external.cache.p.SIZE)) {
                    throw new AssertionError();
                }
                while (this.d > this.h) {
                    o w = w();
                    if (!P(w, w.getHash(), com.nytimes.android.external.cache.p.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        public void o() {
            AtomicReferenceArray atomicReferenceArray = this.g;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.c;
            AtomicReferenceArray B = B(length << 1);
            this.f = (B.length() * 3) / 4;
            int length2 = B.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                o oVar = (o) atomicReferenceArray.get(i2);
                if (oVar != null) {
                    o next = oVar.getNext();
                    int hash = oVar.getHash() & length2;
                    if (next == null) {
                        B.set(hash, oVar);
                    } else {
                        o oVar2 = oVar;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                oVar2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        B.set(hash, oVar2);
                        while (oVar != oVar2) {
                            int hash3 = oVar.getHash() & length2;
                            o g = g(oVar, (o) B.get(hash3));
                            if (g != null) {
                                B.set(hash3, g);
                            } else {
                                O(oVar);
                                i--;
                            }
                            oVar = oVar.getNext();
                        }
                    }
                }
            }
            this.g = B;
            this.c = i;
        }

        public void p(long j) {
            o oVar;
            o oVar2;
            i();
            do {
                oVar = (o) this.m.peek();
                if (oVar == null || !this.a.o(oVar, j)) {
                    do {
                        oVar2 = (o) this.n.peek();
                        if (oVar2 == null || !this.a.o(oVar2, j)) {
                            return;
                        }
                    } while (P(oVar2, oVar2.getHash(), com.nytimes.android.external.cache.p.EXPIRED));
                    throw new AssertionError();
                }
            } while (P(oVar, oVar.getHash(), com.nytimes.android.external.cache.p.EXPIRED));
            throw new AssertionError();
        }

        public Object q(Object obj, int i) {
            try {
                if (this.c != 0) {
                    long a2 = this.a.q.a();
                    o u = u(obj, i, a2);
                    if (u == null) {
                        return null;
                    }
                    Object obj2 = u.getValueReference().get();
                    if (obj2 != null) {
                        J(u, a2);
                        Object key = u.getKey();
                        this.a.getClass();
                        return X(u, key, i, obj2, a2, null);
                    }
                    a0();
                }
                return null;
            } finally {
                C();
            }
        }

        public Object r(Object obj, int i, l lVar, com.nytimes.android.external.cache.j jVar) {
            Object obj2;
            try {
                obj2 = com.nytimes.android.external.cache.v.a(jVar);
            } catch (Throwable th) {
                th = th;
                obj2 = null;
            }
            try {
                if (obj2 != null) {
                    Z(obj, i, lVar, obj2);
                    return obj2;
                }
                throw new f.a("CacheLoader returned null for key " + obj + ".");
            } catch (Throwable th2) {
                th = th2;
                if (obj2 == null) {
                    R(obj, i, lVar);
                }
                throw th;
            }
        }

        public o s(Object obj, int i) {
            for (o t = t(i); t != null; t = t.getNext()) {
                if (t.getHash() == i) {
                    Object key = t.getKey();
                    if (key == null) {
                        a0();
                    } else if (this.a.f.d(obj, key)) {
                        return t;
                    }
                }
            }
            return null;
        }

        public o t(int i) {
            return (o) this.g.get(i & (r0.length() - 1));
        }

        public o u(Object obj, int i, long j) {
            o s = s(obj, i);
            if (s == null) {
                return null;
            }
            if (!this.a.o(s, j)) {
                return s;
            }
            b0(j);
            return null;
        }

        public Object v(o oVar, long j) {
            if (oVar.getKey() == null) {
                a0();
                return null;
            }
            Object obj = oVar.getValueReference().get();
            if (obj == null) {
                a0();
                return null;
            }
            if (!this.a.o(oVar, j)) {
                return obj;
            }
            b0(j);
            return null;
        }

        public o w() {
            for (o oVar : this.n) {
                if (oVar.getValueReference().c() > 0) {
                    return oVar;
                }
            }
            throw new AssertionError();
        }

        public void x(AtomicReferenceArray atomicReferenceArray) {
            this.f = (atomicReferenceArray.length() * 3) / 4;
            if (!this.a.f()) {
                int i = this.f;
                if (i == this.h) {
                    this.f = i + 1;
                }
            }
            this.g = atomicReferenceArray;
        }

        /* JADX WARN: Finally extract failed */
        public l y(Object obj, int i, boolean z) {
            lock();
            try {
                long a2 = this.a.q.a();
                E(a2);
                AtomicReferenceArray atomicReferenceArray = this.g;
                int length = (atomicReferenceArray.length() - 1) & i;
                o oVar = (o) atomicReferenceArray.get(length);
                for (o oVar2 = oVar; oVar2 != null; oVar2 = oVar2.getNext()) {
                    Object key = oVar2.getKey();
                    if (oVar2.getHash() == i && key != null && this.a.f.d(obj, key)) {
                        y valueReference = oVar2.getValueReference();
                        if (!valueReference.b() && (!z || a2 - oVar2.getWriteTime() >= this.a.n)) {
                            this.e++;
                            l lVar = new l(valueReference);
                            oVar2.setValueReference(lVar);
                            unlock();
                            D();
                            return lVar;
                        }
                        unlock();
                        D();
                        return null;
                    }
                }
                this.e++;
                l lVar2 = new l();
                o A = A(obj, i, oVar);
                A.setValueReference(lVar2);
                atomicReferenceArray.set(length, A);
                unlock();
                D();
                return lVar2;
            } catch (Throwable th) {
                unlock();
                D();
                throw th;
            }
        }

        public com.nytimes.android.external.cache.j z(Object obj, int i, l lVar, com.nytimes.android.external.cache.f fVar) {
            com.nytimes.android.external.cache.j g = lVar.g(obj, fVar);
            g.addListener(new a(obj, i, lVar, g), com.nytimes.android.external.cache.g.INSTANCE);
            return g;
        }
    }

    public static class q extends SoftReference implements y {
        public final o a;

        public q(ReferenceQueue referenceQueue, Object obj, o oVar) {
            super(obj, referenceQueue);
            this.a = oVar;
        }

        public void a(Object obj) {
        }

        public boolean b() {
            return false;
        }

        public int c() {
            return 1;
        }

        public y d(ReferenceQueue referenceQueue, Object obj, o oVar) {
            return new q(referenceQueue, obj, oVar);
        }

        public o getEntry() {
            return this.a;
        }

        public boolean isActive() {
            return true;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class r {
        private static final /* synthetic */ r[] $VALUES;
        public static final r SOFT;
        public static final r STRONG;
        public static final r WEAK;

        public enum a extends r {
            public a(String str, int i) {
                super(str, i, null);
            }

            public com.nytimes.android.external.cache.h defaultEquivalence() {
                return com.nytimes.android.external.cache.h.c();
            }

            public y referenceValue(p pVar, o oVar, Object obj, int i) {
                return i == 1 ? new v(obj) : new G(obj, i);
            }
        }

        public enum b extends r {
            public b(String str, int i) {
                super(str, i, null);
            }

            public com.nytimes.android.external.cache.h defaultEquivalence() {
                return com.nytimes.android.external.cache.h.f();
            }

            public y referenceValue(p pVar, o oVar, Object obj, int i) {
                return i == 1 ? new q(pVar.j, obj, oVar) : new F(pVar.j, obj, oVar, i);
            }
        }

        public enum c extends r {
            public c(String str, int i) {
                super(str, i, null);
            }

            public com.nytimes.android.external.cache.h defaultEquivalence() {
                return com.nytimes.android.external.cache.h.f();
            }

            public y referenceValue(p pVar, o oVar, Object obj, int i) {
                return i == 1 ? new D(pVar.j, obj, oVar) : new H(pVar.j, obj, oVar, i);
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            STRONG = aVar;
            b bVar = new b("SOFT", 1);
            SOFT = bVar;
            c cVar = new c("WEAK", 2);
            WEAK = cVar;
            $VALUES = new r[]{aVar, bVar, cVar};
        }

        private r(String str, int i) {
        }

        public static r valueOf(String str) {
            return (r) Enum.valueOf(r.class, str);
        }

        public static r[] values() {
            return (r[]) $VALUES.clone();
        }

        public abstract com.nytimes.android.external.cache.h defaultEquivalence();

        public abstract y referenceValue(p pVar, o oVar, Object obj, int i);

        public /* synthetic */ r(String str, int i, a aVar) {
            this(str, i);
        }
    }

    public static final class s extends u {
        public volatile long f;
        public o g;
        public o h;

        public s(Object obj, int i, o oVar) {
            super(obj, i, oVar);
            this.f = Long.MAX_VALUE;
            this.g = k.r();
            this.h = k.r();
        }

        public long getAccessTime() {
            return this.f;
        }

        public o getNextInAccessQueue() {
            return this.g;
        }

        public o getPreviousInAccessQueue() {
            return this.h;
        }

        public void setAccessTime(long j) {
            this.f = j;
        }

        public void setNextInAccessQueue(o oVar) {
            this.g = oVar;
        }

        public void setPreviousInAccessQueue(o oVar) {
            this.h = oVar;
        }
    }

    public static final class t extends u {
        public volatile long f;
        public o g;
        public o h;
        public volatile long i;
        public o j;
        public o k;

        public t(Object obj, int i, o oVar) {
            super(obj, i, oVar);
            this.f = Long.MAX_VALUE;
            this.g = k.r();
            this.h = k.r();
            this.i = Long.MAX_VALUE;
            this.j = k.r();
            this.k = k.r();
        }

        public long getAccessTime() {
            return this.f;
        }

        public o getNextInAccessQueue() {
            return this.g;
        }

        public o getNextInWriteQueue() {
            return this.j;
        }

        public o getPreviousInAccessQueue() {
            return this.h;
        }

        public o getPreviousInWriteQueue() {
            return this.k;
        }

        public long getWriteTime() {
            return this.i;
        }

        public void setAccessTime(long j) {
            this.f = j;
        }

        public void setNextInAccessQueue(o oVar) {
            this.g = oVar;
        }

        public void setNextInWriteQueue(o oVar) {
            this.j = oVar;
        }

        public void setPreviousInAccessQueue(o oVar) {
            this.h = oVar;
        }

        public void setPreviousInWriteQueue(o oVar) {
            this.k = oVar;
        }

        public void setWriteTime(long j) {
            this.i = j;
        }
    }

    public static class u extends d {
        public final Object a;
        public final int c;
        public final o d;
        public volatile y e = k.F();

        public u(Object obj, int i, o oVar) {
            this.a = obj;
            this.c = i;
            this.d = oVar;
        }

        public int getHash() {
            return this.c;
        }

        public Object getKey() {
            return this.a;
        }

        public o getNext() {
            return this.d;
        }

        public y getValueReference() {
            return this.e;
        }

        public void setValueReference(y yVar) {
            this.e = yVar;
        }
    }

    public static class v implements y {
        public final Object a;

        public v(Object obj) {
            this.a = obj;
        }

        public void a(Object obj) {
        }

        public boolean b() {
            return false;
        }

        public int c() {
            return 1;
        }

        public y d(ReferenceQueue referenceQueue, Object obj, o oVar) {
            return this;
        }

        public Object get() {
            return this.a;
        }

        public o getEntry() {
            return null;
        }

        public boolean isActive() {
            return true;
        }
    }

    public static final class w extends u {
        public volatile long f;
        public o g;
        public o h;

        public w(Object obj, int i, o oVar) {
            super(obj, i, oVar);
            this.f = Long.MAX_VALUE;
            this.g = k.r();
            this.h = k.r();
        }

        public o getNextInWriteQueue() {
            return this.g;
        }

        public o getPreviousInWriteQueue() {
            return this.h;
        }

        public long getWriteTime() {
            return this.f;
        }

        public void setNextInWriteQueue(o oVar) {
            this.g = oVar;
        }

        public void setPreviousInWriteQueue(o oVar) {
            this.h = oVar;
        }

        public void setWriteTime(long j) {
            this.f = j;
        }
    }

    public final class x extends i {
        public x() {
            super();
        }

        public Object next() {
            return d().getValue();
        }
    }

    public interface y {
        void a(Object obj);

        boolean b();

        int c();

        y d(ReferenceQueue referenceQueue, Object obj, o oVar);

        Object get();

        o getEntry();

        boolean isActive();
    }

    public final class z extends AbstractCollection {
        public final ConcurrentMap a;

        public z(ConcurrentMap concurrentMap) {
            this.a = concurrentMap;
        }

        public void clear() {
            this.a.clear();
        }

        public boolean contains(Object obj) {
            return this.a.containsValue(obj);
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        public Iterator iterator() {
            return k.this.new x();
        }

        public int size() {
            return this.a.size();
        }

        public Object[] toArray() {
            return k.a(this).toArray();
        }

        public Object[] toArray(Object[] objArr) {
            return k.a(this).toArray(objArr);
        }
    }

    public k(com.nytimes.android.external.cache.e eVar, com.nytimes.android.external.cache.f fVar) {
        this.e = Math.min(eVar.d(), 65536);
        r i2 = eVar.i();
        this.h = i2;
        this.i = eVar.o();
        this.f = eVar.h();
        this.g = eVar.n();
        long j2 = eVar.j();
        this.j = j2;
        this.k = eVar.p();
        this.l = eVar.e();
        this.m = eVar.f();
        this.n = eVar.k();
        com.nytimes.android.external.cache.q l2 = eVar.l();
        this.p = l2;
        this.o = l2 == e.b.INSTANCE ? g() : new ConcurrentLinkedQueue();
        this.q = eVar.m(y());
        this.r = f.getFactory(i2, G(), K());
        int min = Math.min(eVar.g(), 1073741824);
        if (h() && !f()) {
            min = Math.min(min, (int) j2);
        }
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        while (i5 < this.e && (!h() || i5 * 20 <= this.j)) {
            i6++;
            i5 <<= 1;
        }
        this.c = 32 - i6;
        this.a = i5 - 1;
        this.d = q(i5);
        int i7 = min / i5;
        while (i4 < (i7 * i5 < min ? i7 + 1 : i7)) {
            i4 <<= 1;
        }
        if (h()) {
            long j3 = this.j;
            long j4 = i5;
            long j5 = (j3 / j4) + 1;
            long j6 = j3 % j4;
            while (true) {
                p[] pVarArr = this.d;
                if (i3 >= pVarArr.length) {
                    return;
                }
                if (i3 == j6) {
                    j5--;
                }
                pVarArr[i3] = e(i4, j5);
                i3++;
            }
        } else {
            while (true) {
                p[] pVarArr2 = this.d;
                if (i3 >= pVarArr2.length) {
                    return;
                }
                pVarArr2[i3] = e(i4, -1L);
                i3++;
            }
        }
    }

    public static int B(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    public static char C(long j2) {
        if (j2 > 65535) {
            return (char) 65535;
        }
        if (j2 < 0) {
            return (char) 0;
        }
        return (char) j2;
    }

    public static ArrayList E(Collection collection) {
        return new ArrayList(collection);
    }

    public static y F() {
        return w;
    }

    public static /* synthetic */ ArrayList a(Collection collection) {
        return E(collection);
    }

    public static void c(o oVar, o oVar2) {
        oVar.setNextInAccessQueue(oVar2);
        oVar2.setPreviousInAccessQueue(oVar);
    }

    public static void d(o oVar, o oVar2) {
        oVar.setNextInWriteQueue(oVar2);
        oVar2.setPreviousInWriteQueue(oVar);
    }

    public static Queue g() {
        return x;
    }

    public static o r() {
        return n.INSTANCE;
    }

    public static void s(o oVar) {
        o r2 = r();
        oVar.setNextInAccessQueue(r2);
        oVar.setPreviousInAccessQueue(r2);
    }

    public static void t(o oVar) {
        o r2 = r();
        oVar.setNextInWriteQueue(r2);
        oVar.setPreviousInWriteQueue(r2);
    }

    public boolean A() {
        return this.n > 0;
    }

    public p D(int i2) {
        return this.d[(i2 >>> this.c) & this.a];
    }

    public boolean G() {
        return H() || x();
    }

    public boolean H() {
        return i() || h();
    }

    public boolean I() {
        return this.h != r.STRONG;
    }

    public boolean J() {
        return this.i != r.STRONG;
    }

    public boolean K() {
        return L() || z();
    }

    public boolean L() {
        return j();
    }

    public void clear() {
        for (p pVar : this.d) {
            pVar.b();
        }
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return ConcurrentMap.-CC.$default$compute(this, obj, biFunction);
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return ConcurrentMap.-CC.$default$computeIfAbsent(this, obj, function);
    }

    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return ConcurrentMap.-CC.$default$computeIfPresent(this, obj, biFunction);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int n2 = n(obj);
        return D(n2).f(obj, n2);
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        long a2 = this.q.a();
        p[] pVarArr = this.d;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            int length = pVarArr.length;
            long j3 = 0;
            int i3 = 0;
            while (i3 < length) {
                p pVar = pVarArr[i3];
                int i4 = pVar.c;
                AtomicReferenceArray atomicReferenceArray = pVar.g;
                for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                    o oVar = (o) atomicReferenceArray.get(i5);
                    while (oVar != null) {
                        p[] pVarArr2 = pVarArr;
                        Object v2 = pVar.v(oVar, a2);
                        long j4 = a2;
                        if (v2 != null && this.g.d(obj, v2)) {
                            return true;
                        }
                        oVar = oVar.getNext();
                        pVarArr = pVarArr2;
                        a2 = j4;
                    }
                }
                j3 += pVar.e;
                i3++;
                a2 = a2;
            }
            long j5 = a2;
            p[] pVarArr3 = pVarArr;
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
            pVarArr = pVarArr3;
            a2 = j5;
        }
        return false;
    }

    public p e(int i2, long j2) {
        return new p(this, i2, j2);
    }

    public Set entrySet() {
        Set set = this.u;
        if (set != null) {
            return set;
        }
        h hVar = new h(this);
        this.u = hVar;
        return hVar;
    }

    public boolean f() {
        return this.k != e.c.INSTANCE;
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        ConcurrentMap.-CC.$default$forEach(this, biConsumer);
    }

    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int n2 = n(obj);
        return D(n2).q(obj, n2);
    }

    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return ConcurrentMap.-CC.$default$getOrDefault(this, obj, obj2);
    }

    public boolean h() {
        return this.j >= 0;
    }

    public boolean i() {
        return this.l > 0;
    }

    public boolean isEmpty() {
        p[] pVarArr = this.d;
        long j2 = 0;
        for (int i2 = 0; i2 < pVarArr.length; i2++) {
            if (pVarArr[i2].c != 0) {
                return false;
            }
            j2 += pVarArr[i2].e;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < pVarArr.length; i3++) {
            if (pVarArr[i3].c != 0) {
                return false;
            }
            j2 -= pVarArr[i3].e;
        }
        return j2 == 0;
    }

    public boolean j() {
        return this.m > 0;
    }

    public Object k(Object obj) {
        int n2 = n(com.nytimes.android.external.cache.o.a(obj));
        return D(n2).q(obj, n2);
    }

    public Set keySet() {
        Set set = this.s;
        if (set != null) {
            return set;
        }
        k kVar = new k(this);
        this.s = kVar;
        return kVar;
    }

    public Object m(o oVar, long j2) {
        Object obj;
        if (oVar.getKey() == null || (obj = oVar.getValueReference().get()) == null || o(oVar, j2)) {
            return null;
        }
        return obj;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return ConcurrentMap.-CC.$default$merge(this, obj, obj2, biFunction);
    }

    public int n(Object obj) {
        return B(this.f.e(obj));
    }

    public boolean o(o oVar, long j2) {
        com.nytimes.android.external.cache.o.a(oVar);
        if (!i() || j2 - oVar.getAccessTime() < this.l) {
            return j() && j2 - oVar.getWriteTime() >= this.m;
        }
        return true;
    }

    public long p() {
        long j2 = 0;
        for (int i2 = 0; i2 < this.d.length; i2++) {
            j2 += Math.max(0, r0[i2].c);
        }
        return j2;
    }

    public Object put(Object obj, Object obj2) {
        com.nytimes.android.external.cache.o.a(obj);
        com.nytimes.android.external.cache.o.a(obj2);
        int n2 = n(obj);
        return D(n2).F(obj, n2, obj2, false);
    }

    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        com.nytimes.android.external.cache.o.a(obj);
        com.nytimes.android.external.cache.o.a(obj2);
        int n2 = n(obj);
        return D(n2).F(obj, n2, obj2, true);
    }

    public final p[] q(int i2) {
        return new p[i2];
    }

    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int n2 = n(obj);
        return D(n2).M(obj, n2);
    }

    public Object replace(Object obj, Object obj2) {
        com.nytimes.android.external.cache.o.a(obj);
        com.nytimes.android.external.cache.o.a(obj2);
        int n2 = n(obj);
        return D(n2).T(obj, n2, obj2);
    }

    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        ConcurrentMap.-CC.$default$replaceAll(this, biFunction);
    }

    public int size() {
        return C(p());
    }

    public void u() {
        while (true) {
            com.nytimes.android.external.cache.r rVar = (com.nytimes.android.external.cache.r) this.o.poll();
            if (rVar == null) {
                return;
            }
            try {
                this.p.onRemoval(rVar);
            } catch (Throwable th) {
                v.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    public void v(o oVar) {
        int hash = oVar.getHash();
        D(hash).G(oVar, hash);
    }

    public Collection values() {
        Collection collection = this.t;
        if (collection != null) {
            return collection;
        }
        z zVar = new z(this);
        this.t = zVar;
        return zVar;
    }

    public void w(y yVar) {
        o entry = yVar.getEntry();
        int hash = entry.getHash();
        D(hash).H(entry.getKey(), hash, yVar);
    }

    public boolean x() {
        return i();
    }

    public boolean y() {
        return z() || x();
    }

    public boolean z() {
        return j() || A();
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int n2 = n(obj);
        return D(n2).N(obj, n2, obj2);
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        com.nytimes.android.external.cache.o.a(obj);
        com.nytimes.android.external.cache.o.a(obj3);
        if (obj2 == null) {
            return false;
        }
        int n2 = n(obj);
        return D(n2).U(obj, n2, obj2, obj3);
    }
}
