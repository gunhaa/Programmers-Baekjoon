function solution(s) {
    let stack = [];
    for (let item of s) {
        if (item === "(") {
            stack.push("(");
        }
        else if (item === ")") {
            if (stack.length === 0) {
                return false;
            }
            stack.pop();
        }
    }
    console.log(`stack.len : ${stack.length}`);
    return stack.length === 0;
}