package pl.edu.pjwstk.jaz;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("hello")
public class AverageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String average = req.getParameter("average");

        String[] arr = average.split(",");
        int Sum = 0;
        for (int i = 0; i < arr.length; i++){
            Sum = Sum + Integer.parseInt(arr[i]);
        }
        double aver = (double)Sum/(double)arr.length;

        resp.setStatus(200);
        resp.setContentType("text/plain");

        var respWriter = resp.getWriter();

        respWriter.println("Average of " + average + " is " + aver);
    }
}