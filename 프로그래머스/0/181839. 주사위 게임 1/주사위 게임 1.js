function solution(a, b) {

    let answer = 0;
    
    if(a%2===1 && b%2===1){
        answer = a*a + b*b
        return answer;
    }
    
    if(a%2===1 || b%2 ===1){
        answer = 2*(a+b);
        return answer;
    }
    
    return Math.abs(a-b);
        

    
}