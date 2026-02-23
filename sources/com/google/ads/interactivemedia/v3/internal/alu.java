package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class alu implements Continuation {
    public final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public /* synthetic */ alu(alx alxVar, int i) {
        this.b = i;
        this.a = alxVar;
    }

    public final Object then(Task task) {
        int i = this.b;
        if (i == 0) {
            Object obj = this.a;
            List<alt> list = (List) task.getResult();
            ArrayList arrayList = new ArrayList(list.size());
            for (alt altVar : list) {
                arrayList.add(altVar.b().addOnFailureListener(new alv((alx) obj, altVar)));
            }
            return arrayList;
        }
        if (i == 1) {
            return this.a;
        }
        if (i == 2) {
            return alx.a((alx) this.a, task);
        }
        if (i == 3) {
            List<Task> list2 = (List) task.getResult();
            ArrayList arrayList2 = new ArrayList(list2.size());
            for (Task task2 : list2) {
                if (task2.isSuccessful()) {
                    arrayList2.add(task2.getResult());
                }
            }
            return arrayList2;
        }
        if (i != 4) {
            alx.f((alx) this.a);
            return null;
        }
        Object obj2 = this.a;
        List<alt> list3 = (List) task.getResult();
        ArrayList arrayList3 = new ArrayList(list3.size());
        for (alt altVar2 : list3) {
            Task c = altVar2.c();
            c.addOnFailureListener(new alw((alx) obj2, altVar2));
            arrayList3.add(c);
        }
        return arrayList3;
    }

    public /* synthetic */ alu(List list, int i) {
        this.b = i;
        this.a = list;
    }
}
