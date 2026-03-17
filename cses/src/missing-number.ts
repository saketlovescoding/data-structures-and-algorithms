import { createInterface } from "readline";

const rl = createInterface({ input: process.stdin });
const lines: string[] = [];

rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
  const n = Number(lines[0]);
  const numbers = lines[1].split(" ").map(Number);

  const expectedSum = n * (n + 1) / 2;
  const actualSum = numbers.reduce((sum, num) => sum + num, 0);

  console.log(expectedSum - actualSum);
});
