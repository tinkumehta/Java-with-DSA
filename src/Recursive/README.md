# RECURSION
Recursion is a programming technique where a function calls itself to solve a problem. It is often used to solve problems that can be broken down into smaller subproblems of the same type.

Key Concepts of Recursion:
- Base Case: The condition that stops the recursion. Without a base case, the function will call itself indefinitely, causing a stack overflow.
- Recursive Case: The part of the function that calls itself with a smaller or simpler input.
- Stack Usage: Recursive calls are stored in the function call stack, and each call waits for the next one to complete before it returns.

## Advantages of Recursion:
- Simplifies code for problems like tree traversal, backtracking, and divide-and-conquer algorithms.
- Reduces the need for explicit loops.
## Disadvantages of Recursion:
- High memory usage due to function call stack.
- Can be slower compared to iterative solutions.
- Risk of stack overflow if recursion depth is too large.