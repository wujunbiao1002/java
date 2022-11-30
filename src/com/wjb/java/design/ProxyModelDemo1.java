package com.wjb.java.design;

/**
 * <b><code>Proxy</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/10 18:28.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class ProxyModelDemo1 {
    public static void main(String[] args) {
        ProxyServer proxyServer = new ProxyServer(new Server());
        proxyServer.browse();
    }
}

interface Network {
    void browse();
}

class Server implements Network {

    @Override
    public void browse() {
        System.out.println("Server游览");
    }
}

class ProxyServer implements Network {

    private final Server server;

    ProxyServer(Network network) {
        server = (Server) network;
    }

    void check() {
        System.out.println("进行联网测试");
    }

    @Override
    public void browse() {
        check();
        server.browse();
    }
}
