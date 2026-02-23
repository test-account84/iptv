package C0;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i implements G0.c {
    public final Context a;
    public final String c;
    public final File d;
    public final int e;
    public final G0.c f;
    public a g;
    public boolean h;

    public i(Context context, String str, File file, int i, G0.c cVar) {
        this.a = context;
        this.c = str;
        this.d = file;
        this.e = i;
        this.f = cVar;
    }

    public final void a(File file) {
        ReadableByteChannel channel;
        if (this.c != null) {
            channel = Channels.newChannel(this.a.getAssets().open(this.c));
        } else {
            if (this.d == null) {
                throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            }
            channel = new FileInputStream(this.d).getChannel();
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.a.getCacheDir());
        createTempFile.deleteOnExit();
        E0.d.a(channel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    public void c(a aVar) {
        this.g = aVar;
    }

    public synchronized void close() {
        this.f.close();
        this.h = false;
    }

    public final void d() {
        String databaseName = getDatabaseName();
        File databasePath = this.a.getDatabasePath(databaseName);
        a aVar = this.g;
        E0.a aVar2 = new E0.a(databaseName, this.a.getFilesDir(), aVar == null || aVar.j);
        try {
            aVar2.b();
            if (!databasePath.exists()) {
                try {
                    a(databasePath);
                    aVar2.c();
                    return;
                } catch (IOException e) {
                    throw new RuntimeException("Unable to copy database file.", e);
                }
            }
            if (this.g == null) {
                aVar2.c();
                return;
            }
            try {
                int c = E0.c.c(databasePath);
                int i = this.e;
                if (c == i) {
                    aVar2.c();
                    return;
                }
                if (this.g.a(c, i)) {
                    aVar2.c();
                    return;
                }
                if (this.a.deleteDatabase(databaseName)) {
                    try {
                        a(databasePath);
                    } catch (IOException e2) {
                        Log.w("ROOM", "Unable to copy database file.", e2);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                aVar2.c();
                return;
            } catch (IOException e3) {
                Log.w("ROOM", "Unable to read database version.", e3);
                aVar2.c();
                return;
            }
        } catch (Throwable th) {
            aVar2.c();
            throw th;
        }
        aVar2.c();
        throw th;
    }

    public String getDatabaseName() {
        return this.f.getDatabaseName();
    }

    public synchronized G0.b getWritableDatabase() {
        try {
            if (!this.h) {
                d();
                this.h = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f.getWritableDatabase();
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f.setWriteAheadLoggingEnabled(z);
    }
}
