package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Variable implements Label {
    private final Label label;
    private final Object value;

    public static class Adapter implements Repeater {
        private final Label label;
        private final Converter reader;
        private final Object value;

        public Adapter(Converter converter, Label label, Object obj) {
            this.reader = converter;
            this.value = obj;
            this.label = label;
        }

        public Object read(InputNode inputNode) throws Exception {
            return read(inputNode, this.value);
        }

        public boolean validate(InputNode inputNode) throws Exception {
            Position position = inputNode.getPosition();
            String name = inputNode.getName();
            Converter converter = this.reader;
            if (converter instanceof Repeater) {
                return ((Repeater) converter).validate(inputNode);
            }
            throw new PersistenceException("Element '%s' declared twice at %s", name, position);
        }

        public void write(OutputNode outputNode, Object obj) throws Exception {
            write(outputNode, obj);
        }

        public Object read(InputNode inputNode, Object obj) throws Exception {
            Position position = inputNode.getPosition();
            String name = inputNode.getName();
            Converter converter = this.reader;
            if (converter instanceof Repeater) {
                return ((Repeater) converter).read(inputNode, obj);
            }
            throw new PersistenceException("Element '%s' is already used with %s at %s", name, this.label, position);
        }
    }

    public Variable(Label label, Object obj) {
        this.label = label;
        this.value = obj;
    }

    public Annotation getAnnotation() {
        return this.label.getAnnotation();
    }

    public Contact getContact() {
        return this.label.getContact();
    }

    public Converter getConverter(Context context) throws Exception {
        Converter converter = this.label.getConverter(context);
        return converter instanceof Adapter ? converter : new Adapter(converter, this.label, this.value);
    }

    public Decorator getDecorator() throws Exception {
        return this.label.getDecorator();
    }

    public Type getDependent() throws Exception {
        return this.label.getDependent();
    }

    public Object getEmpty(Context context) throws Exception {
        return this.label.getEmpty(context);
    }

    public String getEntry() throws Exception {
        return this.label.getEntry();
    }

    public Expression getExpression() throws Exception {
        return this.label.getExpression();
    }

    public Object getKey() throws Exception {
        return this.label.getKey();
    }

    public Label getLabel(Class cls) {
        return this;
    }

    public String getName() throws Exception {
        return this.label.getName();
    }

    public String[] getNames() throws Exception {
        return this.label.getNames();
    }

    public String getOverride() {
        return this.label.getOverride();
    }

    public String getPath() throws Exception {
        return this.label.getPath();
    }

    public String[] getPaths() throws Exception {
        return this.label.getPaths();
    }

    public Class getType() {
        return this.label.getType();
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isAttribute() {
        return this.label.isAttribute();
    }

    public boolean isCollection() {
        return this.label.isCollection();
    }

    public boolean isData() {
        return this.label.isData();
    }

    public boolean isInline() {
        return this.label.isInline();
    }

    public boolean isRequired() {
        return this.label.isRequired();
    }

    public boolean isText() {
        return this.label.isText();
    }

    public boolean isTextList() {
        return this.label.isTextList();
    }

    public boolean isUnion() {
        return this.label.isUnion();
    }

    public String toString() {
        return this.label.toString();
    }

    public Type getType(Class cls) throws Exception {
        return this.label.getType(cls);
    }
}
