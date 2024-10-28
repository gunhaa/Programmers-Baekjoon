function solution(sequence) {
    var pulse1 = [];
    var pulse2 = [];
    // 1. 시퀀스를 펄스 수열을 곱한 두개로 만든다.
    for (var i = 0; i < sequence.length; i++) {
        if (i % 2 == 0) {
            pulse1.push(1);
        }
        else {
            pulse1.push(-1);
        }
    }
    for (var i = 0; i < sequence.length; i++) {
        if (i % 2 == 0) {
            pulse2.push(-1);
        }
        else {
            pulse2.push(1);
        }
    }
    var temp1 = sequence.map(function (item, index) {
        return item * pulse1[index];
    });
    var temp2 = sequence.map(function (item, index) {
        return item * pulse2[index];
    });
    var max1 = -Infinity;
    var max2 = -Infinity;
    var now1 = 0;
    var now2 = 0;
    for (var i = 0; i < temp1.length; i++) {
        // 지금 값,여태까지 누적합중 최대
        now1 = Math.max(temp1[i], now1 + temp1[i]);
        max1 = Math.max(now1, max1);
    }
    // if (now1 > max1) {
    //     max1 = now1;
    // } else {
    //     now1 = max1;
    // }
    for (var i = 0; i < temp2.length; i++) {
        now2 = Math.max(temp2[i], now2 + temp2[i]);
        max2 = Math.max(now2, max2);
    }
    return Math.max(max1, max2);
}