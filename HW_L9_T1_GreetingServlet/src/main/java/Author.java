import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/author")
public class Author extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");

        printWriter.println("<title>Author</title>");
        printWriter.println("<link rel=\"stylesheet\" href=\"style.css\">");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>Информация об авторе</h1>");
        printWriter.println("<p>Фамилия: Иванов</p>");
        printWriter.println("<p>Имя: Иван</p>");
        printWriter.println("<p>Отчество: Иванович</p>");
        printWriter.println("<p>Телефон: 8-920-920-920-11-11</p>");
        printWriter.println("<p>Хобби: лыжи, аквариум </p>");
        printWriter.println("<p>Bitbacket: http://bitbaket/ivan</p>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}

