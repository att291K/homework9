import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");

        printWriter.println("<title>Calculator</title>");
        printWriter.println("<link rel=\"stylesheet\" href=\"style.css\">");
        printWriter.println("</head>");
        printWriter.println("<body>");

        printWriter.println("<a href=\"finance\"><h1>Финансовый калькулятор</h1></a>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}