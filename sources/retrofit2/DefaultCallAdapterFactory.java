package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new DefaultCallAdapterFactory();

    public class 1 implements CallAdapter {
        final /* synthetic */ Type val$responseType;

        public 1(Type type) {
            this.val$responseType = type;
        }

        public Type responseType() {
            return this.val$responseType;
        }

        public Call adapt(Call call) {
            return call;
        }
    }

    public CallAdapter get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != Call.class) {
            return null;
        }
        return new 1(Utils.getCallResponseType(type));
    }
}
