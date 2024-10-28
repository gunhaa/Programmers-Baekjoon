function solution(str1, str2) {
    
    const arr = str1.split("");
    
    return arr.reduce((a, b, index) => a+b+str2[index] , "").toString();
    
}