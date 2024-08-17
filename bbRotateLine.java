import java.awt.image.BufferedImage;
public class bbRotateLine {
		public static BufferedImage image_rotateline(BufferedImage srcImage,double o){
				int w1 = srcImage.getWidth();
				int h1 = srcImage.getHeight();
				int srcRGBs[] = srcImage.getRGB(0, 0, w1, h1, null, 0, w1);			
				int rgb[]=new int[3];
				int rs[][]=new int[w1][ h1]; 
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
				//double oo = Math.PI*o/180;
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
			       	double w3 = Math.abs(x4)+Math.abs(x1), w4 = Math.abs(x3)+Math.abs(x2);				
				double h3 = Math.abs(y4)+Math.abs(y1), h4 =Math.abs(y3)+Math.abs(y2);

			    int w2,h2;
			    if(w3>w4) w2=(int)(w3);
			    else w2=(int)(w4);		
				if(h3>h4) h2=(int)h3;
			    else h2=(int)h4;

				BufferedImage destImage = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_RGB);
				int destRGBs[] = destImage.getRGB(0, 0, w2, h2, null, 0, w2);
				
		        for (int j = 0; j < h2; j++) {
					for(int i=0; i< w2; i++) {
				    	try {
							ImageColor.colorINTtoRGB(destRGBs[j*w2+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println(i);
						}
				    	
				    	double xx=(i-w2/2)*cos2-(j-h2/2)*sin2+w1/2;
				    	double yy=(i-w2/2)*sin2+(j-h2/2)*cos2+h1/2;
				    	int x0=(int)xx;
				    	int y0=(int)yy;				    	
				    	double ux=xx-x0;
				    	double uy=yy-y0;

				    	 if( x0>0 && y0>0 && x0<w1-1 && y0<h1-1)
				    	{
						    double rs1=(1-ux)*rs[x0][y0]+ux*rs[x0+1][y0];
						    double rs2=(1-ux)*rs[x0][y0+1]+ux*rs[x0+1][y0+1];
						    double rs3=(1-uy)*rs1+uy*rs2;
						    double gs1=(1-ux)*gs[x0][y0]+ux*gs[x0+1][y0];
						    double gs2=(1-ux)*gs[x0][y0+1]+ux*gs[x0+1][y0+1];
						    double gs3=(1-uy)*gs1+uy*gs2;
						    double bs1=(1-ux)*bs[x0][y0]+ux*bs[x0+1][y0];
					        double bs2=(1-ux)*bs[x0][y0+1]+ux*bs[x0+1][y0+1];
				            double bs3=(1-uy)*bs1+uy*bs2;
						    	rgb[0]=(int) rs3;
						    	rgb[1]=(int) gs3;
						    	rgb[2]=(int) bs3;
				    	}
				    	else{
				    		rgb[0]=238;//R  
				    	    rgb[1]=238;//G
				    	    rgb[2]=238;//B
				    	}
				    	destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
					}	
				}
				return destImage;
			}			
}	
			