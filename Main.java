// Robert Bennethum IV
// CMPSC 463 HW2
// Course Scheduling Problem
import java.util.Arrays;
import java.util.Scanner;

void main() {
    int n = nInput();
    int[][] courses = coursesInput(n);
    System.out.println(calculateMaxClassesAndLearningValue(courses, n));
}

int nInput () {
    Scanner scanner = new Scanner(System.in);
    int n = 0;
    while (!(n>=1 && n <= 100000)) {
        System.out.println("N: ");
        n = scanner.nextInt();
        if (!(n>= 1 && n <= 100000)) {
            System.out.println("Invalid N");
        }
    }
    return n;
}

int[] courseInput(int expectedId, int n) {
    int[] course = {0,0,0};
    Scanner scanner = new Scanner(System.in);
    System.out.println("Course " + expectedId + ": ");
    for (int i = 0; i < 3; i++) {
        course[i] = scanner.nextInt();
    }
    if (course[0] != expectedId) {
        System.out.println("Invalid Course ID, Try Again\n");
        return courseInput(expectedId, n);
    }
    else if (!(course[1] <= n && course[1] >= 1)) {
        System.out.println("Invalid Deadline, Try Again\n");
        return courseInput(expectedId, n);
    }
    else if (!(course[2] < 1000 && course[2] >= 1)) {
        System.out.println("Invalid Learning Value, Try Again\n");
        return courseInput(expectedId, n);
    }
    return course;
}

int[][] coursesInput(int n) {
    int[][] courses = new int[n][3];
    for (int i = 1; i < n+1; i++) {
        courses[i-1] = courseInput(i, n);
    }
    return courses;
}

String calculateMaxClassesAndLearningValue(int[][] courses, int n) {
    int maxClasses = 0;
    int learningValue = 0;
    Arrays.sort(courses, new java.util.Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return Integer.compare(b[2], a[2]);
        }
    });

    int[] courseSchedule = new int[n];
    for (int i = 0; i < n; i++) {
        for (int j = courses[i][1] - 1; j >= 0; j--) {
            if (courseSchedule[j] == 0) {
                courseSchedule[j] = courses[i][0];
                learningValue += courses[i][2];
                maxClasses++;
                j = -1;
            }
        }
    }
    return "Classes: " + maxClasses + "\nLearning Value: " + learningValue;
}