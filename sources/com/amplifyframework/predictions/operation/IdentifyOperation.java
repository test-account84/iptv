package com.amplifyframework.predictions.operation;

import com.amplifyframework.core.async.AmplifyOperation;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.predictions.models.IdentifyAction;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class IdentifyOperation extends AmplifyOperation {
    private final IdentifyAction identifyAction;

    public IdentifyOperation(IdentifyAction identifyAction, Object obj) {
        super(CategoryType.PREDICTIONS, obj);
        Objects.requireNonNull(identifyAction);
        this.identifyAction = identifyAction;
    }

    public IdentifyAction getIdentifyAction() {
        return this.identifyAction;
    }
}
