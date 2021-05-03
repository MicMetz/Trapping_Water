package com.company;

import java.util.Stack;

public class Solution {
	int            Units;                       // Variable to keep record of the units of trapped water on the map
	int            n;                           // The length of the map
	Stack<Integer> barStack = new Stack<>();    // Container to help in processing unit index positions



	public int trap(int[] height) {
		n = height.length;
		Units = 0;

		/*
		 * If there is only 2 positions on the map to analyze,
		 * there is 0 area units in which water can accumulate.
		 * So, return 0. */
		if (n > 2) {
			for (int x = 0; x < n; x++) {
				// If there is a height of the current index position is greater than the last & there is another position on stack to reference,
				while (!barStack.empty() && height[x] > height[barStack.peek()]) {
					int dipPosition = barStack.pop();                            // The position of the dip in elevation
					int rightBound;                                              // The position of the right boundry before the dip
					int leftBound;                                               // The position of the left boundry before the dip
					int distance;                                                // The Distance between the two boundries
					int depth;                                                   // The elevation of the crevasse between both boundries

					/*
					 *If we haven't explored enough positions in order to properly analyze the differences in depth between two boundries,
					 * break and store the index position.
					 */
					if (barStack.empty()) { break; }
					else {
						rightBound = x;
						leftBound = barStack.peek();
						distance = rightBound - leftBound - 1;

						/*
						 *By first finding the lesser height of the two boundries,
						 * we can't determine the difference in height between the dip and the shortest wall,
						 * therefore, we can determine the units of water that can possibly accumulate inbetween.
						 */
						depth = Math.min(height[rightBound], height[leftBound]) - height[dipPosition];

						Units += distance * depth;                              // Add the units of water that can be trapped to the total for the elevation map.
					}
				}
				// Otherwise store the region's index position to references later.
				barStack.push(x);
			}

		}
		return Units;
	}
}
