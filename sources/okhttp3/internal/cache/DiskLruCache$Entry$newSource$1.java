package okhttp3.internal.cache;

import k8.q;
import okhttp3.internal.cache.DiskLruCache;
import okio.ForwardingSource;
import okio.Source;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DiskLruCache$Entry$newSource$1 extends ForwardingSource {
    final /* synthetic */ Source $fileSource;
    private boolean closed;
    final /* synthetic */ DiskLruCache.Entry this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Entry$newSource$1(DiskLruCache.Entry entry, Source source, Source source2) {
        super(source2);
        this.this$0 = entry;
        this.$fileSource = source;
    }

    public void close() {
        super.close();
        if (this.closed) {
            return;
        }
        this.closed = true;
        synchronized (this.this$0.this$0) {
            try {
                this.this$0.setLockingSourceCount$okhttp(r1.getLockingSourceCount$okhttp() - 1);
                if (this.this$0.getLockingSourceCount$okhttp() == 0 && this.this$0.getZombie$okhttp()) {
                    DiskLruCache.Entry entry = this.this$0;
                    entry.this$0.removeEntry$okhttp(entry);
                }
                q qVar = q.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
