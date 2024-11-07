function solution(a, b, n) {

    const cola = ( a , b , n, can ) => {
    
        if(a>n) return can;
    
        const newColas = Math.floor(n / a) * b;
        const remainingBottles = n % a; 
        
        
        return cola(a, b, newColas + remainingBottles, can + newColas);        
    }

    return cola(a,b,n,0);
    
}