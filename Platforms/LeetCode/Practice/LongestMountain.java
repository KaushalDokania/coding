public class LongestMountain {
    static class Solution {
        public int longestMountain2(int[] arr) {
            int count=1, maxCount = 0, climbDecend=-1;        // 0 for climbing, 1 for decending
            for (int i=1; i<arr.length; ++i) {
                if (arr[i] > arr[i-1]) {
                    if (climbDecend == 1) {             // new mountain started
                        maxCount = (count>maxCount) ? count : maxCount;
                        count = 1;                      // reset and count the last one
                        climbDecend = -1;
                    }
                    count++;                            // count the current one
                    climbDecend = 0;
                } else if (arr[i] < arr[i-1]) {
                    climbDecend = climbDecend==0 ? 1 : climbDecend;
                    if (climbDecend==1)
                        count++;
                    
                } else {
                    if (climbDecend==1) {
                        maxCount = (count>maxCount) ? count : maxCount;
                    }
                    count = 1;
                    climbDecend = -1;
                }
            }
            if (climbDecend==1)
                maxCount = (count>maxCount) ? count : maxCount;
            return (maxCount >= 3) ? maxCount : 0;
        }

        public int longestMountain(int[] arr) {
            int i=1, maxCount = 0;
            while (i < arr.length) {
                int climb=0, decend=0;
                while (i < arr.length && arr[i] > arr[i-1]) {
                    i++;
                    climb++;
                }
                while (i < arr.length && arr[i] < arr[i-1]) {
                    i++;
                    decend++;
                }
                if (climb > 0 && decend > 0)
                maxCount = (i > maxCount) ? i : maxCount;
            }
            return maxCount;
        }

        public int longestMountain3(int[] A) {
            int max = 0, i = 1, N = A.length;
            
            while (i < N) {
                int up = 0, down = 0;
                
                while (i < N && A[i - 1] < A[i]) { i++; up++;   }
                while (i < N && A[i - 1] > A[i]) { i++; down++; }
                
                if (up > 0 && down > 0) max = Math.max(max, up + down + 1);
                
                while (i < N && A[i - 1] == A[i]) i++;
            }
            return max;
        }
    }


    public static void main(String[] args) {
        // int arr[] = new int[]{2,1,4,7,3,2,5};
        // int arr[] = new int[]{2,2,2};
        // int arr[] = new int[]{2,4,3};
        // int arr[] = new int[]{0,1,2,3,4,5,6,7,8,9};
        // int arr[] = new int[]{9,8,7,6,5,4,3,2,1,0};
        // int arr[] = new int[]{0,2,0,2,1,2,3,4,4,1};
        int arr[] = new int[]{2,3,3,2,0,2};
        // int arr[] = new int[]{1,2,4,5,3,9,6,8,10,9,11,17,19,20,18,14,12,16,6,10};
        System.out.println("Answer: " + new Solution().longestMountain3(arr));
    }
}
