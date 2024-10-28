function solution(x1, x2, x3, x4) {

    const v = (a, b) => {
        if(a===false && b === false) return false
        else return true
    }
    
    const n = (a, b) => {
        if(a===true && b === true) return true
        else return false
    } 
    
    return n(v(x1,x2) , v(x3,x4));

}