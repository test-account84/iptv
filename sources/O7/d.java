package O7;

import com.onesignal.P0;
import com.onesignal.t1;
import k8.q;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class d extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c dataRepository, P0 logger, t1 timeProvider) {
        super(dataRepository, logger, timeProvider);
        l.e(dataRepository, "dataRepository");
        l.e(logger, "logger");
        l.e(timeProvider, "timeProvider");
    }

    public void a(JSONObject jsonObject, P7.a influence) {
        l.e(jsonObject, "jsonObject");
        l.e(influence, "influence");
        if (influence.d().isAttributed()) {
            try {
                jsonObject.put("direct", influence.d().isDirect());
                jsonObject.put("notification_ids", influence.b());
            } catch (JSONException e) {
                o().error("Generating notification tracker addSessionData JSONObject ", e);
            }
        }
    }

    public void b() {
        c f = f();
        P7.c k = k();
        if (k == null) {
            k = P7.c.UNATTRIBUTED;
        }
        f.b(k);
        f().c(g());
    }

    public int c() {
        return f().l();
    }

    public P7.b d() {
        return P7.b.NOTIFICATION;
    }

    public String h() {
        return "notification_id";
    }

    public int i() {
        return f().k();
    }

    public JSONArray l() {
        return f().i();
    }

    public JSONArray m(String str) {
        try {
            return l();
        } catch (JSONException e) {
            o().error("Generating Notification tracker getLastChannelObjects JSONObject ", e);
            return new JSONArray();
        }
    }

    public void p() {
        P7.c j = f().j();
        if (j.isIndirect()) {
            x(n());
        } else if (j.isDirect()) {
            w(f().d());
        }
        q qVar = q.a;
        y(j);
        o().debug(l.l("OneSignal NotificationTracker initInfluencedTypeFromCache: ", this));
    }

    public void u(JSONArray channelObjects) {
        l.e(channelObjects, "channelObjects");
        f().r(channelObjects);
    }
}
