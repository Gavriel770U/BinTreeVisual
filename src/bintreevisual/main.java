package bintreevisual;

class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Bin Tree Visualisation!");
        
        BTVisualizer vis = BTVisualizer.getInstance();
        vis.visualize(null, null, null, null);
    }
}