function solution(priorities, location) {

    let arr = [];
    let answer = 0;
    for (let i = 0; i < priorities.length; i++) {
        arr.push(i);
    }
    while (priorities.length !== 0) {
        let maxPriority = Math.max(...priorities);
        if (priorities[0] < maxPriority) {
            priorities.push(priorities.shift());
            arr.push(arr.shift());
        }
        else {
            priorities.shift();
            answer++;
            if (arr.shift() === location) {
                console.log(answer);
                return answer;
            }
        }
    }
}