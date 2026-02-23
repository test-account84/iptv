package androidx.savedstate;

import F0.c;
import F0.e;
import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Recreator implements n {
    public static final a c = new a(null);
    public final e a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b implements c.c {
        public final Set a;

        public b(c cVar) {
            l.e(cVar, "registry");
            this.a = new LinkedHashSet();
            cVar.h("androidx.savedstate.Restarter", this);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.a));
            return bundle;
        }

        public final void b(String str) {
            l.e(str, "className");
            this.a.add(str);
        }
    }

    public Recreator(e eVar) {
        l.e(eVar, "owner");
        this.a = eVar;
    }

    public void b(p pVar, j.b bVar) {
        l.e(pVar, "source");
        l.e(bVar, "event");
        if (bVar != j.b.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        pVar.getLifecycle().c(this);
        Bundle b2 = this.a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (b2 == null) {
            return;
        }
        ArrayList stringArrayList = b2.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator it = stringArrayList.iterator();
        while (it.hasNext()) {
            c((String) it.next());
        }
    }

    public final void c(String str) {
        try {
            Class asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(c.a.class);
            l.d(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor((Class[]) null);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance((Object[]) null);
                    l.d(newInstance, "{\n                constr…wInstance()\n            }");
                    ((c.a) newInstance).a(this.a);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }
}
