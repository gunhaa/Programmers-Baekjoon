function solution(arr, k) {

    const set = new Set();
    
    arr.forEach((v,i)=>{
       
        if(k > set.size) set.add(v);
        
    });
    
    const answer = [...set];
    
    while(answer.length !== k){
        answer.push(-1);
    }
    
    return answer
    
}