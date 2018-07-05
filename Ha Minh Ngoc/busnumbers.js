        readline();
        let result = [];
        readline().split(' ')
            .map(function (item) { return +item; })
            .sort(function (i1, i2) { return i1 - i2; })
            .forEach(function (item, index, array) {
                if (index == 0 || item > array[index - 1] + 1) {
                    result.push((result.length == 0 ? '' : ' ') + item);
                } else if (index == array.length - 1 || item < array[index + 1] - 1) {
                    result.push((index > 1 && array[index - 2] == item - 2 ? '-' : ' ') + item);
                }
            });
        print(result.join(''));