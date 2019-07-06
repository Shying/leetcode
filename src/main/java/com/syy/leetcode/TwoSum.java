package com.syy.leetcode;

import java.util.*;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        int i = 0;
        int j = numsCopy.length - 1;
        boolean flag = false;
        while (j > i) {
            int sum = numsCopy[i] + numsCopy[j];
            if (sum == target) {
                flag = true;
                break;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        //        System.out.println(i + " " + numsCopy[i]);
        //        System.out.println(j + " " + numsCopy[j]);
        if (flag) {
            int iPos = 0;
            int jPos = 0;
            for (int x = 0; x < nums.length; x++) {
                if (nums[x] == numsCopy[i] && iPos == 0) {
                    iPos = x;
                }
                if (nums[x] == numsCopy[j] && x != iPos) {
                    jPos = x;
                }
            }

            return new int[] {iPos, jPos};
        }
        return null;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        List<List<Integer>> listResult = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return listResult;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return listResult;
        }
        int lastThirdNum = -1;
        for (int third = nums.length - 1; third >= 2; third--) {
            int thirdNum = nums[third];
            if (thirdNum == lastThirdNum) {
                continue;
            }
            int first = 0;
            int second = third - 1;
            while (second > first) {
                int sum = nums[first] + nums[second];
                if (sum == -thirdNum) {
                    result.put(nums[first] + "_" + nums[second] + "_" + thirdNum,
                            Arrays.asList(nums[first], nums[second], thirdNum));
                    while (second > first && nums[second] == nums[second - 1]) {
                        second--;
                    }
                    while (second > first && nums[first] == nums[first + 1]) {
                        first++;
                    }
                    second--;
                    first++;
                } else if (sum > -thirdNum) {
                    while (second > first && nums[second] == nums[second - 1]) {
                        second--;
                    }
                    second--;
                } else {
                    while (second > first && nums[first] == nums[first + 1]) {
                        first++;
                    }
                    first++;
                }
            }
        }

        Object[] resultValues = result.values().toArray();
        for (int i = 0; i < resultValues.length; i++) {
            listResult.add((List<Integer>) resultValues[i]);
        }
        return listResult;
    }



    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<String, List<Integer>> hashResult = new HashMap<String, List<Integer>>();
        if (nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int first = 0;
        int fourth = nums.length - 1;

        while (fourth - 2 > first) {

            int remain = target - (nums[fourth] + nums[first]);

            int second = first + 1;

            while (nums[second] + nums[second + 1] > remain) {
                fourth--;
                //                while(fourth > first + 2 && nums[fourth] == nums[fourth - 1]){
                //                    fourth--;
                //                }
                if (fourth <= first + 2) {
                    break;
                }
                remain = target - (nums[fourth] + nums[first]);
            }
            if (fourth <= first + 2) {
                fourth = nums.length - 1;
                first++;
                continue;
            }

            while (fourth > first + 2) {
                second = first + 1;
                int third = fourth - 1;
                remain = target - (nums[fourth] + nums[first]);
                while (third > second) {
                    int sum = nums[second] + nums[third];
                    if (sum == remain) {
                        hashResult.put(nums[first] + "_" + nums[second] + "_" + nums[third] + "_" + nums[fourth],
                                Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        while (third > second && nums[second] == nums[second + 1]) {
                            second++;
                        }
                        while (third > second && nums[third] == nums[third - 1]) {
                            third--;
                        }
                        second++;
                        third--;
                    } else if (sum < remain) {
                        while (third > second && nums[second] == nums[second + 1]) {
                            second++;
                        }
                        second++;
                    } else {
                        while (third > second && nums[third] == nums[third - 1]) {
                            third--;
                        }
                        third--;
                    }
                }
                fourth--;
            }

            fourth = nums.length - 1;
            first++;
        }

        Object[] resultValues = hashResult.values().toArray();
        for (int i = 0; i < resultValues.length; i++) {
            result.add((List<Integer>) resultValues[i]);
        }
        return result;

    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        //        sort
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        int aP = 0;

        Map<Integer, Integer> remainCount = new HashMap<Integer, Integer>();

        while (aP < A.length) {
            int dP = D.length - 1;

            while(dP >= 0){
                int bP = 0;
                int cP = C.length - 1;
                int remain = 0 - (A[aP] + D[dP]);
//                检查已经处理过的内容
                if(remainCount.containsKey(remain)){
//                    System.out.println("exist " + remain + " " + remainCount.get(remain));
                    result += remainCount.get(remain);
                    dP--;
                    continue;
                }
//                检查不可能存在答案的情况
                if(B[0] + C[0] > remain || B[B.length - 1] + C[C.length - 1] < remain){
                    dP--;
                    continue;
                }
                int totalFound = 0;
                while (bP < B.length && cP >= 0) {
                    int sum = B[bP] + C[cP];
                    if (sum == remain) {
                        int sameBCount = 1;
                        int sameCCount = 1;
                        while (bP < B.length - 1 && B[bP] == B[bP + 1]) {
                            sameBCount++;
                            bP++;
                        }
                        while (cP > 0 && C[cP] == C[cP - 1]) {
                            sameCCount++;
                            cP--;
                        }
                        totalFound += sameBCount * sameCCount;

                        bP++;
                        cP--;
                    } else if (sum > remain) {
                        cP--;
                    } else {
                        bP++;
                    }
                }
                remainCount.put(remain, totalFound);
//                System.out.println("found " + remain + " " + totalFound);
                result += totalFound;
                dP--;
            }
            aP++;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = TwoSum.fourSumCount(
                new int[] {-1,-1},
                new int[] {-1,1},
                new int[] {-1,1},
                new int[] {1,-1}
                );
        System.out.println(result);
//        if (result != null) {
//            for (int i = 0; i < result.size(); i++) {
//                System.out.println(result.get(i).get(0)
//                        + " " + result.get(i).get(1)
//                        + " " + result.get(i).get(2)
//                        + " " + result.get(i).get(3));
//            }
//
//        } else {
//            System.out.println("no result");
//        }

    }
}
