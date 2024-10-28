function solution(my_string) {
    
    const asc = [...my_string].map( v => v.charCodeAt(0));
    const answer = [];
    
    for(let i=65; i<91; i++){
        answer.push(asc.filter(v=>v===i).length);
    }
    
    for(let i=97 ; i<123 ; i++){
        answer.push(asc.filter(v=>v===i).length);
    }
    
    return answer;    
}