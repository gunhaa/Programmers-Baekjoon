function solution(myString) {

    let arr = myString.split("x");
    
    let answer = [];
    
    arr.forEach(item => {
        answer.push(item.length)
    })
    
    return answer;
}