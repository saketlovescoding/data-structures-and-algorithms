"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const readline_1 = require("readline");
const rl = (0, readline_1.createInterface)({ input: process.stdin });
const lines = [];
rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
    let n = BigInt(lines[0]);
    const result = [n];
    while (n !== 1n) {
        if (n % 2n === 0n) {
            n = n / 2n;
        }
        else {
            n = 3n * n + 1n;
        }
        result.push(n);
    }
    console.log(result.join(" "));
});
