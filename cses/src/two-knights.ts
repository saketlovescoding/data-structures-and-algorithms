import { createInterface } from "readline";

const rl = createInterface({input: process.stdin})
const lines : string[] = [];

rl.on("line", (line)=>lines.push(line))
rl.on("close", ()=>{
    const n : number = Number(lines[0]);

    
})