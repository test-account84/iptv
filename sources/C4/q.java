package c4;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q implements o {
    public static final q c = new q(Collections.emptyMap());
    public int a;
    public final Map b;

    public q(Map map) {
        this.b = Collections.unmodifiableMap(map);
    }

    public static void c(HashMap hashMap, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), g(entry.getValue()));
        }
    }

    public static Map d(Map map, p pVar) {
        HashMap hashMap = new HashMap(map);
        i(hashMap, pVar.c());
        c(hashMap, pVar.b());
        return hashMap;
    }

    public static byte[] g(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(r5.d.c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public static boolean h(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void i(HashMap hashMap, List list) {
        for (int i = 0; i < list.size(); i++) {
            hashMap.remove(list.get(i));
        }
    }

    public final long a(String str, long j) {
        byte[] bArr = (byte[]) this.b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j;
    }

    public final String b(String str, String str2) {
        byte[] bArr = (byte[]) this.b.get(str);
        return bArr != null ? new String(bArr, r5.d.c) : str2;
    }

    public q e(p pVar) {
        Map d = d(this.b, pVar);
        return h(this.b, d) ? this : new q(d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return h(this.b, ((q) obj).b);
    }

    public Set f() {
        return this.b.entrySet();
    }

    public int hashCode() {
        if (this.a == 0) {
            int i = 0;
            for (Map.Entry entry : this.b.entrySet()) {
                i += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.a = i;
        }
        return this.a;
    }
}
