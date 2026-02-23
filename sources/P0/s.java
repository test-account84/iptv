package P0;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class s implements r {
    public final WebViewProviderFactoryBoundaryInterface a;

    public s(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.a = webViewProviderFactoryBoundaryInterface;
    }

    public String[] a() {
        return this.a.getSupportedFeatures();
    }

    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderBoundaryInterface.class, this.a.createWebView(webView));
    }
}
