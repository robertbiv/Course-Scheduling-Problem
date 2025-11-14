# Course Scheduling Problem

A Java solution to the Course Scheduling Problem that maximizes learning value while respecting course deadlines.

## Problem Description

Given N courses, each with:
- A unique course ID
- A deadline (time slot by which it must be completed)
- A learning value (benefit gained from taking the course)

The goal is to schedule courses to maximize total learning value while ensuring each course is completed before its deadline. Each course takes exactly 1 time slot.

## Algorithm

This solution uses a **greedy algorithm** with the following approach:

1. **Sort courses by learning value** (highest to lowest)
2. **Schedule each course as late as possible** before its deadline
3. **Fill available time slots** starting from the deadline and working backwards

This greedy approach ensures maximum learning value by prioritizing high-value courses and efficiently utilizing available time slots.

### Time Complexity
- **O(n² log n)** where n is the number of courses
  - O(n log n) for sorting courses by learning value
  - O(n²) for scheduling (nested loops through courses and time slots)

### Space Complexity
- **O(n)** for storing the course schedule array

## Input Format

The program expects interactive input:

1. **N**: Number of courses (1 ≤ N ≤ 100,000)
2. For each course, three integers:
   - **Course ID**: Expected sequential ID (1 to N)
   - **Deadline**: Time slot by which course must be completed (1 ≤ deadline ≤ N)
   - **Learning Value**: Benefit of taking the course (1 ≤ value < 1,000)

### Example Input
```
N: 
4
Course 1: 
1 4 20
Course 2: 
2 1 10
Course 3: 
3 2 40
Course 4: 
4 2 30
```

## Output Format

The program outputs:
- **Classes**: Number of courses scheduled
- **Learning Value**: Total learning value achieved

### Example Output
```
Classes: 3
Learning Value: 90
```

In this example:
- Course 3 (value 40) is scheduled at time slot 2
- Course 4 (value 30) is scheduled at time slot 1
- Course 1 (value 20) is scheduled at time slot 4
- Course 2 (value 10) cannot be scheduled (deadline conflict)

## Requirements

- **Java 21 or higher** (uses implicit main method feature)
- No external dependencies required

## Usage

### Compile
```bash
javac --enable-preview --release 21 Main.java
```

### Run
```bash
java --enable-preview Main
```

**Note**: If you're using Java 17 or earlier, you'll need to refactor `Main.java` to use a traditional class structure with a `public static void main(String[] args)` method.

## Implementation Details

### Key Methods

- **`main()`**: Entry point that coordinates input and output
- **`nInput()`**: Validates and reads the number of courses
- **`courseInput(int expectedId, int n)`**: Validates and reads individual course data
- **`coursesInput(int n)`**: Reads all N courses
- **`calculateMaxClassesAndLearningValue(int[][] courses, int n)`**: Core algorithm that schedules courses and calculates results

### Input Validation

The program includes robust input validation:
- N must be between 1 and 100,000
- Course IDs must match expected sequential order
- Deadlines must be between 1 and N
- Learning values must be between 1 and 999

Invalid inputs trigger re-prompts with error messages.

## Project Information

- **Course**: CMPSC 463 (Algorithms)
- **Assignment**: HW2
- **Author**: Robert Bennethum IV

## License

This is an academic project. Please refer to your institution's academic integrity policies before using this code.
