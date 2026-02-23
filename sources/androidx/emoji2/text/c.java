package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.emoji2.text.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {

    public static class a {
        public final b a;

        public a(b bVar) {
            this.a = bVar == null ? e() : bVar;
        }

        public static b e() {
            return Build.VERSION.SDK_INT >= 28 ? new d() : new c();
        }

        public final e.c a(Context context, M.e eVar) {
            if (eVar == null) {
                return null;
            }
            return new j(context, eVar);
        }

        public final List b(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        public e.c c(Context context) {
            return a(context, h(context));
        }

        public final M.e d(ProviderInfo providerInfo, PackageManager packageManager) {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new M.e(str, str2, "emojicompat-emoji-font", b(this.a.b(packageManager, str2)));
        }

        public final boolean f(ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        public final ProviderInfo g(PackageManager packageManager) {
            Iterator it = this.a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (it.hasNext()) {
                ProviderInfo a = this.a.a((ResolveInfo) it.next());
                if (f(a)) {
                    return a;
                }
            }
            return null;
        }

        public M.e h(Context context) {
            PackageManager packageManager = context.getPackageManager();
            O.h.g(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo g = g(packageManager);
            if (g == null) {
                return null;
            }
            try {
                return d(g, packageManager);
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e);
                return null;
            }
        }
    }

    public static class b {
        public abstract ProviderInfo a(ResolveInfo resolveInfo);

        public Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public abstract List c(PackageManager packageManager, Intent intent, int i);
    }

    public static class c extends b {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        public List c(PackageManager packageManager, Intent intent, int i) {
            return packageManager.queryIntentContentProviders(intent, i);
        }
    }

    public static class d extends c {
        public Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    public static j a(Context context) {
        return (j) new a(null).c(context);
    }
}
