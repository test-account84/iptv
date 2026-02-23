package retrofit2.converter.simplexml;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class SimpleXmlConverterFactory extends Converter.Factory {
    private final Serializer serializer;
    private final boolean strict;

    private SimpleXmlConverterFactory(Serializer serializer, boolean z) {
        this.serializer = serializer;
        this.strict = z;
    }

    public static SimpleXmlConverterFactory create() {
        return create(new Persister());
    }

    public static SimpleXmlConverterFactory createNonStrict() {
        return createNonStrict(new Persister());
    }

    public boolean isStrict() {
        return this.strict;
    }

    public Converter requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (type instanceof Class) {
            return new SimpleXmlRequestBodyConverter(this.serializer);
        }
        return null;
    }

    public Converter responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type instanceof Class) {
            return new SimpleXmlResponseBodyConverter((Class) type, this.serializer, this.strict);
        }
        return null;
    }

    public static SimpleXmlConverterFactory create(Serializer serializer) {
        return new SimpleXmlConverterFactory(serializer, true);
    }

    public static SimpleXmlConverterFactory createNonStrict(Serializer serializer) {
        if (serializer != null) {
            return new SimpleXmlConverterFactory(serializer, false);
        }
        throw new NullPointerException("serializer == null");
    }
}
