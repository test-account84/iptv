package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.stream.Format;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class AttributeLabel extends TemplateLabel {
    private Decorator decorator;
    private Introspector detail;
    private String empty;
    private Format format;
    private Attribute label;
    private String name;
    private Expression path;
    private boolean required;
    private Class type;

    public AttributeLabel(Contact contact, Attribute attribute, Format format) {
        this.detail = new Introspector(contact, this, format);
        this.decorator = new Qualifier(contact);
        this.required = attribute.required();
        this.type = contact.getType();
        this.empty = attribute.empty();
        this.name = attribute.name();
        this.format = format;
        this.label = attribute;
    }

    public Annotation getAnnotation() {
        return this.label;
    }

    public Contact getContact() {
        return this.detail.getContact();
    }

    public Converter getConverter(Context context) throws Exception {
        return new Primitive(context, getContact(), getEmpty(context));
    }

    public Decorator getDecorator() throws Exception {
        return this.decorator;
    }

    public Expression getExpression() throws Exception {
        if (this.path == null) {
            this.path = this.detail.getExpression();
        }
        return this.path;
    }

    public String getName() throws Exception {
        return this.format.getStyle().getAttribute(this.detail.getName());
    }

    public String getOverride() {
        return this.name;
    }

    public String getPath() throws Exception {
        return getExpression().getAttribute(getName());
    }

    public Class getType() {
        return this.type;
    }

    public boolean isAttribute() {
        return true;
    }

    public boolean isData() {
        return false;
    }

    public boolean isRequired() {
        return this.required;
    }

    public String toString() {
        return this.detail.toString();
    }

    public String getEmpty(Context context) {
        if (this.detail.isEmpty(this.empty)) {
            return null;
        }
        return this.empty;
    }
}
