function solution(n) {
    
    const fiboElement = [0,1];     
    
    for (let i = 2; i <= n; i++) {
        let element = (fiboElement[i - 1] + fiboElement[i - 2])%1234567;
        fiboElement.push(element);
    }

    return fiboElement[n]%1234567;

}