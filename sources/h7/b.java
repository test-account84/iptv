package h7;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends Thread {
    public URL a;

    public b(URL url) {
        this.a = url;
    }

    public void run() {
        HttpURLConnection openConnection;
        DataOutputStream dataOutputStream;
        byte[] bArr = new byte[153600];
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            try {
                openConnection = this.a.openConnection();
                openConnection.setDoOutput(true);
                openConnection.setRequestMethod("POST");
                openConnection.setRequestProperty("Connection", "Keep-Alive");
                dataOutputStream = new DataOutputStream(openConnection.getOutputStream());
                dataOutputStream.write(bArr, 0, 153600);
                dataOutputStream.flush();
                openConnection.getResponseCode();
                c.h = (int) (c.h + (153600 / 1024.0d));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ((System.currentTimeMillis() - currentTimeMillis) / 1000.0d >= 10) {
                return;
            }
            dataOutputStream.close();
            openConnection.disconnect();
        }
    }
}
