package P4;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.N;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a extends com.google.android.gms.common.internal.h implements O4.e {
    public static final /* synthetic */ int g = 0;
    public final boolean c;
    public final com.google.android.gms.common.internal.e d;
    public final Bundle e;
    public final Integer f;

    public a(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.e eVar, Bundle bundle, GoogleApiClient.b bVar, GoogleApiClient.c cVar) {
        super(context, looper, 44, eVar, bVar, cVar);
        this.c = true;
        this.d = eVar;
        this.e = bundle;
        this.f = eVar.h();
    }

    public static Bundle g(com.google.android.gms.common.internal.e eVar) {
        eVar.g();
        Integer h = eVar.h();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", eVar.b());
        if (h != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", h.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    public final void b() {
        try {
            ((g) getService()).A(((Integer) r.m(this.f)).intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public final void c() {
        connect(new c.d(this));
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof g ? (g) queryLocalInterface : new g(iBinder);
    }

    public final void d(f fVar) {
        r.n(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account c = this.d.c();
            ((g) getService()).Z(new j(1, new N(c, ((Integer) r.m(this.f)).intValue(), "<<default account>>".equals(c.name) ? l4.a.a(getContext()).b() : null)), fVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.M0(new l(1, new w4.b(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public final void e(com.google.android.gms.common.internal.k kVar, boolean z) {
        try {
            ((g) getService()).E(kVar, ((Integer) r.m(this.f)).intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.d.e())) {
            this.e.putString("com.google.android.gms.signin.internal.realClientPackageName", this.d.e());
        }
        return this.e;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public final boolean requiresSignIn() {
        return this.c;
    }
}
