package m7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends Thread {
    public HashMap a = new HashMap();
    public HashMap c = new HashMap();
    public double d = 0.0d;
    public double e = 0.0d;
    public boolean f = false;

    public HashMap a() {
        return this.a;
    }

    public double b() {
        return this.d;
    }

    public double c() {
        return this.e;
    }

    public HashMap d() {
        return this.c;
    }

    public boolean e() {
        return this.f;
    }

    public void run() {
        try {
            HttpURLConnection openConnection = new URL("https://www.speedtest.net/speedtest-config.php").openConnection();
            openConnection.getContentLength();
            if (openConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.contains("isp=")) {
                            this.d = Double.parseDouble(readLine.split("lat=\"")[1].split(" ")[0].replace("\"", ""));
                            this.e = Double.parseDouble(readLine.split("lon=\"")[1].split(" ")[0].replace("\"", ""));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                bufferedReader.close();
            }
            try {
                HttpURLConnection openConnection2 = new URL("https://www.speedtest.net/speedtest-servers-static.php").openConnection();
                if (openConnection2.getResponseCode() == 200) {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(openConnection2.getInputStream()));
                    int i = 0;
                    while (true) {
                        String readLine2 = bufferedReader2.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        if (readLine2.contains("<server url")) {
                            String str = readLine2.split("server url=\"")[1].split("\"")[0];
                            List asList = Arrays.asList(new String[]{readLine2.split("lat=\"")[1].split("\"")[0], readLine2.split("lon=\"")[1].split("\"")[0], readLine2.split("name=\"")[1].split("\"")[0], readLine2.split("country=\"")[1].split("\"")[0], readLine2.split("cc=\"")[1].split("\"")[0], readLine2.split("sponsor=\"")[1].split("\"")[0], readLine2.split("host=\"")[1].split("\"")[0]});
                            this.a.put(Integer.valueOf(i), str);
                            this.c.put(Integer.valueOf(i), asList);
                            i++;
                        }
                    }
                    bufferedReader2.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
