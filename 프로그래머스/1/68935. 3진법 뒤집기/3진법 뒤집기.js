function solution(n) {

    let base3 = n.toString(3);
    
    let base3rev= base3.split("").reverse().join("");

    return parseInt(base3rev, 3);
    
}