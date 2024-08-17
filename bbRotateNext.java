import java.awt.image.BufferedImage;
public class bbRotateNext {
	public static BufferedImage image_rotatenext(BufferedImage srcImage,double o){
		int w1 = srcImage.getWidth();
		int h1 = srcImage.getHeight();
		int srcRGBs[] = srcImage.getRGB(0, 0, w1, h1, null, 0, w1);
		//BufferedImage destImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		int rgb[]=new int[3];
		int rs[][]=new int[w1][ h1]; //
		int gs[][]=new int[w1][ h1];
		int bs[][]=new int[w1][ h1];
		
		for(int j=0; j<h1; j++) {
		    for (int i = 0; i < w1; i++) {
		    	ImageColor.colorINTtoRGB(srcRGBs[j*w1+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
		    	rs[i][j]=rgb[0];   //R
		    	gs[i][j]=rgb[1];   //G
		    	bs[i][j]=rgb[2];   //B
		}	
		}		
	    double oo = Math.toRadians(o);
	    double sin1=Math.sin(oo);
	    double cos1=Math.cos(oo);
	    double sin2=Math.sin(-oo);
	    double cos2=Math.cos(-oo);
	    double x1 =-w1/2*cos1 - h1/2*sin1;   
	    double y1 = w1/2*sin1 - h1/2*cos1;  //(-w1/2,-h1/2)
	    double x2 = w1/2*cos1 - h1/2*sin1;   
	    double y2 =-w1/2*sin1 - h1/2*cos1;  //( w1/2,-h1/2)
	    double x3 =-w1/2*cos1 + h1/2*sin1;   
	    double y3 = w1/2*sin1 + h1/2*cos1;  //(-w1/2, h1/2)
	    double x4 = w1/2*cos1 + h1/2*sin1;   
	    double y4 =-w1/2*sin1 + h1/2*cos1;  //( w1/2, h1/2)	    
	    
	    double w3 = Math.abs(x4)+Math.abs(x1);
	    double w4 = Math.abs(x3)+Math.abs(x2);
	    double h3 = Math.abs(y4)+Math.abs(y1);
	    double h4 = Math.abs(y3)+Math.abs(y2);
	    int w2=0;
	    int h2=0;
	    if(w3>w4) w2=(int)w3;
	    else w2=(int)w4;		
		if(h3>h4) h2=(int)h3;
	    else h2=(int)h4;
	   // int w2=(int)(1.5*w1);
	   // int h2=(int)(1.5*h1);
		BufferedImage destImage = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_RGB);
		int destRGBs[] = destImage.getRGB(0, 0, w2, h2, null, 0, w2);
		
        for (int j = 0; j < h2; j++) {
			for(int i=0; i<w2; i++) {
		    	try {
					ImageColor.colorINTtoRGB(destRGBs[j*w2+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(i);
				}
		    	int x=(int)((i-w2/2)*cos2-(j-h2/2)*sin2+w1/2);
		    	int y=(int)((i-w2/2)*sin2+(j-h2/2)*cos2+h1/2);
		    	if( x>=0 && y>=0 && x<w1 && y<h1)
		    	{
		    	    rgb[0]=rs[x][y];//R 
		    	    rgb[1]=gs[x][y];//G
		    	    rgb[2]=bs[x][y];//B
		    	}
		    	else{
		    	    rgb[0]=238;//G  
		    	    rgb[1]=238;//G
		    	    rgb[2]=238;//B
		    	}
		    	destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
			}	
		}
		return destImage;
		
	}
	
}
