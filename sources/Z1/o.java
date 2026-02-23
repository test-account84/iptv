package Z1;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o implements S1.b {
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, OutputStream outputStream) {
        byte[] b = q2.a.a().b();
        while (true) {
            try {
                try {
                    int read = inputStream.read(b);
                    if (read == -1) {
                        q2.a.a().c(b);
                        return true;
                    }
                    outputStream.write(b, 0, read);
                } catch (IOException e) {
                    if (Log.isLoggable("StreamEncoder", 3)) {
                        Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                    }
                    q2.a.a().c(b);
                    return false;
                }
            } catch (Throwable th) {
                q2.a.a().c(b);
                throw th;
            }
        }
    }

    public String getId() {
        return "";
    }
}
