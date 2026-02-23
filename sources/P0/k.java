package P0;

import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k extends O0.a {
    public JsReplyProxyBoundaryInterface a;

    public class a implements Callable {
        public final /* synthetic */ JsReplyProxyBoundaryInterface a;

        public a(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
            this.a = jsReplyProxyBoundaryInterface;
        }

        public Object call() {
            return new k(this.a);
        }
    }

    public k(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.a = jsReplyProxyBoundaryInterface;
    }

    public static k a(InvocationHandler invocationHandler) {
        JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(JsReplyProxyBoundaryInterface.class, invocationHandler);
        return (k) jsReplyProxyBoundaryInterface.getOrCreatePeer(new a(jsReplyProxyBoundaryInterface));
    }
}
