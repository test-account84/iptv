package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aho {
    private final HashMap a = new HashMap();
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final HashSet d = new HashSet();
    private final HashSet e = new HashSet();
    private final HashSet f = new HashSet();
    private final HashMap g = new HashMap();
    private final Map h = new WeakHashMap();
    private boolean i;

    public final View a(String str) {
        return (View) this.c.get(str);
    }

    public final String b(String str) {
        return (String) this.g.get(str);
    }

    public final String c(View view) {
        if (this.a.size() == 0) {
            return null;
        }
        String str = (String) this.a.get(view);
        if (str != null) {
            this.a.remove(view);
        }
        return str;
    }

    public final HashSet d() {
        return this.f;
    }

    public final HashSet e() {
        return this.e;
    }

    public final void f() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.i = false;
    }

    public final void g() {
        this.i = true;
    }

    public final void h() {
        Boolean bool;
        String str;
        agz a = agz.a();
        if (a != null) {
            for (agt agtVar : a.b()) {
                View g = agtVar.g();
                if (agtVar.k()) {
                    String i = agtVar.i();
                    if (g != null) {
                        if (g.isAttachedToWindow()) {
                            if (g.hasWindowFocus()) {
                                this.h.remove(g);
                                bool = Boolean.FALSE;
                            } else if (this.h.containsKey(g)) {
                                bool = (Boolean) this.h.get(g);
                            } else {
                                Map map = this.h;
                                Boolean bool2 = Boolean.FALSE;
                                map.put(g, bool2);
                                bool = bool2;
                            }
                            if (bool.booleanValue()) {
                                str = "noWindowFocus";
                            } else {
                                HashSet hashSet = new HashSet();
                                View view = g;
                                while (true) {
                                    if (view == null) {
                                        this.d.addAll(hashSet);
                                        str = null;
                                        break;
                                    }
                                    String c = com.google.ads.interactivemedia.v3.impl.data.i.c(view);
                                    if (c != null) {
                                        str = c;
                                        break;
                                    } else {
                                        hashSet.add(view);
                                        ViewParent parent = view.getParent();
                                        view = parent instanceof View ? (View) parent : null;
                                    }
                                }
                            }
                        } else {
                            str = "notAttached";
                        }
                        if (str == null) {
                            this.e.add(i);
                            this.a.put(g, i);
                            for (ly lyVar : agtVar.j()) {
                                View view2 = (View) lyVar.j().get();
                                if (view2 != null) {
                                    aeq aeqVar = (aeq) this.b.get(view2);
                                    if (aeqVar != null) {
                                        aeqVar.f(agtVar.i());
                                    } else {
                                        this.b.put(view2, new aeq(lyVar, agtVar.i(), null));
                                    }
                                }
                            }
                        } else if (str != "noWindowFocus") {
                            this.f.add(i);
                            this.c.put(i, g);
                            this.g.put(i, str);
                        }
                    } else {
                        this.f.add(i);
                        this.g.put(i, "noAdView");
                    }
                }
            }
        }
    }

    public final boolean i(View view) {
        if (!this.h.containsKey(view)) {
            return true;
        }
        this.h.put(view, Boolean.TRUE);
        return false;
    }

    public final int j(View view) {
        if (this.d.contains(view)) {
            return 1;
        }
        return this.i ? 2 : 3;
    }

    public final aeq k(View view) {
        aeq aeqVar = (aeq) this.b.get(view);
        if (aeqVar != null) {
            this.b.remove(view);
        }
        return aeqVar;
    }
}
