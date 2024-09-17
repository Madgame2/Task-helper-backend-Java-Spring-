modes =document.getElementById("modes");

var mode=false;

//modes.querySelectorAll(".active").forEach(function(button){
//    if(button.id=="in") mode=1;
//    else mode=2;
//})


modes.querySelectorAll("button").forEach(function(button){
    button.addEventListener("click",function(){

        if(!button.classList.contains("active")){
        mode=!mode;
        console.log(mode)

        modes.querySelectorAll(".active").forEach(function(active){
            active.classList.remove("active")
        })
        button.classList.add("active")
        } 
        
        
        if(mode){
            document.getElementById("movable").style.top="-100%"    
        }else{
            document.getElementById("movable").style.top="0%" 
        }
    })
});