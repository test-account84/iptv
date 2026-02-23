package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.d;
import androidx.navigation.NavController;
import androidx.navigation.n;
import androidx.navigation.r;
import androidx.navigation.s;
import androidx.navigation.v;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NavHostFragment extends Fragment {
    public n a;
    public Boolean c = null;
    public View d;
    public int e;
    public boolean f;

    public static NavController z(Fragment fragment) {
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment2).B();
            }
            Fragment x0 = fragment2.getParentFragmentManager().x0();
            if (x0 instanceof NavHostFragment) {
                return ((NavHostFragment) x0).B();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return r.b(view);
        }
        Dialog dialog = fragment instanceof d ? ((d) fragment).getDialog() : null;
        if (dialog != null && dialog.getWindow() != null) {
            return r.b(dialog.getWindow().getDecorView());
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
    }

    public final int A() {
        int id = getId();
        return (id == 0 || id == -1) ? b.a : id;
    }

    public final NavController B() {
        n nVar = this.a;
        if (nVar != null) {
            return nVar;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    public void D(NavController navController) {
        navController.l().a(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
        navController.l().a(x());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.f) {
            getParentFragmentManager().m().v(this).i();
        }
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        ((DialogFragmentNavigator) this.a.l().d(DialogFragmentNavigator.class)).h(fragment);
    }

    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        n nVar = new n(requireContext());
        this.a = nVar;
        nVar.D(this);
        this.a.E(requireActivity().getOnBackPressedDispatcher());
        n nVar2 = this.a;
        Boolean bool = this.c;
        nVar2.c(bool != null && bool.booleanValue());
        this.c = null;
        this.a.F(getViewModelStore());
        D(this.a);
        if (bundle != null) {
            bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
            if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                this.f = true;
                getParentFragmentManager().m().v(this).i();
            }
            this.e = bundle.getInt("android-support-nav:fragment:graphId");
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.a.y(bundle2);
        }
        int i = this.e;
        if (i != 0) {
            this.a.A(i);
        } else {
            Bundle arguments = getArguments();
            int i2 = arguments != null ? arguments.getInt("android-support-nav:fragment:graphId") : 0;
            Bundle bundle3 = arguments != null ? arguments.getBundle("android-support-nav:fragment:startDestinationArgs") : null;
            if (i2 != 0) {
                this.a.B(i2, bundle3);
            }
        }
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(A());
        return fragmentContainerView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        View view = this.d;
        if (view != null && r.b(view) == this.a) {
            r.e(this.d, null);
        }
        this.d = null;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.p);
        int resourceId = obtainStyledAttributes.getResourceId(v.q, 0);
        if (resourceId != 0) {
            this.e = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, c.r);
        if (obtainStyledAttributes2.getBoolean(c.s, false)) {
            this.f = true;
        }
        obtainStyledAttributes2.recycle();
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.c(z);
        } else {
            this.c = Boolean.valueOf(z);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle z = this.a.z();
        if (z != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", z);
        }
        if (this.f) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i = this.e;
        if (i != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
        }
        r.e(view, this.a);
        if (view.getParent() != null) {
            View parent = view.getParent();
            this.d = parent;
            if (parent.getId() == getId()) {
                r.e(this.d, this.a);
            }
        }
    }

    public s x() {
        return new a(requireContext(), getChildFragmentManager(), A());
    }
}
