function solution(numbers) {
    let answer = Array.from({length : numbers.length}).fill(-1);
    let stack = [];
    for (let i = 0; i < numbers.length; i++) {

        while (stack.length > 0 && numbers[i] > numbers[stack[stack.length - 1]]) {
            const index = stack.pop();
            answer[index] = numbers[i]; 
        }
        stack.push(i);
    }
    return answer;
}