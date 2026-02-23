package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.w;
import androidx.lifecycle.j;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a extends w implements m.n {
    public final m t;
    public boolean u;
    public int v;

    public a(m mVar) {
        super(mVar.q0(), mVar.t0() != null ? mVar.t0().f().getClassLoader() : null);
        this.v = -1;
        this.t = mVar;
    }

    public static boolean H(w.a aVar) {
        Fragment fragment = aVar.b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    public void A(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (this.h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.h));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f != 0 || this.g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.m);
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (this.c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            w.a aVar = (w.a) this.c.get(i);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.b);
            if (z) {
                if (aVar.c != 0 || aVar.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.d));
                }
                if (aVar.e != 0 || aVar.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f));
                }
            }
        }
    }

    public void B() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            w.a aVar = (w.a) this.c.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.h);
                fragment.setSharedElementNames(this.p, this.q);
            }
            switch (aVar.a) {
                case 1:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.o1(fragment, false);
                    this.t.g(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.f1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.C0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.o1(fragment, false);
                    this.t.s1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.x(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.o1(fragment, false);
                    this.t.l(fragment);
                    break;
                case 8:
                    this.t.q1(fragment);
                    break;
                case 9:
                    this.t.q1(null);
                    break;
                case 10:
                    this.t.p1(fragment, aVar.h);
                    break;
            }
            if (!this.r && aVar.a != 1 && fragment != null && !m.P) {
                this.t.P0(fragment);
            }
        }
        if (this.r || m.P) {
            return;
        }
        m mVar = this.t;
        mVar.Q0(mVar.q, true);
    }

    public void C(boolean z) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            w.a aVar = (w.a) this.c.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(m.k1(this.h));
                fragment.setSharedElementNames(this.q, this.p);
            }
            switch (aVar.a) {
                case 1:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.o1(fragment, true);
                    this.t.f1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.g(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.s1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.o1(fragment, true);
                    this.t.C0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.l(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.c, aVar.d, aVar.e, aVar.f);
                    this.t.o1(fragment, true);
                    this.t.x(fragment);
                    break;
                case 8:
                    this.t.q1(null);
                    break;
                case 9:
                    this.t.q1(fragment);
                    break;
                case 10:
                    this.t.p1(fragment, aVar.g);
                    break;
            }
            if (!this.r && aVar.a != 3 && fragment != null && !m.P) {
                this.t.P0(fragment);
            }
        }
        if (this.r || !z || m.P) {
            return;
        }
        m mVar = this.t;
        mVar.Q0(mVar.q, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.fragment.app.Fragment D(java.util.ArrayList r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList r5 = r0.c
            int r5 = r5.size()
            if (r4 >= r5) goto Lba
            java.util.ArrayList r5 = r0.c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.w$a r5 = (androidx.fragment.app.w.a) r5
            int r6 = r5.a
            r7 = 1
            if (r6 == r7) goto Lb2
            r8 = 2
            r9 = 0
            r10 = 3
            r11 = 9
            if (r6 == r8) goto L58
            if (r6 == r10) goto L41
            r8 = 6
            if (r6 == r8) goto L41
            r8 = 7
            if (r6 == r8) goto Lb2
            r8 = 8
            if (r6 == r8) goto L31
            goto Lb7
        L31:
            java.util.ArrayList r6 = r0.c
            androidx.fragment.app.w$a r8 = new androidx.fragment.app.w$a
            r8.<init>(r11, r3)
            r6.add(r4, r8)
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.b
            goto Lb7
        L41:
            androidx.fragment.app.Fragment r6 = r5.b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.b
            if (r5 != r3) goto Lb7
            java.util.ArrayList r3 = r0.c
            androidx.fragment.app.w$a r6 = new androidx.fragment.app.w$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lb7
        L58:
            androidx.fragment.app.Fragment r6 = r5.b
            int r8 = r6.mContainerId
            int r12 = r17.size()
            int r12 = r12 - r7
            r13 = 0
        L62:
            if (r12 < 0) goto La2
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.mContainerId
            if (r15 != r8) goto L9f
            if (r14 != r6) goto L72
            r13 = 1
            goto L9f
        L72:
            if (r14 != r3) goto L81
            java.util.ArrayList r3 = r0.c
            androidx.fragment.app.w$a r15 = new androidx.fragment.app.w$a
            r15.<init>(r11, r14)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L81:
            androidx.fragment.app.w$a r15 = new androidx.fragment.app.w$a
            r15.<init>(r10, r14)
            int r2 = r5.c
            r15.c = r2
            int r2 = r5.e
            r15.e = r2
            int r2 = r5.d
            r15.d = r2
            int r2 = r5.f
            r15.f = r2
            java.util.ArrayList r2 = r0.c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        L9f:
            int r12 = r12 + (-1)
            goto L62
        La2:
            if (r13 == 0) goto Lac
            java.util.ArrayList r2 = r0.c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lb7
        Lac:
            r5.a = r7
            r1.add(r6)
            goto Lb7
        Lb2:
            androidx.fragment.app.Fragment r2 = r5.b
            r1.add(r2)
        Lb7:
            int r4 = r4 + r7
            goto L7
        Lba:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.D(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    public String E() {
        return this.k;
    }

    public boolean F(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = ((w.a) this.c.get(i2)).b;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean G(ArrayList arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.c.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = ((w.a) this.c.get(i4)).b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = (a) arrayList.get(i6);
                    int size2 = aVar.c.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = ((w.a) aVar.c.get(i7)).b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public boolean I() {
        for (int i = 0; i < this.c.size(); i++) {
            if (H((w.a) this.c.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void J() {
        if (this.s != null) {
            for (int i = 0; i < this.s.size(); i++) {
                ((Runnable) this.s.get(i)).run();
            }
            this.s = null;
        }
    }

    public void K(Fragment.l lVar) {
        for (int i = 0; i < this.c.size(); i++) {
            w.a aVar = (w.a) this.c.get(i);
            if (H(aVar)) {
                aVar.b.setOnStartEnterTransitionListener(lVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.fragment.app.Fragment L(java.util.ArrayList r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList r2 = r5.c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.w$a r2 = (androidx.fragment.app.w.a) r2
            int r3 = r2.a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.j$c r3 = r2.g
            r2.h = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.L(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (m.F0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.i) {
            return true;
        }
        this.t.e(this);
        return true;
    }

    public int i() {
        return y(false);
    }

    public int j() {
        return y(true);
    }

    public void k() {
        n();
        this.t.b0(this, false);
    }

    public void l() {
        n();
        this.t.b0(this, true);
    }

    public w m(Fragment fragment) {
        m mVar = fragment.mFragmentManager;
        if (mVar == null || mVar == this.t) {
            return super.m(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void o(int i, Fragment fragment, String str, int i2) {
        super.o(i, fragment, str, i2);
        fragment.mFragmentManager = this.t;
    }

    public w p(Fragment fragment) {
        m mVar = fragment.mFragmentManager;
        if (mVar == null || mVar == this.t) {
            return super.p(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    public w u(Fragment fragment, j.c cVar) {
        if (fragment.mFragmentManager != this.t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.t);
        }
        if (cVar == j.c.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + " after the Fragment has been created");
        }
        if (cVar != j.c.DESTROYED) {
            return super.u(fragment, cVar);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    public w v(Fragment fragment) {
        m mVar;
        if (fragment == null || (mVar = fragment.mFragmentManager) == null || mVar == this.t) {
            return super.v(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void x(int i) {
        if (this.i) {
            if (m.F0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                w.a aVar = (w.a) this.c.get(i2);
                Fragment fragment = aVar.b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (m.F0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public int y(boolean z) {
        if (this.u) {
            throw new IllegalStateException("commit already called");
        }
        if (m.F0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new B("FragmentManager"));
            z("  ", printWriter);
            printWriter.close();
        }
        this.u = true;
        this.v = this.i ? this.t.j() : -1;
        this.t.Y(this, z);
        return this.v;
    }

    public void z(String str, PrintWriter printWriter) {
        A(str, printWriter, true);
    }
}
