package u7;

import a7.j;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a {
    public Context a;
    public SharedPreferences b;
    public SharedPreferences c;
    public SharedPreferences d;
    public SharedPreferences e;
    public SharedPreferences f;
    public SharedPreferences g;
    public SharedPreferences h;
    public SharedPreferences i;
    public SharedPreferences j;
    public SharedPreferences k;
    public SharedPreferences.Editor l;
    public SharedPreferences.Editor m;
    public SharedPreferences.Editor n;
    public SharedPreferences o;

    public a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        this.c = this.a.getSharedPreferences("pref.using_opensl_es", 0);
        this.j = this.a.getSharedPreferences("pref.using_opengl", 0);
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("pref.using_media_codec", 0);
        this.k = sharedPreferences;
        this.l = sharedPreferences.edit();
        SharedPreferences sharedPreferences2 = this.a.getSharedPreferences("auto_start", 0);
        this.f = sharedPreferences2;
        this.m = sharedPreferences2.edit();
        SharedPreferences sharedPreferences3 = this.a.getSharedPreferences("pref.billing_p", 0);
        this.i = sharedPreferences3;
        this.n = sharedPreferences3.edit();
        this.d = this.a.getSharedPreferences("pref.using_infbuf", 0);
        this.e = this.a.getSharedPreferences("pref.using_sub_font_size", 0);
        this.f = this.a.getSharedPreferences("auto_start", 0);
        this.g = this.a.getSharedPreferences("automation_channels", 0);
        this.h = this.a.getSharedPreferences("automation_epg", 0);
        this.o = this.a.getSharedPreferences("loginPrefs", 0);
    }

    public String A() {
        try {
            return this.f.getString("pref.screen_type", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean B() {
        return this.f.getBoolean("show_epg_in_channels_list", m7.a.A0);
    }

    public String C() {
        return this.o.getString("serverTimeZone", m7.a.y0);
    }

    public boolean D() {
        return this.k.getString("pref.using_media_codec", m7.a.v0).equals(this.a.getResources().getString(j.p2));
    }

    public boolean E() {
        return this.b.getBoolean(this.a.getString(j.D5), false);
    }

    public boolean F() {
        return this.b.getBoolean(this.a.getString(j.E5), false);
    }

    public boolean G() {
        return this.c.getString("pref.using_opensl_es", "").equals("checked");
    }

    public Boolean H() {
        return Boolean.valueOf(this.f.getBoolean("full_epg", true));
    }

    public void I(Boolean bool) {
        SharedPreferences.Editor editor = this.m;
        if (editor != null) {
            editor.putBoolean("subtitle_active", bool.booleanValue());
            this.m.apply();
        }
    }

    public void J(boolean z) {
        try {
            SharedPreferences.Editor editor = this.m;
            if (editor != null) {
                editor.putBoolean("auto_clear_cache", z);
            }
        } catch (Exception unused) {
        }
    }

    public void K(String str) {
        SharedPreferences.Editor editor = this.m;
        if (editor != null) {
            editor.putString("autoplay_seconds", str);
            this.m.apply();
        }
    }

    public void L(Boolean bool) {
        SharedPreferences.Editor editor = this.m;
        if (editor != null) {
            editor.putBoolean("autoplay", bool.booleanValue());
            this.m.apply();
        }
    }

    public void M(Boolean bool) {
        SharedPreferences.Editor editor = this.m;
        if (editor != null) {
            editor.putBoolean("auto_start", bool.booleanValue());
            this.m.apply();
        }
    }

    public void N(boolean z) {
        try {
            SharedPreferences.Editor editor = this.m;
            if (editor != null) {
                editor.putBoolean("auto_play_channel_in_live", z);
            }
        } catch (Exception unused) {
        }
    }

    public void O(String str, String str2, int i) {
        try {
            this.n.putString("pref_billing_p_email", str);
            this.n.putString("pref_billing_p_pass", str2);
            this.n.putInt("pref_billing_p_id", i);
            this.n.apply();
        } catch (Exception unused) {
        }
    }

    public void P() {
        try {
            this.n.putString("pref_billing_p_date", String.valueOf(System.currentTimeMillis()));
            this.n.apply();
        } catch (Exception unused) {
        }
    }

    public void Q(Boolean bool) {
        try {
            this.n.putBoolean("pref_billing_p_is_p", bool.booleanValue());
            this.n.apply();
        } catch (Exception unused) {
        }
    }

    public void R(int i) {
        try {
            this.m.putInt("pref.brightness", i);
            this.m.apply();
        } catch (Exception unused) {
        }
    }

    public void S(boolean z) {
        try {
            SharedPreferences.Editor editor = this.m;
            if (editor != null) {
                editor.putBoolean("show_epg_in_channels_list", z);
            }
        } catch (Exception unused) {
        }
    }

    public void T(Boolean bool) {
        try {
            this.n.putBoolean("pref_billing_p_max_conn", bool.booleanValue());
            this.n.apply();
        } catch (Exception unused) {
        }
    }

    public void U(String str) {
        this.l.putString("pref.using_media_codec", str);
        this.l.apply();
    }

    public void V(int i) {
        try {
            this.m.putInt("recently_added_limit", i);
            this.m.apply();
        } catch (Exception unused) {
        }
    }

    public void W(int i) {
        SharedPreferences.Editor editor = this.m;
        if (editor != null) {
            editor.putInt("recently_watched_limit_live", i);
            this.m.apply();
        }
    }

    public void X(String str) {
        try {
            this.m.putString("pref.screen_type", str);
            this.m.apply();
        } catch (Exception unused) {
        }
    }

    public void Y(Boolean bool) {
        SharedPreferences.Editor editor = this.m;
        if (editor != null) {
            editor.putBoolean("full_epg", bool.booleanValue());
            this.m.apply();
        }
    }

    public void a() {
        try {
            this.n.clear().commit();
        } catch (Exception unused) {
        }
    }

    public Boolean b() {
        return Boolean.valueOf(this.f.getBoolean("subtitle_active", true));
    }

    public boolean c() {
        return this.f.getBoolean("auto_clear_cache", m7.a.z0);
    }

    public String d() {
        return this.f.getString("autoplay_seconds", m7.a.t0);
    }

    public Boolean e() {
        return Boolean.valueOf(this.f.getBoolean("autoplay", true));
    }

    public Boolean f() {
        return Boolean.valueOf(this.f.getBoolean("auto_start", true));
    }

    public int g() {
        return this.g.getInt("automation_channels_days", m7.a.D0);
    }

    public int h() {
        return this.h.getInt("automation_epg_days", m7.a.H0);
    }

    public boolean i() {
        return this.f.getBoolean("auto_play_channel_in_live", m7.a.B0);
    }

    public String j() {
        try {
            return this.i.getString("pref_billing_p_date", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public String k() {
        try {
            return this.i.getString("pref_billing_p_email", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public int l() {
        try {
            return this.i.getInt("pref_billing_p_id", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public Boolean m() {
        try {
            return Boolean.valueOf(this.i.getBoolean("pref_billing_p_is_p", false));
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public String n() {
        try {
            return this.i.getString("pref_billing_p_pass", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public int o() {
        try {
            return this.f.getInt("pref.brightness", m7.a.J0);
        } catch (Exception unused) {
            return m7.a.J0;
        }
    }

    public boolean p() {
        return this.b.getBoolean(this.a.getString(j.x5), false);
    }

    public boolean q() {
        return this.b.getBoolean(this.a.getString(j.y5), false);
    }

    public boolean r() {
        return this.b.getBoolean(this.a.getString(j.z5), false);
    }

    public boolean s() {
        return this.b.getBoolean(this.a.getString(j.A5), false);
    }

    public boolean t() {
        return this.b.getBoolean(this.a.getString(j.B5), false);
    }

    public Boolean u() {
        try {
            return Boolean.valueOf(this.i.getBoolean("pref_billing_p_max_conn", false));
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public boolean v() {
        return this.b.getBoolean(this.a.getString(j.C5), false);
    }

    public String w() {
        return this.j.getString("pref.using_opengl", "");
    }

    public int x() {
        String string = this.k.getString("pref.using_media_codec", m7.a.v0);
        if (string.equals(this.a.getResources().getString(j.U3))) {
            return 3;
        }
        if (string.equals(this.a.getResources().getString(j.p2))) {
            return 2;
        }
        string.equals(this.a.getResources().getString(j.d7));
        return 2;
    }

    public int y() {
        return this.f.getInt("recently_added_limit", m7.a.r0);
    }

    public int z() {
        return this.f.getInt("recently_watched_limit_live", m7.a.s0);
    }
}
