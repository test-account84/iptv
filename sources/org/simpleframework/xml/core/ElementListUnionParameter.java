package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.stream.Format;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ElementListUnionParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public static class Contact extends ParameterContact {
        public Contact(ElementList elementList, Constructor constructor, int i) {
            super(elementList, constructor, i);
        }

        public String getName() {
            return ((ElementList) this.label).name();
        }
    }

    public ElementListUnionParameter(Constructor constructor, ElementListUnion elementListUnion, ElementList elementList, Format format, int i) throws Exception {
        Contact contact = new Contact(elementList, constructor, i);
        this.contact = contact;
        ElementListUnionLabel elementListUnionLabel = new ElementListUnionLabel(contact, elementListUnion, elementList, format);
        this.label = elementListUnionLabel;
        this.expression = elementListUnionLabel.getExpression();
        this.path = elementListUnionLabel.getPath();
        this.type = elementListUnionLabel.getType();
        this.name = elementListUnionLabel.getName();
        this.key = elementListUnionLabel.getKey();
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
