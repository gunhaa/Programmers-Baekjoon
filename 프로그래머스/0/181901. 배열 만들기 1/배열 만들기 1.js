function solution(n, k) {

    const answer = [];
    
    for(let i=1; i<n+1; i++){
        if(i%k===0) answer.push(i);
    }
    
    return answer
}