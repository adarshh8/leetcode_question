/*
// Definition for a Node.
class Node {
public:
    int val; // Store the value of the node
    Node* prev; // Pointer to the previous node
    Node* next; // Pointer to the next node
    Node* child; // Pointer to the child list
};
*/

class Solution { // Define the Solution class
public: // Public access specifier

    Node* flatten(Node* head) { // Function to flatten the multilevel doubly linked list

        if (head == nullptr) return head; // Return if the list is empty

        stack<Node*> st; // Create a stack to store next nodes
        Node* curr = head; // Initialize current pointer

        while (curr != nullptr) { // Traverse the linked list

            if (curr->child != nullptr) { // Check if the current node has a child

                if (curr->next != nullptr) st.push(curr->next); // Save the next node for later

                curr->next = curr->child; // Connect current node to its child
                curr->child->prev = curr; // Update the previous pointer of the child
                curr->child = nullptr; // Remove the child pointer
            }

            if (curr->next == nullptr && !st.empty()) { // Check if end of current level is reached

                Node* temp = st.top(); // Get the stored next node
                st.pop(); // Remove it from the stack

                curr->next = temp; // Connect the current node to the stored node
                temp->prev = curr; // Update the previous pointer
            }

            curr = curr->next; // Move to the next node
        }

        return head; // Return the flattened list
    }
};