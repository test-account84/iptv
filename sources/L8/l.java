package l8;

import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class l extends k {
    public static int o(Iterable iterable, int i) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
