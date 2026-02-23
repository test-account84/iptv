package M1;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b {
    public List a = new ArrayList();

    public boolean a() {
        return this.a.isEmpty();
    }

    public Object b() {
        if (a()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return this.a.remove(r0.size() - 1);
    }

    public void c(Object obj) {
        this.a.add(obj);
    }
}
