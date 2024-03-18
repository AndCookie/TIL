/**
 * 
 */
$(function() {
	$("#todoid").on('keyup', idCheck);
	$("#todopwd").on('keyup', pwdCheck);
	
	// 로그인 버튼을 클릭하면 아이디와 비밀번호 검증
	$("#signin").on('click', function(){
		// Code here
		
		if(!idCheck() || !pwdCheck() ) {
			alert("로그인을 위해 데이터를 정확히 입력하세요");
			$("#todoid").focus();	
			return;
		}
		else
			$("#signinForm").submit();
	})
});

// 아이디 길이 체크
function idCheck() {
	
	let todoid = $("#todoid").val();
	
	// Code here
	if(todoid.length < 3 || todoid.length > 5 ) {
		$(".todoidresult").css("color", "red"); 
		$(".todoidresult").text('아이디는 3~5자 이내로 작성해주세요');
		return false;
	}
	$("#todoidresult").text('');
	return true;
	
}


// 비밀번호 길이체크
function pwdCheck() {
	let passwd = $("#todopwd").val();
	
	// Code Here
	if(passwd.length < 3 || passwd.length > 5 ) {
		$(".todopwdresult").css("color", "red"); 
		$(".todopwdresult").text('비밀번호는 3~5자 이내로 작성해주세요');
		return false;
	}
	$("#todopwdresult").text('');
	return true;
}