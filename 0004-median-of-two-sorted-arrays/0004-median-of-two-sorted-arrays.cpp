class Solution { // Define the Solution class
public: // Public access specifier

    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) { // Function to find the median

        if (nums1.size() > nums2.size()) // Ensure nums1 is the smaller array
            return findMedianSortedArrays(nums2, nums1); // Swap the arrays if needed

        int n1 = nums1.size(); // Size of first array
        int n2 = nums2.size(); // Size of second array

        int low = 0; // Binary search starting index
        int high = n1; // Binary search ending index

        while (low <= high) { // Perform binary search

            int cut1 = (low + high) / 2; // Partition index for first array
            int cut2 = (n1 + n2 + 1) / 2 - cut1; // Partition index for second array

            int left1 = (cut1 == 0) ? INT_MIN : nums1[cut1 - 1]; // Left element of first array
            int left2 = (cut2 == 0) ? INT_MIN : nums2[cut2 - 1]; // Left element of second array

            int right1 = (cut1 == n1) ? INT_MAX : nums1[cut1]; // Right element of first array
            int right2 = (cut2 == n2) ? INT_MAX : nums2[cut2]; // Right element of second array

            if (left1 <= right2 && left2 <= right1) { // Check if correct partition is found

                if ((n1 + n2) % 2 == 0) // If total number of elements is even
                    return (max(left1, left2) + min(right1, right2)) / 2.0; // Return average of middle two elements

                return max(left1, left2); // Return middle element for odd length
            }

            else if (left1 > right2) // Move towards left in first array
                high = cut1 - 1; // Update high

            else // Move towards right in first array
                low = cut1 + 1; // Update low
        }

        return 0.0; // Dummy return (will never be reached)
    }
};