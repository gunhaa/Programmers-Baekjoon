function solution(rank, attendance) {
    
    const answer = [];    
    
    for(let i=1 ; i<rank.length+1 ; i++){
        const idx = rank.indexOf(i);
        if(attendance[idx]){
            answer.push(idx);
            if(answer.length===3){
                break;
            }
        }
    }
    console.log(answer);
    
    return answer[0]*10000 + 100*answer[1] + answer[2];

}