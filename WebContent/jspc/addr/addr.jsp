<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우편번호 검색</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>

	function onPostCode(){
		
	    new daum.Postcode({
	        oncomplete: function(data) {
	            
	        	/* 
	        	zonecode : 국가기초구역번호. 2015년 8월 1일부터 시행될 새 우편번호. :
	        	address : 기본 주소 :
	        	addressEnglish : 기본 영문 주소 : 
	        	addressType : 검색된 기본 주소 타입: R(도로명), J(지번)
	        	userSelectedType : 검색 결과에서 사용자가 선택한 주소의 타입
	        	userLanguageType : 검색 결과에서 사용자가 선택한 주소의 언어 타입: K(한글주소), E(영문주소)
	        	roadAddress : 도로명 주소
	        	roadAddressEnglish : 영문 도로명 주소
	        	jibunAddress : 지번 주소
	        	jibunAddressEnglish : 영문 지번 주소
	        	sido : 도/시 이름
	        	sigungu : 시/군/구 이름
	        	bname : 법정동/법정리 이름
	        	hname : 행정동 이름
	        	query : 사용자가 입력한 검색어
	        	postcode : 구 우편번호 (2015년 8월 1일 이후에는 업데이트가 되지 않습니다.)
	        	postcode1 : 구 우편번호 앞 3자리 (2015년 8월 1일 이후에는 업데이트가 되지 않습니다.)
	        	postcode2 : 구 우편번호 뒤 3자리 (2015년 8월 1일 이후에는 업데이트가 되지 않습니다.)
	        	 */
	        	
	        	document.getElementById("zip1").value = data.zonecode;
	        	document.getElementById("addr1").value = data.address;
	        	document.getElementById("addr2").focus();
	        	
	        	
	        	
	        }
	    }).open();
	    
	}
</script>


</head>
<body>

	<div>
		우편번호<input type="text" id="zip1" style="width: 40px; text-align: center;">-<input type="text" id="zip2" style="width: 40px; text-align: center;">
		<input type="button" id="button" value="우편번호 검색" onclick="onPostCode()"><br>
		기본주소<input type="text" id="addr1" style="width: 250px;"><br>
		상세주소<input type="text" id="addr2" style="width: 250px;">
	</div>

</body>
</html>