package androidx.lifecycle;

import F0.c;
import android.os.Bundle;
import androidx.lifecycle.j;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class LegacySavedStateHandleController {

    public class 1 implements n {
        public final /* synthetic */ j a;
        public final /* synthetic */ F0.c c;

        public 1(j jVar, F0.c cVar) {
            this.a = jVar;
            this.c = cVar;
        }

        public void b(p pVar, j.b bVar) {
            if (bVar == j.b.ON_START) {
                this.a.c(this);
                this.c.i(a.class);
            }
        }
    }

    public static final class a implements c.a {
        public void a(F0.e eVar) {
            if (!(eVar instanceof N)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            M viewModelStore = ((N) eVar).getViewModelStore();
            F0.c savedStateRegistry = eVar.getSavedStateRegistry();
            Iterator it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                LegacySavedStateHandleController.a(viewModelStore.b((String) it.next()), savedStateRegistry, eVar.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    public static void a(I i, F0.c cVar, j jVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) i.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.j()) {
            return;
        }
        savedStateHandleController.c(cVar, jVar);
        c(cVar, jVar);
    }

    public static SavedStateHandleController b(F0.c cVar, j jVar, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, B.c(cVar.b(str), bundle));
        savedStateHandleController.c(cVar, jVar);
        c(cVar, jVar);
        return savedStateHandleController;
    }

    public static void c(F0.c cVar, j jVar) {
        j.c b = jVar.b();
        if (b == j.c.INITIALIZED || b.isAtLeast(j.c.STARTED)) {
            cVar.i(a.class);
        } else {
            jVar.a(new 1(jVar, cVar));
        }
    }
}
