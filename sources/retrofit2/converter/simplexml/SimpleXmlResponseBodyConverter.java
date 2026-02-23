package retrofit2.converter.simplexml;

import java.io.IOException;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class SimpleXmlResponseBodyConverter implements Converter {
    private final Class cls;
    private final Serializer serializer;
    private final boolean strict;

    public SimpleXmlResponseBodyConverter(Class cls, Serializer serializer, boolean z) {
        this.cls = cls;
        this.serializer = serializer;
        this.strict = z;
    }

    public Object convert(ResponseBody responseBody) throws IOException {
        try {
            try {
                Object read = this.serializer.read(this.cls, responseBody.charStream(), this.strict);
                if (read != null) {
                    return read;
                }
                throw new IllegalStateException("Could not deserialize body as " + this.cls);
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            } catch (RuntimeException e3) {
                throw e3;
            }
        } finally {
            responseBody.close();
        }
    }
}
