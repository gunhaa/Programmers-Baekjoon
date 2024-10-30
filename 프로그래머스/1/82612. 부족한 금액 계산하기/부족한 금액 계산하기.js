function solution(price, money, count) {
    
    let acc = 0;
    const val = price;
    
    for(let i=0; i<count; i++){
        acc += price;
        price += val;
    }
    
    let answer = money - acc;
    
    return answer > 0 ? 0 : Math.abs(answer);
    
}