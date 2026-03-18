"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const readline_1 = require("readline");
const rl = (0, readline_1.createInterface)({ input: process.stdin });
// We will store our answers here instead of printing them immediately
const outputBuffer = [];
let isFirstLine = true;
rl.on("line", (line) => {
    // Skip the first line since we are processing as a stream and
    // don't need the total test case count 't' for our logic
    if (isFirstLine) {
        isFirstLine = false;
        return;
    }
    // Split and parse the current line
    const indexes = line.split(" ");
    const x = BigInt(indexes[0]);
    const y = BigInt(indexes[1]);
    let maxi = x;
    let ans = 1n;
    if (y > x)
        maxi = y;
    if (maxi === x) {
        if (maxi % 2n === 0n) {
            ans = x * x - (y - 1n);
        }
        else {
            ans = (x - 1n) * (x - 1n) + (y - 1n) + 1n;
        }
    }
    else {
        if (maxi % 2n === 0n) {
            ans = (y - 1n) * (y - 1n) + (x - 1n) + 1n;
        }
        else {
            ans = y * y - (x - 1n);
        }
    }
    // Add the answer to our buffer array instead of printing it
    outputBuffer.push(ans.toString());
});
rl.on("close", () => {
    // Join all answers with a newline character and print them EXACTLY ONCE
    // process.stdout.write is slightly faster than console.log for massive strings
    process.stdout.write(outputBuffer.join("\n") + "\n");
});
