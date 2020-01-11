function validateForm(){
    let user={}
    let errors=false;
    let matchError=false,lengthError=false,capitalError=false,lowerError=false,specialError=false,abcError=false;
    user.username=document.forms["loginForm"]["username"].value;
    user.password=document.forms["loginForm"]["password"].value;
    user.cpassword=document.forms["loginForm"]["confpassword"].value;
    let capital=new RegExp("(?=.*?[A-Z])");
    let lower=new RegExp("(?=.*?[a-z])");
    let special=new RegExp("(?=.*?[#?!@$%^&*-])");
    let abc=new RegExp("(?=.*?[abcABC])")
    if(user.password!==user.cpassword){
        document.getElementById("match").style.display="block";
        errors=true;
        matchError=true;
    }
    else if(user.password===user.cpassword){
        document.getElementById("match").style.display="none";
        matchError=false;
    }
    if(user.password.length<8){
        document.getElementById("minlength").style.display="block";
        errors=true;
        lengthError=true;
    }
    else if(user.password.length>=8){
        document.getElementById("minlength").style.display="none";
        lengthError=false;
    }
    if(!capital.test(user.password)){
        document.getElementById("capital").style.display="block";
        errors=true;
        capitalError=true;
    }
    else if(capital.test(user.password)){
        document.getElementById("capital").style.display="none";
        capitalError=false;
    }
    if(!lower.test(user.password)){
        document.getElementById("small").style.display="block";
        errors=true;
        lowerError=true;
    }
    else if(lower.test(user.password)){
        document.getElementById("small").style.display="none";
        lowerError=false;
    }
    if(!special.test(user.password)){
        document.getElementById("special").style.display="block";
        errors=true;
        specialError=true;
    }
    else if(special.test(user.password)){
        document.getElementById("special").style.display="none";
        specialError=false;
    }
    if(!abc.test(user.password)){
        document.getElementById("abc").style.display="block";
        errors=true;
        abcError=true;
    }
    else if(abc.test(user.password)){
        document.getElementById("abc").style.display="none";
        abcError=false;
    }


    if( !matchError && !lengthError && !capitalError && !lowerError && !specialError && !abcError){
        errors=false;
    }

    if(!errors){
        document.getElementById("errors").style.display="none";
        document.getElementById("submitted").style.display="block";
        document.getElementById("submitted_username").innerHTML=user.username;
        document.getElementById("submitted_password").innerHTML=user.password;
    }
    else{
        document.getElementById("errors").style.display="block";
        document.getElementById("submitted").style.display="none";
    }

}