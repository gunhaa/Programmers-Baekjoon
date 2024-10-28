function solution(binomial) {
    
    const operation = {
        "+" : (a,b) => Number(a) + Number(b),
        "-" : (a,b) => Number(a) - Number(b),
        "*" : (a,b) => Number(a) * Number(b)
    }
    
    const arr = binomial.split(" ");

    return operation[arr[1]](arr[0], arr[2]);

}