function solution(strings, n) {

    
    return strings.sort((a, b) => {
        
        let charA = a[n];
        let charB = b[n];
        
        if(charA===charB){
            return a.localeCompare(b);  
        }
        
        
        return charA.localeCompare(charB);
    });       
    
}