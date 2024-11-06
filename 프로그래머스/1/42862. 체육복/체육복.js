function solution(n, lost, reserve) {
    
    
    const filterLost = lost.filter(v => !reserve.includes(v)).sort( (a,b) => a-b);
    
    const filterReserve = reserve.filter(v => !lost.includes(v)).sort( (a,b) => a-b);
    
    return n-filterLost.filter((v,i)=> {
        
        if(filterReserve.indexOf(v-1)>-1){
            filterReserve.splice(filterReserve.indexOf(v-1), 1);
            return false;
        }
        if(filterReserve.indexOf(v+1)>-1){
            filterReserve.splice(filterReserve.indexOf(v+1), 1);
            return false;
        }
        
        return true;
        
    }).length;
    
}