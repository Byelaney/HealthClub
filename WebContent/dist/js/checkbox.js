window.onload=addListener();

function addListener(){
	var button=document.getElementById("bottomButton");
	button.onclick=function(){
	var flag; 
	var checks = document.getElementsByName("selection"); 
	for(var i=0;i<checks.length;i++){ 
	if(checks[i].checked==true){ 
	flag = true; 
	return true; 
	break; 
	} 
	} 
	if(!flag){ 
	alert("you didn't choose anyone!"); 
	return false;
	}
};
}

