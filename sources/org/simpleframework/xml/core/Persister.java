package org.simpleframework.xml.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeBuilder;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.Matcher;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Persister implements Serializer {
    private final Format format;
    private final SessionManager manager;
    private final Strategy strategy;
    private final Support support;

    public Persister() {
        this((Map) new HashMap());
    }

    public Object read(Class cls, File file) throws Exception {
        return read(cls, file, true);
    }

    public boolean validate(Class cls, File file) throws Exception {
        return validate(cls, file, true);
    }

    public void write(Object obj, File file) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            write(obj, (OutputStream) fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    public Persister(Map map) {
        this(new PlatformFilter(map));
    }

    public Object read(Class cls, File file, boolean z) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return read(cls, (InputStream) fileInputStream, z);
        } finally {
            fileInputStream.close();
        }
    }

    public boolean validate(Class cls, File file, boolean z) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return validate(cls, (InputStream) fileInputStream, z);
        } finally {
            fileInputStream.close();
        }
    }

    public void write(Object obj, OutputStream outputStream) throws Exception {
        write(obj, outputStream, "utf-8");
    }

    public Persister(Map map, Format format) {
        this(new PlatformFilter(map));
    }

    public Object read(Class cls, InputStream inputStream) throws Exception {
        return read(cls, inputStream, true);
    }

    public boolean validate(Class cls, InputStream inputStream) throws Exception {
        return validate(cls, inputStream, true);
    }

    public void write(Object obj, OutputStream outputStream, String str) throws Exception {
        write(obj, (Writer) new OutputStreamWriter(outputStream, str));
    }

    public Persister(Filter filter) {
        this(new TreeStrategy(), filter);
    }

    public Object read(Class cls, InputStream inputStream, boolean z) throws Exception {
        return read(cls, NodeBuilder.read(inputStream), z);
    }

    public boolean validate(Class cls, InputStream inputStream, boolean z) throws Exception {
        return validate(cls, NodeBuilder.read(inputStream), z);
    }

    public void write(Object obj, Writer writer) throws Exception {
        write(obj, NodeBuilder.write(writer, this.format));
    }

    public Persister(Filter filter, Format format) {
        this(new TreeStrategy(), filter, format);
    }

    public Object read(Class cls, Reader reader) throws Exception {
        return read(cls, reader, true);
    }

    public boolean validate(Class cls, Reader reader) throws Exception {
        return validate(cls, reader, true);
    }

    public void write(Object obj, OutputNode outputNode) throws Exception {
        try {
            write(obj, outputNode, this.manager.open());
        } finally {
            this.manager.close();
        }
    }

    public Persister(Filter filter, Matcher matcher) {
        this(new TreeStrategy(), filter, matcher);
    }

    private void write(Object obj, OutputNode outputNode, Context context) throws Exception {
        new Traverser(context).write(outputNode, obj);
    }

    public Object read(Class cls, Reader reader, boolean z) throws Exception {
        return read(cls, NodeBuilder.read(reader), z);
    }

    public boolean validate(Class cls, Reader reader, boolean z) throws Exception {
        return validate(cls, NodeBuilder.read(reader), z);
    }

    public Persister(Filter filter, Matcher matcher, Format format) {
        this(new TreeStrategy(), filter, matcher, format);
    }

    private void write(Object obj, OutputNode outputNode, Session session) throws Exception {
        write(obj, outputNode, new Source(this.strategy, this.support, session));
    }

    public Object read(Class cls, String str) throws Exception {
        return read(cls, str, true);
    }

    public boolean validate(Class cls, String str) throws Exception {
        return validate(cls, str, true);
    }

    public Persister(Strategy strategy) {
        this(strategy, (Map) new HashMap());
    }

    public Object read(Class cls, String str, boolean z) throws Exception {
        return read(cls, (Reader) new StringReader(str), z);
    }

    public boolean validate(Class cls, String str, boolean z) throws Exception {
        return validate(cls, (Reader) new StringReader(str), z);
    }

    public Persister(Strategy strategy, Map map) {
        this(strategy, new PlatformFilter(map));
    }

    public Object read(Class cls, InputNode inputNode) throws Exception {
        return read(cls, inputNode, true);
    }

    public boolean validate(Class cls, InputNode inputNode) throws Exception {
        return validate(cls, inputNode, true);
    }

    public Persister(Strategy strategy, Map map, Format format) {
        this(strategy, new PlatformFilter(map), format);
    }

    private Object read(Class cls, InputNode inputNode, Context context) throws Exception {
        return new Traverser(context).read(inputNode, cls);
    }

    private boolean validate(Class cls, InputNode inputNode, Context context) throws Exception {
        return new Traverser(context).validate(inputNode, cls);
    }

    public Persister(Strategy strategy, Filter filter) {
        this(strategy, filter, new Format());
    }

    private Object read(Class cls, InputNode inputNode, Session session) throws Exception {
        return read(cls, inputNode, (Context) new Source(this.strategy, this.support, session));
    }

    private boolean validate(Class cls, InputNode inputNode, Session session) throws Exception {
        return validate(cls, inputNode, new Source(this.strategy, this.support, session));
    }

    public Persister(Strategy strategy, Filter filter, Format format) {
        this(strategy, filter, new EmptyMatcher(), format);
    }

    public Object read(Class cls, InputNode inputNode, boolean z) throws Exception {
        try {
            return read(cls, inputNode, this.manager.open(z));
        } finally {
            this.manager.close();
        }
    }

    public boolean validate(Class cls, InputNode inputNode, boolean z) throws Exception {
        try {
            return validate(cls, inputNode, this.manager.open(z));
        } finally {
            this.manager.close();
        }
    }

    public Persister(Strategy strategy, Filter filter, Matcher matcher) {
        this(strategy, filter, matcher, new Format());
    }

    public Object read(Object obj, File file) throws Exception {
        return read(obj, file, true);
    }

    public Persister(Strategy strategy, Filter filter, Matcher matcher, Format format) {
        this.support = new Support(filter, matcher, format);
        this.manager = new SessionManager();
        this.strategy = strategy;
        this.format = format;
    }

    public Object read(Object obj, File file, boolean z) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return read(obj, (InputStream) fileInputStream, z);
        } finally {
            fileInputStream.close();
        }
    }

    public Persister(Strategy strategy, Format format) {
        this(strategy, (Map) new HashMap(), format);
    }

    public Object read(Object obj, InputStream inputStream) throws Exception {
        return read(obj, inputStream, true);
    }

    public Persister(Strategy strategy, Matcher matcher) {
        this(strategy, new PlatformFilter(), matcher);
    }

    public Object read(Object obj, InputStream inputStream, boolean z) throws Exception {
        return read(obj, NodeBuilder.read(inputStream), z);
    }

    public Persister(Strategy strategy, Matcher matcher, Format format) {
        this(strategy, new PlatformFilter(), matcher, format);
    }

    public Object read(Object obj, Reader reader) throws Exception {
        return read(obj, reader, true);
    }

    public Persister(Format format) {
        this(new TreeStrategy(), format);
    }

    public Object read(Object obj, Reader reader, boolean z) throws Exception {
        return read(obj, NodeBuilder.read(reader), z);
    }

    public Persister(Matcher matcher) {
        this(new TreeStrategy(), matcher);
    }

    public Object read(Object obj, String str) throws Exception {
        return read(obj, str, true);
    }

    public Persister(Matcher matcher, Format format) {
        this(new TreeStrategy(), matcher, format);
    }

    public Object read(Object obj, String str, boolean z) throws Exception {
        return read(obj, (Reader) new StringReader(str), z);
    }

    public Object read(Object obj, InputNode inputNode) throws Exception {
        return read(obj, inputNode, true);
    }

    private Object read(Object obj, InputNode inputNode, Context context) throws Exception {
        return new Traverser(context).read(inputNode, obj);
    }

    private Object read(Object obj, InputNode inputNode, Session session) throws Exception {
        return read(obj, inputNode, new Source(this.strategy, this.support, session));
    }

    public Object read(Object obj, InputNode inputNode, boolean z) throws Exception {
        try {
            return read(obj, inputNode, this.manager.open(z));
        } finally {
            this.manager.close();
        }
    }
}
