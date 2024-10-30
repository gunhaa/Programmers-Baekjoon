function solution(s) {

    const voca = s.split(" ");
    const jadencase = voca.map(v=>{
        if (v.length === 0) return ""; 
        return /[a-z]/.test(v[0]) ? v[0].toUpperCase()+v.slice(1).toLowerCase() : v[0]+v.slice(1).toLowerCase();
    
    }); 
    
    return jadencase.join(" ");

}