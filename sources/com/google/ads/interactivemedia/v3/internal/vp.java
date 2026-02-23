package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class vp implements Comparator {
    private final /* synthetic */ int i;
    public static final /* synthetic */ vp h = new vp(7);
    public static final /* synthetic */ vp g = new vp(6);
    public static final /* synthetic */ vp f = new vp(5);
    public static final /* synthetic */ vp e = new vp(4);
    public static final /* synthetic */ vp d = new vp(3);
    public static final /* synthetic */ vp c = new vp(2);
    public static final /* synthetic */ vp b = new vp(1);
    public static final /* synthetic */ vp a = new vp(0);

    private /* synthetic */ vp(int i) {
        this.i = i;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.i) {
            case 0:
                return ((vr) Collections.max((List) obj)).a((vr) Collections.max((List) obj2));
            case 1:
                return ((s) obj2).h - ((s) obj).h;
            case 2:
                List list = (List) obj;
                List list2 = (List) obj2;
                aut j = aut.j();
                vp vpVar = g;
                aut b2 = j.c((wc) Collections.max(list, vpVar), (wc) Collections.max(list2, vpVar), vpVar).b(list.size(), list2.size());
                vp vpVar2 = h;
                return b2.c((wc) Collections.max(list, vpVar2), (wc) Collections.max(list2, vpVar2), vpVar2).a();
            case 3:
                return ((vz) ((List) obj).get(0)).a((vz) ((List) obj2).get(0));
            case 4:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                int i = wd.a;
                if (num.intValue() == -1) {
                    return num2.intValue() == -1 ? 0 : -1;
                }
                if (num2.intValue() == -1) {
                    return 1;
                }
                return num.intValue() - num2.intValue();
            case 5:
                int i2 = wd.a;
                return 0;
            case 6:
                return wc.d((wc) obj, (wc) obj2);
            default:
                return wc.a((wc) obj, (wc) obj2);
        }
    }
}
