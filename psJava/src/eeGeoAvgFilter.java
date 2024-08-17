import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
public class eeGeoAvgFilter {
	   public static BufferedImage image_geoavgfilter(BufferedImage srcImage) {
	  		int width = srcImage.getWidth();
	  		int height = srcImage.getHeight();
	  		int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);

	  		int rgb[]=new int[3];
	  		int rs[][]=new int[width][ height]; 
	  		int gs[][]=new int[width][ height];
	  		int bs[][]=new int[width][ height];

	  		String s=JOptionPane.showInputDialog("Please enter the filter parameters (3 or 5)");
	  		int n=Integer.parseInt(s);
	  		if(n!=3&&n!=5){  
	  			JOptionPane.showMessageDialog( null,"The value entered is incorrect");
	  		}
	  		
	  		for(int j=0; j<height; j++) {
	  		    for (int i =0; i < width; i++) {
	  		    	ImageColor.colorINTtoRGB(srcRGBs[j* width+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]
	 		    	rs[i][j]=rgb[0];   //R
	 		    	gs[i][j]=rgb[1];   //G
	  		    	bs[i][j]=rgb[2];   //b 		    	  		
	  		    }	
	  		}
	  	    int w=width;
	  	    int h=height; 
	  	    double temp=1;
	  	    int r[] = new int[25],g[]= new int[25],b[]= new int[25];
	        BufferedImage destImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	        for (int j = 0; j < h; j++) {
				for(int i=0; i<w; i++) {
				if(n==3){
                    if(i==0||j==0||i==w-1||j==h-1){
                    	rgb[0]=rs[i][j];    			   
    			    	rgb[1]=gs[i][j];
    			    	rgb[2]=bs[i][j];
                    }
                    else{ 	                  	                   
                        temp=1;
                    	r[0]=zeroTo1(rs[i-1][j-1]);r[1]=zeroTo1(rs[i][j-1]);r[2]=zeroTo1(rs[i+1][j-1]);r[3]=zeroTo1(rs[i-1][j]);r[4]=zeroTo1(rs[i][j]);
                    	r[5]=zeroTo1(rs[i+1][j]);r[6]=zeroTo1(rs[i-1][j+1]);r[7]=zeroTo1(rs[i][j+1]);r[8]=zeroTo1(rs[i+1][j+1]);
                    	//System.out.println("r[0]: "+r[0]+"r[1]: "+r[1]+"r[2]: "+r[2]+"r[3]: "+r[3]+"r[4]: "+r[4]+"r[5]: "+r[5]+"r[6]: "+r[6]+"r[7]: "+r[7]+"r[8]: "+r[8]);
                    	for(int a=0;a<9;a++){
                    		temp=temp*Math.pow(r[a],1.0/9);
                    		//System.out.println("a: "+Math.pow(r[a],1.0/9));
                    		//System.out.println("temp: "+temp);
                    	}
                    	rgb[0]=(int)(temp+0.5f);
       	
                    	temp=1;
                    	g[0]=zeroTo1(gs[i-1][j-1]);g[1]=zeroTo1(gs[i][j-1]);g[2]=zeroTo1(gs[i+1][j-1]);g[3]=zeroTo1(gs[i-1][j]);g[4]=zeroTo1(gs[i][j]);
                    	g[5]=zeroTo1(gs[i+1][j]);g[6]=zeroTo1(gs[i-1][j+1]);g[7]=zeroTo1(gs[i][j+1]);g[8]=zeroTo1(gs[i+1][j+1]); 
                    	for(int a=0;a<9;a++){
                    		temp*=Math.pow(g[a],1.0/9);
                    	}
                    	rgb[1]=(int)(temp+0.5f);
                    	
                    	temp=1;
                    	b[0]=zeroTo1(bs[i-1][j-1]);b[1]=zeroTo1(bs[i][j-1]);b[2]=zeroTo1(bs[i+1][j-1]);b[3]=zeroTo1(bs[i-1][j]);b[4]=zeroTo1(bs[i][j]);
                    	b[5]=zeroTo1(bs[i+1][j]);b[6]=zeroTo1(bs[i-1][j+1]);b[7]=zeroTo1(bs[i][j+1]);b[8]=zeroTo1(bs[i+1][j+1]); 
                    	for(int a=0;a<9;a++){
                    		temp*=Math.pow(b[a],1.0/9);
                    	}
                    	rgb[2]=(int)(temp+0.5f);                    	    	
                    }
                }
				else {
					if(i==0||j==0||i==1||j==1||i==w-2||j==h-2||i==w-1||j==h-1){
                    		rgb[0]=rs[i][j];    			   
    			    	rgb[1]=gs[i][j];
    			    	rgb[2]=bs[i][j];
                    }
                    else{

                        temp=1;
                        r[0]=zeroTo1(rs[i-2][j-2]);r[1]=zeroTo1(rs[i-1][j-2]);r[2]=zeroTo1(rs[i][j-2]);r[3]=zeroTo1(rs[i+1][j-2]);r[4]=zeroTo1(rs[i+2][j-2]);
                    	r[5]=zeroTo1(rs[i-2][j-1]);r[6]=zeroTo1(rs[i-1][j-1]);r[7]=zeroTo1(rs[i][j-1]);r[8]=zeroTo1(rs[i+1][j-1]);r[9]=zeroTo1(rs[i+2][j-1]);
                    	r[10]=zeroTo1(rs[i-2][j]);r[11]=zeroTo1(rs[i-1][j]);r[12]=zeroTo1(rs[i][j]);r[13]=zeroTo1(rs[i+1][j]);r[14]=zeroTo1(rs[i+2][j]);
                    	r[15]=zeroTo1(rs[i-2][j+1]);r[16]=zeroTo1(rs[i-1][j+1]);r[17]=zeroTo1(rs[i][j+1]);r[18]=zeroTo1(rs[i+1][j+1]);r[19]=zeroTo1(rs[i+2][j+1]);
                    	r[20]=zeroTo1(rs[i-2][j+2]);r[21]=zeroTo1(rs[i-1][j+2]);r[22]=zeroTo1(rs[i][j+2]);r[23]=zeroTo1(rs[i+1][j+2]);r[24]=zeroTo1(rs[i+2][j+2]);            	                    
                    	for(int a=0;a<25;a++){
                    		temp=temp*Math.pow(r[a],1.0/25);
                    		//System.out.println("a: "+Math.pow(r[a],1.0/9));
                    		//System.out.println("temp: "+temp);
                    	}
                    	rgb[0]=(int)(temp+0.5f);
                    	
                    	temp=1;
                    	g[0]=zeroTo1(gs[i-2][j-2]);g[1]=zeroTo1(gs[i-1][j-2]);g[2]=zeroTo1(gs[i][j-2]);g[3]=zeroTo1(gs[i+1][j-2]);g[4]=zeroTo1(gs[i+2][j-2]);
                    	g[5]=zeroTo1(gs[i-2][j-1]);g[6]=zeroTo1(gs[i-1][j-1]);g[7]=zeroTo1(gs[i][j-1]);g[8]=zeroTo1(gs[i+1][j-1]);g[9]=zeroTo1(gs[i+2][j-1]);
                    	g[10]=zeroTo1(gs[i-2][j]);g[11]=zeroTo1(gs[i-1][j]);g[12]=zeroTo1(gs[i][j]);g[13]=zeroTo1(gs[i+1][j]);g[14]=zeroTo1(gs[i+2][j]);
                    	g[15]=zeroTo1(gs[i-2][j+1]);g[16]=zeroTo1(gs[i-1][j+1]);g[17]=zeroTo1(gs[i][j+1]);g[18]=zeroTo1(gs[i+1][j+1]);g[19]=zeroTo1(gs[i+2][j+1]);
                    	g[20]=zeroTo1(gs[i-2][j+2]);g[21]=zeroTo1(gs[i-1][j+2]);g[22]=zeroTo1(gs[i][j+2]);g[23]=zeroTo1(gs[i+1][j+2]);g[24]=zeroTo1(gs[i+2][j+2]);                   	
                    	for(int a=0;a<25;a++){
                    		temp*=Math.pow(g[a],1.0/25);
                    	}
                    	rgb[1]=(int)(temp+0.5f);
                    	
                    	temp=1;
                    	b[0]=zeroTo1(bs[i-2][j-2]);b[1]=zeroTo1(bs[i-1][j-2]);b[2]=zeroTo1(bs[i][j-2]);b[3]=zeroTo1(bs[i+1][j-2]);b[4]=zeroTo1(bs[i+2][j-2]);
                    	b[5]=zeroTo1(bs[i-2][j-1]);b[6]=zeroTo1(bs[i-1][j-1]);b[7]=zeroTo1(bs[i][j-1]);b[8]=zeroTo1(bs[i+1][j-1]);b[9]=zeroTo1(bs[i+2][j-1]);
                    	b[10]=zeroTo1(bs[i-2][j]);b[11]=zeroTo1(bs[i-1][j]);b[12]=zeroTo1(bs[i][j]);b[13]=zeroTo1(bs[i+1][j]);b[14]=zeroTo1(bs[i+2][j]);
                    	b[15]=zeroTo1(bs[i-2][j+1]);b[16]=zeroTo1(bs[i-1][j+1]);b[17]=zeroTo1(bs[i][j+1]);b[18]=zeroTo1(bs[i+1][j+1]);b[19]=zeroTo1(bs[i+2][j+1]);
                    	b[20]=zeroTo1(bs[i-2][j+2]);b[21]=zeroTo1(bs[i-1][j+2]);b[22]=zeroTo1(bs[i][j+2]);b[23]=zeroTo1(bs[i+1][j+2]);b[24]=zeroTo1(bs[i+2][j+2]);
                        for(int a=0;a<25;a++){
                    		temp*=Math.pow(b[a],1.0/25);
                    	}
                    	rgb[2]=(int)(temp+0.5f);	    	
                    }
				}					
                    destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
				}	
			}    
			return destImage;
		}
         public static int zeroTo1(int a){
        	 if(a==0) return 1;
        	 else return a;
         }

		}
		