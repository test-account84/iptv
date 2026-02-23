package androidx.leanback.widget.picker;

import android.content.res.Resources;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {
    public static final boolean a = true;

    public static class a {
        public final Locale a;
        public final String[] b;
        public final String[] c;

        public a(Locale locale, Resources resources) {
            this.a = locale;
            this.b = DateFormatSymbols.getInstance(locale).getShortMonths();
            Calendar calendar = Calendar.getInstance(locale);
            this.c = a.a(calendar.getMinimum(5), calendar.getMaximum(5), "%02d");
        }
    }

    public static String[] a(int i, int i2, String str) {
        String[] strArr = new String[(i2 - i) + 1];
        for (int i3 = i; i3 <= i2; i3++) {
            int i4 = i3 - i;
            if (str != null) {
                strArr[i4] = String.format(str, new Object[]{Integer.valueOf(i3)});
            } else {
                strArr[i4] = String.valueOf(i3);
            }
        }
        return strArr;
    }

    public static Calendar b(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public static a c(Locale locale, Resources resources) {
        return new a(locale, resources);
    }
}
