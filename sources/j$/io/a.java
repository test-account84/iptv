package j$.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class a implements Iterator {
    private final BufferedReader a;
    String b = null;

    a(BufferedReader bufferedReader) {
        this.a = bufferedReader;
    }

    public final boolean hasNext() {
        if (this.b != null) {
            return true;
        }
        try {
            String readLine = this.a.readLine();
            this.b = readLine;
            return readLine != null;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public final Object next() {
        if (this.b == null && !hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.b;
        this.b = null;
        return str;
    }
}
