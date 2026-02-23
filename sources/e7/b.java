package E7;

import a7.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.C;
import com.squareup.picasso.s;
import com.squareup.picasso.t;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.joda.time.LocalDate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class b {
    public static SimpleDateFormat a;
    public static t b;
    public static SharedPreferences c;
    public static Context d;

    public class a implements t.d {
        public void a(t tVar, Uri uri, Exception exc) {
            Log.e("EPGUtil", exc.getMessage());
        }
    }

    public static String a(long j) {
        LocalDate localDate = new LocalDate(j);
        return localDate.dayOfWeek().getAsShortText() + " " + localDate.getDayOfMonth() + "/" + localDate.getMonthOfYear();
    }

    public static String b(Context context, long j) {
        d = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("timeFormat", 0);
        c = sharedPreferences;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sharedPreferences.getString("timeFormat", m7.a.E0), Locale.US);
        a = simpleDateFormat;
        return simpleDateFormat.format(Long.valueOf(j));
    }

    public static void c(Context context) {
        if (b == null) {
            b = new t.b(context).b(new s(new OkHttpClient())).c(new a()).a();
        }
    }

    public static void d(Context context, String str, int i, int i2, C c2) {
        c(context);
        ((str == null || str.equals("")) ? b.j(e.i1) : b.l(str).k(i, i2).b()).i(c2);
    }
}
