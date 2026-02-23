package okhttp3.internal.cache;

import E8.e;
import E8.n;
import E8.o;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import k8.c;
import k8.q;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x8.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DiskLruCache implements Closeable, Flushable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;

    @NotNull
    private final File directory;

    @NotNull
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;

    @NotNull
    private final LinkedHashMap lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String JOURNAL_FILE = "journal";

    @NotNull
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";

    @NotNull
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";

    @NotNull
    public static final String MAGIC = "libcore.io.DiskLruCache";

    @NotNull
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;

    @NotNull
    public static final e LEGAL_KEY_PATTERN = new e("[a-z0-9_-]{1,120}");

    @NotNull
    public static final String CLEAN = "CLEAN";

    @NotNull
    public static final String DIRTY = "DIRTY";

    @NotNull
    public static final String REMOVE = "REMOVE";

    @NotNull
    public static final String READ = "READ";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final class Editor {
        private boolean done;

        @NotNull
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;

        @Nullable
        private final boolean[] written;

        public Editor(@NotNull DiskLruCache diskLruCache, Entry entry) {
            l.e(entry, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final void abort() throws IOException {
            synchronized (this.this$0) {
                try {
                    if (!(!this.done)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (l.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    q qVar = q.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void commit() throws IOException {
            synchronized (this.this$0) {
                try {
                    if (!(!this.done)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (l.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    q qVar = q.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void detach$okhttp() {
            if (l.a(this.entry.getCurrentEditor$okhttp(), this)) {
                if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0)) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        @NotNull
        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        @Nullable
        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        @NotNull
        public final Sink newSink(int i) {
            synchronized (this.this$0) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (!l.a(this.entry.getCurrentEditor$okhttp(), this)) {
                    return Okio.blackhole();
                }
                if (!this.entry.getReadable$okhttp()) {
                    boolean[] zArr = this.written;
                    l.b(zArr);
                    zArr[i] = true;
                }
                try {
                    return new FaultHidingSink(this.this$0.getFileSystem$okhttp().sink((File) this.entry.getDirtyFiles$okhttp().get(i)), new DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(this, i));
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                }
            }
        }

        @Nullable
        public final Source newSource(int i) {
            synchronized (this.this$0) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                Source source = null;
                if (!this.entry.getReadable$okhttp() || (!l.a(this.entry.getCurrentEditor$okhttp(), this)) || this.entry.getZombie$okhttp()) {
                    return null;
                }
                try {
                    source = this.this$0.getFileSystem$okhttp().source((File) this.entry.getCleanFiles$okhttp().get(i));
                } catch (FileNotFoundException unused) {
                }
                return source;
            }
        }
    }

    public final class Entry {

        @NotNull
        private final List cleanFiles;

        @Nullable
        private Editor currentEditor;

        @NotNull
        private final List dirtyFiles;

        @NotNull
        private final String key;

        @NotNull
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(@NotNull DiskLruCache diskLruCache, String key) {
            l.e(key, "key");
            this.this$0 = diskLruCache;
            this.key = key;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i = 0; i < valueCount$okhttp; i++) {
                sb.append(i);
                this.cleanFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final Source newSource(int i) {
            Source source = this.this$0.getFileSystem$okhttp().source((File) this.cleanFiles.get(i));
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0)) {
                return source;
            }
            this.lockingSourceCount++;
            return new DiskLruCache$Entry$newSource$1(this, source, source);
        }

        @NotNull
        public final List getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        @Nullable
        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        @NotNull
        public final List getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        @NotNull
        public final String getKey$okhttp() {
            return this.key;
        }

        @NotNull
        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(@Nullable Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(@NotNull List strings) throws IOException {
            l.e(strings, "strings");
            if (strings.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(strings);
                throw new c();
            }
            try {
                int size = ((Collection) strings).size();
                for (int i = 0; i < size; i++) {
                    this.lengths[i] = Long.parseLong((String) strings.get(i));
                }
            } catch (NumberFormatException unused) {
                invalidLengths(strings);
                throw new c();
            }
        }

        public final void setLockingSourceCount$okhttp(int i) {
            this.lockingSourceCount = i;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        @Nullable
        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                l.d(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(diskLruCache);
                throw new AssertionError(sb.toString());
            }
            if (!this.readable) {
                return null;
            }
            if (!DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.lengths.clone();
            try {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i = 0; i < valueCount$okhttp; i++) {
                    arrayList.add(newSource(i));
                }
                return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Util.closeQuietly((Source) it.next());
                }
                try {
                    this.this$0.removeEntry$okhttp(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void writeLengths$okhttp(@NotNull BufferedSink writer) throws IOException {
            l.e(writer, "writer");
            for (long j : this.lengths) {
                writer.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List sources;
        final /* synthetic */ DiskLruCache this$0;

        public Snapshot(@NotNull DiskLruCache diskLruCache, String key, @NotNull long j, @NotNull List sources, long[] lengths) {
            l.e(key, "key");
            l.e(sources, "sources");
            l.e(lengths, "lengths");
            this.this$0 = diskLruCache;
            this.key = key;
            this.sequenceNumber = j;
            this.sources = sources;
            this.lengths = lengths;
        }

        public void close() {
            Iterator it = this.sources.iterator();
            while (it.hasNext()) {
                Util.closeQuietly((Source) it.next());
            }
        }

        @Nullable
        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        @NotNull
        public final Source getSource(int i) {
            return (Source) this.sources.get(i);
        }

        @NotNull
        public final String key() {
            return this.key;
        }
    }

    public static final class 1 implements Iterator, a {
        private final Iterator delegate;
        private Snapshot nextSnapshot;
        private Snapshot removeSnapshot;

        public 1() {
            Iterator it = new ArrayList(DiskLruCache.this.getLruEntries$okhttp().values()).iterator();
            l.d(it, "ArrayList(lruEntries.values).iterator()");
            this.delegate = it;
        }

        public boolean hasNext() {
            Snapshot snapshot$okhttp;
            if (this.nextSnapshot != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.getClosed$okhttp()) {
                    return false;
                }
                while (this.delegate.hasNext()) {
                    Entry entry = (Entry) this.delegate.next();
                    if (entry != null && (snapshot$okhttp = entry.snapshot$okhttp()) != null) {
                        this.nextSnapshot = snapshot$okhttp;
                        return true;
                    }
                }
                q qVar = q.a;
                return false;
            }
        }

        public void remove() {
            Snapshot snapshot = this.removeSnapshot;
            if (snapshot == null) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            try {
                DiskLruCache.this.remove(snapshot.key());
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.removeSnapshot = null;
                throw th;
            }
            this.removeSnapshot = null;
        }

        @NotNull
        public Snapshot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            l.b(snapshot);
            return snapshot;
        }
    }

    public DiskLruCache(@NotNull FileSystem fileSystem, @NotNull File directory, int i, int i2, long j, @NotNull TaskRunner taskRunner) {
        l.e(fileSystem, "fileSystem");
        l.e(directory, "directory");
        l.e(taskRunner, "taskRunner");
        this.fileSystem = fileSystem;
        this.directory = directory;
        this.appVersion = i;
        this.valueCount = i2;
        this.maxSize = j;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new DiskLruCache$cleanupTask$1(this, Util.okHttpName + " Cache");
        if (!(j > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(i2 > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.journalFile = new File(directory, JOURNAL_FILE);
        this.journalFileTmp = new File(directory, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(directory, JOURNAL_FILE_BACKUP);
    }

    public static final /* synthetic */ boolean access$getCivilizedFileSystem$p(DiskLruCache diskLruCache) {
        return diskLruCache.civilizedFileSystem;
    }

    public static final /* synthetic */ boolean access$getHasJournalErrors$p(DiskLruCache diskLruCache) {
        return diskLruCache.hasJournalErrors;
    }

    public static final /* synthetic */ boolean access$getInitialized$p(DiskLruCache diskLruCache) {
        return diskLruCache.initialized;
    }

    public static final /* synthetic */ BufferedSink access$getJournalWriter$p(DiskLruCache diskLruCache) {
        return diskLruCache.journalWriter;
    }

    public static final /* synthetic */ boolean access$getMostRecentRebuildFailed$p(DiskLruCache diskLruCache) {
        return diskLruCache.mostRecentRebuildFailed;
    }

    public static final /* synthetic */ boolean access$getMostRecentTrimFailed$p(DiskLruCache diskLruCache) {
        return diskLruCache.mostRecentTrimFailed;
    }

    public static final /* synthetic */ int access$getRedundantOpCount$p(DiskLruCache diskLruCache) {
        return diskLruCache.redundantOpCount;
    }

    public static final /* synthetic */ boolean access$journalRebuildRequired(DiskLruCache diskLruCache) {
        return diskLruCache.journalRebuildRequired();
    }

    public static final /* synthetic */ void access$setCivilizedFileSystem$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.civilizedFileSystem = z;
    }

    public static final /* synthetic */ void access$setHasJournalErrors$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.hasJournalErrors = z;
    }

    public static final /* synthetic */ void access$setInitialized$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.initialized = z;
    }

    public static final /* synthetic */ void access$setJournalWriter$p(DiskLruCache diskLruCache, BufferedSink bufferedSink) {
        diskLruCache.journalWriter = bufferedSink;
    }

    public static final /* synthetic */ void access$setMostRecentRebuildFailed$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.mostRecentRebuildFailed = z;
    }

    public static final /* synthetic */ void access$setMostRecentTrimFailed$p(DiskLruCache diskLruCache, boolean z) {
        diskLruCache.mostRecentTrimFailed = z;
    }

    public static final /* synthetic */ void access$setRedundantOpCount$p(DiskLruCache diskLruCache, int i) {
        diskLruCache.redundantOpCount = i;
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    private final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            l.d(next, "i.next()");
            Entry entry = (Entry) next;
            int i = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i2 = this.valueCount;
                while (i < i2) {
                    this.size += entry.getLengths$okhttp()[i];
                    i++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i3 = this.valueCount;
                while (i < i3) {
                    this.fileSystem.delete((File) entry.getCleanFiles$okhttp().get(i));
                    this.fileSystem.delete((File) entry.getDirtyFiles$okhttp().get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private final void readJournal() throws IOException {
        BufferedSource buffer = Okio.buffer(this.fileSystem.source(this.journalFile));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if ((!l.a(MAGIC, readUtf8LineStrict)) || (!l.a(VERSION_1, readUtf8LineStrict2)) || (!l.a(String.valueOf(this.appVersion), readUtf8LineStrict3)) || (!l.a(String.valueOf(this.valueCount), readUtf8LineStrict4)) || readUtf8LineStrict5.length() > 0) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + ']');
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
                        rebuildJournal$okhttp();
                    }
                    q qVar = q.a;
                    u8.a.a(buffer, null);
                    return;
                }
            }
        } finally {
        }
    }

    private final void readJournalLine(String str) throws IOException {
        String substring;
        int Q = o.Q(str, ' ', 0, false, 6, null);
        if (Q == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = Q + 1;
        int Q2 = o.Q(str, ' ', i, false, 4, null);
        if (Q2 == -1) {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            substring = str.substring(i);
            l.d(substring, "(this as java.lang.String).substring(startIndex)");
            String str2 = REMOVE;
            if (Q == str2.length() && n.B(str, str2, false, 2, null)) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            substring = str.substring(i, Q2);
            l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        Entry entry = (Entry) this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(this, substring);
            this.lruEntries.put(substring, entry);
        }
        if (Q2 != -1) {
            String str3 = CLEAN;
            if (Q == str3.length() && n.B(str, str3, false, 2, null)) {
                int i2 = Q2 + 1;
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring2 = str.substring(i2);
                l.d(substring2, "(this as java.lang.String).substring(startIndex)");
                List r0 = o.r0(substring2, new char[]{' '}, false, 0, 6, null);
                entry.setReadable$okhttp(true);
                entry.setCurrentEditor$okhttp(null);
                entry.setLengths$okhttp(r0);
                return;
            }
        }
        if (Q2 == -1) {
            String str4 = DIRTY;
            if (Q == str4.length() && n.B(str, str4, false, 2, null)) {
                entry.setCurrentEditor$okhttp(new Editor(this, entry));
                return;
            }
        }
        if (Q2 == -1) {
            String str5 = READ;
            if (Q == str5.length() && n.B(str, str5, false, 2, null)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private final boolean removeOldestEntry() {
        for (Entry toEvict : this.lruEntries.values()) {
            if (!toEvict.getZombie$okhttp()) {
                l.d(toEvict, "toEvict");
                removeEntry$okhttp(toEvict);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.a(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        try {
            if (this.initialized && !this.closed) {
                Collection values = this.lruEntries.values();
                l.d(values, "lruEntries.values");
                Object[] array = values.toArray(new Entry[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                for (Entry entry : (Entry[]) array) {
                    if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                BufferedSink bufferedSink = this.journalWriter;
                l.b(bufferedSink);
                bufferedSink.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void completeEdit$okhttp(@NotNull Editor editor, boolean z) throws IOException {
        l.e(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (!l.a(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (z && !entry$okhttp.getReadable$okhttp()) {
            int i = this.valueCount;
            for (int i2 = 0; i2 < i; i2++) {
                boolean[] written$okhttp = editor.getWritten$okhttp();
                l.b(written$okhttp);
                if (!written$okhttp[i2]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                }
                if (!this.fileSystem.exists((File) entry$okhttp.getDirtyFiles$okhttp().get(i2))) {
                    editor.abort();
                    return;
                }
            }
        }
        int i3 = this.valueCount;
        for (int i4 = 0; i4 < i3; i4++) {
            File file = (File) entry$okhttp.getDirtyFiles$okhttp().get(i4);
            if (!z || entry$okhttp.getZombie$okhttp()) {
                this.fileSystem.delete(file);
            } else if (this.fileSystem.exists(file)) {
                File file2 = (File) entry$okhttp.getCleanFiles$okhttp().get(i4);
                this.fileSystem.rename(file, file2);
                long j = entry$okhttp.getLengths$okhttp()[i4];
                long size = this.fileSystem.size(file2);
                entry$okhttp.getLengths$okhttp()[i4] = size;
                this.size = (this.size - j) + size;
            }
        }
        entry$okhttp.setCurrentEditor$okhttp(null);
        if (entry$okhttp.getZombie$okhttp()) {
            removeEntry$okhttp(entry$okhttp);
            return;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        l.b(bufferedSink);
        if (entry$okhttp.getReadable$okhttp() || z) {
            entry$okhttp.setReadable$okhttp(true);
            bufferedSink.writeUtf8(CLEAN).writeByte(32);
            bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
            entry$okhttp.writeLengths$okhttp(bufferedSink);
            bufferedSink.writeByte(10);
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry$okhttp.setSequenceNumber$okhttp(j2);
            }
        } else {
            this.lruEntries.remove(entry$okhttp.getKey$okhttp());
            bufferedSink.writeUtf8(REMOVE).writeByte(32);
            bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
            bufferedSink.writeByte(10);
        }
        bufferedSink.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    @Nullable
    public final Editor edit(@NotNull String str) throws IOException {
        return edit$default(this, str, 0L, 2, null);
    }

    public final synchronized void evictAll() throws IOException {
        try {
            initialize();
            Collection values = this.lruEntries.values();
            l.d(values, "lruEntries.values");
            Object[] array = values.toArray(new Entry[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            for (Entry entry : (Entry[]) array) {
                l.d(entry, "entry");
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            l.b(bufferedSink);
            bufferedSink.flush();
        }
    }

    @Nullable
    public final synchronized Snapshot get(@NotNull String key) throws IOException {
        l.e(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = (Entry) this.lruEntries.get(key);
        if (entry == null) {
            return null;
        }
        l.d(entry, "lruEntries[key] ?: return null");
        Snapshot snapshot$okhttp = entry.snapshot$okhttp();
        if (snapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        l.b(bufferedSink);
        bufferedSink.writeUtf8(READ).writeByte(32).writeUtf8(key).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshot$okhttp;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    @NotNull
    public final File getDirectory() {
        return this.directory;
    }

    @NotNull
    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    @NotNull
    public final LinkedHashMap getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        try {
            if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                l.d(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(this);
                throw new AssertionError(sb.toString());
            }
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
            this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e) {
                    Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);
                    try {
                        delete();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        try {
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
            try {
                buffer.writeUtf8(MAGIC).writeByte(10);
                buffer.writeUtf8(VERSION_1).writeByte(10);
                buffer.writeDecimalLong(this.appVersion).writeByte(10);
                buffer.writeDecimalLong(this.valueCount).writeByte(10);
                buffer.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.getCurrentEditor$okhttp() != null) {
                        buffer.writeUtf8(DIRTY).writeByte(32);
                        buffer.writeUtf8(entry.getKey$okhttp());
                    } else {
                        buffer.writeUtf8(CLEAN).writeByte(32);
                        buffer.writeUtf8(entry.getKey$okhttp());
                        entry.writeLengths$okhttp(buffer);
                    }
                    buffer.writeByte(10);
                }
                q qVar = q.a;
                u8.a.a(buffer, null);
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.rename(this.journalFile, this.journalFileBackup);
                }
                this.fileSystem.rename(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = newJournalWriter();
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            } finally {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean remove(@NotNull String key) throws IOException {
        l.e(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = (Entry) this.lruEntries.get(key);
        if (entry == null) {
            return false;
        }
        l.d(entry, "lruEntries[key] ?: return false");
        boolean removeEntry$okhttp = removeEntry$okhttp(entry);
        if (removeEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removeEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(@NotNull Entry entry) throws IOException {
        BufferedSink bufferedSink;
        l.e(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (bufferedSink = this.journalWriter) != null) {
                bufferedSink.writeUtf8(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(entry.getKey$okhttp());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.fileSystem.delete((File) entry.getCleanFiles$okhttp().get(i2));
            this.size -= entry.getLengths$okhttp()[i2];
            entry.getLengths$okhttp()[i2] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey$okhttp());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    @NotNull
    public final synchronized Iterator snapshots() throws IOException {
        initialize();
        return new 1();
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    @Nullable
    public final synchronized Editor edit(@NotNull String key, long j) throws IOException {
        l.e(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = (Entry) this.lruEntries.get(key);
        if (j != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != j)) {
            return null;
        }
        if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            BufferedSink bufferedSink = this.journalWriter;
            l.b(bufferedSink);
            bufferedSink.writeUtf8(DIRTY).writeByte(32).writeUtf8(key).writeByte(10);
            bufferedSink.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, key);
                this.lruEntries.put(key, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.setCurrentEditor$okhttp(editor);
            return editor;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        return null;
    }
}
