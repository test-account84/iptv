package n1;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import okhttp3.ResponseBody;
import p1.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements e {
    public final Gson a;
    public final TypeAdapter b;

    public b(Gson gson, TypeAdapter typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object convert(ResponseBody responseBody) {
        try {
            return this.b.read(this.a.newJsonReader(responseBody.charStream()));
        } finally {
            responseBody.close();
        }
    }
}
