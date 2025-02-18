package programmer_zaman_now.webservlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourcePathTest {

    @Test
    void checkHtml() {
        Path htmlPath = Path.of("src/main/resources/html");
        Path htmlFile = Path.of("src/main/resources/html/form.html");

        Assertions.assertTrue(Files.isDirectory(htmlPath));

        Assertions.assertFalse(Files.isDirectory(htmlFile));
        Assertions.assertTrue(Files.exists(htmlFile));
    }

    @Test
    void getPathResource() throws IOException, URISyntaxException {
        URI uri = getClass().getClassLoader().getResource("html/form.html").toURI();
        String resource = Path.of(uri).toString();
        Path path = Path.of(resource);

        System.out.println(Files.readString(path));
    }
}
