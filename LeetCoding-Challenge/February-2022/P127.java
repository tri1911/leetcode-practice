package leetcodingchallenge.february2022;

import java.util.*;

/**
 * Date: Feb 11, 2022
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/
 */

// TODO: check out the official solution if have time

public class P127 {
    // BFS approach
    // time: O(m * m * n)
    // space: O(m * n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size(), m = beginWord.length();
        // convert wordList into Hash Set for constant retrieval
        Set<String> wordSet = new HashSet<>(wordList);
        // corner case
        if (!wordSet.contains(endWord)) return 0;
        // queue for Breadth-First Search
        Deque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        // the visited map to avoid the cycle search (we don't need to mark the beginWord as visited because it will be met again anyway)
        Set<String> visited = new HashSet<>();
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            System.out.println("current step is " + steps);
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // examine the word in the head of queue
                String currentWord = queue.poll();
                System.out.println("current word is " + currentWord);
                if (currentWord.equals(endWord)) return steps;
                char[] charArr = currentWord.toCharArray();
                // find the next word that is different from the current word only one letter
                // there are 2 approaches I think of
                // 1. iterate through entire list - takes O(n * n)
                // 2. replace each character in the word with 25 other possible lowercase letters - takes O(26 * m * m) = O(m * m)
                // cause m < n, I chose the second approach
                for (int j = 0; j < m; j++) {
                    char original = charArr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != original) {
                            charArr[j] = ch;
                            // takes O(m)
                            String nextWord = new String(charArr);
                            System.out.println("next word is " + nextWord);
                            if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                                System.out.println("found " + nextWord + " in the word list");
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    charArr[j] = original;
                }
            }
            System.out.println("---------");
        }
        return 0;
    }

    public static void main(String[] args) {
        P127 obj = new P127();
        System.out.println("Expected: 0. Received: " + obj.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "tog", "cog"})));
    }
}

/**
 * reference
 * https://leetcode.com/problems/word-ladder/discuss/1764371/A-very-highly-detailed-EXPLANATION
 */