class Solution { // Define the Solution class
public: // Public access specifier

    int singleNonDuplicate(vector<int>& nums) { // Function to find the single non-duplicate element

        int low = 0; // Initialize the starting index
        int high = nums.size() - 1; // Initialize the ending index

        while (low < high) { // Perform binary search

            int mid = low + (high - low) / 2; // Calculate the middle index

            if (mid % 2 == 1) // Check if mid is odd
                mid--; // Make mid even so it points to the first element of a pair

            if (nums[mid] == nums[mid + 1]) // Check if the pair at mid is valid
                low = mid + 2; // Single element lies on the right side
            else // Pair is broken
                high = mid; // Single element lies on the left side including mid
        }

        return nums[low]; // Return the single non-duplicate element
    }
};