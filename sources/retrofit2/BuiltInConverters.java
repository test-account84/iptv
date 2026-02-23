package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import k8.q;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    public static final class BufferingResponseBodyConverter implements Converter {
        static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return Utils.buffer(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    public static final class RequestBodyConverter implements Converter {
        static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter {
        static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    public static final class ToStringConverter implements Converter {
        static final ToStringConverter INSTANCE = new ToStringConverter();

        public String convert(Object obj) {
            return obj.toString();
        }
    }

    public static final class UnitResponseBodyConverter implements Converter {
        static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        public q convert(ResponseBody responseBody) {
            responseBody.close();
            return q.a;
        }
    }

    public static final class VoidResponseBodyConverter implements Converter {
        static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    public Converter requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (RequestBody.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    public Converter responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            return Utils.isAnnotationPresent(annotationArr, Streaming.class) ? StreamingResponseBodyConverter.INSTANCE : BufferingResponseBodyConverter.INSTANCE;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        if (!this.checkForKotlinUnit || type != q.class) {
            return null;
        }
        try {
            return UnitResponseBodyConverter.INSTANCE;
        } catch (NoClassDefFoundError unused) {
            this.checkForKotlinUnit = false;
            return null;
        }
    }
}
