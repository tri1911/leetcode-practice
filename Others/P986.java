// Date: Nov 27, 2021
// 986. Interval List Intersections (https://leetcode.com/problems/interval-list-intersections/)

// time complexity: O(m + n) where m, n are the number of intervals in 2 lists respectively
// space complexity: O(1) 
public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
	int p1 = 0, p2 = 0;
	List<int[]> ans = new ArrayList<>();
    while (p1 < firstList.length && p2 < secondList.length) {
    	int[] result = new int[2];
    	result[0] = Math.max(firstList[p1][0], secondList[p2][0]);
    	result[1] = Math.min(firstList[p1][1], secondList[p2][1]);

    	if (result[0] <= result[1])
    		ans.add(result);

    	if (firstList[p1][1] < secondList[p2][1])
    		p1++;
    	else
    		p2++;
    }
    return ans.toArray(new int[ans.size()][]);
}

// Failed test cases:
// [[0,2],[5,10],[13,23],[24,25]]
// [[1,5],[8,12],[15,24],[25,26]]
// Ouput: [[1,2],[5,5],[8,10],[13,12],[15,23],[24,24],[25,25]] => Should not have [13, 12]

// [[13,23],[24,25]]
// [[10,12],[15,24],[25,26]]
// start = max(start1, start2)
// end = min(end1, end2)
// [1,2], [5,5], [8, 10]...


// reference:
// https://stackoverflow.com/questions/2843366/how-to-add-new-elements-to-an-array
// https://leetcode.com/discuss/general-discussion/910108/java-converting-2d-list-into-array