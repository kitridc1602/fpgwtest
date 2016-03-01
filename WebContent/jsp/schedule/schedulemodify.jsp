<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">
          <!-- start: content -->
            <div id="content">
                <div class="panel">
                  <div class="panel-body">
                      <div class="col-md-6 col-sm-12">
                        <h3 class="animated fadeInLeft">${sessionScope.coInfo[6].strName }</h3>
                        <p class="animated fadeInDown"><span class="fa  fa-map-marker"></span> 일정관리 >> 일정추가</p>

                        
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
                	<c:choose>
                		<c:when test="${!empty schedule.strUser }">
                			<h4><span class="icon-notebook icons"></span> 일정수정</h4>
                		</c:when>
                		
                		<c:otherwise>
                			<h4><span class="icon-notebook icons"></span> 일정추가</h4>	
                		</c:otherwise>
                	</c:choose>
                </div>

					<!-- start : 메뉴 디자인 구성하는 위치 -->
				<div class="col-md-12">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="panel-heading bg-white border-none">
							<form>
	                   			<div class="panel-body">
	                   				<table style="width: 100%;">
	                   					<tbody>
	                   						<tr>
	                   							<td style="width: 10%; text-align: center;">제목</td>
	                   							<td style="width: 90%;" colspan="3">
	                   								<input type="text" id="strTitle" name="strTitle" class="form-control" style="width: 100%;" value="">
	                   							</td>
	                   						</tr>
	                   						<tr>
	                   							<td style="width: 10%; text-align: center;">내용</td>
	                   							<td colspan="3">
	                   								<textarea id="strDetail_Comment" name="strDetail_Comment" rows="7" cols="" class="form-control" style="width: 100%;"></textarea>
	                   							</td>
	                   						</tr>
	                   						<tr>
	                   							<td style="width: 10%; text-align: center;" rowspan="3">일자</td>
	                   							<td colspan="3">
	                   								&nbsp;&nbsp;
		                   							<c:forEach var="workKind" items="">
		                   								<c:choose>
		                   									<c:when test="">
		                   										<input type="radio" id="strWork_Kind_Cd" name="strWork_Kind_Cd" value="">&nbsp;&nbsp;&nbsp;
		                   									</c:when>
		                   								
		                   									<c:otherwise>
		                   										<input type="radio" id="strWork_Kind_Cd" name="strWork_Kind_Cd" value="">&nbsp;&nbsp;&nbsp;	
		                   									</c:otherwise>
		                   								</c:choose>
		                   							</c:forEach>
	                   							</td>
	                   						</tr>
	                   						<tr>
	                   							<td colspan="3">
	                   								<input type="text" id="strYY" name="strYY" style="width: 15%; text-align: center;" readonly="readonly" value="">
	                   								<span>년</span>
	                   								<input type="text" id="strMM" name="strMM" style="width: 10%; text-align: center;" readonly="readonly" value="">
	                   								<span>월</span>
	                   								<input type="text" id="strDD" name="strDD" style="width: 10%; text-align: center;" readonly="readonly" value="">
	                   								<span>일</span>
	                   								<a href="#" class="date" ><i class="fa fa-calendar"></i></a>
	                   							</td>
	                   						</tr>
	                   						<tr>
	                   							<td colspan="3">
	                   								<select id="strStart_Hour" name="strStart_Hour">
	                   									<c:forEach var="startHour" begin="00" end="24" step="01">
	                   									
	                   										<c:if test="${startHour < 10 }">
	                   											<c:set var="startHour" value="0${startHour }"/>
	                   										</c:if>
	                   										
	                   										<c:choose>
	                   											<c:when test="">
	                   												<option value="${startHour }" selected="selected" >${startHour }</option>
	                   											</c:when>
	                   											
	                   											<c:otherwise>
	                   												<option value="${startHour }">${startHour }</option>
	                   											</c:otherwise>
	                   										</c:choose>
	                   									</c:forEach>
	                   								</select>
	                   								시
	                   								<select id="strStart_Minute" name="strStart_Minute">
	                   									<c:forEach var="startMinute" begin="00" end="60" step="10">
	                   									
	                   										<c:if test="${startMinute < 10 }">
	                   											<c:set var="startMinute" value="0${startMinute }"/>
	                   										</c:if>
	                   										
	                   										<c:choose>
	                   											<c:when test="">
	                   												<option value="${startMinute }" selected="selected" >${startMinute }</option>
	                   											</c:when>
	                   											
	                   											<c:otherwise>
	                   												<option value="${startMinute }">${startMinute }</option>
	                   											</c:otherwise>
	                   										</c:choose>
	                   									</c:forEach>
	                   								</select>
	                   								분&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;
	                   								<select id="strEnd_Hour" name="strEnd_Hour">
	                   									<c:forEach var="endHour" begin="00" end="24" step="01">
	                   										
	                   										<c:if test="${endHour < 10 }">
	                   											<c:set var="endHour" value="0${endHour }"/>
	                   										</c:if>
	                   										
	                   										<c:choose>
	                   											<c:when test="">
	                   												<option value="${endHour }" selected="selected" >${endHour }</option>
	                   											</c:when>
	                   											
	                   											<c:otherwise>
	                   												<option value="${endHour }">${endHour }</option>
	                   											</c:otherwise>
	                   										</c:choose>
	                   									</c:forEach>
	                   								</select>
	                   								시
	                   								<select id="strEnd_Minute" name="strEnd_Minute">
	                   									<c:forEach var="endMinute" begin="00" end="60" step="10">
	                   										
	                   										<c:if test="${endMinute < 10 }">
	                   											<c:set var="endMinute" value="0${endMinute }"/>
	                   										</c:if>
	                   										
	                   										<c:choose>
	                   											<c:when test="">
	                   												<option value="${endMinute }" selected="selected" >${endMinute }</option>
	                   											</c:when>
	                   											
	                   											<c:otherwise>
	                   												<option value="${endMinute }">${endMinute }</option>
	                   											</c:otherwise>
	                   										</c:choose>
	                   									</c:forEach>
	                   								</select>
	                   								분
	                   							</td>
	                   						</tr>
	                   						<tr>
                   								<td style="width: 10%; text-align: center;">종류</td>
	                   							<td>
	                   								<select style="width: 100%;" id="strWork_Kind_cd" name="strWork_Kind_cd">
		                                    			<option>선택</option>
		                                    				<c:forEach var="workKind" items="${sessionScope.schKind }">
		                                    					
		                                    					<c:choose>
		                                    						<c:when test="${schedule.strWork_kind_Cd eq workKind.strSCode }">
		                                    							<option value="${workKind.strSCode }" selected="selected">${workKind.strName }</option>
		                                    						</c:when>
		                                    							
		                                    						<c:otherwise>
		                                    							<option value="${workKind.strSCode }">${workKind.strName }</option>	
		                                    						</c:otherwise>
		                                    					</c:choose>
		                                    				</c:forEach>
		                                  			</select>
	                   							</td>
	                   							<td style="width: 40%; text-align: center;">공개여부</td>
	                   							<td>
	                   								<select style="width: 100%;" id="strDisclosure_Cd" name="strDisclosure_Cd">
	                                    				<c:forEach var="disclosure" items="${sessionScope.disclosure }">
	                                    					
	                                    					<c:choose>
	                                    						<c:when test="${schedule.strDisclosure_Cd eq disclosure.strSCode }">
	                                    							<option value="${disclosure.strSCode }" selected="selected">${disclosure.strName }</option>
	                                    						</c:when>
	                                    							
	                                    						<c:otherwise>
	                                    							<option value="${disclosure.strSCode }">${disclosure.strName }</option>	
	                                    						</c:otherwise>
	                                    					</c:choose>
	                                    				</c:forEach>
		                                  			</select>
	                   							</td>
	                   						</tr>
	                   						
	                   					</tbody>
	                   				</table>
	                   				
	                   				<div style="margin-top: 30px; margin-bottom: 10px; text-align: right;">
										<c:choose>
											<c:when test="${!empty schedule.strUser }">
												<input type="button" id="btnDelete" class="btn ripple btn-round btn-3d btn-default" style="width: auto; height: auto;" value="수정" onclick="scheduleSubmit('delete')"/>
	               								<input type="button" id="btnModify" class="btn ripple btn-round btn-3d btn-default" style="width: auto; height: auto;" value="수정" onclick="scheduleSubmit('modify')"/>
	                  						</c:when>
		                  						
	                  						<c:otherwise>
	                  							<input type="button" id="btnInsert" class="btn ripple btn-round btn-3d btn-default" style="width: auto; height: auto;" value="입력" onclick="scheduleSubmit('insert')"/>
	                  						</c:otherwise>
	                  					</c:choose>
	                   					<input type="button" class="btn ripple btn-round btn-3d btn-default" style="width: auto; height: auto;" value="종료" onclick="location.href='${root}/user/selectall.html'"/>
	                   					<input type="hidden" id="strGet_User_Cd" name="strGet_User_Cd" value="${sessionScope.userInfo.strCode }">
	                   					<input type="hidden" id="strEdit_User_Cd" name="strEdit_User_Cd" value="${sessionScope.userInfo.strCode }">
	                   				</div>
	                   			</div>
                   			</form>
              			</div>
          			</div>
          			<div class="col-md-1"></div>
       			</div>	
					<!-- end : 메뉴 디자인 구성하는 위치 -->
					
           </div>
          <!-- end: content -->

</html>