package d;

import P.q;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import i.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class u extends androidx.activity.g implements b {
    private d mDelegate;
    private final q.a mKeyDispatcher;

    public u(Context context, int i) {
        super(context, d(context, i));
        this.mKeyDispatcher = new t(this);
        d delegate = getDelegate();
        delegate.M(d(context, i));
        delegate.x(null);
    }

    public static int d(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(c.a.y, typedValue, true);
        return typedValue.resourceId;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().e(view, layoutParams);
    }

    public void dismiss() {
        super.dismiss();
        getDelegate().y();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return P.q.e(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    public View findViewById(int i) {
        return getDelegate().j(i);
    }

    public d getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = d.i(this, this);
        }
        return this.mDelegate;
    }

    public a getSupportActionBar() {
        return getDelegate().r();
    }

    public void invalidateOptionsMenu() {
        getDelegate().t();
    }

    public void onCreate(Bundle bundle) {
        getDelegate().s();
        super.onCreate(bundle);
        getDelegate().x(bundle);
    }

    public void onStop() {
        super.onStop();
        getDelegate().D();
    }

    public i.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void setContentView(int i) {
        getDelegate().H(i);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().N(getContext().getString(i));
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().G(i);
    }

    public void setContentView(View view) {
        getDelegate().I(view);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().N(charSequence);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().J(view, layoutParams);
    }

    public void onSupportActionModeFinished(i.b bVar) {
    }

    public void onSupportActionModeStarted(i.b bVar) {
    }
}
