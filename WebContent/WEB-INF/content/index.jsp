<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="header.jsp"/>
<body>
<nav class="navbar navbar-default">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Struts2 Bootstrap Plugin Showcase - <s:text name="showcase.version"/></a>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
            <s:url var="index_url" action="index"/>
            <li class="active"><s:a href="%{index_url}">Home</s:a></li>
            <s:url var="about_url" action="about"/>
            <li><s:a href="%{about_url}">About</s:a></li>
            <li><a href="https://github.com/struts-community-plugins/struts2-bootstrap/">Project</a></li>
        </ul>
    </div>
</nav>

<s:form theme="simple" cssClass="well form-search">
    <s:textfield
            placeholder="Login"
            name="login"
            tooltip="Enter your Name here"/>

    <s:password
            placeholder="Password"
            name="password"/>

    <s:submit cssClass="btn btn-primary"/>
</s:form>
</body>
<jsp:include page="footer.jsp"/>