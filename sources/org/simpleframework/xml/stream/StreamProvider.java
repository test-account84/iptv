package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class StreamProvider implements Provider {
    private final XMLInputFactory factory = XMLInputFactory.newInstance();

    public EventReader provide(InputStream inputStream) throws Exception {
        return provide(this.factory.createXMLEventReader(inputStream));
    }

    public EventReader provide(Reader reader) throws Exception {
        return provide(this.factory.createXMLEventReader(reader));
    }

    private EventReader provide(XMLEventReader xMLEventReader) throws Exception {
        return new StreamReader(xMLEventReader);
    }
}
