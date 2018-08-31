var testcases = +readline(),result = '';
while (testcases-->0){
    readline();
    var count = 0,current = 1;
    readline().split(' ').forEach(x=>{
        if (+x === current) current++;
            else count++;
    });
    result += count+'\n';
}
print(result);