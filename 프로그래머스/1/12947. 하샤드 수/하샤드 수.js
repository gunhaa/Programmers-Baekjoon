function solution(x) {

    let acc = 0 ;
    
    for(const num of x.toString()){
        
        acc += parseInt(num);
        
    }
    
    return x % acc === 0 ? true : false;
    
}