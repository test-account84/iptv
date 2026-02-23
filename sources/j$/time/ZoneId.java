package j$.time;

import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public abstract class ZoneId implements Serializable {
    public static final Map a;
    private static final long serialVersionUID = 8352817235686L;

    static {
        Map.Entry[] entryArr = {j$.com.android.tools.r8.a.j("ACT", "Australia/Darwin"), j$.com.android.tools.r8.a.j("AET", "Australia/Sydney"), j$.com.android.tools.r8.a.j("AGT", "America/Argentina/Buenos_Aires"), j$.com.android.tools.r8.a.j("ART", "Africa/Cairo"), j$.com.android.tools.r8.a.j("AST", "America/Anchorage"), j$.com.android.tools.r8.a.j("BET", "America/Sao_Paulo"), j$.com.android.tools.r8.a.j("BST", "Asia/Dhaka"), j$.com.android.tools.r8.a.j("CAT", "Africa/Harare"), j$.com.android.tools.r8.a.j("CNT", "America/St_Johns"), j$.com.android.tools.r8.a.j("CST", "America/Chicago"), j$.com.android.tools.r8.a.j("CTT", "Asia/Shanghai"), j$.com.android.tools.r8.a.j("EAT", "Africa/Addis_Ababa"), j$.com.android.tools.r8.a.j("ECT", "Europe/Paris"), j$.com.android.tools.r8.a.j("IET", "America/Indiana/Indianapolis"), j$.com.android.tools.r8.a.j("IST", "Asia/Kolkata"), j$.com.android.tools.r8.a.j("JST", "Asia/Tokyo"), j$.com.android.tools.r8.a.j("MIT", "Pacific/Apia"), j$.com.android.tools.r8.a.j("NET", "Asia/Yerevan"), j$.com.android.tools.r8.a.j("NST", "Pacific/Auckland"), j$.com.android.tools.r8.a.j("PLT", "Asia/Karachi"), j$.com.android.tools.r8.a.j("PNT", "America/Phoenix"), j$.com.android.tools.r8.a.j("PRT", "America/Puerto_Rico"), j$.com.android.tools.r8.a.j("PST", "America/Los_Angeles"), j$.com.android.tools.r8.a.j("SST", "Pacific/Guadalcanal"), j$.com.android.tools.r8.a.j("VST", "Asia/Ho_Chi_Minh"), j$.com.android.tools.r8.a.j("EST", "-05:00"), j$.com.android.tools.r8.a.j("MST", "-07:00"), j$.com.android.tools.r8.a.j("HST", "-10:00")};
        HashMap hashMap = new HashMap(28);
        for (int i = 0; i < 28; i++) {
            Map.Entry entry = entryArr[i];
            Object requireNonNull = Objects.requireNonNull(entry.getKey());
            if (hashMap.put(requireNonNull, Objects.requireNonNull(entry.getValue())) != null) {
                throw new IllegalArgumentException("duplicate key: " + requireNonNull);
            }
        }
        a = Collections.unmodifiableMap(hashMap);
    }

    ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != x.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    static ZoneId D(String str, boolean z) {
        int i;
        Objects.a(str, "zoneId");
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
            return ZoneOffset.J(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            i = 3;
        } else {
            if (!str.startsWith("UT")) {
                return x.H(str, z);
            }
            i = 2;
        }
        return F(str, i, z);
    }

    public static ZoneId E(String str, ZoneOffset zoneOffset) {
        Objects.a(str, "prefix");
        Objects.a(zoneOffset, "offset");
        if (str.isEmpty()) {
            return zoneOffset;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: ".concat(str));
        }
        if (zoneOffset.I() != 0) {
            str = str.concat(zoneOffset.getId());
        }
        return new x(str, j$.time.zone.f.i(zoneOffset));
    }

    private static ZoneId F(String str, int i, boolean z) {
        String substring = str.substring(0, i);
        if (str.length() == i) {
            return E(substring, ZoneOffset.UTC);
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-') {
            return x.H(str, z);
        }
        try {
            ZoneOffset J = ZoneOffset.J(str.substring(i));
            return J == ZoneOffset.UTC ? E(substring, J) : E(substring, J);
        } catch (c e) {
            throw new c("Invalid ID for offset-based ZoneId: ".concat(str), e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static ZoneId systemDefault() {
        String id = TimeZone.getDefault().getID();
        Objects.a(id, "zoneId");
        Map map = a;
        Objects.a(map, "aliasMap");
        String str = (String) map.get(id);
        if (str != null) {
            id = str;
        }
        return D(id, true);
    }

    private Object writeReplace() {
        return new s((byte) 7, this);
    }

    public abstract j$.time.zone.f C();

    abstract void G(DataOutput dataOutput);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return getId().equals(((ZoneId) obj).getId());
        }
        return false;
    }

    public abstract String getId();

    public int hashCode() {
        return getId().hashCode();
    }

    public String toString() {
        return getId();
    }
}
