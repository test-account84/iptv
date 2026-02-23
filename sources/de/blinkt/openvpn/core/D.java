package de.blinkt.openvpn.core;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class d implements Serializable, Cloneable {
    public boolean l;
    public String a = "openvpn.example.com";
    public String c = "1194";
    public boolean d = true;
    public String e = "";
    public boolean f = false;
    public boolean g = true;
    public int h = 0;
    public a i = a.NONE;
    public String j = "proxy.example.com";
    public String k = "8080";
    public String m = null;
    public String n = null;

    public enum a {
        NONE,
        HTTP,
        SOCKS5,
        ORBOT
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return (d) super.clone();
    }

    public String c(boolean z) {
        StringBuilder sb;
        String str;
        String str2 = ((("remote ") + this.a) + " ") + this.c;
        if (this.d) {
            sb = new StringBuilder();
            sb.append(str2);
            str = " udp\n";
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            str = " tcp-client\n";
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (this.h != 0) {
            sb2 = sb2 + String.format(Locale.US, " connect-timeout  %d\n", new Object[]{Integer.valueOf(this.h)});
        }
        if ((z || e()) && this.i == a.HTTP) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            Locale locale = Locale.US;
            sb3.append(String.format(locale, "http-proxy %s %s\n", new Object[]{this.j, this.k}));
            String sb4 = sb3.toString();
            if (this.l) {
                sb2 = sb4 + String.format(locale, "<http-proxy-user-pass>\n%s\n%s\n</http-proxy-user-pass>\n", new Object[]{this.m, this.n});
            } else {
                sb2 = sb4;
            }
        }
        if (e() && this.i == a.SOCKS5) {
            sb2 = sb2 + String.format(Locale.US, "socks-proxy %s %s\n", new Object[]{this.j, this.k});
        }
        if (TextUtils.isEmpty(this.e) || !this.f) {
            return sb2;
        }
        return (sb2 + this.e) + "\n";
    }

    public boolean d() {
        return TextUtils.isEmpty(this.e) || !this.f;
    }

    public boolean e() {
        return this.f && this.e.contains("http-proxy-option ");
    }
}
