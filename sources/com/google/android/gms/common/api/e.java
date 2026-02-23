package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.A;
import com.google.android.gms.common.api.internal.J0;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.k0;
import com.google.android.gms.common.api.internal.p0;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import d.D;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class e {
    protected final com.google.android.gms.common.api.internal.g zaa;
    private final Context zab;
    private final String zac;
    private final com.google.android.gms.common.api.a zad;
    private final a.d zae;
    private final com.google.android.gms.common.api.internal.b zaf;
    private final Looper zag;
    private final int zah;

    @NotOnlyInitialized
    private final GoogleApiClient zai;
    private final s zaj;

    public static class a {
        public static final a c = new a().a();
        public final s a;
        public final Looper b;

        public static class a {
            public s a;
            public Looper b;

            public a a() {
                if (this.a == null) {
                    this.a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.b == null) {
                    this.b = Looper.getMainLooper();
                }
                return new a(this.a, null, this.b, null);
            }
        }

        public a(s sVar, Account account, Looper looper) {
            this.a = sVar;
            this.b = looper;
        }

        public /* synthetic */ a(s sVar, Account account, Looper looper, o oVar) {
            this(sVar, null, looper);
        }
    }

    public e(Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(activity, activity, aVar, dVar, aVar2);
    }

    public GoogleApiClient asGoogleApiClient() {
        return this.zai;
    }

    public e.a createClientSettingsBuilder() {
        e.a aVar = new e.a();
        aVar.d(null);
        aVar.c(Collections.emptySet());
        aVar.e(this.zab.getClass().getName());
        aVar.b(this.zab.getPackageName());
        return aVar;
    }

    public Task disconnectService() {
        return this.zaa.v(this);
    }

    public com.google.android.gms.common.api.internal.d doBestEffortWrite(com.google.android.gms.common.api.internal.d dVar) {
        f(2, dVar);
        return dVar;
    }

    public com.google.android.gms.common.api.internal.d doRead(com.google.android.gms.common.api.internal.d dVar) {
        f(0, dVar);
        return dVar;
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public Task doRegisterEventListener(com.google.android.gms.common.api.internal.o oVar, v vVar) {
        r.m(oVar);
        r.m(vVar);
        r.n(oVar.b(), "Listener has already been released.");
        r.n(vVar.a(), "Listener has already been released.");
        r.b(com.google.android.gms.common.internal.q.b(oVar.b(), vVar.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.w(this, oVar, vVar, n.a);
    }

    @ResultIgnorabilityUnspecified
    public Task doUnregisterEventListener(k.a aVar) {
        return doUnregisterEventListener(aVar, 0);
    }

    public com.google.android.gms.common.api.internal.d doWrite(com.google.android.gms.common.api.internal.d dVar) {
        f(1, dVar);
        return dVar;
    }

    public final com.google.android.gms.common.api.internal.d f(int i, com.google.android.gms.common.api.internal.d dVar) {
        dVar.zak();
        this.zaa.C(this, i, dVar);
        return dVar;
    }

    public final Task g(int i, t tVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.D(this, i, tVar, taskCompletionSource, this.zaj);
        return taskCompletionSource.getTask();
    }

    public String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    public final com.google.android.gms.common.api.internal.b getApiKey() {
        return this.zaf;
    }

    public a.d getApiOptions() {
        return this.zae;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    public String getContextAttributionTag() {
        return this.zac;
    }

    @Deprecated
    public String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zag;
    }

    public com.google.android.gms.common.api.internal.k registerListener(Object obj, String str) {
        return com.google.android.gms.common.api.internal.l.a(obj, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.f zab(Looper looper, k0 k0Var) {
        com.google.android.gms.common.internal.e a2 = createClientSettingsBuilder().a();
        a.f buildClient = ((a.a) r.m(this.zad.a())).buildClient(this.zab, looper, a2, (Object) this.zae, (GoogleApiClient.b) k0Var, (GoogleApiClient.c) k0Var);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof com.google.android.gms.common.internal.c)) {
            ((com.google.android.gms.common.internal.c) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag == null || !(buildClient instanceof com.google.android.gms.common.api.internal.m)) {
            return buildClient;
        }
        D.a(buildClient);
        throw null;
    }

    public final J0 zac(Context context, Handler handler) {
        return new J0(context, handler, createClientSettingsBuilder().a());
    }

    public e(Context context, Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        r.n(context, "Null context is not permitted.");
        r.n(aVar, "Api must not be null.");
        r.n(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) r.n(context.getApplicationContext(), "The provided context did not have an application context.");
        this.zab = context2;
        String a2 = Build.VERSION.SDK_INT >= 30 ? d.a(context) : getApiFallbackAttributionTag(context);
        this.zac = a2;
        this.zad = aVar;
        this.zae = dVar;
        this.zag = aVar2.b;
        com.google.android.gms.common.api.internal.b a3 = com.google.android.gms.common.api.internal.b.a(aVar, dVar, a2);
        this.zaf = a3;
        this.zai = new p0(this);
        com.google.android.gms.common.api.internal.g t = com.google.android.gms.common.api.internal.g.t(context2);
        this.zaa = t;
        this.zah = t.k();
        this.zaj = aVar2.a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            A.j(activity, t, a3);
        }
        t.H(this);
    }

    @ResultIgnorabilityUnspecified
    public Task doBestEffortWrite(t tVar) {
        return g(2, tVar);
    }

    @ResultIgnorabilityUnspecified
    public Task doRead(t tVar) {
        return g(0, tVar);
    }

    @ResultIgnorabilityUnspecified
    public Task doRegisterEventListener(com.google.android.gms.common.api.internal.p pVar) {
        r.m(pVar);
        r.n(pVar.a.b(), "Listener has already been released.");
        r.n(pVar.b.a(), "Listener has already been released.");
        return this.zaa.w(this, pVar.a, pVar.b, pVar.c);
    }

    @ResultIgnorabilityUnspecified
    public Task doUnregisterEventListener(k.a aVar, int i) {
        r.n(aVar, "Listener key cannot be null.");
        return this.zaa.x(this, aVar, i);
    }

    @ResultIgnorabilityUnspecified
    public Task doWrite(t tVar) {
        return g(1, tVar);
    }

    public e(Context context, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(context, null, aVar, dVar, aVar2);
    }
}
