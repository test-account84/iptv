package W1;

import W1.d;
import android.content.Context;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class f extends d {

    public class a implements d.a {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(Context context, String str, int i) {
        super(new a(context, str), i);
    }
}
