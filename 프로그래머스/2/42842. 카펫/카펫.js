function solution(brown, yellow) {
    let sum = brown + yellow;
    let arr = [];
    const candidate = (sum) => {
        for (let i = Math.ceil(Math.sqrt(sum)); i < sum; i++) {
            if (sum % i === 0 && sum / i >= 3) {
                arr.push([i, sum / i]);
            }
        }
    };
    candidate(sum);
    arr.reverse();
    console.log(arr);
    while (arr.length !== 0) {
        let stack = arr.pop();
        let brownTile = (stack[0]) * 2 + (stack[1] - 2) * 2;
        let yellowTile = (stack[0] - 2) * (stack[1] - 2);
        // console.log(`brown : ${brownTile} , yellow : ${yellowTile}`)
        let tileSum = brownTile + yellowTile;
        // console.log(`tileSum : ${tileSum} , sum : ${sum}`)
        if (tileSum === sum && brown === brownTile && yellow === yellowTile) {
            console.log(stack);
            return stack;
        }
    }
}