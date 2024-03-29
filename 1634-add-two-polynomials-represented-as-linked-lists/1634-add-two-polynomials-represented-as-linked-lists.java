/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        if (poly1 == null) return poly2;
        if (poly2 == null) return poly1;
        
        PolyNode dummy = new PolyNode();
        PolyNode curr = dummy;
        
        while (poly1 != null && poly2 != null) {
            if (poly1.power > poly2.power) {
                curr.next = poly1;
                poly1 = poly1.next;
                curr = curr.next;
            } else if (poly1.power < poly2.power) {
                curr.next = poly2;
                poly2 = poly2.next;
                curr = curr.next;
            } else {
                int sum = poly1.coefficient + poly2.coefficient;
                poly1.coefficient = sum;
                if (sum != 0) curr.next = poly1;
                poly1 = poly1.next;
                poly2 = poly2.next;
                if (sum != 0) curr = curr.next;
                if (sum == 0 && poly1 == null && poly2 == null) curr.next = null;
            }
        }
        
        if (poly1 != null) curr.next = poly1;
        if (poly2 != null) curr.next = poly2;
        
        return dummy.next;
    }
}