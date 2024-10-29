function solution(num) {

    const even = (n) => {
        num=num/2;
    };
    
    const odd = (n) => {
        num = num*3 + 1;
    };
    
    let count = 0;
    
    while(count<500){
       
        if(num===1){
            return count;
        } else {
            num%2===0 ? even(num) : odd(num)
        }
        count++;
        
    }
    return -1;
    
}