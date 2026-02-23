package com.google.ads.interactivemedia.v3.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class qj {
    private final BufferedReader a;
    private final Queue b;
    private String c;

    public qj(Queue queue, BufferedReader bufferedReader) {
        this.b = queue;
        this.a = bufferedReader;
    }

    public final String a() throws IOException {
        if (!b()) {
            throw new NoSuchElementException();
        }
        String str = this.c;
        this.c = null;
        return str;
    }

    public final boolean b() throws IOException {
        String trim;
        if (this.c != null) {
            return true;
        }
        if (!this.b.isEmpty()) {
            String str = (String) this.b.poll();
            af.s(str);
            this.c = str;
            return true;
        }
        do {
            String readLine = this.a.readLine();
            this.c = readLine;
            if (readLine == null) {
                return false;
            }
            trim = readLine.trim();
            this.c = trim;
        } while (trim.isEmpty());
        return true;
    }
}
