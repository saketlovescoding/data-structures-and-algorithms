"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const readline_1 = require("readline");
const rl = (0, readline_1.createInterface)({ input: process.stdin });
const lines = [];
rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
    const str = lines[0];
    let count = 0, ans = 0;
    let ch = "";
    for (const char of str) {
        if (ch === char) {
            count++;
        }
        else {
            count = 1;
            ch = char;
        }
        ans = Math.max(ans, count);
    }
    console.log(ans);
});
