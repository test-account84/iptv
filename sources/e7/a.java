package E7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s5.G;
import s5.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a implements C7.b {
    public List a;
    public Map b = new HashMap();

    public a(Map map) {
        this.a = G.h();
        this.a = G.i(map.keySet());
        h();
    }

    public D7.b a(int i, int i2) {
        return (D7.b) ((D7.a) this.a.get(i)).e().get(i2);
    }

    public boolean b() {
        return !this.a.isEmpty();
    }

    public D7.a c(int i) {
        return (D7.a) this.a.get(i);
    }

    public List d(int i) {
        if (i >= this.a.size() || this.a.get(i) == null) {
            return null;
        }
        return ((D7.a) this.a.get(i)).e();
    }

    public D7.a e(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        D7.a aVar = (D7.a) this.b.get(str4);
        return aVar != null ? aVar : g(str, str2, str3, str4, str5, str6, str7);
    }

    public int f() {
        return this.a.size();
    }

    public D7.a g(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int size = this.a.size();
        D7.a aVar = new D7.a(str2, str, size, str3, str4, str5, str6, str7, str6);
        if (size > 0) {
            D7.a aVar2 = (D7.a) this.a.get(size - 1);
            aVar2.n(aVar);
            aVar.o(aVar2);
        }
        this.a.add(aVar);
        this.b.put(aVar.i(), aVar);
        return aVar;
    }

    public final void h() {
        this.b = I.h();
        for (int i = 0; i < this.a.size(); i++) {
            D7.a aVar = (D7.a) this.a.get(i);
            this.b.put(aVar.i(), aVar);
        }
    }
}
