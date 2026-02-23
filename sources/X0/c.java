package x0;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.k;
import androidx.navigation.l;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {

    public class a implements View.OnClickListener {
        public final /* synthetic */ NavController a;
        public final /* synthetic */ b c;

        public a(NavController navController, b bVar) {
            this.a = navController;
            this.c = bVar;
        }

        public void onClick(View view) {
            c.c(this.a, this.c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.navigation.k] */
    public static k a(l lVar) {
        l lVar2 = lVar;
        while (lVar2 instanceof l) {
            l lVar3 = lVar2;
            lVar2 = lVar3.A(lVar3.E());
        }
        return lVar2;
    }

    public static boolean b(k kVar, Set set) {
        while (!set.contains(Integer.valueOf(kVar.i()))) {
            kVar = kVar.n();
            if (kVar == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(NavController navController, b bVar) {
        bVar.b();
        navController.h();
        bVar.c();
        if (navController.s()) {
            return true;
        }
        bVar.a();
        return false;
    }

    public static void d(Toolbar toolbar, NavController navController, b bVar) {
        navController.a(new e(toolbar, bVar));
        toolbar.setNavigationOnClickListener(new a(navController, bVar));
    }
}
