package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import k8.q;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;

    @NotNull
    public static final ByteString PREFIX_CLEAN;

    @NotNull
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;

    @NotNull
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;

    @Nullable
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;

    @Nullable
    private Source upstream;

    @NotNull
    private final Buffer upstreamBuffer;
    private long upstreamPos;

    @Nullable
    private Thread upstreamReader;

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Relay edit(@NotNull File file, @NotNull Source upstream, @NotNull ByteString metadata, long j) throws IOException {
            l.e(file, "file");
            l.e(upstream, "upstream");
            l.e(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, j, null);
            randomAccessFile.setLength(0L);
            Relay.access$writeHeader(relay, Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        @NotNull
        public final Relay read(@NotNull File file) throws IOException {
            l.e(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            l.d(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0L, buffer, 32L);
            ByteString byteString = Relay.PREFIX_CLEAN;
            if (!l.a(buffer.readByteString(byteString.size()), byteString)) {
                throw new IOException("unreadable cache file");
            }
            long readLong = buffer.readLong();
            long readLong2 = buffer.readLong();
            Buffer buffer2 = new Buffer();
            fileOperator.read(readLong + 32, buffer2, readLong2);
            return new Relay(randomAccessFile, null, readLong, buffer2.readByteString(), 0L, null);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            l.b(file);
            FileChannel channel = file.getChannel();
            l.d(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            Closeable closeable = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                try {
                    Relay.this.setSourceCount(r2.getSourceCount() - 1);
                    if (Relay.this.getSourceCount() == 0) {
                        Closeable file = Relay.this.getFile();
                        Relay.this.setFile(null);
                        closeable = file;
                    }
                    q qVar = q.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (closeable != null) {
                Util.closeQuietly(closeable);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x008e, code lost:
        
            if (r4 != 2) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0090, code lost:
        
            r10 = java.lang.Math.min(r21, r19.this$0.getUpstreamPos() - r19.sourcePos);
            r2 = r19.fileOperator;
            kotlin.jvm.internal.l.b(r2);
            r2.read(r19.sourcePos + 32, r20, r10);
            r19.sourcePos += r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00b0, code lost:
        
            return r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00b2, code lost:
        
            r0 = r19.this$0.getUpstream();
            kotlin.jvm.internal.l.b(r0);
            r14 = r0.read(r19.this$0.getUpstreamBuffer(), r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00cd, code lost:
        
            if (r14 != (-1)) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00cf, code lost:
        
            r0 = r19.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00d8, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00da, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00db, code lost:
        
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00e2, code lost:
        
            if (r0 == null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00e4, code lost:
        
            r0.notifyAll();
            r0 = k8.q.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00e9, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ea, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00f4, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00fa, code lost:
        
            r11 = java.lang.Math.min(r14, r21);
            r19.this$0.getUpstreamBuffer().copyTo(r20, 0, r11);
            r19.sourcePos += r11;
            r13 = r19.fileOperator;
            kotlin.jvm.internal.l.b(r13);
            r13.write(r19.this$0.getUpstreamPos() + 32, r19.this$0.getUpstreamBuffer().clone(), r14);
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0131, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0132, code lost:
        
            r19.this$0.getBuffer().write(r19.this$0.getUpstreamBuffer(), r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0153, code lost:
        
            if (r19.this$0.getBuffer().size() <= r19.this$0.getBufferMaxSize()) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0155, code lost:
        
            r19.this$0.getBuffer().skip(r19.this$0.getBuffer().size() - r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0172, code lost:
        
            r0 = r19.this$0;
            r0.setUpstreamPos(r0.getUpstreamPos() + r14);
            r0 = k8.q.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x017e, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x017f, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0181, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0182, code lost:
        
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0189, code lost:
        
            if (r0 == null) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x018b, code lost:
        
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x018e, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x018f, code lost:
        
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0199, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0170, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x019d, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00f7, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x01a0, code lost:
        
            monitor-enter(r19.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x01a1, code lost:
        
            r19.this$0.setUpstreamReader(null);
            r3 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x01a8, code lost:
        
            if (r3 == null) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x01b1, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x01b4, code lost:
        
            r3.notifyAll();
            r3 = k8.q.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x01ba, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x01b2, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01bc, code lost:
        
            throw r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(@org.jetbrains.annotations.NotNull okio.Buffer r20, long r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 459
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        PREFIX_CLEAN = companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    public static final /* synthetic */ void access$writeHeader(Relay relay, ByteString byteString, long j, long j2) {
        relay.writeHeader(byteString, j, j2);
    }

    private final void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j);
        buffer.writeLong(j2);
        if (!(buffer.size() == 32)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        RandomAccessFile randomAccessFile = this.file;
        l.b(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        l.d(channel, "file!!.channel");
        new FileOperator(channel).write(0L, buffer, 32L);
    }

    private final void writeMetadata(long j) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        l.b(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        l.d(channel, "file!!.channel");
        new FileOperator(channel).write(32 + j, buffer, this.metadata.size());
    }

    public final void commit(long j) throws IOException {
        writeMetadata(j);
        RandomAccessFile randomAccessFile = this.file;
        l.b(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        l.b(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            q qVar = q.a;
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly(source);
        }
        this.upstream = null;
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    @NotNull
    public final ByteString metadata() {
        return this.metadata;
    }

    @Nullable
    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(@Nullable RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i) {
        this.sourceCount = i;
    }

    public final void setUpstream(@Nullable Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j) {
        this.upstreamPos = j;
    }

    public final void setUpstreamReader(@Nullable Thread thread) {
        this.upstreamReader = thread;
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2, g gVar) {
        this(randomAccessFile, source, j, byteString, j2);
    }
}
