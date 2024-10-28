function solution(my_string, m, c) {
    
    let str = my_string.split("");
    
    let answer = str.filter((v,i)=>i%m===c-1);
    
    
    return answer.join("");
}