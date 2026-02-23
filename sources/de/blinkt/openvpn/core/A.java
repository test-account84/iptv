package de.blinkt.openvpn.core;

import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a {
    public String a;
    public int b;

    public a(String str, int i) {
        this.b = i;
        this.a = str;
    }

    public static int a(String str) {
        long c = c(str) + 4294967296L;
        int i = 0;
        while ((1 & c) == 0) {
            i++;
            c >>= 1;
        }
        if (c != (8589934591 >> i)) {
            return 32;
        }
        return 32 - i;
    }

    public static long c(String str) {
        return (Long.parseLong(str.split("\\.")[0]) << 24) + (Integer.parseInt(r4[1]) << 16) + (Integer.parseInt(r4[2]) << 8) + Integer.parseInt(r4[3]);
    }

    public long b() {
        return c(this.a);
    }

    public boolean d() {
        long c = c(this.a);
        long j = (4294967295 << (32 - this.b)) & c;
        if (j == c) {
            return false;
        }
        this.a = String.format(Locale.US, "%d.%d.%d.%d", new Object[]{Long.valueOf(((-16777216) & j) >> 24), Long.valueOf((16711680 & j) >> 16), Long.valueOf((65280 & j) >> 8), Long.valueOf(j & 255)});
        return true;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%s/%d", new Object[]{this.a, Integer.valueOf(this.b)});
    }

    public a(String str, String str2) {
        this.a = str;
        this.b = a(str2);
    }
}
