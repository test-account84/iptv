package j$.io;

import j$.util.Spliterators;
import j$.util.stream.Stream;
import j$.util.stream.y0;
import java.io.BufferedReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class DesugarBufferedReader {
    public static Stream lines(BufferedReader bufferedReader) {
        return y0.f0(Spliterators.n(new a(bufferedReader), 272), false);
    }
}
