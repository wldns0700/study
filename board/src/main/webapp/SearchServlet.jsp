<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="com.example.SearchServlet" %>

<%
    String keyword = "Gyeongbok restaurant";
    double desiredRating = 3.5;
    String restaurantLink = SearchServlet.getRestaurantLinkWithRating(keyword, desiredRating);

    request.setAttribute("desiredRating", desiredRating);
    request.setAttribute("restaurantLink", restaurantLink);
    request.getRequestDispatcher("RestaurantSearch.jsp").forward(request, response);
%>
