package J7;

import L7.b;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a extends SQLiteOpenHelper {
    public Context a;
    public SQLiteDatabase c;
    public ArrayList d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public a(Context context) {
        super(context, "vpndatabase.db", (SQLiteDatabase.CursorFactory) null, 6);
        this.d = null;
        this.e = "CREATE TABLE IF NOT EXISTS vpntable(id INTEGER PRIMARY KEY,filename TEXT,filename1 TEXT,filepath TEXT,username TEXT,name TEXT,user_id TEXT,profilename TEXT,type TEXT)";
        this.f = "CREATE TABLE IF NOT EXISTS vpntablelogin(id TEXT,filename TEXT,filename1 TEXT,filepath TEXT,username TEXT,name TEXT,profilename TEXT,type TEXT)";
        this.g = "ALTER TABLE vpntable ADD COLUMN filename1 TEXT;";
        this.h = "ALTER TABLE vpntablelogin ADD COLUMN filename1 TEXT;";
        this.i = "ALTER TABLE vpnsmarterstable ADD COLUMN flag TEXT;";
        this.j = "CREATE TABLE IF NOT EXISTS vpnsmarterstable(id INTEGER PRIMARY KEY,file_name TEXT,filepath TEXT,vpn_username TEXT,vpn_password TEXT,user_id TEXT,auth_user_pass TEXT,remember TEXT,server_name TEXT,server_type TEXT,flag TEXT)";
        this.a = context;
    }

    public void a(ArrayList arrayList) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            int size = arrayList.size();
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    contentValues.put("file_name", ((L7.a) arrayList.get(i)).a());
                    contentValues.put("server_name", ((L7.a) arrayList.get(i)).e());
                    contentValues.put("filepath", ((L7.a) arrayList.get(i)).d());
                    contentValues.put("vpn_username", ((L7.a) arrayList.get(i)).i());
                    contentValues.put("vpn_password", ((L7.a) arrayList.get(i)).h());
                    contentValues.put("auth_user_pass", ((L7.a) arrayList.get(i)).j());
                    contentValues.put("remember", ((L7.a) arrayList.get(i)).k());
                    contentValues.put("user_id", ((L7.a) arrayList.get(i)).g());
                    contentValues.put("flag", ((L7.a) arrayList.get(i)).b());
                    contentValues.put("server_type", ((L7.a) arrayList.get(i)).f());
                    writableDatabase.insert("vpnsmarterstable", (String) null, contentValues);
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            Log.w("msg", "exception");
        }
    }

    public void c(SQLiteDatabase sQLiteDatabase, ArrayList arrayList) {
        try {
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            int size = arrayList.size();
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    contentValues.put("file_name", ((L7.a) arrayList.get(i)).a());
                    contentValues.put("server_name", ((L7.a) arrayList.get(i)).e());
                    contentValues.put("filepath", ((L7.a) arrayList.get(i)).d());
                    contentValues.put("vpn_username", ((L7.a) arrayList.get(i)).i());
                    contentValues.put("vpn_password", ((L7.a) arrayList.get(i)).h());
                    contentValues.put("auth_user_pass", ((L7.a) arrayList.get(i)).j());
                    contentValues.put("remember", ((L7.a) arrayList.get(i)).k());
                    contentValues.put("user_id", ((L7.a) arrayList.get(i)).g());
                    sQLiteDatabase.insert("vpnsmarterstable", (String) null, contentValues);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            Log.w("msg", "exception");
        }
    }

    public boolean d(String str, String str2, String str3) {
        String str4 = "SELECT  * FROM vpnsmarterstable WHERE  file_name='" + str + "'  AND server_name='" + str2 + "' AND filepath='" + str3 + "'";
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.c = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery(str4, (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count > 0;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return false;
        }
    }

    public boolean e(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT  * FROM vpnsmarterstable WHERE  file_name='" + str + "'  AND server_name='" + str2 + "' AND filepath='" + str3 + "'", (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count > 0;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return false;
        }
    }

    public void g() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            this.c = writableDatabase;
            writableDatabase.delete("vpnsmarterstable", "server_type='sbp'", (String[]) null);
            this.c.close();
        } catch (Exception unused) {
        }
    }

    public void h(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    h(file2);
                }
            }
            file.delete();
        }
    }

    public void i(int i) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            this.c = writableDatabase;
            writableDatabase.delete("vpnsmarterstable", "id='" + i + "'", (String[]) null);
            this.c.close();
        } catch (Exception unused) {
        }
    }

    public ArrayList j() {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.c = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM vpnsmarterstable", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    L7.a aVar = new L7.a();
                    aVar.o(rawQuery.getInt(0));
                    aVar.m(rawQuery.getString(1));
                    aVar.q(rawQuery.getString(2));
                    aVar.v(rawQuery.getString(3));
                    aVar.u(rawQuery.getString(4));
                    aVar.t(rawQuery.getString(5));
                    aVar.l(rawQuery.getString(6));
                    aVar.p(rawQuery.getString(7));
                    aVar.r(rawQuery.getString(8));
                    aVar.s(rawQuery.getString(9));
                    aVar.n(rawQuery.getString(10));
                    arrayList.add(aVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final ArrayList k(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT  * FROM vpntablelogin", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.g(rawQuery.getInt(0));
                    bVar.d(rawQuery.getString(1));
                    bVar.e(rawQuery.getString(2));
                    bVar.f(rawQuery.getString(3));
                    bVar.k(rawQuery.getString(4));
                    bVar.h(rawQuery.getString(5));
                    bVar.i(rawQuery.getColumnName(6));
                    bVar.j("login");
                    arrayList.add(bVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public final ArrayList l(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT  * FROM vpntable", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.g(rawQuery.getInt(0));
                    bVar.d(rawQuery.getString(1));
                    bVar.e(rawQuery.getString(2));
                    bVar.f(rawQuery.getString(3));
                    bVar.k(rawQuery.getString(4));
                    bVar.h(rawQuery.getString(5));
                    bVar.i(rawQuery.getColumnName(6));
                    bVar.j("settings");
                    arrayList.add(bVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public final void m(SQLiteDatabase sQLiteDatabase) {
        File file;
        File[] listFiles;
        int i;
        int i2;
        File[] fileArr;
        try {
            String valueOf = String.valueOf(new File(this.a.getFilesDir() + "/VPNIPTVSmarters"));
            this.d = new ArrayList();
            if (valueOf.isEmpty()) {
                return;
            }
            File file2 = new File(valueOf);
            if (file2.exists()) {
                for (File file3 : file2.listFiles()) {
                    if (file3.isDirectory() && (listFiles = file3.listFiles()) != null && listFiles.length > 0) {
                        int length = listFiles.length;
                        int i3 = 0;
                        while (i3 < length) {
                            File file4 = listFiles[i3];
                            if (file4 == null || !file4.getName().endsWith(".ovpn")) {
                                i = i3;
                                i2 = length;
                                fileArr = listFiles;
                                StringBuilder sb = new StringBuilder();
                                try {
                                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file4));
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        sb.append(readLine);
                                        sb.append('\n');
                                    }
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                }
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(new File(MyApplication.m().getFilesDir() + "/VPNIPTVSmarters", file4.getName()));
                                    fileOutputStream.write(sb.toString().getBytes());
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            } else {
                                String replaceAll = file4.getName().replaceAll(".ovpn", "");
                                StringBuilder sb2 = new StringBuilder();
                                try {
                                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file4));
                                    while (true) {
                                        String readLine2 = bufferedReader2.readLine();
                                        if (readLine2 == null) {
                                            break;
                                        }
                                        sb2.append(readLine2);
                                        sb2.append('\n');
                                    }
                                    bufferedReader2.close();
                                } catch (IOException unused3) {
                                }
                                try {
                                    StringBuilder sb3 = new StringBuilder();
                                    i = i3;
                                    try {
                                        sb3.append(MyApplication.m().getFilesDir());
                                        sb3.append("/");
                                        sb3.append("VPNIPTVSmarters");
                                        File file5 = new File(sb3.toString(), file4.getName());
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file5);
                                        fileOutputStream2.write(sb2.toString().getBytes());
                                        fileOutputStream2.flush();
                                        fileOutputStream2.close();
                                        if (e(sQLiteDatabase, file4.getName(), replaceAll, String.valueOf(file5))) {
                                            i2 = length;
                                            fileArr = listFiles;
                                        } else {
                                            i2 = length;
                                            fileArr = listFiles;
                                            try {
                                                n(sQLiteDatabase, file4.getName(), replaceAll, sb2.toString(), file5);
                                            } catch (Exception e) {
                                                e = e;
                                                e.printStackTrace();
                                                i3 = i + 1;
                                                length = i2;
                                                listFiles = fileArr;
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        i2 = length;
                                        fileArr = listFiles;
                                        e.printStackTrace();
                                        i3 = i + 1;
                                        length = i2;
                                        listFiles = fileArr;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    i = i3;
                                }
                            }
                            i3 = i + 1;
                            length = i2;
                            listFiles = fileArr;
                        }
                    }
                }
                if (this.d.size() > 0) {
                    c(sQLiteDatabase, this.d);
                }
                if (new u7.a(this.a).A().equals(m7.a.K0)) {
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNIPTVSmarters");
                } else if (Build.VERSION.SDK_INT >= 23) {
                    file = new File(this.a.getFilesDir() + "/VPNIPTVSmarters");
                } else {
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNIPTVSmarters");
                }
                try {
                    h(file);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception unused4) {
        }
    }

    public final void n(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, File file) {
        String str4;
        String str5;
        L7.a aVar = new L7.a();
        if (str3.contains("auth-user-pass")) {
            aVar.l("1");
        } else {
            aVar.l("0");
        }
        aVar.p("0");
        ArrayList k = k(sQLiteDatabase);
        ArrayList l = l(sQLiteDatabase);
        int i = 0;
        if (k == null || k.size() <= 0) {
            str4 = "";
            str5 = str4;
        } else {
            for (int i2 = 0; i2 < k.size(); i2++) {
                if (((b) k.get(i2)).a().equals(str)) {
                    str5 = ((b) k.get(i2)).c();
                    str4 = ((b) k.get(i2)).b();
                    break;
                }
            }
            str4 = "";
            str5 = str4;
        }
        if (str5.equals("") && str4.equals("") && l != null && l.size() > 0) {
            while (true) {
                if (i >= l.size()) {
                    break;
                }
                if (((b) l.get(i)).a().equals(str)) {
                    str5 = ((b) l.get(i)).c();
                    str4 = ((b) l.get(i)).b();
                    break;
                }
                i++;
            }
        }
        aVar.v(str5);
        aVar.u(str4);
        aVar.r(str2);
        aVar.m(str);
        aVar.t("0");
        aVar.q(String.valueOf(file));
        this.d.add(aVar);
    }

    public int o(L7.a aVar) {
        int c = aVar.c();
        int i = 0;
        try {
            this.c = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("vpn_username", aVar.i());
            contentValues.put("vpn_password", aVar.h());
            i = this.c.update("vpnsmarterstable", contentValues, "id='" + c + "'", (String[]) null);
            this.c.close();
            return i;
        } catch (Exception unused) {
            return i;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.e);
        sQLiteDatabase.execSQL(this.f);
        sQLiteDatabase.execSQL(this.j);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 4) {
            sQLiteDatabase.execSQL(this.g);
            sQLiteDatabase.execSQL(this.h);
        }
        if (i < 5) {
            sQLiteDatabase.execSQL(this.j);
            m(sQLiteDatabase);
        }
        if (i < 6) {
            sQLiteDatabase.execSQL(this.i);
        }
    }
}
