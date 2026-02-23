package u4;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b {
    public static final t4.b a = new t4.b("MetadataUtils");
    public static final String[] b;
    public static final String c;

    static {
        String[] strArr = {"Z", "+hh", "+hhmm", "+hh:mm"};
        b = strArr;
        c = "yyyyMMdd'T'HHmmss".concat(String.valueOf(strArr[0]));
    }

    public static Calendar a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            a.a("Input string is empty or null", new Object[0]);
            return null;
        }
        String d = d(str);
        if (TextUtils.isEmpty(d)) {
            a.a("Invalid date format", new Object[0]);
            return null;
        }
        String e = e(str);
        if (TextUtils.isEmpty(e)) {
            str2 = "yyyyMMdd";
        } else {
            d = d + "T" + e;
            str2 = e.length() == 6 ? "yyyyMMdd'T'HHmmss" : c;
        }
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat(str2).parse(d));
            return calendar;
        } catch (ParseException e2) {
            a.d(e2, "Error parsing string", new Object[0]);
            return null;
        }
    }

    public static JSONArray b(List list) {
        list.getClass();
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(((x4.a) it.next()).I());
        }
        return jSONArray;
    }

    public static void c(List list, JSONArray jSONArray) {
        try {
            list.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    list.add(new x4.a(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException unused) {
                }
            }
        } catch (JSONException unused2) {
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            a.a("Input string is empty or null", new Object[0]);
            return null;
        }
        try {
            return str.substring(0, 8);
        } catch (IndexOutOfBoundsException e) {
            a.d(e, "Error extracting the date", new Object[0]);
            return null;
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            a.a("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != 8) {
            a.a("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == 6) {
                return substring;
            }
            char charAt = substring.charAt(6);
            if (charAt != '+' && charAt != '-') {
                if (charAt == 'Z' && substring.length() == b[0].length() + 6) {
                    return String.valueOf(substring.substring(0, substring.length() - 1)).concat("+0000");
                }
                return null;
            }
            int length = substring.length();
            String[] strArr = b;
            if (length == strArr[1].length() + 6 || length == strArr[2].length() + 6 || length == strArr[3].length() + 6) {
                return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            a.d(e, "Error extracting the time substring: %s", new Object[0]);
            return null;
        }
    }
}
