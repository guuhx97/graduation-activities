var fs = require("fs");

Array.prototype.diff = function(a) {
  return this.filter(function(i) {
    return a.indexOf(i) === -1;
  });
};

function generateSolution(n, w, data) {
  let items = [];
  let weight = 0;
  let value = 0;
  while (weight <= w && data.length) {
    let random = Math.floor(Math.random() * data.length);

    let item = data[random];

    data = data.filter(c => c !== item);

    while (item && weight + item.w > w) {
      random = Math.floor(Math.random() * data.length);

      item = data[random];

      data = data.filter(c => c !== item);
    }

    if (item) {
      items.push(item);
      weight = weight + item.w;
      value = value + item.v;
    }
  }
  return { items, value, weight };
}

(function init() {
  let initialDate = new Date();

  fs.readFile("data/a10000.lia", "utf8", function(err, data) {
    if (err) {
      return console.log(err);
    }

    let list = data.split("\n");

    line1 = list[0].split(",").map(Number);
    line2 = list[1].split(",").map(Number);
    line3 = list[2].split(",").map(Number);

    let n = +line1[0];
    let w = +line1[1];

    data = [];
    for (let i = 0; i < n; i++) {
      data.push({
        v: line2[i],
        w: line3[i]
      });
    }

    let solutions = [];

    let atual = generateSolution(n, w, [...data]);

    solutions.push({ ...atual, items: [...atual.items] });

    let maxRepeat = 15;
    let repeat = 0;
    let interations = 10;
    let interation = 1;
    let out = false;

    while (interation < interations && !out) {
      let solution = { ...atual, items: [...atual.items] };
      for (const item of data) {
        let hasItem = solution.items.find(c => c === item);

        if (hasItem) {
          let diff = data.diff(solution.items);

          let newItem = null;

          while (!newItem && diff.length) {
            let possibleNewItem = diff.pop();

            let wei = solution.weight - item.w + possibleNewItem.w;

            if (wei < w) {
              newItem = possibleNewItem;
            }
          }

          if (newItem) {
            solution.items = solution.items.filter(c => c != item);
            solution.value -= item.v;
            solution.weight -= item.w;

            solution.items.push(newItem);
            solution.value += newItem.v;
            solution.weight += newItem.w;

            solutions.push({ ...solution, items: [...solution.items] });
          }
        } else {
          if (solution.weight + item.w < w) {
            solution.items.push(item);
            solution.value += item.v;
            solution.weight += item.w;

            solutions.push({ ...solution, items: [...solution.items] });
          }
        }
      }

      solutions.sort((a, b) => b.value - a.value);

      let newBest = solutions[0];

      // console.log("Interation: ", interation);
      // console.log("Atual: ", atual.value, atual.weight);
      // console.log("newBest: ", newBest.value, newBest.weight);

      if (solutions.length > n * n || repeat >= maxRepeat) {
        out = true;
      }

      if (newBest.value !== atual.value) {
        atual = newBest;
      } else {
        newBest = solutions[Math.floor(Math.random() * solutions.length)]; // Se não existir melhor com a solução atual, pega uma aleatoria e tenta novamente
        repeat++;
        if (newBest.value !== atual.value) {
          atual = newBest;
        }
      }

      interation++;
    }

    let endDate = new Date();
    console.log("Best: ", solutions[0].value, solutions[0].weight);
    console.log("Total interações: ", interation);
    console.log("Total soluções: ", solutions.length);
    console.log("Tempo: ", endDate - initialDate);

    // for (let i = 0; i < solutions.length; i++) {
    //   console.log(solutions[i].value, solutions[i].weight);
    // }
  });
})();
