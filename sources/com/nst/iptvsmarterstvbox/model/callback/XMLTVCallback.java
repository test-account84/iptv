package com.nst.iptvsmarterstvbox.model.callback;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "tv", strict = false)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class XMLTVCallback {

    @ElementList(inline = true, required = false)
    public List programmePojos;

    public String toString() {
        return "ClassPojo [programmePojos= " + this.programmePojos + "]";
    }
}
