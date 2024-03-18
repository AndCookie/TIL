/**
 * 
 */
document.getElementById("submitBtn").addEventListener('click', validation)
 
function validation(e) {
	 e.preventDefault(); // 기능이 있는 태그의 "기본 기능"을 삭제
	 // e: 이벤트 소스 그 자체
	 // preventDefault : ex) a, submit, reset 태그 등의 하이퍼링크 기능을 없앤다
	 console.log(e);
	 
	 let memberpwd = document.getElementById("memberpwd");
	 if (memberpwd.value.length<3 || memberpwd.value.length>5){
		 alert("비밀번호는 3~5자리로 입력해주세요");
		 memberpwd.focus();
		 memberpwd.select();
		 return;
	 }
	 
	 let memberForm = document.getElementById("memberForm");
	 memberForm.submit(); 
}