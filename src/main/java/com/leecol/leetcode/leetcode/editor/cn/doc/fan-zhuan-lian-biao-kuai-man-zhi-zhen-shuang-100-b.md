### 回文问题
判断一个字符串或者一个数字是不是回文，是一个比较常规的问题。但是，判断一个链表是不是回文的，与字符串和数字有区别。

常规的思想是：使用两个指针，一个头指针，一个尾指针，判断两个指针所指的值是不是相等的，然后两边向中间缩短再进行比较。

在链表中，面临有如下的问题：
- 链表的长度是需要进行遍历整个链表才可以知道的
- 知道了链表的长度也没办法直接的使用双指针的方法进行比较，因为在链表中只可以知道当前节点的下一个节点，不能知道前一个节点，使用常规判断回文的方法行不通。



### 解决思想
由于无法知道节点的前一个节点，一个比较好想到的方法就是翻转链表，然后再去比较原链表与翻转后的链表。

翻转链表：
 [屏幕快照 2020-06-11 23.30.01.png](https://pic.leetcode-cn.com/9855a4dbcb091961bf390652e22d3521b9f40a146ae153a5864e0d8cf482c601-%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202020-06-11%2023.30.01.png)

但是直接的使用翻转链表会耗费空间去储存链表。

可以使用快慢指针，找到中间链表的中间位置mid，mid之前的节点进行翻转得到left链表，之后的节点保持不变得到right链表，在比较两个链表。

快慢指针(偶数)：
 [屏幕快照 2020-06-11 23.30.08.png](https://pic.leetcode-cn.com/3f1feec75c087d4630740e199a72b681b53af1191c6f48c3e4f37354f0985e36-%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202020-06-11%2023.30.08.png)
快慢指针(奇数)：

 [屏幕快照 2020-06-11 23.30.18.png](https://pic.leetcode-cn.com/e9fffbda29097722c7ec6cecb13e8d5e2073801561a20045092dea8fb368ddc6-%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202020-06-11%2023.30.18.png)




### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 使用快慢指针，慢指针在进行操作的时候，顺带的进行链表的翻转，在进行半个链表之间的比较

        
        if(head == null){
            return true;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        ListNode prev = null;

        // 使用快慢指针找到链表的中间位置，并翻转慢指针前的链表
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            // 链表翻转
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode rigth;
        if(fast != null){
            // 不为空，表示链表size为偶数
            // 0 -> 1 -> 2 -> 3, prev指向1，slow指向2，要比较prev与right，先确定位置1与2的val是不是一样的
            if(slow.val != slow.next.val){
                return false;
            }
            // rigth从3开始
            rigth = slow.next.next;
        }
        else{
            // 为空，表示链表size为奇数
            // 0 -> 1 -> 2 -> 3 -> 4, prev指向1，slow指向2
            // rigth从3开始
            rigth = slow.next;
        }
        // 比较两个链表
        while(prev != null && rigth != null){
            if(prev.val != rigth.val){
                return false;
            }
            prev = prev.next;
            rigth = rigth.next;
        }
        return true;


    }
}
```