package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.stream.Format;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ElementMapParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public static class Contact extends ParameterContact {
        public Contact(ElementMap elementMap, Constructor constructor, int i) {
            super(elementMap, constructor, i);
        }

        public String getName() {
            return ((ElementMap) this.label).name();
        }
    }

    public ElementMapParameter(Constructor constructor, ElementMap elementMap, Format format, int i) throws Exception {
        Contact contact = new Contact(elementMap, constructor, i);
        this.contact = contact;
        ElementMapLabel elementMapLabel = new ElementMapLabel(contact, elementMap, format);
        this.label = elementMapLabel;
        this.expression = elementMapLabel.getExpression();
        this.path = elementMapLabel.getPath();
        this.type = elementMapLabel.getType();
        this.name = elementMapLabel.getName();
        this.key = elementMapLabel.getKey();
        this.index = i;
    }

    public Annotation getAnnotation() {
        return this.contact.getAnnotation();
    }

    public Expression getExpression() {
        return this.expression;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public Class getType() {
        return this.type;
    }

    public boolean isPrimitive() {
        return this.type.isPrimitive();
    }

    public boolean isRequired() {
        return this.label.isRequired();
    }

    public String toString() {
        return this.contact.toString();
    }
}
