package t1;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends a {
    public HashMap b;
    public String c;
    public String d;

    public b(Context context, String str) {
        super(context);
        this.b = new HashMap();
        this.c = str;
        n();
    }

    public void h() {
        p();
        this.b.clear();
        i();
    }

    public final void i() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.b.keySet()) {
            e eVar = (e) this.b.get(str);
            arrayList.add(str + ">>>>>" + eVar.a + ">>>>>" + eVar.c);
        }
        g(k(), TextUtils.join("#####", arrayList));
        this.d = Long.toString(new Date().getTime());
        g(l(), this.d);
    }

    public final String j() {
        return e(l(), "0");
    }

    public final String k() {
        return c() + this.c;
    }

    public final String l() {
        return k() + ".version";
    }

    public boolean m(String str) {
        p();
        return this.b.containsKey(str);
    }

    public final void n() {
        for (CharSequence charSequence : e(k(), "").split(Pattern.quote("#####"))) {
            if (!TextUtils.isEmpty(charSequence)) {
                String[] split = charSequence.split(Pattern.quote(">>>>>"));
                if (split.length > 2) {
                    this.b.put(split[0], new e(split[1], split[2]));
                } else if (split.length > 1) {
                    this.b.put(split[0], new e(split[1], null));
                }
            }
        }
        this.d = j();
    }

    public void o(String str, String str2, String str3) {
        p();
        if (this.b.containsKey(str)) {
            return;
        }
        this.b.put(str, new e(str2, str3));
        i();
    }

    public final void p() {
        if (this.d.equalsIgnoreCase(j())) {
            return;
        }
        this.b.clear();
        n();
    }

    public String toString() {
        return TextUtils.join(", ", this.b.keySet());
    }
}
