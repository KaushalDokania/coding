package Platforms.LeetCode.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Temp2 {

    static  class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<Set<Integer>> setofSets = new HashSet<>();
            List<List<Integer>> list = new ArrayList<>();
            
            for (int i=0; i<nums.length; ++i) {
                int target = -nums[i];                       // a + b = -c
                HashSet<Integer> set = new HashSet<>();
                for (int j=0; j<nums.length && j!=i; ++j) {
                    if (set.contains(target - nums[j]))
                        setofSets.add(new HashSet<>(Arrays.asList(nums[j], -target, target-nums[j])));
                    set.add(nums[j]);
                }
            }
            for (Set<Integer> s: setofSets) {
                list.add(new ArrayList<>(Arrays.asList(s.toArray())));
                list.addAll(Arrays.asList(s.toArray()));
            }
            
            return list;
        }
    }

    

    public static void main(String[] args) {
        int arr[] = {1,3,3,1,3,1,3,2,3,2,3,2,1,2,1};
        // int arr[] = {4,2,1,3};
        ListNode head=null, node=null;

        for (Integer n: arr) {
            if (head == null) {
                node = head = new ListNode(n);
                continue;
            }
            node.next = new ListNode(n);
            node = node.next;
        }
        
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(1);
        // head.next.next.next = new ListNode(3);
        new Solution().printList(head);
        head = new Solution().sortList(head);
        System.out.println();
        new Solution().printList(head);
        Set<Set<Integer>> set = new HashSet<>();
        
    }
}
