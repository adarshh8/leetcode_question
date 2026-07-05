class Solution { // Define the Solution class
public: // Public access specifier

    int findDuplicate(vector<int>& nums) { // Function to find the duplicate number

        int slow = nums[0]; // Initialize slow pointer with the first element
        int fast = nums[0]; // Initialize fast pointer with the first element

        while (true) { // Run until slow and fast pointers meet
            slow = nums[slow]; // Move slow pointer one step
            fast = nums[nums[fast]]; // Move fast pointer two steps

            if (slow == fast) { // Check if both pointers meet
                break; // Exit the loop when a cycle is detected
            }
        }

        int slow2 = nums[0]; // Initialize another pointer from the beginning

        while (slow != slow2) { // Move both pointers until they meet
            slow = nums[slow]; // Move first pointer one step
            slow2 = nums[slow2]; // Move second pointer one step
        }

        return slow; // Return the duplicate number (cycle entry point)
    }
};