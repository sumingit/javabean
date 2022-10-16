<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp"%>
<%@ include file="./include/sessionCheck.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset='utf-8' />
  <!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
  <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <!-- jquery CDN -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- fullcalendar CDN -->
  <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
  <!-- fullcalendar 언어 CDN -->
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
<style>
 body {        
  margin: 40px 10px;        
  padding: 0;        
  font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;        
  font-size: 14px;    
	}


.dropNewEvent 
  font-size: 13px;
}

.popoverTitleCalendar {
  width: 100%;
  height: 100%;
  padding: 15px 15px;
  font-size: 13px;
  border-radius: 5px 5px 0 0;
}

.popoverInfoCalendar i {
  font-size: 14px;
  margin-right: 10px;
  line-height: inherit;
  color: #d3d4da;
}

.popoverInfoCalendar p {
  margin-bottom: 1px;
}

.popoverDescCalendar {
  margin-top: 12px;
  padding-top: 12px;
  border-top: 1px solid #E3E3E3;
  overflow: hidden;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
}

.popover-title {
  background: transparent;
  font-weight: 600;
  padding: 0 !important;
  border: none;
}

.popover-content {
  padding: 15px 15px;
  font-size: 13px;
}

.inputModal {
  width: 65%;
  margin-bottom: 10px;
}

#contextMenu {
  position: absolute;
  display: none;
  z-index: 2;
}

#contextMenu .dropdown-menu {
  border: none;
}

.opacityWeekend {
  background-color: #f4f4fb !important;
}

.fc-avatar-image {
  top: 4px;
  left: 20px;
  height: 28px;
  width: 28px;
  border-radius: 50%;
  position: absolute;
  z-index: 2;
}

.fc-avatar-image img {
  height: 28px;
  width: 28px;
  border-radius: 50%;
}

.fc-avatar-image:before {
  content: none !important;
}

.fc-day-header {
  text-transform: uppercase;
  font-size: 13px;
  font-weight: 500;
  color: #505363;
  background-color: #FAFAFA;
  padding: 11px 0px !important;
  text-decoration: none;
}

.fc-day-header a {
  text-decoration: none !important;
  color: #505363;
}

.fc-center h2 {
  text-transform: uppercase;
  font-size: 18px;
  font-weight: 600;
  color: #505363;
  line-height: 32px;
}

.fc-toolbar.fc-header-toolbar {
  margin-bottom: 22px;
  padding-top: 22px;
}

.fc-agenda-view .fc-day-grid .fc-row .fc-content-skeleton {
  padding-bottom: 1em;
  padding-top: 1em;
}

.fc-day {
  -webkit-transition: all 0.2s linear;
  -o-transition: all 0.2s linear;
  transition: all 0.2s linear;
}

.fc-day:hover {
  background: #EEF7FF;
  cursor: pointer;
  -webkit-transition: all 0.2s linear;
  -o-transition: all 0.2s linear;
  transition: all 0.2s linear;
}

.fc-highlight {
  background: #EEF7FF;
  opacity: 0.7;
}

.fc-time-grid-event.fc-short .fc-time:before {
  content: attr(data-start);
  display: none;
}

.fc-time-grid-event.fc-short .fc-time span {
  display: inline-block;
}

.fc-time-grid-event.fc-short .fc-avatar-image {
  display: none;
  -webkit-transition: all 0.3s linear;
  -o-transition: all 0.3s linear;
  transition: all 0.3s linear;
}

.fc-time-grid .fc-bgevent,
.fc-time-grid .fc-event {
  border: 1px solid #fff !important;
}

.fc-time-grid-event.fc-short .fc-content {
  padding: 4px 20px 10px 22px !important;
}

.fc-time-grid-event .fc-avatar-image {
  top: 9px;
}

.fc-event-vert {
  min-height: 22px;
}

.fc .fc-axis {
  vertical-align: middle;
  padding: 0 4px;
  white-space: nowrap;
  font-size: 10px;
  color: #505362;
  text-transform: uppercase;
  text-align: center !important;
  background-color: #fafafa;
}

.fc-unthemed .fc-event .fc-content,
.fc-unthemed .fc-event-dot .fc-content {
  padding: 5px 10px 5px 10px;
  font-family: 'Roboto', sans-serif;
  margin-left: -1px;
  height: 100%;
}

.fc-event {
  border: none !important;
}

 .fc-day-grid-event .fc-time {
  font-weight: 700;
  text-transform: uppercase;
} 

.fc-unthemed .fc-day-grid td:not(.fc-axis).fc-event-container {
  /* padding: 0.2rem 0.5rem; */
}

.fc-unthemed .fc-content,
.fc-unthemed .fc-divider,
.fc-unthemed .fc-list-heading td,
.fc-unthemed .fc-list-view,
.fc-unthemed .fc-popover,
.fc-unthemed .fc-row,
.fc-unthemed tbody,
.fc-unthemed td,
.fc-unthemed th,
.fc-unthemed thead {
  border-color: #DADFEA;
}

.fc-ltr .fc-h-event .fc-end-resizer,
.fc-ltr .fc-h-event .fc-end-resizer:before,
.fc-ltr .fc-h-event .fc-end-resizer:after,
.fc-rtl .fc-h-event .fc-start-resizer,
.fc-rtl .fc-h-event .fc-start-resizer:before,
.fc-rtl .fc-h-event .fc-start-resizer:after {
  left: auto;
  cursor: e-resize;
  background: none;
}

