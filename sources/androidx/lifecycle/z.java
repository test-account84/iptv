package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class z extends Fragment {
    public a a;

    public interface a {
        void a();

        void onResume();

        void onStart();
    }

    public static class b implements Application.ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            y.a(activity, new b());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            z.a(activity, j.b.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            z.a(activity, j.b.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            z.a(activity, j.b.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            z.a(activity, j.b.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            z.a(activity, j.b.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            z.a(activity, j.b.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static void a(Activity activity, j.b bVar) {
        if (activity instanceof p) {
            j lifecycle = ((p) activity).getLifecycle();
            if (lifecycle instanceof q) {
                ((q) lifecycle).h(bVar);
            }
        }
    }

    public static z f(Activity activity) {
        return (z) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new z(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void b(j.b bVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), bVar);
        }
    }

    public final void c(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    public final void e(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public void h(a aVar) {
        this.a = aVar;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c(this.a);
        b(j.b.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        b(j.b.ON_DESTROY);
        this.a = null;
    }

    public void onPause() {
        super.onPause();
        b(j.b.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        d(this.a);
        b(j.b.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        e(this.a);
        b(j.b.ON_START);
    }

    public void onStop() {
        super.onStop();
        b(j.b.ON_STOP);
    }
}
