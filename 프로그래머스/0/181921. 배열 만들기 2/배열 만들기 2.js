function solution(l, r) {
    const answer = [];
    const temp = []
    
    
    for(let i=l ; i<r+1; i++){
        
        temp.push(i.toString());
        
    }

    for(let v of temp){

        if(Number(v)%5 == 0){
            if([...v].every(val => val==="5" || val==="0")){
                
                answer.push(Number(v));
                
            }
            
        }
        
    }
    
    if(answer.length === 0) {
        answer.push(-1);
    }
    
    return answer;
}