package com.algorithm.findMedianSortedArrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 先判空的情况
         */
        int n = nums1.length;
        int m = nums2.length;
        if (n == 0 && m == 0) {
            return 0.0d;
        }
        if (n == 0) {
            return findSingleMedian(nums2);
        }
        if (m == 0) {
            return findSingleMedian(nums1);
        }


        /**
         * 半数组大小的判定
         */
        int s = n + m;

        //是否是奇数
        boolean isOddNumber = false;

        if (s % 2 != 0) {
            isOddNumber = true;

        }
        //排序到哪个位置
        int  p = s / 2;


        /**
         * 两数组各设置一个开始位置的指针，逐一比较把较小的放入半数组
         */
        int[] halfNums = new int[p + 1];

        int i = 0, j = 0, k = 0;
        for (; i < n && j < m && k < p + 1; k++) {
            if (nums1[i] <= nums2[j]) {
                halfNums[k] = nums1[i];
                i++;
            } else {
                halfNums[k] = nums2[j];
                j++;
            }
        }

        /**
         * 如果其中一个没有数了，半数组却未满，在剩余一个数组中截取半数组需要个数的数放入半数组
         */
        //回退到k的赋值位置
        k--;

        //如果半数组没有赋值到最后一位
        if (k < p) {
            //如果是因为nums2用完了
            if (j == m) {
                for (int l = k + 1; l < p + 1; l++, i++) {
                    halfNums[l] = nums1[i];
                }
            } else {
                for (int l = k + 1; l < p + 1; l++, j++) {
                    halfNums[l] = nums2[j];
                }
            }
        }

        if (isOddNumber) {
            return halfNums[p];
        } else {

            return (halfNums[p] + halfNums[p - 1]) / 2;
        }
    }

    public double findSingleMedian(int[] nums) {
        int p = nums.length / 2;

        if (nums.length % 2 != 0) {
            return nums[p];
        } else {
            return (nums[p] + nums[p - 1]) / 2;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}));

    }

}
