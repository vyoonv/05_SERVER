

const checkObj = {
    "inputId" : false,
    "inputPw" : false, 
    "inputPwConfirm" : false, 
    "inputName" : false
};

const inputId = document.getElementById("inputId"); 

inputId.addEventListener("change", function() {

    const regExp = /^[a-z][\w_-]{5,13}$/;
    
    if(regExp.test(this.value)) {
        this.style.backgroundColor = "#b2ebcb"; 
        this.style.color = "white"; 
        checkObj.inputId = true; 
    } else {
        this.style.backgroundColor = "black"; 
        this.style.color = "white"; 
        checkObj.inputId = false; 
    }

}); 


const inputPw = document.getElementById("inputPw"); 
const inputPwConfirm = document.getElementById("inputPw2"); 

inputPwConfirm.addEventListener("keyup", function(){

    if(inputPw.value.length == 0) {
        this.value = ""; 
        alert("비밀번호를 먼저 입력해주세요!")
        inputPw.focus(); 
        checkObj.inputPw = false;
    }


}); 



inputPw.addEventListener("keyup", function(){

    if((inputPw.value.length == inputPwConfirm.value)&& inputPw.value.length !=0) {
        
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

const inputName = document.getElementById("inputName"); 

inputName.addEventListener("change", function(){

    const regExp = /^[가-힣][a-z][\w]{2,7}$/; 
    const nameMessage = document.getElementById("nameMessage"); 

    if(regExp.test(this.value)) {
        nameMessage.innerText = "정상입력"; 
        nameMessage.classList.add("confirm"); 
        nameMessage.classList.remove("error");
        checkObj.inputName=true;  
    } else {
        nameMessage.innerText = "2~7글자 한글, 영어만 입력하세요"
        nameMessage.classList.add("error"); 
        nameMessage.classList.remove("confirm"); 
        checkObj.inputName = false; 
    }

});



function validate() {

    for(let key in checkObj) {
        if( !checkObj[key]) {
            alert("유효성 검사가 완료되지 않음"); 
            return false; 
        }
    }
    return true; 
}















