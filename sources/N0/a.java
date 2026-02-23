package n0;

import android.os.Bundle;
import androidx.lifecycle.N;
import androidx.lifecycle.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import o0.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {

    public interface a {
        c a(int i, Bundle bundle);

        void b(c cVar);

        void c(c cVar, Object obj);
    }

    public static a b(p pVar) {
        return new b(pVar, ((N) pVar).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract c c(int i, Bundle bundle, a aVar);

    public abstract void d();
}
