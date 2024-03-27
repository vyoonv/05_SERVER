// console.log("signup.js loaded"); 

// 유효성 검사 객체 
const checkObj = { 
    "inputId" : false,  //아이디 검사 
    "inputPw" : false,  //비밀번호 
    "inputPwConfirm" : false, // 비번확인
    "inputName" : false //닉네임
};

// 아이디 유효성 검사 
const inputId = document.getElementById("inputId"); 
                     // change : 작성 후 벗어나면 검사 // 입력할 때마다 검사-> keyup
inputId.addEventListener("change", function() {
    
    const regExp = /^[a-z][\w_-]{5,13}$/; 
    // 소문자 시작(1) + 나머지 (5~13) = 6~14글자  // [\w]단어 

    if(regExp.test(this.value)) {
        this.style.backgroundColor = "green"; 
        this.style.color = "white"; 
        checkObj.inputId = true;        
    } else {
        this.style.backgroundColor = "red"; 
        this.style.color = "white"; 
        checkObj.inputId = false;  
    }

});  

const inputPw = document.getElementById("inputPw"); 
const inputPwConfirm = document.getElementById("inputPw2"); 

inputPwConfirm.addEventListener("keyup", function() {

    if(inputPw.value.length == 0) {
        this.value = ""; 
        alert("비밀번호를 먼저 입력해주세요"); 
        inputPw.focus();    // input창에 커서 옮겨지게  
        checkObj.inputPw = false; 

    } 
}); 

const pwMessage = document.getElementById("pwMessage"); 

inputPw.addEventListener("keyup", function(){

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0) {
        pwMessage.innerText = "비밀번호 일치"; 
        pwMessage.classList.add("confirm"); 
        pwMessage.classList.remove("error"); 
        checkObj.inputPw = true; 
        checkObj.inputPwConfirm = true;

    } else {
        pwMessage.innerText = "비밀번호 불일치"; 
        pwMessage.classList.add("error"); 
        pwMessage.classList.remove("confirm"); 
        checkObj.inputPwConfirm = false;
    }
}); 


inputPwConfirm.addEventListener("keyup", function(){

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0) {
        pwMessage.innerText = "비밀번호 일치"; 
        pwMessage.classList.add("confirm"); 
        pwMessage.classList.remove("error"); 
        checkObj.inputPw = true; 
        checkObj.inputPwConfirm = true;

    } else {
        pwMessage.innerText = "비밀번호 불일치"; 
        pwMessage.classList.add("error"); 
        pwMessage.classList.remove("confirm"); 
        checkObj.inputPwConfirm = false;
    }
}); 


// 닉네임 유효성 검사 
// 2~5 한글만 
const inputName = document.getElementById("inputName"); 

inputName.addEventListener("change", function() {

    const regExp = /^[가-힣]{2,5}$/;
    
    const nameMessage = document.getElementById("nameMessage"); 

    if(regExp.test(this.value)) {

        nameMessage.innerText = "정상입력"; 
        nameMessage.classList.add("confirm"); 
        nameMessage.classList.remove("error"); 
        checkObj.inputName = true; 

    } else {

        nameMessage.innerText = "2글자에서 5글자 사이 한글만 입력하세요"; 
        nameMessage.classList.add("error"); 
        nameMessage.classList.remove("confirm"); 
        checkObj.inputName = false; 
    }

}); 













//최종적으로 유효성 검사 객체인 checkObj 안에 있는 
//모든 value가 true인지 확인해주는 함수
//만약 모두 true -> 서버로 submit
//만약 하나라도 false -> 유효성검사가 완료되지 않았습니다
function validate() {
    for(let key in checkObj) {
        if( !checkObj[key] ) {
            alert("유효성 검사가 완료되지 않았습니다");
            return false; 
        }
    }
    return true; 
}; 