<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">
		<!-- start: Javascript -->
		<script src='${root}/js/lang/ko.js'></script>
		<script src="${root }/js/main.js" ></script>
		<script type="text/javascript">
		  
		$(document).ready(function(){
		        
			$('#external-events .fc-event').each(function() {
		        // store data so the calendar knows to render an event upon drop
		        $(this).data('event', {
		          title: $.trim($(this).text()), // use the element's text as the event title
		          stick: true // maintain when user navigates (see docs on the renderEvent method)
		        });
		
		       /*  // make the event draggable using jQuery UI
		        $(this).draggable({
		          zIndex: 999,
		          revert: true,      // will cause the event to go back to its
		          revertDuration: 0  //  original position after the drag
		        }); */
		
		      });
		
		
		      $('#calendar').fullCalendar({
		    	  
		    	  lang: 'ko',
			      header: {
			        left: 'prev,next today',
			        center: 'title',
			        right: 'month,agendaWeek,agendaDay'
			      },
			      editable: true,
			      droppable: true, // this allows things to be dropped onto the calendar
			      drop: function(date, jsEvent, ui ) {
			
			        // is the "remove after drop" checkbox checked?
			        if ($('#drop-remove').is(':checked')) {
			          // if so, remove the element from the "Draggable Events" list
			          $(this).remove();
			        }
			      }
		    });
		  });
		</script>
		<!-- end: Javascript -->

          <!-- start: content -->
            <div id="content">
                <div class="panel">
                  <div class="panel-body">
                      <div class="col-md-6 col-sm-12">
                        <h3 class="animated fadeInLeft">${sessionScope.coInfo[6].strName }</h3>
                        <p class="animated fadeInDown"><span class="fa  fa-map-marker"></span> ${menuCategory }</p>

                        
                    </div>
                    <div class="col-md-6 col-sm-12">
                        <div class="col-md-6 col-sm-6 text-right" style="padding-left:10px;">
                          <h5 id="addr"  style="color:#DDDDDE;"><span class="fa  fa-map-marker"></span> 위치정보 들어가는 자리</h5>
                          <h1 style="margin-top: -10px;color: #ddd;"></h1>
                        </div>
                        <div class="col-md-6 col-sm-6">
                           <div class="wheather">
	                            <div class="sun animated pulse infinite">
	                              <div class="suny"></div>
	                            </div>
                          </div>
                        </div>                   
                    </div>
                  </div>                    
                </div>
                
                <div class="panel-heading bg-white border-none" style="margin-bottom: 20px;">
                   	<h4><span class="icon-notebook icons"></span> 일정관리</h4>
                </div>

					<!-- start : 메뉴 디자인 구성하는 위치 -->
					
				<div class="col-md-12">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="panel-heading bg-white border-none">
                   			<div class="panel-body">
                   				<div style="margin-bottom: 10px; text-align: right;">
                   					<input type="button" class="btn ripple btn-round btn-3d btn-default" style="width: auto; height: auto;" value="일정추가" onclick="location.href='${root}/schedule/select.html'"/>
                   				</div>
                   				
                   				<div id='calendar'></div>
                   			</div>
              			</div>
          			</div>
          			<div class="col-md-1"></div>
       			</div>
					
					<!-- end : 메뉴 디자인 구성하는 위치 -->
					
           </div>
          <!-- end: content -->

</html>