<%-- 
    Document   : take_exam
    Created on : Oct 9, 2014, 10:00:01 AM
    Author     : mahavir.singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%= request.getContextPath()%>/docs-assets/ico/favicon.png">
    <!--
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=request.getContextPath()%>/resources/styles/schoolart.css" rel="stylesheet">
    -->
    <title>Schoolart | Sign In</title>
    <!-- Bootstrap core CSS -->
    <link href="<%= request.getContextPath()%>/resources/styles/bootstrap.css" rel="stylesheet">
    <!-- Bootstrap CSS Ends -->
    <!-- Other CSS for pages -->
    <link rel="stylesheet/less" type="text/css"  href="<%= request.getContextPath()%>/resources/styles/style.less">
    <link href="<%= request.getContextPath()%>/resources/styles/font-awesome.css" rel="stylesheet">
</head>
<body>
    
    <div class="main-container">
        <div class="header">
            <div class="logo">
                <img src="<%= request.getContextPath()%>/resources/images/logo.png"/>
            </div>
        </div>
            
        <div class="login-area">
            <div class="login-box">
                <div class="title-box">
                    <div class="heading">Sign In</div>
                    <div class="sub-heading">Please enter credentials...</div>
                </div>
            </div>
        </div>
        
        <form:form name="loginForm" action="login" method="POST" commandName="loginBean">
        <div class="filed-area">
            <table name="exam_table" align="center" width="900px">
                <tr>
                    <td><div class="title">Username:</div></td>
                    <td>
                        <p style="width:350px;">
                        <form:input path="username" cssClass="form-control" />
                        </p>
                    </td>
                </tr>
                <tr>
                    <td><div class="title">Password:</div></td>
                    <td>
                        <p style="width:350px;">
                        <form:password path="password" cssClass="form-control" />
                        </p>
                    </td>
                </tr>
            </table>
            
        </div>
            
        <br/><br/>
        <div class="action-area" style="width:70%">
            <input type="submit" value="Sign In" class="btn btn-primary" />
            <div style="clear:both;"></div>
        </div>
         </form:form>
        
        <br/><br/>
        <div class="footer">
            <div class="reserved">All Rights Reserved @ Schoolart Exam</div>
        </div>
    </div>
    <script type='text/javascript' src='<%= request.getContextPath()%>/resources/scripts/less-1.7.3.min.js'></script>
    <script type='text/javascript' src='<%= request.getContextPath()%>/resources/scripts/jquery-1.10.2.min.js'></script>
    <script src="<%= request.getContextPath()%>/resources/scripts/bootstrap.js"></script>
</body>
</html>
