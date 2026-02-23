package R8;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class e {
    public Object a;

    public e(Object obj) {
        this.a = obj;
    }

    public static e d(Activity activity) {
        return Build.VERSION.SDK_INT < 23 ? new d(activity) : activity instanceof androidx.appcompat.app.b ? new b((androidx.appcompat.app.b) activity) : new a(activity);
    }

    public static e e(Fragment fragment) {
        return Build.VERSION.SDK_INT < 23 ? new d(fragment) : new f(fragment);
    }

    public abstract void a(int i, String... strArr);

    public abstract Context b();

    public Object c() {
        return this.a;
    }

    public boolean f(String str) {
        return !i(str);
    }

    public void g(String str, String str2, String str3, int i, int i2, String... strArr) {
        if (h(strArr)) {
            j(str, str2, str3, i, i2, strArr);
        } else {
            a(i2, strArr);
        }
    }

    public final boolean h(String... strArr) {
        for (String str : strArr) {
            if (i(str)) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean i(String str);

    public abstract void j(String str, String str2, String str3, int i, int i2, String... strArr);

    public boolean k(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (f((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
