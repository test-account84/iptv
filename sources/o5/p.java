package O5;

import java.io.File;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p {
    public final String a;
    public final T5.f b;

    public p(String str, T5.f fVar) {
        this.a = str;
        this.b = fVar;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e) {
            L5.f.f().e("Error creating marker: " + this.a, e);
            return false;
        }
    }

    public final File b() {
        return this.b.e(this.a);
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
