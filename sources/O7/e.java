package O7;

import com.onesignal.F1;
import com.onesignal.P0;
import com.onesignal.S1;
import com.onesignal.l1;
import com.onesignal.t1;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.l;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class e {
    public final ConcurrentHashMap a;
    public final c b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[P7.b.values().length];
            iArr[P7.b.NOTIFICATION.ordinal()] = 1;
            iArr[P7.b.IAM.ordinal()] = 2;
            a = iArr;
        }
    }

    public e(l1 preferences, P0 logger, t1 timeProvider) {
        l.e(preferences, "preferences");
        l.e(logger, "logger");
        l.e(timeProvider, "timeProvider");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = concurrentHashMap;
        c cVar = new c(preferences);
        this.b = cVar;
        N7.a aVar = N7.a.a;
        concurrentHashMap.put(aVar.a(), new b(cVar, logger, timeProvider));
        concurrentHashMap.put(aVar.b(), new d(cVar, logger, timeProvider));
    }

    public final void a(JSONObject jsonObject, List influences) {
        l.e(jsonObject, "jsonObject");
        l.e(influences, "influences");
        for (P7.a aVar : (Iterable) influences) {
            if (a.a[aVar.c().ordinal()] == 1) {
                g().a(jsonObject, aVar);
            }
        }
    }

    public final O7.a b(F1.r entryAction) {
        l.e(entryAction, "entryAction");
        if (entryAction.isNotificationClick()) {
            return g();
        }
        return null;
    }

    public final List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(g());
        arrayList.add(e());
        return arrayList;
    }

    public final List d(F1.r entryAction) {
        l.e(entryAction, "entryAction");
        ArrayList arrayList = new ArrayList();
        if (entryAction.isAppClose()) {
            return arrayList;
        }
        O7.a g = entryAction.isAppOpen() ? g() : null;
        if (g != null) {
            arrayList.add(g);
        }
        arrayList.add(e());
        return arrayList;
    }

    public final O7.a e() {
        Object obj = this.a.get(N7.a.a.a());
        l.b(obj);
        l.d(obj, "trackers[OSInfluenceConstants.IAM_TAG]!!");
        return (O7.a) obj;
    }

    public final List f() {
        Iterable values = this.a.values();
        l.d(values, "trackers.values");
        Iterable iterable = values;
        ArrayList arrayList = new ArrayList(l8.l.o(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((O7.a) it.next()).e());
        }
        return arrayList;
    }

    public final O7.a g() {
        Object obj = this.a.get(N7.a.a.b());
        l.b(obj);
        l.d(obj, "trackers[OSInfluenceConstants.NOTIFICATION_TAG]!!");
        return (O7.a) obj;
    }

    public final List h() {
        Iterable values = this.a.values();
        l.d(values, "trackers.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (!l.a(((O7.a) obj).h(), N7.a.a.a())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(l8.l.o(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((O7.a) it.next()).e());
        }
        return arrayList2;
    }

    public final void i() {
        Iterable values = this.a.values();
        l.d(values, "trackers.values");
        Iterator it = values.iterator();
        while (it.hasNext()) {
            ((O7.a) it.next()).p();
        }
    }

    public final void j(S1.e influenceParams) {
        l.e(influenceParams, "influenceParams");
        this.b.q(influenceParams);
    }
}
