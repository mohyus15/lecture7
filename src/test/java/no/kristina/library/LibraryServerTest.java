package no.kristina.library;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class LibraryServerTest {
    @Test
    void shoudShowFrontPage() throws Exception {
        var server  = new LibraryServer(0);
        server.start();
        var connection = (HttpURLConnection)server.getURL().openConnection();
        assertThat(connection.getResponseCode()).isEqualTo(200);
        assertThat(connection.getInputStream()).asString(StandardCharsets.UTF_8).contains("<title>kristina library</title>");
    }
}