package programmer_zaman_now.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import programmer_zaman_now.webservlet.model.SayHelloRequest;
import programmer_zaman_now.webservlet.util.JsonUtil;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/api/sayhello")
public class ApiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SayHelloRequest sayHelloRequest = JsonUtil.objectMapper().readValue(
                req.getReader(),
                SayHelloRequest.class
        );

        String sayHello = "Hello " + sayHelloRequest.getFirstName() + " " + sayHelloRequest.getLastName();
        Map<String, Object> response = Map.of(
                "data", sayHello
        );
        String jsonResponse = JsonUtil.objectMapper().writeValueAsString(response);

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(jsonResponse);
    }
}
