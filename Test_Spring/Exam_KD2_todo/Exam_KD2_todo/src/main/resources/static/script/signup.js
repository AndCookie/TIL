/**
 * 
 */

let valid = false;
$(function() {
	$("#todoid").on('keyup', todoidCheck);
	
	// 회원 가입 실시
	$("#regist").on('click', function(){
		if(!valid || !todopwdCheck() || !todonameCheck() ) {
			alert("데이터를 모두 정확히 입력해 주세요");
			$("#todoid").focus();	
			return;
		}
		else 
			$("#registForm").submit();
	})
});
// 아이디 체크
function todoidCheck() {
	valid = false;

	let todoid = $("#todoid").val();

	if(todoid.length < 3 || todoid.length > 5 ) {
		$("span.todoidresult").css("color", "red"); 
		$("#todoidresult").text('아이디는 3~5자 이내로 작성해주세요');
		valid = false;
		return;
	}		
	
	let sendData = {"todoid": todoid};
	$.ajax({
		url: 'todoidCheck'
		, method : 'POST'
		, data : sendData
		, success : function(resp){
			if(resp == "success") {
				$("span.todoidresult").css("color", "blue"); 
				$("#todoidresult").text('사용가능한 아이디입니다.');
				valid = true;
			} else {
				$("span.todoidresult").css("color", "red");
				$("#todoidresult").text('사용 할 수 없는 아이디입니다.');
				valid = false;
			}
		}
	});
}

// 비밀번호 체크
function todopwdCheck() {
	let todopwd = $("#todopwd").val();
	console.log(todopwd);
	if(todopwd.length < 3 || todopwd.length > 5 ) {
		$("span.todopwdresult").css("color", "red"); 
		$("#todopwdresult").text('비밀번호는 3~5자 이내로 작성해주세요');
		return false;
	}
	$("#todopwdresult").text('');
	return true;
}

// 이름 체크
function todonameCheck(){
	$(this).on('blur', function(){
		$(this).next().text('');
	});
	let todoname = $("#todoname").val();
	if(todoname.length == 0 ) {
		$("span.todonameresult").css("color", "red"); 
		$("#todonameresult").text('이름을 입력해주세요.');
		return false;
	}
	$("#todonameresult").text('');
	return true;
}