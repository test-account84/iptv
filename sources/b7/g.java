package b7;

import android.content.Context;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g {
    public static List b = new ArrayList();
    public static g c;
    public Context a;

    public static class a {
        public static String a = "http://api-android.whmcssmarters.com/";
        public static String b = "?/Android";
        public static String c = "response_api.php";
    }

    public g(Context context) {
        this.a = context;
    }

    public static e a(String str, String str2) {
        return new e(str, str2);
    }

    public void b(c cVar) {
        new d(this.a, a.b, 1, cVar, "Form", b, Boolean.FALSE).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public void c(c cVar) {
        new d(this.a, a.c, 1, cVar, "Form", b, Boolean.FALSE).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }
}
