package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.util.VisibleForTesting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aqn implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context g;
    private final Object b = new Object();
    private final ConditionVariable c = new ConditionVariable();
    private volatile boolean d = false;

    @VisibleForTesting
    volatile boolean a = false;
    private SharedPreferences e = null;
    private Bundle f = new Bundle();
    private JSONObject h = new JSONObject();

    public static /* bridge */ /* synthetic */ SharedPreferences a(aqn aqnVar) {
        return aqnVar.e;
    }

    private final void f() {
        if (this.e == null) {
            return;
        }
        try {
            this.h = new JSONObject((String) aqp.a(new aql(this)));
        } catch (JSONException unused) {
        }
    }

    public final Object b(aqj aqjVar) {
        if (!this.c.block(5000L)) {
            synchronized (this.b) {
                try {
                    if (!this.a) {
                        throw new IllegalStateException("Flags.initialize() was not called!");
                    }
                } finally {
                }
            }
        }
        if (!this.d || this.e == null) {
            synchronized (this.b) {
                if (this.d && this.e != null) {
                }
                return aqjVar.g();
            }
        }
        if (aqjVar.d() != 2) {
            return (aqjVar.d() == 1 && this.h.has(aqjVar.h())) ? aqjVar.a(this.h) : aqp.a(new aqk(this, aqjVar));
        }
        Bundle bundle = this.f;
        return bundle == null ? aqjVar.g() : aqjVar.b(bundle);
    }

    public final /* synthetic */ Object c(aqj aqjVar) {
        return aqjVar.c(this.e);
    }

    public final /* synthetic */ String d() {
        return this.e.getString("flag_configuration", "{}");
    }

    public final void e(Context context) {
        if (this.d) {
            return;
        }
        synchronized (this.b) {
            try {
                if (this.d) {
                    return;
                }
                if (!this.a) {
                    this.a = true;
                }
                Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
                this.g = applicationContext;
                try {
                    this.f = E4.e.a(applicationContext).c(this.g.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                }
                try {
                    Context e = w4.m.e(context);
                    if (e != null || (e = context.getApplicationContext()) != null) {
                        context = e;
                    }
                    if (context == null) {
                        return;
                    }
                    aqd.b();
                    SharedPreferences sharedPreferences = context.getSharedPreferences("google_ads_flags", 0);
                    this.e = sharedPreferences;
                    if (sharedPreferences != null) {
                        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                    }
                    aqv.c(new aqm(this));
                    f();
                    this.d = true;
                } finally {
                    this.a = false;
                    this.c.open();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            f();
        }
    }
}
