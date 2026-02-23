package O7;

import com.onesignal.S1;
import com.onesignal.l1;
import kotlin.jvm.internal.l;
import org.json.JSONArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class c {
    public final l1 a;

    public c(l1 preferences) {
        l.e(preferences, "preferences");
        this.a = preferences;
    }

    public final void a(P7.c influenceType) {
        l.e(influenceType, "influenceType");
        l1 l1Var = this.a;
        l1Var.f(l1Var.i(), "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE", influenceType.toString());
    }

    public final void b(P7.c influenceType) {
        l.e(influenceType, "influenceType");
        l1 l1Var = this.a;
        l1Var.f(l1Var.i(), "PREFS_OS_OUTCOMES_CURRENT_SESSION", influenceType.toString());
    }

    public final void c(String str) {
        l1 l1Var = this.a;
        l1Var.f(l1Var.i(), "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN", str);
    }

    public final String d() {
        l1 l1Var = this.a;
        return l1Var.d(l1Var.i(), "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN", null);
    }

    public final P7.c e() {
        String obj = P7.c.UNATTRIBUTED.toString();
        l1 l1Var = this.a;
        return P7.c.Companion.a(l1Var.d(l1Var.i(), "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE", obj));
    }

    public final int f() {
        l1 l1Var = this.a;
        return l1Var.h(l1Var.i(), "PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW", 1440);
    }

    public final int g() {
        l1 l1Var = this.a;
        return l1Var.h(l1Var.i(), "PREFS_OS_IAM_LIMIT", 10);
    }

    public final JSONArray h() {
        l1 l1Var = this.a;
        String d = l1Var.d(l1Var.i(), "PREFS_OS_LAST_IAMS_RECEIVED", "[]");
        JSONArray jSONArray = d == null ? null : new JSONArray(d);
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public final JSONArray i() {
        l1 l1Var = this.a;
        String d = l1Var.d(l1Var.i(), "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", "[]");
        JSONArray jSONArray = d == null ? null : new JSONArray(d);
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public final P7.c j() {
        l1 l1Var = this.a;
        return P7.c.Companion.a(l1Var.d(l1Var.i(), "PREFS_OS_OUTCOMES_CURRENT_SESSION", P7.c.UNATTRIBUTED.toString()));
    }

    public final int k() {
        l1 l1Var = this.a;
        return l1Var.h(l1Var.i(), "PREFS_OS_INDIRECT_ATTRIBUTION_WINDOW", 1440);
    }

    public final int l() {
        l1 l1Var = this.a;
        return l1Var.h(l1Var.i(), "PREFS_OS_NOTIFICATION_LIMIT", 10);
    }

    public final boolean m() {
        l1 l1Var = this.a;
        return l1Var.g(l1Var.i(), "PREFS_OS_DIRECT_ENABLED", false);
    }

    public final boolean n() {
        l1 l1Var = this.a;
        return l1Var.g(l1Var.i(), "PREFS_OS_INDIRECT_ENABLED", false);
    }

    public final boolean o() {
        l1 l1Var = this.a;
        return l1Var.g(l1Var.i(), "PREFS_OS_UNATTRIBUTED_ENABLED", false);
    }

    public final void p(JSONArray iams) {
        l.e(iams, "iams");
        l1 l1Var = this.a;
        l1Var.f(l1Var.i(), "PREFS_OS_LAST_IAMS_RECEIVED", iams.toString());
    }

    public final void q(S1.e influenceParams) {
        l.e(influenceParams, "influenceParams");
        l1 l1Var = this.a;
        l1Var.b(l1Var.i(), "PREFS_OS_DIRECT_ENABLED", influenceParams.e());
        l1 l1Var2 = this.a;
        l1Var2.b(l1Var2.i(), "PREFS_OS_INDIRECT_ENABLED", influenceParams.f());
        l1 l1Var3 = this.a;
        l1Var3.b(l1Var3.i(), "PREFS_OS_UNATTRIBUTED_ENABLED", influenceParams.g());
        l1 l1Var4 = this.a;
        l1Var4.a(l1Var4.i(), "PREFS_OS_NOTIFICATION_LIMIT", influenceParams.d());
        l1 l1Var5 = this.a;
        l1Var5.a(l1Var5.i(), "PREFS_OS_INDIRECT_ATTRIBUTION_WINDOW", influenceParams.c());
        l1 l1Var6 = this.a;
        l1Var6.a(l1Var6.i(), "PREFS_OS_IAM_LIMIT", influenceParams.a());
        l1 l1Var7 = this.a;
        l1Var7.a(l1Var7.i(), "PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW", influenceParams.b());
    }

    public final void r(JSONArray notifications) {
        l.e(notifications, "notifications");
        l1 l1Var = this.a;
        l1Var.f(l1Var.i(), "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", notifications.toString());
    }
}
