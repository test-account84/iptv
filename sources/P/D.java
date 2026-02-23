package p;

import D.g;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.ArrayList;
import p.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d {
    public final Intent a;
    public final Bundle b;

    public static final class a {
        public ArrayList c;
        public Bundle d;
        public ArrayList e;
        public SparseArray f;
        public Bundle g;
        public final Intent a = new Intent("android.intent.action.VIEW");
        public final a.a b = new a.a();
        public int h = 0;
        public boolean i = true;

        public a() {
        }

        public d a() {
            if (!this.a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c(null, null);
            }
            ArrayList arrayList = this.c;
            if (arrayList != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList arrayList2 = this.e;
            if (arrayList2 != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.i);
            this.a.putExtras(this.b.a().a());
            Bundle bundle = this.g;
            if (bundle != null) {
                this.a.putExtras(bundle);
            }
            if (this.f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f);
                this.a.putExtras(bundle2);
            }
            this.a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.h);
            return new d(this.a, this.d);
        }

        public a b(f fVar) {
            this.a.setPackage(fVar.d().getPackageName());
            c(fVar.c(), fVar.e());
            return this;
        }

        public final void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            g.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.a.putExtras(bundle);
        }

        public a(f fVar) {
            if (fVar != null) {
                b(fVar);
            }
        }
    }

    public d(Intent intent, Bundle bundle) {
        this.a = intent;
        this.b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.a.setData(uri);
        E.b.startActivity(context, this.a, this.b);
    }
}
