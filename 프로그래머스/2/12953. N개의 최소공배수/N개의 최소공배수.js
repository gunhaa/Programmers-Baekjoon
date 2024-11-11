function solution(arr) {

    const gcd = (a,b) => {
        if(b===0) return a;
        else return gcd(b, a%b)
    }
    
    const lcm = (a,b) => {
        return (a*b)/gcd(a,b);
    }
    
    
    let l = arr[0];
    
    for(let i=1; i<arr.length; i++){
        
         l = lcm(l,arr[i]);
        
    }
    
    return l;
    
}