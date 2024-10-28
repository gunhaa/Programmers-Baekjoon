function solution(num_str) {

    let num_arr = num_str.split("");
    let answer = 0;
    
    console.log(num_arr);
    for(let num of num_arr){
        
        answer += Number(num);
        
    }
    
    return answer
}