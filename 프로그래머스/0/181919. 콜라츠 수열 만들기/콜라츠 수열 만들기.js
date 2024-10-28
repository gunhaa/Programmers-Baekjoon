function solution(n) {
    let answer = n;
    const answerArr = [];
    
    answerArr.push(answer);
    console.log(answerArr)
    while(answer!==1){
        
        if(answer%2===0){
            answer = answer/2
        }else if(answer%2===1){
            answer = (answer*3)+1
        }
        

        answerArr.push(answer);
    }
    
    
    return answerArr;
}