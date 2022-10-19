package no.kristina.library;
import org.eclipse.jetty.server.Server;

import java.net.MalformedURLException;
import java.net.URL;

public class LibraryServer {
    private final Server server;
    public LibraryServer(int port) {
        this.server = new Server(0);

    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public URL getURL() throws MalformedURLException {
        return server.getURI().toURL();
    }

    public void start() throws Exception {
        server.start();
    }
}
