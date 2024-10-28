function solution(myStr) {
    
    
    const result = myStr.split(/[abc]/);
    
    return result.filter(v=>v!=="").length!==0 ? result.filter(v=>v!=="") : ["EMPTY"]
}