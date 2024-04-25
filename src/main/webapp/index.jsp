<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product Discount Calculator</title>
</head>
<body>
  <h1>Product Discount Calculator</h1>
  <form action="${pageContext.request.contextPath}/display-discount" method="post">
    <input type="text" name="ProductDescription" placeholder="Product Description"/><br/>
    <input type="number" name="ListPrice" placeholder="List Price"/><br/>
    <input type = "number" name="DiscountPercent" placeholder="DiscountPercent %"/><br/>
    <input type="submit" id="Calculate Discount" value="Calculate Discount">
  </form>
</body>
</html>