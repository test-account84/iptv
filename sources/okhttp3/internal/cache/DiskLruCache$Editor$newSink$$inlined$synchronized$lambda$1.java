package okhttp3.internal.cache;

import java.io.IOException;
import k8.q;
import kotlin.jvm.internal.m;
import okhttp3.internal.cache.DiskLruCache;
import org.jetbrains.annotations.NotNull;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 extends m implements l {
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ DiskLruCache.Editor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(DiskLruCache.Editor editor, int i) {
        super(1);
        this.this$0 = editor;
        this.$index$inlined = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return q.a;
    }

    public final void invoke(@NotNull IOException it) {
        kotlin.jvm.internal.l.e(it, "it");
        synchronized (this.this$0.this$0) {
            this.this$0.detach$okhttp();
            q qVar = q.a;
        }
    }
}
