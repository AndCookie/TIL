/**
 * 글 삭제 (GET 방식)
 */

 let target = document.getElementsByClassName("delete");
 
 for (t of target) {
	 // in으로 하면 정수값을 반환하므로 NO!
	 // of로 해야 객체를 받아올 수 있다
	 t.addEventListener("click", myDelete);
 }
 
 function myDelete(){
	 let seq = this.getAttribute("data-no");
	 let usrpwd = prompt("비밀번호 입력");
	 let url = `guestbookDelete?seq=${seq}&usrpwd=${usrpwd}`;
	 location.replace(url);

	 
	 /* 
	 location.href
	 location.assign : 뒤로가기 불가
	 location.replace : 뒤로가기 가능
	 */
	 // console.log(seq);
	 // 화면 상의 글 번호와 console창에 뜨는 seq 번호는 다르다
	 
 }