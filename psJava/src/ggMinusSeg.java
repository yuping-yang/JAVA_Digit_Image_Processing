import java.awt.image.BufferedImage;
public class ggMinusSeg{
	public static BufferedImage image_minusseg(BufferedImage srcImage,BufferedImage image1) {
		int width = srcImage.getWidth();
		int height = srcImage.getHeight();
		int iRGBs1[] = srcImage.getRGB(0, 0, width, height, null, 0, width);
		int iRGBs2[] =image1.getRGB(0, 0, width, height, null, 0, width);
		
		int rgb1[]=new int[3];
		int rgb2[]=new int[3];

		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for(int j=0; j<height; j++) {
		    for (int i = 0; i < width; i++) {
		    	ImageColor.colorINTtoRGB(iRGBs1[j*width+i],rgb1); 
		    	ImageColor.colorINTtoRGB(iRGBs2[j*width+i],rgb2);
		    	int a=rgb1[0]-rgb2[0];
		    	int b=rgb1[1]-rgb2[1];
		    	int c=rgb1[2]-rgb2[2];
		    	if(a<20&&b<20&&c<20){ }
		    	else  newImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb1));
		    	}
		}
		return newImage;
	}		
}
