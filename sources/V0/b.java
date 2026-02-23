package v0;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements Closeable {
    public final File a;
    public final long c;
    public final File d;
    public final RandomAccessFile e;
    public final FileChannel f;
    public final FileLock g;

    public class a implements FileFilter {
        public a() {
        }

        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    public static class b extends File {
        public long a;

        public b(File file, String str) {
            super(file, str);
            this.a = -1L;
        }
    }

    public b(File file, File file2) {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.a = file;
        this.d = file2;
        this.c = h(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.e = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.g = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e) {
                e = e;
                c(this.f);
                throw e;
            } catch (Error e2) {
                e = e2;
                c(this.f);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                c(this.f);
                throw e;
            }
        } catch (Error e4) {
            e = e4;
            c(this.e);
            throw e;
        } catch (IOException e5) {
            e = e5;
            c(this.e);
            throw e;
        } catch (RuntimeException e6) {
            e = e6;
            c(this.e);
            throw e;
        }
    }

    public static void c(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    public static void d(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        zipOutputStream.write(bArr, 0, read);
                    }
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!createTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    c(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            c(inputStream);
            createTempFile.delete();
            throw th2;
        }
    }

    public static SharedPreferences e(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    public static long g(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    public static long h(File file) {
        long c = c.c(file);
        return c == -1 ? c - 1 : c;
    }

    public static boolean i(Context context, File file, long j, String str) {
        SharedPreferences e = e(context);
        if (e.getLong(str + "timestamp", -1L) == g(file)) {
            if (e.getLong(str + "crc", -1L) == j) {
                return false;
            }
        }
        return true;
    }

    public static void m(Context context, String str, long j, long j2, List list) {
        SharedPreferences.Editor edit = e(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        Iterator it = list.iterator();
        int i = 2;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            edit.putLong(str + "dex.crc." + i, bVar.a);
            edit.putLong(str + "dex.time." + i, bVar.lastModified());
            i++;
        }
        edit.commit();
    }

    public final void a() {
        File[] listFiles = this.d.listFiles(new a());
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.d.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    public void close() {
        this.g.release();
        this.f.close();
        this.e.close();
    }

    public List j(Context context, String str, boolean z) {
        List list;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.a.getPath() + ", " + z + ", " + str + ")");
        if (!this.g.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z && !i(context, this.a, this.c, str)) {
            try {
                list = k(context, str);
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
            }
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        Log.i("MultiDex", z ? "Forced extraction must be performed." : "Detected that extraction must be performed.");
        List l = l();
        m(context, str, g(this.a), this.c, l);
        list = l;
        Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
        return list;
    }

    public final List k(Context context, String str) {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.a.getName() + ".classes";
        SharedPreferences e = e(context);
        int i = e.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + (-1));
        int i2 = 2;
        while (i2 <= i) {
            b bVar = new b(this.d, str2 + i2 + ".zip");
            if (!bVar.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + bVar.getPath() + "'");
            }
            bVar.a = h(bVar);
            long j = e.getLong(str + "dex.crc." + i2, -1L);
            long j2 = e.getLong(str + "dex.time." + i2, -1L);
            long lastModified = bVar.lastModified();
            if (j2 == lastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = e;
                if (j == bVar.a) {
                    arrayList.add(bVar);
                    i2++;
                    e = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + bVar + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + bVar.a);
        }
        return arrayList;
    }

    public final List l() {
        boolean z;
        String str = this.a.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.a);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i = 2;
            while (entry != null) {
                b bVar = new b(this.d, str + i + ".zip");
                arrayList.add(bVar);
                Log.i("MultiDex", "Extraction is needed for file " + bVar);
                int i2 = 0;
                boolean z2 = false;
                while (i2 < 3 && !z2) {
                    int i3 = i2 + 1;
                    d(zipFile, entry, bVar, str);
                    try {
                        bVar.a = h(bVar);
                        z = true;
                    } catch (IOException e) {
                        Log.w("MultiDex", "Failed to read crc from " + bVar.getAbsolutePath(), e);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(bVar.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(bVar.length());
                    sb.append(" - crc: ");
                    sb.append(bVar.a);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        bVar.delete();
                        if (bVar.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + bVar.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i2 = i3;
                }
                if (!z2) {
                    throw new IOException("Could not create zip file " + bVar.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                i++;
                entry = zipFile.getEntry("classes" + i + ".dex");
            }
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
            return arrayList;
        } finally {
        }
    }
}
