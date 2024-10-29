function solution(s){

    let countp=0;
    let county=0;
    s.toLowerCase().split("").forEach(v=>{
       
        if(v==="p"){
            countp+=1;
        } else if(v==="y"){
            county+=1;
        }
        
    });
    if(countp+county === 0 || countp===county){
        return true;
    }
    
    return false;

}