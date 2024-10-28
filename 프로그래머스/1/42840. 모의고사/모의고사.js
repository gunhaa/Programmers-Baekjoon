function solution(answers) {
    const pattern1 = "12345";
    const pattern2 = "21232425";
    const pattern3 = "3311224455";
    const len = answers.length;
    const people1 = Array.from({ length: len }, (_, index) => pattern1[index % pattern1.length]);
    const people2 = Array.from({ length: len }, (_, index) => pattern2[index % pattern2.length]);
    const people3 = Array.from({ length: len }, (_, index) => pattern3[index % pattern3.length]);
    let count1 = 0;
    let count2 = 0;
    let count3 = 0;
    for (let i = 0; i < len; i++) {
        if (Number(people1[i]) === answers[i]) {
            count1++;
        }
        if (Number(people2[i]) === answers[i]) {
            count2++;
        }
        if (Number(people3[i]) === answers[i]) {
            count3++;
        }
    }
    const maxCount = Math.max(count1, count2, count3);
    const arr = [];
    const answer = [];
    arr.push({ student: 1, ct: count1 });
    arr.push({ student: 2, ct: count2 });
    arr.push({ student: 3, ct: count3 });
    arr.forEach(item => {
        if (item.ct === maxCount) {
            answer.push(item.student);
        }
    });
    console.log(answer);
    return answer;
}