package pl.droidsonroids.gif;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class GifIOException extends IOException {
    public final b a;
    public final String c;

    public GifIOException(int i, String str) {
        this.a = b.fromCode(i);
        this.c = str;
    }

    public String getMessage() {
        if (this.c == null) {
            return this.a.getFormattedDescription();
        }
        return this.a.getFormattedDescription() + ": " + this.c;
    }
}
