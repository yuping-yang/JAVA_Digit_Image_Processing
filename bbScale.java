import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class bbScale {
	public static BufferedImage image_scale(BufferedImage srcImage,double p) {
		
				int width = srcImage.getWidth();
				int height = srcImage.getHeight();
				int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);
				//BufferedImage destImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				
				int rgb[]=new int[3];
				int rs[][]=new int[width][ height]; 
				int gs[][]=new int[width][ height];
				int bs[][]=new int[width][ height];
				double x=p;
				int xx=(int)p;
				for(int j=0; j<height; j++) {
				    for (int i = 0; i < width; i++) {
				    	ImageColor.colorINTtoRGB(srcRGBs[j*width+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
				    	rs[i][j]=rgb[0];   //R?
				    	gs[i][j]=rgb[1];   //G?
				    	bs[i][j]=rgb[2];   //b?
				}	
				}
				
			  //  int width1 = image1.getWidth();
			//	int height1 = image1.getHeight();
			//	srcRGBs = image1.getRGB(0, 0, width1, height1, null, 0, width1);
				
				float ftemp;
			    float a=0.5f;
			    int w=width;
			    int h=height;
			//	if (width > width1) {w=width1;}
			//	if (height > height1){h=height1;}
			    int w1=(int)(x*w-1);
			    int h1=(int)(x*h-1);
			    if (x>=1){w1-=1;h1-=1;}
				BufferedImage destImage = new BufferedImage(w1, h1, BufferedImage.TYPE_INT_RGB);
		        for (int j = 0; j < h; j++) {
					//for(int n=0;n<x;n++)
					//{
		        	for(int i=0; i<w; i++) {
				    	/*try {
							ImageUtil.decodeColor(srcRGBs[j*width1+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println(i);
						}
						*/
				    	ftemp=rs[i][j];   //R?
				    	rgb[0]=(int)(ftemp+0.5f);
				    	ftemp=gs[i][j];   //G?
				    	rgb[1]=(int)(ftemp+0.5f);
				    	ftemp=bs[i][j];   //B?
				    	rgb[2]=(int)(ftemp+0.5f);
				    	if(j==0) 	;//destImage.setRGB(i,j, ImageUtil.encodeColor(rgb));
				    	else{
				    		for(int n=(int)(x*(j-1)+1);n<=x*j;n++)	    {
				    	  if(i==0) ;//	destImage.setRGB(i,j, ImageUtil.encodeColor(rgb));
				    	  else{
				    	for(int m=(int)(x*(i-1)+1);m<=x*i;m++)
				    	//{	for(int m=2*(i-1)+1;m<=2*i;m++)
				    	///for(int m=1;m<=w*2;m++)
				    	destImage.setRGB(m-1,n-1, ImageColor.colorRGBtoINT(rgb));
				    	//i++;
				    	//}
				    	}}
				    	}
					}
		        	//j++;
				//}
		        			        	
				}
		     
				return destImage;
	}

}
			
			
