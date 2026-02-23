package Q7;

import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class d implements b {
    public String getLanguage() {
        String language;
        language = Locale.getDefault().getLanguage();
        language.hashCode();
        switch (language) {
            case "in":
                return "id";
            case "iw":
                return "he";
            case "ji":
                return "yi";
            case "zh":
                return language + "-" + Locale.getDefault().getCountry();
            default:
                return language;
        }
    }
}
