package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.e;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ EmojiCompatInitializer.b a;
    public final /* synthetic */ e.h c;
    public final /* synthetic */ ThreadPoolExecutor d;

    public /* synthetic */ f(EmojiCompatInitializer.b bVar, e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.a = bVar;
        this.c = hVar;
        this.d = threadPoolExecutor;
    }

    public final void run() {
        EmojiCompatInitializer.b.b(this.a, this.c, this.d);
    }
}
