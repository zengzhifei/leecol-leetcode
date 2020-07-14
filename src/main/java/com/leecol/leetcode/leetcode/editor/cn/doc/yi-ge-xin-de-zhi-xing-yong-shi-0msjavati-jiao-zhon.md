### 解题思路
先用二分法缩小查找范围,缩小范围原理为拆分成的两个数中的较大者不应该大于target-min(numbers)。比如numbers=[2,7,11,23],target=10,只需在[2,7]范围查找即可,因为11>10-2=8，若一个数大于10-2=8，则构造出的数总大于target=10;再比如,numbers=[-2,7,12,23],target=10,只需在[-2,7,12]范围查找即可,因为23>10-(-2)=12。然后再利用双指针在缩小的范围内遍历一次数组获得结果!时间复杂度介于O(lgn)到O(n)之间。

### 结果
执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗 :39.9 MB, 在所有 Java 提交中击败了6.67%的用户
 [无标题.png](https://pic.leetcode-cn.com/51bb24aa1096d6ff2f906a8b8dda5f315e81cb95d8b560f4ef12a78c7ddfed6f-%E6%97%A0%E6%A0%87%E9%A2%98.png)

### 代码

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2 || target < numbers[0] + numbers[1] || target > numbers[numbers.length - 2] + numbers[numbers.length - 1]){
            return null;
        }
        /*缩小查找范围,找到缩小范围的结束边界*/
        int mid = 0;
        if(target - numbers[0] >= numbers[numbers.length - 1]){
            mid = numbers.length - 1;
        }else{
            int i = 0,j = numbers.length - 1,temp = target - numbers[0];
            while(i <= j){
                mid = (i + j) / 2;
                if(numbers[mid] > temp){
                    j = mid - 1;
                } else if(numbers[mid] < temp){
                    i = mid + 1;
                } else break;
            }
            /*二分结束时mid可能指向第一个大于temp的数,也可能指向第一个小于temp的数*/
            if(numbers[mid] > temp){
                mid -= 1;
            }
        }
        /*在缩小的范围内用双指针遍历一次数组获得结果*/
        for(int i = 0, j = mid; i < j;){
            if(numbers[i] + numbers[j] > target){
                --j;
            } else if(numbers[i] + numbers[j] < target){
                ++i;
            } else{
                return new int[]{i +  1, j + 1};
            }
        }
        return null;
    }
}
```