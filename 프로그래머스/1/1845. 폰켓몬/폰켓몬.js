function solution(nums) {
    let answer;
    let pocketSet = new Set(nums);
    if (nums.length / 2 > pocketSet.size) {
        answer = pocketSet.size;
    }
    else {
        answer = nums.length / 2;
    }
    return answer;
}