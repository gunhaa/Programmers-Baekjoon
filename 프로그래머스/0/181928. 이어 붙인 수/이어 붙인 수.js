function solution(num_list) {

    const odd = num_list.filter(el => el % 2 === 1 );
    const even = num_list.filter(el => el %2 === 0 );
    
    const a = odd.join("");
    const b = even.join("");
    
    return Number(a) + Number(b);
}