class Solution {

    static class Robot {
        private int row;
        private int column;

        public Robot() {
        }

        public void setRow(int row) {
            this.row = row;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public void move(String direction) {
            if (direction.equals("W")) {
                this.column -= 1;
            }

            if (direction.equals("E")) {
                this.column += 1;
            }

            if (direction.equals("N")) {
                this.row -= 1;
            }

            if (direction.equals("S")) {
                this.row += 1;
            }
        }

    }

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        Robot robot = new Robot();

        char[][] parkMap = new char[park.length][];

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                robot.setRow(i);
                robot.setColumn(park[i].indexOf("S"));
            }
            parkMap[i] = park[i].toCharArray();
        }


        for (String route : routes) {
            String[] routeArray = route.split(" ");
            String direction = routeArray[0].trim();
            String move = routeArray[1].trim();
            int tmpRow = robot.row;
            int tmpCol = robot.column;

            boolean possible = true;

            for (int x = 0; x < Integer.parseInt(move); x++) {
                robot.move(direction);

                if (robot.row < 0 || robot.column < 0 || robot.row >= park.length || robot.column >= parkMap[0].length) {
                    possible = false;
                    break;
                }

                if (parkMap[robot.row][robot.column] == 'X') {
                    possible = false;
                    break;
                }

                parkMap[tmpRow][tmpCol] = 'O';
                parkMap[robot.row][robot.column] = 'S';

            }
            if (!possible) {
                robot.setRow(tmpRow);
                robot.setColumn(tmpCol);
            }
        }

        answer[0] = robot.row;
        answer[1] = robot.column;

        return answer;
    }
}
