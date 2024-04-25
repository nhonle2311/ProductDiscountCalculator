package org.example.ex_product_discount_calculator;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "CalculateServlet" , urlPatterns = "/display-discount")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productDescription = req.getParameter("ProductDescription");
        String listPriceStr = req.getParameter("ListPrice");
        String discountPercentStr = req.getParameter("DiscountPercent");

        if (listPriceStr == null || listPriceStr.isEmpty() || discountPercentStr == null || discountPercentStr.isEmpty()) {
            PrintWriter writer = resp.getWriter();
            resp.setContentType("text/html;charset=UTF-8");
            writer.println("<html><head><title>Error</title></head><body>");
            writer.println("<h1>Error: Missing values!</h1>");
            writer.println("<p>List Price and Discount Percent are required.</p>");
            writer.println("</body></html>");
            return;
        }

        float listPrice = Float.parseFloat(listPriceStr);
        float discountPercent = Float.parseFloat(discountPercentStr);

        float discountAmount = listPrice * discountPercent / 100;
        float discountPrice = listPrice - discountAmount;

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        writer.println("<html><head><title>Discount Result</title></head><body>");
        writer.println("<h1>Product Discount Calculator</h1>");
        if (productDescription != null && !productDescription.isEmpty()) {
            writer.println("<p>Product Description: " + productDescription + "</p>");
        }
        writer.println("<p>List Price: " + listPrice + "</p>");
        writer.println("<p>Discount Percent: " + discountPercent + "%</p>");
        writer.println("<p>Discount Amount: " + discountAmount + "</p>");
        writer.println("<p>Discount Price: " + discountPrice + "</p>");
        writer.println("</body></html>");
    }
}
