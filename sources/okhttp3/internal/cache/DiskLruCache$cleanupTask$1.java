package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.internal.concurrent.Task;
import okio.Okio;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DiskLruCache$cleanupTask$1 extends Task {
    final /* synthetic */ DiskLruCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$cleanupTask$1(DiskLruCache diskLruCache, String str) {
        super(str, false, 2, null);
        this.this$0 = diskLruCache;
    }

    public long runOnce() {
        synchronized (this.this$0) {
            if (!DiskLruCache.access$getInitialized$p(this.this$0) || this.this$0.getClosed$okhttp()) {
                return -1L;
            }
            try {
                this.this$0.trimToSize();
            } catch (IOException unused) {
                DiskLruCache.access$setMostRecentTrimFailed$p(this.this$0, true);
            }
            try {
                if (DiskLruCache.access$journalRebuildRequired(this.this$0)) {
                    this.this$0.rebuildJournal$okhttp();
                    DiskLruCache.access$setRedundantOpCount$p(this.this$0, 0);
                }
            } catch (IOException unused2) {
                DiskLruCache.access$setMostRecentRebuildFailed$p(this.this$0, true);
                DiskLruCache.access$setJournalWriter$p(this.this$0, Okio.buffer(Okio.blackhole()));
            }
            return -1L;
        }
    }
}
