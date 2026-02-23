package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ArrayMatcher implements Matcher {
    private final Matcher primary;

    public ArrayMatcher(Matcher matcher) {
        this.primary = matcher;
    }

    private Transform matchArray(Class cls) throws Exception {
        Transform match = this.primary.match(cls);
        if (match == null) {
            return null;
        }
        return new ArrayTransform(match, cls);
    }

    public Transform match(Class cls) throws Exception {
        Class componentType = cls.getComponentType();
        if (componentType != Character.TYPE && componentType != Character.class) {
            return componentType == String.class ? new StringArrayTransform() : matchArray(componentType);
        }
        return new CharacterArrayTransform(componentType);
    }
}
