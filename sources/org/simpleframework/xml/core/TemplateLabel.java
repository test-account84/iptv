package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class TemplateLabel implements Label {
    private final KeyBuilder builder = new KeyBuilder(this);

    public Type getDependent() throws Exception {
        return null;
    }

    public String getEntry() throws Exception {
        return null;
    }

    public Object getKey() throws Exception {
        return this.builder.getKey();
    }

    public Label getLabel(Class cls) throws Exception {
        return this;
    }

    public String[] getNames() throws Exception {
        return new String[]{getPath(), getName()};
    }

    public String[] getPaths() throws Exception {
        return new String[]{getPath()};
    }

    public Type getType(Class cls) throws Exception {
        return getContact();
    }

    public boolean isAttribute() {
        return false;
    }

    public boolean isCollection() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isText() {
        return false;
    }

    public boolean isTextList() {
        return false;
    }

    public boolean isUnion() {
        return false;
    }
}
