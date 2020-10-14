class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);  // O(n log n)
        
        int sum = 0; // sumas provisionales
        int resultado = 100000; // resultado final que se actualizará
        
        int low = 0;
        int high = nums.length - 1;
        
        for(int i=0; i<nums.length; i++) {
            low = i+1; // valor justo a la derecha de nuestro indice
            high = nums.length-1;
            
            while(low < high) {
                sum = nums[i] + nums[low] + nums[high]; // suma provisional
                if(sum == target) {
                    return sum;
                }
                if(Math.abs(target-sum) < Math.abs(target-resultado)) {
                    resultado = sum; // actualizamos resultado si la diferencia con target es menor
                }
                
                if(sum < target) {
                    low++; // ya que el array esta ordenado
                } else {
                    high--;
                }
                
            }
            
        }
        
        return resultado; 
    }
}
