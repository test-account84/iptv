package C2;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class j {
    public static Executor a() {
        return new n(Executors.newSingleThreadExecutor());
    }
}
