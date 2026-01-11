import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Objects;

@WebServlet("/style.css")
public class Style extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/css");
        PrintWriter printWriter = resp.getWriter();

        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceUrl = classLoader.getResource("style.css");
        String path = Objects.requireNonNull(resourceUrl).getPath();
        try (FileReader fr = new FileReader(path)) {
            var bodyResponse = fr.readAllAsString();
            printWriter.write(bodyResponse);
        }
        printWriter.close();
    }
}