/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val; // Store the value of the node
 *     ListNode *next; // Pointer to the next node
 *     ListNode() : val(0), next(nullptr) {} // Default constructor
 *     ListNode(int x) : val(x), next(nullptr) {} // Constructor with value
 *     ListNode(int x, ListNode *next) : val(x), next(next) {} // Constructor with value and next pointer
 * };
 */

class Solution { // Define the Solution class
public: // Public access specifier

    ListNode* reverse(ListNode* head) { // Function to reverse a linked list

        ListNode* prev = nullptr; // Initialize previous pointer
        ListNode* curr = head; // Initialize current pointer

        while (curr != nullptr) { // Traverse the linked list

            ListNode* nextNode = curr->next; // Store the next node
            curr->next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev one step forward
            curr = nextNode; // Move curr one step forward
        }

        return prev; // Return the new head of the reversed list
    }

    bool isPalindrome(ListNode* head) { // Function to check if the linked list is a palindrome

        if (head == nullptr || head->next == nullptr) // Check for empty or single-node list
            return true; // Such lists are always palindromes

        ListNode* slow = head; // Initialize slow pointer
        ListNode* fast = head; // Initialize fast pointer

        while (fast->next != nullptr && fast->next->next != nullptr) { // Find the middle of the list
            slow = slow->next; // Move slow one step
            fast = fast->next->next; // Move fast two steps
        }

        ListNode* secondHalf = reverse(slow->next); // Reverse the second half of the list

        ListNode* firstHalf = head; // Pointer for the first half
        ListNode* temp = secondHalf; // Pointer for the reversed second half

        while (temp != nullptr) { // Compare both halves

            if (firstHalf->val != temp->val) // Check if values are different
                return false; // Not a palindrome

            firstHalf = firstHalf->next; // Move first pointer
            temp = temp->next; // Move second pointer
        }

        return true; // The linked list is a palindrome
    }
};