function solution(my_string, s, e) {

    let str = my_string.split("");
    let answer = str.splice(s,e-s+1).reverse();
    str.splice(s,0, ...answer);
    
    return str.join("");
}