function solution(num_list) {
    let evenSum = num_list.reduce( (a,b,index) => index % 2===0 ? a + b : a , 0 );
    let oddSum = num_list.reduce( (a,b,index) => index % 2===1 ? a + b : a , 0 );
    
    return evenSum > oddSum ? evenSum : oddSum;
}