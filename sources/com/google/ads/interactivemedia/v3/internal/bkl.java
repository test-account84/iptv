package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bkl {
    public final Object fromJson(Reader reader) throws IOException {
        return read(new boh(reader));
    }

    public final Object fromJsonTree(bjy bjyVar) {
        try {
            return read(new bmc(bjyVar));
        } catch (IOException e) {
            throw new bjz((Throwable) e);
        }
    }

    public final bkl nullSafe() {
        return new bkk(this);
    }

    public abstract Object read(boh bohVar) throws IOException;

    public final String toJson(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, obj);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new bjz((Throwable) e);
        }
    }

    public final bjy toJsonTree(Object obj) {
        try {
            bme bmeVar = new bme();
            write(bmeVar, obj);
            return bmeVar.a();
        } catch (IOException e) {
            throw new bjz((Throwable) e);
        }
    }

    public abstract void write(boj bojVar, Object obj) throws IOException;

    public final Object fromJson(String str) throws IOException {
        return fromJson((Reader) new StringReader(str));
    }

    public final void toJson(Writer writer, Object obj) throws IOException {
        write(new boj(writer), obj);
    }
}
