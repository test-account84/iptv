package com.amazonaws.mobileconnectors.appsync;

import D1.a;
import v1.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class MutationInformation {
    String clientState;
    a.a customerCallBack;
    MuationType muationType;
    InMemoryOfflineMutationObject originalInMemoryMutation;
    PersistentOfflineMutationObject originalPersistMutation;
    e retryMutation;
    String uniqueIdentifier;

    public MutationInformation(String str, InMemoryOfflineMutationObject inMemoryOfflineMutationObject, a.a aVar, String str2) {
        this.originalInMemoryMutation = inMemoryOfflineMutationObject;
        this.customerCallBack = aVar;
        this.clientState = str2;
        this.muationType = MuationType.InMemory;
        this.uniqueIdentifier = str;
    }

    public void updateCustomerCallBack(a.a aVar) {
        this.customerCallBack = aVar;
    }

    public void updateRetryMutation(e eVar) {
        this.retryMutation = eVar;
    }

    public MutationInformation(String str, PersistentOfflineMutationObject persistentOfflineMutationObject, String str2) {
        this.uniqueIdentifier = str;
        this.originalPersistMutation = persistentOfflineMutationObject;
        this.clientState = str2;
        this.muationType = MuationType.Persistent;
    }
}
