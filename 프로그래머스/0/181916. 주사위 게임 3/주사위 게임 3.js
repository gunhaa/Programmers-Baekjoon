function solution(a, b, c, d) {
    const arr = Array.from([a,b,c,d]);
    const answer = new Map();
    while(arr.length!==0){
        const temp = arr.shift();
          if(answer.has(temp)){
                const currentValue = answer.get(temp); 
                answer.set(temp, currentValue + 1);                   
            } else {
                answer.set(temp, 1);
            }
    }    
    const answerArr = [...answer.entries()];
    // console.log(answerArr);
    if(answerArr.length===1){
        return 1111 * answerArr[0][0]
    } else if(answerArr.length===2){
        if(answerArr[0][1] === 3 || answerArr[0][1] === 1){

            const p = answerArr.filter((v,i)=>v[1] === 3);
            const q = answerArr.filter((v,i)=>v[1] === 1);
            return Math.pow( ( 10*p[0][0] ) + q[0][0] , 2 )
            
        } else {
            return (answerArr[0][0]+answerArr[1][0])*Math.abs(answerArr[0][0]-answerArr[1][0])    
        }
        
    } else if(answerArr.length===3){
        const qr = answerArr.filter((v,i) => v[1]===1);
        console.log(qr)
        return qr[0][0]*qr[1][0]
        
    } else {
        return Math.min(a,b,c,d);
    }
    
}