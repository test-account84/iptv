package j$.time.format;

import j$.time.ZoneId;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class l implements f {
    public final /* synthetic */ int a;
    private final Object b;

    public /* synthetic */ l(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public final boolean i(p pVar, StringBuilder sb) {
        switch (this.a) {
            case 0:
                sb.append((String) this.b);
                break;
            default:
                ZoneId zoneId = (ZoneId) pVar.f((a) ((j$.time.temporal.t) this.b));
                if (zoneId != null) {
                    sb.append(zoneId.getId());
                    break;
                }
                break;
        }
        return true;
    }

    public final String toString() {
        switch (this.a) {
            case 0:
                return "'" + ((String) this.b).replace("'", "''") + "'";
            default:
                return "ZoneRegionId()";
        }
    }
}
