function solution(myString, pat) {
    
    let arr = myString.split("");
    
    
    return arr.map(item => item === "A" ? "B" : "A").join("").includes(pat) ? 1 : 0;
    
}