var guess = 500;
print(guess);
var response;
var up = 1000, down = 1;
while ((response = readline()) !== 'correct'){
    if (response === 'lower'){
        up = guess - 1;
        guess = Math.floor((up+down)/2);
        print(guess);
    } else {
        down = guess + 1;
        guess = Math.floor((up+down)/2);
        print(guess);
    }
}