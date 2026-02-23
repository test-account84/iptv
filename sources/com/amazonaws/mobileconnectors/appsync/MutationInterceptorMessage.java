package com.amazonaws.mobileconnectors.appsync;

import v1.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class MutationInterceptorMessage {
    String clientState;
    final f currentMutation;
    final f originalMutation;
    String requestClassName;
    String requestIdentifier;
    String serverState;

    public MutationInterceptorMessage() {
        this.originalMutation = null;
        this.currentMutation = null;
    }

    public MutationInterceptorMessage(f fVar, f fVar2) {
        this.originalMutation = fVar;
        this.currentMutation = fVar2;
    }
}
