package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h extends c implements a.f, J {
    private static volatile Executor zaa;
    private final e zab;
    private final Set zac;
    private final Account zad;

    public h(Context context, Looper looper, int i, e eVar, GoogleApiClient.b bVar, GoogleApiClient.c cVar) {
        this(context, looper, i, eVar, (com.google.android.gms.common.api.internal.f) bVar, (com.google.android.gms.common.api.internal.n) cVar);
    }

    public final Set f(Set set) {
        Set validateScopes = validateScopes(set);
        Iterator it = validateScopes.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    public final Account getAccount() {
        return this.zad;
    }

    public Executor getBindServiceExecutor() {
        return null;
    }

    public final e getClientSettings() {
        return this.zab;
    }

    public w4.d[] getRequiredFeatures() {
        return new w4.d[0];
    }

    public final Set getScopes() {
        return this.zac;
    }

    public Set getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.emptySet();
    }

    public Set validateScopes(Set set) {
        return set;
    }

    public h(Context context, Looper looper, int i, e eVar, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.n nVar) {
        this(context, looper, i.a(context), w4.h.q(), i, eVar, (com.google.android.gms.common.api.internal.f) r.m(fVar), (com.google.android.gms.common.api.internal.n) r.m(nVar));
    }

    public h(Context context, Looper looper, i iVar, w4.h hVar, int i, e eVar, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.n nVar) {
        super(context, looper, iVar, hVar, i, fVar == null ? null : new H(fVar), nVar == null ? null : new I(nVar), eVar.i());
        this.zab = eVar;
        this.zad = eVar.b();
        this.zac = f(eVar.d());
    }
}
