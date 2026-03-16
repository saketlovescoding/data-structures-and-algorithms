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
