package org.simpleframework.xml.core;

import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Function {
    private final boolean contextual;
    private final Method method;

    public Function(Method method) {
        this(method, false);
    }

    public Object call(Context context, Object obj) throws Exception {
        if (obj != null) {
            return this.contextual ? this.method.invoke(obj, new Object[]{context.getSession().getMap()}) : this.method.invoke(obj, (Object[]) null);
        }
        return null;
    }

    public Function(Method method, boolean z) {
        this.contextual = z;
        this.method = method;
    }
}
