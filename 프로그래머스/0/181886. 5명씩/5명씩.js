function solution(names) {
    return names.filter((item, idx) => (idx+1) % 5 ===1? true : false)
}