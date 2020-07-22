思路和剑指Offer59-2基本完全一致。
这里仅仅对涉及到的知识点进行复习：

**ArrayList是顺序结构，所以定位很快，但插入，删除数据慢。
LinkedList 是链表结构，定位慢，但插入，删除数据快。**

**ArrayList实现了List接口，常见方法有：**
add(); contains(); get(); indexOf():定位对象所处的位置; remove(); size(); toArray(); toString();//转换为字符串 

**LinkedList也实现了List接口外，可以实现上述ArrayList中的常用方法，此外：**
**1.LinkedList还实现了双向链表结构Deque，可以很方便的在头尾插入删除数据。** 
LinkedList<class> link = new LinkedList<>();
常用方法：addFirst(); addLast(); getFirst(); getLast(); removeFirst(); removeLast();

**2.LinkedList除了实现了List和Deque外，还实现了Queue接口(队列),Queue是先进先出队列 FIFO。**
Queue<class> queue = new LinkedList<>();
常用方法：poll()取出第一个元素; peek()查看第一个元素; offer()在最后添加元素,可用add()替换;

**先进后出FILO Stack栈**：
Stack<class> stack = new Stack<>(); 
常用方法：push();可用add();代替    pop();输出末尾的元素相当于LinkedList中的removeLast(); peek();查看最后一个元素，相当于getLast();

本题具体的Java代码如下：
```
public class MaxQueue {

    Queue<Integer> queue;
    LinkedList<Integer> max;
    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();//LinkedList是双端链表
    }
    
    public int max_value() {
        return max.size()==0?-1:max.getFirst();
    }
    
    public void push_back(int value) {
        queue.add(value);
        while(max.size()!=0&&max.getLast()<value){//注意：这里第二个判断条件不能带等号，即max中对于当前queue中的具有相同值的元素会全部存储，而不是存储最近的那个。
            max.removeLast();
        }
        max.add(value);
    }
    
    public int pop_front() {
        if(max.size()!=0&&queue.peek().equals(max.getFirst()))//Integer类型的值的比较不能直接使用==
            max.removeFirst();
        return queue.size()==0?-1:queue.poll();
    }
    
    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */
}
```

