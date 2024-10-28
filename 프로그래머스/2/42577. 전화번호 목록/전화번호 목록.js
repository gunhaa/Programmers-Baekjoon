function solution(phone_book) {
    let answer = true;
    let sortArr = phone_book.sort();
    for (let i = 0; i < sortArr.length; i++) {
        if (sortArr[i + 1]) {
            if (sortArr[i + 1].startsWith(sortArr[i])) {
                answer = false;
                break;
            }
        }
    }
    return answer;
}
