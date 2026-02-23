package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k implements LayoutInflater.Factory2 {
    public final m a;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ t a;

        public a(t tVar) {
            this.a = tVar;
        }

        public void onViewAttachedToWindow(View view) {
            Fragment k = this.a.k();
            this.a.m();
            C.n(k.mView.getParent(), k.this.a).j();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public k(m mVar) {
        this.a = mVar;
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        t v;
        StringBuilder sb;
        String str2;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.c.d);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(e0.c.e);
        }
        int resourceId = obtainStyledAttributes.getResourceId(e0.c.f, -1);
        String string = obtainStyledAttributes.getString(e0.c.g);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !i.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment g0 = resourceId != -1 ? this.a.g0(resourceId) : null;
        if (g0 == null && string != null) {
            g0 = this.a.h0(string);
        }
        if (g0 == null && id != -1) {
            g0 = this.a.g0(id);
        }
        if (g0 == null) {
            g0 = this.a.q0().a(context.getClassLoader(), attributeValue);
            g0.mFromLayout = true;
            g0.mFragmentId = resourceId != 0 ? resourceId : id;
            g0.mContainerId = id;
            g0.mTag = string;
            g0.mInLayout = true;
            m mVar = this.a;
            g0.mFragmentManager = mVar;
            g0.mHost = mVar.t0();
            g0.onInflate(this.a.t0().f(), attributeSet, g0.mSavedFragmentState);
            v = this.a.g(g0);
            if (m.F0(2)) {
                sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(g0);
                str2 = " has been inflated via the <fragment> tag: id=0x";
                sb.append(str2);
                sb.append(Integer.toHexString(resourceId));
                Log.v("FragmentManager", sb.toString());
            }
        } else {
            if (g0.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            g0.mInLayout = true;
            m mVar2 = this.a;
            g0.mFragmentManager = mVar2;
            g0.mHost = mVar2.t0();
            g0.onInflate(this.a.t0().f(), attributeSet, g0.mSavedFragmentState);
            v = this.a.v(g0);
            if (m.F0(2)) {
                sb = new StringBuilder();
                sb.append("Retained Fragment ");
                sb.append(g0);
                str2 = " has been re-attached via the <fragment> tag: id=0x";
                sb.append(str2);
                sb.append(Integer.toHexString(resourceId));
                Log.v("FragmentManager", sb.toString());
            }
        }
        g0.mContainer = (ViewGroup) view;
        v.m();
        v.j();
        View view2 = g0.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (g0.mView.getTag() == null) {
            g0.mView.setTag(string);
        }
        g0.mView.addOnAttachStateChangeListener(new a(v));
        return g0.mView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
