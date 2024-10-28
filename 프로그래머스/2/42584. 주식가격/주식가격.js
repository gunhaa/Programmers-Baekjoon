function solution(prices) {
    let answer = [];
    for (let i = 0; i < prices.length; i++) {
        let t = 0;
        for (let j = i + 1; j < prices.length; j++) {
            if (prices[i] > prices[j]) {
                t++;
                break;
            }
            else {
                t++;
            }
        }
        answer.push(t);
    }
    return answer;
}