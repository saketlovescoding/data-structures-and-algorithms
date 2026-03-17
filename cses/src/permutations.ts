// [1 2 3 4 5]
// [1, 3, 5, 2, 4]
// [1 2 3 4 5 6]
// [1 3 5 6 4 2]
// [1 3 5 2 4 6 ]

import { createInterface } from "readline";

const rl = createInterface({ input: process.stdin });
const lines: string[] = [];

rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
  const n: number = Number(lines[0]);

  if (n === 1) console.log(1);
  else if (n <= 3) console.log("NO SOLUTION");
  else {
    const ans: number[] = [];
    for (let i = 2; i <= n; i += 2) {
      ans.push(i);
    }
    for (let i = 1; i <= n; i += 2) {
      ans.push(i);
    }

    console.log(ans.join(" "));
  }
});
