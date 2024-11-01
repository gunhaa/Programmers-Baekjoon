function solution(s){

    const stack = [];
    
    for(let i=0; i<s.length; i++){
        
        const temp = s[i];
        stack.push(temp);

        while(stack.length > 1 && stack[stack.length-1] === stack[stack.length-2]){
            
            stack.pop();
            stack.pop();
            
        }
        
        
    }

    return stack.length===0 ? 1 : 0;
}