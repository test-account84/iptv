package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import okhttp3.Call;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class HttpServiceMethod extends ServiceMethod {
    private final CallAdapter callAdapter;
    private final Call.Factory callFactory;
    private final RequestFactory requestFactory;
    private final Converter responseConverter;

    private HttpServiceMethod(RequestFactory requestFactory, Call.Factory factory, CallAdapter callAdapter, Converter converter) {
        this.requestFactory = requestFactory;
        this.callFactory = factory;
        this.callAdapter = callAdapter;
        this.responseConverter = converter;
    }

    private static CallAdapter createCallAdapter(Retrofit retrofit, Method method) {
        Type genericReturnType = method.getGenericReturnType();
        try {
            return retrofit.callAdapter(genericReturnType, method.getAnnotations());
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    private static Converter createResponseConverter(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create converter for %s", type);
        }
    }

    public static HttpServiceMethod parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory) {
        CallAdapter createCallAdapter = createCallAdapter(retrofit, method);
        Type responseType = createCallAdapter.responseType();
        if (responseType == Response.class || responseType == okhttp3.Response.class) {
            throw Utils.methodError(method, "'" + Utils.getRawType(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (requestFactory.httpMethod.equals("HEAD") && !Void.class.equals(responseType)) {
            throw Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        return new HttpServiceMethod(requestFactory, retrofit.callFactory, createCallAdapter, createResponseConverter(retrofit, method, responseType));
    }

    public Object invoke(Object[] objArr) {
        return this.callAdapter.adapt(new OkHttpCall(this.requestFactory, objArr, this.callFactory, this.responseConverter));
    }
}
