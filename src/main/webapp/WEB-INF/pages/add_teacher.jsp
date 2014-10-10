<%-- 
    Document   : add_teacher
    Created on : Oct 10, 2014, 12:07:17 PM
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
    <title>Schoolart | Add Teacher</title>
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
                    <div class="heading">New Teacher</div>
                    <div class="sub-heading">Please teacher details...</div>
                </div>
            </div>
        </div>
        
        <div class="filed-area">
            <table name="exam_table" align="center" width="900px">
                <tr>
                    <td><div class="title">First Name:</div></td>
                    <td>
                        <p style="width:350px;">
                        <input type="text" name="firstName" class="form-control" />
                        </p>
                    </td>
                </tr>
                <tr>
                    <td><div class="title">Last Name:</div></td>
                    <td>
                        <p style="width:350px;">
                        <input type="text" name="lastName" class="form-control" />
                        </p>
                    </td>
                </tr>
                <tr>
                    <td><div class="title">Address:</div></td>
                    <td>
                        <p style="width:350px;">
                        
                        </p>
                    </td>
                </tr>
                <tr>
                    <td><div class="title">Street:</div></td>
                    <td>
                        <p style="width:350px;">
                        <input type="text" name="street" class="form-control" />
                        </p>
                    </td>
                </tr>
                <tr>
                    <td><div class="title">City:</div></td>
                    <td>
                        <p style="width:350px;">
                        <input type="text" name="city" class="form-control" />
                        </p>
                    </td>
                </tr>
                <tr>
                    <td><div class="title">Zipcode:</div></td>
                    <td>
                        <p style="width:350px;">
                        <input type="text" name="zipcode" class="form-control" />
                        </p>
                    </td>
                </tr>
            </table>
            
        </div>
            
        <br/><br/>
        <div class="action-area" style="width:70%">
            <button name="create" class="btn btn-primary">Create</button>
            <div style="clear:both;"></div>
        </div>
        
        <br/><br/>
        <div class="footer">
            <div class="reserved">All Rights Reserved @ Schoolart Exam</div>
        </div>
    </div>
    <script type='text/javascript' src='<%= request.getContextPath()%>/resources/scripts/less-1.7.3.min.js'></script>
    <script type='text/javascript' src='<%= request.getContextPath()%>/resources/scripts/jquery-1.10.2.min.js'></script>
    <script src="<%= request.getContextPath()%>/resources/scripts/bootstrap.js"></script>
    <script>
        $(document).ready(function() {
            $('button[name=create]').on('click', function() {
                var firstName = $('input[name=firstName]').val();
                var lastName = $('input[name=lastName]').val();
                var street = $('input[name=street]').val();
                var city = $('input[name=city]').val();
                var zipcode = $('input[name=zipcode]').val();
                var data = { "firstName" : firstName, "lastName" : lastName, "street" : street, "city" : city, "zipcode" : zipcode };
                $.ajax({
                    url: "addTeacher",
                    type: 'POST',
                    data: window.JSON.stringify(data),
                    async: false,
                    dataType: "json",
                    headers: {
                        "Accept" : "application/json",
                        "Content-Type" : "application/json"
                    },
                    success: function(data) {
                        console.log("teacher created successfully");
                    }, error: function (data) {
                        console.log('we got error while getting exams');
                        console.log(data);
                    }
                });
            });
        });
    </script>
</body>
</html>