select.filter {
  width: 500px !important;
}

.popover {
  background: #fff !important;
  color: #2E2F34;
  border: none;
  margin-bottom: 10px;
}

/*popover header*/
.popover-title {
  background: #F7F7FC;
  font-weight: 600;
  padding: 15px 15px 11px;
  border: none;
}

/*popover arrows*/
.popover.top .arrow:after {
  border-top-color: #fff;
}

.popover.right .arrow:after {
  border-right-color: #fff;
}

.popover.bottom .arrow:after {
  border-bottom-color: #fff;
}

.popover.left .arrow:after {
  border-left-color: #fff;
}

.popover.bottom .arrow:after {
  border-bottom-color: #fff;
}

.material-icons {
  font-family: 'Material Icons';
  font-weight: normal;
  font-style: normal;
  font-size: 24px;
  /* Preferred icon size */
  display: inline-block;
  line-height: 1;
  text-transform: none;
  letter-spacing: normal;
  word-wrap: normal;
  white-space: nowrap;
  direction: ltr;

  /* Support for all WebKit browsers. */
  -webkit-font-smoothing: antialiased;
  /* Support for Safari and Chrome. */
  text-rendering: optimizeLegibility;

  /* Support for Firefox. */
  -moz-osx-font-smoothing: grayscale;

  /* Support for IE. */
  -webkit-font-feature-settings: 'liga';
          font-feature-settings: 'liga';
}

#add-color,
#edit-color {
  color: #d25565;
  
  
}

 #calendar {       
  max-width: 900px;        
  margin: 0 auto;    
  }
  


</style>	
</head>
<body style="padding:30px;">
  <!-- calendar 태그 -->
  
  <div id='calendar-container' style="width: 1070px; margin: 0 auto;">
  
   	<%@ include file="header.jsp" %>
 
  <h1 style="text-align: center">JAVABEAN 직원 근태,일정 관리</h1><br>	

  

    <div id='calendar' style="padding: 30px"></div>
    <%@include file="footer.jsp" %>
    	
    
    <!-- <input type="button" onclick="saveData()" value="저장" style="width:200px; height: 50pt; margin: auto; display: block;"/> -->
  </div>
  <script>
  (function(){
	  const path = $('#contextpath').val();
    $(function(){
      // calendar element 취득
      var calendarEl = $('#calendar')[0];

      // full-calendar 생성하기
      var calendar = new FullCalendar.Calendar(calendarEl, {
        height: '700px', // calendar 높이 설정
        expandRows: true, // 화면에 맞게 높이 재설정
        slotMinTime: '08:00', // Day 캘린더에서 시작 시간
        slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
        // 해더에 표시할 툴바	
        headerToolbar: {  
          left: '',			//헤더툴바 월,주 상세조회 기능 제거.
          center: 'title',
          right: 'prev,next today'   //왼쪽에 있던 주간 상세조회 제거.
        },
        initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
        /* initialDate: '2022-06-06', */ // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
        navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
        editable: false, // 수정 가능?
        selectable: true, // 달력 일자 드래그 설정가능
        nowIndicator: false,  // 현재 시간 마크
        dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
        locale: 'ko', // 한국어 설정
        eventAdd: function(obj) { // 이벤트가 추가되면 발생하는 이벤트	

          console.log(obj);
        },
        eventRemove: function(obj) { // 이벤트가 수정되면 발생하는 이벤트	
            console.log(obj);
          },        

      

      

        select: function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
            var title = prompt('부서 이름 사유 입력하세요');
            if (title) {
          	  const data = {
                        title: title,
                        start: arg.start,
                        end: arg.end,
                        allday: arg.allday
                       
                      };
              calendar.addEvent(data);
              console.log(data);
              
              //서버로 전송
      		fetch(`${path}/drag`, {
      			method : 'post',
      			headers : {
      				'Content-Type' : "application/json; charset=utf-8"
      			},
      			body : JSON.stringify(data),
                success : function(result) {
                    console.log("추가완료");
                   
                }
      		})
      		.then(res=>res.text())
      		.then(data=>{
      			console.log(data);
      		})
      		.catch(console.error);               
            }
            
            
            calendar.unselect()
          },
        
          eventClick : function(arg) {
			
             
                  if (confirm('삭제하시겠습니까?')) {
					
						const title= arg.event.title;
						console.log(arg.event.title);
                  	 	arg.event.remove();

                  	
                  	 	
                   	 	fetch(`${path}/`+title,{
                  	 		method: 'delete',
                  	 	})
                  	 	.then(res=>res.text())			
                  	 	.then(text=>{
                  	 		console.log(text);
                  	 	})
                  	 	.catch(console.error);
                  	 	
/*         	               $.ajax({
                               type:"DELETE",
                                url:'/project/remove/{title}',
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                // num 값 넘겨줘야함
                               data : JSON.stringify(event),
                               success : function(result) {
                                   console.log("삭제완료");
                                  
                                 
                               }
                                /* error : console.err,  */
                           
                  	
                  } 
    
                  
              },
            
        
        // 이벤트 
         events: (info, success, error)=>{  
    		fetch(`${path}/caldata`)
    		.then(res=>res.json())
    		.then(data=>{
    			success(data);
    		})
    		.catch(console.err);        	
        } 
        
      });


      
      console.log(calendar);
      // 캘린더 랜더링
      calendar.render();
      



    

    });
  })();
 
 
    
    
</script>



</body>
</html>
