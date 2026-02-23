package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
interface K0 {
    K0 b(int i);

    long count();

    void forEach(Consumer consumer);

    K0 i(long j, long j2, IntFunction intFunction);

    void j(Object[] objArr, int i);

    Object[] p(IntFunction intFunction);

    int r();

    Spliterator spliterator();
}
