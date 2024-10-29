function solution(arr, divisor) {

    const filter = arr.filter(v=> v%divisor===0 ? true : false);
    
    return filter.length === 0 ? [-1] : filter.sort((a,b) => a-b);
    
}