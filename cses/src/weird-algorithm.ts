import { createInterface } from "readline";

const rl = createInterface({ input: process.stdin });
const lines: string[] = [];

rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
  let n = BigInt(lines[0]);
  const result: bigint[] = [n];

  while (n !== 1n) {
    if (n % 2n === 0n) {
      n = n / 2n;
    } else {
      n = 3n * n + 1n;
    }
    result.push(n);
  }

  console.log(result.join(" "));
});
