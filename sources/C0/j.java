package C0;

import G0.c;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j implements c.c {
    public final String a;
    public final File b;
    public final c.c c;

    public j(String str, File file, c.c cVar) {
        this.a = str;
        this.b = file;
        this.c = cVar;
    }

    public G0.c a(c.b bVar) {
        return new i(bVar.a, this.a, this.b, bVar.c.a, this.c.a(bVar));
    }
}
