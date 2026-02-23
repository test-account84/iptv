package okhttp3;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Callback {
    void onFailure(@NotNull Call call, @NotNull IOException iOException);

    void onResponse(@NotNull Call call, @NotNull Response response) throws IOException;
}
