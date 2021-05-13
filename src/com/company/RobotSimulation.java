package com.company;

import java.util.HashSet;
import java.util.Set;

public class RobotSimulation {

	public static void main(String[] args) {

		System.out.println(robotSim(new int[]{4,-1,3}, new int[][]{}));
	}

	public static int robotSim(int[] commands, int[][] obstacles) {
		Set<String> obstacleSet = new HashSet<>();

		for (int[] o : obstacles)
			obstacleSet.add(o[0] + "," + o[1]);

		int max = 0;
		int x = 0;
		int y = 0;
		int dir = 0;
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


		//  W
		// S N
		//  E
		//TODO
		// {{0, 1}, 0 NORTH
		// {1, 0}, 1 EAST
		// {0, -1}, 2 SOUTH
		// {-1, 0}}; 3 WEST

		for (int command : commands)
			if (command == -2){
				dir = dir == 0
						? 3
						: dir - 1;
			}
			else if (command == -1){
				dir = dir == 3
						? 0
						: dir + 1;
			}
			else {
				int[] xy = dirs[dir];
				while (command-- > 0 && !obstacleSet.contains((x + xy[0]) + "," + (y + xy[1]))) {
					x += xy[0];
					y += xy[1];
				}
				max = Math.max(max, x * x + y * y);
			}
		return max;
	}
}
