package z1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class j {
    public static j a() {
        return new j();
    }

    public static void e(Object obj, J1.h hVar) {
        String d;
        if (obj == null) {
            hVar.h();
            return;
        }
        if (obj instanceof String) {
            d = (String) obj;
        } else {
            if (obj instanceof Boolean) {
                hVar.q(((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof Number) {
                hVar.o((Number) obj);
                return;
            }
            if (!(obj instanceof d)) {
                if (!(obj instanceof List)) {
                    throw new RuntimeException("Unsupported record value type: " + obj.getClass());
                }
                hVar.a();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    e(it.next(), hVar);
                }
                hVar.d();
                return;
            }
            d = ((d) obj).d();
        }
        hVar.p(d);
    }

    public Map b(String str) {
        return c(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes()))));
    }

    public Map c(BufferedSource bufferedSource) {
        return J1.a.b(J1.a.a(bufferedSource)).u();
    }

    public String d(Map map) {
        x1.g.c(map, "fields == null");
        Buffer buffer = new Buffer();
        J1.h i = J1.h.i(buffer);
        i.m(true);
        try {
            i.c();
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                i.g(str);
                e(value, i);
            }
            i.e();
            i.close();
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
