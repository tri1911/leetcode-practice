package leetcodingchallenge.january2022;

// Date: Jan 9, 2022
// 1041. Robot Bounded In Circle
// https://leetcode.com/problems/robot-bounded-in-circle/

// TODO: check out better implementation?

public class P1041 {
    // time complexity: O(n)
    // space complexity: O(1)
    public boolean isRobotBounded(String instructions) {
        int[] position = {0, 0};
        int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int current = 0;
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L':
                    current = (current + 1) % 4;
                    break;
                case 'R':
                    current = (current + 4 - 1) % 4;
                    break;
                default:
                    position[0] += directions[current][0];
                    position[1] += directions[current][1];
            }
//            System.out.print("Current position: (" + position[0] + ", " + position[1] + ")");
//            System.out.println(" & direction: " + current);
        }
        // stays in circle if and only if
        // moves 0 OR changes direction
        return (position[0] == 0 && position[1] == 0) || (current != 0);
    }

    public static void main(String[] args) {
        P1041 obj = new P1041();
        System.out.println("Expected: true. Received: " + obj.isRobotBounded("GGLLGG"));
        System.out.println("---");
        System.out.println("Expected: false. Received: " + obj.isRobotBounded("GG"));
        System.out.println("---");
        System.out.println("Expected: true. Received: " + obj.isRobotBounded("GL"));
        System.out.println("---");
        System.out.println("Expected: true. Received: " + obj.isRobotBounded("GLRLGLLGLGRGLGL"));
    }
}
