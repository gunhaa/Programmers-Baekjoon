function solution(s, n) {

    const asc = s.split("").map(v=> {
       
        const temp = v.charCodeAt();
        
        if(temp === 32) {
            return temp; 
        } 
        
        if(temp>=65 && temp<=90 && temp+n>90){
            return temp+n-26;
        }
        
        if(temp+n > 122 ){    
            return temp+n-26;
        } 
        
        
        return temp+n;
        
    });
    
    
    return asc.map(v => String.fromCharCode(v)).join("");
}