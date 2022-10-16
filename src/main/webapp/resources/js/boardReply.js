/**
 * 게시물 댓글
 */

 //윈도우가 로딩이 완료된 후
window.addEventListener('load', ()=>{
	const path = $("#contextpath").val();
	
	//헬퍼 작성
	//세션mid과 작성자mid이 같은지 체크(같을때만 버튼을 리턴)
	Handlebars.registerHelper('sessionCheck', function(mid, rnum, content){
		//console.log(mid);
		
		var curMid = $('#curMid').text();
		console.log(content);
		//console.log(curMid);
		if (content == ''){
			return '<pre>삭제된 댓글입니다</pre> <br>';
		}else if ((content != '' && curMid == mid)  || sessionMcode == '0'){
			return '<pre id="content'+rnum+'">'+content+'</pre> <br>'+
					'<button class="reReplyModify" value="'+ rnum +'">수정</button>'+' '+
					'<button class="reReplyRemove" value="'+ rnum +'">삭제</button>';
		}else if (content != '' && curMid != mid){
			return '<pre id="content' +rnum+'">'+content+'</pre> <br>';
		}
	});
	
	
	
	
	//핸들바에서 사용 : 헬퍼만들기
	Handlebars.registerHelper('levelSpace', function(relevel){
		let result = '';
		for(var i=0; i<relevel; i++)
			result += '<div class ="divSpace"></div>';
		return result;
		
	});

	//댓글창 초기화
	const replyInit = ()=>{
		//입력된 내용 지우기
		$('#replycontnet').val='';
		
		//댓글추가 div 이동
		const hr = $('#hr');
		const divReplyAdd = $('#divReplyAdd');
		hr.after(divReplyAdd);
		//댓글추가 창 숨기기
		$('#divReplyAdd').css('display', 'none');
		
		//댓글수정 div 이동
		const divReplyModify = $('#divReplyModify');
		hr.after(divReplyModify);
		//댓글수정 창 숨기기
		divReplyModify.css('display', 'none');
		
		
	};
	//댓글의 리스트 
	const replyList = ()=> {
		
		replyInit();//댓글창 초기화
		
		const bnum = $('#bnum').text();
		//console.log(bnum);
		//ajax 서버 호출(get)
		fetch(`${path}/reply/list/${bnum}`)
		.then(res=>res.json())
		.then(data=>{
			//console.log(data);
			/*탬플리소스가져오기*/
			const source = $('#template_source').html();
			//console.log(source);
			//소스컴파일
			const template = Handlebars.compile(source);
			//컴파일된 데이터를 div넣기 
			$('#divReplyList').html(template(data));
			Handlebars.registerHelper('ifCond', function(v1, v2, options) {
			if($('#content').val().equals('삭제된 댓글입니다')) {
			  return options.fn(this);
			}
			return options.inverse(this);
});
			
		})
		.catch(console.err);
		
	};
	
	replyList(); //댓글의 리스트 출력 함수 호출
	
	//게시물의 댓글 버튼을 클릭했을때
	$('#replyAddShow').on('click',()=>{
		//부모의 restep,relevel
		$('#restep').value = 0;
		$('#relevel').value = 0;
		
		//댓글추가 div 이동
		const hr = $('#hr');
		const divReplyAdd = $('#divReplyAdd');
		hr.after(divReplyAdd);
		
		//댓글추가 div 보이기
		divReplyAdd.css('display', '');
		
	});
	
	//댓글추가창에서 취소버튼을 클릭했을때
	$('#replyCancel').on('click',()=>{
		//댓글추가 창 숨기기
		$('#divReplyAdd').css('display', 'none');	
	});
	
	
	//부모를 선택하고 자식엘리먼트에 이벤트 달기
	//댓글리스트의 댓글버튼을 클릭했을때
	$('#divReplyList').on('click','.reReplyAddShow', (e)=>{
		//rnum,restep,relevel 가져오기
		const rnum = $(e.target).val();
		console.log(rnum);
		const restep = $(`#restep${rnum}`).text();
		console.log(restep); 
		const relevel = $(`#relevel${rnum}`).text();
		console.log(relevel); 
		//부모의 restep, relevel
		$('#restep').val(restep);
		$('#relevel').val(relevel);
		
		//댓글추가 div 이동
		const reply = $(`#reply${rnum}`);
		const divReplyAdd = $('#divReplyAdd');
		reply.after(divReplyAdd);
		
		//댓글추가 div 보이기
		divReplyAdd.css('display', '');

	});
	//댓글리스트의 삭제 버튼을 클릭했을때
	$('#divReplyList').on('click', '.reReplyRemove', (e)=>{
		if (!confirm('삭제하시겠습니까?')) return ;
		
		const rnum = $(e.target).val();
		console.log(rnum);

		//ajax 서버 호출
		fetch(`${path}/reply/${rnum}`,{
			method : 'delete',
		})
		.then(res=>res.text())
		.then(text=>{
			alert(text);
			replyList(); //댓글 리스트 호출
		})
		.catch(err=>console.log(err));
	});
	
	//댓글리스트의 수정 버튼을 클릭했을때
	$('#divReplyList').on('click', '.reReplyModify', (e)=>{
		const rnum = $(e.target).val();
		console.log(rnum);
		//댓글수정 div 이동
		const reply = $(`#reply${rnum}`);
		const divReplyModify = $('#divReplyModify');
		reply.after(divReplyModify);
		//댓글수정 창 보이기
		divReplyModify.css('display', '');
	
		//기존 rnum, content 세팅
		$('#replyrnumModify').val(rnum);
		const content = $(`#content${rnum}`).text();
		$(`#replycontentModify`).html(content);		
	});
	
	//추가댓글의 추가버튼 클릭시
	$('#replyAdd').click(()=>{
		//추가할 내용 읽어오기
		const bnum = $('#bnum').text();
		const mid = $('#curMid').val();
		const content = $('#replycontent').val();
		const restep = $('#restep').val(); // 댓글의 순서
		const relevel = $('#relevel').val(); // 댓글의 레벨
		
		console.log(bnum);
		console.log(mid);
		console.log(content);
		console.log(restep);
		console.log(relevel);
		
		//전송할 데이터(자바스트립트 객체)
		const data ={
			bnum,
			mid,
			content,
			restep,
			relevel,
		};
		
		//jquery 서버 호출
		$.ajax({
			url : `${path}/reply/`,
			type : 'post',
			contentType : 'application/json', //보내는 데이터의 타입
			data: JSON.stringify(data), //보내는 데이터  json의 문자열
			dataType : 'text', //받을 데이터의 타입 
			success : (text)=>{
				console.log(text);
				replyList(); //댓글의 리스트 호출
			},
			error : console.error
			
		});
		
	});
	
	//댓글수정의 저장버튼을 클릭했을때
	$('#replyModify').click(()=>{
		//rnum, content
		const rnum = $('#replyrnumModify').val();
		const content = $('#replycontentModify').val();
		console.log(rnum);
		console.log(content);
		//보낼데이터 객체 생성
		const data = {
			rnum,
			content,
		};
		
		$.ajax({
			url : `${path}/reply/`,
			type : 'put',
			contentType : 'application/json',
			data : JSON.stringify(data),//보낼데이터 json문자열 변환
			success : (text)=>{
				console.log(text);
				replyList(); //댓글의 리스트 호출				
			},
			error : console.error
		});
	
	});
	
	//댓글수정창에서 취소버튼을 클릭했을때
	$('#replyModifyCancel').click(()=>{
		//댓글수정 창 숨기기
		$('#divReplyModify').css('display', 'none');	
	});
	
	
	
	
});