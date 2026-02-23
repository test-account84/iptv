package c4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import d4.k0;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import s5.C;
import s5.c0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class m {
    public final HashMap a;
    public final SparseArray b;
    public final SparseBooleanArray c;
    public final SparseBooleanArray d;
    public c e;
    public c f;

    public static final class a implements c {
        public static final String[] e = {"id", "key", "metadata"};
        public final T2.b a;
        public final SparseArray b = new SparseArray();
        public String c;
        public String d;

        public a(T2.b bVar) {
            this.a = bVar;
        }

        public static void j(T2.b bVar, String str) {
            try {
                String n = n(str);
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    T2.e.c(writableDatabase, 1, str);
                    l(writableDatabase, n);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new T2.a(e2);
            }
        }

        public static void l(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        public static String n(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        public boolean a() {
            try {
                return T2.e.b(this.a.getReadableDatabase(), 1, (String) d4.a.e(this.c)) != -1;
            } catch (SQLException e2) {
                throw new T2.a(e2);
            }
        }

        public void b(HashMap hashMap) {
            if (this.b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.b.size(); i++) {
                    try {
                        l lVar = (l) this.b.valueAt(i);
                        if (lVar == null) {
                            k(writableDatabase, this.b.keyAt(i));
                        } else {
                            i(writableDatabase, lVar);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new T2.a(e2);
            }
        }

        public void c(long j) {
            String hexString = Long.toHexString(j);
            this.c = hexString;
            this.d = n(hexString);
        }

        public void d(HashMap hashMap) {
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    o(writableDatabase);
                    Iterator it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, (l) it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.b.clear();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e2) {
                throw new T2.a(e2);
            }
        }

        public void e(l lVar) {
            this.b.put(lVar.a, lVar);
        }

        public void f(l lVar, boolean z) {
            if (z) {
                this.b.delete(lVar.a);
            } else {
                this.b.put(lVar.a, (Object) null);
            }
        }

        public void g(HashMap hashMap, SparseArray sparseArray) {
            d4.a.g(this.b.size() == 0);
            try {
                if (T2.e.b(this.a.getReadableDatabase(), 1, (String) d4.a.e(this.c)) != 1) {
                    SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        o(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                Cursor m = m();
                while (m.moveToNext()) {
                    try {
                        l lVar = new l(m.getInt(0), (String) d4.a.e(m.getString(1)), m.b(new DataInputStream(new ByteArrayInputStream(m.getBlob(2)))));
                        hashMap.put(lVar.b, lVar);
                        sparseArray.put(lVar.a, lVar.b);
                    } finally {
                    }
                }
                m.close();
            } catch (SQLiteException e2) {
                hashMap.clear();
                sparseArray.clear();
                throw new T2.a(e2);
            }
        }

        public void h() {
            j(this.a, (String) d4.a.e(this.c));
        }

        public final void i(SQLiteDatabase sQLiteDatabase, l lVar) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m.c(lVar.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(lVar.a));
            contentValues.put("key", lVar.b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) d4.a.e(this.d), (String) null, contentValues);
        }

        public final void k(SQLiteDatabase sQLiteDatabase, int i) {
            sQLiteDatabase.delete((String) d4.a.e(this.d), "id = ?", new String[]{Integer.toString(i)});
        }

        public final Cursor m() {
            return this.a.getReadableDatabase().query((String) d4.a.e(this.d), e, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }

        public final void o(SQLiteDatabase sQLiteDatabase) {
            T2.e.d(sQLiteDatabase, 1, (String) d4.a.e(this.c), 1);
            l(sQLiteDatabase, (String) d4.a.e(this.d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }
    }

    public interface c {
        boolean a();

        void b(HashMap hashMap);

        void c(long j);

        void d(HashMap hashMap);

        void e(l lVar);

        void f(l lVar, boolean z);

        void g(HashMap hashMap, SparseArray sparseArray);

        void h();
    }

    public m(T2.b bVar, File file, byte[] bArr, boolean z, boolean z2) {
        d4.a.g((bVar == null && file == null) ? false : true);
        this.a = new HashMap();
        this.b = new SparseArray();
        this.c = new SparseBooleanArray();
        this.d = new SparseBooleanArray();
        a aVar = bVar != null ? new a(bVar) : null;
        b bVar2 = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z) : null;
        if (aVar == null || (bVar2 != null && z2)) {
            this.e = (c) k0.j(bVar2);
            this.f = aVar;
        } else {
            this.e = aVar;
            this.f = bVar2;
        }
    }

    public static /* synthetic */ Cipher a() {
        return i();
    }

    public static /* synthetic */ q b(DataInputStream dataInputStream) {
        return q(dataInputStream);
    }

    public static /* synthetic */ void c(q qVar, DataOutputStream dataOutputStream) {
        t(qVar, dataOutputStream);
    }

    public static Cipher i() {
        if (k0.a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public static int l(SparseArray sparseArray) {
        int size = sparseArray.size();
        int i = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt >= 0) {
            return keyAt;
        }
        while (i < size && i == sparseArray.keyAt(i)) {
            i++;
        }
        return i;
    }

    public static boolean o(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    public static q q(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 < 0) {
                throw new IOException("Invalid value size: " + readInt2);
            }
            int min = Math.min(readInt2, 10485760);
            byte[] bArr = k0.f;
            int i2 = 0;
            while (i2 != readInt2) {
                int i3 = i2 + min;
                bArr = Arrays.copyOf(bArr, i3);
                dataInputStream.readFully(bArr, i2, min);
                min = Math.min(readInt2 - i3, 10485760);
                i2 = i3;
            }
            hashMap.put(readUTF, bArr);
        }
        return new q(hashMap);
    }

    public static void t(q qVar, DataOutputStream dataOutputStream) {
        Set<Map.Entry> f = qVar.f();
        dataOutputStream.writeInt(f.size());
        for (Map.Entry entry : f) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public final l d(String str) {
        int l = l(this.b);
        l lVar = new l(l, str);
        this.a.put(str, lVar);
        this.b.put(l, str);
        this.d.put(l, true);
        this.e.e(lVar);
        return lVar;
    }

    public void e(String str, p pVar) {
        l m = m(str);
        if (m.b(pVar)) {
            this.e.e(m);
        }
    }

    public int f(String str) {
        return m(str).a;
    }

    public l g(String str) {
        return (l) this.a.get(str);
    }

    public Collection h() {
        return Collections.unmodifiableCollection(this.a.values());
    }

    public o j(String str) {
        l g = g(str);
        return g != null ? g.d() : q.c;
    }

    public String k(int i) {
        return (String) this.b.get(i);
    }

    public l m(String str) {
        l lVar = (l) this.a.get(str);
        return lVar == null ? d(str) : lVar;
    }

    public void n(long j) {
        c cVar;
        this.e.c(j);
        c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.c(j);
        }
        if (this.e.a() || (cVar = this.f) == null || !cVar.a()) {
            this.e.g(this.a, this.b);
        } else {
            this.f.g(this.a, this.b);
            this.e.d(this.a);
        }
        c cVar3 = this.f;
        if (cVar3 != null) {
            cVar3.h();
            this.f = null;
        }
    }

    public void p(String str) {
        l lVar = (l) this.a.get(str);
        if (lVar != null && lVar.g() && lVar.i()) {
            this.a.remove(str);
            int i = lVar.a;
            boolean z = this.d.get(i);
            this.e.f(lVar, z);
            SparseArray sparseArray = this.b;
            if (z) {
                sparseArray.remove(i);
                this.d.delete(i);
            } else {
                sparseArray.put(i, (Object) null);
                this.c.put(i, true);
            }
        }
    }

    public void r() {
        c0 l = C.r(this.a.keySet()).l();
        while (l.hasNext()) {
            p((String) l.next());
        }
    }

    public void s() {
        this.e.b(this.a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }

    public static class b implements c {
        public final boolean a;
        public final Cipher b;
        public final SecretKeySpec c;
        public final SecureRandom d;
        public final d4.b e;
        public boolean f;
        public s g;

        public b(File file, byte[] bArr, boolean z) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            d4.a.g((bArr == null && z) ? false : true);
            if (bArr != null) {
                d4.a.a(bArr.length == 16);
                try {
                    cipher = m.a();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                d4.a.a(!z);
                cipher = null;
                secretKeySpec = null;
            }
            this.a = z;
            this.b = cipher;
            this.c = secretKeySpec;
            this.d = z ? new SecureRandom() : null;
            this.e = new d4.b(file);
        }

        public boolean a() {
            return this.e.c();
        }

        public void b(HashMap hashMap) {
            if (this.f) {
                d(hashMap);
            }
        }

        public void d(HashMap hashMap) {
            m(hashMap);
            this.f = false;
        }

        public void e(l lVar) {
            this.f = true;
        }

        public void f(l lVar, boolean z) {
            this.f = true;
        }

        public void g(HashMap hashMap, SparseArray sparseArray) {
            d4.a.g(!this.f);
            if (k(hashMap, sparseArray)) {
                return;
            }
            hashMap.clear();
            sparseArray.clear();
            this.e.a();
        }

        public void h() {
            this.e.a();
        }

        public final int i(l lVar, int i) {
            int hashCode = (lVar.a * 31) + lVar.b.hashCode();
            if (i >= 2) {
                return (hashCode * 31) + lVar.d().hashCode();
            }
            long a = n.a(lVar.d());
            return (hashCode * 31) + ((int) (a ^ (a >>> 32)));
        }

        public final l j(int i, DataInputStream dataInputStream) {
            q b;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i < 2) {
                long readLong = dataInputStream.readLong();
                p pVar = new p();
                p.g(pVar, readLong);
                b = q.c.e(pVar);
            } else {
                b = m.b(dataInputStream);
            }
            return new l(readInt, readUTF, b);
        }

        public final boolean k(HashMap hashMap, SparseArray sparseArray) {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (!this.e.c()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.e.d());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int readInt = dataInputStream.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.b == null) {
                            k0.o(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.b.init(2, (Key) k0.j(this.c), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.b));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.a) {
                        this.f = true;
                    }
                    int readInt2 = dataInputStream.readInt();
                    int i = 0;
                    for (int i2 = 0; i2 < readInt2; i2++) {
                        l j = j(readInt, dataInputStream);
                        hashMap.put(j.b, j);
                        sparseArray.put(j.a, j.b);
                        i += i(j, readInt);
                    }
                    int readInt3 = dataInputStream.readInt();
                    boolean z = dataInputStream.read() == -1;
                    if (readInt3 == i && z) {
                        k0.o(dataInputStream);
                        return true;
                    }
                    k0.o(dataInputStream);
                    return false;
                }
                k0.o(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    k0.o(dataInputStream2);
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    k0.o(dataInputStream2);
                }
                throw th;
            }
        }

        public final void l(l lVar, DataOutputStream dataOutputStream) {
            dataOutputStream.writeInt(lVar.a);
            dataOutputStream.writeUTF(lVar.b);
            m.c(lVar.d(), dataOutputStream);
        }

        public final void m(HashMap hashMap) {
            s sVar;
            DataOutputStream dataOutputStream;
            DataOutputStream dataOutputStream2 = null;
            try {
                OutputStream f = this.e.f();
                s sVar2 = this.g;
                if (sVar2 == null) {
                    this.g = new s(f);
                } else {
                    sVar2.a(f);
                }
                sVar = this.g;
                dataOutputStream = new DataOutputStream(sVar);
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeInt(2);
                int i = 0;
                dataOutputStream.writeInt(this.a ? 1 : 0);
                if (this.a) {
                    byte[] bArr = new byte[16];
                    ((SecureRandom) k0.j(this.d)).nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        ((Cipher) k0.j(this.b)).init(1, (Key) k0.j(this.c), new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(sVar, this.b));
                    } catch (InvalidAlgorithmParameterException e) {
                        e = e;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(hashMap.size());
                for (l lVar : hashMap.values()) {
                    l(lVar, dataOutputStream);
                    i += i(lVar, 2);
                }
                dataOutputStream.writeInt(i);
                this.e.b(dataOutputStream);
                k0.o(null);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                k0.o(dataOutputStream2);
                throw th;
            }
        }

        public void c(long j) {
        }
    }
}
