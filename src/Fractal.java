//Stuart Spiegel
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

//This class creates Fractal artwork based off of a given image, it will use the Mathematical Mandelbrot theory to calculate 
//-fractals using iterations (recursion) of an algorithm 
public class Fractal {

	public static void main(String[] args) throws IOException {
		new Fractal();
	}

	//fields
	//r is the random object for variance in complex numbers used
	
	public static ComplexNumber c = new ComplexNumber(-0.22, 0.75);
	private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
	//array of booleans for pixels, black or white (true or false) etc
    private boolean[][] values = null;
   
   //creates BufferedImage
    BufferedImage image = null;
  
    //bounds for complex plain to graph
    
    private double minX = -2.5;
    private double maxX = 1;
    private double minY = -1.75;
    private double maxY = 1.25;
	
	//maximum complex number in the given set allowed
    private double threshold = 1;
	//number of times algorithm executes 
    private int iterations = 1000;
	
	//constructor
	public Fractal() throws IOException{
		
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		 //fills the array values
		 getValues();
		 //moves through array and sets pixel color to the values in the array "values"
		 for(int i=0;i<WIDTH;i++){
	            for(int j=0;j<HEIGHT;j++){
	                // If the point is in the Set, color it White, else, color it Black.
	                if(values[i][j]) image.setRGB(i, j, Color.WHITE.getRGB());
	                if(!values[i][j]) image.setRGB(i, j, Color.BLACK.getRGB());
	            }
	        }
		 //creates a JFrame
		 JFrame f = new JFrame("Fractal"){  
			
			 
			 
				public void paint(java.awt.Graphics g){
	                g.drawImage(image,-5,0,null);
					 
	            }
			 	
	        };
	        //frame settings
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setSize(WIDTH,HEIGHT);
	        f.repaint();
	        f.setVisible(true);
	    }

		
	
	//fills array "values" with values for pixels
	private void getValues() {
		values = new boolean[WIDTH][HEIGHT];
        //determines values for each Pixel, each pixel is a complex number, pixel in center is 0,0, window is scaled version
		//-of the bounds set in fields
        for(int k=0;k<WIDTH;k++){
            for(int j=0;j<HEIGHT;j++){
                
		double a = (double)k*(maxX-minX)/(double)WIDTH + minX;
		double b = (double)j*(maxY-minY)/(double)HEIGHT + minY;
                // fill the boolean array.
                values[k][j] = inSet(new ComplexNumber(a,b));
            }
        }
		
		
		
	}
	//checks to see if c = a + ib is in mandelbrot set
	private boolean inSet(ComplexNumber com){
        for(int i=0;i<iterations;i++){
           //basic set Algorithm, algo credit is not mine
            com = com.square().add(c);
 
        }
        // If the threshold squared is larger than the magnitude then return true
        return com.magnitude()<threshold*threshold;
    }
	
}




