function solution(myString) {
    return myString.replaceAll('a', 'A').split("").map(item => item==='A' ? 'A' : item.toLowerCase() ).join("");
}