<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.nodes.Element" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    String keyword = "Gyeongbok restaurant";
    double desiredRating = 3.5;
    String restaurantLink = getRestaurantLinkWithRating(keyword, desiredRating);

    request.setAttribute("desiredRating", desiredRating);
    request.setAttribute("restaurantLink", restaurantLink);
%>

<%
    public static String getRestaurantLinkWithRating(String keyword, double desiredRating) {
        try {
            // Perform a web search
            Document document = Jsoup.connect("https://www.google.com/search?q=" + keyword).get();

            // Find the search results
            Elements searchResults = document.select("div.r > a");

            // Iterate over the search results and find the desired link with the desired rating
            for (Element result : searchResults) {
                String link = result.attr("href");
                double rating = getRatingFromLink(link);
                if (rating >= desiredRating) {
                    return link;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // If the restaurant link with the desired rating is not found
    }

    public static double getRatingFromLink(String link) {
        // Implement your logic to extract the rating from the link
        // This depends on the structure and format of the links from the search results
        // You may need to use regular expressions or other techniques to extract the rating
        // Return the rating as a double value

        // Example: Extracting the rating from a link containing "3.5-star" or "4.0"
        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(link);
        if (matcher.find()) {
            String ratingStr = matcher.group(1);
            return Double.parseDouble(ratingStr);
        }

        return 0.0; // If the rating cannot be extracted or is not available
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Restaurant Search Results</title>
</head>
<body>
    <h1>Restaurant Search Results</h1>
    <p>Link for the restaurant with a rating of <%= request.getAttribute("desiredRating") %>: <%= request.getAttribute("restaurantLink") %></p>
</body>
</html>
