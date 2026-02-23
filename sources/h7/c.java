package h7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends Thread {
    public static int h;
    public String a;
    public double c = 0.0d;
    public boolean d = false;
    public double e = 0.0d;
    public double f = 0.0d;
    public long g;

    public c(String str) {
        this.a = str;
    }

    public double a() {
        return d(this.f, 2);
    }

    public double b() {
        try {
            new BigDecimal(h);
            if (h < 0) {
                return 0.0d;
            }
            double currentTimeMillis = (System.currentTimeMillis() - this.g) / 1000.0d;
            this.e = currentTimeMillis;
            return d(((h / 1000.0d) * 8.0d) / currentTimeMillis, 2);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public boolean c() {
        return this.d;
    }

    public final double d(double d, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        try {
            return new BigDecimal(d).setScale(i, RoundingMode.HALF_UP).doubleValue();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public void run() {
        try {
            URL url = new URL(this.a);
            h = 0;
            this.g = System.currentTimeMillis();
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
            for (int i = 0; i < 4; i++) {
                newFixedThreadPool.execute(new b(url));
            }
            newFixedThreadPool.shutdown();
            while (!newFixedThreadPool.isTerminated()) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
            double currentTimeMillis = (System.currentTimeMillis() - this.g) / 1000.0d;
            this.c = currentTimeMillis;
            this.f = ((h / 1000.0d) * 8.0d) / currentTimeMillis;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = true;
    }
}
