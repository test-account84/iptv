package I5;

import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class s extends t {
    public final List a;

    public s(List list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.a = list;
    }
}
