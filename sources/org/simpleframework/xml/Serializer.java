package org.simpleframework.xml;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Serializer {
    Object read(Class cls, File file) throws Exception;

    Object read(Class cls, File file, boolean z) throws Exception;

    Object read(Class cls, InputStream inputStream) throws Exception;

    Object read(Class cls, InputStream inputStream, boolean z) throws Exception;

    Object read(Class cls, Reader reader) throws Exception;

    Object read(Class cls, Reader reader, boolean z) throws Exception;

    Object read(Class cls, String str) throws Exception;

    Object read(Class cls, String str, boolean z) throws Exception;

    Object read(Class cls, InputNode inputNode) throws Exception;

    Object read(Class cls, InputNode inputNode, boolean z) throws Exception;

    Object read(Object obj, File file) throws Exception;

    Object read(Object obj, File file, boolean z) throws Exception;

    Object read(Object obj, InputStream inputStream) throws Exception;

    Object read(Object obj, InputStream inputStream, boolean z) throws Exception;

    Object read(Object obj, Reader reader) throws Exception;

    Object read(Object obj, Reader reader, boolean z) throws Exception;

    Object read(Object obj, String str) throws Exception;

    Object read(Object obj, String str, boolean z) throws Exception;

    Object read(Object obj, InputNode inputNode) throws Exception;

    Object read(Object obj, InputNode inputNode, boolean z) throws Exception;

    boolean validate(Class cls, File file) throws Exception;

    boolean validate(Class cls, File file, boolean z) throws Exception;

    boolean validate(Class cls, InputStream inputStream) throws Exception;

    boolean validate(Class cls, InputStream inputStream, boolean z) throws Exception;

    boolean validate(Class cls, Reader reader) throws Exception;

    boolean validate(Class cls, Reader reader, boolean z) throws Exception;

    boolean validate(Class cls, String str) throws Exception;

    boolean validate(Class cls, String str, boolean z) throws Exception;

    boolean validate(Class cls, InputNode inputNode) throws Exception;

    boolean validate(Class cls, InputNode inputNode, boolean z) throws Exception;

    void write(Object obj, File file) throws Exception;

    void write(Object obj, OutputStream outputStream) throws Exception;

    void write(Object obj, Writer writer) throws Exception;

    void write(Object obj, OutputNode outputNode) throws Exception;
}
