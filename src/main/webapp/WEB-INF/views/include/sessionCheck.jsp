<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	//세션을 체크
	const path = $('#contextpath').val();
	
	if(!'${sessionScope.mid}'){
		alert('로그인 후 이용하세요');
		location.href='${path}/login';
	}
</script>