function solution(myString) {

    const answer = [];
    const stack = [];
    
    let str = myString.split("");
    
    str.forEach((v,i)=>{
       
        v==="x" ? (answer.push(stack.join("")) , stack.length = 0) : stack.push(v)
        
    });
    
    if(stack.length!==0){
        answer.push(stack.join(""));
    }

    
    return answer.filter(v=>v!=="").sort()
    
}

