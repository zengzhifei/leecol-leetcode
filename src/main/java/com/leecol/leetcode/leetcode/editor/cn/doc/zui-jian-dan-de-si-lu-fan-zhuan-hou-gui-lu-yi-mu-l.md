### 解题思路
把原数表示翻转，可以看出后一个数为前一个数的数字个数统计
例如：
7:    13112221
8:    1113213211
反转后：
7:    12221131
8:    1123123111
8重新数7: 1个1,3个2,2个1,1个3,1个1; 即11 23 12 31 11,翻转后为 11 13 21 32 11 为原数表示。
### 代码

```cpp
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//6.     312211
//7.     13112221
//8.     1113213211
//9.     31131211131221
//10.    13211311123113112211
//可以看出，只要翻转一下，后一个数就是前一个数的个数统计
//例如：
//5.     111221
//6.     312211
//翻转后：
//5.     122111
//6.     112213 ，即1个1,2个2,3个1
class Solution {
public:
	string countAndSay(int n) {
		if (n == 1) return "1";
		string ans = "";
		string pre = countAndSay(n - 1);
		reverse(pre.begin(), pre.end());
		int len = pre.size();
		int count = 1;
		for (int i = 1; i < len; i++) {
			if (pre[i] == pre[i - 1]) {
				count++;
			}
			else {
				ans = ans + pre[i - 1] + to_string(count);
				count = 1;
			}
		}
		ans = ans + pre[len - 1] + to_string(count);
		reverse(ans.begin(), ans.end());
		return ans;
	}
};
```