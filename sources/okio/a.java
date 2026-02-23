package okio;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ InputStream a(Path path, OpenOption[] openOptionArr) {
        return Files.newInputStream(path, openOptionArr);
    }
}
