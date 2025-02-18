package programmer_zaman_now.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@WebServlet(urlPatterns = "/form-upload")
@MultipartConfig
public class FormUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            URI uriFile = getClass().getClassLoader().getResource("html/upload.html").toURI();
            String getPath = Path.of(uriFile).toString();
            Path path = Path.of(uriFile);
            String html = Files.readString(path);

            resp.setHeader("Content-Type", "text/html");
            resp.getWriter().println(html);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Part profile = req.getPart("profile");

        Path uploadLocation = Path.of("upload/" + UUID.randomUUID().toString() + profile.getSubmittedFileName());
        Files.copy(profile.getInputStream(), uploadLocation);

        String response = "Hello " + name + ". Your profile image saved in " + uploadLocation.toAbsolutePath();
        resp.getWriter().println(response);
    }
}
