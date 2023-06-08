Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Constraints:

* 3 <= nums.length <= 3000
* -105 <= nums[i] <= 105




1. 使用什么方法解决这个问题？

            先确定一个前导指针，即划定边界，如0位置，则剩余两指针只能在1~n-1范围内移动，且两指针不重合。
2. 前导指针如何移动？

            从0开始逐个往后移动，如果遇到得数和上一个数相同则跳过，因为the solution set must not contain duplicate triplets。
3. 剩余两指针如何移动？

            如果和小于0，则左指针往右动，如果大于0右指针往左移动，如果等于0，两指针同时往中间移动。
4. 程序何时退出？

            前导指针在n-3的位置，进行最后一次求和计算并退出。