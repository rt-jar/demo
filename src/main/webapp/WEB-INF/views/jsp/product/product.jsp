<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Product Input Page</title>
</head>

<style>
    .error {
        color: #ff0000;
    }

    .errorblock {
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }
</style>

<body>
<h2>Product Information</h2>
<%--@elvariable id="product" type=""--%>
<form:form method="POST" action="/s4/product/add" modelAttribute="product">
    <form:errors path="*" cssClass="errorblock" element="div"/>
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>