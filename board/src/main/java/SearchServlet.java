import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = "Gyeongbok restaurant";
        double desiredRating = 3.5;
        String restaurantLink = getRestaurantLinkWithRating(keyword, desiredRating);

        request.setAttribute("desiredRating", desiredRating);
        request.setAttribute("restaurantLink", restaurantLink);
        request.getRequestDispatcher("RestaurantSearch.jsp").forward(request, response);
    }

    public static String getRestaurantLinkWithRating(String keyword, double desiredRating) {
        // The logic for getting the restaurant link with the desired rating goes here
        // You can use the code provided earlier for this method
        // Remember to import necessary classes (e.g., org.jsoup) for performing web scraping

        return null; // Replace this with the actual restaurant link with the desired rating
    }
}
