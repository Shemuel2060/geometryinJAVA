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
        double dist = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
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
        System.out.print("Enter "+n +" points: ");
        points =new double[n][2];
        for(int i=0;i<points.length;i++){
            points[i][0] = in.nextDouble();
            points[i][1]= in.nextDouble();
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
        double[] dists = new double[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
                dists[i] = distance(arr[i][0],arr[i][1],arr[i+1][0],arr[i+1][1]);
            }
        return dists;
    }

    public static void main(String[] args){
        double[][] pts = enterPoints();
        // for(int i=0;i<pts.length;i++){
        //     System.out.println(pts[i][0]+", "+pts[i][1]);
        // }
        int r1=0, r2=1; // initial two points
        double shortestDistance = distance(pts[r1][0],pts[r1][1],pts[r2][0],pts[r2][1]);
        
        double[] computed = computeDistances(pts);
        for(int i=0;i<computed.length;i++){
            System.out.println(""+computed[i]);
        }
        for(int i=0;i<computed.length-1;i++){
            if(computed[i]<shortestDistance){
                shortestDistance = computed[i];
                System.out.println("Shortest distance: "+shortestDistance+"\nClosest points: ("+pts[i][0]+","+pts[i][1]+")"+
                ","+"("+pts[i+1][0]+","+pts[i+1][1]+")");
            }
        }
    }
}