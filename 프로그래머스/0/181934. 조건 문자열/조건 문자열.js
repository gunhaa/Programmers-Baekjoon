function solution(ineq, eq, n, m) {
    
    
    let sumeq = ineq+eq;
    
    switch(sumeq){
        
        case ">=" :
            return n >= m ? 1 : 0;
        
        case "<=" :
            return n<= m ? 1 : 0;
        
        case ">!" :
            return n>m ? 1: 0;
        
        case "<!" :
            return n<m ? 1: 0;
        
    }
    
}