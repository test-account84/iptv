package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ahh implements ahg {
    private final /* synthetic */ int a;
    private final Object b;

    public ahh(int i) {
        this.a = i;
        this.b = new int[2];
    }

    public final JSONObject a(View view) {
        if (this.a == 0 && view != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            view.getLocationOnScreen((int[]) this.b);
            int[] iArr = (int[]) this.b;
            return ahn.b(iArr[0], iArr[1], width, height);
        }
        return ahn.b(0, 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.google.ads.interactivemedia.v3.internal.ahg, java.lang.Object] */
    public final void b(View view, JSONObject jSONObject, ahf ahfVar, boolean z, boolean z2) {
        int i;
        int i2 = 0;
        if (this.a == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (!z) {
                    while (i2 < viewGroup.getChildCount()) {
                        ahfVar.a(viewGroup.getChildAt(i2), this, jSONObject, z2);
                        i2++;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
                    }
                    arrayList.add(childAt);
                }
                ArrayList arrayList2 = new ArrayList(hashMap.keySet());
                Collections.sort(arrayList2);
                int size = arrayList2.size();
                int i4 = 0;
                while (i4 < size) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get((Float) arrayList2.get(i4));
                    int size2 = arrayList3.size();
                    int i5 = 0;
                    while (true) {
                        i = i4 + 1;
                        if (i5 < size2) {
                            ahfVar.a((View) arrayList3.get(i5), this, jSONObject, z2);
                            i5++;
                        }
                    }
                    i4 = i;
                }
                return;
            }
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        agz a = agz.a();
        if (a != null) {
            Collection b = a.b();
            int size3 = b.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size3 + size3 + 3);
            Iterator it = b.iterator();
            while (it.hasNext()) {
                View g = ((agt) it.next()).g();
                if (g != null && g.isAttachedToWindow() && g.isShown()) {
                    View view2 = g;
                    while (true) {
                        if (view2 == null) {
                            View rootView = g.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float b2 = com.google.ads.interactivemedia.v3.impl.data.i.b(rootView);
                                int size4 = arrayList4.size();
                                while (size4 > 0) {
                                    int i6 = size4 - 1;
                                    if (com.google.ads.interactivemedia.v3.impl.data.i.b((View) arrayList4.get(i6)) <= b2) {
                                        break;
                                    } else {
                                        size4 = i6;
                                    }
                                }
                                arrayList4.add(size4, rootView);
                            }
                        } else if (view2.getAlpha() != 0.0f) {
                            ViewParent parent = view2.getParent();
                            view2 = parent instanceof View ? (View) parent : null;
                        }
                    }
                }
            }
        }
        int size5 = arrayList4.size();
        while (i2 < size5) {
            ahfVar.a((View) arrayList4.get(i2), this.b, jSONObject, z2);
            i2++;
        }
    }

    public ahh(ahg ahgVar, int i) {
        this.a = i;
        this.b = ahgVar;
    }
}
