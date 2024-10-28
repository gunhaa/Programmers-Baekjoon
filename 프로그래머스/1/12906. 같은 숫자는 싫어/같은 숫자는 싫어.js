function solution(arr) {
    var prev = Infinity;
    var answer = [];
    for (var i = 0; i < arr.length; i++) {
        if (prev == arr[i]) {
            continue;
        }
        else {
            answer.push(arr[i]);
        }
        prev = arr[i];
    }
    return answer;
}
