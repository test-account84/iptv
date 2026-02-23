package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class GsonResponseBodyConverter implements Converter {
    private final TypeAdapter adapter;
    private final Gson gson;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    public Object convert(ResponseBody responseBody) throws IOException {
        try {
            return this.adapter.read(this.gson.newJsonReader(responseBody.charStream()));
        } finally {
            responseBody.close();
        }
    }
}
