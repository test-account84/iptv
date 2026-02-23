package B7;

import android.net.Uri;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class c {
    public static InputFilter a = new b();

    public class a implements InputFilter {
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            while (i < i2) {
                if (Character.isWhitespace(charSequence.charAt(i))) {
                    return "";
                }
                i++;
            }
            return null;
        }
    }

    public class b implements InputFilter {
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            while (i < i2) {
                if (Character.getType(charSequence.charAt(i)) == 19) {
                    return "";
                }
                i++;
            }
            return null;
        }
    }

    public static void a(EditText editText) {
        editText.setFilters(new InputFilter[]{new a()});
    }

    public static boolean b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean c(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }
}
