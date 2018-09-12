var n = +readline();
var result = '1 ';
var current = 1;
var count  = 1;
while (current*2 <n){
    current *= 2;
    count ++;
    result += current +' ';
}
print(count)
print(result);