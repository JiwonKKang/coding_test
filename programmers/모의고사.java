import java.util.ArrayList;
import java.util.List;

class Solution {

    class Student implements Comparable<Student>{
        private int idx;
        private int score;

        public Student(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        public void scoreUp() {
            this.score += 1;
        }

        @Override
        public int compareTo(Student student) {
            return this.score - student.score;
        }
    }

    public int[] solution(int[] answers) {

        List<Student> students = new ArrayList<>();

        int[] math1 = {1, 2, 3, 4, 5};
        int[] math2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] math3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        Student student1 = new Student(1, 0);
        Student student2 = new Student(2, 0);
        Student student3 = new Student(3, 0);

        for (int i = 0; i < answers.length; i++) {
            if (math1[i % math1.length] == answers[i]) {
                student1.scoreUp();
            }
            if (i == answers.length - 1) {
                students.add(student1);
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (math2[i % math2.length] == answers[i]) {
                student2.scoreUp();
            }
            if (i == answers.length - 1) {
                students.add(student2);
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (math3[i % math3.length] == answers[i]) {
                student3.scoreUp();
            }
            if (i == answers.length - 1) {
                students.add(student3);
            }
        }

        students.sort(Student::compareTo);

        Student max = students.stream().max(Student::compareTo).get();
        int maxScore = max.score;

        int[] answer = students.stream().filter(student -> student.score == maxScore).map(student -> student.idx).mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
