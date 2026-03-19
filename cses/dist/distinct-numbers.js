"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const readline_1 = require("readline");
const rl = (0, readline_1.createInterface)({ input: process.stdin });
const lines = [];
rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
    const n = Number(lines[0]);
    const numbers = lines[1].split(" ").map(Number);
    const map = new Map();
    let ans = 0;
    for (const num of numbers) {
        if (!map.has(num)) {
            ans++;
            map.set(num, 1);
        }
        else {
            let value = map.get(num) ?? 0;
            map.set(num, value + 1);
        }
    }
    console.log(ans);
});
