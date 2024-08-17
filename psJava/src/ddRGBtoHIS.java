import java.awt.image.BufferedImage;

public class ddRGBtoHIS {

    public static BufferedImage image_rgbtohis(BufferedImage srcImage) {
		int width = srcImage.getWidth();
		int height = srcImage.getHeight();
		int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);

		int rgb[]=new int[3];
		int rs[][]=new int[width][ height];
		int gs[][]=new int[width][ height];
		int bs[][]=new int[width][ height];
		
		double hs[][]=new double[width][height];
		double ss[][]=new double[width][height];
		double is[][]=new double[width][height];
		
		int intensity[]=new int[256];//I
		for(int i=0;i<256;i++){  
			intensity[i]=0;
		}	
		
		double H,I,S,numm,den,theta,min,max;
		for(int j=0; j<height; j++) {
		    for (int i = 0; i < width; i++) {
		    	ImageColor.colorINTtoRGB(srcRGBs[j*width+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
		    	rs[i][j]=rgb[0];   //R
		    	gs[i][j]=rgb[1];   //G
		    	bs[i][j]=rgb[2];   //b
		    	 numm=0.5*((rs[i][j]-gs[i][j])+(rs[i][j]-bs[i][j]));
		         den=Math.sqrt((rs[i][j]-gs[i][j])*(rs[i][j]-gs[i][j])+(rs[i][j]-bs[i][j])*(gs[i][j]-bs[i][j]));
		        
		         //H
		    	if(den==0)    hs[i][j]=0;
		    	else{
		    		 theta=Math.acos(numm/den);
		    		if(bs[i][j]>gs[i][j])    //hs[i][j]=(int)((2*Math.PI-theta)/(2*Math.PI));
		    			hs[i][j]=(2*Math.PI-theta);
		    		//else  hs[i][j]=(int)(theta/(2*Math.PI));
		    		else  hs[i][j]=theta;
		    	}
		    	
		    	//S
		    	min=(bs[i][j]>gs[i][j])?gs[i][j]:bs[i][j];
		    	min=(min>rs[i][j])?rs[i][j]:min;
		    	 den=rs[i][j]+gs[i][j]+bs[i][j];
		    	if(den==0)   ss[i][j]=0;
		    	else  ss[i][j]=1-(3*min/den);
		    	
		    	//I
		    	is[i][j]=den/3;
		    	//int gray=(int)(0.299*rs[i][j]+0.587*gs[i][j]+0.114*bs[i][j]);
		    	intensity[(int) is[i][j]]++;
		}	
		}
				
	    int w=width;
	    int h=height;
	    double d=w*h;  
	   
	        
		double rate[]=new double[256];
		for(int i=0;i<256;i++){
			rate[i]=0;    
		}
		rate[0]=intensity[0]/d;
		for(int i=1;i<256;i++){
			double a=intensity[i]/d;
			rate[i]=rate[i-1]+a;	
		}
        BufferedImage destImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int j = 0; j < h; j++) {
			for(int i=0; i<w; i++) {
		    	is[i][j]=255*rate[(int)is[i][j]];
		    	if(hs[i][j]>=0&&hs[i][j]<2*Math.PI/3){
		    		rgb[2]=(int) (is[i][j]*(1-ss[i][j]));
		    		rgb[0]=(int)(is[i][j]*(1+(ss[i][j]*Math.cos(hs[i][j])/Math.cos(Math.PI/3-hs[i][j]))));
		    		rgb[1]=(int) (3*is[i][j]-(rgb[0]+rgb[2]));
		    	}
		    	if(hs[i][j]>=2*Math.PI/3&&hs[i][j]<4*Math.PI/3){
		    		hs[i][j]=(hs[i][j]-(2*Math.PI/3));
		    		rgb[0]=(int) (is[i][j]*(1-ss[i][j]));
		    		rgb[1]=(int)(is[i][j]*(1+(ss[i][j]*Math.cos(hs[i][j])/Math.cos(Math.PI/3-hs[i][j]))));
		    		rgb[2]=(int) (3*is[i][j]-(rgb[0]+rgb[1]));
		    	}
		    	if(hs[i][j]>=4*Math.PI/3&&hs[i][j]<2*Math.PI){
		    		hs[i][j]=(hs[i][j]-4*Math.PI/3);
		    		rgb[1]=(int) (is[i][j]*(1-ss[i][j]));
		    		rgb[2]=(int)(is[i][j]*(1+(ss[i][j]*Math.cos(hs[i][j])/Math.cos(Math.PI/3-hs[i][j]))));
		    		rgb[0]=(int) (3*is[i][j]-(rgb[2]+rgb[1]));
		    	}
		    	
		    	if(rgb[0]>255){
		    		rgb[0]=255;
		    	}
		    	if(rgb[1]>255){
		    		rgb[1]=255;
		    	}
		    	if(rgb[2]>255){
		    		rgb[2]=255;
		    	}
		    	if(rgb[0]<0){
		    		rgb[0]=0;
		    	}
		    	if(rgb[1]<0){
		    		rgb[1]=0;
		    	}
		    	if(rgb[2]<0){
		    		rgb[2]=0;
		    	}
		    	destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
			}	
		}    
		return destImage;	
	}
    
}
