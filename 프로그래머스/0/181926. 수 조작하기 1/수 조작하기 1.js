function solution(n, control) {

    const arr = control.split("");
    let answer = 0;
    const convert = {
        "w": +1,
        "s": -1,
        "d": +10,
        "a": -10
    }
    
    return arr.reduce((ac, v, i) => {
        return ac+convert[v]
    }, n);
    
}