<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/include/dialog.jsp"%>
</head>
<body>
<script>
function dialog_ok(){
	alert("ok!");
}
function dialog_cancel(){
	alert("cancel!");
}
function show_msg(){
	$.showDialog(1,"确认窗口！","dialog_ok();");
}
function show_confrim(){
	$.showDialog(2,"确认窗口！","dialog_ok();","dialog_cancel();");
}
</script>
<input type="button" value="message" onclick="show_msg()"/> 
<input type="button" value="confirm" onclick="show_confrim()"/> 
</body>
</html>