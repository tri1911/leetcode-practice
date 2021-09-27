// 740. Delete and Earn
// You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
// Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
// Return the maximum number of points you can earn by applying the above operation some number of times.

// Example 1:
// Input: nums = [3,4,2]
// Output: 6
// Explanation: You can perform the following operations:
// - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
// - Delete 2 to earn 2 points. nums = [].
// You earn a total of 6 points.

// Example 2:
// Input: nums = [2,2,3,3,3,4]
// Output: 9
// Explanation: You can perform the following operations:
// - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
// - Delete a 3 again to earn 3 points. nums = [3].
// - Delete a 3 once more to earn 3 points. nums = [].
// You earn a total of 9 points.

// Failed Test Case:
// [883,183,6,920,688,139,129,547,439,97,832,746,688,661,843,603,437,431,534,219,195,699,606,127,928,289,800,712,914,8,938,86,471,285,969,575,251,68,114,933,800,223,673,556,160,970,188,482,312,891,258,602,767,872,887,314,682,148,954,871,440,851,17,846,195,324,669,73,219,545,150,2,527,926,430,180,945,297,50,808,780,974,351,214,449,357,179,188,506,704,583,8,44,324,523,757,135,312,898,598,379,898,935,167,116,412,579,901,321,89,949,664,864,435,418,864,103,313,213,778,161,229,274,870,696,269,391,83,437,824,110,198,230,395,703,115,408,697,732,269,670,619,201,324,740,608,881,66,475,218,657,535,303,513,959,361,755,788,56,67,634,463,167,364,312,382,122,587,92,939,558,136,439,874,282,294,74,623,109,569,15,421,94,987,382,154,41,336,857,604,473,866,380,965,720,413,900,34,54,211,808,228,230,897,417,401,590,923,390,558,97,371,231,60,152,726,236,828,708,396,750,244,904,886,410,923,923,38,192,136,882,199,503,985,885,890,66,864,918,688,337,361,573,686,280,691,650,399,504,202,687,960,703,937,219,75,585,510,753,270,272,766,600,686,985,526,496,35,395,530,553,286,307,414,852,662,78,75,194,782,152,446,849,298,99,740,259,588,546,476,875,450,161,190,153,722,123,567,707,21,772,89,75,296,653,265,101,988,722,9,650,690,670,847,101,80,991,83,674,391,756,369,273,576,756,31,5,248,633,560,514,697,398,296,880,145,234,139,857,422,17,230,885,7,79,621,641,738,192,130,693,371,146,268,645,554,372,231,132,306,711,122,536,556,164,454,220,14,272,665,299,98,256,188,484,862,232,942,363,635,916,557,450,788,396,327,143,121,206,779,129,645,271,902,790,872,859,354,675,563,390,819,559,963,44,294,943,407,890,296,80,450,841,487,689,563,281,794,916,946,204,529,132,563,355,877,706,302,382,821,187,876,820,322,503,773,800,492,238,987,567,244,421,330,400,877,114,880,345,836,997,333,998,83,47,884,236,784,116,122,327,424,248,216,629,729,388,371,345,8,300,735,763,848,217,486,462,25,935,822,437,431,260,585,766,307,71,819,846,148,878,658,173,293,869,835,374,617,555,874,349,4,912,348,644,680,518,176,203,730,570,979,29,755,244,562,494,333,841,199,104,193,665,482,42,777,878,72,876,185,423,24,902,828,775,14,831,430,166,442,986,325,784,362,745,625,441,371,187,490,922,629,393,799,726,264,378,812,273,886,732,245,567,358,353,525,44,774,785,471,200,303,525,574,798,549,674,255,994,726,922,802,193,870,638,772,400,634,98,53,715,802,864,955,848,73,747,348,111,493,252,82,63,974,607,964,404,754,140,143,670,511,695,762,986,598,836,719,798,953,271,85,422,374,61,115,635,87,440,249,743,627,574,549,911,748,901,425,914,170,426,903,910,278,367,295,417,38,752,640,38,768,420,871,190,551,449,67,445,65,472,990,921,679,534,154,402,403,32,151,278,255,653,852,386,384,448,839,260,538,817,743,972,988,234,523,113,375,141,422,213,986,993,183,785,61,469,573,736,966,178,721,293,787,259,210,488,19,550,397,851,262,301,42,999,4,412,403,29,688,963,839,859,956,623,188,126,451,881,517,550,976,983,479,45,898,890,978,593,131,832,43,362,813,775,986,605,941,95,775,27,955,32,126,384,70,901,138,393,186,40,510,939,494,424,76,128,550,830,500,696,862,205,189,692,386,993,606,32,287,169,937,629,900,805,823,450,921,74,884,794,259,890,103,694,953,603,901,303,414,981,841,105,87,277,249,906,798,906,351,926,956,789,485,738,231,679,127,622,857,415,504,286,96,732,910,964,597,711,830,614,156,254,135,415,102,800,638,677,585,490,404,888,672,21,514,533,886,346,725,483,211,719,421,946,833,769,635,191,936,285,533,941,422,933,651,793,229,197,599,795,412,788,50,784,278,865,232,529,919,394,857,614,458,113,547,226,676,128,734,203,711,175,256,547,517,392,713,397,266,595,183,921,29,767,995,318,540,96,143,650,562,777,525,942,997,174,890,156,420,92,144,134,981,934,590,859,165,456,861,325,957,308,963,490,630,693,385,82,412,396,80,318,103,625,109,833,331,335,508,127,315,391,558,238,717,46,504,608,254,481,463,504,630,443,741,921,838,41,986,880,29,512,650,546,227,136,746,120,573,655,34,320,427,447,648,675,969,995,763,448,447,538,572,5,814,485,477,798,515]
// Output: 343352
 
