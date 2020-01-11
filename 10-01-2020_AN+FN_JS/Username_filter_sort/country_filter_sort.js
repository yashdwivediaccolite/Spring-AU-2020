var names=["Yash12","goodguy23","helper36","coolboy1234","coder11","ajay15","rare233","budo","123"];

function init(){                                                //To initially display all stored usernames
    names.forEach((elem)=>{
        document.getElementById("names").innerHTML+=elem+"<br>";
        document.getElementById("sorted").innerHTML+=elem+"<br>";
    });
}

function filterUsernames(){                                     //Function to filter the usernames
    let name=document.getElementById("username");
    let pattern=new RegExp(name.value);
    var displayNames=[];
    names.forEach((elem)=>{
        if(pattern.test(elem)){
            displayNames.push(elem);
        }
    });
    document.getElementById("names").innerHTML="";
    document.getElementById("sorted").innerHTML="";
    displayNames.forEach((elem)=>{
        document.getElementById("names").innerHTML+=elem+"<br>";
        document.getElementById("sorted").innerHTML+=elem+"<br>";
    });
}


function sortUsernames(){
    document.getElementById("sorted").innerHTML="";
    displayNames=document.getElementById("names").innerHTML.split("<br>").filter((elem)=>elem);
    displayNames.sort((a,b)=>{
        a=typeof a==="string"?a.toLowerCase():a.toString();     //If a or b are strings get converted all to lowercase    
        b=typeof b==="string"?b.toLowerCase():b.toString();     //If they are numbers get converted to strings    
        return a.localeCompare(b);                              //FOR CASE INSENSITIVE SORTING returns -1,0 or 1 depending on comparison
    });
    displayNames.forEach((elem)=>{
        document.getElementById("sorted").innerHTML+=elem+"<br>";
    });
}

function onSubmit(){                                            //To display the values user entered in form
    document.getElementById("afterSubmit").style.display="block";
    document.getElementById("submitted_name").innerHTML=document.getElementById("name").value;
    document.getElementById("submitted_country").innerHTML=document.getElementById("country").value;
    document.getElementById("submitted_username").innerHTML=document.getElementById("username").value;
}
