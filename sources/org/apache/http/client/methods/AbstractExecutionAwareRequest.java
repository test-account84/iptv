package org.apache.http.client.methods;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.HttpRequest;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.HeaderGroup;
import org.apache.http.params.HttpParams;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class AbstractExecutionAwareRequest extends AbstractHttpMessage implements HttpExecutionAware, AbortableHttpRequest, Cloneable, HttpRequest {
    private final AtomicBoolean aborted = new AtomicBoolean(false);
    private final AtomicReference cancellableRef = new AtomicReference((Object) null);

    public class 1 implements Cancellable {
        final /* synthetic */ ClientConnectionRequest val$connRequest;

        public 1(ClientConnectionRequest clientConnectionRequest) {
            this.val$connRequest = clientConnectionRequest;
        }

        public boolean cancel() {
            this.val$connRequest.abortRequest();
            return true;
        }
    }

    public class 2 implements Cancellable {
        final /* synthetic */ ConnectionReleaseTrigger val$releaseTrigger;

        public 2(ConnectionReleaseTrigger connectionReleaseTrigger) {
            this.val$releaseTrigger = connectionReleaseTrigger;
        }

        public boolean cancel() {
            try {
                this.val$releaseTrigger.abortConnection();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public void abort() {
        Cancellable cancellable;
        if (!this.aborted.compareAndSet(false, true) || (cancellable = (Cancellable) this.cancellableRef.getAndSet((Object) null)) == null) {
            return;
        }
        cancellable.cancel();
    }

    public Object clone() throws CloneNotSupportedException {
        AbstractExecutionAwareRequest abstractExecutionAwareRequest = (AbstractExecutionAwareRequest) super.clone();
        abstractExecutionAwareRequest.headergroup = (HeaderGroup) CloneUtils.cloneObject(this.headergroup);
        abstractExecutionAwareRequest.params = (HttpParams) CloneUtils.cloneObject(this.params);
        return abstractExecutionAwareRequest;
    }

    public void completed() {
        this.cancellableRef.set((Object) null);
    }

    public boolean isAborted() {
        return this.aborted.get();
    }

    public void reset() {
        Cancellable cancellable = (Cancellable) this.cancellableRef.getAndSet((Object) null);
        if (cancellable != null) {
            cancellable.cancel();
        }
        this.aborted.set(false);
    }

    public void setCancellable(Cancellable cancellable) {
        if (this.aborted.get()) {
            return;
        }
        this.cancellableRef.set(cancellable);
    }

    @Deprecated
    public void setConnectionRequest(ClientConnectionRequest clientConnectionRequest) {
        setCancellable(new 1(clientConnectionRequest));
    }

    @Deprecated
    public void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger) {
        setCancellable(new 2(connectionReleaseTrigger));
    }
}
