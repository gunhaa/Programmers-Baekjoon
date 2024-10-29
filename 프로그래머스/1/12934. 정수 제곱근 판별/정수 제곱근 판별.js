function solution(n) {
    
    const sqrt = Math.sqrt(n);
    
    if(sqrt === Math.floor(sqrt)){
        return Math.pow(sqrt+1,2);
    } else {
        return -1;
    }
    
}