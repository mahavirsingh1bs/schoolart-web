<%-- 
    Document   : take_exam
    Created on : Oct 8, 2014, 10:00:01 AM
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
    <title>Schoolart | Take Exam</title>
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
                    <div class="heading">Take Exam</div>
                    <div class="sub-heading">Please Select the Exam...</div>
                </div>
            </div>
        </div>
            
        <div class="filed-area">
            <table name="exam_table" align="center" width="900px">
                <div>
                <tr>
                    <td><div class="title">Exam:</div></td>
                    <td>
                        <select name="exam" class="form-control">
                        </select>
                    </td>

                </tr>
                </div>
            </table>
            <br/>
            <table name="question_table" align="center" width="900px">
        
            </table>
        </div>
            
        <br/><br/>
        <div class="action-area" style="width:70%">
            <button name="submit" class="btn btn-primary">Submit</button>
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
            var types = ["VERY_SHORT", "SHORT", "LONG", "FILL_IN_THE_BLANK", "DEFINE", "MATCH", "TRUE_FALSE"];
            $.ajax({
                url: "exams",
                type: 'GET',
                async: false,
                dataType: 'json',
                success: function(data) {
                    $('select[name=exam]').text('');
                    $('select[name=exam]').append('<option value="-1">select</option>');
                    if (data) {
                        for (var i = 0; i < data.length; i++) {
                            $('select[name=exam]').append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
                        }
                    }
                }, error: function (data) {
                    console.log('we got error while getting exams');
                    console.log(data);
                }
            });
            
            $('select[name=exam]').on('change', function() {
                var examId = $('select[name=exam] :selected').val();
                $.ajax({
                    url: "exam/" + examId,
                    type: 'GET',
                    async: false,
                    dataType: 'json',
                    success: function(data) {
                        console.log(data);
                        $('table[name=question_table]').html('');
                        if (data) {
                            var $question_table = $('table[name=question_table]');
                            var section_no = 1;
                            for (var i = 0; i < types.length; i++) {
                                var questions = data[types[i]];
                                if (typeof questions !== 'undefined' && questions.length > 0) {
                                    var section_char = String.fromCharCode(64 + section_no++);
                                    $question_table.append('<tr></tr><tr></tr>');
                                    var $section_tr = $('<tr>');
                                    $section_tr.append('<td></td><td></td>');
                                    $section_tr.append('<td class="_section_title_td" style="color: #637728;"><label>' + section_char + '. </label><label>Please give the answer to ' + types[i] + ' questions.</label>');
                                    $question_table.append($section_tr);
                                }

                                var question_no = 1;
                                for (var j = 0; (typeof questions !== 'undefined') && j < questions.length; j++) {
                                    var $question_tr = $('<tr class="_question_title_tr" style="height: 35px; margin-top: 40px; vertical-align: bottom;">');
                                    $question_tr.append('<td><input type="hidden" value="' + questions[j].id + '"/><td/>');
                                    $question_tr.append('<td><label>Q.' + question_no++ + ' </label><label>' + questions[j].question + '</label><td/>');
                                    $question_table.append($question_tr);
                                    var $answer_tr = $('<tr>');
                                    if (types[i] === 'VERY_SHORT') {
                                        $answer_tr.append('<td><td/>');
                                        $answer_tr.append('<td><label>Ans. &nbsp;&nbsp;</label><input type="text" size="25" /><td/>');
                                    } else if (types[i] === 'SHORT' || types[i] === 'DEFINE') {
                                        $answer_tr.append('<td><td/>');
                                        $answer_tr.append('<td><label>Ans. &nbsp;&nbsp;</label><textarea rows="2" cols="50"></textarea><td/>');
                                    } else if (types[i] === 'LONG') {
                                        $answer_tr.append('<td><td/>');
                                        $answer_tr.append('<td><label>Ans. &nbsp;&nbsp;</label><textarea rows="5" cols="50"></textarea><td/>');
                                    } else if (types[i] === 'FILL_IN_THE_BLANK') {
                                        $answer_tr.append('<td><td/>');
                                        var $td = $('<td>');
                                        $td.append('<label>Ans. &nbsp;&nbsp;</label>');
                                        var answers = questions[j].answer.split(',');
                                        for (var k = 0; k < answers.length - 1; k++) {
                                            $td.append('<input type="text" size="15"/>,&nbsp;');
                                        }
                                        $td.append('<input type="text" size="15"/>');
                                        $answer_tr.append($td);
                                    } else if (types[i] === 'TRUE_FALSE') {
                                        $answer_tr.append('<td><td/>');
                                        $answer_tr.append('<td><label>Ans. &nbsp;&nbsp;</label><input type="checkbox">True</input>&nbsp;<input type="checkbox">False</input><td/>');
                                    }
                                    $question_table.append($answer_tr);
                                }
                            }
                        }
                    }, error: function (data) {
                        console.log('we got error while getting subjects');
                        console.log(data);
                    }
                });
            });
        });
    </script>
</body>
</html>
