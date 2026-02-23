package P0;

import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class l implements WebMessageBoundaryInterface {
    public static O0.d[] a(InvocationHandler[] invocationHandlerArr) {
        O0.d[] dVarArr = new O0.d[invocationHandlerArr.length];
        for (int i = 0; i < invocationHandlerArr.length; i++) {
            dVarArr[i] = new n(invocationHandlerArr[i]);
        }
        return dVarArr;
    }

    public static O0.c b(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        return new O0.c(webMessageBoundaryInterface.getData(), a(webMessageBoundaryInterface.getPorts()));
    }
}
