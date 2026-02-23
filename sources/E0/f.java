package E0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f {
    public final String a;
    public final Map b;
    public final Set c;
    public final Set d;

    public static class a {
        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final int e;
        public final String f;
        public final int g;

        public a(String str, String str2, boolean z, int i, String str3, int i2) {
            this.a = str;
            this.b = str2;
            this.d = z;
            this.e = i;
            this.c = a(str2);
            this.f = str3;
            this.g = i2;
        }

        public static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.e != aVar.e || !this.a.equals(aVar.a) || this.d != aVar.d) {
                return false;
            }
            if (this.g == 1 && aVar.g == 2 && (str3 = this.f) != null && !str3.equals(aVar.f)) {
                return false;
            }
            if (this.g == 2 && aVar.g == 1 && (str2 = aVar.f) != null && !str2.equals(this.f)) {
                return false;
            }
            int i = this.g;
            return (i == 0 || i != aVar.g || ((str = this.f) == null ? aVar.f == null : str.equals(aVar.f))) && this.c == aVar.c;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.c) * 31) + (this.d ? 1231 : 1237)) * 31) + this.e;
        }

        public String toString() {
            return "Column{name='" + this.a + "', type='" + this.b + "', affinity='" + this.c + "', notNull=" + this.d + ", primaryKeyPosition=" + this.e + ", defaultValue='" + this.f + "'}";
        }
    }

    public static class b {
        public final String a;
        public final String b;
        public final String c;
        public final List d;
        public final List e;

        public b(String str, String str2, String str3, List list, List list2) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = Collections.unmodifiableList(list);
            this.e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.b.equals(bVar.b) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                return this.e.equals(bVar.e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.a + "', onDelete='" + this.b + "', onUpdate='" + this.c + "', columnNames=" + this.d + ", referenceColumnNames=" + this.e + '}';
        }
    }

    public static class c implements Comparable {
        public final int a;
        public final int c;
        public final String d;
        public final String e;

        public c(int i, int i2, String str, String str2) {
            this.a = i;
            this.c = i2;
            this.d = str;
            this.e = str2;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int i = this.a - cVar.a;
            return i == 0 ? this.c - cVar.c : i;
        }
    }

    public static class d {
        public final String a;
        public final boolean b;
        public final List c;

        public d(String str, boolean z, List list) {
            this.a = str;
            this.b = z;
            this.c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.b == dVar.b && this.c.equals(dVar.c)) {
                return this.a.startsWith("index_") ? dVar.a.startsWith("index_") : this.a.equals(dVar.a);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.a.startsWith("index_") ? -1184239155 : this.a.hashCode()) * 31) + (this.b ? 1 : 0)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.a + "', unique=" + this.b + ", columns=" + this.c + '}';
        }
    }

    public f(String str, Map map, Set set, Set set2) {
        this.a = str;
        this.b = Collections.unmodifiableMap(map);
        this.c = Collections.unmodifiableSet(set);
        this.d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static f a(G0.b bVar, String str) {
        return new f(str, b(bVar, str), d(bVar, str), f(bVar, str));
    }

    public static Map b(G0.b bVar, String str) {
        Cursor U = bVar.U("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (U.getColumnCount() > 0) {
                int columnIndex = U.getColumnIndex("name");
                int columnIndex2 = U.getColumnIndex("type");
                int columnIndex3 = U.getColumnIndex("notnull");
                int columnIndex4 = U.getColumnIndex("pk");
                int columnIndex5 = U.getColumnIndex("dflt_value");
                while (U.moveToNext()) {
                    String string = U.getString(columnIndex);
                    hashMap.put(string, new a(string, U.getString(columnIndex2), U.getInt(columnIndex3) != 0, U.getInt(columnIndex4), U.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            U.close();
        }
    }

    public static List c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Set d(G0.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor U = bVar.U("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = U.getColumnIndex("id");
            int columnIndex2 = U.getColumnIndex("seq");
            int columnIndex3 = U.getColumnIndex("table");
            int columnIndex4 = U.getColumnIndex("on_delete");
            int columnIndex5 = U.getColumnIndex("on_update");
            List<c> c2 = c(U);
            int count = U.getCount();
            for (int i = 0; i < count; i++) {
                U.moveToPosition(i);
                if (U.getInt(columnIndex2) == 0) {
                    int i2 = U.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : c2) {
                        if (cVar.a == i2) {
                            arrayList.add(cVar.d);
                            arrayList2.add(cVar.e);
                        }
                    }
                    hashSet.add(new b(U.getString(columnIndex3), U.getString(columnIndex4), U.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            U.close();
            return hashSet;
        } catch (Throwable th) {
            U.close();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static d e(G0.b bVar, String str, boolean z) {
        Cursor U = bVar.U("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = U.getColumnIndex("seqno");
            int columnIndex2 = U.getColumnIndex("cid");
            int columnIndex3 = U.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (U.moveToNext()) {
                    if (U.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(U.getInt(columnIndex)), U.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                d dVar = new d(str, z, arrayList);
                U.close();
                return dVar;
            }
            U.close();
            return null;
        } catch (Throwable th) {
            U.close();
            throw th;
        }
    }

    public static Set f(G0.b bVar, String str) {
        Cursor U = bVar.U("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = U.getColumnIndex("name");
            int columnIndex2 = U.getColumnIndex("origin");
            int columnIndex3 = U.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (U.moveToNext()) {
                    if ("c".equals(U.getString(columnIndex2))) {
                        String string = U.getString(columnIndex);
                        boolean z = true;
                        if (U.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        d e = e(bVar, string, z);
                        if (e == null) {
                            return null;
                        }
                        hashSet.add(e);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            U.close();
        }
    }

    public boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.a;
        if (str == null ? fVar.a != null : !str.equals(fVar.a)) {
            return false;
        }
        Map map = this.b;
        if (map == null ? fVar.b != null : !map.equals(fVar.b)) {
            return false;
        }
        Set set2 = this.c;
        if (set2 == null ? fVar.c != null : !set2.equals(fVar.c)) {
            return false;
        }
        Set set3 = this.d;
        if (set3 == null || (set = fVar.d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set set = this.c;
        return hashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.a + "', columns=" + this.b + ", foreignKeys=" + this.c + ", indices=" + this.d + '}';
    }
}
