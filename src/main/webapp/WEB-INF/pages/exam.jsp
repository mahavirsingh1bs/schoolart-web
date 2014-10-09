<%-- 
    Document   : exam
    Created on : Oct 6, 2014, 3:46:30 PM
    Author     : mahavir.singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <title>Schoolart | Create Exam</title>
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
                    <div class="heading">New Exam</div>
                    <div class="sub-heading">Please Create Exam Here...</div>
                </div>
            </div>
        </div>
            
        <div class="filed-area">
            <table name="chapter_table" align="center" width="900px">
                <div>
                <tr>
                    <td><div class="title">Class:</div></td>
                    <td>
                        <select name="stuClass" class="form-control">
                        </select>
                    </td>
                    <td><div class="title">Subject:</div></td>
                    <td>
                        <select name="subject" class="form-control">
                        </select>
                    </td>
                    <td><div class="title">Chapters:</div></td>
                    <td>
                        <select name="chapter" class="form-control">   
                        </select>
                    </td>
                    <td>
                        <select name="operand" class="form-control">
                        </select>
                    </td>
                    <td>
                        <select name="toChapter" class="form-control">
                        </select>
                    </td>
                    <td>
                        <a href="#" name="addCriteria">+</a>
                    </td>
                </tr>
                </div>
                <div>
                <tr>
                    <td><div class="title">Exam Name:</div></td>
                    <td>
                        <input type="text" name="examName" class="_exam_name form-control"/>
                    </td>
                </tr>
                </div>
            </table>
            <br/>
            <table name="question_type" align="center" width="900px">
                <div>
                <tr>
                    <td><div class="title">Question Types:</div></td>
                </tr>
                </div>
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
            // $('select[name=subject]').css('display', 'none');
            $.ajax({
                url: "stuClasses",
                type: 'GET',
                async: false,
                dataType: 'json',
                success: function(data) {
                    $('select[name=stuClass]').text('');
                    $('select[name=stuClass]').append('<option value="-1">select</option>');
                    if (data) {
                        for (var i = 0; i < data.length; i++) {
                            $('select[name=stuClass]').append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
                        }
                    }
                }, error: function (data) {
                    console.log('we got error while getting classes');
                    console.log(data);
                }
            });
            
            $.ajax({
                url: "resources/schoolart/json/question_type.json",
                type: 'GET',
                async: false,
                dataType: 'json',
                success: function(data) {
                    if (data) {
                        for (var i = 0; i < data.length; i++) {
                            var $tr = $('<tr>');
                            $tr.append('<td/>');
                            $tr.append('<td class="_question_type_td"><input type="checkbox" value="' + data[i].constant + '" class="_question_type ' + data[i].class + '">' + data[i].name + '</td>');
                            $tr.append('<td class="_no_of_questions_td"><label class="_no_of_question_label">No. Of Questions:</label>&nbsp;&nbsp;<input type="text" size="10" class="_no_of_question"/></td>');
                            $tr.append('<td class="_marks_per_question_td"><label class="_marks_per_question_label">Marks per question:</label>&nbsp;&nbsp;<input type="text" size="10" class="_marks_per_question"/></td>');
                            $('table[name=question_type]').append($tr);
                        }
                    }
                }, error: function (data) {
                    console.log('we got error while getting question types');
                    console.log(data);
                }
            });
            
            $('select[name=stuClass]').on('change', function() {
                var classId = $('select[name=stuClass] :selected').val();
                $.ajax({
                    url: "subjects/" + classId,
                    type: 'GET',
                    async: false,
                    dataType: 'json',
                    success: function(data) {
                        $('select[name=subject]').text('');
                        $('select[name=subject]').append('<option value="-1">select</option>');
                        if (data) {
                            for (var i = 0; i < data.length; i++) {
                                $('select[name=subject]').append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
                            }
                        }
                    }, error: function (data) {
                        console.log('we got error while getting subjects');
                        console.log(data);
                    }
                });
            });
            
            $('select[name=subject]').on('change', function() {
                var subjectId = $('select[name=subject] :selected').val();
                $.ajax({
                    url: "chapters/" + subjectId,
                    type: 'GET',
                    async: false,
                    dataType: 'json',
                    success: function(data) {
                        $('select[name=chapter]').text('');
                        $('select[name=chapter]').append('<option value="-1">All</option>');
                        if (data) {
                            for (var i = 0; i < data.length; i++) {
                                $('select[name=chapter]').append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
                            }
                        }
                    }, error: function (data) {
                        console.log('we got error while getting chapters');
                        console.log(data);
                    }
                });
            });
            
            $('select[name=chapter]').on('change', function() {
                var subjectId = $('select[name=subject] :selected').val();
                var chapterId = $('select[name=chapter] :selected').val();
                if (chapterId !== -1) {
                    $('select[name=operand]').text('');
                    $('select[name=operand]').append('<option value="TO">To</option>');
                    $('select[name=operand]').append('<option value="AND">And</option>');
                    $.ajax({
                        url: "chapters/" + subjectId,
                        type: 'GET',
                        async: false,
                        dataType: 'json',
                        success: function(data) {
                            $('select[name=toChapter]').text('');
                            if (data) {
                                for (var i = 0; i < data.length; i++) {
                                    $('select[name=toChapter]').append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
                                }
                            }
                        }, error: function (data) {
                            console.log('we got error while getting chapters');
                            console.log(data);
                        }
                    });
                }
            });
            
            $('a[name=addCriteria]').on('click', function() {
                var subjectId = $('select[name=subject] :selected').val();
                $.ajax({
                    url: "chapters/" + subjectId,
                    type: 'GET',
                    async: false,
                    dataType: 'json',
                    success: function(data) {
                        var $tr =$('<tr>');
                        $tr.append('<td/><td/><td/><td/><td/><td/>');
                        $tr.append('<td><select class="operand"><option value="TO">To</option><option value="AND">And</option></select>');
                        var $select = $('<select class="chapter">');
                        if (data) {
                            for (var i = 0; i < data.length; i++) {
                                $select.append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
                            }
                            $tr.append($('<td>').append($select));
                            $tr.append('<td><a href="#" name="addCriteria">+</a></td>');
                            $('table[name=chapter_table]').append($tr);
                        }
                    }, error: function (data) {
                        console.log('we got error while getting chapters');
                        console.log(data);
                    }
                });
            });

            $('button[name=create]').on('click', function() {
                var classId = $('select[name=stuClass] :selected').val();
                var subjectId = $('select[name=subject] :selected').val();
                var chapterId = $('select[name=chapter] :selected').val();
                var operandId = $('select[name=operand] :selected').val();
                var toChapterId = $('select[name=toChapter] :selected').val();
                var examName = $('input[name=examName]').val();
                console.log(classId + ' ' + subjectId + ' ' + chapterId + ' ' + operandId + ' ' + toChapterId);
                var chapterCriteria = { "chapter" : chapterId, "operand" : operandId, "next" : { "chapter" : toChapterId }};
                var data = { "examName" : examName, "classId" : classId, "subjectId" : subjectId, "chapterCriteria" : chapterCriteria };
                
                var sections = [];
                $('table[name=question_type] tr').each(function() {
                    if ($(this).find('input[type=checkbox]').is(':checked')) {
                        console.log($(this).find('input[type=checkbox]').val() + ' ' + $(this).find('input[class=_no_of_question]').val() + ' ' + $(this).find('input[class=_marks_per_question]').val());
                        sections.push({ "type" : $(this).find('input[type=checkbox]').val(), "noOfQuestions" : $(this).find('input[class=_no_of_question]').val(), "marksPerQuestion" : $(this).find('input[class=_marks_per_question]').val() });
                    }
                });
                data["sections"] = sections;
                console.log(data);
                console.log(window.JSON.stringify(data));
                
                $.ajax({
                    url: "createExam",
                    type: 'POST',
                    data: window.JSON.stringify(data),
                    async: false,
                    dataType: "json",
                    headers: {
                        "Accept" : "application/json",
                        "Content-Type" : "application/json"
                    },
                    success: function(data) {
                        console.log(data);
                    }, error: function (data) {
                        console.log('we got error while creating exam');
                        console.log(data);
                    }
                });
            });
        });
    </script>
</body>
</html>
