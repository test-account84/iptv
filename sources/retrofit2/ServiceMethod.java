package retrofit2;

import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class ServiceMethod {
    public static ServiceMethod parseAnnotations(Retrofit retrofit, Method method) {
        RequestFactory parseAnnotations = RequestFactory.parseAnnotations(retrofit, method);
        Class genericReturnType = method.getGenericReturnType();
        if (Utils.hasUnresolvableType(genericReturnType)) {
            throw Utils.methodError(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return HttpServiceMethod.parseAnnotations(retrofit, method, parseAnnotations);
        }
        throw Utils.methodError(method, "Service methods cannot return void.", new Object[0]);
    }

    public abstract Object invoke(Object[] objArr);
}
