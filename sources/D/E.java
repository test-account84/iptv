package d;

import F.h;
import P.L;
import P.S;
import P.U;
import P.X;
import P.q;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.lifecycle.j;
import i.b;
import i.f;
import j$.util.Objects;
import java.util.List;
import java.util.Locale;
import k.d0;
import k.l0;
import k.m0;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends d.d implements e.a, LayoutInflater.Factory2 {
    public static final s.i o0 = new s.i();
    public static final boolean p0 = false;
    public static final int[] q0 = {16842836};
    public static final boolean r0 = !"robolectric".equals(Build.FINGERPRINT);
    public static final boolean s0 = true;
    public boolean A;
    public boolean B;
    public ViewGroup C;
    public TextView D;
    public View E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public t[] N;
    public t O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public Configuration T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public p Y;
    public p Z;
    public boolean e0;
    public int f0;
    public final Runnable g0;
    public boolean h0;
    public Rect i0;
    public Rect j0;
    public final Object k;
    public w k0;
    public final Context l;
    public A l0;
    public Window m;
    public OnBackInvokedDispatcher m0;
    public n n;
    public OnBackInvokedCallback n0;
    public final d.b o;
    public d.a p;
    public MenuInflater q;
    public CharSequence r;
    public k.G s;
    public g t;
    public u u;
    public i.b v;
    public ActionBarContextView w;
    public PopupWindow x;
    public Runnable y;
    public S z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e eVar = e.this;
            if ((eVar.f0 & 1) != 0) {
                eVar.g0(0);
            }
            e eVar2 = e.this;
            if ((eVar2.f0 & 4096) != 0) {
                eVar2.g0(108);
            }
            e eVar3 = e.this;
            eVar3.e0 = false;
            eVar3.f0 = 0;
        }
    }

    public class b implements P.E {
        public b() {
        }

        public X a(View view, X x) {
            int k = x.k();
            int d1 = e.this.d1(x, null);
            if (k != d1) {
                x = x.o(x.i(), d1, x.j(), x.h());
            }
            return L.e0(view, x);
        }
    }

    public class d implements Runnable {

        public class a extends U {
            public a() {
            }

            public void b(View view) {
                e.this.w.setAlpha(1.0f);
                e.this.z.j(null);
                e.this.z = null;
            }

            public void c(View view) {
                e.this.w.setVisibility(0);
            }
        }

        public d() {
        }

        public void run() {
            e eVar = e.this;
            eVar.x.showAtLocation(eVar.w, 55, 0, 0);
            e.this.h0();
            if (!e.this.S0()) {
                e.this.w.setAlpha(1.0f);
                e.this.w.setVisibility(0);
            } else {
                e.this.w.setAlpha(0.0f);
                e eVar2 = e.this;
                eVar2.z = L.e(eVar2.w).b(1.0f);
                e.this.z.j(new a());
            }
        }
    }

    public class e extends U {
        public e() {
        }

        public void b(View view) {
            e.this.w.setAlpha(1.0f);
            e.this.z.j(null);
            e.this.z = null;
        }

        public void c(View view) {
            e.this.w.setVisibility(0);
            if (e.this.w.getParent() instanceof View) {
                L.p0(e.this.w.getParent());
            }
        }
    }

    public interface f {
        boolean a(int i);

        View onCreatePanelView(int i);
    }

    public final class g implements i.a {
        public g() {
        }

        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
            e.this.X(eVar);
        }

        public boolean c(androidx.appcompat.view.menu.e eVar) {
            Window.Callback t0 = e.this.t0();
            if (t0 == null) {
                return true;
            }
            t0.onMenuOpened(108, eVar);
            return true;
        }
    }

    public class h implements b.a {
        public b.a a;

        public class a extends U {
            public a() {
            }

            public void b(View view) {
                e.this.w.setVisibility(8);
                e eVar = e.this;
                PopupWindow popupWindow = eVar.x;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (eVar.w.getParent() instanceof View) {
                    L.p0(e.this.w.getParent());
                }
                e.this.w.k();
                e.this.z.j(null);
                e eVar2 = e.this;
                eVar2.z = null;
                L.p0(eVar2.C);
            }
        }

        public h(b.a aVar) {
            this.a = aVar;
        }

        public boolean a(i.b bVar, MenuItem menuItem) {
            return this.a.a(bVar, menuItem);
        }

        public void b(i.b bVar) {
            this.a.b(bVar);
            e eVar = e.this;
            if (eVar.x != null) {
                eVar.m.getDecorView().removeCallbacks(e.this.y);
            }
            e eVar2 = e.this;
            if (eVar2.w != null) {
                eVar2.h0();
                e eVar3 = e.this;
                eVar3.z = L.e(eVar3.w).b(0.0f);
                e.this.z.j(new a());
            }
            e eVar4 = e.this;
            d.b bVar2 = eVar4.o;
            if (bVar2 != null) {
                bVar2.onSupportActionModeFinished(eVar4.v);
            }
            e eVar5 = e.this;
            eVar5.v = null;
            L.p0(eVar5.C);
            e.this.b1();
        }

        public boolean c(i.b bVar, Menu menu) {
            L.p0(e.this.C);
            return this.a.c(bVar, menu);
        }

        public boolean d(i.b bVar, Menu menu) {
            return this.a.d(bVar, menu);
        }
    }

    public static class i {
        public static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        public static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i = configuration.densityDpi;
            int i2 = configuration2.densityDpi;
            if (i != i2) {
                configuration3.densityDpi = i2;
            }
        }

        public static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        public static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    public static class j {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    public static class k {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList a = d.f.a(configuration);
            LocaleList a2 = d.f.a(configuration2);
            if (d.g.a(a, a2)) {
                return;
            }
            d.h.a(configuration3, a2);
            configuration3.locale = configuration2.locale;
        }

        public static L.i b(Configuration configuration) {
            return L.i.c(d.k.a(d.f.a(configuration)));
        }

        public static void c(L.i iVar) {
            d.j.a(d.i.a(iVar.h()));
        }

        public static void d(Configuration configuration, L.i iVar) {
            d.h.a(configuration, d.i.a(iVar.h()));
        }
    }

    public static class l {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((d.l.a(configuration) & 3) != (d.l.a(configuration2) & 3)) {
                d.m.a(configuration3, d.l.a(configuration3) | (d.l.a(configuration2) & 3));
            }
            if ((d.l.a(configuration) & 12) != (d.l.a(configuration2) & 12)) {
                d.m.a(configuration3, d.l.a(configuration3) | (d.l.a(configuration2) & 12));
            }
        }
    }

    public static class m {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return d.q.a(activity);
        }

        public static OnBackInvokedCallback b(Object obj, e eVar) {
            Objects.requireNonNull(eVar);
            d.s sVar = new d.s(eVar);
            d.r.a(d.o.a(obj), 1000000, sVar);
            return sVar;
        }

        public static void c(Object obj, Object obj2) {
            d.p.a(d.o.a(obj), d.n.a(obj2));
        }
    }

    public class n extends i.i {
        public f c;
        public boolean d;
        public boolean e;
        public boolean f;

        public n(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.e = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.e = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.d = true;
                callback.onContentChanged();
            } finally {
                this.d = false;
            }
        }

        public void d(Window.Callback callback, int i, Menu menu) {
            try {
                this.f = true;
                callback.onPanelClosed(i, menu);
            } finally {
                this.f = false;
            }
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.e ? a().dispatchKeyEvent(keyEvent) : e.this.f0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || e.this.E0(keyEvent.getKeyCode(), keyEvent);
        }

        public void e(f fVar) {
            this.c = fVar;
        }

        public final ActionMode f(ActionMode.Callback callback) {
            f.a aVar = new f.a(e.this.l, callback);
            i.b V0 = e.this.V0(aVar);
            if (V0 != null) {
                return aVar.e(V0);
            }
            return null;
        }

        public void onContentChanged() {
            if (this.d) {
                a().onContentChanged();
            }
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public View onCreatePanelView(int i) {
            View onCreatePanelView;
            f fVar = this.c;
            return (fVar == null || (onCreatePanelView = fVar.onCreatePanelView(i)) == null) ? super.onCreatePanelView(i) : onCreatePanelView;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            e.this.H0(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            if (this.f) {
                a().onPanelClosed(i, menu);
            } else {
                super.onPanelClosed(i, menu);
                e.this.I0(i);
            }
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.a0(true);
            }
            f fVar = this.c;
            boolean z = fVar != null && fVar.a(i);
            if (!z) {
                z = super.onPreparePanel(i, view, menu);
            }
            if (eVar != null) {
                eVar.a0(false);
            }
            return z;
        }

        public void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            androidx.appcompat.view.menu.e eVar;
            t r0 = e.this.r0(0, true);
            if (r0 == null || (eVar = r0.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return e.this.z0() ? f(callback) : super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (e.this.z0() && i == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    public class o extends p {
        public final PowerManager c;

        public o(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            return j.a(this.c) ? 2 : 1;
        }

        public void d() {
            e.this.R();
        }
    }

    public abstract class p {
        public BroadcastReceiver a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            public void onReceive(Context context, Intent intent) {
                p.this.d();
            }
        }

        public p() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    e.this.l.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b = b();
            if (b == null || b.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            e.this.l.registerReceiver(this.a, b);
        }
    }

    public class q extends p {
        public final G c;

        public q(G g) {
            super();
            this.c = g;
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            return this.c.d() ? 2 : 1;
        }

        public void d() {
            e.this.R();
        }
    }

    public static class r {
        public static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    public class s extends ContentFrameLayout {
        public s(Context context) {
            super(context);
        }

        public final boolean b(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return e.this.f0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            e.this.Z(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(e.a.b(getContext(), i));
        }
    }

    public static final class t {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public ViewGroup g;
        public View h;
        public View i;
        public androidx.appcompat.view.menu.e j;
        public androidx.appcompat.view.menu.c k;
        public Context l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q = false;
        public boolean r;
        public Bundle s;

        public t(int i) {
            this.a = i;
        }

        public androidx.appcompat.view.menu.j a(i.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.l, c.g.j);
                this.k = cVar;
                cVar.d(aVar);
                this.j.b(this.k);
            }
            return this.k.j(this.g);
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        public void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.O(this.k);
            }
            this.j = eVar;
            if (eVar == null || (cVar = this.k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(c.a.a, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(c.a.G, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 == 0) {
                i2 = c.i.c;
            }
            newTheme.applyStyle(i2, true);
            i.d dVar = new i.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(c.j.y0);
            this.b = obtainStyledAttributes.getResourceId(c.j.B0, 0);
            this.f = obtainStyledAttributes.getResourceId(c.j.A0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final class u implements i.a {
        public u() {
        }

        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
            androidx.appcompat.view.menu.e D = eVar.D();
            boolean z2 = D != eVar;
            e eVar2 = e.this;
            if (z2) {
                eVar = D;
            }
            t k0 = eVar2.k0(eVar);
            if (k0 != null) {
                if (!z2) {
                    e.this.a0(k0, z);
                } else {
                    e.this.W(k0.a, k0, D);
                    e.this.a0(k0, true);
                }
            }
        }

        public boolean c(androidx.appcompat.view.menu.e eVar) {
            Window.Callback t0;
            if (eVar != eVar.D()) {
                return true;
            }
            e eVar2 = e.this;
            if (!eVar2.H || (t0 = eVar2.t0()) == null || e.this.S) {
                return true;
            }
            t0.onMenuOpened(108, eVar);
            return true;
        }
    }

    public e(Activity activity, d.b bVar) {
        this(activity, null, bVar, activity);
    }

    public static Configuration l0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                k.a(configuration, configuration2, configuration3);
            } else if (!O.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                l.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            i.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    public void A() {
        d.a r2 = r();
        if (r2 != null) {
            r2.v(true);
        }
    }

    public int A0(Context context, int i2) {
        p p02;
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    p02 = o0(context);
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                p02 = p0(context);
            }
            return p02.c();
        }
        return i2;
    }

    public boolean B0() {
        boolean z = this.P;
        this.P = false;
        t r02 = r0(0, false);
        if (r02 != null && r02.o) {
            if (!z) {
                a0(r02, true);
            }
            return true;
        }
        i.b bVar = this.v;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        d.a r2 = r();
        return r2 != null && r2.h();
    }

    public void C() {
        Q(true, false);
    }

    public boolean C0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.P = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            D0(0, keyEvent);
            return true;
        }
        return false;
    }

    public void D() {
        d.a r2 = r();
        if (r2 != null) {
            r2.v(false);
        }
    }

    public final boolean D0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        t r02 = r0(i2, true);
        if (r02.o) {
            return false;
        }
        return N0(r02, keyEvent);
    }

    public boolean E0(int i2, KeyEvent keyEvent) {
        d.a r2 = r();
        if (r2 != null && r2.p(i2, keyEvent)) {
            return true;
        }
        t tVar = this.O;
        if (tVar != null && M0(tVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            t tVar2 = this.O;
            if (tVar2 != null) {
                tVar2.n = true;
            }
            return true;
        }
        if (this.O == null) {
            t r02 = r0(0, true);
            N0(r02, keyEvent);
            boolean M0 = M0(r02, keyEvent.getKeyCode(), keyEvent, 1);
            r02.m = false;
            if (M0) {
                return true;
            }
        }
        return false;
    }

    public boolean F0(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 82) {
                G0(0, keyEvent);
                return true;
            }
        } else if (B0()) {
            return true;
        }
        return false;
    }

    public boolean G(int i2) {
        int P0 = P0(i2);
        if (this.L && P0 == 108) {
            return false;
        }
        if (this.H && P0 == 1) {
            this.H = false;
        }
        if (P0 == 1) {
            X0();
            this.L = true;
            return true;
        }
        if (P0 == 2) {
            X0();
            this.F = true;
            return true;
        }
        if (P0 == 5) {
            X0();
            this.G = true;
            return true;
        }
        if (P0 == 10) {
            X0();
            this.J = true;
            return true;
        }
        if (P0 == 108) {
            X0();
            this.H = true;
            return true;
        }
        if (P0 != 109) {
            return this.m.requestFeature(P0);
        }
        X0();
        this.I = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean G0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            i.b r0 = r4.v
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            d.e$t r2 = r4.r0(r5, r0)
            if (r5 != 0) goto L43
            k.G r5 = r4.s
            if (r5 == 0) goto L43
            boolean r5 = r5.a()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.l
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            k.G r5 = r4.s
            boolean r5 = r5.e()
            if (r5 != 0) goto L3c
            boolean r5 = r4.S
            if (r5 != 0) goto L62
            boolean r5 = r4.N0(r2, r6)
            if (r5 == 0) goto L62
            k.G r5 = r4.s
            boolean r0 = r5.c()
            goto L68
        L3c:
            k.G r5 = r4.s
            boolean r0 = r5.b()
            goto L68
        L43:
            boolean r5 = r2.o
            if (r5 != 0) goto L64
            boolean r3 = r2.n
            if (r3 == 0) goto L4c
            goto L64
        L4c:
            boolean r5 = r2.m
            if (r5 == 0) goto L62
            boolean r5 = r2.r
            if (r5 == 0) goto L5b
            r2.m = r1
            boolean r5 = r4.N0(r2, r6)
            goto L5c
        L5b:
            r5 = 1
        L5c:
            if (r5 == 0) goto L62
            r4.K0(r2, r6)
            goto L68
        L62:
            r0 = 0
            goto L68
        L64:
            r4.a0(r2, r0)
            r0 = r5
        L68:
            if (r0 == 0) goto L85
            android.content.Context r5 = r4.l
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7e
            r5.playSoundEffect(r1)
            goto L85
        L7e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.G0(int, android.view.KeyEvent):boolean");
    }

    public void H(int i2) {
        i0();
        ViewGroup findViewById = this.C.findViewById(16908290);
        findViewById.removeAllViews();
        LayoutInflater.from(this.l).inflate(i2, findViewById);
        this.n.c(this.m.getCallback());
    }

    public void H0(int i2) {
        d.a r2;
        if (i2 != 108 || (r2 = r()) == null) {
            return;
        }
        r2.i(true);
    }

    public void I(View view) {
        i0();
        ViewGroup findViewById = this.C.findViewById(16908290);
        findViewById.removeAllViews();
        findViewById.addView(view);
        this.n.c(this.m.getCallback());
    }

    public void I0(int i2) {
        if (i2 == 108) {
            d.a r2 = r();
            if (r2 != null) {
                r2.i(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            t r02 = r0(i2, true);
            if (r02.o) {
                a0(r02, false);
            }
        }
    }

    public void J(View view, ViewGroup.LayoutParams layoutParams) {
        i0();
        ViewGroup findViewById = this.C.findViewById(16908290);
        findViewById.removeAllViews();
        findViewById.addView(view, layoutParams);
        this.n.c(this.m.getCallback());
    }

    public void K(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.K(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.m0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.n0) != null) {
            m.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.n0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.k;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                onBackInvokedDispatcher = m.a((Activity) this.k);
            }
        }
        this.m0 = onBackInvokedDispatcher;
        b1();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void K0(d.e.t r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.K0(d.e$t, android.view.KeyEvent):void");
    }

    public void L(Toolbar toolbar) {
        if (this.k instanceof Activity) {
            d.a r2 = r();
            if (r2 instanceof H) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.q = null;
            if (r2 != null) {
                r2.o();
            }
            this.p = null;
            if (toolbar != null) {
                E e2 = new E(toolbar, s0(), this.n);
                this.p = e2;
                this.n.e(e2.c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.n.e(null);
            }
            t();
        }
    }

    public final d.a L0() {
        return this.p;
    }

    public void M(int i2) {
        this.V = i2;
    }

    public final boolean M0(t tVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.e eVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((tVar.m || N0(tVar, keyEvent)) && (eVar = tVar.j) != null) {
            z = eVar.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.s == null) {
            a0(tVar, true);
        }
        return z;
    }

    public final void N(CharSequence charSequence) {
        this.r = charSequence;
        k.G g2 = this.s;
        if (g2 != null) {
            g2.setWindowTitle(charSequence);
            return;
        }
        if (L0() != null) {
            L0().y(charSequence);
            return;
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean N0(t tVar, KeyEvent keyEvent) {
        k.G g2;
        k.G g3;
        k.G g4;
        if (this.S) {
            return false;
        }
        if (tVar.m) {
            return true;
        }
        t tVar2 = this.O;
        if (tVar2 != null && tVar2 != tVar) {
            a0(tVar2, false);
        }
        Window.Callback t0 = t0();
        if (t0 != null) {
            tVar.i = t0.onCreatePanelView(tVar.a);
        }
        int i2 = tVar.a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (g4 = this.s) != null) {
            g4.f();
        }
        if (tVar.i == null && (!z || !(L0() instanceof E))) {
            androidx.appcompat.view.menu.e eVar = tVar.j;
            if (eVar == null || tVar.r) {
                if (eVar == null && (!x0(tVar) || tVar.j == null)) {
                    return false;
                }
                if (z && this.s != null) {
                    if (this.t == null) {
                        this.t = new g();
                    }
                    this.s.d(tVar.j, this.t);
                }
                tVar.j.d0();
                if (!t0.onCreatePanelMenu(tVar.a, tVar.j)) {
                    tVar.c(null);
                    if (z && (g2 = this.s) != null) {
                        g2.d(null, this.t);
                    }
                    return false;
                }
                tVar.r = false;
            }
            tVar.j.d0();
            Bundle bundle = tVar.s;
            if (bundle != null) {
                tVar.j.P(bundle);
                tVar.s = null;
            }
            if (!t0.onPreparePanel(0, tVar.i, tVar.j)) {
                if (z && (g3 = this.s) != null) {
                    g3.d(null, this.t);
                }
                tVar.j.c0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            tVar.p = z2;
            tVar.j.setQwertyMode(z2);
            tVar.j.c0();
        }
        tVar.m = true;
        tVar.n = false;
        this.O = tVar;
        return true;
    }

    public final void O0(boolean z) {
        k.G g2 = this.s;
        if (g2 == null || !g2.a() || (ViewConfiguration.get(this.l).hasPermanentMenuKey() && !this.s.g())) {
            t r02 = r0(0, true);
            r02.q = true;
            a0(r02, false);
            K0(r02, null);
            return;
        }
        Window.Callback t0 = t0();
        if (this.s.e() && z) {
            this.s.b();
            if (this.S) {
                return;
            }
            t0.onPanelClosed(108, r0(0, true).j);
            return;
        }
        if (t0 == null || this.S) {
            return;
        }
        if (this.e0 && (this.f0 & 1) != 0) {
            this.m.getDecorView().removeCallbacks(this.g0);
            this.g0.run();
        }
        t r03 = r0(0, true);
        androidx.appcompat.view.menu.e eVar = r03.j;
        if (eVar == null || r03.r || !t0.onPreparePanel(0, r03.i, eVar)) {
            return;
        }
        t0.onMenuOpened(108, r03.j);
        this.s.c();
    }

    public final boolean P(boolean z) {
        return Q(z, true);
    }

    public final int P0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    public final boolean Q(boolean z, boolean z2) {
        if (this.S) {
            return false;
        }
        int V = V();
        int A0 = A0(this.l, V);
        L.i U = Build.VERSION.SDK_INT < 33 ? U(this.l) : null;
        if (!z2 && U != null) {
            U = q0(this.l.getResources().getConfiguration());
        }
        boolean a1 = a1(A0, U, z);
        if (V == 0) {
            p0(this.l).e();
        } else {
            p pVar = this.Y;
            if (pVar != null) {
                pVar.a();
            }
        }
        if (V == 3) {
            o0(this.l).e();
        } else {
            p pVar2 = this.Z;
            if (pVar2 != null) {
                pVar2.a();
            }
        }
        return a1;
    }

    public void Q0(Configuration configuration, L.i iVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            k.d(configuration, iVar);
        } else {
            i.d(configuration, iVar.d(0));
            i.c(configuration, iVar.d(0));
        }
    }

    public boolean R() {
        return P(true);
    }

    public void R0(L.i iVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            k.c(iVar);
        } else {
            Locale.setDefault(iVar.d(0));
        }
    }

    public final void S() {
        ContentFrameLayout findViewById = this.C.findViewById(16908290);
        View decorView = this.m.getDecorView();
        findViewById.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.l.obtainStyledAttributes(c.j.y0);
        obtainStyledAttributes.getValue(c.j.K0, findViewById.getMinWidthMajor());
        obtainStyledAttributes.getValue(c.j.L0, findViewById.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(c.j.I0)) {
            obtainStyledAttributes.getValue(c.j.I0, findViewById.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(c.j.J0)) {
            obtainStyledAttributes.getValue(c.j.J0, findViewById.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(c.j.G0)) {
            obtainStyledAttributes.getValue(c.j.G0, findViewById.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(c.j.H0)) {
            obtainStyledAttributes.getValue(c.j.H0, findViewById.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        findViewById.requestLayout();
    }

    public final boolean S0() {
        ViewGroup viewGroup;
        return this.B && (viewGroup = this.C) != null && L.W(viewGroup);
    }

    public final void T(Window window) {
        if (this.m != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof n) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        n nVar = new n(callback);
        this.n = nVar;
        window.setCallback(nVar);
        d0 u2 = d0.u(this.l, null, q0);
        Drawable h2 = u2.h(0);
        if (h2 != null) {
            window.setBackgroundDrawable(h2);
        }
        u2.w();
        this.m = window;
        if (Build.VERSION.SDK_INT < 33 || this.m0 != null) {
            return;
        }
        K(null);
    }

    public final boolean T0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.m.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || L.V((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public L.i U(Context context) {
        L.i q2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 || (q2 = d.d.q()) == null) {
            return null;
        }
        L.i q02 = q0(context.getApplicationContext().getResources().getConfiguration());
        L.i b2 = i2 >= 24 ? B.b(q2, q02) : q2.f() ? L.i.e() : L.i.c(q2.d(0).toString());
        return b2.f() ? q02 : b2;
    }

    public boolean U0() {
        if (this.m0 == null) {
            return false;
        }
        t r02 = r0(0, false);
        return (r02 != null && r02.o) || this.v != null;
    }

    public final int V() {
        int i2 = this.U;
        return i2 != -100 ? i2 : d.d.m();
    }

    public i.b V0(b.a aVar) {
        d.b bVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        i.b bVar2 = this.v;
        if (bVar2 != null) {
            bVar2.c();
        }
        h hVar = new h(aVar);
        d.a r2 = r();
        if (r2 != null) {
            i.b z = r2.z(hVar);
            this.v = z;
            if (z != null && (bVar = this.o) != null) {
                bVar.onSupportActionModeStarted(z);
            }
        }
        if (this.v == null) {
            this.v = W0(hVar);
        }
        b1();
        return this.v;
    }

    public void W(int i2, t tVar, Menu menu) {
        if (menu == null) {
            if (tVar == null && i2 >= 0) {
                t[] tVarArr = this.N;
                if (i2 < tVarArr.length) {
                    tVar = tVarArr[i2];
                }
            }
            if (tVar != null) {
                menu = tVar.j;
            }
        }
        if ((tVar == null || tVar.o) && !this.S) {
            this.n.d(this.m.getCallback(), i2, menu);
        }
    }

    public i.b W0(b.a aVar) {
        i.b bVar;
        i.d dVar;
        d.b bVar2;
        h0();
        i.b bVar3 = this.v;
        if (bVar3 != null) {
            bVar3.c();
        }
        if (!(aVar instanceof h)) {
            aVar = new h(aVar);
        }
        d.b bVar4 = this.o;
        if (bVar4 == null || this.S) {
            bVar = null;
        } else {
            try {
                bVar = bVar4.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (bVar != null) {
            this.v = bVar;
        } else {
            if (this.w == null) {
                if (this.K) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.l.getTheme();
                    theme.resolveAttribute(c.a.d, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme newTheme = this.l.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new i.d(this.l, 0);
                        dVar.getTheme().setTo(newTheme);
                    } else {
                        dVar = this.l;
                    }
                    this.w = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, c.a.f);
                    this.x = popupWindow;
                    T.h.b(popupWindow, 2);
                    this.x.setContentView(this.w);
                    this.x.setWidth(-1);
                    dVar.getTheme().resolveAttribute(c.a.b, typedValue, true);
                    this.w.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.x.setHeight(-2);
                    this.y = new d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.C.findViewById(c.f.h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m0()));
                        this.w = viewStubCompat.a();
                    }
                }
            }
            if (this.w != null) {
                h0();
                this.w.k();
                i.e eVar = new i.e(this.w.getContext(), this.w, aVar, this.x == null);
                if (aVar.d(eVar, eVar.e())) {
                    eVar.k();
                    this.w.h(eVar);
                    this.v = eVar;
                    if (S0()) {
                        this.w.setAlpha(0.0f);
                        S b2 = L.e(this.w).b(1.0f);
                        this.z = b2;
                        b2.j(new e());
                    } else {
                        this.w.setAlpha(1.0f);
                        this.w.setVisibility(0);
                        if (this.w.getParent() instanceof View) {
                            L.p0(this.w.getParent());
                        }
                    }
                    if (this.x != null) {
                        this.m.getDecorView().post(this.y);
                    }
                } else {
                    this.v = null;
                }
            }
        }
        i.b bVar5 = this.v;
        if (bVar5 != null && (bVar2 = this.o) != null) {
            bVar2.onSupportActionModeStarted(bVar5);
        }
        b1();
        return this.v;
    }

    public void X(androidx.appcompat.view.menu.e eVar) {
        if (this.M) {
            return;
        }
        this.M = true;
        this.s.l();
        Window.Callback t0 = t0();
        if (t0 != null && !this.S) {
            t0.onPanelClosed(108, eVar);
        }
        this.M = false;
    }

    public final void X0() {
        if (this.B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void Y() {
        p pVar = this.Y;
        if (pVar != null) {
            pVar.a();
        }
        p pVar2 = this.Z;
        if (pVar2 != null) {
            pVar2.a();
        }
    }

    public final androidx.appcompat.app.b Y0() {
        for (Context context = this.l; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.b) {
                return (androidx.appcompat.app.b) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    public void Z(int i2) {
        a0(r0(i2, true), true);
    }

    public final void Z0(Configuration configuration) {
        androidx.lifecycle.p pVar = (Activity) this.k;
        if (pVar instanceof androidx.lifecycle.p) {
            if (!pVar.getLifecycle().b().isAtLeast(j.c.CREATED)) {
                return;
            }
        } else if (!this.R || this.S) {
            return;
        }
        pVar.onConfigurationChanged(configuration);
    }

    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        t k0;
        Window.Callback t0 = t0();
        if (t0 == null || this.S || (k0 = k0(eVar.D())) == null) {
            return false;
        }
        return t0.onMenuItemSelected(k0.a, menuItem);
    }

    public void a0(t tVar, boolean z) {
        ViewGroup viewGroup;
        k.G g2;
        if (z && tVar.a == 0 && (g2 = this.s) != null && g2.e()) {
            X(tVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.l.getSystemService("window");
        if (windowManager != null && tVar.o && (viewGroup = tVar.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                W(tVar.a, tVar, null);
            }
        }
        tVar.m = false;
        tVar.n = false;
        tVar.o = false;
        tVar.h = null;
        tVar.q = true;
        if (this.O == tVar) {
            this.O = null;
        }
        if (tVar.a == 0) {
            b1();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a1(int r9, L.i r10, boolean r11) {
        /*
            r8 = this;
            android.content.Context r1 = r8.l
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.b0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.l
            int r1 = r8.n0(r1)
            android.content.res.Configuration r2 = r8.T
            if (r2 != 0) goto L1f
            android.content.Context r2 = r8.l
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            L.i r2 = r8.q0(r2)
            r5 = 0
            if (r10 != 0) goto L30
            r0 = r5
            goto L34
        L30:
            L.i r0 = r8.q0(r0)
        L34:
            r6 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.175E-43)
            goto L3b
        L3a:
            r3 = 0
        L3b:
            if (r0 == 0) goto L45
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L45
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L6f
            if (r11 == 0) goto L6f
            boolean r11 = r8.Q
            if (r11 == 0) goto L6f
            boolean r11 = d.e.r0
            if (r11 != 0) goto L58
            boolean r11 = r8.R
            if (r11 == 0) goto L6f
        L58:
            java.lang.Object r11 = r8.k
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L6f
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L6f
            java.lang.Object r11 = r8.k
            android.app.Activity r11 = (android.app.Activity) r11
            D.b.g(r11)
            r11 = 1
            goto L70
        L6f:
            r11 = 0
        L70:
            if (r11 != 0) goto L7d
            if (r3 == 0) goto L7d
            r11 = r3 & r1
            if (r11 != r3) goto L79
            r6 = 1
        L79:
            r8.c1(r4, r0, r6, r5)
            goto L7e
        L7d:
            r7 = r11
        L7e:
            if (r7 == 0) goto L9a
            java.lang.Object r11 = r8.k
            boolean r1 = r11 instanceof androidx.appcompat.app.b
            if (r1 == 0) goto L9a
            r1 = r3 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L8f
            androidx.appcompat.app.b r11 = (androidx.appcompat.app.b) r11
            r11.m1(r9)
        L8f:
            r9 = r3 & 4
            if (r9 == 0) goto L9a
            java.lang.Object r9 = r8.k
            androidx.appcompat.app.b r9 = (androidx.appcompat.app.b) r9
            r9.l1(r10)
        L9a:
            if (r7 == 0) goto Laf
            if (r0 == 0) goto Laf
            android.content.Context r9 = r8.l
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            L.i r9 = r8.q0(r9)
            r8.R0(r9)
        Laf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.a1(int, L.i, boolean):boolean");
    }

    public void b(androidx.appcompat.view.menu.e eVar) {
        O0(true);
    }

    public final Configuration b0(Context context, int i2, L.i iVar, Configuration configuration, boolean z) {
        int i3 = i2 != 1 ? i2 != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (iVar != null) {
            Q0(configuration2, iVar);
        }
        return configuration2;
    }

    public void b1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean U0 = U0();
            if (U0 && this.n0 == null) {
                this.n0 = m.b(this.m0, this);
            } else {
                if (U0 || (onBackInvokedCallback = this.n0) == null) {
                    return;
                }
                m.c(this.m0, onBackInvokedCallback);
            }
        }
    }

    public final ViewGroup c0() {
        ViewGroup inflate;
        TypedArray obtainStyledAttributes = this.l.obtainStyledAttributes(c.j.y0);
        if (!obtainStyledAttributes.hasValue(c.j.D0)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(c.j.M0, false)) {
            G(1);
        } else if (obtainStyledAttributes.getBoolean(c.j.D0, false)) {
            G(108);
        }
        if (obtainStyledAttributes.getBoolean(c.j.E0, false)) {
            G(109);
        }
        if (obtainStyledAttributes.getBoolean(c.j.F0, false)) {
            G(10);
        }
        this.K = obtainStyledAttributes.getBoolean(c.j.z0, false);
        obtainStyledAttributes.recycle();
        j0();
        this.m.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.l);
        if (this.L) {
            inflate = from.inflate(this.J ? c.g.o : c.g.n, (ViewGroup) null);
        } else if (this.K) {
            inflate = (ViewGroup) from.inflate(c.g.f, (ViewGroup) null);
            this.I = false;
            this.H = false;
        } else if (this.H) {
            TypedValue typedValue = new TypedValue();
            this.l.getTheme().resolveAttribute(c.a.d, typedValue, true);
            inflate = LayoutInflater.from(typedValue.resourceId != 0 ? new i.d(this.l, typedValue.resourceId) : this.l).inflate(c.g.p, (ViewGroup) null);
            k.G findViewById = inflate.findViewById(c.f.p);
            this.s = findViewById;
            findViewById.setWindowCallback(t0());
            if (this.I) {
                this.s.h(109);
            }
            if (this.F) {
                this.s.h(2);
            }
            if (this.G) {
                this.s.h(5);
            }
        } else {
            inflate = null;
        }
        if (inflate == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.H + ", windowActionBarOverlay: " + this.I + ", android:windowIsFloating: " + this.K + ", windowActionModeOverlay: " + this.J + ", windowNoTitle: " + this.L + " }");
        }
        L.E0(inflate, new b());
        if (this.s == null) {
            this.D = inflate.findViewById(c.f.M);
        }
        m0.c(inflate);
        ContentFrameLayout findViewById2 = inflate.findViewById(c.f.b);
        FrameLayout frameLayout = (ViewGroup) this.m.findViewById(16908290);
        if (frameLayout != null) {
            while (frameLayout.getChildCount() > 0) {
                View childAt = frameLayout.getChildAt(0);
                frameLayout.removeViewAt(0);
                findViewById2.addView(childAt);
            }
            frameLayout.setId(-1);
            findViewById2.setId(16908290);
            if (frameLayout instanceof FrameLayout) {
                frameLayout.setForeground((Drawable) null);
            }
        }
        this.m.setContentView(inflate);
        findViewById2.setAttachListener(new c());
        return inflate;
    }

    public final void c1(int i2, L.i iVar, boolean z, Configuration configuration) {
        Resources resources = this.l.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        if (iVar != null) {
            Q0(configuration2, iVar);
        }
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            C.a(resources);
        }
        int i4 = this.V;
        if (i4 != 0) {
            this.l.setTheme(i4);
            if (i3 >= 23) {
                this.l.getTheme().applyStyle(this.V, true);
            }
        }
        if (z && (this.k instanceof Activity)) {
            Z0(configuration2);
        }
    }

    public View d0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        w wVar;
        if (this.k0 == null) {
            String string = this.l.obtainStyledAttributes(c.j.y0).getString(c.j.C0);
            if (string == null) {
                wVar = new w();
            } else {
                try {
                    this.k0 = (w) this.l.getClassLoader().loadClass(string).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    wVar = new w();
                }
            }
            this.k0 = wVar;
        }
        boolean z2 = p0;
        boolean z3 = false;
        if (z2) {
            if (this.l0 == null) {
                this.l0 = new A();
            }
            if (this.l0.a(attributeSet)) {
                z = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    z3 = T0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z3 = true;
                }
                z = z3;
            }
        } else {
            z = false;
        }
        return this.k0.r(view, str, context, attributeSet, z, z2, true, l0.c());
    }

    public final int d1(X x, Rect rect) {
        boolean z;
        boolean z2;
        int k2 = x != null ? x.k() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.w;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams layoutParams = this.w.getLayoutParams();
            if (this.w.isShown()) {
                if (this.i0 == null) {
                    this.i0 = new Rect();
                    this.j0 = new Rect();
                }
                Rect rect2 = this.i0;
                Rect rect3 = this.j0;
                if (x == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(x.i(), x.k(), x.j(), x.h());
                }
                m0.a(this.C, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                X K = L.K(this.C);
                int i5 = K == null ? 0 : K.i();
                int j2 = K == null ? 0 : K.j();
                if (layoutParams.topMargin == i2 && layoutParams.leftMargin == i3 && layoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    layoutParams.topMargin = i2;
                    layoutParams.leftMargin = i3;
                    layoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 <= 0 || this.E != null) {
                    View view = this.E;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams layoutParams2 = view.getLayoutParams();
                        int i6 = layoutParams2.height;
                        int i7 = layoutParams.topMargin;
                        if (i6 != i7 || layoutParams2.leftMargin != i5 || layoutParams2.rightMargin != j2) {
                            layoutParams2.height = i7;
                            layoutParams2.leftMargin = i5;
                            layoutParams2.rightMargin = j2;
                            this.E.setLayoutParams(layoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.l);
                    this.E = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, layoutParams.topMargin, 51);
                    layoutParams3.leftMargin = i5;
                    layoutParams3.rightMargin = j2;
                    this.C.addView(this.E, -1, layoutParams3);
                }
                View view3 = this.E;
                r5 = view3 != null;
                if (r5 && view3.getVisibility() != 0) {
                    e1(this.E);
                }
                if (!this.J && r5) {
                    k2 = 0;
                }
                z = r5;
                r5 = z2;
            } else if (layoutParams.topMargin != 0) {
                layoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                r5 = false;
            }
            if (r5) {
                this.w.setLayoutParams(layoutParams);
            }
        }
        View view4 = this.E;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return k2;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        i0();
        this.C.findViewById(16908290).addView(view, layoutParams);
        this.n.c(this.m.getCallback());
    }

    public void e0() {
        androidx.appcompat.view.menu.e eVar;
        k.G g2 = this.s;
        if (g2 != null) {
            g2.l();
        }
        if (this.x != null) {
            this.m.getDecorView().removeCallbacks(this.y);
            if (this.x.isShowing()) {
                try {
                    this.x.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.x = null;
        }
        h0();
        t r02 = r0(0, false);
        if (r02 == null || (eVar = r02.j) == null) {
            return;
        }
        eVar.close();
    }

    public final void e1(View view) {
        Context context;
        int i2;
        if ((L.O(view) & 8192) != 0) {
            context = this.l;
            i2 = c.c.b;
        } else {
            context = this.l;
            i2 = c.c.a;
        }
        view.setBackgroundColor(E.b.getColor(context, i2));
    }

    public boolean f0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.k;
        if (((obj instanceof q.a) || (obj instanceof d.u)) && (decorView = this.m.getDecorView()) != null && P.q.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.n.b(this.m.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? C0(keyCode, keyEvent) : F0(keyCode, keyEvent);
    }

    public Context g(Context context) {
        this.Q = true;
        int A0 = A0(context, V());
        if (d.d.u(context)) {
            d.d.O(context);
        }
        L.i U = U(context);
        if (s0 && (context instanceof ContextThemeWrapper)) {
            try {
                r.a((ContextThemeWrapper) context, b0(context, A0, U, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof i.d) {
            try {
                ((i.d) context).a(b0(context, A0, U, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!r0) {
            return super.g(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = i.a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration b0 = b0(context, A0, U, !configuration2.equals(configuration3) ? l0(configuration2, configuration3) : null, true);
        i.d dVar = new i.d(context, c.i.d);
        dVar.a(b0);
        try {
            if (context.getTheme() != null) {
                h.f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.g(dVar);
    }

    public void g0(int i2) {
        t r02;
        t r03 = r0(i2, true);
        if (r03.j != null) {
            Bundle bundle = new Bundle();
            r03.j.Q(bundle);
            if (bundle.size() > 0) {
                r03.s = bundle;
            }
            r03.j.d0();
            r03.j.clear();
        }
        r03.r = true;
        r03.q = true;
        if ((i2 != 108 && i2 != 0) || this.s == null || (r02 = r0(0, false)) == null) {
            return;
        }
        r02.m = false;
        N0(r02, null);
    }

    public void h0() {
        S s2 = this.z;
        if (s2 != null) {
            s2.c();
        }
    }

    public final void i0() {
        if (this.B) {
            return;
        }
        this.C = c0();
        CharSequence s02 = s0();
        if (!TextUtils.isEmpty(s02)) {
            k.G g2 = this.s;
            if (g2 != null) {
                g2.setWindowTitle(s02);
            } else if (L0() != null) {
                L0().y(s02);
            } else {
                TextView textView = this.D;
                if (textView != null) {
                    textView.setText(s02);
                }
            }
        }
        S();
        J0(this.C);
        this.B = true;
        t r02 = r0(0, false);
        if (this.S) {
            return;
        }
        if (r02 == null || r02.j == null) {
            y0(108);
        }
    }

    public View j(int i2) {
        i0();
        return this.m.findViewById(i2);
    }

    public final void j0() {
        if (this.m == null) {
            Object obj = this.k;
            if (obj instanceof Activity) {
                T(((Activity) obj).getWindow());
            }
        }
        if (this.m == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public t k0(Menu menu) {
        t[] tVarArr = this.N;
        int length = tVarArr != null ? tVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            t tVar = tVarArr[i2];
            if (tVar != null && tVar.j == menu) {
                return tVar;
            }
        }
        return null;
    }

    public Context l() {
        return this.l;
    }

    public final Context m0() {
        d.a r2 = r();
        Context k2 = r2 != null ? r2.k() : null;
        return k2 == null ? this.l : k2;
    }

    public int n() {
        return this.U;
    }

    public final int n0(Context context) {
        if (!this.X && (this.k instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i2 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.k.getClass()), i2 >= 29 ? 269221888 : i2 >= 24 ? 786432 : 0);
                if (activityInfo != null) {
                    this.W = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.W = 0;
            }
        }
        this.X = true;
        return this.W;
    }

    public final p o0(Context context) {
        if (this.Z == null) {
            this.Z = new o(context);
        }
        return this.Z;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return d0(view, str, context, attributeSet);
    }

    public MenuInflater p() {
        if (this.q == null) {
            u0();
            d.a aVar = this.p;
            this.q = new i.g(aVar != null ? aVar.k() : this.l);
        }
        return this.q;
    }

    public final p p0(Context context) {
        if (this.Y == null) {
            this.Y = new q(G.a(context));
        }
        return this.Y;
    }

    public L.i q0(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? k.b(configuration) : L.i.c(j.b(configuration.locale));
    }

    public d.a r() {
        u0();
        return this.p;
    }

    public t r0(int i2, boolean z) {
        t[] tVarArr = this.N;
        if (tVarArr == null || tVarArr.length <= i2) {
            t[] tVarArr2 = new t[i2 + 1];
            if (tVarArr != null) {
                System.arraycopy(tVarArr, 0, tVarArr2, 0, tVarArr.length);
            }
            this.N = tVarArr2;
            tVarArr = tVarArr2;
        }
        t tVar = tVarArr[i2];
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(i2);
        tVarArr[i2] = tVar2;
        return tVar2;
    }

    public void s() {
        LayoutInflater from = LayoutInflater.from(this.l);
        if (from.getFactory() == null) {
            P.r.a(from, this);
        } else {
            if (from.getFactory2() instanceof e) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final CharSequence s0() {
        Object obj = this.k;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.r;
    }

    public void t() {
        if (L0() == null || r().m()) {
            return;
        }
        y0(0);
    }

    public final Window.Callback t0() {
        return this.m.getCallback();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u0() {
        /*
            r3 = this;
            r3.i0()
            boolean r0 = r3.H
            if (r0 == 0) goto L37
            d.a r0 = r3.p
            if (r0 == 0) goto Lc
            goto L37
        Lc:
            java.lang.Object r0 = r3.k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L20
            d.H r0 = new d.H
            java.lang.Object r1 = r3.k
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.I
            r0.<init>(r1, r2)
        L1d:
            r3.p = r0
            goto L2e
        L20:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L2e
            d.H r0 = new d.H
            java.lang.Object r1 = r3.k
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L2e:
            d.a r0 = r3.p
            if (r0 == 0) goto L37
            boolean r1 = r3.h0
            r0.s(r1)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.u0():void");
    }

    public final boolean v0(t tVar) {
        View view = tVar.i;
        if (view != null) {
            tVar.h = view;
            return true;
        }
        if (tVar.j == null) {
            return false;
        }
        if (this.u == null) {
            this.u = new u();
        }
        View a2 = tVar.a(this.u);
        tVar.h = a2;
        return a2 != null;
    }

    public void w(Configuration configuration) {
        d.a r2;
        if (this.H && this.B && (r2 = r()) != null) {
            r2.n(configuration);
        }
        k.i.b().g(this.l);
        this.T = new Configuration(this.l.getResources().getConfiguration());
        Q(false, false);
    }

    public final boolean w0(t tVar) {
        tVar.d(m0());
        tVar.g = new s(tVar.l);
        tVar.c = 81;
        return true;
    }

    public void x(Bundle bundle) {
        String str;
        this.Q = true;
        P(false);
        j0();
        Object obj = this.k;
        if (obj instanceof Activity) {
            try {
                str = D.j.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                d.a L0 = L0();
                if (L0 == null) {
                    this.h0 = true;
                } else {
                    L0.s(true);
                }
            }
            d.d.d(this);
        }
        this.T = new Configuration(this.l.getResources().getConfiguration());
        this.R = true;
    }

    public final boolean x0(t tVar) {
        Resources.Theme theme;
        Context context = this.l;
        int i2 = tVar.a;
        if ((i2 == 0 || i2 == 108) && this.s != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(c.a.d, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(c.a.e, typedValue, true);
            } else {
                theme2.resolveAttribute(c.a.e, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                Context dVar = new i.d(context, 0);
                dVar.getTheme().setTo(theme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.R(this);
        tVar.c(eVar);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.k
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            d.d.E(r3)
        L9:
            boolean r0 = r3.e0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.m
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.g0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.S = r0
            int r0 = r3.U
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            s.i r0 = d.e.o0
            java.lang.Object r1 = r3.k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.U
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            s.i r0 = d.e.o0
            java.lang.Object r1 = r3.k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            d.a r0 = r3.p
            if (r0 == 0) goto L5b
            r0.o()
        L5b:
            r3.Y()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.y():void");
    }

    public final void y0(int i2) {
        this.f0 = (1 << i2) | this.f0;
        if (this.e0) {
            return;
        }
        L.k0(this.m.getDecorView(), this.g0);
        this.e0 = true;
    }

    public void z(Bundle bundle) {
        i0();
    }

    public boolean z0() {
        return this.A;
    }

    public e(Dialog dialog, d.b bVar) {
        this(dialog.getContext(), dialog.getWindow(), bVar, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public e(Context context, Window window, d.b bVar, Object obj) {
        androidx.appcompat.app.b Y0;
        this.z = null;
        this.A = true;
        this.U = -100;
        this.g0 = new a();
        this.l = context;
        this.o = bVar;
        this.k = obj;
        if (this.U == -100 && (obj instanceof Dialog) && (Y0 = Y0()) != null) {
            this.U = Y0.h1().n();
        }
        if (this.U == -100) {
            s.i iVar = o0;
            Integer num = (Integer) iVar.get(obj.getClass().getName());
            if (num != null) {
                this.U = num.intValue();
                iVar.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            T(window);
        }
        k.i.h();
    }

    public void B(Bundle bundle) {
    }

    public void J0(ViewGroup viewGroup) {
    }

    public class c implements ContentFrameLayout.a {
        public c() {
        }

        public void onDetachedFromWindow() {
            e.this.e0();
        }

        public void a() {
        }
    }
}
