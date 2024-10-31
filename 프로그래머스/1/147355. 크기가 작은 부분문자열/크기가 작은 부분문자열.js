function solution(t, p) {

    const answer = [];
    for(let i=0; i<t.length-p.length+1; i++){
        answer.push(Number(t.substring(i , i+p.length)));
        
    }    
    
    return answer.filter(v=> v <= p).length;
    
}