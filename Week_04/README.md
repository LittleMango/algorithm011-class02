### 这周主要是BFS、DFS、贪心、二分

### BFS
0. 求最少转换次数、树的最小深度、用BFS
1. 如果没有特殊要求，那么一般是简单题，一个队列就好了
2. 如果是中等题，那么一般会加上一个按层遍历，那么就一次性拿出每一层所有元素进行记录就好了
3. 如果是一些数组字符串变换的，记得加个visited，visited用set，时间复杂度O(1)

### DFS
0. DFS更多作为一种手段，常跟回溯配合，或者递归本身就是DFS

### 贪心
0. 能用贪心的，都能用动态
1. 当数组按照单调递减排序，从头开始，每一个元素都是后面元素的整数倍的时候，就可以用贪心，否则就动态规划

### 二分
0. 旋转数组的，按照分段有序求解，num[left]、num[right]、target有多种情况，但其实只有两类操作，只要找出条件组合较少的那种做if，其它的做else就可以写少很多分支代码
```
if left <= mid:
	if target between left..mid:
		right = mid - 1
	else:
		left = mid + 1
else:
	if target between mid..right:
		left = mid + 1
	else: 
		right = mid - 1
```