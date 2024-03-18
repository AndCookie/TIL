/**
 * 
 */

document.getElementById("submitBtn").addEventListener('click', validation)
 
function validation(e) {
	 e.preventDefault(); // 기능이 있는 태그의 "기본 기능"을 삭제
	 // e: 이벤트 소스 그 자체
	 // preventDefault : ex) a, submit, reset 태그 등의 하이퍼링크 기능을 없앤다
	 console.log(e);
	 
	 let memberid = document.getElementById("memberid");
	 if (memberid.value.length<3 || memberid.value.length>10){
		 alert("아이디는 3~10자리로 입력해주세요");
		 memberid.focus();
		 memberid.select();
		 return;
	 }
	 
	 let memberpw = document.getElementById("memberpw");
	 if (memberpw.value.length<3 || memberpw.value.length>10){
		 alert("비밀번호는 3~10자리로 입력해주세요");
		 memberpw.focus();
		 memberpw.select();
		 return;
	 }
	 
	 let memberpwchk = document.getElementById("memberpwchk");
	 if (memberpw.value != memberpwchk.value){
		 alert("비밀번호가 일치하지 않습니다.");
		 memberpwchk.focus();
		 memberpwchk.select();
		 return;
	 }
	 
	 let membername = document.getElementById("membername");
	 if (membername.value.length == 0){
		 alert("이름을 입력해주세요");
		 membername.focus();
		 membername.select();
		 return;
	 }
	 
	 let memberForm = document.getElementById("memberForm");
	 memberForm.submit();
	 
	 // Security
	 
}