// Constraints:
// 1 <= nums.length <= 2 * 10^4
// 1 <= nums[i] <= 10^4

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// #define SIZE 10000

// memoization solution
// helper function
// calculates the maximum sum of values at non-adjacent indices
// int solve(const vector<int>& hash, int last, vector<int>& memo) {
// 	if (last < 1)
// 		return 0;
// 	if (memo[last] != -1) {
// 		return memo[last];
// 	}
// 	if (last == 1) {
// 		memo[last] = hash[1];
// 		return memo[last];
// 	}
// 	int first = hash[last] + solve(hash, last - 2, memo);
// 	int second = hash[last - 1] + solve(hash, last - 3, memo);
// 	memo[last] = max(first, second);
// 	return memo[last];
// }

// int deleteAndEarn(vector<int>& nums) {
// 	// hash table takes O(n)
// 	// contains the total value of a specific value in nums
// 	// e.g. 3, 3, 3 => Stores 9
// 	vector<int> hash(SIZE + 1, 0);
// 	// save values into the hash table
// 	for (int i = 0; i < nums.size(); i++) {
// 		int code = nums[i] % SIZE; // or just the value of nums[i] itself, because its value never greater than SIZE
// 		hash[code] += nums[i];
// 	}
// 	// memoization
// 	vector<int> memo(SIZE + 1, -1);
// 	return solve(hash, SIZE, memo);
// }

// dynamic programing solution
// int deleteAndEarn(vector<int>& nums) {
// 	// hash table
// 	vector<int> hash(SIZE + 1, 0);
// 	// fill values
// 	for (int i = 0; i < nums.size(); i++) {
// 		int code = nums[i] % SIZE;
// 		hash[code] += nums[i];
// 	}

// 	int first = hash[1];
// 	int second = max(hash[1], hash[2]);
// 	int result;
// 	for (int i = 3; i <= SIZE; i++) {
// 		result = max(first + hash[i], second);
// 		first = second;
// 		second = result;
// 	}
// 	return result;
// }

// dynamic programing solution
int deleteAndEarn(vector<int> &nums) {
    // find maximum value
    int largest = nums[0];
    for (int i = 1; i < nums.size(); i++) {
        if (largest < nums[i])
            largest = nums[i];
    }
    // hash table
    vector<int> sums(largest + 1, 0);
    // fill values
    for (int i = 0; i < nums.size(); i++) {
        sums[nums[i]] += nums[i];
    }
    // solve
    int first = 0;
    int second = 0;
    int result;
    for (int i = 1; i <= largest; i++) {
        result = max(first + sums[i], second);
        first = second;
        second = result;
    }
    return result;
}

int main() {
	vector<int> nums { 2, 2, 3, 3, 3, 4 };
	cout << "Output: " << deleteAndEarn(nums) << endl;
	return 0;
}