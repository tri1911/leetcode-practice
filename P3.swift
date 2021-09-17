// Solution 1

func lengthOfLongestSubstring(_ s: String) -> Int {
    // the pointer to the start of sliding window
    var start = s.startIndex
    // the length of the longest non-repeating substring
    var result = 0
    // the dictionary to save the latest position of characters in the current window
    var lastIndices = [Character: String.Index]()
    
    for end in s.indices {
        print("----New Iteration----")
        // current checking character
        let character = s[end]
        print("Checking \(character)")
        
        // if the character already has been seen
        if let lastIndex = lastIndices[character] {
            // update the start pointer
            // i.e. abcacb, when iterating to the last b, last index of b is 1
            // but start is at 3, so we don't care it
            start = max(start, s.index(lastIndex, offsetBy: 1))
            print("start is updated to \(s.distance(from: s.startIndex, to: start))")
        }
        // update the position of current checking character
        lastIndices[character] = end
        // update the result
        print("Current substring: \(s[start...end])")
        let currentLength = s.distance(from: start, to: end) + 1
        result = max(result, currentLength)
    }
    return result
}

// Solution 2


func lengthOfLongestSubstring(_ s: String) -> Int {
    // the start index of the sliding window
    var start = 0
    // the length of the longest non-repeating substring
    var result = 0
    // the dictionary to save the latest position of characters in the current window
    var lastIndices = [Character: Int]()
    
    for end in 0..<s.count {
        print("---------------New Iteration---------------")
        // current checking character
        let character = s[end]
        print("Checking \(character)...")

        // looking the last position of the character if it has been seen before
        if let lastIndex = lastIndices[character] {
            // update the start pointer if necessary
            // i.e. abcacb, when iterating the end (character b), the saved index is 1
            // but the start index is 3, so we don't care
            start = max(start, lastIndex + 1)
            print("start is updated to \(start)")
        }
        
        // update the position of current checking character
        lastIndices[character] = end
        // update the result
        let currentLength = (end - start) + 1
        result = max(result, currentLength)
    }
    return result
}

extension String {
    subscript(_ indexAsInt: Int) -> Character {
        let index = self.index(self.startIndex, offsetBy: indexAsInt)
        return self[index]
    }
}