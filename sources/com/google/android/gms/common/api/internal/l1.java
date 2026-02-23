package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l1 extends Fragment implements j {
    public static final WeakHashMap e = new WeakHashMap();
    public final Map a = DesugarCollections.synchronizedMap(new s.a());
    public int c = 0;
    public Bundle d;

    public static /* bridge */ /* synthetic */ int a(l1 l1Var) {
        return l1Var.c;
    }

    public static /* bridge */ /* synthetic */ Bundle b(l1 l1Var) {
        return l1Var.d;
    }

    public static l1 c(Activity activity) {
        l1 l1Var;
        WeakHashMap weakHashMap = e;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (l1Var = (l1) weakReference.get()) != null) {
            return l1Var;
        }
        try {
            l1 l1Var2 = (l1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (l1Var2 == null || l1Var2.isRemoving()) {
                l1Var2 = new l1();
                activity.getFragmentManager().beginTransaction().add(l1Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(l1Var2));
            return l1Var2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void f(String str, LifecycleCallback lifecycleCallback) {
        if (this.a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.a.put(str, lifecycleCallback);
        if (this.c > 0) {
            new zzi(Looper.getMainLooper()).post(new k1(this, lifecycleCallback, str));
        }
    }

    public final LifecycleCallback g(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.a.get(str));
    }

    public final Activity h() {
        return getActivity();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = 1;
        this.d = bundle;
        for (Map.Entry entry : this.a.entrySet()) {
            ((LifecycleCallback) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.c = 5;
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.c = 3;
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    public final void onStart() {
        super.onStart();
        this.c = 2;
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.c = 4;
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onStop();
        }
    }
}
