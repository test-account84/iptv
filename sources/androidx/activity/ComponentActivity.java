package androidx.activity;

import P.v;
import P.x;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.C;
import androidx.lifecycle.F;
import androidx.lifecycle.J;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.P;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import b.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ComponentActivity extends D.h implements p, N, androidx.lifecycle.i, F0.e, l, androidx.activity.result.d {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    private J.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList mOnNewIntentListeners;
    private final CopyOnWriteArrayList mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList mOnTrimMemoryListeners;
    final F0.d mSavedStateRegistryController;
    private M mViewModelStore;
    final a.a mContextAwareHelper = new a.a();
    private final v mMenuHostHelper = new v(new androidx.activity.b(this));
    private final q mLifecycleRegistry = new q(this);

    public class 3 implements androidx.lifecycle.n {
        public 3() {
        }

        public void b(p pVar, j.b bVar) {
            if (bVar == j.b.ON_STOP) {
                Window window = ComponentActivity.this.getWindow();
                View peekDecorView = window != null ? window.peekDecorView() : null;
                if (peekDecorView != null) {
                    c.a(peekDecorView);
                }
            }
        }
    }

    public class 4 implements androidx.lifecycle.n {
        public 4() {
        }

        public void b(p pVar, j.b bVar) {
            if (bVar == j.b.ON_DESTROY) {
                ComponentActivity.this.mContextAwareHelper.b();
                if (ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.getViewModelStore().a();
            }
        }
    }

    public class 5 implements androidx.lifecycle.n {
        public 5() {
        }

        public void b(p pVar, j.b bVar) {
            ComponentActivity.this.ensureViewModelStore();
            ComponentActivity.this.getLifecycle().c(this);
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                ComponentActivity.access$001(ComponentActivity.this);
            } catch (IllegalStateException e) {
                if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            }
        }
    }

    public class b extends ActivityResultRegistry {

        public class a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ a.a c;

            public a(int i, a.a aVar) {
                this.a = i;
                this.c = aVar;
            }

            public void run() {
                b.this.c(this.a, this.c.a());
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ IntentSender.SendIntentException c;

            public b(int i, IntentSender.SendIntentException sendIntentException) {
                this.a = i;
                this.c = sendIntentException;
            }

            public void run() {
                b.this.b(this.a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.c));
            }
        }

        public b() {
        }

        public void f(int i, b.a aVar, Object obj, D.d dVar) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            a.a b2 = aVar.b(componentActivity, obj);
            if (b2 != null) {
                new Handler(Looper.getMainLooper()).post(new a(i, b2));
                return;
            }
            Intent a2 = aVar.a(componentActivity, obj);
            if (a2.getExtras() != null && a2.getExtras().getClassLoader() == null) {
                a2.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
                String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                D.b.h(componentActivity, stringArrayExtra, i);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
                D.b.m(componentActivity, a2, i, bundle);
                return;
            }
            androidx.activity.result.e eVar = (androidx.activity.result.e) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                D.b.n(componentActivity, eVar.e(), i, eVar.a(), eVar.c(), eVar.d(), 0, bundle);
            } catch (IntentSender.SendIntentException e) {
                new Handler(Looper.getMainLooper()).post(new b(i, e));
            }
        }
    }

    public static class c {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    public static class d {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    public static final class e {
        public Object a;
        public M b;
    }

    public ComponentActivity() {
        F0.d a2 = F0.d.a(this);
        this.mSavedStateRegistryController = a2;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i = Build.VERSION.SDK_INT;
        getLifecycle().a(new 3());
        getLifecycle().a(new 4());
        getLifecycle().a(new 5());
        a2.c();
        C.c(this);
        if (i <= 23) {
            getLifecycle().a(new ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().h("android:support:activity-result", new androidx.activity.c(this));
        addOnContextAvailableListener(new androidx.activity.d(this));
    }

    public static /* synthetic */ void a1(ComponentActivity componentActivity, Context context) {
        componentActivity.e1(context);
    }

    public static /* synthetic */ void access$001(ComponentActivity componentActivity) {
        super.onBackPressed();
    }

    public static /* synthetic */ Bundle b1(ComponentActivity componentActivity) {
        return componentActivity.d1();
    }

    private void c1() {
        O.a(getWindow().getDecorView(), this);
        P.a(getWindow().getDecorView(), this);
        F0.f.a(getWindow().getDecorView(), this);
        n.a(getWindow().getDecorView(), this);
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        c1();
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(x xVar) {
        this.mMenuHostHelper.c(xVar);
    }

    public final void addOnConfigurationChangedListener(O.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(a.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    public final void addOnMultiWindowModeChangedListener(O.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(O.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(O.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(O.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public final /* synthetic */ Bundle d1() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    public final /* synthetic */ void e1(Context context) {
        Bundle b2 = getSavedStateRegistry().b("android:support:activity-result");
        if (b2 != null) {
            this.mActivityResultRegistry.g(b2);
        }
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new M();
            }
        }
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public m0.a getDefaultViewModelCreationExtras() {
        m0.d dVar = new m0.d();
        if (getApplication() != null) {
            dVar.c(J.a.g, getApplication());
        }
        dVar.c(C.a, this);
        dVar.c(C.b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            dVar.c(C.c, getIntent().getExtras());
        }
        return dVar;
    }

    public J.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new F(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.a;
        }
        return null;
    }

    public androidx.lifecycle.j getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final F0.c getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public M getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mActivityResultRegistry.b(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.f();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            ((O.a) it.next()).accept(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        z.g(this);
        if (L.a.d()) {
            this.mOnBackPressedDispatcher.g(d.a(this));
        }
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    public void onMultiWindowModeChanged(boolean z) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            ((O.a) it.next()).accept(new D.i(z));
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            ((O.a) it.next()).accept(intent);
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i, menu);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            ((O.a) it.next()).accept(new D.M(z));
        }
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.b(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        M m = this.mViewModelStore;
        if (m == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            m = eVar.b;
        }
        if (m == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.a = onRetainCustomNonConfigurationInstance;
        eVar2.b = m;
        return eVar2;
    }

    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.j lifecycle = getLifecycle();
        if (lifecycle instanceof q) {
            ((q) lifecycle).o(j.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            ((O.a) it.next()).accept(Integer.valueOf(i));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final androidx.activity.result.c registerForActivityResult(b.a aVar, androidx.activity.result.b bVar) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, bVar);
    }

    public void removeMenuProvider(x xVar) {
        this.mMenuHostHelper.l(xVar);
    }

    public final void removeOnConfigurationChangedListener(O.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(a.b bVar) {
        this.mContextAwareHelper.e(bVar);
    }

    public final void removeOnMultiWindowModeChangedListener(O.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(O.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(O.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(O.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    public void reportFullyDrawn() {
        try {
            if (J0.b.d()) {
                J0.b.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            J0.b.b();
        } catch (Throwable th) {
            J0.b.b();
            throw th;
        }
    }

    public void setContentView(int i) {
        c1();
        super.setContentView(i);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void addMenuProvider(x xVar, p pVar) {
        this.mMenuHostHelper.d(xVar, pVar);
    }

    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                ((O.a) it.next()).accept(new D.i(z, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                ((O.a) it.next()).accept(new D.M(z, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final androidx.activity.result.c registerForActivityResult(b.a aVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.b bVar) {
        return activityResultRegistry.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, bVar);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        c1();
        super.setContentView(view);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(x xVar, p pVar, j.c cVar) {
        this.mMenuHostHelper.e(xVar, pVar, cVar);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        c1();
        super.setContentView(view, layoutParams);
    }
}
