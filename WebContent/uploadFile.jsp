<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload File</title>

<style>

.btn-group .button {
    background-image:url('bu7.jpg');
    border: 2px solid #FAFBFD;
    color: black;
    padding: 5px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 30px;
    cursor: pointer;
    float: left;
    width:25%;
   
}

.btn-group .button:hover {
    background-color: white;
}

body{
    padding: 25px;
    background: url(BG6.jpg);
    background-repeat: no-repeat;
    background-size: 100% 100%;
}

        .button2 {
            background-color: black;
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 25px;
            margin: 4px 2px;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            cursor: pointer;
        }

        .button1 {
            background-color: white;
            color: black;
            border: 4px solid black;
            border-radius: 25px;
            width: 25%;
        }

        .button1:hover {
            background-color:black;
            color: white;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
        }

        input { font-size: 25px; }
</style>

</head>
<body>
    <%@include file="header.jsp" %>

<table cellpadding="80">
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
</table>

<table cellpadding="80">
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
</table>

<%--adding upload button--%>
<div align="center">
    <form name="upload" action="<%=request.getContextPath() %>/upload" method="POST" enctype="multipart/form-data">
    <table cellpadding="10">
    	<tr>
    		<td><b><font size="6">Upload File</font></b></td>
    	</tr>
    
        <tr>            
            <td><input type="file" name="document" /></td>
        </tr>
    </table>
        <button class="button2 button1" name="UploadButton">Upload</button>
</form>
</div>

</body>
</html>
