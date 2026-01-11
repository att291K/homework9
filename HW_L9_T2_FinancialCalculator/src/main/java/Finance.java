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

@WebServlet("/finance")
public class Finance extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceUrl = classLoader.getResource("calculator.html");
        String path = Objects.requireNonNull(resourceUrl).getPath();
        try (FileReader fr = new FileReader(path)) {
            var bodyResponse = fr.readAllAsString();
            printWriter.write(bodyResponse);
        }
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        ClassLoader classLoader = getClass().getClassLoader();

        String summString = req.getParameter("summ");
        String percentString = req.getParameter("percent");
        String yearsString = req.getParameter("years");

        double summ = 0.0;
        double result = 0.0;
        try {
            summ = Double.parseDouble(summString);
            var percent = Double.parseDouble(percentString);
            var years = Double.parseDouble(yearsString);
            result = summ + summ * percent / 100 * years;
        }
        catch (Exception ex){
            URL resourceUrl = classLoader.getResource("error.html");
            String path = Objects.requireNonNull(resourceUrl).getPath();
            try (FileReader fr = new FileReader(path)) {
                var bodyResponse = fr.readAllAsString();
                String bodyResponse2 = bodyResponse.replace("#text#", "Неверный формат данных </p><p>Скорректируйте значения ");
                printWriter.write(bodyResponse2);
            }
            printWriter.close();
        }

        if (summ < 50000.0){
            URL resourceUrl = classLoader.getResource("error.html");
            String path = Objects.requireNonNull(resourceUrl).getPath();
            try (FileReader fr = new FileReader(path)) {
                var bodyResponse = fr.readAllAsString();
                String bodyResponse2 = bodyResponse.replace("#text#", "Минимальная сумма на момент </p><p> открытия вклада 50 000 рублей");
                printWriter.write(bodyResponse2);
            }
            printWriter.close();
        }
        else{
            URL resourceUrl = classLoader.getResource("result.html");
            String path = Objects.requireNonNull(resourceUrl).getPath();
            try (FileReader fr = new FileReader(path)) {
                var bodyResponse = fr.readAllAsString();
                String res = String.format( "Итоговая сумма %.2f рублей", result);
                String bodyResponse2 = bodyResponse.replace("#text#", res);
                printWriter.write(bodyResponse2);
            }
            printWriter.close();
        }




    }
}
