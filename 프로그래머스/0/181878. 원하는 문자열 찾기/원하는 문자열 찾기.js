function solution(myString, pat) {

    return myString.toLowerCase().indexOf(pat.toLowerCase()) > -1 ? 1 : 0;
}