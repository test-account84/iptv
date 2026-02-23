package h7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends Thread {
    public String c;
    public int d;
    public HashMap a = new HashMap();
    public double e = 0.0d;
    public double f = 0.0d;
    public boolean g = false;
    public boolean h = false;

    public d(String str, int i) {
        this.c = str;
        this.d = i;
    }

    public double a() {
        return this.f;
    }

    public double b() {
        return this.e;
    }

    public boolean c() {
        return this.g;
    }

    public void run() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(new String[]{"ping", "-c" + this.d, this.c});
            processBuilder.redirectErrorStream(true);
            Process start = processBuilder.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains("icmp_seq")) {
                    this.e = Double.parseDouble(readLine.split(" ")[readLine.split(" ").length - 2].replace("time=", ""));
                }
                if (readLine.startsWith("rtt ")) {
                    this.f = Double.parseDouble(readLine.split("/")[4]);
                    break;
                }
            }
            start.waitFor();
            bufferedReader.close();
        } catch (Exception e) {
            e = e;
            e.printStackTrace();
            this.g = true;
        } catch (InterruptedException e2) {
            e = e2;
            e.printStackTrace();
            this.g = true;
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            this.g = true;
        }
        this.g = true;
    }
}
