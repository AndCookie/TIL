/**
 * 
 */

document.getElementById("submitBtn").addEventListener('click', validation)

let m3 = document.getElementById("m3");
m3.addEventListener('change', function(){
	let m2 = document.getElementById("m2");
	m2.value=m3.value;
});
 
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
	 
	 let membername = document.getElementById("membername");
	 if (membername.value.length == 0){
		 alert("이름을 입력해주세요");
		 membername.focus();
		 membername.select();
		 return;
	 }
	 
	 // 이메일 검증
	 let m1 = document.getElementById("m1");
	 if (m1.value.length == 0){
		 alert("이메일을 입력해주세요");
		 m1.focus();
		 m1.select();
		 return;
	 }
	 let m2 = document.getElementById("m2");
	 if (m2.value.length == 0){
		 alert("이메일을 입력하거나 선택해주세요");
		 m2.focus();
		 m2.select();
		 return;
	 }
	 let email = document.getElementById("email");
	 email.value = `${m1.value}@${m2.value}`;
	 
	 // 연락처 인증
	 let p1 = document.getElementById("p1").value;
	 let p2 = document.getElementById("p2");
	 let p3 = document.getElementById("p3");
	 if (isNaN(p2.value) || p2.value.length !=4){
		 // isNaN( ) : 문자가 섞여있거나
		 alert("전화번호는 문자가 포함되지 않은 4자리 숫자로 입력해주세요");
		 p2.focus();
		 p2.select();
		 return;
	 }
	 if (isNaN(p3.value) || p3.value.length !=4){
		 // isNaN( ) : 문자가 섞여있거나
		 alert("전화번호는 문자가 포함되지 않은 4자리 숫자로 입력해주세요");
		 p3.focus();
		 p3.select();
		 return;
	 }
	 
	 let phone = document.getElementById("phone");
	 phone.value = `${p1}${p2.value}${p3.value}`;
	 
	 let memberForm = document.getElementById("memberForm");
	 memberForm.submit();
	 
	 
	 // Security
	 
}