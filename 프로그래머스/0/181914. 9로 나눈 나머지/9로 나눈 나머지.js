function solution(number) {
    
    return number.split("").reduce((ac, v)=> ac+Number(v),0)%9;
}