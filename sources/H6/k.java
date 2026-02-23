package h6;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class k {
    public final SharedPreferences a;

    public k(Context context, String str) {
        this.a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    public final synchronized void a() {
        try {
            long j = this.a.getLong("fire-count", 0L);
            String str = "";
            String str2 = null;
            for (Map.Entry entry : this.a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    for (String str3 : (Set) entry.getValue()) {
                        if (str2 == null || str2.compareTo(str3) > 0) {
                            str = (String) entry.getKey();
                            str2 = str3;
                        }
                    }
                }
            }
            HashSet hashSet = new HashSet(this.a.getStringSet(str, new HashSet()));
            hashSet.remove(str2);
            this.a.edit().putStringSet(str, hashSet).putLong("fire-count", j - 1).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        try {
            SharedPreferences.Editor edit = this.a.edit();
            int i = 0;
            for (Map.Entry entry : this.a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    String d = d(System.currentTimeMillis());
                    String str = (String) entry.getKey();
                    if (set.contains(d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(d);
                        i++;
                        edit.putStringSet(str, hashSet);
                    } else {
                        edit.remove(str);
                    }
                }
            }
            if (i == 0) {
                edit.remove("fire-count");
            } else {
                edit.putLong("fire-count", i);
            }
            edit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized List c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Map.Entry entry : this.a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(d(System.currentTimeMillis()));
                    if (!hashSet.isEmpty()) {
                        arrayList.add(l.a((String) entry.getKey(), new ArrayList(hashSet)));
                    }
                }
            }
            l(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String d(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
    }

    public final synchronized String e(String str) {
        for (Map.Entry entry : this.a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return (String) entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    public synchronized boolean f(long j, long j2) {
        return d(j).equals(d(j2));
    }

    public synchronized void g() {
        String d = d(System.currentTimeMillis());
        this.a.edit().putString("last-used-date", d).commit();
        h(d);
    }

    public final synchronized void h(String str) {
        try {
            String e = e(str);
            if (e == null) {
                return;
            }
            HashSet hashSet = new HashSet(this.a.getStringSet(e, new HashSet()));
            hashSet.remove(str);
            (hashSet.isEmpty() ? this.a.edit().remove(e) : this.a.edit().putStringSet(e, hashSet)).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean i(long j) {
        return j("fire-global", j);
    }

    public synchronized boolean j(String str, long j) {
        if (!this.a.contains(str)) {
            this.a.edit().putLong(str, j).commit();
            return true;
        }
        if (f(this.a.getLong(str, -1L), j)) {
            return false;
        }
        this.a.edit().putLong(str, j).commit();
        return true;
    }

    public synchronized void k(long j, String str) {
        String d = d(j);
        if (this.a.getString("last-used-date", "").equals(d)) {
            String e = e(d);
            if (e == null) {
                return;
            }
            if (e.equals(str)) {
                return;
            }
            m(str, d);
            return;
        }
        long j2 = this.a.getLong("fire-count", 0L);
        if (j2 + 1 == 30) {
            a();
            j2 = this.a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.a.getStringSet(str, new HashSet()));
        hashSet.add(d);
        this.a.edit().putStringSet(str, hashSet).putLong("fire-count", j2 + 1).putString("last-used-date", d).commit();
    }

    public synchronized void l(long j) {
        this.a.edit().putLong("fire-global", j).commit();
    }

    public final synchronized void m(String str, String str2) {
        h(str2);
        HashSet hashSet = new HashSet(this.a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.a.edit().putStringSet(str, hashSet).commit();
    }
}
