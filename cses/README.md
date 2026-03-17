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

## Commands Reference

| Command | Description |
|---------|-------------|
| `npm run build` | Compile all TypeScript files to JavaScript |
| `echo "input" \| node dist/<name>.js` | Test with inline input |
| `node dist/<name>.js < input.txt` | Test with input file |
