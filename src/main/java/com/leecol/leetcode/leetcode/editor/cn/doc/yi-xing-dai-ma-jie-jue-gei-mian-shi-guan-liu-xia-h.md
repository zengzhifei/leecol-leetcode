### 解题思路
解题思路我就不说了，大家都讲的太了，最终的优化在此

### 代码

```java
class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
```