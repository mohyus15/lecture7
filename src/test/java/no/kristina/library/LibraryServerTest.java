package no.kristina.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class LibraryServerTest {

    private LibraryServer server;

    @BeforeEach
    void setUp() throws Exception {
        server = new LibraryServer(0);
        server.start();
    }

    @Test
    void shoudShowFrontPage() throws IOException {
        var connection = openConnection();
        assertThat(connection.getResponseCode()).isEqualTo(200);
        assertThat(connection.getInputStream()).asString(StandardCharsets.UTF_8).contains("<title>kristina library</title>");
    }
    @Test
    void shoudShowdynamicContent() throws IOException {
        var connection = openConnection('/api/books');
        assertThat(connection.getResponseCode()).isEqualTo(200);
        assertThat(connection.getInputStream()).asString(StandardCharsets.UTF_8).contains("[{\"title\":\"Hello World\"");
    }

    private HttpURLConnection openConnection() throws IOException {
        return (HttpURLConnection) server.getURL().openConnection();
    }
}