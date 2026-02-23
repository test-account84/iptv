package com.amplifyframework.hub;

import android.content.Context;
import j$.util.Objects;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSHubPlugin extends HubPlugin {
    private final Set subscriptions = new HashSet();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public static final class Subscription {
        private final HubChannel channel;
        private final HubEventFilter hubEventFilter;
        private final HubSubscriber hubSubscriber;
        private final SubscriptionToken subscriptionToken;

        public Subscription(SubscriptionToken subscriptionToken, HubChannel hubChannel, HubEventFilter hubEventFilter, HubSubscriber hubSubscriber) {
            Objects.requireNonNull(subscriptionToken);
            this.subscriptionToken = subscriptionToken;
            Objects.requireNonNull(hubChannel);
            this.channel = hubChannel;
            Objects.requireNonNull(hubEventFilter);
            this.hubEventFilter = hubEventFilter;
            Objects.requireNonNull(hubSubscriber);
            this.hubSubscriber = hubSubscriber;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Subscription.class != obj.getClass()) {
                return false;
            }
            Subscription subscription = (Subscription) obj;
            if (O.c.a(this.subscriptionToken, subscription.subscriptionToken) && this.channel == subscription.channel && O.c.a(this.hubEventFilter, subscription.hubEventFilter)) {
                return O.c.a(this.hubSubscriber, subscription.hubSubscriber);
            }
            return false;
        }

        public HubChannel getHubChannel() {
            return this.channel;
        }

        public HubEventFilter getHubEventFilter() {
            return this.hubEventFilter;
        }

        public HubSubscriber getHubSubscriber() {
            return this.hubSubscriber;
        }

        public SubscriptionToken getSubscriptionToken() {
            return this.subscriptionToken;
        }

        public int hashCode() {
            return (((((this.subscriptionToken.hashCode() * 31) + this.channel.hashCode()) * 31) + this.hubEventFilter.hashCode()) * 31) + this.hubSubscriber.hashCode();
        }

        public String toString() {
            return "Subscription{subscriptionToken=" + this.subscriptionToken + ", channel=" + this.channel + ", hubEventFilter=" + this.hubEventFilter + ", hubSubscriber=" + this.hubSubscriber + '}';
        }
    }

    public static /* synthetic */ void a(Subscription subscription, HubEvent hubEvent) {
        lambda$null$0(subscription, hubEvent);
    }

    public static /* synthetic */ void b(AWSHubPlugin aWSHubPlugin, HubChannel hubChannel, HubEvent hubEvent) {
        aWSHubPlugin.lambda$publish$1(hubChannel, hubEvent);
    }

    private static /* synthetic */ void lambda$null$0(Subscription subscription, HubEvent hubEvent) {
        subscription.getHubSubscriber().onEvent(hubEvent);
    }

    private /* synthetic */ void lambda$publish$1(HubChannel hubChannel, HubEvent hubEvent) {
        synchronized (this.subscriptions) {
            try {
                for (Subscription subscription : this.subscriptions) {
                    if (subscription.getHubChannel().equals(hubChannel) && subscription.getHubEventFilter().filter(hubEvent)) {
                        this.executorService.execute(new b(subscription, hubEvent));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void configure(JSONObject jSONObject, Context context) {
    }

    public String getPluginKey() {
        return "awsHubPlugin";
    }

    public String getVersion() {
        return "1.37.10";
    }

    public void publish(HubChannel hubChannel, HubEvent hubEvent) {
        Objects.requireNonNull(hubChannel);
        Objects.requireNonNull(hubEvent);
        this.executorService.execute(new a(this, hubChannel, hubEvent));
    }

    public SubscriptionToken subscribe(HubChannel hubChannel, HubEventFilter hubEventFilter, HubSubscriber hubSubscriber) {
        Objects.requireNonNull(hubChannel);
        Objects.requireNonNull(hubEventFilter);
        Objects.requireNonNull(hubSubscriber);
        SubscriptionToken create = SubscriptionToken.create();
        synchronized (this.subscriptions) {
            this.subscriptions.add(new Subscription(create, hubChannel, hubEventFilter, hubSubscriber));
        }
        return create;
    }

    public void unsubscribe(SubscriptionToken subscriptionToken) {
        Objects.requireNonNull(subscriptionToken);
        synchronized (this.subscriptions) {
            try {
                Iterator it = this.subscriptions.iterator();
                while (it.hasNext()) {
                    if (((Subscription) it.next()).getSubscriptionToken().equals(subscriptionToken)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Void getEscapeHatch() {
        return null;
    }

    public SubscriptionToken subscribe(HubChannel hubChannel, HubSubscriber hubSubscriber) {
        return subscribe(hubChannel, HubEventFilters.always(), hubSubscriber);
    }
}
