# CSES Problem Set - TypeScript Solutions

CSES doesn't support TypeScript directly, but we can compile TypeScript to JavaScript and submit under **Node.js**.

## Setup

```bash
cd cses
npm install
```

## Workflow

### 1. Write your solution

Create a `.ts` file in `src/`:

```bash
# e.g., for "Weird Algorithm"
src/weird-algorithm.ts
```

All solutions read from stdin using `readline`:

```typescript
import { createInterface } from "readline";

const rl = createInterface({ input: process.stdin });
const lines: string[] = [];

rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
  // Parse input and solve here
  console.log(answer);
});
```

### Handling Multiline Input

CSES problems often provide input across multiple lines. Our readline pattern collects **all lines** into an array, making multiline parsing straightforward:

```typescript
rl.on("line", (line) => lines.push(line));
rl.on("close", () => {
  const n = Number(lines[0]);           // first line: a single value
  const nums = lines[1].split(" ").map(Number); // second line: space-separated values
  // ...
});
```

Each call to `rl.on("line", ...)` captures one line of input into the `lines` array. Once stdin closes, `lines[0]` is the first line, `lines[1]` is the second, and so on. This makes it easy to handle any input format — just index into `lines` by line number.

To test multiline input locally:

```bash
# Use echo with newline
echo "5
1 2 3 5" | node dist/missing-number.js

# Or use a file
node dist/missing-number.js < input.txt
```

### 2. Compile TypeScript to JavaScript

```bash
# Compile all .ts files in src/ to dist/
npm run build
```

This runs `tsc` which reads `tsconfig.json` and outputs `.js` files into `dist/`.

### 3. Test locally

```bash
# Pipe input directly
echo "3" | node dist/weird-algorithm.js

# Pipe from a file
node dist/weird-algorithm.js < input.txt

# Interactive input (type input, then Ctrl+D to end)
node dist/weird-algorithm.js
```

### 4. Submit on CSES

1. Go to the problem's **SUBMIT** tab
2. Upload the compiled `.js` file from `dist/` (e.g., `dist/weird-algorithm.js`)
3. Select **Node.js** as the language
4. Click Submit

## Project Structure

```
cses/
├── src/           # TypeScript source files (you write here)
├── dist/          # Compiled JavaScript files (you submit these)
├── tsconfig.json  # TypeScript compiler config
└── package.json   # npm scripts and dependencies
```

## Notes

### Printing Elements in a Single Line

When a problem expects space-separated output on a single line (e.g., `1 3 5 2 4`), collect results into an array and use `array.join(" ")`:

```typescript
const ans: number[] = [];
for (let i = 2; i <= n; i += 2) {
  ans.push(i);
}
console.log(ans.join(" "));
```

Avoid printing each element individually with `process.stdout.write()` in a loop — `join()` is cleaner and avoids trailing space issues.

### Parsing Space-Separated Input

```typescript
const nums: number[] = lines[1].split(" ").map(Number);
```

### Fast Output with Buffering

For problems with many test cases (e.g., `t` queries), printing each answer with `console.log()` in a loop can cause TLE. Instead, buffer all answers into an array and write them once at the end:

```typescript
const outputBuffer: string[] = [];

rl.on("line", (line) => {
  // ... solve and push result
  outputBuffer.push(ans.toString());
});

rl.on("close", () => {
  process.stdout.write(outputBuffer.join("\n") + "\n");
});
```

`process.stdout.write` with a single joined string is faster than many individual `console.log` calls, especially for large output.

### Using BigInt for Large Numbers

Some CSES problems involve numbers exceeding `Number.MAX_SAFE_INTEGER` (2^53 - 1). Use `BigInt` in those cases:

```typescript
const big = BigInt(lines[0]);
console.log((big * 2n).toString());
```

### Getting Map Values Safely

`Map.get()` returns `undefined` when the key doesn't exist, so TypeScript won't let you use it directly as a number. Use the nullish coalescing operator `??` to provide a default:

```typescript
const map: Map<number, number> = new Map();

// map.get(key) returns number | undefined — can't assign directly to number
let value: number = map.get(num) ?? 0;
map.set(num, value + 1);
```

`?? 0` means "use the Map's value if it exists, otherwise fall back to `0`." This is cleaner than checking `has()` + `get()` separately.

## Commands Reference

| Command | Description |
|---------|-------------|
| `npm run build` | Compile all TypeScript files to JavaScript |
| `echo "input" \| node dist/<name>.js` | Test with inline input |
| `node dist/<name>.js < input.txt` | Test with input file |
