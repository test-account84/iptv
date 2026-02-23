package m7;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import org.jsoup.Jsoup;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends AsyncTask {
    public Context a;
    public String b;

    public b(Context context) {
        this.b = "";
        this.a = context;
        try {
            this.b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String a(String str) {
        return str.replaceAll("[\\-\\+\\.\\^:,]", "");
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        try {
            return Jsoup.connect("https://play.google.com/store/apps/details?id=com.nst.iptvsmarterstvbox&hl=en").timeout(3000).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").referrer("http://www.google.com").get().select(" div.hAyfc:nth-child(4) > span:nth-child(2) >div:nth-child(1) > span:nth-child(1)").first().ownText();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        int i;
        int i2;
        super.onPostExecute(str);
        if (str == null || str.isEmpty()) {
            SharepreferenceDBHandler.setIsupdate(false, this.a);
            SharepreferenceDBHandler.setIsAppExistOnPlayStore(false, this.a);
            return;
        }
        SharepreferenceDBHandler.setIsAppExistOnPlayStore(true, this.a);
        if (str.matches("\\d\\.\\d") || str.matches("\\d\\.\\d\\.\\d") || str.matches("\\d\\.\\d\\.\\d\\.\\d")) {
            String a = a(str);
            String a2 = a(this.b);
            if (a.length() > a2.length()) {
                int length = a.length() - a2.length();
                StringBuffer stringBuffer = new StringBuffer(a2);
                for (int i3 = 0; i3 < length; i3++) {
                    stringBuffer.append(0);
                }
                a2 = stringBuffer.toString();
            } else if (a.length() < a2.length()) {
                int length2 = a2.length() - a.length();
                StringBuffer stringBuffer2 = new StringBuffer(a);
                for (int i4 = 0; i4 < length2; i4++) {
                    stringBuffer2.append(0);
                }
                a = stringBuffer2.toString();
            }
            try {
                i = Integer.parseInt(a);
                i2 = Integer.parseInt(a2);
            } catch (NumberFormatException unused) {
                i = 1;
                i2 = 1;
            }
            if (i > i2) {
                SharepreferenceDBHandler.setIsupdate(true, this.a);
                return;
            }
        }
        SharepreferenceDBHandler.setIsupdate(false, this.a);
    }
}
