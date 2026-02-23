package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class o {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "lastScheduledTask");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(o.class, "producerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(o.class, "consumerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(o.class, "blockingTasksInBuffer");
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);

    @NotNull
    private volatile /* synthetic */ Object lastScheduledTask = null;

    @NotNull
    private volatile /* synthetic */ int producerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int consumerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ h b(o oVar, h hVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oVar.a(hVar, z);
    }

    public final h a(h hVar, boolean z) {
        if (z) {
            return c(hVar);
        }
        h hVar2 = (h) b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return c(hVar2);
    }

    public final h c(h hVar) {
        if (hVar.c.b() == 1) {
            e.incrementAndGet(this);
        }
        if (e() == 127) {
            return hVar;
        }
        int i = this.producerIndex & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, hVar);
        c.incrementAndGet(this);
        return null;
    }

    public final void d(h hVar) {
        if (hVar == null || hVar.c.b() != 1) {
            return;
        }
        e.decrementAndGet(this);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(d dVar) {
        h hVar = (h) b.getAndSet(this, (Object) null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (j(dVar)) {
        }
    }

    public final h h() {
        h hVar = (h) b.getAndSet(this, (Object) null);
        return hVar == null ? i() : hVar;
    }

    public final h i() {
        h hVar;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (hVar = (h) this.a.getAndSet(i2, (Object) null)) != null) {
                d(hVar);
                return hVar;
            }
        }
    }

    public final boolean j(d dVar) {
        h i = i();
        if (i == null) {
            return false;
        }
        dVar.a(i);
        return true;
    }

    public final long k(o oVar) {
        int i = oVar.producerIndex;
        AtomicReferenceArray atomicReferenceArray = oVar.a;
        for (int i2 = oVar.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (oVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = (h) atomicReferenceArray.get(i3);
            if (hVar != null && hVar.c.b() == 1 && n.a(atomicReferenceArray, i3, hVar, null)) {
                e.decrementAndGet(oVar);
                b(this, hVar, false, 2, null);
                return -1L;
            }
        }
        return m(oVar, true);
    }

    public final long l(o oVar) {
        h i = oVar.i();
        if (i == null) {
            return m(oVar, false);
        }
        b(this, i, false, 2, null);
        return -1L;
    }

    public final long m(o oVar, boolean z) {
        h hVar;
        do {
            hVar = (h) oVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z && hVar.c.b() != 1) {
                return -2L;
            }
            long a = l.e.a() - hVar.a;
            long j = l.a;
            if (a < j) {
                return j - a;
            }
        } while (!t.b.a(b, oVar, hVar, (Object) null));
        b(this, hVar, false, 2, null);
        return -1L;
    }
}
