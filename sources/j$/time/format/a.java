package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class a implements j$.time.temporal.t {
    public final Object a(j$.time.temporal.o oVar) {
        ZoneId zoneId = (ZoneId) oVar.t(j$.time.temporal.n.k());
        if (zoneId == null || (zoneId instanceof ZoneOffset)) {
            return null;
        }
        return zoneId;
    }
}
