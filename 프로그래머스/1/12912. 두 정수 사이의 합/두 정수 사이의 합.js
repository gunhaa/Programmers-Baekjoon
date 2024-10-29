function solution(a, b) {
    
    let loop = Math.abs(a-b)+1;
    let answer = 0;
    if(loop===0){
        return a;
    } else {
        
        let temp = Math.max(a,b);
        
        while(loop--){
            answer += temp;
            temp--;
        }
        
        return answer;
    }
}