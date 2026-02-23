package retrofit2.converter.simplexml;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class SimpleXmlRequestBodyConverter implements Converter {
    private static final String CHARSET = "UTF-8";
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/xml; charset=UTF-8");
    private final Serializer serializer;

    public SimpleXmlRequestBodyConverter(Serializer serializer) {
        this.serializer = serializer;
    }

    public RequestBody convert(Object obj) throws IOException {
        Buffer buffer = new Buffer();
        try {
            Writer outputStreamWriter = new OutputStreamWriter(buffer.outputStream(), "UTF-8");
            this.serializer.write(obj, outputStreamWriter);
            outputStreamWriter.flush();
            return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
