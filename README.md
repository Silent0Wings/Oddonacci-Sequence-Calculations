# Oddonacci Sequence Calculations

## Project Overview
Project Repport .[here](https://github.com/Silent0Wings/Oddonacci-Sequence-Calculations/blob/6cc48b494cb479e8351a28f720fa466c6bb1a380/Github.pdf).


This project implements two methods for calculating Oddonacci numbers using Java: a linear tail-recursive approach and a multiple recursive approach. These methods are implemented to study their performance in terms of execution time and efficiency.

## Code Structure

### Packages and Imports
- **Package**: `L_Oddonacci`
- **Imports**: `java.math.BigInteger` for handling large numbers, `java.io` classes for file operations.

### Main Class: `Linear_Oddonacci`
- **Methods**:
  - `main(String[] args)`: Entry point to run tests and method executions.
  - `MultipleOddonacci_Run(int numRuns)`: Executes the multiple recursive Oddonacci calculation multiple times to measure performance.
  - `LinearTailRecursiveOddonacci_Run(int numRuns)`: Executes the linear tail-recursive Oddonacci calculation.
  - `Full_Test(int numRuns)`: Runs both methods for a series of inputs to compare outputs directly.
  - `LinearTailRecursiveOddonacci(int n, BigInteger a, BigInteger b, BigInteger c)`: Calculates Oddonacci using tail recursion.
  - `MultipleOddonacci(int n, BigInteger first, BigInteger second, BigInteger third)`: Calculates Oddonacci using multiple recursion.
  - `ArrayToFile(int[] input, BigInteger[] Data, long[] time, String FuncName, String Path)`: Saves results to a file.

### Algorithm Descriptions
1. **Linear Tail-Recursive Oddonacci**
   - Tail recursion optimizes memory usage by reducing the need for new stack frames for each recursive call.
   - Example execution: Calculates efficiently by updating the last three computed values recursively.
   
2. **Multiple Recursive Oddonacci**
   - Utilizes multiple recursive calls, increasing the computation exponentially with each step.
   - Less efficient for larger inputs due to increased computational overhead.

### Usage
- Compile and run the `Linear_Oddonacci` class.
- Methods can be called with varying `numRuns` to see performance impacts directly.
- Results of performance tests are written to text files, allowing for easy analysis of execution times.

### Performance Analysis
- Execution times and Oddonacci values are recorded.
- Performance is analyzed by comparing the efficiency of linear tail recursion versus multiple recursion.

## Files and Output
- Results are saved to `MultipleOddonacci.txt` and `LinearOddonacci.txt` files, detailing the input, computed Oddonacci number, and execution time for each test.

## Contributing
- Enhancements to the recursion methods or new approaches to Oddonacci number calculations are welcome.

