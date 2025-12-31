class Solution {
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = reverse(slow);

        Node first = head;
        Node tempSecond = second;
        while (tempSecond != null) {
            if (first.data != tempSecond.data) {
                return false;
            }
            first = first.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    private Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
