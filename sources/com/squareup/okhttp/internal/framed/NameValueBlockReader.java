package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class NameValueBlockReader {
    private int compressedLimit;
    private final InflaterSource inflaterSource;
    private final BufferedSource source;

    public class 1 extends ForwardingSource {
        public 1(Source source) {
            super(source);
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (NameValueBlockReader.access$000(NameValueBlockReader.this) == 0) {
                return -1L;
            }
            long read = super.read(buffer, Math.min(j, NameValueBlockReader.access$000(NameValueBlockReader.this)));
            if (read == -1) {
                return -1L;
            }
            NameValueBlockReader.access$002(NameValueBlockReader.this, (int) (NameValueBlockReader.access$000(r8) - read));
            return read;
        }
    }

    public class 2 extends Inflater {
        public 2() {
        }

        public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
            int inflate = super.inflate(bArr, i, i2);
            if (inflate != 0 || !needsDictionary()) {
                return inflate;
            }
            setDictionary(Spdy3.DICTIONARY);
            return super.inflate(bArr, i, i2);
        }
    }

    public NameValueBlockReader(BufferedSource bufferedSource) {
        InflaterSource inflaterSource = new InflaterSource(new 1(bufferedSource), new 2());
        this.inflaterSource = inflaterSource;
        this.source = Okio.buffer(inflaterSource);
    }

    public static /* synthetic */ int access$000(NameValueBlockReader nameValueBlockReader) {
        return nameValueBlockReader.compressedLimit;
    }

    public static /* synthetic */ int access$002(NameValueBlockReader nameValueBlockReader, int i) {
        nameValueBlockReader.compressedLimit = i;
        return i;
    }

    private void doneReading() throws IOException {
        if (this.compressedLimit > 0) {
            this.inflaterSource.refill();
            if (this.compressedLimit == 0) {
                return;
            }
            throw new IOException("compressedLimit > 0: " + this.compressedLimit);
        }
    }

    private ByteString readByteString() throws IOException {
        return this.source.readByteString(this.source.readInt());
    }

    public void close() throws IOException {
        this.source.close();
    }

    public List readNameValueBlock(int i) throws IOException {
        this.compressedLimit += i;
        int readInt = this.source.readInt();
        if (readInt < 0) {
            throw new IOException("numberOfPairs < 0: " + readInt);
        }
        if (readInt > 1024) {
            throw new IOException("numberOfPairs > 1024: " + readInt);
        }
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            ByteString asciiLowercase = readByteString().toAsciiLowercase();
            ByteString readByteString = readByteString();
            if (asciiLowercase.size() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add(new Header(asciiLowercase, readByteString));
        }
        doneReading();
        return arrayList;
    }
}
