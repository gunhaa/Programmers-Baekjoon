function solution(arr, n) {
    return arr.length % 2 === 0 ?
        arr.map((item , index) => index % 2 === 1 ? item + n : item ) : arr.map((item , index) => index % 2 === 0 ? item +n : item);
}