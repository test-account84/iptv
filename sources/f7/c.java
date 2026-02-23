package F7;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class c extends AsyncTask {
    public a a;
    public Context b;
    public FileDescriptor c;
    public File d;
    public String e;

    public interface a {
        void a(File file);
    }

    public c(String str, Context context, a aVar) {
        this.b = context;
        this.a = aVar;
        this.e = str;
    }

    public void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        boolean z;
        try {
            URLConnection uRLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
            uRLConnection.setInstanceFollowRedirects(true);
            uRLConnection.connect();
            do {
                if (uRLConnection.getResponseCode() == 301 || uRLConnection.getResponseCode() == 302) {
                    uRLConnection = (HttpURLConnection) new URL(uRLConnection.getHeaderField("Location")).openConnection();
                    uRLConnection.connect();
                    z = true;
                } else {
                    z = false;
                }
            } while (z);
            int contentLength = uRLConnection.getContentLength();
            Log.d("DOWNLOADFILE", "Length of the file: " + contentLength);
            InputStream inputStream = uRLConnection.getInputStream();
            File file = new File(this.e);
            this.d = file;
            a(file.getParent());
            FileOutputStream fileOutputStream = new FileOutputStream(this.d);
            Log.d("DOWNLOADFILE", "file saved at " + this.d.getAbsolutePath());
            this.c = fileOutputStream.getFD();
            byte[] bArr = new byte[1024];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return null;
                }
                j += read;
                publishProgress(new String[]{"" + ((int) ((100 * j) / contentLength))});
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(this.d);
        }
    }

    public void onPreExecute() {
        super.onPreExecute();
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(String... strArr) {
    }
}
