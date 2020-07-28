### 解题思路
见代码注释

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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode tmp = head;//用来遍历的节点
        while(tmp.next != null){//因为我们是对下一个节点执行判断和删除操作，所以下一个节点不能为null
            if(tmp.next.val == val)//如果下一个节点值等于val
                tmp.next = tmp.next.next;//修改指针，执行删除操作
            else tmp = tmp.next;//否则，正常遍历
        }
        return head.val == val ? head.next : head;//因为while循环没有判断头结点，所以这里还需要判断一下
    }
}
```