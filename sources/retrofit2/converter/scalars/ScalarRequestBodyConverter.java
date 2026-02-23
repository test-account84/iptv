package retrofit2.converter.scalars;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class ScalarRequestBodyConverter implements Converter {
    static final ScalarRequestBodyConverter INSTANCE = new ScalarRequestBodyConverter();
    private static final MediaType MEDIA_TYPE = MediaType.get("text/plain; charset=UTF-8");

    private ScalarRequestBodyConverter() {
    }

    public RequestBody convert(Object obj) throws IOException {
        return RequestBody.create(MEDIA_TYPE, String.valueOf(obj));
    }
}
