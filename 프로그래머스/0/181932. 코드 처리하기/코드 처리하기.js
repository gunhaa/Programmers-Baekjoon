function solution(code) {
    
    let codeArr = [...code];
    let answer = "";
    let mode = 0;
    console.log(codeArr)
    const mode0 = idx => {
        
        if (codeArr[idx] == 1){
            mode = 1;
            return;
        }
        
        if(idx%2===0){
            
            answer += codeArr[idx];
            
        }
    
    }
    
    const mode1 = idx => {
        
        if(codeArr[idx] ==1){
            mode = 0;
            return;
        }
        
        if(idx%2===1){
            answer += codeArr[idx];
        }
        
    }
    
    
    codeArr.forEach((_, idx) => {
        mode===1 ? mode1(idx) : mode0(idx)
    })
    
    
    
    
    
    return answer==="" ? "EMPTY" : answer;
    
}