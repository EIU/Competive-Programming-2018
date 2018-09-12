var digitalNumbers = [];
digitalNumbers[0] = ['+---+','|   |','|   |','+   +','|   |','|   |','+---+'];//

digitalNumbers[1] = ['    +','    |','    |','    +','    |','    |','    +'];//

digitalNumbers[2] = ['+---+','    |','    |','+---+','|    ','|    ','+---+'];//

digitalNumbers[3] = ['+---+','    |','    |','+---+','    |','    |','+---+'];//

digitalNumbers[4] = ['+   +','|   |','|   |','+---+','    |','    |','    +'];//

digitalNumbers[5] = ['+---+','|    ','|    ','+---+','    |','    |','+---+'];//

digitalNumbers[6] = ['+---+','|    ','|    ','+---+','|   |','|   |','+---+'];//

digitalNumbers[7] = ['+---+','    |','    |','    +','    |','    |','    +'];//

digitalNumbers[8] = ['+---+','|   |','|   |','+---+','|   |','|   |','+---+'];//

digitalNumbers[9] = ['+---+','|   |','|   |','+---+','    |','    |','+---+'];//

digitalNumbers[10] = ['     ','     ','  o  ','     ','  o  ','     ','     '];//
var time;
var result = '';
while ((time = readline()) !== 'end'){
    time = time.split('');
    for (var i=0;i<7;i++){
        result += digitalNumbers[+time[0]][i] + '  ' + digitalNumbers[+time[1]][i] 
                + digitalNumbers[10][i]
                + digitalNumbers[+time[3]][i] + '  '+ digitalNumbers[+time[4]][i] +'\n';
    }
    result += '\n\n';
}
result += 'end';
print(result);