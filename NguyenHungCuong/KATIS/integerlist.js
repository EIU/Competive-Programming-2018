test = +readline();
while (test-->0){
    D = 0;
    cmd = readline().split('');
    cmd.forEach(x=> D += (x === 'D')?1:0);
    n = +readline();
    ar = readline().split(',');
    if (D >= n){
        if (D > n) print('error');
        if (D == n) print('[]');
        continue;
    }
    ar[0] = ar[0].substring(1);
    ar[n-1] = ar[n-1].substring(0,ar[n-1].length-1);
    
    start = 0;
    end = n-1;
    order = true;
    cmd.forEach(x=>{
       if (x === 'R') order = !order;
       else if (order) {
           start++;
       } else {
           end--;
       }
    });
    res = '[';
    if (order){
        res += ar[start++];
        for (;start<=end;start++){
           res += ','+ar[start];    
        }
    } else {
        res += ar[end--];
        for (;end>=start;end--){
            res += ','+ar[end];
        }
    }
    res += ']';
    print(res);
}