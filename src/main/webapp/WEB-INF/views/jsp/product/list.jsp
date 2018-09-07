<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        table {
            border-collapse: collapse;
        }

        table, td, th {
            border: 1px solid black;
        }

    </style>
</head>

<body>
<h2>Product List</h2>
<table>
    <col width="130">
    <col width="130">
    <col width="130">
    <tr>
        <td>
            <p>ID</p>
        </td>
        <td>
            <p>Name</p>
        </td>
        <td>
            <p>Price</p>
        </td>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>
                <c:out value="${product.getId()}"/>
            </td>
            <td>
                <c:out value="${product.getName()}"/>
            </td>
            <td>
                <c:out value="${product.getPrice()}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>