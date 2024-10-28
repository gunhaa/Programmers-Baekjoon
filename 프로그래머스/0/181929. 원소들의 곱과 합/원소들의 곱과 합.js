function solution(num_list) {
    
    
    let sum = num_list.reduce((a , b) => a + b , 0 );
    let multiply = num_list.reduce((a,b) => a * b, 1 );
    
    if(sum*sum > multiply) return 1;
    else return 0;
}