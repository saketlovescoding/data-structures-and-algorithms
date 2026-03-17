import { createInterface } from "readline";

const rl = createInterface({ input: process.stdin });
const lines: string[] = [];

rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
  const str: string = lines[0];

  let count: number = 0,
    ans: number = 0;
  let ch: string = "";

  for (const char of str) {
    if (ch === char) {
      count++;
    } else {
      count = 1;
      ch = char;
    }
    ans = Math.max(ans, count);
  }

  console.log(ans);
});
