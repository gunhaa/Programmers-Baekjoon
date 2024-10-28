function solution(numbers, n) {
    
    let answer = 0;
    
    numbers.some((v,i)=>{
        return (answer += v) > n
    })
    
    return answer;
}