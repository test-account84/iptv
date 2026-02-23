package n1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import p1.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a extends e.a {
    public final Gson a;

    public a(Gson gson) {
        this.a = gson;
    }

    public e a(Type type) {
        return new b(this.a, this.a.getAdapter(TypeToken.get(type)));
    }
}
