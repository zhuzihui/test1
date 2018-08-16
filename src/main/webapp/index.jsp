<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>


	
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		alert("=================");
		 $.ajax({
			url : 'deposite',
			method : 'POST',
			data : $("#myform").serialize(),
			dataType : 'JSON',
			success : function(data) {
				if (data.code == 1) {
					alert("存款成功");
				} else {

					alert("存款失败.." + data.msg);
				}
			}

		});  
	});
})
	
	
		/* function submit() {
			alert("=================");
			$.ajax({
				url : 'deposite',
				method : 'POST',
				data : $("#myform").serialize(),
				dataType : 'JSON',
				success : function(data) {
					if (data.code == 1) {
						alert("存款成功");
					} else {

						alert("存款失败.." + data.msg);
					}
				}

			}); 
		} */

	</script>

	<form id="myform" action="deposite" method="post">
		<!-- <input type="hidden"  name="op" value="deposite"/> -->
		zhanghao：<input type="text" name="accountid" /><br /> 
		jine：<input	type="text" name="balance" /> 
		<!-- <input type="button"  value="提交" onclick="submit()"/> -->
			<input type="button" value="提交" id="btn" />

		<!-- <a id="sub" href="javascript:void(0)" target="iframeContent">提交</a> -->

	</form>

	<img src="images/1.png" width="300px" height="300px" />










</body>
</html>