function solution(myString, pat) {

    const idx = myString.lastIndexOf(pat);
    
    const len = pat.length
    
    const answer = myString.slice(0, idx+len);
    
    return answer;

}