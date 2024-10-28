function solution(s, skip, index) {
    let asc = s.split("").map(v => v.charCodeAt(0));
    const skipAsc = skip.split("").map(v => v.charCodeAt(0));
    while (index !== 0) {
        asc = asc.map(v => {
            do {
                v += 1;
                if (v > 122) {
                    v = 97;
                }
            } while (skipAsc.includes(v));
            return v;
        });
        index--;
    }
    const answer = asc.map(v => String.fromCharCode(v));
    console.log(answer);
    return answer.join("");
}