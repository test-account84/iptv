package T1;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g implements c {
    public final Uri a;
    public final Context b;
    public Object c;

    public g(Context context, Uri uri) {
        this.b = context.getApplicationContext();
        this.a = uri;
    }

    public void a() {
        Object obj = this.c;
        if (obj != null) {
            try {
                c(obj);
            } catch (IOException e) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e);
                }
            }
        }
    }

    public final Object b(O1.i iVar) {
        Object d = d(this.a, this.b.getContentResolver());
        this.c = d;
        return d;
    }

    public abstract void c(Object obj);

    public abstract Object d(Uri uri, ContentResolver contentResolver);

    public String getId() {
        return this.a.toString();
    }

    public void cancel() {
    }
}
