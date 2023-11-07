import java.util.*;
class Day7
{
    //Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        // code here
        ArrayList<Integer> a = new ArrayList<>();
        int sum1 = 0, sum2 =0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum1 += matrix[i][j];
                sum2 += matrix[n-i-1][n-1-j];
            }
        }
        a.add(sum1);
        a.add(sum2);
        return a; 
    }

}


