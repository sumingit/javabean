$(function(){
	const sessionName = $('#sessionName').text().trim();
	const sessionMcode = $('#sessionMcode').val();
	const sessionMid = $('#sessionMid').val();
	const boardMid = $('#boardMid').val();
	console.log(sessionName);
	console.log(sessionMcode);
	console.log(sessionMid);
	console.log(boardMid);
	//관리자 버튼 보이기
	if (sessionMcode == '0'){
		$('.manager').show();
	}else{
		$('.manager').hide();
	}
	
	//로그인, 로그아웃, 회원가입 제어
	if (!sessionName){ //로그인 전
		$('#aLogin').show();
		$('#aLogout').hide();
		$('#aJoin').show();
	}else{  //로그인 후
		$('#aLogin').hide();
		$('#aLogout').show();
		$('#aJoin').hide();
	}
	
	//로그아웃 버튼을 클릭했을때
	$('#aLogout').click(e=>{
		e.preventDefault(); //기본이벤트 제거
		if (confirm('로그아웃하시겠습니까?')){
			const path = $('#contextpath').val();
			location.href=`${path}/logout`;
		}		
		
	});
	
	
	
	
});