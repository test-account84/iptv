package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.j;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ActivityResultRegistry {
    public Random a = new Random();
    public final Map b = new HashMap();
    public final Map c = new HashMap();
    public final Map d = new HashMap();
    public ArrayList e = new ArrayList();
    public final transient Map f = new HashMap();
    public final Map g = new HashMap();
    public final Bundle h = new Bundle();

    public class 1 implements n {
        public final /* synthetic */ String a;
        public final /* synthetic */ androidx.activity.result.b c;
        public final /* synthetic */ b.a d;

        public 1(String str, androidx.activity.result.b bVar, b.a aVar) {
            this.a = str;
            this.c = bVar;
            this.d = aVar;
        }

        public void b(p pVar, j.b bVar) {
            if (!j.b.ON_START.equals(bVar)) {
                if (j.b.ON_STOP.equals(bVar)) {
                    ActivityResultRegistry.this.f.remove(this.a);
                    return;
                } else {
                    if (j.b.ON_DESTROY.equals(bVar)) {
                        ActivityResultRegistry.this.l(this.a);
                        return;
                    }
                    return;
                }
            }
            ActivityResultRegistry.this.f.put(this.a, new c(this.c, this.d));
            if (ActivityResultRegistry.this.g.containsKey(this.a)) {
                Object obj = ActivityResultRegistry.this.g.get(this.a);
                ActivityResultRegistry.this.g.remove(this.a);
                this.c.a(obj);
            }
            androidx.activity.result.a aVar = (androidx.activity.result.a) ActivityResultRegistry.this.h.getParcelable(this.a);
            if (aVar != null) {
                ActivityResultRegistry.this.h.remove(this.a);
                this.c.a(this.d.c(aVar.c(), aVar.a()));
            }
        }
    }

    public class a extends androidx.activity.result.c {
        public final /* synthetic */ String a;
        public final /* synthetic */ b.a b;

        public a(String str, b.a aVar) {
            this.a = str;
            this.b = aVar;
        }

        public void b(Object obj, D.d dVar) {
            Integer num = (Integer) ActivityResultRegistry.this.c.get(this.a);
            if (num != null) {
                ActivityResultRegistry.this.e.add(this.a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.b, obj, dVar);
                    return;
                } catch (Exception e) {
                    ActivityResultRegistry.this.e.remove(this.a);
                    throw e;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        public void c() {
            ActivityResultRegistry.this.l(this.a);
        }
    }

    public class b extends androidx.activity.result.c {
        public final /* synthetic */ String a;
        public final /* synthetic */ b.a b;

        public b(String str, b.a aVar) {
            this.a = str;
            this.b = aVar;
        }

        public void b(Object obj, D.d dVar) {
            Integer num = (Integer) ActivityResultRegistry.this.c.get(this.a);
            if (num != null) {
                ActivityResultRegistry.this.e.add(this.a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.b, obj, dVar);
                    return;
                } catch (Exception e) {
                    ActivityResultRegistry.this.e.remove(this.a);
                    throw e;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        public void c() {
            ActivityResultRegistry.this.l(this.a);
        }
    }

    public static class c {
        public final androidx.activity.result.b a;
        public final b.a b;

        public c(androidx.activity.result.b bVar, b.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }
    }

    public static class d {
        public final j a;
        public final ArrayList b = new ArrayList();

        public d(j jVar) {
            this.a = jVar;
        }

        public void a(n nVar) {
            this.a.a(nVar);
            this.b.add(nVar);
        }

        public void b() {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                this.a.c((n) it.next());
            }
            this.b.clear();
        }
    }

    public final void a(int i, String str) {
        this.b.put(Integer.valueOf(i), str);
        this.c.put(str, Integer.valueOf(i));
    }

    public final boolean b(int i, int i2, Intent intent) {
        String str = (String) this.b.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        d(str, i2, intent, (c) this.f.get(str));
        return true;
    }

    public final boolean c(int i, Object obj) {
        androidx.activity.result.b bVar;
        String str = (String) this.b.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        c cVar = (c) this.f.get(str);
        if (cVar == null || (bVar = cVar.a) == null) {
            this.h.remove(str);
            this.g.put(str, obj);
            return true;
        }
        if (!this.e.remove(str)) {
            return true;
        }
        bVar.a(obj);
        return true;
    }

    public final void d(String str, int i, Intent intent, c cVar) {
        if (cVar == null || cVar.a == null || !this.e.contains(str)) {
            this.g.remove(str);
            this.h.putParcelable(str, new androidx.activity.result.a(i, intent));
        } else {
            cVar.a.a(cVar.b.c(i, intent));
            this.e.remove(str);
        }
    }

    public final int e() {
        int nextInt = this.a.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (!this.b.containsKey(Integer.valueOf(i))) {
                return i;
            }
            nextInt = this.a.nextInt(2147418112);
        }
    }

    public abstract void f(int i, b.a aVar, Object obj, D.d dVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.a = bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i = 0; i < stringArrayList.size(); i++) {
            String str = (String) stringArrayList.get(i);
            if (this.c.containsKey(str)) {
                Integer num = (Integer) this.c.remove(str);
                if (!this.h.containsKey(str)) {
                    this.b.remove(num);
                }
            }
            a(((Integer) integerArrayList.get(i)).intValue(), (String) stringArrayList.get(i));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.a);
    }

    public final androidx.activity.result.c i(String str, p pVar, b.a aVar, androidx.activity.result.b bVar) {
        j lifecycle = pVar.getLifecycle();
        if (lifecycle.b().isAtLeast(j.c.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + pVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        d dVar = (d) this.d.get(str);
        if (dVar == null) {
            dVar = new d(lifecycle);
        }
        dVar.a(new 1(str, bVar, aVar));
        this.d.put(str, dVar);
        return new a(str, aVar);
    }

    public final androidx.activity.result.c j(String str, b.a aVar, androidx.activity.result.b bVar) {
        k(str);
        this.f.put(str, new c(bVar, aVar));
        if (this.g.containsKey(str)) {
            Object obj = this.g.get(str);
            this.g.remove(str);
            bVar.a(obj);
        }
        androidx.activity.result.a aVar2 = (androidx.activity.result.a) this.h.getParcelable(str);
        if (aVar2 != null) {
            this.h.remove(str);
            bVar.a(aVar.c(aVar2.c(), aVar2.a()));
        }
        return new b(str, aVar);
    }

    public final void k(String str) {
        if (((Integer) this.c.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final void l(String str) {
        Integer num;
        if (!this.e.contains(str) && (num = (Integer) this.c.remove(str)) != null) {
            this.b.remove(num);
        }
        this.f.remove(str);
        if (this.g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.g.get(str));
            this.g.remove(str);
        }
        if (this.h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.h.getParcelable(str));
            this.h.remove(str);
        }
        d dVar = (d) this.d.get(str);
        if (dVar != null) {
            dVar.b();
            this.d.remove(str);
        }
    }
}
