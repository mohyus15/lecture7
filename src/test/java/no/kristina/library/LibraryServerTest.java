package no.kristina.library;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class LibraryServerTest {
    @Test
    void shoudShowFrontPage() throws IOException {
        var server  = new LibraryServer(0);
        var con = (HttpURLConnection)server.getURL().openConnection();
        assertThat(con.getResponseCode()).isEqualTo(200);
       assertThat(con.getErrorStream()).asString(StandardCharsets.UTF_8).contains("<title>kristania Library</title>");
    }
}