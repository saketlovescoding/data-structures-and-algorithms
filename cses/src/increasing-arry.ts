import { createInterface } from "readline";

const rl = createInterface({ input: process.stdin });
const lines: string[] = [];

rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
  const n: number = Number(lines[0]);
  const array: number[] = lines[1].split(" ").map(Number);

  let ans: number = 0;
  let maxSoFar: number = array[0];

  for (const num of array) {
    if (num < maxSoFar) {
      ans += maxSoFar - num;
    }
    maxSoFar = Math.max(maxSoFar, num);
  }

  console.log(ans);
});
