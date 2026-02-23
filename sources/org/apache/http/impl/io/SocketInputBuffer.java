package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.io.EofSensor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private boolean eof;
    private final Socket socket;

    public SocketInputBuffer(Socket socket, int i, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        this.socket = socket;
        this.eof = false;
        i = i < 0 ? socket.getReceiveBufferSize() : i;
        init(socket.getInputStream(), i < 1024 ? 1024 : i, httpParams);
    }

    public int fillBuffer() throws IOException {
        int fillBuffer = super.fillBuffer();
        this.eof = fillBuffer == -1;
        return fillBuffer;
    }

    public boolean isDataAvailable(int i) throws IOException {
        boolean hasBufferedData = hasBufferedData();
        if (hasBufferedData) {
            return hasBufferedData;
        }
        int soTimeout = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(i);
            fillBuffer();
            return hasBufferedData();
        } finally {
            this.socket.setSoTimeout(soTimeout);
        }
    }

    public boolean isEof() {
        return this.eof;
    }
}
