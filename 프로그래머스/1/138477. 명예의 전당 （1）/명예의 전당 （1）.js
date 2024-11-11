function solution(k, score) {
    
    const stack = [];
    const answer = []
    
    
    for(let i=0; i<score.length; i++){

        if(i<k) {
            stack.push(score[i]);
            stack.sort( (a,b) => b-a );
            answer.push(stack[stack.length-1]);
        }else {
            const temp = Math.min(...stack);
            if(score[i] > temp){
                stack.pop();
                stack.push(score[i]);
                stack.sort( (a,b) => b-a );
            }
            answer.push(stack[stack.length-1]);
            
        }
    }
    
    return answer;
}