var result = '';
function checkStartsWith(arr){
    for (var index = 0;index<arr.length-1;index++){
         if (arr[index].startsWith(arr[index+1]) || arr[index+1].startsWith(arr[index])){
                return 'NO\n';
            }
    }
    return 'YES\n';
}
for (var testcase = +readline();testcase>0;testcase--){
    var phones = [];
    for (var i = 0,len = +readline();i<len;i++){
        phones[i] = readline();
    }
    phones.sort((a,b)=>a.localeCompare(b));
    result += checkStartsWith(phones);
}
print(result);