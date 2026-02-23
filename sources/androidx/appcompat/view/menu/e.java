package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e implements I.a {
    public static final int[] A = {1, 4, 5, 3, 2, 0};
    public final Context a;
    public final Resources b;
    public boolean c;
    public boolean d;
    public a e;
    public ContextMenu.ContextMenuInfo m;
    public CharSequence n;
    public Drawable o;
    public View p;
    public g x;
    public boolean z;
    public int l = 0;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public ArrayList v = new ArrayList();
    public CopyOnWriteArrayList w = new CopyOnWriteArrayList();
    public boolean y = false;
    public ArrayList f = new ArrayList();
    public ArrayList g = new ArrayList();
    public boolean h = true;
    public ArrayList i = new ArrayList();
    public ArrayList j = new ArrayList();
    public boolean k = true;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean d(g gVar);
    }

    public e(Context context) {
        this.a = context;
        this.b = context.getResources();
        b0(true);
    }

    public static int B(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = A;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public static int n(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((g) arrayList.get(size)).f() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean A() {
        return this.t;
    }

    public Resources C() {
        return this.b;
    }

    public e D() {
        return this;
    }

    public ArrayList E() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.f.get(i);
            if (gVar.isVisible()) {
                this.g.add(gVar);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public boolean F() {
        return this.y;
    }

    public boolean G() {
        return this.c;
    }

    public boolean H() {
        return this.d;
    }

    public void I(g gVar) {
        this.k = true;
        K(true);
    }

    public void J(g gVar) {
        this.h = true;
        K(true);
    }

    public void K(boolean z) {
        if (this.q) {
            this.r = true;
            if (z) {
                this.s = true;
                return;
            }
            return;
        }
        if (z) {
            this.h = true;
            this.k = true;
        }
        i(z);
    }

    public boolean L(MenuItem menuItem, int i) {
        return M(menuItem, null, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r1
      0x002d: PHI (r1v4 boolean) = (r1v2 boolean), (r1v1 boolean), (r1v5 boolean) binds: [B:32:0x0068, B:21:0x003c, B:13:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean M(android.view.MenuItem r7, androidx.appcompat.view.menu.i r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.g r7 = (androidx.appcompat.view.menu.g) r7
            r0 = 0
            if (r7 == 0) goto L6c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Lc
            goto L6c
        Lc:
            boolean r1 = r7.k()
            P.b r2 = r7.b()
            r3 = 1
            if (r2 == 0) goto L1f
            boolean r4 = r2.b()
            if (r4 == 0) goto L1f
            r4 = 1
            goto L20
        L1f:
            r4 = 0
        L20:
            boolean r5 = r7.j()
            if (r5 == 0) goto L31
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L6b
        L2d:
            r6.e(r3)
            goto L6b
        L31:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L3f
            if (r4 == 0) goto L3a
            goto L3f
        L3a:
            r7 = r9 & 1
            if (r7 != 0) goto L6b
            goto L2d
        L3f:
            r9 = r9 & 4
            if (r9 != 0) goto L46
            r6.e(r0)
        L46:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L58
            androidx.appcompat.view.menu.l r9 = new androidx.appcompat.view.menu.l
            android.content.Context r0 = r6.u()
            r9.<init>(r0, r6, r7)
            r7.x(r9)
        L58:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.l r7 = (androidx.appcompat.view.menu.l) r7
            if (r4 == 0) goto L63
            r2.g(r7)
        L63:
            boolean r7 = r6.j(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L6b
            goto L2d
        L6b:
            return r1
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.M(android.view.MenuItem, androidx.appcompat.view.menu.i, int):boolean");
    }

    public final void N(int i, boolean z) {
        if (i < 0 || i >= this.f.size()) {
            return;
        }
        this.f.remove(i);
        if (z) {
            K(true);
        }
    }

    public void O(i iVar) {
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar2 = (i) weakReference.get();
            if (iVar2 == null || iVar2 == iVar) {
                this.w.remove(weakReference);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((l) item.getSubMenu()).P(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (findItem = findItem(i2)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((l) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.e = aVar;
    }

    public e S(int i) {
        this.l = i;
        return this;
    }

    public void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f.size();
        d0();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.f.get(i);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        c0();
    }

    public e U(int i) {
        W(0, null, i, null, null);
        return this;
    }

    public e V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    public final void W(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources C = C();
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i > 0) {
                this.n = C.getText(i);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i2 > 0) {
                this.o = E.b.getDrawable(u(), i2);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        K(false);
    }

    public e X(int i) {
        W(i, null, 0, null, null);
        return this;
    }

    public e Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    public e Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    public MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int B = B(i3);
        g g = g(i, i2, i3, B, charSequence, this.l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.m;
        if (contextMenuInfo != null) {
            g.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f;
        arrayList.add(n(arrayList, B), g);
        K(true);
        return g;
    }

    public void a0(boolean z) {
        this.z = z;
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.b.getString(i));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.a.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, (CharSequence) this.b.getString(i));
    }

    public void b(i iVar) {
        c(iVar, this.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.a
            boolean r3 = P.N.e(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.b0(boolean):void");
    }

    public void c(i iVar, Context context) {
        this.w.add(new WeakReference(iVar));
        iVar.i(context, this);
        this.k = true;
    }

    public void c0() {
        this.q = false;
        if (this.r) {
            this.r = false;
            K(this.s);
        }
    }

    public void clear() {
        g gVar = this.x;
        if (gVar != null) {
            f(gVar);
        }
        this.f.clear();
        K(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        K(false);
    }

    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.r = false;
        this.s = false;
    }

    public final void e(boolean z) {
        if (this.u) {
            return;
        }
        this.u = true;
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar = (i) weakReference.get();
            if (iVar == null) {
                this.w.remove(weakReference);
            } else {
                iVar.b(this, z);
            }
        }
        this.u = false;
    }

    public boolean f(g gVar) {
        boolean z = false;
        if (!this.w.isEmpty() && this.x == gVar) {
            d0();
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                i iVar = (i) weakReference.get();
                if (iVar == null) {
                    this.w.remove(weakReference);
                } else {
                    z = iVar.h(this, gVar);
                    if (z) {
                        break;
                    }
                }
            }
            c0();
            if (z) {
                this.x = null;
            }
        }
        return z;
    }

    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getItemId() == i) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (findItem = gVar.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final g g(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new g(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f.get(i);
    }

    public boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((g) this.f.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i(boolean z) {
        if (this.w.isEmpty()) {
            return;
        }
        d0();
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar = (i) weakReference.get();
            if (iVar == null) {
                this.w.remove(weakReference);
            } else {
                iVar.f(z);
            }
        }
        c0();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return p(i, keyEvent) != null;
    }

    public final boolean j(l lVar, i iVar) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean e = iVar != null ? iVar.e(lVar) : false;
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar2 = (i) weakReference.get();
            if (iVar2 == null) {
                this.w.remove(weakReference);
            } else if (!e) {
                e = iVar2.e(lVar);
            }
        }
        return e;
    }

    public boolean k(g gVar) {
        boolean z = false;
        if (this.w.isEmpty()) {
            return false;
        }
        d0();
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar = (i) weakReference.get();
            if (iVar == null) {
                this.w.remove(weakReference);
            } else {
                z = iVar.c(this, gVar);
                if (z) {
                    break;
                }
            }
        }
        c0();
        if (z) {
            this.x = gVar;
        }
        return z;
    }

    public int l(int i) {
        return m(i, 0);
    }

    public int m(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (((g) this.f.get(i2)).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int o(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((g) this.f.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public g p(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.v;
        arrayList.clear();
        q(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (g) arrayList.get(0);
        }
        boolean G = G();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) arrayList.get(i2);
            char alphabeticShortcut = G ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (G && alphabeticShortcut == '\b' && i == 67))) {
                return gVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return L(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        g p = p(i, keyEvent);
        boolean L = p != null ? L(p, i2) : false;
        if ((i2 & 2) != 0) {
            e(true);
        }
        return L;
    }

    public void q(List list, int i, KeyEvent keyEvent) {
        boolean G = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) this.f.get(i2);
                if (gVar.hasSubMenu()) {
                    gVar.getSubMenu().q(list, i, keyEvent);
                }
                char alphabeticShortcut = G ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if ((modifiers & 69647) == ((G ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (G && alphabeticShortcut == '\b' && i == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList E = E();
        if (this.k) {
            Iterator it = this.w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                i iVar = (i) weakReference.get();
                if (iVar == null) {
                    this.w.remove(weakReference);
                } else {
                    z |= iVar.g();
                }
            }
            if (z) {
                this.i.clear();
                this.j.clear();
                int size = E.size();
                for (int i = 0; i < size; i++) {
                    g gVar = (g) E.get(i);
                    (gVar.l() ? this.i : this.j).add(gVar);
                }
            } else {
                this.i.clear();
                this.j.clear();
                this.j.addAll(E());
            }
            this.k = false;
        }
    }

    public void removeGroup(int i) {
        int l = l(i);
        if (l >= 0) {
            int size = this.f.size() - l;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((g) this.f.get(l)).getGroupId() != i) {
                    break;
                }
                N(l, false);
                i2 = i3;
            }
            K(true);
        }
    }

    public void removeItem(int i) {
        N(o(i), true);
    }

    public ArrayList s() {
        r();
        return this.i;
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getGroupId() == i) {
                gVar.t(z2);
                gVar.setCheckable(z);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getGroupId() == i) {
                gVar.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getGroupId() == i && gVar.y(z)) {
                z2 = true;
            }
        }
        if (z2) {
            K(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.c = z;
        K(false);
    }

    public int size() {
        return this.f.size();
    }

    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.a;
    }

    public g v() {
        return this.x;
    }

    public Drawable w() {
        return this.o;
    }

    public CharSequence x() {
        return this.n;
    }

    public View y() {
        return this.p;
    }

    public ArrayList z() {
        r();
        return this.j;
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.b.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, (CharSequence) this.b.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        g gVar = (g) a(i, i2, i3, charSequence);
        l lVar = new l(this.a, this, gVar);
        gVar.x(lVar);
        return lVar;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }
}
