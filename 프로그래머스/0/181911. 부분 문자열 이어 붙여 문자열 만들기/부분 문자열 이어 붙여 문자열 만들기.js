function solution(my_strings, parts) {
    
    const answer = [];
    
    parts.forEach((v,i) => {
        const temp = my_strings[i].slice(v[0], v[1]+1);
        answer.push(temp);
        
    })
    return answer.join("")
}