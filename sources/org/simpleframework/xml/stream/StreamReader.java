package org.simpleframework.xml.stream;

import java.util.Iterator;
import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class StreamReader implements EventReader {
    private EventNode peek;
    private XMLEventReader reader;

    public static class End extends EventToken {
        private End() {
        }

        public boolean isEnd() {
            return true;
        }

        public /* synthetic */ End(1 r1) {
            this();
        }
    }

    public static class Entry extends EventAttribute {
        private final javax.xml.stream.events.Attribute entry;

        public Entry(javax.xml.stream.events.Attribute attribute) {
            this.entry = attribute;
        }

        public String getName() {
            return this.entry.getName().getLocalPart();
        }

        public String getPrefix() {
            return this.entry.getName().getPrefix();
        }

        public String getReference() {
            return this.entry.getName().getNamespaceURI();
        }

        public Object getSource() {
            return this.entry;
        }

        public String getValue() {
            return this.entry.getValue();
        }

        public boolean isReserved() {
            return false;
        }
    }

    public static class Start extends EventElement {
        private final StartElement element;
        private final Location location;

        public Start(XMLEvent xMLEvent) {
            this.element = xMLEvent.asStartElement();
            this.location = xMLEvent.getLocation();
        }

        public Iterator getAttributes() {
            return this.element.getAttributes();
        }

        public int getLine() {
            return this.location.getLineNumber();
        }

        public String getName() {
            return this.element.getName().getLocalPart();
        }

        public String getPrefix() {
            return this.element.getName().getPrefix();
        }

        public String getReference() {
            return this.element.getName().getNamespaceURI();
        }

        public Object getSource() {
            return this.element;
        }
    }

    public static class Text extends EventToken {
        private final Characters text;

        public Text(XMLEvent xMLEvent) {
            this.text = xMLEvent.asCharacters();
        }

        public Object getSource() {
            return this.text;
        }

        public String getValue() {
            return this.text.getData();
        }

        public boolean isText() {
            return true;
        }
    }

    public StreamReader(XMLEventReader xMLEventReader) {
        this.reader = xMLEventReader;
    }

    private Entry attribute(javax.xml.stream.events.Attribute attribute) {
        return new Entry(attribute);
    }

    private Start build(Start start) {
        Iterator attributes = start.getAttributes();
        while (attributes.hasNext()) {
            Entry attribute = attribute((javax.xml.stream.events.Attribute) attributes.next());
            if (!attribute.isReserved()) {
                start.add(attribute);
            }
        }
        return start;
    }

    private End end() {
        return new End(null);
    }

    private EventNode read() throws Exception {
        XMLEvent nextEvent = this.reader.nextEvent();
        if (nextEvent.isEndDocument()) {
            return null;
        }
        return nextEvent.isStartElement() ? start(nextEvent) : nextEvent.isCharacters() ? text(nextEvent) : nextEvent.isEndElement() ? end() : read();
    }

    private Start start(XMLEvent xMLEvent) {
        Start start = new Start(xMLEvent);
        return start.isEmpty() ? build(start) : start;
    }

    private Text text(XMLEvent xMLEvent) {
        return new Text(xMLEvent);
    }

    public EventNode next() throws Exception {
        EventNode eventNode = this.peek;
        if (eventNode == null) {
            return read();
        }
        this.peek = null;
        return eventNode;
    }

    public EventNode peek() throws Exception {
        if (this.peek == null) {
            this.peek = next();
        }
        return this.peek;
    }
}
