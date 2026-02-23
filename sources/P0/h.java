package P0;

import android.os.Looper;
import android.webkit.TracingController;
import android.webkit.WebView;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h {
    public static TracingController a() {
        return f.a();
    }

    public static ClassLoader b() {
        return e.a();
    }

    public static Looper c(WebView webView) {
        return c.a(webView);
    }

    public static boolean d(TracingController tracingController) {
        return d.a(tracingController);
    }

    public static void e(TracingController tracingController, O0.b bVar) {
        g.a();
        throw null;
    }

    public static boolean f(TracingController tracingController, OutputStream outputStream, Executor executor) {
        return b.a(tracingController, outputStream, executor);
    }
}
