package com.amazonaws.mobileconnectors.appsync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class ConnectivityWatcher {
    private BroadcastReceiver broadcastReceiver;
    private final Callback callback;
    private final ConnectivityManager connManager;
    private final Context context;
    private ConnectivityManager.NetworkCallback networkCallback;

    public interface Callback {
        void onConnectivityChanged(boolean z);
    }

    public class ConnectivityChangeReceiver extends BroadcastReceiver {
        private ConnectivityChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                ConnectivityWatcher.access$300(ConnectivityWatcher.this).onConnectivityChanged(ConnectivityWatcher.access$200(ConnectivityWatcher.this));
            }
        }

        public /* synthetic */ ConnectivityChangeReceiver(ConnectivityWatcher connectivityWatcher, 1 r2) {
            this();
        }
    }

    public class NetworkCallback extends ConnectivityManager.NetworkCallback {
        private boolean isConnected;

        private NetworkCallback() {
            this.isConnected = ConnectivityWatcher.access$200(ConnectivityWatcher.this);
        }

        private void checkConnected() {
            boolean access$200 = ConnectivityWatcher.access$200(ConnectivityWatcher.this);
            if (this.isConnected != access$200) {
                this.isConnected = access$200;
                ConnectivityWatcher.access$300(ConnectivityWatcher.this).onConnectivityChanged(access$200);
            }
        }

        public void onAvailable(Network network) {
            checkConnected();
        }

        public void onLost(Network network) {
            checkConnected();
        }

        public /* synthetic */ NetworkCallback(ConnectivityWatcher connectivityWatcher, 1 r2) {
            this();
        }
    }

    public ConnectivityWatcher(Context context, Callback callback) {
        this.context = context.getApplicationContext();
        this.callback = callback;
        this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static /* synthetic */ boolean access$200(ConnectivityWatcher connectivityWatcher) {
        return connectivityWatcher.isNetworkConnected();
    }

    public static /* synthetic */ Callback access$300(ConnectivityWatcher connectivityWatcher) {
        return connectivityWatcher.callback;
    }

    private boolean isNetworkConnected() {
        NetworkInfo activeNetworkInfo = this.connManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void registerBroadcastReceiver() {
        if (this.broadcastReceiver == null) {
            ConnectivityChangeReceiver connectivityChangeReceiver = new ConnectivityChangeReceiver(this, null);
            this.broadcastReceiver = connectivityChangeReceiver;
            this.context.registerReceiver(connectivityChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void registerNetworkCallback() {
        if (this.networkCallback == null) {
            this.networkCallback = new NetworkCallback(this, null);
            this.connManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.networkCallback);
        }
    }

    private void unregisterBroadcastReceiver() {
        BroadcastReceiver broadcastReceiver = this.broadcastReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.broadcastReceiver = null;
        }
    }

    private void unregisterNetworkCallback() {
        ConnectivityManager.NetworkCallback networkCallback = this.networkCallback;
        if (networkCallback != null) {
            this.connManager.unregisterNetworkCallback(networkCallback);
            this.networkCallback = null;
        }
    }

    public void register() {
        registerNetworkCallback();
    }

    public void unregister() {
        unregisterNetworkCallback();
    }
}
