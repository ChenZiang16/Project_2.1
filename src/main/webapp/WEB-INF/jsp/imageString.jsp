<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>GET IMAGE</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name='referrer' content= 'no-referrer'>
	<script src="./js/jquery.min.js"></script>
</head>
<body>
	<div class = 'imgDiv' style='display:none'>
		<img src = '${pageContext.request.contextPath }/getImage' alt= '加载图片失败' height='200' width='300'></img>
	</div>
	
	<form action = "${pageContext.request.contextPath }/storeImage.do"  method='post'
			enctype="multipart/form-data">
	
		<input type="file" name="file" value="选择图片"/>	
		<input type = 'submit' value = '上传''/>
		<input type = 'button' value = 'GetImage' onclick = 'getImage()'/>
		
	
	</form>
	
	<script type="text/javascript">
	
		function getImage(){
			$('.imgDiv').show();
		}
	
	</script>
	
</body>
</html>