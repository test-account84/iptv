package androidx.mediarouter.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.fragment.app.m;
import androidx.fragment.app.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t0.j;
import t0.l;
import u0.K;
import u0.L;
import u0.g0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MediaRouteButton extends View {
    public static a s;
    public static final SparseArray t = new SparseArray(2);
    public static final int[] u = {16842912};
    public static final int[] v = {16842911};
    public final L a;
    public final b c;
    public K d;
    public e e;
    public boolean f;
    public int g;
    public boolean h;
    public c i;
    public Drawable j;
    public int k;
    public int l;
    public int m;
    public ColorStateList n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;

    public static final class a extends BroadcastReceiver {
        public final Context a;
        public boolean b = true;
        public List c = new ArrayList();

        public a(Context context) {
            this.a = context;
        }

        public boolean a() {
            return this.b;
        }

        public void b(MediaRouteButton mediaRouteButton) {
            if (this.c.size() == 0) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.a.registerReceiver(this, intentFilter);
            }
            this.c.add(mediaRouteButton);
        }

        public void c(MediaRouteButton mediaRouteButton) {
            this.c.remove(mediaRouteButton);
            if (this.c.size() == 0) {
                this.a.unregisterReceiver(this);
            }
        }

        public void onReceive(Context context, Intent intent) {
            boolean z;
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || this.b == (!intent.getBooleanExtra("noConnectivity", false))) {
                return;
            }
            this.b = z;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((MediaRouteButton) it.next()).c();
            }
        }
    }

    public final class b extends L.a {
        public b() {
        }

        public void onProviderAdded(L l, L.g gVar) {
            MediaRouteButton.this.b();
        }

        public void onProviderChanged(L l, L.g gVar) {
            MediaRouteButton.this.b();
        }

        public void onProviderRemoved(L l, L.g gVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteAdded(L l, L.h hVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteChanged(L l, L.h hVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteRemoved(L l, L.h hVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteSelected(L l, L.h hVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteUnselected(L l, L.h hVar) {
            MediaRouteButton.this.b();
        }

        public void onRouterParamsChanged(L l, g0 g0Var) {
            boolean z = g0Var != null ? g0Var.b().getBoolean("androidx.mediarouter.media.MediaRouterParams.FIXED_CAST_ICON") : false;
            MediaRouteButton mediaRouteButton = MediaRouteButton.this;
            if (mediaRouteButton.h != z) {
                mediaRouteButton.h = z;
                mediaRouteButton.refreshDrawableState();
            }
        }
    }

    public final class c extends AsyncTask {
        public final int a;
        public final Context b;

        public c(int i, Context context) {
            this.a = i;
            this.b = context;
        }

        public final void a(Drawable drawable) {
            if (drawable != null) {
                MediaRouteButton.t.put(this.a, drawable.getConstantState());
            }
            MediaRouteButton.this.i = null;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(Void... voidArr) {
            if (((Drawable.ConstantState) MediaRouteButton.t.get(this.a)) == null) {
                return e.a.b(this.b, this.a);
            }
            return null;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Drawable drawable) {
            a(drawable);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) {
            if (drawable != null) {
                a(drawable);
            } else {
                Drawable.ConstantState constantState = (Drawable.ConstantState) MediaRouteButton.t.get(this.a);
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                MediaRouteButton.this.i = null;
            }
            MediaRouteButton.this.setRemoteIndicatorDrawableInternal(drawable);
        }
    }

    public MediaRouteButton(Context context) {
        this(context, null);
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private m getFragmentManager() {
        Activity activity = getActivity();
        if (activity instanceof androidx.fragment.app.e) {
            return ((androidx.fragment.app.e) activity).getSupportFragmentManager();
        }
        return null;
    }

    public final void a() {
        if (this.k > 0) {
            c cVar = this.i;
            if (cVar != null) {
                cVar.cancel(false);
            }
            c cVar2 = new c(this.k, getContext());
            this.i = cVar2;
            this.k = 0;
            cVar2.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public void b() {
        L.h n = this.a.n();
        boolean z = true;
        boolean z2 = !n.w();
        int c2 = z2 ? n.c() : 0;
        if (this.m != c2) {
            this.m = c2;
            i();
            refreshDrawableState();
        }
        if (c2 == 1) {
            a();
        }
        if (this.f) {
            if (!this.q && !z2 && !this.a.q(this.d, 1)) {
                z = false;
            }
            setEnabled(z);
        }
    }

    public void c() {
        super.setVisibility((this.g != 0 || this.q || s.a()) ? this.g : 4);
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    public boolean d() {
        if (!this.f) {
            return false;
        }
        g0 l = this.a.l();
        if (l == null) {
            return e(1);
        }
        if (l.d() && L.p() && f()) {
            return true;
        }
        return e(l.a());
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.j != null) {
            this.j.setState(getDrawableState());
            if (this.j.getCurrent() instanceof AnimationDrawable) {
                AnimationDrawable current = this.j.getCurrent();
                int i = this.m;
                if (i == 1 || this.l != i) {
                    if (!current.isRunning()) {
                        current.start();
                    }
                } else if (i == 2 && !current.isRunning()) {
                    current.selectDrawable(current.getNumberOfFrames() - 1);
                }
            }
            invalidate();
        }
        this.l = this.m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean e(int i) {
        String str;
        String str2;
        d dVar;
        m fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
        }
        if (this.a.n().w()) {
            str = "android.support.v7.mediarouter:MediaRouteChooserDialogFragment";
            if (fragmentManager.h0("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                str2 = "showDialog(): Route chooser dialog already showing!";
                Log.w("MediaRouteButton", str2);
                return false;
            }
            androidx.mediarouter.app.b onCreateChooserDialogFragment = this.e.onCreateChooserDialogFragment();
            onCreateChooserDialogFragment.setRouteSelector(this.d);
            dVar = onCreateChooserDialogFragment;
            if (i == 2) {
                onCreateChooserDialogFragment.setUseDynamicGroup(true);
                dVar = onCreateChooserDialogFragment;
            }
            w m = fragmentManager.m();
            m.e(dVar, str);
            m.j();
            return true;
        }
        str = "android.support.v7.mediarouter:MediaRouteControllerDialogFragment";
        if (fragmentManager.h0("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
            str2 = "showDialog(): Route controller dialog already showing!";
            Log.w("MediaRouteButton", str2);
            return false;
        }
        d onCreateControllerDialogFragment = this.e.onCreateControllerDialogFragment();
        onCreateControllerDialogFragment.setRouteSelector(this.d);
        dVar = onCreateControllerDialogFragment;
        if (i == 2) {
            onCreateControllerDialogFragment.setUseDynamicGroup(true);
            dVar = onCreateControllerDialogFragment;
        }
        w m2 = fragmentManager.m();
        m2.e(dVar, str);
        m2.j();
        return true;
    }

    public final boolean f() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            boolean h = h();
            if (h) {
                return h;
            }
        } else if (i != 30) {
            return false;
        }
        return g();
    }

    public final boolean g() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        Intent putExtra = new Intent().setAction("com.android.settings.panel.action.MEDIA_OUTPUT").putExtra("com.android.settings.panel.extra.PACKAGE_NAME", context.getPackageName()).putExtra("key_media_session_token", this.a.k());
        Iterator it = context.getPackageManager().queryIntentActivities(putExtra, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = ((ResolveInfo) it.next()).activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & 129) != 0) {
                context.startActivity(putExtra);
                return true;
            }
        }
        return false;
    }

    public e getDialogFactory() {
        return this.e;
    }

    public K getRouteSelector() {
        return this.d;
    }

    public final boolean h() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        Intent putExtra = new Intent().setAction("com.android.systemui.action.LAUNCH_MEDIA_OUTPUT_DIALOG").setPackage("com.android.systemui").putExtra("package_name", context.getPackageName()).putExtra("key_media_session_token", this.a.k());
        Iterator it = context.getPackageManager().queryBroadcastReceivers(putExtra, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = ((ResolveInfo) it.next()).activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & 129) != 0) {
                context.sendBroadcast(putExtra);
                return true;
            }
        }
        return false;
    }

    public final void i() {
        int i = this.m;
        CharSequence string = getContext().getString(i != 1 ? i != 2 ? j.c : j.a : j.b);
        setContentDescription(string);
        if (!this.r || TextUtils.isEmpty(string)) {
            string = null;
        }
        k.g0.a(this, string);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.f = true;
        if (!this.d.f()) {
            this.a.a(this.d, this.c);
        }
        b();
        s.b(this);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.a == null || this.h) {
            return onCreateDrawableState;
        }
        int i2 = this.m;
        if (i2 == 1) {
            View.mergeDrawableStates(onCreateDrawableState, v);
        } else if (i2 == 2) {
            View.mergeDrawableStates(onCreateDrawableState, u);
        }
        return onCreateDrawableState;
    }

    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.f = false;
            if (!this.d.f()) {
                this.a.s(this.c);
            }
            s.c(this);
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.j != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int intrinsicWidth = this.j.getIntrinsicWidth();
            int intrinsicHeight = this.j.getIntrinsicHeight();
            int i = paddingLeft + (((width - paddingLeft) - intrinsicWidth) / 2);
            int i2 = paddingTop + (((height - paddingTop) - intrinsicHeight) / 2);
            this.j.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.j.draw(canvas);
        }
    }

    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i3 = this.o;
        Drawable drawable = this.j;
        int max = Math.max(i3, drawable != null ? drawable.getIntrinsicWidth() + getPaddingLeft() + getPaddingRight() : 0);
        int i4 = this.p;
        Drawable drawable2 = this.j;
        int max2 = Math.max(i4, drawable2 != null ? drawable2.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom() : 0);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, max);
        } else if (mode != 1073741824) {
            size = max;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, max2);
        } else if (mode2 != 1073741824) {
            size2 = max2;
        }
        setMeasuredDimension(size, size2);
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        a();
        return d() || performClick;
    }

    public void setAlwaysVisible(boolean z) {
        if (z != this.q) {
            this.q = z;
            c();
            b();
        }
    }

    public void setCheatSheetEnabled(boolean z) {
        if (z != this.r) {
            this.r = z;
            i();
        }
    }

    public void setDialogFactory(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        this.e = eVar;
    }

    public void setRemoteIndicatorDrawable(Drawable drawable) {
        this.k = 0;
        setRemoteIndicatorDrawableInternal(drawable);
    }

    public void setRemoteIndicatorDrawableInternal(Drawable drawable) {
        c cVar = this.i;
        if (cVar != null) {
            cVar.cancel(false);
        }
        Drawable drawable2 = this.j;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.j);
        }
        if (drawable != null) {
            if (this.n != null) {
                drawable = H.a.r(drawable.mutate());
                H.a.o(drawable, this.n);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
        }
        this.j = drawable;
        refreshDrawableState();
    }

    public void setRouteSelector(K k) {
        if (k == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.d.equals(k)) {
            return;
        }
        if (this.f) {
            if (!this.d.f()) {
                this.a.s(this.c);
            }
            if (!k.f()) {
                this.a.a(k, this.c);
            }
        }
        this.d = k;
        b();
    }

    public void setVisibility(int i) {
        this.g = i;
        c();
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.j;
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.a.a);
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet, int i) {
        Drawable.ConstantState constantState;
        super(i.a(context), attributeSet, i);
        this.d = K.c;
        this.e = e.getDefault();
        this.g = 0;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, l.a, i, 0);
        P.L.q0(this, context2, l.a, attributeSet, obtainStyledAttributes, i, 0);
        if (isInEditMode()) {
            this.a = null;
            this.c = null;
            this.j = e.a.b(context2, obtainStyledAttributes.getResourceId(l.e, 0));
            return;
        }
        L j = L.j(context2);
        this.a = j;
        this.c = new b();
        L.h n = j.n();
        int c2 = n.w() ^ true ? n.c() : 0;
        this.m = c2;
        this.l = c2;
        if (s == null) {
            s = new a(context2.getApplicationContext());
        }
        this.n = obtainStyledAttributes.getColorStateList(l.f);
        this.o = obtainStyledAttributes.getDimensionPixelSize(l.b, 0);
        this.p = obtainStyledAttributes.getDimensionPixelSize(l.c, 0);
        int resourceId = obtainStyledAttributes.getResourceId(l.e, 0);
        this.k = obtainStyledAttributes.getResourceId(l.d, 0);
        obtainStyledAttributes.recycle();
        int i2 = this.k;
        if (i2 != 0 && (constantState = (Drawable.ConstantState) t.get(i2)) != null) {
            setRemoteIndicatorDrawable(constantState.newDrawable());
        }
        if (this.j == null) {
            if (resourceId != 0) {
                Drawable.ConstantState constantState2 = (Drawable.ConstantState) t.get(resourceId);
                if (constantState2 != null) {
                    setRemoteIndicatorDrawableInternal(constantState2.newDrawable());
                } else {
                    c cVar = new c(resourceId, getContext());
                    this.i = cVar;
                    cVar.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
            } else {
                a();
            }
        }
        i();
        setClickable(true);
    }
}
