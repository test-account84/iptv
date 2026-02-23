package com.onesignal;

import android.content.ContentValues;
import android.database.Cursor;
import com.onesignal.F1;
import com.onesignal.T1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class M0 {
    public final M1 a;
    public final P0 b;
    public final l1 c;
    public int d = 0;

    public class a extends JSONObject {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public a(String str, int i, String str2, String str3, String str4, boolean z) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = z;
            put("app_id", str);
            put("device_type", i);
            put("player_id", str2);
            put("click_id", str3);
            put("variant_id", str4);
            if (z) {
                put("first_click", true);
            }
        }
    }

    public class b extends T1.g {
        public final /* synthetic */ Set a;
        public final /* synthetic */ i b;

        public b(Set set, i iVar) {
            this.a = set;
            this.b = iVar;
        }

        public void a(int i, String str, Throwable th) {
            M0.c(M0.this, "engagement", i, str);
            this.b.a(str);
        }

        public void b(String str) {
            M0.a(M0.this, "engagement", str);
            M0.b(M0.this, this.a);
        }
    }

    public class c extends JSONObject {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;

        public c(String str, String str2, String str3, int i, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
            this.e = str4;
            put("app_id", str);
            put("player_id", str2);
            put("variant_id", str3);
            put("device_type", i);
            put("page_id", str4);
        }
    }

    public class d extends T1.g {
        public final /* synthetic */ Set a;
        public final /* synthetic */ i b;

        public d(Set set, i iVar) {
            this.a = set;
            this.b = iVar;
        }

        public void a(int i, String str, Throwable th) {
            M0.c(M0.this, "page impression", i, str);
            this.b.a(str);
        }

        public void b(String str) {
            M0.a(M0.this, "page impression", str);
            M0.this.C(this.a);
        }
    }

    public class e extends JSONObject {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;

        public e(String str, String str2, String str3, int i) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
            put("app_id", str);
            put("player_id", str2);
            put("variant_id", str3);
            put("device_type", i);
            put("first_impression", true);
        }
    }

    public class f extends T1.g {
        public final /* synthetic */ Set a;
        public final /* synthetic */ i b;

        public f(Set set, i iVar) {
            this.a = set;
            this.b = iVar;
        }

        public void a(int i, String str, Throwable th) {
            M0.c(M0.this, "impression", i, str);
            this.b.a(str);
        }

        public void b(String str) {
            M0.a(M0.this, "impression", str);
            M0.d(M0.this, this.a);
        }
    }

    public class g extends T1.g {
        public final /* synthetic */ i a;

        public g(i iVar) {
            this.a = iVar;
        }

        public void a(int i, String str, Throwable th) {
            M0.c(M0.this, "html", i, str);
            this.a.a(str);
        }

        public void b(String str) {
            this.a.onSuccess(str);
        }
    }

    public class h extends T1.g {
        public final /* synthetic */ i a;

        public h(i iVar) {
            this.a = iVar;
        }

        public void a(int i, String str, Throwable th) {
            M0.c(M0.this, "html", i, str);
            JSONObject jSONObject = new JSONObject();
            try {
                if (!OSUtils.U(i) || M0.e(M0.this) >= OSUtils.a) {
                    M0.f(M0.this, 0);
                    jSONObject.put("retry", false);
                } else {
                    M0.g(M0.this);
                    jSONObject.put("retry", true);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.a.a(jSONObject.toString());
        }

        public void b(String str) {
            M0.f(M0.this, 0);
            this.a.onSuccess(str);
        }
    }

    public interface i {
        void a(String str);

        void onSuccess(String str);
    }

    public M0(M1 m1, P0 p0, l1 l1Var) {
        this.a = m1;
        this.b = p0;
        this.c = l1Var;
    }

    public static /* synthetic */ void a(M0 m0, String str, String str2) {
        m0.v(str, str2);
    }

    public static /* synthetic */ void b(M0 m0, Set set) {
        m0.w(set);
    }

    public static /* synthetic */ void c(M0 m0, String str, int i2, String str2) {
        m0.u(str, i2, str2);
    }

    public static /* synthetic */ void d(M0 m0, Set set) {
        m0.z(set);
    }

    public static /* synthetic */ int e(M0 m0) {
        return m0.d;
    }

    public static /* synthetic */ int f(M0 m0, int i2) {
        m0.d = i2;
        return i2;
    }

    public static /* synthetic */ int g(M0 m0) {
        int i2 = m0.d;
        m0.d = i2 + 1;
        return i2;
    }

    public synchronized void A(D0 d0) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_id", d0.a);
        contentValues.put("display_quantity", Integer.valueOf(d0.e().a()));
        contentValues.put("last_display", Long.valueOf(d0.e().b()));
        contentValues.put("click_ids", d0.c().toString());
        contentValues.put("displayed_in_session", Boolean.valueOf(d0.g()));
        if (this.a.a("in_app_message", contentValues, "message_id = ?", new String[]{d0.a}) == 0) {
            this.a.g("in_app_message", null, contentValues);
        }
    }

    public void B(Date date) {
        this.c.f(R1.a, "PREFS_OS_LAST_TIME_IAM_DISMISSED", date != null ? date.toString() : null);
    }

    public void C(Set set) {
        this.c.e(R1.a, "PREFS_OS_PAGE_IMPRESSIONED_IAMS", set);
    }

    public void D(String str, String str2, String str3, int i2, String str4, String str5, boolean z, Set set, i iVar) {
        try {
            T1.j("in_app_messages/" + str4 + "/click", new a(str, i2, str2, str5, str3, z), new b(set, iVar));
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.b.error("Unable to execute in-app message action HTTP request due to invalid JSON");
        }
    }

    public void E(String str, String str2, String str3, int i2, String str4, Set set, i iVar) {
        try {
            T1.j("in_app_messages/" + str4 + "/impression", new e(str, str2, str3, i2), new f(set, iVar));
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.b.error("Unable to execute in-app message impression HTTP request due to invalid JSON");
        }
    }

    public void F(String str, String str2, String str3, int i2, String str4, String str5, Set set, i iVar) {
        try {
            T1.j("in_app_messages/" + str4 + "/pageImpression", new c(str, str2, str3, i2, str5), new d(set, iVar));
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.b.error("Unable to execute in-app message impression HTTP request due to invalid JSON");
        }
    }

    public synchronized void h() {
        String[] strArr = {"message_id", "click_ids"};
        String[] strArr2 = {String.valueOf((System.currentTimeMillis() / 1000) - 15552000)};
        Set K = OSUtils.K();
        Set K2 = OSUtils.K();
        Cursor cursor = null;
        try {
            try {
                cursor = this.a.d("in_app_message", strArr, "last_display < ?", strArr2, null, null, null);
            } finally {
                if (0 != 0 && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            if (0 != 0 && !cursor.isClosed()) {
            }
        }
        if (cursor != null && cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(cursor.getColumnIndex("message_id"));
                    String string2 = cursor.getString(cursor.getColumnIndex("click_ids"));
                    K.add(string);
                    K2.addAll(OSUtils.L(new JSONArray(string2)));
                } while (cursor.moveToNext());
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            this.a.e("in_app_message", "last_display < ?", strArr2);
            j(K);
            i(K2);
            return;
        }
        F1.c1(F1.v.DEBUG, "Attempted to clean 6 month old IAM data, but none exists!");
    }

    public final void i(Set set) {
        String str;
        Set g2;
        if (set == null || set.size() <= 0 || (g2 = R1.g((str = R1.a), "PREFS_OS_CLICKED_CLICK_IDS_IAMS", null)) == null || g2.size() <= 0) {
            return;
        }
        g2.removeAll(set);
        R1.n(str, "PREFS_OS_CLICKED_CLICK_IDS_IAMS", g2);
    }

    public final void j(Set set) {
        if (set == null || set.size() <= 0) {
            return;
        }
        String str = R1.a;
        Set g2 = R1.g(str, "PREFS_OS_DISPLAYED_IAMS", null);
        Set g3 = R1.g(str, "PREFS_OS_IMPRESSIONED_IAMS", null);
        if (g2 != null && g2.size() > 0) {
            g2.removeAll(set);
            R1.n(str, "PREFS_OS_DISPLAYED_IAMS", g2);
        }
        if (g3 == null || g3.size() <= 0) {
            return;
        }
        g3.removeAll(set);
        R1.n(str, "PREFS_OS_IMPRESSIONED_IAMS", g3);
    }

    public synchronized List k() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.a.d("in_app_message", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(cursor.getColumnIndex("message_id"));
                        String string2 = cursor.getString(cursor.getColumnIndex("click_ids"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("display_quantity"));
                        long j = cursor.getLong(cursor.getColumnIndex("last_display"));
                        boolean z = true;
                        if (cursor.getInt(cursor.getColumnIndex("displayed_in_session")) != 1) {
                            z = false;
                        }
                        arrayList.add(new D0(string, OSUtils.L(new JSONArray(string2)), z, new L0(i2, j)));
                    } while (cursor.moveToNext());
                }
            } catch (JSONException e2) {
                F1.b(F1.v.ERROR, "Generating JSONArray from iam click ids:JSON Failed.", e2);
                if (cursor != null && !cursor.isClosed()) {
                }
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    public Set l() {
        return this.c.c(R1.a, "PREFS_OS_CLICKED_CLICK_IDS_IAMS", null);
    }

    public Set m() {
        return this.c.c(R1.a, "PREFS_OS_DISPLAYED_IAMS", null);
    }

    public void n(String str, String str2, String str3, i iVar) {
        T1.e(t(str2, str3, str), new h(iVar), null);
    }

    public void o(String str, String str2, i iVar) {
        T1.e("in_app_messages/device_preview?preview_id=" + str2 + "&app_id=" + str, new g(iVar), null);
    }

    public Set p() {
        return this.c.c(R1.a, "PREFS_OS_IMPRESSIONED_IAMS", null);
    }

    public Date q() {
        String d2 = this.c.d(R1.a, "PREFS_OS_LAST_TIME_IAM_DISMISSED", null);
        if (d2 == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(d2);
        } catch (ParseException e2) {
            F1.c1(F1.v.ERROR, e2.getLocalizedMessage());
            return null;
        }
    }

    public String r() {
        return this.c.d(R1.a, "PREFS_OS_CACHED_IAMS", null);
    }

    public Set s() {
        return this.c.c(R1.a, "PREFS_OS_PAGE_IMPRESSIONED_IAMS", null);
    }

    public final String t(String str, String str2, String str3) {
        if (str2 == null) {
            this.b.error("Unable to find a variant for in-app message " + str);
            return null;
        }
        return "in_app_messages/" + str + "/variants/" + str2 + "/html?app_id=" + str3;
    }

    public final void u(String str, int i2, String str2) {
        this.b.error("Encountered a " + i2 + " error while attempting in-app message " + str + " request: " + str2);
    }

    public final void v(String str, String str2) {
        this.b.debug("Successful post for in-app message " + str + " request: " + str2);
    }

    public final void w(Set set) {
        this.c.e(R1.a, "PREFS_OS_CLICKED_CLICK_IDS_IAMS", set);
    }

    public void x(Set set) {
        this.c.e(R1.a, "PREFS_OS_DISPLAYED_IAMS", set);
    }

    public void y(String str) {
        this.c.f(R1.a, "PREFS_OS_CACHED_IAMS", str);
    }

    public final void z(Set set) {
        this.c.e(R1.a, "PREFS_OS_IMPRESSIONED_IAMS", set);
    }
}
