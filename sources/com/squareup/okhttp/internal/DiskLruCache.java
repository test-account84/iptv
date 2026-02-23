package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DiskLruCache implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private boolean closed;
    private final File directory;
    private final Executor executor;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;
    private long maxSize;
    private int redundantOpCount;
    private final int valueCount;
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final Sink NULL_SINK = new 4();
    private long size = 0;
    private final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final Runnable cleanupRunnable = new 1();

    public class 1 implements Runnable {
        public 1() {
        }

        public void run() {
            synchronized (DiskLruCache.this) {
                if ((!DiskLruCache.access$000(DiskLruCache.this)) || DiskLruCache.access$100(DiskLruCache.this)) {
                    return;
                }
                try {
                    DiskLruCache.access$200(DiskLruCache.this);
                    if (DiskLruCache.access$300(DiskLruCache.this)) {
                        DiskLruCache.access$400(DiskLruCache.this);
                        DiskLruCache.access$502(DiskLruCache.this, 0);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class 2 extends FaultHidingSink {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public 2(Sink sink) {
            super(sink);
        }

        public void onException(IOException iOException) {
            DiskLruCache.access$602(DiskLruCache.this, true);
        }
    }

    public class 3 implements Iterator {
        final Iterator delegate;
        Snapshot nextSnapshot;
        Snapshot removeSnapshot;

        public 3() {
            this.delegate = new ArrayList(DiskLruCache.access$2000(DiskLruCache.this).values()).iterator();
        }

        public boolean hasNext() {
            if (this.nextSnapshot != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.access$100(DiskLruCache.this)) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        Snapshot snapshot = ((Entry) this.delegate.next()).snapshot();
                        if (snapshot != null) {
                            this.nextSnapshot = snapshot;
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Snapshot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            return snapshot;
        }

        public void remove() {
            Snapshot snapshot = this.removeSnapshot;
            if (snapshot == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                DiskLruCache.this.remove(Snapshot.access$2100(snapshot));
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.removeSnapshot = null;
                throw th;
            }
            this.removeSnapshot = null;
        }
    }

    public static class 4 implements Sink {
        public void close() throws IOException {
        }

        public void flush() throws IOException {
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void write(Buffer buffer, long j) throws IOException {
            buffer.skip(j);
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        private final boolean[] written;

        public class 1 extends FaultHidingSink {
            public 1(Sink sink) {
                super(sink);
            }

            public void onException(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    Editor.access$1902(Editor.this, true);
                }
            }
        }

        private Editor(Entry entry) {
            this.entry = entry;
            this.written = Entry.access$800(entry) ? null : new boolean[DiskLruCache.access$2300(DiskLruCache.this)];
        }

        public static /* synthetic */ Entry access$1700(Editor editor) {
            return editor.entry;
        }

        public static /* synthetic */ boolean[] access$1800(Editor editor) {
            return editor.written;
        }

        public static /* synthetic */ boolean access$1902(Editor editor, boolean z) {
            editor.hasErrors = z;
            return z;
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                DiskLruCache.access$2600(DiskLruCache.this, this, false);
            }
        }

        public void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.committed) {
                    try {
                        DiskLruCache.access$2600(DiskLruCache.this, this, false);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                try {
                    if (this.hasErrors) {
                        DiskLruCache.access$2600(DiskLruCache.this, this, false);
                        DiskLruCache.access$2700(DiskLruCache.this, this.entry);
                    } else {
                        DiskLruCache.access$2600(DiskLruCache.this, this, true);
                    }
                    this.committed = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Sink newSink(int i) throws IOException {
            1 r1;
            synchronized (DiskLruCache.this) {
                try {
                    if (Entry.access$900(this.entry) != this) {
                        throw new IllegalStateException();
                    }
                    if (!Entry.access$800(this.entry)) {
                        this.written[i] = true;
                    }
                    try {
                        r1 = new 1(DiskLruCache.access$2400(DiskLruCache.this).sink(Entry.access$1400(this.entry)[i]));
                    } catch (FileNotFoundException unused) {
                        return DiskLruCache.access$2500();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return r1;
        }

        public Source newSource(int i) throws IOException {
            synchronized (DiskLruCache.this) {
                if (Entry.access$900(this.entry) != this) {
                    throw new IllegalStateException();
                }
                if (!Entry.access$800(this.entry)) {
                    return null;
                }
                try {
                    return DiskLruCache.access$2400(DiskLruCache.this).source(Entry.access$1300(this.entry)[i]);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public /* synthetic */ Editor(DiskLruCache diskLruCache, Entry entry, 1 r3) {
            this(entry);
        }
    }

    public final class Entry {
        private final File[] cleanFiles;
        private Editor currentEditor;
        private final File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.access$2300(DiskLruCache.this)];
            this.cleanFiles = new File[DiskLruCache.access$2300(DiskLruCache.this)];
            this.dirtyFiles = new File[DiskLruCache.access$2300(DiskLruCache.this)];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.access$2300(DiskLruCache.this); i++) {
                sb.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.access$2800(DiskLruCache.this), sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i] = new File(DiskLruCache.access$2800(DiskLruCache.this), sb.toString());
                sb.setLength(length);
            }
        }

        public static /* synthetic */ void access$1000(Entry entry, String[] strArr) throws IOException {
            entry.setLengths(strArr);
        }

        public static /* synthetic */ long[] access$1200(Entry entry) {
            return entry.lengths;
        }

        public static /* synthetic */ File[] access$1300(Entry entry) {
            return entry.cleanFiles;
        }

        public static /* synthetic */ File[] access$1400(Entry entry) {
            return entry.dirtyFiles;
        }

        public static /* synthetic */ String access$1500(Entry entry) {
            return entry.key;
        }

        public static /* synthetic */ long access$1600(Entry entry) {
            return entry.sequenceNumber;
        }

        public static /* synthetic */ long access$1602(Entry entry, long j) {
            entry.sequenceNumber = j;
            return j;
        }

        public static /* synthetic */ boolean access$800(Entry entry) {
            return entry.readable;
        }

        public static /* synthetic */ boolean access$802(Entry entry, boolean z) {
            entry.readable = z;
            return z;
        }

        public static /* synthetic */ Editor access$900(Entry entry) {
            return entry.currentEditor;
        }

        public static /* synthetic */ Editor access$902(Entry entry, Editor editor) {
            entry.currentEditor = editor;
            return editor;
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        private void setLengths(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.access$2300(DiskLruCache.this)) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        public Snapshot snapshot() {
            Source source;
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.access$2300(DiskLruCache.this)];
            long[] jArr = (long[]) this.lengths.clone();
            for (int i = 0; i < DiskLruCache.access$2300(DiskLruCache.this); i++) {
                try {
                    sourceArr[i] = DiskLruCache.access$2400(DiskLruCache.this).source(this.cleanFiles[i]);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < DiskLruCache.access$2300(DiskLruCache.this) && (source = sourceArr[i2]) != null; i2++) {
                        Util.closeQuietly(source);
                    }
                    return null;
                }
            }
            return new Snapshot(DiskLruCache.this, this.key, this.sequenceNumber, sourceArr, jArr, null);
        }

        public void writeLengths(BufferedSink bufferedSink) throws IOException {
            for (long j : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }

        public /* synthetic */ Entry(DiskLruCache diskLruCache, String str, 1 r3) {
            this(str);
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        private Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public static /* synthetic */ String access$2100(Snapshot snapshot) {
            return snapshot.key;
        }

        public void close() {
            for (Source source : this.sources) {
                Util.closeQuietly(source);
            }
        }

        public Editor edit() throws IOException {
            return DiskLruCache.access$2200(DiskLruCache.this, this.key, this.sequenceNumber);
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public Source getSource(int i) {
            return this.sources[i];
        }

        public String key() {
            return this.key;
        }

        public /* synthetic */ Snapshot(DiskLruCache diskLruCache, String str, long j, Source[] sourceArr, long[] jArr, 1 r7) {
            this(str, j, sourceArr, jArr);
        }
    }

    public DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    public static /* synthetic */ boolean access$000(DiskLruCache diskLruCache) {
        return diskLruCache.initialized;
    }

    public static /* synthetic */ boolean access$100(DiskLruCache diskLruCache) {
        return diskLruCache.closed;
    }

    public static /* synthetic */ void access$200(DiskLruCache diskLruCache) throws IOException {
        diskLruCache.trimToSize();
    }

    public static /* synthetic */ LinkedHashMap access$2000(DiskLruCache diskLruCache) {
        return diskLruCache.lruEntries;
    }

    public static /* synthetic */ Editor access$2200(DiskLruCache diskLruCache, String str, long j) throws IOException {
        return diskLruCache.edit(str, j);
    }

    public static /* synthetic */ int access$2300(DiskLruCache diskLruCache) {
        return diskLruCache.valueCount;
    }

    public static /* synthetic */ FileSystem access$2400(DiskLruCache diskLruCache) {
        return diskLruCache.fileSystem;
    }

    public static /* synthetic */ Sink access$2500() {
        return NULL_SINK;
    }

    public static /* synthetic */ void access$2600(DiskLruCache diskLruCache, Editor editor, boolean z) throws IOException {
        diskLruCache.completeEdit(editor, z);
    }

    public static /* synthetic */ boolean access$2700(DiskLruCache diskLruCache, Entry entry) throws IOException {
        return diskLruCache.removeEntry(entry);
    }

    public static /* synthetic */ File access$2800(DiskLruCache diskLruCache) {
        return diskLruCache.directory;
    }

    public static /* synthetic */ boolean access$300(DiskLruCache diskLruCache) {
        return diskLruCache.journalRebuildRequired();
    }

    public static /* synthetic */ void access$400(DiskLruCache diskLruCache) throws IOException {
        diskLruCache.rebuildJournal();
    }

    public static /* synthetic */ int access$502(DiskLruCache diskLruCache, int i) {
        diskLruCache.redundantOpCount = i;
        return i;
    }

    public static /* synthetic */ boolean access$602(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.hasJournalErrors = z;
        return z;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        Entry access$1700 = Editor.access$1700(editor);
        if (Entry.access$900(access$1700) != editor) {
            throw new IllegalStateException();
        }
        if (z && !Entry.access$800(access$1700)) {
            for (int i = 0; i < this.valueCount; i++) {
                if (!Editor.access$1800(editor)[i]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.fileSystem.exists(Entry.access$1400(access$1700)[i])) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            File file = Entry.access$1400(access$1700)[i2];
            if (!z) {
                this.fileSystem.delete(file);
            } else if (this.fileSystem.exists(file)) {
                File file2 = Entry.access$1300(access$1700)[i2];
                this.fileSystem.rename(file, file2);
                long j = Entry.access$1200(access$1700)[i2];
                long size = this.fileSystem.size(file2);
                Entry.access$1200(access$1700)[i2] = size;
                this.size = (this.size - j) + size;
            }
        }
        this.redundantOpCount++;
        Entry.access$902(access$1700, null);
        if (Entry.access$800(access$1700) || z) {
            Entry.access$802(access$1700, true);
            this.journalWriter.writeUtf8("CLEAN").writeByte(32);
            this.journalWriter.writeUtf8(Entry.access$1500(access$1700));
            access$1700.writeLengths(this.journalWriter);
            this.journalWriter.writeByte(10);
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                Entry.access$1602(access$1700, j2);
            }
        } else {
            this.lruEntries.remove(Entry.access$1500(access$1700));
            this.journalWriter.writeUtf8("REMOVE").writeByte(32);
            this.journalWriter.writeUtf8(Entry.access$1500(access$1700));
            this.journalWriter.writeByte(10);
        }
        this.journalWriter.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer(new 2(this.fileSystem.appendingSink(this.journalFile)));
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (Entry.access$900(entry) == null) {
                while (i < this.valueCount) {
                    this.size += Entry.access$1200(entry)[i];
                    i++;
                }
            } else {
                Entry.access$902(entry, null);
                while (i < this.valueCount) {
                    this.fileSystem.delete(Entry.access$1300(entry)[i]);
                    this.fileSystem.delete(Entry.access$1400(entry)[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private void readJournal() throws IOException {
        BufferedSource buffer = Okio.buffer(this.fileSystem.source(this.journalFile));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.appVersion).equals(readUtf8LineStrict3) || !Integer.toString(this.valueCount).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(buffer.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (buffer.exhausted()) {
                        this.journalWriter = newJournalWriter();
                    } else {
                        rebuildJournal();
                    }
                    Util.closeQuietly(buffer);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(buffer);
            throw th;
        }
    }

    private void readJournalLine(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        Entry entry = (Entry) this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(this, substring, null);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            Entry.access$802(entry, true);
            Entry.access$902(entry, null);
            Entry.access$1000(entry, split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            Entry.access$902(entry, new Editor(this, entry, null));
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private synchronized void rebuildJournal() throws IOException {
        try {
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
            try {
                buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                buffer.writeUtf8("1").writeByte(10);
                buffer.writeDecimalLong(this.appVersion).writeByte(10);
                buffer.writeDecimalLong(this.valueCount).writeByte(10);
                buffer.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (Entry.access$900(entry) != null) {
                        buffer.writeUtf8("DIRTY").writeByte(32);
                        buffer.writeUtf8(Entry.access$1500(entry));
                    } else {
                        buffer.writeUtf8("CLEAN").writeByte(32);
                        buffer.writeUtf8(Entry.access$1500(entry));
                        entry.writeLengths(buffer);
                    }
                    buffer.writeByte(10);
                }
                buffer.close();
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.rename(this.journalFile, this.journalFileBackup);
                }
                this.fileSystem.rename(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = newJournalWriter();
                this.hasJournalErrors = false;
            } catch (Throwable th) {
                buffer.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private boolean removeEntry(Entry entry) throws IOException {
        if (Entry.access$900(entry) != null) {
            Editor.access$1902(Entry.access$900(entry), true);
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(Entry.access$1300(entry)[i]);
            this.size -= Entry.access$1200(entry)[i];
            Entry.access$1200(entry)[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(Entry.access$1500(entry)).writeByte(10);
        this.lruEntries.remove(Entry.access$1500(entry));
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry((Entry) this.lruEntries.values().iterator().next());
        }
    }

    private void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized void close() throws IOException {
        try {
            if (this.initialized && !this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                    if (Entry.access$900(entry) != null) {
                        Entry.access$900(entry).abort();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public Editor edit(String str) throws IOException {
        return edit(str, -1L);
    }

    public synchronized void evictAll() throws IOException {
        initialize();
        for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
            removeEntry(entry);
        }
    }

    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    public synchronized Snapshot get(String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry != null && Entry.access$800(entry)) {
            Snapshot snapshot = entry.snapshot();
            if (snapshot == null) {
                return null;
            }
            this.redundantOpCount++;
            this.journalWriter.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
            if (journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
            return snapshot;
        }
        return null;
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void initialize() throws IOException {
        try {
            if (this.initialized) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e) {
                    Platform.get().logW("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing");
                    delete();
                    this.closed = false;
                }
            }
            rebuildJournal();
            this.initialized = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    public synchronized boolean remove(String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        return removeEntry(entry);
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public synchronized Iterator snapshots() throws IOException {
        initialize();
        return new 3();
    }

    private synchronized Editor edit(String str, long j) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (j != -1 && (entry == null || Entry.access$1600(entry) != j)) {
            return null;
        }
        if (entry != null && Entry.access$900(entry) != null) {
            return null;
        }
        this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
        this.journalWriter.flush();
        if (this.hasJournalErrors) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(this, str, null);
            this.lruEntries.put(str, entry);
        }
        Editor editor = new Editor(this, entry, null);
        Entry.access$902(entry, editor);
        return editor;
    }
}
