### 学习笔记
** 前后写了20几道DP之后，终于发现方法了** 

> 问题一般思路：求最值，然后有最优子结构的，就用数学归纳法

1. 从最后开始推导
2. 明确f(i)有哪些状态，分别全部列出来，如果只有一种，那么一维dp数组，否则就二维
3. 比如f(i)有三种状态如下
* dp[i][0] 状态一
* dp[i][1] 状态二
* dp[i][2] 状态三
> 以dp[i][0]为例，那么就看dp[i-1][0]、dp[i-1][1]、dp[i-1][2]这些上一步的状态能不能转，怎么转成dp[i][0]，把场景全覆盖了，然后dp[i][1]、dp[i][2]同理
4. 上面转移方程就出来了，用了上面的套路之后，转移方程就非常容易推导了，主要思想是分而治之
5. 结果是什么？可能是dp[length-1][0]、dp[length-1][1]、dp[length-1][2]三个的最大或者最小值，很简单
6. 那么就差一个base case了，base case是在太简单了，一般都是dp[0][0]、dp[0][1]、dp[0][2]分别对应source数据的初始情况。
7.最后就根据上面的描述，把代码翻译出来就好了，场景全覆盖了