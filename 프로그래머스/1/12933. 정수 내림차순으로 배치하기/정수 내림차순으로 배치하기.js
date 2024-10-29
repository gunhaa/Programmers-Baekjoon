function solution(n) {
    
    return parseInt(n.toString().split("").map(v=> parseInt(v)).sort((a,b)=> b-a).join(""));
    
}