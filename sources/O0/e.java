package O0;

import P0.o;
import P0.p;
import P0.q;
import P0.r;
import android.net.Uri;
import android.webkit.WebView;
import java.util.Set;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e {
    public static final Uri a = Uri.parse("*");
    public static final Uri b = Uri.parse("");

    public interface a {
        void onPostMessage(WebView webView, c cVar, Uri uri, boolean z, O0.a aVar);
    }

    public static void a(WebView webView, String str, Set set, a aVar) {
        if (!o.S.c()) {
            throw o.a();
        }
        d(webView).a(str, (String[]) set.toArray(new String[0]), aVar);
    }

    public static WebViewProviderBoundaryInterface b(WebView webView) {
        return c().createWebView(webView);
    }

    public static r c() {
        return p.c();
    }

    public static q d(WebView webView) {
        return new q(b(webView));
    }
}
