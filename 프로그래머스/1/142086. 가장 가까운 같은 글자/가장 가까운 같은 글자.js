function solution(s) {

    const stack = [];
    const answer = [];
    
    for(let i=0; i<s.length; i++){
        
        const temp = stack.lastIndexOf(s[i]);
        
        if( temp > -1){
            answer.push(i-temp);
            
        } else {
            answer.push(temp);
        }
        
        stack.push(s[i]);
        
    }
    
    return answer;
    
}