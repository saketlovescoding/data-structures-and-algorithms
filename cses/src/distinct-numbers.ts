import { createInterface } from "readline";

const rl = createInterface({ input: process.stdin });
const lines: string[] = [];

rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
  const n: number = Number(lines[0]);
  const numbers: number[] = lines[1].split(" ").map(Number);

  const map: Map<number, number> = new Map();
  let ans: number = 0;

  for (const num of numbers) {
    if (!map.has(num)) {
      ans++;
      map.set(num, 1);
    } else {
      let value: number = map.get(num) ?? 0;
      map.set(num, value + 1);
    }
  }

  console.log(ans);
});
