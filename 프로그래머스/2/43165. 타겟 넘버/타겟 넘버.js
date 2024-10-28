function solution(numbers, target) {
    var answer = 0;
    function dfs(start, numbers, target, sum) {
        if (numbers.length == start) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(start + 1, numbers, target, sum + numbers[start]);
        dfs(start + 1, numbers, target, sum - numbers[start]);
    }
    dfs(0, numbers, target, 0);
    return answer;
}