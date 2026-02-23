package androidx.fragment.app;

import D.O;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.F;
import androidx.lifecycle.J;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.P;
import androidx.lifecycle.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.p, N, androidx.lifecycle.i, F0.e {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    i mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    J.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    androidx.fragment.app.m mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    androidx.fragment.app.j mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.q mLifecycleRegistry;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    F0.d mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    A mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    androidx.fragment.app.m mChildFragmentManager = new n();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new a();
    j.c mMaxState = j.c.RESUMED;
    androidx.lifecycle.u mViewLifecycleOwnerLiveData = new androidx.lifecycle.u();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList mOnPreAttachedListeners = new ArrayList();

    public class 5 implements androidx.lifecycle.n {
        public 5() {
        }

        public void b(androidx.lifecycle.p pVar, j.b bVar) {
            View view;
            if (bVar != j.b.ON_STOP || (view = Fragment.this.mView) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ C a;

        public c(C c) {
            this.a = c;
        }

        public void run() {
            this.a.g();
        }
    }

    public class d extends androidx.fragment.app.g {
        public d() {
        }

        public View c(int i) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        public boolean d() {
            return Fragment.this.mView != null;
        }
    }

    public class e implements n.a {
        public e() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r3) {
            Fragment fragment = Fragment.this;
            Object obj = fragment.mHost;
            return obj instanceof androidx.activity.result.d ? ((androidx.activity.result.d) obj).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
        }
    }

    public class f implements n.a {
        public final /* synthetic */ ActivityResultRegistry a;

        public f(ActivityResultRegistry activityResultRegistry) {
            this.a = activityResultRegistry;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r1) {
            return this.a;
        }
    }

    public class g extends k {
        public final /* synthetic */ n.a a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ b.a c;
        public final /* synthetic */ androidx.activity.result.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(n.a aVar, AtomicReference atomicReference, b.a aVar2, androidx.activity.result.b bVar) {
            super(null);
            this.a = aVar;
            this.b = atomicReference;
            this.c = aVar2;
            this.d = bVar;
        }

        public void a() {
            String generateActivityResultKey = Fragment.this.generateActivityResultKey();
            this.b.set(((ActivityResultRegistry) this.a.apply(null)).i(generateActivityResultKey, Fragment.this, this.c, this.d));
        }
    }

    public class h extends androidx.activity.result.c {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ b.a b;

        public h(AtomicReference atomicReference, b.a aVar) {
            this.a = atomicReference;
            this.b = aVar;
        }

        public void b(Object obj, D.d dVar) {
            androidx.activity.result.c cVar = (androidx.activity.result.c) this.a.get();
            if (cVar == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            cVar.b(obj, dVar);
        }

        public void c() {
            androidx.activity.result.c cVar = (androidx.activity.result.c) this.a.getAndSet((Object) null);
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public static class i {
        public View a;
        public Animator b;
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public ArrayList i;
        public ArrayList j;
        public Object k = null;
        public Object l;
        public Object m;
        public Object n;
        public Object o;
        public Object p;
        public Boolean q;
        public Boolean r;
        public float s;
        public View t;
        public boolean u;
        public l v;
        public boolean w;

        public i() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.l = obj;
            this.m = null;
            this.n = obj;
            this.o = null;
            this.p = obj;
            this.s = 1.0f;
            this.t = null;
        }
    }

    public static class j extends RuntimeException {
        public j(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static abstract class k {
        public k() {
        }

        public abstract void a();

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    public interface l {
        void a();

        void b();
    }

    public static class m implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public final Bundle a;

        public class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel) {
                return new m(parcel, null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public m[] newArray(int i) {
                return new m[i];
            }
        }

        public m(Bundle bundle) {
            this.a = bundle;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.a);
        }

        public m(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.a = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }
    }

    public Fragment() {
        r();
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        androidx.fragment.app.m mVar;
        i iVar = this.mAnimationInfo;
        l lVar = null;
        if (iVar != null) {
            iVar.u = false;
            l lVar2 = iVar.v;
            iVar.v = null;
            lVar = lVar2;
        }
        if (lVar != null) {
            lVar.b();
            return;
        }
        if (!androidx.fragment.app.m.P || this.mView == null || (viewGroup = this.mContainer) == null || (mVar = this.mFragmentManager) == null) {
            return;
        }
        C n = C.n(viewGroup, mVar);
        n.p();
        if (z) {
            this.mHost.g().post(new c(n));
        } else {
            n.g();
        }
    }

    public androidx.fragment.app.g createFragmentContainer() {
        return new d();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            n0.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.W(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.i0(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final androidx.fragment.app.e getActivity() {
        androidx.fragment.app.j jVar = this.mHost;
        if (jVar == null) {
            return null;
        }
        return (androidx.fragment.app.e) jVar.e();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.a;
    }

    public Animator getAnimator() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final androidx.fragment.app.m getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        androidx.fragment.app.j jVar = this.mHost;
        if (jVar == null) {
            return null;
        }
        return jVar.f();
    }

    public /* synthetic */ m0.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.h.a(this);
    }

    public J.b getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && androidx.fragment.app.m.F0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new F(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.d;
    }

    public Object getEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.k;
    }

    public O getEnterTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    public int getExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.e;
    }

    public Object getExitTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.m;
    }

    public O getExitTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    public View getFocusedView() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.t;
    }

    @Deprecated
    public final androidx.fragment.app.m getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        androidx.fragment.app.j jVar = this.mHost;
        if (jVar == null) {
            return null;
        }
        return jVar.i();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    public androidx.lifecycle.j getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public n0.a getLoaderManager() {
        return n0.a.b(this);
    }

    public int getNextTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.h;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final androidx.fragment.app.m getParentFragmentManager() {
        androidx.fragment.app.m mVar = this.mFragmentManager;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public boolean getPopDirection() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.c;
    }

    public int getPopEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f;
    }

    public int getPopExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.g;
    }

    public float getPostOnViewCreatedAlpha() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.s;
    }

    public Object getReenterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.n;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.l;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    public final F0.c getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public Object getSharedElementEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.o;
    }

    public Object getSharedElementReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.p;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList getSharedElementSourceNames() {
        ArrayList arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.i) == null) ? new ArrayList() : arrayList;
    }

    public ArrayList getSharedElementTargetNames() {
        ArrayList arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.j) == null) ? new ArrayList() : arrayList;
    }

    public final String getString(int i2) {
        return getResources().getString(i2);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        androidx.fragment.app.m mVar = this.mFragmentManager;
        if (mVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return mVar.f0(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i2) {
        return getResources().getText(i2);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public androidx.lifecycle.p getViewLifecycleOwner() {
        A a2 = this.mViewLifecycleOwner;
        if (a2 != null) {
            return a2;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public M getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (p() != j.c.INITIALIZED.ordinal()) {
            return this.mFragmentManager.A0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        r();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new n();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.w;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        androidx.fragment.app.m mVar;
        return this.mMenuVisible && ((mVar = this.mFragmentManager) == null || mVar.H0(this.mParentFragment));
    }

    public boolean isPostponed() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.u;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        androidx.fragment.app.m mVar = this.mFragmentManager;
        if (mVar == null) {
            return false;
        }
        return mVar.K0();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.T0();
    }

    public final i o() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new i();
        }
        return this.mAnimationInfo;
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (androidx.fragment.app.m.F0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.J0(1)) {
            return;
        }
        this.mChildFragmentManager.C();
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public final int p() {
        j.c cVar = this.mMaxState;
        return (cVar == j.c.INITIALIZED || this.mParentFragment == null) ? cVar.ordinal() : Math.min(cVar.ordinal(), this.mParentFragment.p());
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.T0();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            w();
            this.mChildFragmentManager.y();
        } else {
            throw new E("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public void performAttach() {
        Iterator it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.k(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f());
        if (this.mCalled) {
            this.mFragmentManager.I(this);
            this.mChildFragmentManager.z();
        } else {
            throw new E("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.A(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.B(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.T0();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new 5());
        this.mSavedStateRegistryController.d(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.h(j.b.ON_CREATE);
            return;
        }
        throw new E("Fragment " + this + " did not call through to super.onCreate()");
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return z | this.mChildFragmentManager.D(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.T0();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new A(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView == null) {
            if (this.mViewLifecycleOwner.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        } else {
            this.mViewLifecycleOwner.b();
            androidx.lifecycle.O.a(this.mView, this.mViewLifecycleOwner);
            P.a(this.mView, this.mViewLifecycleOwner);
            F0.f.a(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.o(this.mViewLifecycleOwner);
        }
    }

    public void performDestroy() {
        this.mChildFragmentManager.E();
        this.mLifecycleRegistry.h(j.b.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new E("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void performDestroyView() {
        this.mChildFragmentManager.F();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().isAtLeast(j.c.CREATED)) {
            this.mViewLifecycleOwner.a(j.b.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            n0.a.b(this).d();
            this.mPerformedCreateView = false;
        } else {
            throw new E("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.E0()) {
                return;
            }
            this.mChildFragmentManager.E();
            this.mChildFragmentManager = new n();
            return;
        }
        throw new E("Fragment " + this + " did not call through to super.onDetach()");
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.G();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.H(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.J(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.K(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.M();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(j.b.ON_PAUSE);
        }
        this.mLifecycleRegistry.h(j.b.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new E("Fragment " + this + " did not call through to super.onPause()");
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.N(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return z | this.mChildFragmentManager.O(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean I0 = this.mFragmentManager.I0(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != I0) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(I0);
            onPrimaryNavigationFragmentChanged(I0);
            this.mChildFragmentManager.P();
        }
    }

    public void performResume() {
        this.mChildFragmentManager.T0();
        this.mChildFragmentManager.a0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new E("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.q qVar = this.mLifecycleRegistry;
        j.b bVar = j.b.ON_RESUME;
        qVar.h(bVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bVar);
        }
        this.mChildFragmentManager.Q();
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
        Parcelable l1 = this.mChildFragmentManager.l1();
        if (l1 != null) {
            bundle.putParcelable("android:support:fragments", l1);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.T0();
        this.mChildFragmentManager.a0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new E("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.q qVar = this.mLifecycleRegistry;
        j.b bVar = j.b.ON_START;
        qVar.h(bVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bVar);
        }
        this.mChildFragmentManager.R();
    }

    public void performStop() {
        this.mChildFragmentManager.T();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(j.b.ON_STOP);
        }
        this.mLifecycleRegistry.h(j.b.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new E("Fragment " + this + " did not call through to super.onStop()");
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.U();
    }

    public void postponeEnterTransition() {
        o().u = true;
    }

    public final void r() {
        this.mLifecycleRegistry = new androidx.lifecycle.q(this);
        this.mSavedStateRegistryController = F0.d.a(this);
        this.mDefaultFactory = null;
    }

    public final androidx.activity.result.c registerForActivityResult(b.a aVar, androidx.activity.result.b bVar) {
        return u(aVar, new e(), bVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i2) {
        if (this.mHost != null) {
            getParentFragmentManager().L0(this, strArr, i2);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final androidx.fragment.app.e requireActivity() {
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    public final androidx.fragment.app.m requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.j1(parcelable);
        this.mChildFragmentManager.C();
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(j.b.ON_CREATE);
            }
        } else {
            throw new E("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        o().r = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        o().q = Boolean.valueOf(z);
    }

    public void setAnimatingAway(View view) {
        o().a = view;
    }

    public void setAnimations(int i2, int i3, int i4, int i5) {
        if (this.mAnimationInfo == null && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        o().d = i2;
        o().e = i3;
        o().f = i4;
        o().g = i5;
    }

    public void setAnimator(Animator animator) {
        o().b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(O o) {
        o().getClass();
    }

    public void setEnterTransition(Object obj) {
        o().k = obj;
    }

    public void setExitSharedElementCallback(O o) {
        o().getClass();
    }

    public void setExitTransition(Object obj) {
        o().m = obj;
    }

    public void setFocusedView(View view) {
        o().t = view;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.p();
        }
    }

    public void setHideReplaced(boolean z) {
        o().w = z;
    }

    public void setInitialSavedState(m mVar) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (mVar == null || (bundle = mVar.a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.p();
            }
        }
    }

    public void setNextTransition(int i2) {
        if (this.mAnimationInfo == null && i2 == 0) {
            return;
        }
        o();
        this.mAnimationInfo.h = i2;
    }

    public void setOnStartEnterTransitionListener(l lVar) {
        o();
        i iVar = this.mAnimationInfo;
        l lVar2 = iVar.v;
        if (lVar == lVar2) {
            return;
        }
        if (lVar != null && lVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (iVar.u) {
            iVar.v = lVar;
        }
        if (lVar != null) {
            lVar.a();
        }
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        o().c = z;
    }

    public void setPostOnViewCreatedAlpha(float f2) {
        o().s = f2;
    }

    public void setReenterTransition(Object obj) {
        o().n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        androidx.fragment.app.m mVar = this.mFragmentManager;
        if (mVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            mVar.i(this);
        } else {
            mVar.h1(this);
        }
    }

    public void setReturnTransition(Object obj) {
        o().l = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        o().o = obj;
    }

    public void setSharedElementNames(ArrayList arrayList, ArrayList arrayList2) {
        o();
        i iVar = this.mAnimationInfo;
        iVar.i = arrayList;
        iVar.j = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        o().p = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i2) {
        androidx.fragment.app.m mVar = this.mFragmentManager;
        androidx.fragment.app.m mVar2 = fragment != null ? fragment.mFragmentManager : null;
        if (mVar != null && mVar2 != null && mVar != mVar2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
            if (fragment2.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
        } else {
            if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = fragment;
                this.mTargetRequestCode = i2;
            }
            this.mTargetWho = fragment.mWho;
        }
        this.mTarget = null;
        this.mTargetRequestCode = i2;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            androidx.fragment.app.m mVar = this.mFragmentManager;
            mVar.V0(mVar.v(this));
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 5 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        androidx.fragment.app.j jVar = this.mHost;
        if (jVar != null) {
            return jVar.m(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityForResult(intent, i2, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (androidx.fragment.app.m.F0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i2 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        getParentFragmentManager().N0(this, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !o().u) {
            return;
        }
        if (this.mHost == null) {
            o().u = false;
        } else if (Looper.myLooper() != this.mHost.g().getLooper()) {
            this.mHost.g().postAtFrontOfQueue(new b());
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public final androidx.activity.result.c u(b.a aVar, n.a aVar2, androidx.activity.result.b bVar) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            v(new g(aVar2, atomicReference, aVar, bVar));
            return new h(atomicReference, aVar);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }

    public final void v(k kVar) {
        if (this.mState >= 0) {
            kVar.a();
        } else {
            this.mOnPreAttachedListeners.add(kVar);
        }
    }

    public final void w() {
        if (androidx.fragment.app.m.F0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) androidx.fragment.app.i.d(context.getClassLoader(), str).getConstructor((Class[]) null).newInstance((Object[]) null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e2) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new j("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (IllegalAccessException e4) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        } catch (InvocationTargetException e5) {
            throw new j("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        androidx.fragment.app.j jVar = this.mHost;
        if (jVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater j2 = jVar.j();
        P.r.a(j2, this.mChildFragmentManager.u0());
        return j2;
    }

    public final String getString(int i2, Object... objArr) {
        return getResources().getString(i2, objArr);
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        androidx.fragment.app.j jVar = this.mHost;
        Activity e2 = jVar == null ? null : jVar.e();
        if (e2 != null) {
            this.mCalled = false;
            onAttach(e2);
        }
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        androidx.fragment.app.j jVar = this.mHost;
        Activity e2 = jVar == null ? null : jVar.e();
        if (e2 != null) {
            this.mCalled = false;
            onInflate(e2, attributeSet, bundle);
        }
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        o().u = true;
        androidx.fragment.app.m mVar = this.mFragmentManager;
        Handler g2 = mVar != null ? mVar.t0().g() : new Handler(Looper.getMainLooper());
        g2.removeCallbacks(this.mPostponedDurationRunnable);
        g2.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final androidx.activity.result.c registerForActivityResult(b.a aVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.b bVar) {
        return u(aVar, new f(activityResultRegistry), bVar);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        androidx.fragment.app.j jVar = this.mHost;
        if (jVar != null) {
            jVar.n(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().M0(this, intent, i2, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
}
