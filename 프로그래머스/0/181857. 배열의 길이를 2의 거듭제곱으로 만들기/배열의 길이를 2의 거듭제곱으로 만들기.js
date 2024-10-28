function solution(arr) {
    
    const next2n = (len) => {
        
        let temp = 1;
        
        while(len > temp){
        
            temp *= 2
            
        }
        
        return temp;
    }
    
    const answerLen = next2n(arr.length);
    
    while(answerLen !== arr.length){
        
        arr.push(0);
        
    }
    return arr
}