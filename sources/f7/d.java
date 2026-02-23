package F7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import de.blinkt.openvpn.core.C;
import de.blinkt.openvpn.core.c;
import f8.l;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class d extends AsyncTask {
    public WeakReference a;
    public a b;
    public FileInputStream c;
    public String d;
    public String e;
    public String f;

    public interface a {
        void a();

        void b(String str);
    }

    public d(Context context, FileInputStream fileInputStream, String str, String str2, String str3, a aVar) {
        this.a = new WeakReference(context);
        this.b = aVar;
        this.c = fileInputStream;
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        a aVar;
        String str;
        try {
            Reader bufferedReader = new BufferedReader(new InputStreamReader(this.c));
            de.blinkt.openvpn.core.c cVar = new de.blinkt.openvpn.core.c();
            cVar.o(bufferedReader, this.e, this.f, (Context) this.a.get());
            l f = cVar.f();
            C g = C.g((Context) this.a.get());
            f.d = this.d;
            f.i0 = "com.nst.iptvsmarterstvbox";
            f.B = null;
            f.A = null;
            g.a(f);
            g.o((Context) this.a.get(), f);
            g.q((Context) this.a.get());
            return Boolean.TRUE;
        } catch (c.a unused) {
            cancel(true);
            aVar = this.b;
            str = "ConfigParseError";
            aVar.b(str);
            return Boolean.FALSE;
        } catch (IOException unused2) {
            cancel(true);
            aVar = this.b;
            str = "IOException";
            aVar.b(str);
            return Boolean.FALSE;
        } catch (MalformedURLException unused3) {
            cancel(true);
            aVar = this.b;
            str = "MalformedURLException";
            aVar.b(str);
            return Boolean.FALSE;
        }
    }

    public final boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            this.b.a();
        } else {
            this.b.b("unknown error");
        }
    }

    public void onPreExecute() {
        super.onPreExecute();
        Context context = (Context) this.a.get();
        if (context == null || this.b == null) {
            cancel(true);
        } else {
            if (b(context)) {
                return;
            }
            cancel(true);
            this.b.b("No Network");
        }
    }
}
