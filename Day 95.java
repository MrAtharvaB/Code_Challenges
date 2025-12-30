class Solution {

    private Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    private Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0 && head.next != null) {
            head = head.next;
        }
        return head;
    }

    public Node addTwoLists(Node head1, Node head2) {
        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);

        head1 = reverse(head1);
        head2 = reverse(head2);

        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            carry = sum / 10;
            tail.next = new Node(sum % 10);
            tail = tail.next;
        }

        Node result = reverse(dummy.next);
        result = removeLeadingZeros(result);

        return result;
    }
}
