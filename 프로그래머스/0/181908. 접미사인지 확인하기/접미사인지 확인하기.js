function solution(my_string, is_suffix) {
    
    let answer = [];
    
    for(let i=0; i<my_string.length; i++){
        
        answer.push(my_string.slice(my_string.length-i-1, my_string.length))
        
    }
    console.log(answer)
    console.log(answer.includes(is_suffix))
    
    return answer.includes(is_suffix) === true ? 1 : 0;
}