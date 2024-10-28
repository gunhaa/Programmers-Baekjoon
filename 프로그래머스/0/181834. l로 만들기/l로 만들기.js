function solution(myString) {

    let stringArr = [...myString];
    
    return stringArr.map(item => item.charCodeAt() < 108 ? "l" : item ).join("");
}