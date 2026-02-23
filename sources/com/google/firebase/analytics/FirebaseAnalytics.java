package com.google.firebase.analytics;

import B5.a;
import M4.u3;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k6.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class FirebaseAnalytics {
    public static volatile FirebaseAnalytics b;
    public final zzef a;

    public FirebaseAnalytics(zzef zzefVar) {
        r.m(zzefVar);
        this.a = zzefVar;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (b == null) {
                        b = new FirebaseAnalytics(zzef.zzg(context, null, null, null, null));
                    }
                } finally {
                }
            }
        }
        return b;
    }

    @Keep
    public static u3 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzef zzg = zzef.zzg(context, null, null, null, bundle);
        if (zzg == null) {
            return null;
        }
        return new a(zzg);
    }

    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(g.p().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        } catch (ExecutionException e) {
            throw new IllegalStateException(e.getCause());
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.a.zzH(activity, str, str2);
    }
}
