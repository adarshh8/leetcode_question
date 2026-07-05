class Solution { // Define the Solution class
public: // Public access specifier

    int peakIndexInMountainArray(vector<int>& arr) { // Function to find the peak index

        int low = 0; // Initialize the starting index
        int high = arr.size() - 1; // Initialize the ending index

        while (low < high) { // Perform binary search until both pointers meet

            int mid = low + (high - low) / 2; // Calculate the middle index

            if (arr[mid] < arr[mid + 1]) { // Check if we are on the increasing slope
                low = mid + 1; // Peak lies on the right side
            }
            else { // We are on the decreasing slope or at the peak
                high = mid; // Peak lies at mid or on the left side
            }
        }

        return low; // Return the index of the peak element
    }
};