package com.amazonaws.mobile.client.internal.oauth2;

import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class OAuth2ClientStore {
    private final AWSKeyValueStore mKeyValueStore;
    ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();

    public OAuth2ClientStore(OAuth2Client oAuth2Client) {
        this.mKeyValueStore = new AWSKeyValueStore(oAuth2Client.mContext, "com.amazonaws.mobile.client.oauth2", oAuth2Client.mIsPersistenceEnabled);
    }

    public void clear() {
        this.mKeyValueStore.clear();
    }

    public String get(String str) {
        try {
            this.mReadWriteLock.readLock().lock();
            return this.mKeyValueStore.get(str);
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    public OAuth2Tokens getTokens() {
        try {
            this.mReadWriteLock.readLock().lock();
            String str = this.mKeyValueStore.get(OAuth2Constants.TokenResponseFields.EXPIRES_IN.toString());
            return new OAuth2Tokens(this.mKeyValueStore.get(OAuth2Constants.TokenResponseFields.ACCESS_TOKEN.toString()), this.mKeyValueStore.get(OAuth2Constants.TokenResponseFields.ID_TOKEN.toString()), this.mKeyValueStore.get(OAuth2Constants.TokenResponseFields.REFRESH_TOKEN.toString()), this.mKeyValueStore.get(OAuth2Constants.TokenResponseFields.TOKEN_TYPE.toString()), str == null ? null : Long.decode(str), Long.valueOf(this.mKeyValueStore.get("createDate")), this.mKeyValueStore.get(OAuth2Constants.TokenResponseFields.SCOPES.toString()));
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    public void set(OAuth2Tokens oAuth2Tokens) {
        try {
            this.mReadWriteLock.writeLock().lock();
            this.mKeyValueStore.put(OAuth2Constants.TokenResponseFields.ACCESS_TOKEN.toString(), oAuth2Tokens.getAccessToken());
            this.mKeyValueStore.put(OAuth2Constants.TokenResponseFields.ID_TOKEN.toString(), oAuth2Tokens.getIdToken());
            this.mKeyValueStore.put(OAuth2Constants.TokenResponseFields.REFRESH_TOKEN.toString(), oAuth2Tokens.getRefreshToken());
            this.mKeyValueStore.put(OAuth2Constants.TokenResponseFields.EXPIRES_IN.toString(), oAuth2Tokens.getExpiresIn() == null ? null : oAuth2Tokens.getExpiresIn().toString());
            this.mKeyValueStore.put("createDate", oAuth2Tokens.getCreateDate().toString());
        } finally {
            this.mReadWriteLock.writeLock().unlock();
        }
    }

    public void setPersistenceEnabled(boolean z) {
        this.mKeyValueStore.setPersistenceEnabled(z);
    }

    public Map get(String... strArr) {
        try {
            this.mReadWriteLock.readLock().lock();
            HashMap hashMap = new HashMap();
            for (String str : strArr) {
                hashMap.put(str, this.mKeyValueStore.get(str));
            }
            return hashMap;
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    public void set(String str, String str2) {
        try {
            this.mReadWriteLock.writeLock().lock();
            this.mKeyValueStore.put(str, str2);
        } finally {
            this.mReadWriteLock.writeLock().unlock();
        }
    }

    public void set(Map map) {
        try {
            this.mReadWriteLock.writeLock().lock();
            for (String str : map.keySet()) {
                this.mKeyValueStore.put(str, (String) map.get(str));
            }
        } finally {
            this.mReadWriteLock.writeLock().unlock();
        }
    }
}
