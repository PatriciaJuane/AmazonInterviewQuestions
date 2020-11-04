class Solution {
  // Two Sum II - Input array is sorted
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        
        while(low < high) {
            int currentSum = numbers[low] + numbers[high];
            
            if(currentSum == target) {
                return new int[]{low+1, high+1};
            } else if (currentSum > target) {
                high--;
            } else { // currentSum < target
                low++;
            }
        }
        
        return new int[]{-1,-1};
    }
}
// O(n) time and O(1) space