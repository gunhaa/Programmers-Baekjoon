function solution(q, r, code) {
    
    const str = code.split("");
    
    const answer = str.filter((v,i)=> i%q===r);
    
    return answer.join("");

}