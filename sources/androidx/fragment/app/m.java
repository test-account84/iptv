package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.fragment.app.w;
import androidx.fragment.app.x;
import androidx.lifecycle.M;
import androidx.lifecycle.j;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class m {
    public static boolean O = false;
    public static boolean P = true;
    public androidx.activity.result.c A;
    public androidx.activity.result.c B;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public ArrayList L;
    public androidx.fragment.app.p M;
    public boolean b;
    public ArrayList d;
    public ArrayList e;
    public OnBackPressedDispatcher g;
    public ArrayList l;
    public androidx.fragment.app.j r;
    public androidx.fragment.app.g s;
    public Fragment t;
    public Fragment u;
    public androidx.activity.result.c z;
    public final ArrayList a = new ArrayList();
    public final v c = new v();
    public final androidx.fragment.app.k f = new androidx.fragment.app.k(this);
    public final androidx.activity.h h = new c(false);
    public final AtomicInteger i = new AtomicInteger();
    public final Map j = DesugarCollections.synchronizedMap(new HashMap());
    public final Map k = DesugarCollections.synchronizedMap(new HashMap());
    public Map m = DesugarCollections.synchronizedMap(new HashMap());
    public final x.g n = new d();
    public final androidx.fragment.app.l o = new androidx.fragment.app.l(this);
    public final CopyOnWriteArrayList p = new CopyOnWriteArrayList();
    public int q = -1;
    public androidx.fragment.app.i v = null;
    public androidx.fragment.app.i w = new e();
    public D x = null;
    public D y = new f();
    public ArrayDeque C = new ArrayDeque();
    public Runnable N = new g();

    public class a implements androidx.activity.result.b {
        public a() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            m mVar = (m) m.this.C.pollFirst();
            if (mVar == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = mVar.a;
            int i = mVar.c;
            Fragment i2 = m.c(m.this).i(str);
            if (i2 != null) {
                i2.onActivityResult(i, aVar.c(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    public class b implements androidx.activity.result.b {
        public b() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            StringBuilder sb;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            m mVar = (m) m.this.C.pollFirst();
            if (mVar == null) {
                sb = new StringBuilder();
                sb.append("No permissions were requested for ");
                sb.append(this);
            } else {
                String str = mVar.a;
                int i2 = mVar.c;
                Fragment i3 = m.c(m.this).i(str);
                if (i3 != null) {
                    i3.onRequestPermissionsResult(i2, strArr, iArr);
                    return;
                } else {
                    sb = new StringBuilder();
                    sb.append("Permission request result delivered for unknown Fragment ");
                    sb.append(str);
                }
            }
            Log.w("FragmentManager", sb.toString());
        }
    }

    public class c extends androidx.activity.h {
        public c(boolean z) {
            super(z);
        }

        public void b() {
            m.this.B0();
        }
    }

    public class d implements x.g {
        public d() {
        }

        public void a(Fragment fragment, L.e eVar) {
            m.this.f(fragment, eVar);
        }

        public void b(Fragment fragment, L.e eVar) {
            if (eVar.c()) {
                return;
            }
            m.this.e1(fragment, eVar);
        }
    }

    public class e extends androidx.fragment.app.i {
        public e() {
        }

        public Fragment a(ClassLoader classLoader, String str) {
            return m.this.t0().b(m.this.t0().f(), str, null);
        }
    }

    public class f implements D {
        public f() {
        }

        public C a(ViewGroup viewGroup) {
            return new androidx.fragment.app.c(viewGroup);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            m.this.a0(true);
        }
    }

    public class h extends AnimatorListenerAdapter {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Fragment d;

        public h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.a = viewGroup;
            this.c = view;
            this.d = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.c);
            animator.removeListener(this);
            Fragment fragment = this.d;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public class i implements q {
        public final /* synthetic */ Fragment a;

        public i(Fragment fragment) {
            this.a = fragment;
        }

        public void a(m mVar, Fragment fragment) {
            this.a.onAttachFragment(fragment);
        }
    }

    public class j implements androidx.activity.result.b {
        public j() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            m mVar = (m) m.this.C.pollFirst();
            if (mVar == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = mVar.a;
            int i = mVar.c;
            Fragment i2 = m.c(m.this).i(str);
            if (i2 != null) {
                i2.onActivityResult(i, aVar.c(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    public static class k extends b.a {
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, androidx.activity.result.e eVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a = eVar.a();
            if (a != null && (bundleExtra = a.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    eVar = new e.b(eVar.e()).b(null).c(eVar.d(), eVar.c()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar);
            if (m.F0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.activity.result.a c(int i, Intent intent) {
            return new androidx.activity.result.a(i, intent);
        }
    }

    public static abstract class l {
        public void a(m mVar, Fragment fragment, Bundle bundle) {
        }

        public void b(m mVar, Fragment fragment, Context context) {
        }

        public void c(m mVar, Fragment fragment, Bundle bundle) {
        }

        public void d(m mVar, Fragment fragment) {
        }

        public void e(m mVar, Fragment fragment) {
        }

        public void f(m mVar, Fragment fragment) {
        }

        public void g(m mVar, Fragment fragment, Context context) {
        }

        public void h(m mVar, Fragment fragment, Bundle bundle) {
        }

        public void i(m mVar, Fragment fragment) {
        }

        public void j(m mVar, Fragment fragment, Bundle bundle) {
        }

        public void k(m mVar, Fragment fragment) {
        }

        public void l(m mVar, Fragment fragment) {
        }

        public void m(m mVar, Fragment fragment, View view, Bundle bundle) {
        }

        public void n(m mVar, Fragment fragment) {
        }
    }

    public static class m implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public String a;
        public int c;

        public class a implements Parcelable.Creator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel) {
                return new m(parcel);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public m[] newArray(int i) {
                return new m[i];
            }
        }

        public m(Parcel parcel) {
            this.a = parcel.readString();
            this.c = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeInt(this.c);
        }

        public m(String str, int i) {
            this.a = str;
            this.c = i;
        }
    }

    public interface n {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    public class o implements n {
        public final String a;
        public final int b;
        public final int c;

        public o(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = m.this.u;
            if (fragment == null || this.b >= 0 || this.a != null || !fragment.getChildFragmentManager().Y0()) {
                return m.this.a1(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    public static class p implements Fragment.l {
        public final boolean a;
        public final androidx.fragment.app.a b;
        public int c;

        public p(androidx.fragment.app.a aVar, boolean z) {
            this.a = z;
            this.b = aVar;
        }

        public void a() {
            this.c++;
        }

        public void b() {
            int i = this.c - 1;
            this.c = i;
            if (i != 0) {
                return;
            }
            this.b.t.n1();
        }

        public void c() {
            androidx.fragment.app.a aVar = this.b;
            aVar.t.t(aVar, this.a, false, false);
        }

        public void d() {
            boolean z = this.c > 0;
            for (Fragment fragment : this.b.t.s0()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            androidx.fragment.app.a aVar = this.b;
            aVar.t.t(aVar, this.a, !z, true);
        }

        public boolean e() {
            return this.c == 0;
        }
    }

    public static boolean F0(int i2) {
        return O || Log.isLoggable("FragmentManager", i2);
    }

    public static /* synthetic */ Map a(m mVar) {
        return mVar.j;
    }

    public static /* synthetic */ Map b(m mVar) {
        return mVar.k;
    }

    public static /* synthetic */ v c(m mVar) {
        return mVar.c;
    }

    public static void c0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        while (i2 < i3) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                aVar.x(-1);
                aVar.C(i2 == i3 + (-1));
            } else {
                aVar.x(1);
                aVar.B();
            }
            i2++;
        }
    }

    public static int k1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    public static Fragment z0(View view) {
        Object tag = view.getTag(e0.b.a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public void A(Configuration configuration) {
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public M A0(Fragment fragment) {
        return this.M.h(fragment);
    }

    public boolean B(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.n()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void B0() {
        a0(true);
        if (this.h.c()) {
            Y0();
        } else {
            this.g.f();
        }
    }

    public void C() {
        this.E = false;
        this.F = false;
        this.M.k(false);
        S(1);
    }

    public void C0(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        r1(fragment);
    }

    public boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.q < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.c.n()) {
            if (fragment != null && H0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = (Fragment) this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public void D0(Fragment fragment) {
        if (fragment.mAdded && G0(fragment)) {
            this.D = true;
        }
    }

    public void E() {
        this.G = true;
        a0(true);
        X();
        S(-1);
        this.r = null;
        this.s = null;
        this.t = null;
        if (this.g != null) {
            this.h.d();
            this.g = null;
        }
        androidx.activity.result.c cVar = this.z;
        if (cVar != null) {
            cVar.c();
            this.A.c();
            this.B.c();
        }
    }

    public boolean E0() {
        return this.G;
    }

    public void F() {
        S(1);
    }

    public void G() {
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public final boolean G0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.o();
    }

    public void H(boolean z) {
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public boolean H0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public void I(Fragment fragment) {
        Iterator it = this.p.iterator();
        while (it.hasNext()) {
            ((q) it.next()).a(this, fragment);
        }
    }

    public boolean I0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        m mVar = fragment.mFragmentManager;
        return fragment.equals(mVar.x0()) && I0(mVar.t);
    }

    public boolean J(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.n()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean J0(int i2) {
        return this.q >= i2;
    }

    public void K(Menu menu) {
        if (this.q < 1) {
            return;
        }
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public boolean K0() {
        return this.E || this.F;
    }

    public final void L(Fragment fragment) {
        if (fragment == null || !fragment.equals(f0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    public void L0(Fragment fragment, String[] strArr, int i2) {
        if (this.B == null) {
            this.r.k(fragment, strArr, i2);
            return;
        }
        this.C.addLast(new m(fragment.mWho, i2));
        this.B.a(strArr);
    }

    public void M() {
        S(5);
    }

    public void M0(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (this.z == null) {
            this.r.n(fragment, intent, i2, bundle);
            return;
        }
        this.C.addLast(new m(fragment.mWho, i2));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.z.a(intent);
    }

    public void N(boolean z) {
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public void N0(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Intent intent2;
        if (this.A == null) {
            this.r.o(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (F0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        androidx.activity.result.e a2 = new e.b(intentSender).b(intent2).c(i4, i3).a();
        this.C.addLast(new m(fragment.mWho, i2));
        if (F0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.A.a(a2);
    }

    public boolean O(Menu menu) {
        boolean z = false;
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.n()) {
            if (fragment != null && H0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void O0(s.b bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = (Fragment) bVar.h(i2);
            if (!fragment.mAdded) {
                View requireView = fragment.requireView();
                fragment.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    public void P() {
        w1();
        L(this.u);
    }

    public void P0(Fragment fragment) {
        if (!this.c.c(fragment.mWho)) {
            if (F0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.q + "since it is not added to " + this);
                return;
            }
            return;
        }
        R0(fragment);
        View view = fragment.mView;
        if (view != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            float f2 = fragment.mPostponedAlpha;
            if (f2 > 0.0f) {
                view.setAlpha(f2);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            f.d c2 = androidx.fragment.app.f.c(this.r.f(), fragment, true, fragment.getPopDirection());
            if (c2 != null) {
                Animation animation = c2.a;
                if (animation != null) {
                    fragment.mView.startAnimation(animation);
                } else {
                    c2.b.setTarget(fragment.mView);
                    c2.b.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            u(fragment);
        }
    }

    public void Q() {
        this.E = false;
        this.F = false;
        this.M.k(false);
        S(7);
    }

    public void Q0(int i2, boolean z) {
        androidx.fragment.app.j jVar;
        if (this.r == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.q) {
            this.q = i2;
            if (P) {
                this.c.r();
            } else {
                Iterator it = this.c.n().iterator();
                while (it.hasNext()) {
                    P0((Fragment) it.next());
                }
                for (t tVar : this.c.k()) {
                    Fragment k2 = tVar.k();
                    if (!k2.mIsNewlyAdded) {
                        P0(k2);
                    }
                    if (k2.mRemoving && !k2.isInBackStack()) {
                        this.c.q(tVar);
                    }
                }
            }
            t1();
            if (this.D && (jVar = this.r) != null && this.q == 7) {
                jVar.p();
                this.D = false;
            }
        }
    }

    public void R() {
        this.E = false;
        this.F = false;
        this.M.k(false);
        S(5);
    }

    public void R0(Fragment fragment) {
        S0(fragment, this.q);
    }

    public final void S(int i2) {
        try {
            this.b = true;
            this.c.d(i2);
            Q0(i2, false);
            if (P) {
                Iterator it = r().iterator();
                while (it.hasNext()) {
                    ((C) it.next()).j();
                }
            }
            this.b = false;
            a0(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void S0(androidx.fragment.app.Fragment r11, int r12) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m.S0(androidx.fragment.app.Fragment, int):void");
    }

    public void T() {
        this.F = true;
        this.M.k(true);
        S(4);
    }

    public void T0() {
        if (this.r == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.M.k(false);
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public void U() {
        S(2);
    }

    public void U0(FragmentContainerView fragmentContainerView) {
        View view;
        for (t tVar : this.c.k()) {
            Fragment k2 = tVar.k();
            if (k2.mContainerId == fragmentContainerView.getId() && (view = k2.mView) != null && view.getParent() == null) {
                k2.mContainer = fragmentContainerView;
                tVar.b();
            }
        }
    }

    public final void V() {
        if (this.H) {
            this.H = false;
            t1();
        }
    }

    public void V0(t tVar) {
        Fragment k2 = tVar.k();
        if (k2.mDeferStart) {
            if (this.b) {
                this.H = true;
                return;
            }
            k2.mDeferStart = false;
            if (P) {
                tVar.m();
            } else {
                R0(k2);
            }
        }
    }

    public void W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = (Fragment) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.z(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            try {
                int size3 = this.a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size3; i4++) {
                        n nVar = (n) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(nVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.s);
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public void W0(int i2, int i3) {
        if (i2 >= 0) {
            Y(new o(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public final void X() {
        if (P) {
            Iterator it = r().iterator();
            while (it.hasNext()) {
                ((C) it.next()).j();
            }
        } else {
            if (this.m.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.m.keySet()) {
                n(fragment);
                R0(fragment);
            }
        }
    }

    public void X0(String str, int i2) {
        Y(new o(str, -1, i2), false);
    }

    public void Y(n nVar, boolean z) {
        if (!z) {
            if (this.r == null) {
                if (!this.G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            p();
        }
        synchronized (this.a) {
            try {
                if (this.r == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(nVar);
                    n1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean Y0() {
        return Z0(null, -1, 0);
    }

    public final void Z(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.r == null) {
            if (!this.G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.r.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            p();
        }
        if (this.I == null) {
            this.I = new ArrayList();
            this.J = new ArrayList();
        }
        this.b = true;
        try {
            e0(null, null);
        } finally {
            this.b = false;
        }
    }

    public final boolean Z0(String str, int i2, int i3) {
        a0(false);
        Z(true);
        Fragment fragment = this.u;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().Y0()) {
            return true;
        }
        boolean a1 = a1(this.I, this.J, str, i2, i3);
        if (a1) {
            this.b = true;
            try {
                g1(this.I, this.J);
            } finally {
                q();
            }
        }
        w1();
        V();
        this.c.b();
        return a1;
    }

    public boolean a0(boolean z) {
        Z(z);
        boolean z2 = false;
        while (k0(this.I, this.J)) {
            z2 = true;
            this.b = true;
            try {
                g1(this.I, this.J);
            } finally {
                q();
            }
        }
        w1();
        V();
        this.c.b();
        return z2;
    }

    public boolean a1(ArrayList arrayList, ArrayList arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList arrayList3 = this.d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.d.get(size2);
                    if ((str != null && str.equals(aVar.E())) || (i2 >= 0 && i2 == aVar.v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.d.get(size2);
                        if (str == null || !str.equals(aVar2.E())) {
                            if (i2 < 0 || i2 != aVar2.v) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.d.size() - 1) {
                return false;
            }
            for (int size3 = this.d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void b0(n nVar, boolean z) {
        if (z && (this.r == null || this.G)) {
            return;
        }
        Z(z);
        if (nVar.a(this.I, this.J)) {
            this.b = true;
            try {
                g1(this.I, this.J);
            } finally {
                q();
            }
        }
        w1();
        V();
        this.c.b();
    }

    public final int b1(ArrayList arrayList, ArrayList arrayList2, int i2, int i3, s.b bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i5);
            boolean booleanValue = ((Boolean) arrayList2.get(i5)).booleanValue();
            if (aVar.I() && !aVar.G(arrayList, i5 + 1, i3)) {
                if (this.L == null) {
                    this.L = new ArrayList();
                }
                p pVar = new p(aVar, booleanValue);
                this.L.add(pVar);
                aVar.K(pVar);
                if (booleanValue) {
                    aVar.B();
                } else {
                    aVar.C(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                d(bVar);
            }
        }
        return i4;
    }

    public void c1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            u1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public final void d(s.b bVar) {
        int i2 = this.q;
        if (i2 < 1) {
            return;
        }
        int min = Math.min(i2, 5);
        for (Fragment fragment : this.c.n()) {
            if (fragment.mState < min) {
                S0(fragment, min);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    bVar.add(fragment);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    public final void d0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        ?? r1;
        boolean z;
        int i4;
        int i5;
        ArrayList arrayList3;
        int i6;
        int i7;
        ArrayList arrayList4;
        int i8;
        boolean z2;
        boolean z3 = ((androidx.fragment.app.a) arrayList.get(i2)).r;
        ArrayList arrayList5 = this.K;
        if (arrayList5 == null) {
            this.K = new ArrayList();
        } else {
            arrayList5.clear();
        }
        this.K.addAll(this.c.n());
        Fragment x0 = x0();
        boolean z4 = false;
        for (int i9 = i2; i9 < i3; i9++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i9);
            x0 = !((Boolean) arrayList2.get(i9)).booleanValue() ? aVar.D(this.K, x0) : aVar.L(this.K, x0);
            z4 = z4 || aVar.i;
        }
        this.K.clear();
        if (z3 || this.q < 1) {
            r1 = 1;
        } else if (P) {
            for (int i10 = i2; i10 < i3; i10++) {
                Iterator it = ((androidx.fragment.app.a) arrayList.get(i10)).c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((w.a) it.next()).b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.c.p(v(fragment));
                    }
                }
            }
            r1 = 1;
        } else {
            r1 = 1;
            x.B(this.r.f(), this.s, arrayList, arrayList2, i2, i3, false, this.n);
        }
        c0(arrayList, arrayList2, i2, i3);
        if (P) {
            boolean booleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
            for (int i11 = i2; i11 < i3; i11++) {
                androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i11);
                if (booleanValue) {
                    for (int size = aVar2.c.size() - r1; size >= 0; size--) {
                        Fragment fragment2 = ((w.a) aVar2.c.get(size)).b;
                        if (fragment2 != null) {
                            v(fragment2).m();
                        }
                    }
                } else {
                    Iterator it2 = aVar2.c.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment3 = ((w.a) it2.next()).b;
                        if (fragment3 != null) {
                            v(fragment3).m();
                        }
                    }
                }
            }
            Q0(this.q, r1);
            for (C c2 : s(arrayList, i2, i3)) {
                c2.r(booleanValue);
                c2.p();
                c2.g();
            }
            i8 = i3;
            arrayList4 = arrayList2;
        } else {
            if (z3) {
                s.b bVar = new s.b();
                d(bVar);
                i6 = 1;
                z = z3;
                i4 = i3;
                i5 = i2;
                arrayList3 = arrayList2;
                i7 = b1(arrayList, arrayList2, i2, i3, bVar);
                O0(bVar);
            } else {
                z = z3;
                i4 = i3;
                i5 = i2;
                arrayList3 = arrayList2;
                i6 = 1;
                i7 = i4;
            }
            if (i7 == i5 || !z) {
                arrayList4 = arrayList3;
                i8 = i4;
            } else {
                if (this.q >= i6) {
                    arrayList4 = arrayList3;
                    int i12 = i7;
                    i8 = i4;
                    z2 = true;
                    x.B(this.r.f(), this.s, arrayList, arrayList2, i2, i12, true, this.n);
                } else {
                    arrayList4 = arrayList3;
                    i8 = i4;
                    z2 = true;
                }
                Q0(this.q, z2);
            }
        }
        for (int i13 = i2; i13 < i8; i13++) {
            androidx.fragment.app.a aVar3 = (androidx.fragment.app.a) arrayList.get(i13);
            if (((Boolean) arrayList4.get(i13)).booleanValue() && aVar3.v >= 0) {
                aVar3.v = -1;
            }
            aVar3.J();
        }
        if (z4) {
            i1();
        }
    }

    public void d1(l lVar, boolean z) {
        this.o.o(lVar, z);
    }

    public void e(androidx.fragment.app.a aVar) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(aVar);
    }

    public final void e0(ArrayList arrayList, ArrayList arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList arrayList3 = this.L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            p pVar = (p) this.L.get(i2);
            if (arrayList == null || pVar.a || (indexOf2 = arrayList.indexOf(pVar.b)) == -1 || arrayList2 == null || !((Boolean) arrayList2.get(indexOf2)).booleanValue()) {
                if (pVar.e() || (arrayList != null && pVar.b.G(arrayList, 0, arrayList.size()))) {
                    this.L.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || pVar.a || (indexOf = arrayList.indexOf(pVar.b)) == -1 || arrayList2 == null || !((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        pVar.d();
                    }
                }
                i2++;
            } else {
                this.L.remove(i2);
                i2--;
                size--;
            }
            pVar.c();
            i2++;
        }
    }

    public void e1(Fragment fragment, L.e eVar) {
        HashSet hashSet = (HashSet) this.m.get(fragment);
        if (hashSet != null && hashSet.remove(eVar) && hashSet.isEmpty()) {
            this.m.remove(fragment);
            if (fragment.mState < 5) {
                w(fragment);
                R0(fragment);
            }
        }
    }

    public void f(Fragment fragment, L.e eVar) {
        if (this.m.get(fragment) == null) {
            this.m.put(fragment, new HashSet());
        }
        ((HashSet) this.m.get(fragment)).add(eVar);
    }

    public Fragment f0(String str) {
        return this.c.f(str);
    }

    public void f1(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            this.c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            r1(fragment);
        }
    }

    public t g(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        t v = v(fragment);
        fragment.mFragmentManager = this;
        this.c.p(v);
        if (!fragment.mDetached) {
            this.c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
        return v;
    }

    public Fragment g0(int i2) {
        return this.c.g(i2);
    }

    public final void g1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        e0(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((androidx.fragment.app.a) arrayList.get(i2)).r) {
                if (i3 != i2) {
                    d0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((androidx.fragment.app.a) arrayList.get(i3)).r) {
                        i3++;
                    }
                }
                d0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            d0(arrayList, arrayList2, i3, size);
        }
    }

    public void h(q qVar) {
        this.p.add(qVar);
    }

    public Fragment h0(String str) {
        return this.c.h(str);
    }

    public void h1(Fragment fragment) {
        this.M.j(fragment);
    }

    public void i(Fragment fragment) {
        this.M.b(fragment);
    }

    public Fragment i0(String str) {
        return this.c.i(str);
    }

    public final void i1() {
        ArrayList arrayList = this.l;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.D.a(this.l.get(0));
        throw null;
    }

    public int j() {
        return this.i.getAndIncrement();
    }

    public final void j0() {
        if (P) {
            Iterator it = r().iterator();
            while (it.hasNext()) {
                ((C) it.next()).k();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                ((p) this.L.remove(0)).d();
            }
        }
    }

    public void j1(Parcelable parcelable) {
        t tVar;
        if (parcelable == null) {
            return;
        }
        androidx.fragment.app.o oVar = (androidx.fragment.app.o) parcelable;
        if (oVar.a == null) {
            return;
        }
        this.c.t();
        Iterator it = oVar.a.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar != null) {
                Fragment d2 = this.M.d(sVar.c);
                if (d2 != null) {
                    if (F0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + d2);
                    }
                    tVar = new t(this.o, this.c, d2, sVar);
                } else {
                    tVar = new t(this.o, this.c, this.r.f().getClassLoader(), q0(), sVar);
                }
                Fragment k2 = tVar.k();
                k2.mFragmentManager = this;
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + k2.mWho + "): " + k2);
                }
                tVar.o(this.r.f().getClassLoader());
                this.c.p(tVar);
                tVar.u(this.q);
            }
        }
        for (Fragment fragment : this.M.g()) {
            if (!this.c.c(fragment.mWho)) {
                if (F0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + oVar.a);
                }
                this.M.j(fragment);
                fragment.mFragmentManager = this;
                t tVar2 = new t(this.o, this.c, fragment);
                tVar2.u(1);
                tVar2.m();
                fragment.mRemoving = true;
                tVar2.m();
            }
        }
        this.c.u(oVar.c);
        if (oVar.d != null) {
            this.d = new ArrayList(oVar.d.length);
            int i2 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = oVar.d;
                if (i2 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a a2 = bVarArr[i2].a(this);
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.v + "): " + a2);
                    PrintWriter printWriter = new PrintWriter(new B("FragmentManager"));
                    a2.A("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(a2);
                i2++;
            }
        } else {
            this.d = null;
        }
        this.i.set(oVar.e);
        String str = oVar.f;
        if (str != null) {
            Fragment f0 = f0(str);
            this.u = f0;
            L(f0);
        }
        ArrayList arrayList = oVar.g;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bundle bundle = (Bundle) oVar.h.get(i3);
                bundle.setClassLoader(this.r.f().getClassLoader());
                this.j.put(arrayList.get(i3), bundle);
            }
        }
        this.C = new ArrayDeque(oVar.i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void k(androidx.fragment.app.j r3, androidx.fragment.app.g r4, androidx.fragment.app.Fragment r5) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m.k(androidx.fragment.app.j, androidx.fragment.app.g, androidx.fragment.app.Fragment):void");
    }

    public final boolean k0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                    return false;
                }
                int size = this.a.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    z |= ((n) this.a.get(i2)).a(arrayList, arrayList2);
                }
                this.a.clear();
                this.r.g().removeCallbacks(this.N);
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void l(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.c.a(fragment);
            if (F0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
    }

    public int l0() {
        ArrayList arrayList = this.d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public Parcelable l1() {
        int size;
        j0();
        X();
        a0(true);
        this.E = true;
        this.M.k(true);
        ArrayList v = this.c.v();
        androidx.fragment.app.b[] bVarArr = null;
        if (v.isEmpty()) {
            if (F0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList w = this.c.w();
        ArrayList arrayList = this.d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i2 = 0; i2 < size; i2++) {
                bVarArr[i2] = new androidx.fragment.app.b((androidx.fragment.app.a) this.d.get(i2));
                if (F0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.d.get(i2));
                }
            }
        }
        androidx.fragment.app.o oVar = new androidx.fragment.app.o();
        oVar.a = v;
        oVar.c = w;
        oVar.d = bVarArr;
        oVar.e = this.i.get();
        Fragment fragment = this.u;
        if (fragment != null) {
            oVar.f = fragment.mWho;
        }
        oVar.g.addAll(this.j.keySet());
        oVar.h.addAll(this.j.values());
        oVar.i = new ArrayList(this.C);
        return oVar;
    }

    public w m() {
        return new androidx.fragment.app.a(this);
    }

    public final androidx.fragment.app.p m0(Fragment fragment) {
        return this.M.e(fragment);
    }

    public Fragment.m m1(Fragment fragment) {
        t m2 = this.c.m(fragment.mWho);
        if (m2 == null || !m2.k().equals(fragment)) {
            u1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return m2.r();
    }

    public final void n(Fragment fragment) {
        HashSet hashSet = (HashSet) this.m.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((L.e) it.next()).a();
            }
            hashSet.clear();
            w(fragment);
            this.m.remove(fragment);
        }
    }

    public androidx.fragment.app.g n0() {
        return this.s;
    }

    public void n1() {
        synchronized (this.a) {
            try {
                ArrayList arrayList = this.L;
                boolean z = (arrayList == null || arrayList.isEmpty()) ? false : true;
                boolean z2 = this.a.size() == 1;
                if (z || z2) {
                    this.r.g().removeCallbacks(this.N);
                    this.r.g().post(this.N);
                    w1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean o() {
        boolean z = false;
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                z = G0(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public Fragment o0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment f0 = f0(string);
        if (f0 == null) {
            u1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return f0;
    }

    public void o1(Fragment fragment, boolean z) {
        FragmentContainerView p0 = p0(fragment);
        if (p0 == null || !(p0 instanceof FragmentContainerView)) {
            return;
        }
        p0.setDrawDisappearingViewsLast(!z);
    }

    public final void p() {
        if (K0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final ViewGroup p0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.s.d()) {
            ViewGroup c2 = this.s.c(fragment.mContainerId);
            if (c2 instanceof ViewGroup) {
                return c2;
            }
        }
        return null;
    }

    public void p1(Fragment fragment, j.c cVar) {
        if (fragment.equals(f0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void q() {
        this.b = false;
        this.J.clear();
        this.I.clear();
    }

    public androidx.fragment.app.i q0() {
        androidx.fragment.app.i iVar = this.v;
        if (iVar != null) {
            return iVar;
        }
        Fragment fragment = this.t;
        return fragment != null ? fragment.mFragmentManager.q0() : this.w;
    }

    public void q1(Fragment fragment) {
        if (fragment == null || (fragment.equals(f0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.u;
            this.u = fragment;
            L(fragment2);
            L(this.u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final Set r() {
        HashSet hashSet = new HashSet();
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((t) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(C.o(viewGroup, y0()));
            }
        }
        return hashSet;
    }

    public v r0() {
        return this.c;
    }

    public final void r1(Fragment fragment) {
        ViewGroup p0 = p0(fragment);
        if (p0 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (p0.getTag(e0.b.c) == null) {
            p0.setTag(e0.b.c, fragment);
        }
        ((Fragment) p0.getTag(e0.b.c)).setPopDirection(fragment.getPopDirection());
    }

    public final Set s(ArrayList arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator it = ((androidx.fragment.app.a) arrayList.get(i2)).c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((w.a) it.next()).b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(C.n(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    public List s0() {
        return this.c.n();
    }

    public void s1(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public void t(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.C(z3);
        } else {
            aVar.B();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.q >= 1) {
            x.B(this.r.f(), this.s, arrayList, arrayList2, 0, 1, true, this.n);
        }
        if (z3) {
            Q0(this.q, true);
        }
        for (Fragment fragment : this.c.l()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.F(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public androidx.fragment.app.j t0() {
        return this.r;
    }

    public final void t1() {
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            V0((t) it.next());
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            obj = this.t;
        } else {
            androidx.fragment.app.j jVar = this.r;
            if (jVar == null) {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
            sb.append(jVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.r;
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    public final void u(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            f.d c2 = androidx.fragment.app.f.c(this.r.f(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c2 == null || (animator = c2.b) == null) {
                if (c2 != null) {
                    fragment.mView.startAnimation(c2.a);
                    c2.a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c2.b.addListener(new h(viewGroup, view, fragment));
                }
                c2.b.start();
            }
        }
        D0(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    public LayoutInflater.Factory2 u0() {
        return this.f;
    }

    public final void u1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new B("FragmentManager"));
        androidx.fragment.app.j jVar = this.r;
        try {
            if (jVar != null) {
                jVar.h("  ", null, printWriter, new String[0]);
            } else {
                W("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    public t v(Fragment fragment) {
        t m2 = this.c.m(fragment.mWho);
        if (m2 != null) {
            return m2;
        }
        t tVar = new t(this.o, this.c, fragment);
        tVar.o(this.r.f().getClassLoader());
        tVar.u(this.q);
        return tVar;
    }

    public androidx.fragment.app.l v0() {
        return this.o;
    }

    public void v1(l lVar) {
        this.o.p(lVar);
    }

    public final void w(Fragment fragment) {
        fragment.performDestroyView();
        this.o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.o(null);
        fragment.mInLayout = false;
    }

    public Fragment w0() {
        return this.t;
    }

    public final void w1() {
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                    this.h.f(l0() > 0 && I0(this.t));
                } else {
                    this.h.f(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void x(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (F0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            r1(fragment);
        }
    }

    public Fragment x0() {
        return this.u;
    }

    public void y() {
        this.E = false;
        this.F = false;
        this.M.k(false);
        S(4);
    }

    public D y0() {
        D d2 = this.x;
        if (d2 != null) {
            return d2;
        }
        Fragment fragment = this.t;
        return fragment != null ? fragment.mFragmentManager.y0() : this.y;
    }

    public void z() {
        this.E = false;
        this.F = false;
        this.M.k(false);
        S(0);
    }
}
