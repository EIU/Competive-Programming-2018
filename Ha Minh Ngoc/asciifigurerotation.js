        let n = 0;
        let firstLine = true;
        while ((n = +readline()) > 0) {
            let matrix = [];
            let width = 0;
            for (let i = 0; i < n; i++) {
                let line = readline();
                line = line.split('');
                matrix.push(line);
                width = Math.max(width, line.length);
            }

            if (!firstLine) print('');
            firstLine = false;

            for (let j = 0; j < width; j++) {
                let vLine = [];
                for (let i = n - 1; i >= 0; i--) {
                    let c = matrix[i][j];
                    c = (!c ? ' ' : (c == '-' ? '|' : (c == '|' ? '-' : c)));
                    vLine.push(c);
                }
                print(vLine.join('').trimRight());
            }
        }