package androidx.fragment.app;

import D.O;
import D.b;
import F0.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e extends ComponentActivity implements b.f, b.g {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    boolean mResumed;
    final h mFragments = h.b(new c());
    final androidx.lifecycle.q mFragmentLifecycleRegistry = new androidx.lifecycle.q(this);
    boolean mStopped = true;

    public class a implements c.c {
        public a() {
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            e.this.markFragmentsCreated();
            e.this.mFragmentLifecycleRegistry.h(j.b.ON_STOP);
            Parcelable x = e.this.mFragments.x();
            if (x != null) {
                bundle.putParcelable("android:support:fragments", x);
            }
            return bundle;
        }
    }

    public class b implements a.b {
        public b() {
        }

        public void a(Context context) {
            e.this.mFragments.a(null);
            Bundle b = e.this.getSavedStateRegistry().b("android:support:fragments");
            if (b != null) {
                e.this.mFragments.w(b.getParcelable("android:support:fragments"));
            }
        }
    }

    public class c extends j implements N, androidx.activity.l, androidx.activity.result.d, q {
        public c() {
            super(e.this);
        }

        public void a(m mVar, Fragment fragment) {
            e.this.onAttachFragment(fragment);
        }

        public View c(int i) {
            return e.this.findViewById(i);
        }

        public boolean d() {
            Window window = e.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public ActivityResultRegistry getActivityResultRegistry() {
            return e.this.getActivityResultRegistry();
        }

        public androidx.lifecycle.j getLifecycle() {
            return e.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return e.this.getOnBackPressedDispatcher();
        }

        public M getViewModelStore() {
            return e.this.getViewModelStore();
        }

        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            e.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public LayoutInflater j() {
            return e.this.getLayoutInflater().cloneInContext(e.this);
        }

        public boolean l(Fragment fragment) {
            return !e.this.isFinishing();
        }

        public boolean m(String str) {
            return D.b.l(e.this, str);
        }

        public void p() {
            e.this.supportInvalidateOptionsMenu();
        }

        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public e i() {
            return e.this;
        }
    }

    public e() {
        f1();
    }

    private void f1() {
        getSavedStateRegistry().h("android:support:fragments", new a());
        addOnContextAvailableListener(new b());
    }

    public static boolean g1(m mVar, j.c cVar) {
        boolean z = false;
        for (Fragment fragment : mVar.s0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= g1(fragment.getChildFragmentManager(), cVar);
                }
                A a2 = fragment.mViewLifecycleOwner;
                if (a2 != null && a2.getLifecycle().b().isAtLeast(j.c.STARTED)) {
                    fragment.mViewLifecycleOwner.f(cVar);
                    z = true;
                }
                if (fragment.mLifecycleRegistry.b().isAtLeast(j.c.STARTED)) {
                    fragment.mLifecycleRegistry.o(cVar);
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.v(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            n0.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.t().W(str, fileDescriptor, printWriter, strArr);
    }

    public m getSupportFragmentManager() {
        return this.mFragments.t();
    }

    @Deprecated
    public n0.a getSupportLoaderManager() {
        return n0.a.b(this);
    }

    public void markFragmentsCreated() {
        while (g1(getSupportFragmentManager(), j.c.CREATED)) {
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.u();
        super.onActivityResult(i, i2, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.u();
        super.onConfigurationChanged(configuration);
        this.mFragments.d(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(j.b.ON_CREATE);
        this.mFragments.f();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.mFragments.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.h(j.b.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.k(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.j(z);
    }

    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.u();
        super.onNewIntent(intent);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.h(j.b.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.n(z);
    }

    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return i == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.o(menu) : super.onPreparePanel(i, view, menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.u();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onResume() {
        this.mFragments.u();
        super.onResume();
        this.mResumed = true;
        this.mFragments.s();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(j.b.ON_RESUME);
        this.mFragments.p();
    }

    public void onStart() {
        this.mFragments.u();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.h(j.b.ON_START);
        this.mFragments.q();
    }

    public void onStateNotSaved() {
        this.mFragments.u();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.h(j.b.ON_STOP);
    }

    public void setEnterSharedElementCallback(O o) {
        D.b.j(this, o);
    }

    public void setExitSharedElementCallback(O o) {
        D.b.k(this, o);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            D.b.n(this, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        D.b.c(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        D.b.f(this);
    }

    public void supportStartPostponedEnterTransition() {
        D.b.o(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            D.b.m(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }
}
