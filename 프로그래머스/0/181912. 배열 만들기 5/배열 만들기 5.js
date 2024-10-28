function solution(intStrs, k, s, l) {

    const answer = [];
    
    intStrs.forEach((v,i) => {
        
        const temp = intStrs[i].slice(s, s+l);
        
        Number(temp) > k ? answer.push(Number(temp)) : false;
        
    })
    
    return answer
}