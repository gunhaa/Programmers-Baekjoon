function solution(clothes) {
    let kind = [];
    for (let i = 0; i < clothes.length; i++) {
        const currentKind = clothes[i][1];
        // 없으면 false 반환
        const exist = kind.some(item => item.kind === currentKind);
        // console.log(currentKind);
        // console.log(exist);
        if (!exist) {
            kind.push({ kind: currentKind, count: 1 });
        }
        else {
            kind.find(item => item.kind === currentKind).count++;
        }
    }
    let answer = 1;
    for (let item of kind) {
        answer = (item.count + 1) * answer;
        console.log(answer);
    }
    return answer - 1;
}