package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ExtraMaterialsDescription implements Serializable {
    public static final ExtraMaterialsDescription NONE = new ExtraMaterialsDescription(Collections.EMPTY_MAP);
    private final Map extra;
    private final ConflictResolution resolve;

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution;

        static {
            int[] iArr = new int[ConflictResolution.values().length];
            $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution = iArr;
            try {
                iArr[ConflictResolution.FAIL_FAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution[ConflictResolution.OVERRIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution[ConflictResolution.OVERRIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum ConflictResolution {
        FAIL_FAST,
        OVERRIDE,
        OVERRIDDEN
    }

    public ExtraMaterialsDescription(Map map) {
        this(map, ConflictResolution.FAIL_FAST);
    }

    public ConflictResolution getConflictResolution() {
        return this.resolve;
    }

    public Map getMaterialDescription() {
        return this.extra;
    }

    public Map mergeInto(Map map) {
        HashMap hashMap;
        if (this.extra.size() == 0) {
            return map;
        }
        if (map == null || map.size() == 0) {
            return this.extra;
        }
        int i = 1.$SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution[this.resolve.ordinal()];
        if (i == 1) {
            int size = map.size() + this.extra.size();
            HashMap hashMap2 = new HashMap(map);
            hashMap2.putAll(this.extra);
            if (size == hashMap2.size()) {
                return Collections.unmodifiableMap(hashMap2);
            }
            throw new IllegalArgumentException("The supplemental material descriptions contains conflicting entries");
        }
        if (i == 2) {
            hashMap = new HashMap(this.extra);
        } else {
            if (i != 3) {
                throw new UnsupportedOperationException();
            }
            hashMap = new HashMap(map);
            map = this.extra;
        }
        hashMap.putAll(map);
        return Collections.unmodifiableMap(hashMap);
    }

    public ExtraMaterialsDescription(Map map, ConflictResolution conflictResolution) {
        if (map == null || conflictResolution == null) {
            throw new IllegalArgumentException();
        }
        this.extra = Collections.unmodifiableMap(new HashMap(map));
        this.resolve = conflictResolution;
    }
}
