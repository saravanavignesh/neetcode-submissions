class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        System.out.println("row:"+row);
        return row == -1 ? false : findTarget(matrix[row], target);
    }

    public int findRow(int[][] matrix, int target){
        int left=0, right=matrix.length-1, mid;
        int n = matrix[0].length-1;
        int firstEle, lastEle;
        while(left<=right){
            mid = left + (right-left)/2;
            firstEle = matrix[mid][0];
            lastEle = matrix[mid][n];
            if(firstEle<=target && target<=lastEle) return mid;
            else if(target<firstEle && target<lastEle){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public boolean findTarget(int[] row, int target){
        int left=0, right=row.length-1, mid;
        while(left<=right){
            mid = left + (right-left)/2;
            if(row[mid]==target) return true;
            else if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
