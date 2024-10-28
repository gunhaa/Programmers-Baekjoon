function solution(array, commands) {
    let answer = [];
    for (let i = 0; i < commands.length; i++) {
        let tempSliceSortArr = array.slice(commands[i][0] - 1, commands[i][1]).sort((a, b) => a - b);
        let answerElement = tempSliceSortArr[commands[i][2] - 1];
        answer.push(answerElement);
    }
    return answer;
}