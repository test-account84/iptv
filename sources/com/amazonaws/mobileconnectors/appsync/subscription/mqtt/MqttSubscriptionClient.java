package com.amazonaws.mobileconnectors.appsync.subscription.mqtt;

import android.content.Context;
import android.util.Log;
import com.amazonaws.mobileconnectors.appsync.subscription.SubscriptionCallback;
import com.amazonaws.mobileconnectors.appsync.subscription.SubscriptionClient;
import com.amazonaws.mobileconnectors.appsync.subscription.SubscriptionClientCallback;
import com.amazonaws.mobileconnectors.appsync.subscription.SubscriptionDisconnectedException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MqttSubscriptionClient implements SubscriptionClient {
    private static final int PING_INTERVAL = 30;
    private static final String TAG = "MqttSubscriptionClient";
    ClientConnectionListener clientConnectionListener;
    MqttAndroidClient mMqttAndroidClient;
    SubscriptionMessageListener subscriptionMessageListener;
    private final HashSet topics = new HashSet();
    public final Map subscriptionsMap = new HashMap();

    public class 1 implements IMqttActionListener {
        final /* synthetic */ SubscriptionClientCallback val$callback;

        public 1(SubscriptionClientCallback subscriptionClientCallback) {
            this.val$callback = subscriptionClientCallback;
        }

        public void onFailure(IMqttToken iMqttToken, Throwable th) {
            SubscriptionClientCallback subscriptionClientCallback = this.val$callback;
            if (subscriptionClientCallback != null) {
                subscriptionClientCallback.onError(new Exception(th));
            }
        }

        public void onSuccess(IMqttToken iMqttToken) {
            SubscriptionClientCallback subscriptionClientCallback = this.val$callback;
            if (subscriptionClientCallback != null) {
                subscriptionClientCallback.onConnect();
            }
        }
    }

    public class 2 implements IMqttActionListener {
        final /* synthetic */ String val$topic;

        public 2(String str) {
            this.val$topic = str;
        }

        public void onFailure(IMqttToken iMqttToken, Throwable th) {
            Log.v(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Errror [" + th + "] when disconnecting from topic [" + this.val$topic + "]");
        }

        public void onSuccess(IMqttToken iMqttToken) {
            Log.v(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Disconnected from topic [" + this.val$topic + "]");
        }
    }

    public class 3 implements IMqttActionListener {
        public 3() {
        }

        public void onFailure(IMqttToken iMqttToken, Throwable th) {
            Log.w(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Got exception [" + th + "] when attempting to disconnect clientID " + MqttSubscriptionClient.this.mMqttAndroidClient.getClientId() + "]");
        }

        public void onSuccess(IMqttToken iMqttToken) {
            try {
                MqttSubscriptionClient.this.mMqttAndroidClient.close();
                Log.d(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Successfully closed the connection. Client ID [" + MqttSubscriptionClient.this.mMqttAndroidClient.getClientId() + "]");
            } catch (Exception e) {
                Log.w(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Error closing connection [" + e + "]");
            }
        }
    }

    public class ClientConnectionListener implements MqttCallback {
        SubscriptionClientCallback callback;
        private String clientID;
        private boolean isTransmitting = true;

        public ClientConnectionListener() {
        }

        public void connectionLost(Throwable th) {
            Log.v(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: client connection lost for client [" + this.clientID + "]");
            if (!this.isTransmitting || this.callback == null) {
                return;
            }
            Log.v(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Transmitting client connection lost for client [" + this.clientID + "]");
            this.callback.onError(new SubscriptionDisconnectedException("Client disconnected", th));
        }

        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            Log.d(MqttSubscriptionClient.access$000(), "delivery complete");
        }

        public void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
            Log.v(MqttSubscriptionClient.access$000(), "message arrived");
        }

        public void setCallback(SubscriptionClientCallback subscriptionClientCallback) {
            this.callback = subscriptionClientCallback;
        }

        public void setClientID(String str) {
            this.clientID = str;
        }

        public void setTransmitting(boolean z) {
            Log.v(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Set Connection transmitting to " + z + " for client [" + this.clientID + "]");
            this.isTransmitting = z;
        }
    }

    public class SubscriptionMessageListener implements IMqttMessageListener {
        SubscriptionCallback callback;
        public MqttSubscriptionClient client;
        private String clientID;
        private boolean isTransmitting;

        public SubscriptionMessageListener() {
        }

        public void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
            Log.v(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Received subscription message on client [" + this.clientID + "]");
            if (this.isTransmitting) {
                Log.v(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Transmitting subscription message from client [" + this.clientID + "] mqttL: " + this + "subL: " + this.callback + " Topic: " + str + " Msg: " + mqttMessage.toString());
                this.callback.onMessage(str, mqttMessage.toString());
            }
        }

        public void setCallback(SubscriptionCallback subscriptionCallback) {
            this.callback = subscriptionCallback;
        }

        public void setClientID(String str) {
            this.clientID = str;
        }

        public void setTransmitting(boolean z) {
            Log.v(MqttSubscriptionClient.access$000(), "Subscription Infrastructure: Set subscription message transmitting to " + z + " for client [" + this.clientID + "]");
            this.isTransmitting = z;
        }
    }

    public MqttSubscriptionClient(Context context, String str, String str2) {
        this.mMqttAndroidClient = new MqttAndroidClient(context, str, str2, new MemoryPersistence());
        SubscriptionMessageListener subscriptionMessageListener = new SubscriptionMessageListener();
        this.subscriptionMessageListener = subscriptionMessageListener;
        subscriptionMessageListener.client = this;
        subscriptionMessageListener.setClientID(str2);
        ClientConnectionListener clientConnectionListener = new ClientConnectionListener();
        this.clientConnectionListener = clientConnectionListener;
        clientConnectionListener.setClientID(str2);
        setTransmitting(false);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public void close() {
        Log.v(TAG, "Closing MQTT client [" + this.mMqttAndroidClient.getClientId() + "");
        try {
            this.mMqttAndroidClient.disconnect(0L, (Object) null, new 3());
        } catch (Exception e) {
            Log.w(TAG, "Got exception when closing MQTT client [" + this.mMqttAndroidClient.getClientId() + "]", e);
        }
    }

    public void connect(SubscriptionClientCallback subscriptionClientCallback) {
        try {
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setMqttVersion(4);
            mqttConnectOptions.setCleanSession(true);
            mqttConnectOptions.setAutomaticReconnect(false);
            mqttConnectOptions.setKeepAliveInterval(30);
            ClientConnectionListener clientConnectionListener = this.clientConnectionListener;
            if (clientConnectionListener != null) {
                clientConnectionListener.setCallback(subscriptionClientCallback);
            }
            this.mMqttAndroidClient.setCallback(this.clientConnectionListener);
            Log.v(TAG, "Subscription Infrastructure: Calling MQTT Connect with actual endpoint for client ID[" + this.mMqttAndroidClient.getClientId() + "]");
            this.mMqttAndroidClient.connect(mqttConnectOptions, (Object) null, new 1(subscriptionClientCallback));
        } catch (Exception e) {
            Log.e("TAG", "Subscription Infrastructure: Failed to connect mqtt client for clientID [" + this.mMqttAndroidClient.getClientId() + "]", e);
            subscriptionClientCallback.onError(e);
        }
    }

    public Set getTopics() {
        return this.topics;
    }

    public void setTransmitting(boolean z) {
        SubscriptionMessageListener subscriptionMessageListener = this.subscriptionMessageListener;
        if (subscriptionMessageListener != null) {
            subscriptionMessageListener.setTransmitting(z);
        }
        ClientConnectionListener clientConnectionListener = this.clientConnectionListener;
        if (clientConnectionListener != null) {
            clientConnectionListener.setTransmitting(z);
        }
    }

    public void subscribe(String str, int i, SubscriptionCallback subscriptionCallback) {
        try {
            Log.v(TAG, this + "Subscription Infrastructure: Attempting to subscribe to topic " + str + " on clientID [" + this.mMqttAndroidClient.getClientId() + "]");
            SubscriptionMessageListener subscriptionMessageListener = this.subscriptionMessageListener;
            if (subscriptionMessageListener != null) {
                subscriptionMessageListener.setCallback(subscriptionCallback);
            }
            this.mMqttAndroidClient.subscribe(str, i, this.subscriptionMessageListener);
            this.topics.add(str);
        } catch (Exception e) {
            subscriptionCallback.onError(str, e);
        }
    }

    public void unsubscribe(String str) {
        try {
            this.topics.remove(str);
            this.mMqttAndroidClient.unsubscribe(str, (Object) null, new 2(str));
        } catch (Exception e) {
            Log.v(TAG, "Unsubscribe failed at the MQTT level [" + e + "]");
        }
    }
}
