/**
 * 글 삭제 (POST 방식)
 */

 let target = document.getElementsByClassName("delete");
 
 for (t of target) {
	 t.addEventListener("click", myDelete);
	 // in으로 하면 정수값을 반환하므로 NO!
	 // of로 해야 객체를 받아올 수 있다
 }
 
 function myDelete(){
	 // console.log(this.getAttribute("data-no"));
	 let seq = this.getAttribute("data-no");
	 let usrpwd = prompt("비밀번호 입력");
	 let url = `guestbookDelete`;
	 let form = document.getElementById("form");
	 document.getElementById("seq").setAttribute("value", seq);
	 document.getElementById("usrpwd").setAttribute("value", usrpwd);
	 form.setAttribute("action", url); // 태그 내에 action이 있다면 생략 가능
	 
	 form.submit(); // javascript 메소드인 submit을 이용하여 전송
	 
	 /* 
	 location.href
	 location.assign : 뒤로가기 불가
	 location.replace : 뒤로가기 가능
	 */
 }