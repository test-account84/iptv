package P0;

import O0.e;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class q {
    public WebViewProviderBoundaryInterface a;

    public q(WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.a = webViewProviderBoundaryInterface;
    }

    public void a(String str, String[] strArr, e.a aVar) {
        this.a.addWebMessageListener(str, strArr, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new m(aVar)));
    }
}
