package C2;

import android.content.Context;
import java.io.Closeable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class v implements Closeable {

    public interface a {
        a a(Context context);

        v build();
    }

    public abstract K2.d a();

    public abstract u c();

    public void close() {
        a().close();
    }
}
