import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import javax.imageio.*;
import javax.swing.JOptionPane;
import java.io.*;
public class ddHisGray {
	public static BufferedImage image_hisgray(BufferedImage srcImage) {
		int width = srcImage.getWidth();
		int height = srcImage.getHeight();
		int srcRGBs[] = srcImage.getRGB(0, 0,width,height,null,0,width);
		int rgb[]=new int[3];
		BufferedImage destImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		for(int j=0;j<height;j++){
		   for(int i=0;i<width;i++){
		    	ImageColor.colorINTtoRGB(srcRGBs[j*width+i],rgb); 
				int grey=(rgb[0]*299+rgb[1]*587+rgb[2]*114+500)/1000;
				rgb[0]=grey;
				rgb[1]=grey;
				rgb[2]=grey;
				destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));				
		        }	
		}
		return destImage;
	}
}