package M4;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Handler;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p extends F2 {
    public long c;
    public String d;
    public AccountManager e;
    public Boolean f;
    public long g;

    public p(l2 l2Var) {
        super(l2Var);
    }

    public final boolean j() {
        Calendar calendar = Calendar.getInstance();
        this.c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.d = language.toLowerCase(locale2) + "-" + locale.getCountry().toLowerCase(locale2);
        return false;
    }

    public final long o() {
        h();
        return this.g;
    }

    public final long p() {
        k();
        return this.c;
    }

    public final String q() {
        k();
        return this.d;
    }

    public final void r() {
        h();
        this.f = null;
        this.g = 0L;
    }

    public final boolean s() {
        h();
        long a = this.a.a().a();
        if (a - this.g > 86400000) {
            this.f = null;
        }
        Boolean bool = this.f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (E.b.checkSelfPermission(this.a.c(), "android.permission.GET_ACCOUNTS") != 0) {
            this.a.d().y().a("Permission error checking for dasher/unicorn accounts");
        } else {
            if (this.e == null) {
                this.e = AccountManager.get(this.a.c());
            }
            try {
                Account[] accountArr = (Account[]) this.e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (accountArr != null && accountArr.length > 0) {
                    this.f = Boolean.TRUE;
                    this.g = a;
                    return true;
                }
                Account[] accountArr2 = (Account[]) this.e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (accountArr2 != null && accountArr2.length > 0) {
                    this.f = Boolean.TRUE;
                    this.g = a;
                    return true;
                }
            } catch (OperationCanceledException e) {
                e = e;
                this.a.d().t().b("Exception checking account types", e);
                this.g = a;
                this.f = Boolean.FALSE;
                return false;
            } catch (IOException e2) {
                e = e2;
                this.a.d().t().b("Exception checking account types", e);
                this.g = a;
                this.f = Boolean.FALSE;
                return false;
            } catch (AuthenticatorException e3) {
                e = e3;
                this.a.d().t().b("Exception checking account types", e);
                this.g = a;
                this.f = Boolean.FALSE;
                return false;
            }
        }
        this.g = a;
        this.f = Boolean.FALSE;
        return false;
    }
}
