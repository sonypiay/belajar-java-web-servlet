package programmer_zaman_now.webservlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

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
    void getPathResource() {
//        Path path = Path.of(getClass().getResource("/html/form.html").getPath());
//        String html = Files.readString(path);
        String resource = getClass().getClassLoader().getResource("html/form.html").getPath();
        Path path = Path.of(resource);
        System.out.println(Files.exists(path));
    }
}
