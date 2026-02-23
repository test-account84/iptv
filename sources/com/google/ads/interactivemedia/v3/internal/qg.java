package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class qg extends qh {
    public static final qg a = new qg("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());
    public final List b;
    public final List c;
    public final List d;
    public final List e;
    public final List f;
    public final List g;
    public final s h;
    public final List i;
    public final Map j;
    public final List k;

    public qg(String str, List list, List list2, List list3, List list4, List list5, List list6, s sVar, List list7, boolean z, Map map, List list8) {
        super(str, list, z);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            Uri uri = ((qf) list2.get(i)).a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        c(list3, arrayList);
        c(list4, arrayList);
        c(list5, arrayList);
        c(list6, arrayList);
        this.b = Collections.unmodifiableList(arrayList);
        this.c = Collections.unmodifiableList(list2);
        this.d = Collections.unmodifiableList(list3);
        this.e = Collections.unmodifiableList(list4);
        this.f = Collections.unmodifiableList(list5);
        this.g = Collections.unmodifiableList(list6);
        this.h = sVar;
        this.i = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.j = Collections.unmodifiableMap(map);
        this.k = Collections.unmodifiableList(list8);
    }

    public static qg a(String str) {
        Uri parse = Uri.parse(str);
        r rVar = new r();
        rVar.S("0");
        rVar.K("application/x-mpegURL");
        return new qg("", Collections.emptyList(), Collections.singletonList(new qf(parse, rVar.v(), null, null, null, null)), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List b(List list, int i, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 < list2.size()) {
                    ba baVar = (ba) list2.get(i3);
                    if (baVar.b == i && baVar.c == i2) {
                        arrayList.add(obj);
                        break;
                    }
                    i3++;
                }
            }
        }
        return arrayList;
    }

    private static void c(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            Uri uri = ((qe) list.get(i)).a;
            if (!list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    public final /* bridge */ /* synthetic */ Object e(List list) {
        return new qg(this.t, this.u, b(this.c, 0, list), Collections.emptyList(), b(this.e, 1, list), b(this.f, 2, list), Collections.emptyList(), this.h, this.i, this.v, this.j, this.k);
    }
}
