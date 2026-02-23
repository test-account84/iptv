package com.nst.iptvsmarterstvbox.model.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "icon", strict = false)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class XMLTVIconPojo {

    @Attribute(name = "src", required = false)
    private String src;

    public String getSrc() {
        return this.src;
    }

    public void setSrc(String str) {
        this.src = str;
    }

    public String toString() {
        return "ClassPojo [src = " + this.src + "]";
    }
}
