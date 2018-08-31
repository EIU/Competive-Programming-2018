var out ="";
function dfs(arr,chosen,i){
    if (i == arr.length - 1){
        if (chosen.length !== 0){
            out += chosen.join(' ')+"\n";
        }
    } else {
        dfs(arr,chosen,i+1);
    }
    chosen.push(arr[i]);
    if (i == arr.length - 1){
        out += chosen.join(' ')+"\n";
    } else {
        dfs(arr,chosen,i+1);
    }
    chosen.splice(chosen.length-1,1);
}
print((1<<+readline())-1);
dfs(readline().split(' '),[],0);
print(out)