function solution(n){
    
    const arr = n.toString().split("");
    
    return arr.reduce((acc, v) => acc+Number(v),0);
    
}