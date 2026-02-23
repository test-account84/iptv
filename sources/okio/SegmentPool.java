package okio;

import com.google.ads.interactivemedia.v3.internal.z1;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT;
    private static final AtomicReference[] hashBuckets;
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = 65536;
    private static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i = 0; i < highestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        hashBuckets = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference firstRef() {
        Thread currentThread = Thread.currentThread();
        l.d(currentThread, "Thread.currentThread()");
        return hashBuckets[(int) (currentThread.getId() & (HASH_BUCKET_COUNT - 1))];
    }

    public static final void recycle(@NotNull Segment segment) {
        l.e(segment, "segment");
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.shared) {
            return;
        }
        AtomicReference firstRef = INSTANCE.firstRef();
        Segment segment2 = (Segment) firstRef.get();
        if (segment2 == LOCK) {
            return;
        }
        int i = segment2 != null ? segment2.limit : 0;
        if (i >= MAX_SIZE) {
            return;
        }
        segment.next = segment2;
        segment.pos = 0;
        segment.limit = i + 8192;
        if (z1.a(firstRef, segment2, segment)) {
            return;
        }
        segment.next = null;
    }

    @NotNull
    public static final Segment take() {
        AtomicReference firstRef = INSTANCE.firstRef();
        Segment segment = LOCK;
        Segment segment2 = (Segment) firstRef.getAndSet(segment);
        if (segment2 == segment) {
            return new Segment();
        }
        if (segment2 == null) {
            firstRef.set((Object) null);
            return new Segment();
        }
        firstRef.set(segment2.next);
        segment2.next = null;
        segment2.limit = 0;
        return segment2;
    }

    public final int getByteCount() {
        Segment segment = (Segment) firstRef().get();
        if (segment != null) {
            return segment.limit;
        }
        return 0;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
