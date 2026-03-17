"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const readline_1 = require("readline");
const rl = (0, readline_1.createInterface)({ input: process.stdin });
const lines = [];
rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
    const n = Number(lines[0]);
    const array = lines[1].split(" ").map(Number);
    let ans = 0;
    let maxSoFar = array[0];
    for (const num of array) {
        if (num < maxSoFar) {
            ans += maxSoFar - num;
        }
        maxSoFar = Math.max(maxSoFar, num);
    }
    console.log(ans);
});
