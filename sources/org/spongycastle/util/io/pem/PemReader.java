package org.spongycastle.util.io.pem;

import j$.io.BufferedReaderRetargetInterface;
import j$.io.DesugarBufferedReader;
import j$.util.stream.Stream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.spongycastle.util.encoders.Base64;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PemReader extends BufferedReader implements BufferedReaderRetargetInterface {
    private static final String BEGIN = "-----BEGIN ";
    private static final String END = "-----END ";

    public PemReader(Reader reader) {
        super(reader);
    }

    private PemObject loadObject(String str) throws IOException {
        String readLine;
        String str2 = "-----END " + str;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        while (true) {
            readLine = readLine();
            if (readLine == null) {
                break;
            }
            if (readLine.indexOf(":") >= 0) {
                int indexOf = readLine.indexOf(58);
                arrayList.add(new PemHeader(readLine.substring(0, indexOf), readLine.substring(indexOf + 1).trim()));
            } else {
                if (readLine.indexOf(str2) != -1) {
                    break;
                }
                sb.append(readLine.trim());
            }
        }
        if (readLine != null) {
            return new PemObject(str, arrayList, Base64.decode(sb.toString()));
        }
        throw new IOException(str2 + " not found");
    }

    public /* synthetic */ Stream lines() {
        return Stream.Wrapper.convert(lines());
    }

    public PemObject readPemObject() throws IOException {
        String readLine;
        do {
            readLine = readLine();
            if (readLine == null) {
                break;
            }
        } while (!readLine.startsWith("-----BEGIN "));
        if (readLine == null) {
            return null;
        }
        String substring = readLine.substring(11);
        int indexOf = substring.indexOf(45);
        String substring2 = substring.substring(0, indexOf);
        if (indexOf > 0) {
            return loadObject(substring2);
        }
        return null;
    }

    public /* synthetic */ j$.util.stream.Stream lines() {
        return DesugarBufferedReader.lines(this);
    }
}
