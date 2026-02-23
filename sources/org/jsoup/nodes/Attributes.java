package org.jsoup.nodes;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Attributes implements Iterable, Cloneable {
    protected static final String dataPrefix = "data-";
    private LinkedHashMap attributes = null;

    public class Dataset extends AbstractMap {

        public class DatasetIterator implements Iterator {
            private Attribute attr;
            private Iterator attrIter;

            private DatasetIterator() {
                this.attrIter = Attributes.access$100(Attributes.this).values().iterator();
            }

            public boolean hasNext() {
                while (this.attrIter.hasNext()) {
                    Attribute attribute = (Attribute) this.attrIter.next();
                    this.attr = attribute;
                    if (attribute.isDataAttribute()) {
                        return true;
                    }
                }
                return false;
            }

            public void remove() {
                Attributes.access$100(Attributes.this).remove(this.attr.getKey());
            }

            public /* synthetic */ DatasetIterator(Dataset dataset, 1 r2) {
                this();
            }

            public Map.Entry next() {
                return new Attribute(this.attr.getKey().substring(5), this.attr.getValue());
            }
        }

        public class EntrySet extends AbstractSet {
            private EntrySet() {
            }

            public Iterator iterator() {
                return new DatasetIterator(Dataset.this, null);
            }

            public int size() {
                int i = 0;
                while (new DatasetIterator(Dataset.this, null).hasNext()) {
                    i++;
                }
                return i;
            }

            public /* synthetic */ EntrySet(Dataset dataset, 1 r2) {
                this();
            }
        }

        private Dataset() {
            if (Attributes.access$100(Attributes.this) == null) {
                Attributes.access$102(Attributes.this, new LinkedHashMap(2));
            }
        }

        public Set entrySet() {
            return new EntrySet(this, null);
        }

        public /* synthetic */ Dataset(Attributes attributes, 1 r2) {
            this();
        }

        public String put(String str, String str2) {
            String access$300 = Attributes.access$300(str);
            String value = Attributes.this.hasKey(access$300) ? ((Attribute) Attributes.access$100(Attributes.this).get(access$300)).getValue() : null;
            Attributes.access$100(Attributes.this).put(access$300, new Attribute(access$300, str2));
            return value;
        }
    }

    public static /* synthetic */ LinkedHashMap access$100(Attributes attributes) {
        return attributes.attributes;
    }

    public static /* synthetic */ LinkedHashMap access$102(Attributes attributes, LinkedHashMap linkedHashMap) {
        attributes.attributes = linkedHashMap;
        return linkedHashMap;
    }

    public static /* synthetic */ String access$300(String str) {
        return dataKey(str);
    }

    private static String dataKey(String str) {
        return "data-" + str;
    }

    public void addAll(Attributes attributes) {
        if (attributes.size() == 0) {
            return;
        }
        if (this.attributes == null) {
            this.attributes = new LinkedHashMap(attributes.size());
        }
        this.attributes.putAll(attributes.attributes);
    }

    public List asList() {
        if (this.attributes == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.attributes.size());
        Iterator it = this.attributes.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getValue());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Map dataset() {
        return new Dataset(this, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attributes)) {
            return false;
        }
        LinkedHashMap linkedHashMap = this.attributes;
        LinkedHashMap linkedHashMap2 = ((Attributes) obj).attributes;
        if (linkedHashMap != null) {
            if (linkedHashMap.equals(linkedHashMap2)) {
                return true;
            }
        } else if (linkedHashMap2 == null) {
            return true;
        }
        return false;
    }

    public String get(String str) {
        Attribute attribute;
        Validate.notEmpty(str);
        LinkedHashMap linkedHashMap = this.attributes;
        return (linkedHashMap == null || (attribute = (Attribute) linkedHashMap.get(str.toLowerCase())) == null) ? "" : attribute.getValue();
    }

    public boolean hasKey(String str) {
        LinkedHashMap linkedHashMap = this.attributes;
        return linkedHashMap != null && linkedHashMap.containsKey(str.toLowerCase());
    }

    public int hashCode() {
        LinkedHashMap linkedHashMap = this.attributes;
        if (linkedHashMap != null) {
            return linkedHashMap.hashCode();
        }
        return 0;
    }

    public String html() {
        StringBuilder sb = new StringBuilder();
        html(sb, new Document("").outputSettings());
        return sb.toString();
    }

    public Iterator iterator() {
        return asList().iterator();
    }

    public void put(String str, String str2) {
        put(new Attribute(str, str2));
    }

    public void remove(String str) {
        Validate.notEmpty(str);
        LinkedHashMap linkedHashMap = this.attributes;
        if (linkedHashMap == null) {
            return;
        }
        linkedHashMap.remove(str.toLowerCase());
    }

    public int size() {
        LinkedHashMap linkedHashMap = this.attributes;
        if (linkedHashMap == null) {
            return 0;
        }
        return linkedHashMap.size();
    }

    public String toString() {
        return html();
    }

    public Attributes clone() {
        if (this.attributes == null) {
            return new Attributes();
        }
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.attributes = new LinkedHashMap(this.attributes.size());
            Iterator it = iterator();
            while (it.hasNext()) {
                Attribute attribute = (Attribute) it.next();
                attributes.attributes.put(attribute.getKey(), attribute.clone());
            }
            return attributes;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void html(StringBuilder sb, Document.OutputSettings outputSettings) {
        LinkedHashMap linkedHashMap = this.attributes;
        if (linkedHashMap == null) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Attribute attribute = (Attribute) ((Map.Entry) it.next()).getValue();
            sb.append(" ");
            attribute.html(sb, outputSettings);
        }
    }

    public void put(String str, boolean z) {
        if (z) {
            put(new BooleanAttribute(str));
        } else {
            remove(str);
        }
    }

    public void put(Attribute attribute) {
        Validate.notNull(attribute);
        if (this.attributes == null) {
            this.attributes = new LinkedHashMap(2);
        }
        this.attributes.put(attribute.getKey(), attribute);
    }
}
