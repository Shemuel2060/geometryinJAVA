import java.util.Scanner;

/**
 * The program lets the user enter a number of points, then computes
 * the distances between each pair of points, and returns the points
 * closest to each other.
 */
public class NearestPoints{

    static double[][] points;

    /**
     * Takes in two points and computes the distance between them using 
     * the Euclidean method.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return distance
     */
    public static double distance(double x1,double y1,double x2,double y2){
        double dist = Math.sqrt((x2-x1)*(x2-x1) + Math.pow((y2-y1),2));
        return dist;
    }
    
    /**
     * Allows the user to enter a specific number of points, and then the 
     * points themselves. The points entered are stored in a 2-D array
     * which is returned.
     * @return 2-D array of points
     */
    public static double[][] enterPoints(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of points: ");
        int n = in.nextInt();
        System.out.print("Enter points: ");
        int times = 0;
        points =new double[n][2];
        while(times<n){
            points[times][0] = in.nextDouble();
            points[times][1]= in.nextDouble();
            times++;
        }
        in.close();
        return points;
    }

    /**
     * Takes in an 2-D array of points and returns a 1-D array of 
     * computed distances between the points.
     * @param arr
     * @return computed distances array
     */
    public static double[] computeDistances(double[][] arr){
        double[] dists = new double[points.length-1];
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length-1;j++){
                dists[i] = distance(arr[1][0],arr[i][1],arr[j][0],arr[j][1]);
            }
        }

        return dists;

    }

    public static void main(String[] args){
        double[][] pts = enterPoints();
        double[] computed = computeDistances(pts);
        for(int i=0;i<computed.length-1;i++){
            if(computed[i]<computed[i+1]){
                System.out.println("Shortest distance: "+computed[i]+"\nClosest points: ("+pts[i][0]+","+pts[i][1]+")"+
                ","+"("+pts[i+1][0]+","+pts[i+1][1]+")");
            }
        }
    }
}