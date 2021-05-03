package com.company;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main {

	public static void main(String[] args) {
		Solution elevation_Map1 = new Solution();
		Solution elevation_Map2 = new Solution();
		Solution elevation_Map3 = new Solution();
		int[]    height1        = new int[]{4, 2, 0, 3, 2, 5};
		int[]    height2        = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int[]    height3        = new int[]{4, 0, 2};
		int[]    height4        = new int[]{0, 1};

		int result1 = elevation_Map1.trap(height1);
		int result2 = elevation_Map2.trap(height2);
		int result3 = elevation_Map3.trap(height3);
		int result4 = elevation_Map3.trap(height4);

		System.out.println("Output 1: " + result1);
		System.out.println("Output 2: " + result2);
		System.out.println("Output 3: " + result3);
		System.out.println("Output 4: " + result4);

	}
}

