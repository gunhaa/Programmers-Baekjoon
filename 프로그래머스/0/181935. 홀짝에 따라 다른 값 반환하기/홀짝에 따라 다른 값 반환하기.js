function solution(n) {
    
    let answer = 0;
    let arr = [];
    
    for(let i=1; i<n+1; i++){
        arr.push(i);
    }    
    console.log(arr);
    return n%2===1 ? arr.filter(a=> a%2===1).reduce((a,b)=> a+b,0) : arr.filter(a=> a%2 ===0).reduce((a,b)=> a+Math.pow(b,2),0)    

    
        
        
}