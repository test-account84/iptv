package com.google.android.exoplayer2.source.rtsp;

import d4.k0;
import java.util.List;
import java.util.Map;
import s5.D;
import s5.y;
import s5.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e {
    public static final e b = new b().e();
    public final z a;

    public static final class b {
        public final z.a a;

        public b() {
            this.a = new z.a();
        }

        public static /* synthetic */ z.a a(b bVar) {
            return bVar.a;
        }

        public b b(String str, String str2) {
            this.a.e(e.a(str.trim()), str2.trim());
            return this;
        }

        public b c(List list) {
            for (int i = 0; i < list.size(); i++) {
                String[] j1 = k0.j1((String) list.get(i), ":\\s?");
                if (j1.length == 2) {
                    b(j1[0], j1[1]);
                }
            }
            return this;
        }

        public b d(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                b((String) entry.getKey(), (String) entry.getValue());
            }
            return this;
        }

        public e e() {
            return new e(this, null);
        }

        public b(String str, String str2, int i) {
            this();
            b("User-Agent", str);
            b("CSeq", String.valueOf(i));
            if (str2 != null) {
                b("Session", str2);
            }
        }
    }

    public e(b bVar) {
        this.a = b.a(bVar).d();
    }

    public static /* synthetic */ String a(String str) {
        return c(str);
    }

    public static String c(String str) {
        return r5.b.a(str, "Accept") ? "Accept" : r5.b.a(str, "Allow") ? "Allow" : r5.b.a(str, "Authorization") ? "Authorization" : r5.b.a(str, "Bandwidth") ? "Bandwidth" : r5.b.a(str, "Blocksize") ? "Blocksize" : r5.b.a(str, "Cache-Control") ? "Cache-Control" : r5.b.a(str, "Connection") ? "Connection" : r5.b.a(str, "Content-Base") ? "Content-Base" : r5.b.a(str, "Content-Encoding") ? "Content-Encoding" : r5.b.a(str, "Content-Language") ? "Content-Language" : r5.b.a(str, "Content-Length") ? "Content-Length" : r5.b.a(str, "Content-Location") ? "Content-Location" : r5.b.a(str, "Content-Type") ? "Content-Type" : r5.b.a(str, "CSeq") ? "CSeq" : r5.b.a(str, "Date") ? "Date" : r5.b.a(str, "Expires") ? "Expires" : r5.b.a(str, "Location") ? "Location" : r5.b.a(str, "Proxy-Authenticate") ? "Proxy-Authenticate" : r5.b.a(str, "Proxy-Require") ? "Proxy-Require" : r5.b.a(str, "Public") ? "Public" : r5.b.a(str, "Range") ? "Range" : r5.b.a(str, "RTP-Info") ? "RTP-Info" : r5.b.a(str, "RTCP-Interval") ? "RTCP-Interval" : r5.b.a(str, "Scale") ? "Scale" : r5.b.a(str, "Session") ? "Session" : r5.b.a(str, "Speed") ? "Speed" : r5.b.a(str, "Supported") ? "Supported" : r5.b.a(str, "Timestamp") ? "Timestamp" : r5.b.a(str, "Transport") ? "Transport" : r5.b.a(str, "User-Agent") ? "User-Agent" : r5.b.a(str, "Via") ? "Via" : r5.b.a(str, "WWW-Authenticate") ? "WWW-Authenticate" : str;
    }

    public z b() {
        return this.a;
    }

    public String d(String str) {
        y e = e(str);
        if (e.isEmpty()) {
            return null;
        }
        return (String) D.d(e);
    }

    public y e(String str) {
        return this.a.get(c(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.a.equals(((e) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public /* synthetic */ e(b bVar, a aVar) {
        this(bVar);
    }
}
