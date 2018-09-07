<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Gradle + Spring MVC</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>


<div>
    <div>
        <br><br>
        <h1>${title}</h1>
        <p>
            <c:if test="${not empty msg}">
                Hello ${msg}
            </c:if>
            <c:if test="${empty msg}">
                Welcome Welcome!
            </c:if>
        </p>

        <h2>Spring Page Redirection</h2>
        <p>Click below button to redirect the result to new page</p>
        <form:form method="GET" action="/s4/redirect">
            <table>
                <tr>
                    <td>
                        <input type="submit" value="Redirect Page"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>


<spring:url value="/resources/core/css/hello.js" var="coreJs"/>
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs"/>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>