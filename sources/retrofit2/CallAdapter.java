package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface CallAdapter {

    public static abstract class Factory {
        public static Type getParameterUpperBound(int i, ParameterizedType parameterizedType) {
            return Utils.getParameterUpperBound(i, parameterizedType);
        }

        public static Class getRawType(Type type) {
            return Utils.getRawType(type);
        }

        public abstract CallAdapter get(Type type, Annotation[] annotationArr, Retrofit retrofit);
    }

    Object adapt(Call call);

    Type responseType();
}
