function solution(progresses, speeds) {
    /* pseudocode
    
        1. 모든 배열에 speeds를 더한다.
        2. progresses 0번이 100보다 크거나 같다면, 이후 인덱스도 0보다 큰것까지를 shfit한다.
        3. shift의 length를 answer에 push 한다.
        4. progress의 length가 0이 될때까지 반복한다.

    */
    let answer = [];
    let progress = progresses;
    let speed = speeds;
    while (progress.length !== 0) {
        progress = progress.map((work, index) => work + speeds[index]);
        let copyProgress = [...progress];
        if (progress[0] >= 100) {
            let shiftitem = [];
            for (let i = 0; i < progress.length; i++) {
                if (progress[i] >= 100) {
                    copyProgress.shift();
                    speed.shift();
                    shiftitem.push(1);
                }
                else {
                    break;
                }
            }
            answer.push(shiftitem.length);
            progress = [...copyProgress];
        }
    }
    return answer;
}