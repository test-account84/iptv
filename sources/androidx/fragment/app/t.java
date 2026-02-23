package androidx.fragment.app;

import P.L;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.C;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.N;
import androidx.lifecycle.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class t {
    public final l a;
    public final v b;
    public final Fragment c;
    public boolean d = false;
    public int e = -1;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            L.p0(this.a);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.c.values().length];
            a = iArr;
            try {
                iArr[j.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[j.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public t(l lVar, v vVar, Fragment fragment) {
        this.a = lVar;
        this.b = vVar;
        this.c = fragment;
    }

    public void a() {
        if (m.F0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        l lVar = this.a;
        Fragment fragment2 = this.c;
        lVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void b() {
        int j = this.b.j(this.c);
        Fragment fragment = this.c;
        fragment.mContainer.addView(fragment.mView, j);
    }

    public void c() {
        if (m.F0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.c);
        }
        Fragment fragment = this.c;
        Fragment fragment2 = fragment.mTarget;
        t tVar = null;
        if (fragment2 != null) {
            t m = this.b.m(fragment2.mWho);
            if (m == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            tVar = m;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (tVar = this.b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (tVar != null && (m.P || tVar.k().mState < 1)) {
            tVar.m();
        }
        Fragment fragment4 = this.c;
        fragment4.mHost = fragment4.mFragmentManager.t0();
        Fragment fragment5 = this.c;
        fragment5.mParentFragment = fragment5.mFragmentManager.w0();
        this.a.g(this.c, false);
        this.c.performAttach();
        this.a.b(this.c, false);
    }

    public int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i = this.e;
        int i2 = b.a[fragment2.mMaxState.ordinal()];
        if (i2 != 1) {
            i = i2 != 2 ? i2 != 3 ? i2 != 4 ? Math.min(i, -1) : Math.min(i, 0) : Math.min(i, 1) : Math.min(i, 5);
        }
        Fragment fragment3 = this.c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i = Math.max(this.e, 2);
                View view = this.c.mView;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.e < 4 ? Math.min(i, fragment3.mState) : Math.min(i, 1);
            }
        }
        if (!this.c.mAdded) {
            i = Math.min(i, 1);
        }
        C.e.b l = (!m.P || (viewGroup = (fragment = this.c).mContainer) == null) ? null : C.n(viewGroup, fragment.getParentFragmentManager()).l(this);
        if (l == C.e.b.ADDING) {
            i = Math.min(i, 6);
        } else if (l == C.e.b.REMOVING) {
            i = Math.max(i, 3);
        } else {
            Fragment fragment4 = this.c;
            if (fragment4.mRemoving) {
                i = fragment4.isInBackStack() ? Math.min(i, 1) : Math.min(i, -1);
            }
        }
        Fragment fragment5 = this.c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i = Math.min(i, 4);
        }
        if (m.F0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i + " for " + this.c);
        }
        return i;
    }

    public void e() {
        if (m.F0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.c.mState = 1;
            return;
        }
        this.a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        l lVar = this.a;
        Fragment fragment3 = this.c;
        lVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    public void f() {
        String str;
        if (this.c.mFromLayout) {
            return;
        }
        if (m.F0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        Fragment fragment2 = this.c;
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i = fragment2.mContainerId;
            if (i == 0) {
                viewGroup = null;
            } else {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.n0().c(this.c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.c;
                    if (!fragment3.mRestored) {
                        try {
                            str = fragment3.getResources().getResourceName(this.c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.c.mContainerId) + " (" + str + ") for fragment " + this.c);
                    }
                }
            }
        }
        Fragment fragment4 = this.c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.c.mView;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.c;
            fragment5.mView.setTag(e0.b.a, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (L.V(this.c.mView)) {
                L.p0(this.c.mView);
            } else {
                View view2 = this.c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.c.performViewCreated();
            l lVar = this.a;
            Fragment fragment7 = this.c;
            lVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.c.mView.getVisibility();
            float alpha = this.c.mView.getAlpha();
            if (m.P) {
                this.c.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.c.setFocusedView(findFocus);
                        if (m.F0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.c);
                        }
                    }
                    this.c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.c;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z = true;
                }
                fragment9.mIsNewlyAdded = z;
            }
        }
        this.c.mState = 2;
    }

    public void g() {
        Fragment f;
        if (m.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (!z2 && !this.b.o().l(this.c)) {
            String str = this.c.mTargetWho;
            if (str != null && (f = this.b.f(str)) != null && f.mRetainInstance) {
                this.c.mTarget = f;
            }
            this.c.mState = 0;
            return;
        }
        j jVar = this.c.mHost;
        if (jVar instanceof N) {
            z = this.b.o().i();
        } else if (jVar.f() instanceof Activity) {
            z = true ^ jVar.f().isChangingConfigurations();
        }
        if (z2 || z) {
            this.b.o().c(this.c);
        }
        this.c.performDestroy();
        this.a.d(this.c, false);
        for (t tVar : this.b.k()) {
            if (tVar != null) {
                Fragment k = tVar.k();
                if (this.c.mWho.equals(k.mTargetWho)) {
                    k.mTarget = this.c;
                    k.mTargetWho = null;
                }
            }
        }
        Fragment fragment2 = this.c;
        String str2 = fragment2.mTargetWho;
        if (str2 != null) {
            fragment2.mTarget = this.b.f(str2);
        }
        this.b.q(this);
    }

    public void h() {
        View view;
        if (m.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.c.performDestroyView();
        this.a.n(this.c, false);
        Fragment fragment2 = this.c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.o(null);
        this.c.mInLayout = false;
    }

    public void i() {
        if (m.F0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.c);
        }
        this.c.performDetach();
        this.a.e(this.c, false);
        Fragment fragment = this.c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((!fragment.mRemoving || fragment.isInBackStack()) && !this.b.o().l(this.c)) {
            return;
        }
        if (m.F0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.c);
        }
        this.c.initState();
    }

    public void j() {
        Fragment fragment = this.c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (m.F0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            Fragment fragment2 = this.c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.c.mSavedFragmentState);
            View view = this.c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.c;
                fragment3.mView.setTag(e0.b.a, fragment3);
                Fragment fragment4 = this.c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.c.performViewCreated();
                l lVar = this.a;
                Fragment fragment5 = this.c;
                lVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.c.mState = 2;
            }
        }
    }

    public Fragment k() {
        return this.c;
    }

    public final boolean l(View view) {
        if (view == this.c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.c.mView) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.d) {
            if (m.F0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.d = true;
            while (true) {
                int d = d();
                Fragment fragment = this.c;
                int i = fragment.mState;
                if (d == i) {
                    if (m.P && fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            C n = C.n(viewGroup, fragment.getParentFragmentManager());
                            if (this.c.mHidden) {
                                n.c(this);
                            } else {
                                n.e(this);
                            }
                        }
                        Fragment fragment2 = this.c;
                        m mVar = fragment2.mFragmentManager;
                        if (mVar != null) {
                            mVar.D0(fragment2);
                        }
                        Fragment fragment3 = this.c;
                        fragment3.mHiddenChanged = false;
                        fragment3.onHiddenChanged(fragment3.mHidden);
                    }
                    this.d = false;
                    return;
                }
                if (d <= i) {
                    switch (i - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (m.F0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                            }
                            Fragment fragment4 = this.c;
                            if (fragment4.mView != null && fragment4.mSavedViewState == null) {
                                t();
                            }
                            Fragment fragment5 = this.c;
                            if (fragment5.mView != null && (viewGroup3 = fragment5.mContainer) != null) {
                                C.n(viewGroup3, fragment5.getParentFragmentManager()).d(this);
                            }
                            this.c.mState = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                C.n(viewGroup2, fragment.getParentFragmentManager()).b(C.e.c.from(this.c.mView.getVisibility()), this);
                            }
                            this.c.mState = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    public void n() {
        if (m.F0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.c);
        }
        this.c.performPause();
        this.a.f(this.c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    public void p() {
        if (m.F0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.c);
        }
        View focusedView = this.c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (m.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.c);
                sb.append(" resulting in focused view ");
                sb.append(this.c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.c.setFocusedView(null);
        this.c.performResume();
        this.a.i(this.c, false);
        Fragment fragment = this.c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final Bundle q() {
        Bundle bundle = new Bundle();
        this.c.performSaveInstanceState(bundle);
        this.a.j(this.c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.c.mView != null) {
            t();
        }
        if (this.c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.c.mSavedViewState);
        }
        if (this.c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.c.mSavedViewRegistryState);
        }
        if (!this.c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.c.mUserVisibleHint);
        }
        return bundle;
    }

    public Fragment.m r() {
        Bundle q;
        if (this.c.mState <= -1 || (q = q()) == null) {
            return null;
        }
        return new Fragment.m(q);
    }

    public s s() {
        s sVar = new s(this.c);
        Fragment fragment = this.c;
        if (fragment.mState <= -1 || sVar.n != null) {
            sVar.n = fragment.mSavedFragmentState;
        } else {
            Bundle q = q();
            sVar.n = q;
            if (this.c.mTargetWho != null) {
                if (q == null) {
                    sVar.n = new Bundle();
                }
                sVar.n.putString("android:target_state", this.c.mTargetWho);
                int i = this.c.mTargetRequestCode;
                if (i != 0) {
                    sVar.n.putInt("android:target_req_state", i);
                }
            }
        }
        return sVar;
    }

    public void t() {
        if (this.c.mView == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        this.c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.c.mSavedViewRegistryState = bundle;
    }

    public void u(int i) {
        this.e = i;
    }

    public void v() {
        if (m.F0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.c);
        }
        this.c.performStart();
        this.a.k(this.c, false);
    }

    public void w() {
        if (m.F0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.c);
        }
        this.c.performStop();
        this.a.l(this.c, false);
    }

    public t(l lVar, v vVar, Fragment fragment, s sVar) {
        this.a = lVar;
        this.b = vVar;
        this.c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = sVar.n;
        fragment.mSavedFragmentState = bundle == null ? new Bundle() : bundle;
    }

    public t(l lVar, v vVar, ClassLoader classLoader, i iVar, s sVar) {
        this.a = lVar;
        this.b = vVar;
        Fragment a2 = iVar.a(classLoader, sVar.a);
        this.c = a2;
        Bundle bundle = sVar.k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.setArguments(sVar.k);
        a2.mWho = sVar.c;
        a2.mFromLayout = sVar.d;
        a2.mRestored = true;
        a2.mFragmentId = sVar.e;
        a2.mContainerId = sVar.f;
        a2.mTag = sVar.g;
        a2.mRetainInstance = sVar.h;
        a2.mRemoving = sVar.i;
        a2.mDetached = sVar.j;
        a2.mHidden = sVar.l;
        a2.mMaxState = j.c.values()[sVar.m];
        Bundle bundle2 = sVar.n;
        a2.mSavedFragmentState = bundle2 == null ? new Bundle() : bundle2;
        if (m.F0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a2);
        }
    }
}
