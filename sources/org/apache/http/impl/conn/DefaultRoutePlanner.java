package org.apache.http.impl.conn;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.protocol.HttpContext;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultRoutePlanner implements HttpRoutePlanner {
    private final SchemePortResolver schemePortResolver;

    public DefaultRoutePlanner(SchemePortResolver schemePortResolver) {
        this.schemePortResolver = schemePortResolver == null ? DefaultSchemePortResolver.INSTANCE : schemePortResolver;
    }

    public HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        return null;
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    public org.apache.http.conn.routing.HttpRoute determineRoute(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        */
    /*  JADX ERROR: Method generation error
        LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r4v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(Unknown Source:28)
        	at l111lLIIl11iL.L111LiLLi1iiliL.lILLi11Li1lll(Unknown Source:44)
        	at l111lLIIl11iL.L111LiLLi1iiliL.iliLiI1iLLIL(Unknown Source:469)
        	at l111lLIIl11iL.l1LII1ii11LI11.iLIi1LlIlIil1(Unknown Source:61)
        	at l111lLIIl11iL.l1LII1ii11LI11.LIi1LL1Ilill1l(Unknown Source:22)
        	at l111lLIIl11iL.l1LII1ii11LI11.lL111llILliLi(Unknown Source:12)
        	at l111lLIIl11iL.l1LII1ii11LI11.LlIIlIliLlL1IiL(Unknown Source:0)
        	at l111lLIIl11iL.IIiLliI1l1li1.accept(Unknown Source:6)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.stream.-$$Lambda$Abl7XfE0Z4AgkViLas9vhsO9mjw.accept(Unknown Source:2)
        	at java.util.ArrayList.forEach(ArrayList.java:1262)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:260)
        */
}
