package O7;

import com.onesignal.P0;
import com.onesignal.t1;
import k8.q;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class b extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c dataRepository, P0 logger, t1 timeProvider) {
        super(dataRepository, logger, timeProvider);
        l.e(dataRepository, "dataRepository");
        l.e(logger, "logger");
        l.e(timeProvider, "timeProvider");
    }

    public void a(JSONObject jsonObject, P7.a influence) {
        l.e(jsonObject, "jsonObject");
        l.e(influence, "influence");
    }

    public void b() {
        P7.c k = k();
        if (k == null) {
            k = P7.c.UNATTRIBUTED;
        }
        c f = f();
        if (k == P7.c.DIRECT) {
            k = P7.c.INDIRECT;
        }
        f.a(k);
    }

    public int c() {
        return f().g();
    }

    public P7.b d() {
        return P7.b.IAM;
    }

    public String h() {
        return "iam_id";
    }

    public int i() {
        return f().f();
    }

    public JSONArray l() {
        return f().h();
    }

    public JSONArray m(String str) {
        try {
            JSONArray l = l();
            try {
                JSONArray jSONArray = new JSONArray();
                int length = l.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        if (!l.a(str, l.getJSONObject(i).getString(h()))) {
                            jSONArray.put(l.getJSONObject(i));
                        }
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    }
                }
                return jSONArray;
            } catch (JSONException e) {
                o().error("Generating tracker lastChannelObjectReceived get JSONObject ", e);
                return l;
            }
        } catch (JSONException e2) {
            o().error("Generating IAM tracker getLastChannelObjects JSONObject ", e2);
            return new JSONArray();
        }
    }

    public void p() {
        P7.c e = f().e();
        if (e.isIndirect()) {
            x(n());
        }
        q qVar = q.a;
        y(e);
        o().debug(l.l("OneSignal InAppMessageTracker initInfluencedTypeFromCache: ", this));
    }

    public void u(JSONArray channelObjects) {
        l.e(channelObjects, "channelObjects");
        f().p(channelObjects);
    }
}
