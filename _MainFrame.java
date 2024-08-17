import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.io.*;
import javax.imageio.*;

import java.text.SimpleDateFormat;
import java.util.*;

/*
 *
 *
public class MainFrame extends JFrame {   
     1. menu, button
     2. public MainFrame() {
           addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                   exit(e);
               }
           });
        
           initComponents();
      }
     3. private void initComponents() {settings
      }
     4. functions

  }  
 
*      
*/

//hotkey ABCDEFGHIJKLMNOPQRSTUVWXYZ 
/*
ImageIcon icon=new ImageIcon("C:/Users/Administrator/Desktop/psjavapic/icon/new.jpg");
bOpen.setIcon(icon);
*/
public class _MainFrame extends JFrame {
	
	JMenuBar mb;
    JMenu fileMenu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem clearItem;
    JMenuItem exitItem;
    
    //JMenu editMenu; 
    JMenu simpleMenu;
    JMenu geometryMenu;
    JMenu contrastMenu;
    JMenu equalizationMenu;
    JMenu filterMenu;
    JMenu edgeMenu;
    JMenu imageSegMenu;

    JMenu mScale=new JMenu("scale");  
    //mScale.setMnemonic('M');
    //mScale.setMnemonic('F');
    JMenu mRotate=new JMenu("rotate");
    //JMenu mEnforce=new JMenu("contrast");
    JMenu mHistogram=new JMenu("grey histogram");
    JMenu mSpatialfilter=new JMenu("Spatial filter smoothing");
    JMenu mSequencingfilter=new JMenu("Sequencing filter denoising");
    //JMenu mFilter=new JMenu("spatial filter");
    JMenu mRoberts=new JMenu("Roberts");
    JMenu mPrewitt=new JMenu("Prewitt");
    JMenu mSobel=new JMenu("Sobel");
    JMenu mLaplace=new JMenu("Laplace");
    
    JMenuItem addItem;
    JMenuItem iInvert;
    JMenuItem iScale;
    JMenuItem iRotate;
    JMenuItem iTranslate;
    JMenuItem iMatting;     
    JMenuItem iEnforce;     
    JMenuItem iEnforceLog;     
    //JMenuItem iHistogram;     
    JMenuItem iScaleLine;     
    JMenuItem iScaleNext;     
    JMenuItem iRotateLine;   
    JMenuItem iRotateNext;     
    JMenuItem iExposure;     
    JMenuItem iHisGray;    
    JMenuItem iHisEqualize;    
    JMenuItem iAvgFilter;
    JMenuItem iGeoAvgFilter;
    JMenuItem iHarmonicFilter;
    JMenuItem iMedFilter;
    JMenuItem iMaxFilter;
    JMenuItem iMinFilter;
    JMenuItem iMidFilter;
    JMenuItem iRGBtoHIS;
    JMenuItem iEdgeR;
    JMenuItem iSharpeningR;
    JMenuItem iEdgeP;
    JMenuItem iSharpeningP;
    JMenuItem iEdgeS;
    JMenuItem iSharpeningS;
    JMenuItem iEdgeL;
    JMenuItem iSharpeningL;
    JMenuItem iOTSU;
    JMenuItem iBestSeg;
    JMenuItem iMinusSeg;

    ImagePanel imagePanelL;
    ImagePanel imagePanelR; 
    JScrollPane scrollPaneL;
    JScrollPane scrollPaneR;
    ImageIcon imageIcon;
    BufferedImage imageL;
    BufferedImage imageR;
    
    JFileChooser chooser;
    //ImagePreviewer imagePreviewer;
    //ImageFileView fileView;
    /*
    ImageFileFilter bmpFilter;
    ImageFileFilter jpgFilter;
	ImageFileFilter gifFilter;
	ImageFileFilter bothFilter;
	*/
	int a=0,b=0,c=0,d=0;
	    
    public _MainFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit(e);
            }
        });
        
        initComponents();
    }
    
    private void initComponents() {
    	
        JButton bOpen;
        JButton bScreenshot;
        JButton bAddText;
        JButton bClear;
        JButton bSave;
        JButton bExit;
        
        JPanel jpUp;
        JLabel jlUp1;
        JLabel jlUp2;
    	jpUp = new JPanel();
    	this.add(jpUp,BorderLayout.NORTH);
    	jlUp1 = new JLabel("	Original image	");
    	jlUp2 = new JLabel("	New image");
    	jpUp.add(jlUp1);
    	jpUp.add(jlUp2);
    	

        JPanel jpLeft;
		jpLeft = new JPanel();
		
    	jpLeft.setLayout(new GridLayout(7,1));

	    this.add(jpLeft, BorderLayout.WEST);
	    JPanel jpLeft1 = new JPanel();
	    JPanel jpLeft2 = new JPanel();
	    JPanel jpLeft3 = new JPanel();
	    JPanel jpLeft4 = new JPanel();
	    JPanel jpLeft5 = new JPanel();
	    JPanel jpLeft6 = new JPanel();
	    JPanel jpLeft7 = new JPanel();

	   /* JPanel jpLeftButton;
	    jpLeftButton = new JPanel();
	   // jpLeftButton.setPreferredSize(new Dimension(30, 100));
	    jpLeftButton.setLayout(new GridLayout(8,1));
	    jpLeft.add(jpLeftButton);
	    */
	    bOpen = new JButton("select image");
		//bOpen.setForeground(Color.BLACK);
	    bScreenshot = new JButton("crop image");
	    // bScreenshot.setForeground(Color.BLACK);
	    bAddText = new JButton("watermark");
	    // bAddText.setForeground(Color.BLACK);
	    
	    JLabel jlBlank1;
	    JLabel jlBlank2;
	    JLabel jlBlank3;
	    JLabel jlBlank4;
	    JLabel jlBlank5;
	    JLabel jlBlank6;
	  //  jlBlank1 = new JLabel("------٩(๑^o^๑)۶----------------");
	    jlBlank1 = new JLabel("---(﹡^o^﹡)---");
	    jlBlank2 = new JLabel("---(﹡^o^﹡)---");
	    jlBlank3 = new JLabel("---(﹡^o^﹡)---");
	    jlBlank4 = new JLabel("     ");
	    jlBlank5 = new JLabel("     ");
	    jlBlank6 = new JLabel("     ");

	    /*jpLeftButton.add(bOpen);
	    jpLeftButton.add(jlBlank1);
	    jpLeftButton.add(bScreenshot);
	    jpLeftButton.add(jlBlank2);
	    jpLeftButton.add(bAddText);
	    jpLeftButton.add(jlBlank3);
	    */
	    

	    /*JPanel jpLeftText;
	    jpLeftText = new JPanel();
	    jpLeftText.setLayout(new GridLayout(8,1));
	    jpLeft.add(jpLeftText,BorderLayout.SOUTH);
	    */
	    JLabel jlTextFont;
		JLabel jlTextBorI;
		JLabel jlTextSize;
		JLabel jlTextColor;
		jlTextFont = new JLabel("  -- font --");
		jlTextBorI = new JLabel("  -- format --");
		jlTextSize = new JLabel("  -- size --");
		jlTextColor = new JLabel("  -- colour --");

        
		
	    JPanel jpFont=new JPanel();
	    jpFont.setLayout(new GridLayout(2,2));
	    //jpFont.setBorder(BorderFactory.createTitledBorder("font")) ;


	    JPanel jpBorI=new JPanel();
	    jpBorI.setLayout(new GridLayout(2,2));
	    JPanel jpSize=new JPanel();
	    jpSize.setLayout(new GridLayout(2,2));
	    JPanel jpColor=new JPanel();
	    jpColor.setLayout(new GridLayout(4,2));
	    //XXX
	   /* jpLeftText.add(jlTextFont);
	    jpLeftText.add(jpFont);	 
	   
	   // jpLeftButton.add(jlTextFont);
	   // jpLeftButton.add(jpFont);	    
	    jpLeftText.add(jlTextBorI);
	    jpLeftText.add(jpBorI);	    
	    jpLeftText.add(jlTextSize);
	    jpLeftText.add(jpSize);	    
	    jpLeftText.add(jlTextColor);
	    jpLeftText.add(jpColor);
		//int textBorI,int textsize,int textfont,int  textcolor,
         */
		
		ButtonGroup bgFont = new ButtonGroup();
		JRadioButton jrbFont1=new JRadioButton("arial");
		JRadioButton jrbFont2=new JRadioButton("calibri");
		JRadioButton jrbFont3=new JRadioButton("consolas");
		JRadioButton jrbFont4=new JRadioButton("cambria");
		bgFont.add(jrbFont1);
		bgFont.add(jrbFont2);
		bgFont.add(jrbFont3);
		bgFont.add(jrbFont4);
		jpFont.add(jrbFont1);
		jpFont.add(jrbFont2);
		jpFont.add(jrbFont3);
		jpFont.add(jrbFont4);
		
		ButtonGroup bgBorI = new ButtonGroup();
		JRadioButton jrbBorI1=new JRadioButton("regular");
		JRadioButton jrbBorI2=new JRadioButton("bold");
		JRadioButton jrbBorI3=new JRadioButton("italic");
		JRadioButton jrbBorI4=new JRadioButton("bold_italic");
		bgBorI.add(jrbBorI1);
		bgBorI.add(jrbBorI2);
		bgBorI.add(jrbBorI3);
		bgBorI.add(jrbBorI4);
		jpBorI.add(jrbBorI1);
		jpBorI.add(jrbBorI2);
		jpBorI.add(jrbBorI3);
		jpBorI.add(jrbBorI4);
		
		ButtonGroup bgSize = new ButtonGroup();
		JRadioButton jrbSize1=new JRadioButton("small");
		JRadioButton jrbSize2=new JRadioButton("medium");
		JRadioButton jrbSize3=new JRadioButton("large");
		JRadioButton jrbSize4=new JRadioButton("extra_large");
		bgSize.add(jrbSize1);
		bgSize.add(jrbSize2);
		bgSize.add(jrbSize3);
		bgSize.add(jrbSize4);
		jpSize.add(jrbSize1);
		jpSize.add(jrbSize2);
		jpSize.add(jrbSize3);
		jpSize.add(jrbSize4);
		

        	ButtonGroup bgColor = new ButtonGroup();     

		JRadioButton jrbRed = new JRadioButton("red");
		JRadioButton jrbOrange = new JRadioButton("orange");
		JRadioButton jrbYellow = new JRadioButton("yellow");
		JRadioButton jrbGreen = new JRadioButton("green");
		JRadioButton jrbBlue = new JRadioButton("blue");
		JRadioButton jrbWhite = new JRadioButton("white");
		JRadioButton jrbGray = new JRadioButton("grey");	
		JRadioButton jrbBlack = new JRadioButton("black");
		//JRadioButton jrbBlack = new JRadioButton();

		bgColor.add(jrbRed);
		bgColor.add(jrbOrange);
		bgColor.add(jrbYellow);
		bgColor.add(jrbGreen);
		bgColor.add(jrbBlue);
		bgColor.add(jrbWhite);
		bgColor.add(jrbGray);
		bgColor.add(jrbBlack);

		jpColor.add(jrbRed);
		jpColor.add(jrbOrange);
		jpColor.add(jrbYellow);
		jpColor.add(jrbGreen);
		jpColor.add(jrbBlue);
		jpColor.add(jrbWhite);
		jpColor.add(jrbGray);
		jpColor.add(jrbBlack);
		//jrbBlack.setIcon(icon);
				
		jpLeft1.setLayout(new GridLayout(2,1));
	    	jpLeft1.add(bOpen);
	    	jpLeft1.add(jlBlank1);
	    	jpLeft2.setLayout(new GridLayout(2,1));
	    	jpLeft2.add(bScreenshot);
	    	jpLeft2.add(jlBlank2);
	    	jpLeft3.setLayout(new GridLayout(2,1));
	    	jpLeft3.add(bAddText);
	    	//jpLeft2.add(jlBlank3);
	    	jpLeft3.add(jlTextFont);
		jpLeft4.setLayout(new GridLayout(2,1));
	    	jpLeft4.add(jpFont);	     
		jpLeft4.add(jlTextBorI);
		jpLeft5.setLayout(new GridLayout(2,1)); 
		jpLeft5.add(jpBorI);	    
		jpLeft5.add(jlTextSize);
		jpLeft6.setLayout(new GridLayout(2,1)); 		
		jpLeft6.add(jpSize);   
		jpLeft6.add(jlTextColor);
		jpLeft7.setLayout(new GridLayout(1,1));
		jpLeft7.add(jpColor);
	    	jpLeft.add(jpLeft1);
	    	jpLeft.add(jpLeft2);
	    	jpLeft.add(jpLeft3);
	    	jpLeft.add(jpLeft4);
	    	jpLeft.add(jpLeft5);
	    	jpLeft.add(jpLeft6);
	    	jpLeft.add(jpLeft7);
	    

        JPanel jpDown;   
    	jpDown = new JPanel();
		this.add(jpDown, BorderLayout.SOUTH);
		bExit = new JButton("exit");
		bClear = new JButton("clear image");
		bSave = new JButton("save image");
		jpDown.add(jlBlank4);
		jpDown.add(bClear);
		jpDown.add(jlBlank5);
		jpDown.add(bSave);
		jpDown.add(jlBlank6);
	    jpDown.add(bExit);

		
	    bOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(e);
			}
		});
	    bScreenshot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Screenshot_process(e); 
			}
		});
	    bAddText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddText_process(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
        bSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {
					saveFile(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        bClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear_rImage(e);				
			}
		});	
        bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit(e);
			}
		});


      //fontjrbFont---------------------
        jrbFont1.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
              int state = e.getStateChange();
              switch (state) {
                  case ItemEvent.SELECTED:a=0;break;
                  case ItemEvent.DESELECTED:
                      break;
              }
          }
      });
        jrbFont2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED:a=1;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbFont3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED:a=2;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbFont4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED:a=3;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });

        jrbBorI1.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
              int state = e.getStateChange();
              switch (state) {
                  case ItemEvent.SELECTED:b=0;break;
                  case ItemEvent.DESELECTED:
                      break;
              }
          }
      });
        jrbBorI2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED:b=1;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbBorI3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED:b=2;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbBorI4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED:b=3;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });

        jrbSize1.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
              int state = e.getStateChange();
              switch (state) {
                  case ItemEvent.SELECTED:c=0;break;
                  case ItemEvent.DESELECTED:
                      break;
              }
          }
      });
        jrbSize2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED:c=1;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbSize3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED:c=2;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbSize4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED:c=3;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });

        jrbRed.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
              int state = e.getStateChange();
              switch (state) {
                  case ItemEvent.SELECTED: d=0;break;
                  case ItemEvent.DESELECTED:
                      break;
              }
          }
      });
        jrbOrange.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED: d=1;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbYellow.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED: d=2;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbGreen.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED: d=3;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbBlue.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
              int state = e.getStateChange();
              switch (state) {
                  case ItemEvent.SELECTED: d=4;break;
                  case ItemEvent.DESELECTED:
                      break;
              }
          }
      });
        jrbWhite.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED: d=5;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbGray.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED: d=6;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        jrbBlack.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                switch (state) {
                    case ItemEvent.SELECTED: d=7;break;
                    case ItemEvent.DESELECTED:
                        break;
                }
            }
        });
        
//-----------------------------------------------------------------------------------------------------------------
        		 
		openItem = new JMenuItem("open(O)");  
		openItem .setBackground(Color.GRAY);
		openItem.setMnemonic('O');
		//openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(e);
			}
		});
		
		//saveItem = new JMenuItem("save(S)"); 
		//saveItem.setMnemonic('S');
		//saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));
	
		saveItem = new JMenuItem("save new image(S)");
		saveItem.setMnemonic('S');
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {
					saveFile(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
				
		clearItem = new JMenuItem("clear new image(C)");
		clearItem.setMnemonic('C');
		clearItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear_rImage(e);				
			}
		});
		

		exitItem = new JMenuItem("exit(X)");
		exitItem.setMnemonic('X');
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit(e);
			}
		});
        
		/*
		addItem = new JMenuItem("Image addition(A)");   //, undoIcon);
		addItem.setMnemonic('A');
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageAdd(e);       
			}
		});
		*/
		iInvert = new JMenuItem("Invert colors(U)");  
		iInvert.setMnemonic('U');
		//undoItem.setAccelerator(KeyStroke.getKeyStroke('Z', Event.CTRL_MASK));
		iInvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invert_process(e);  
			}
		});
		
		iScale = new JMenuItem("scale");   //, redoIcon);
		//iScale.setMnemonic('D');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scale_process(e);      
			}
		});
		
		
		iRotate = new JMenuItem("rotate");   //, redoIcon);
		//iRotate.setMnemonic('R');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iRotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rotate_process(e);      
			}
		});
		

		
		iTranslate = new JMenuItem("move(T)");   //, redoIcon);
		iTranslate.setMnemonic('T');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Translate_process(e);       
			}
		});
		/*
		iMatting = new JMenuItem("crop(M)");   //, redoIcon);
		iMatting.setMnemonic('M');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iMatting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matting_process(e);       
			}
		});
		*/
		iEnforce = new JMenuItem("linear contrast transformation(K)");   //, redoIcon);
		iEnforce.setMnemonic('K');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iEnforce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enforce_process(e);      
			}
		});
		
		iEnforceLog = new JMenuItem("Logarithmic contrast transformation (L)");   //, redoIcon);
		iEnforceLog.setMnemonic('L');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iEnforceLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnforceLog_process(e);       
			}
		});
		iHisGray = new JMenuItem("Convert to grayscale image(G)");   //, redoIcon);
		iHisGray.setMnemonic('G');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iHisGray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HisGray_process(e);       
			}
		});
		iHisEqualize = new JMenuItem("Grayscale image histogram equalization(H)");   //, redoIcon);
		iHisEqualize.setMnemonic('H');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iHisEqualize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HisEqualize_process(e);       
			}
		});
		iScaleLine = new JMenuItem("Bilinear interpolation scaling");   //, redoIcon);
		//iScaleLine.setMnemonic('M');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iScaleLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScaleLine_process(e);      
			}
		});
		iScaleNext = new JMenuItem("Nearest Neighbor Scaling");   //, redoIcon);
		//iScaleNext.setMnemonic('N');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iScaleNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScaleNext_process(e);      
			}
		});
		iRotateLine = new JMenuItem("Bilinear interpolation rotation");   //, redoIcon);
		//iRotateLine.setMnemonic('V');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iRotateLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RotateLine_process(e);      
			}
		});
		iRotateNext = new JMenuItem("Nearest neighbor interpolation rotation");   //, redoIcon);
		//iRotateNext.setMnemonic('W');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iRotateNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RotateNext_process(e);      
			}
		});
		iExposure = new JMenuItem("Image fusion(A)");   //, redoIcon);
		iExposure.setMnemonic('A');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iExposure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exposure_process(e);       
			}
		});
		iAvgFilter = new JMenuItem("Arithmetic mean filter(N)");   //, redoIcon);
		iAvgFilter.setMnemonic('N');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iAvgFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvgFilter_process(e);      
			}
		});
		iGeoAvgFilter = new JMenuItem("Geometric mean filter(G)");   //, redoIcon);
		iGeoAvgFilter.setMnemonic('G');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iGeoAvgFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeoAvgFilter_process(e);      
			}
		});
		iHarmonicFilter = new JMenuItem("Harmonic mean filter(X)");   //, redoIcon);
		iHarmonicFilter.setMnemonic('X');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iHarmonicFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HarmonicFilter_process(e);      
			}
		});
		iMedFilter = new JMenuItem("Median filter(D)");   //, redoIcon);
		iMedFilter.setMnemonic('D');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iMedFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedFilter_process(e);       
			}
		});
		iMaxFilter = new JMenuItem("Maximum filter(Y)");   //, redoIcon);
		iMaxFilter.setMnemonic('Y');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iMaxFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaxFilter_process(e);      
			}
		});
		iMinFilter = new JMenuItem("Minimum filter(Z)");   //, redoIcon);
		iMinFilter.setMnemonic('Z');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iMinFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MinFilter_process(e);       
			}
		});
		iMidFilter = new JMenuItem("Midpoint filter(E)");   //, redoIcon);
		iMidFilter.setMnemonic('E');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iMidFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MidFilter_process(e);       
			}
		});
		iEdgeR = new JMenuItem("Edge detection");   //, redoIcon);
		iEdgeR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RobertsE_process(e);       
			}
		});
		iSharpeningR = new JMenuItem("Image sharpening");   //, redoIcon);
		iSharpeningR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RobertsS_process(e);       
			}
		});
		iEdgeP = new JMenuItem("Edge detection");   //, redoIcon);
		iEdgeP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrewittE_process(e);       
			}
		});
		iSharpeningP = new JMenuItem("Image sharpening");   //, redoIcon);
		iSharpeningP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrewittS_process(e);       
			}
		});
		iEdgeS = new JMenuItem("Edge detection");   //, redoIcon);
		iEdgeS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SobelE_process(e);       
			}
		});
		iSharpeningS = new JMenuItem("Image sharpening");   //, redoIcon);
		iSharpeningS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SobelS_process(e);       
			}
		});
		iEdgeL = new JMenuItem("Edge detection");   //, redoIcon);
		iEdgeL .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LaplaceE_process(e);      
			}
		});
		iSharpeningL = new JMenuItem("Image sharpening");   //, redoIcon);
		iSharpeningL .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LaplaceS_process(e);      
			}
		});
		iRGBtoHIS = new JMenuItem("RGB to HIS harmonization (Q)");   //, redoIcon);
		iRGBtoHIS.setMnemonic('Q');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iRGBtoHIS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RGBtoHIS_process(e);      
			}
		});
		iOTSU = new JMenuItem("Maximum inter-class variance algorithm(O)");   //, redoIcon);
		iOTSU.setMnemonic('O');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iOTSU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OTSU_process(e);      
			}
		});
		iBestSeg = new JMenuItem("Optimal threshold iteration algorithm(R)");   //, redoIcon);
		iBestSeg.setMnemonic('R');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iBestSeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BestSeg_process(e);      
			}
		});
		iMinusSeg = new JMenuItem("Difference imaging method(M)");   //, redoIcon);
		iMinusSeg.setMnemonic('M');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iMinusSeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MinusSeg_process(e);      
			}
		});
		/*
		iSLMedFilter = new JMenuItem("Simplify/aggregate sorting method vector median filtering");   //, redoIcon);
		iSLMedFilter.setMnemonic('1');
		//redoItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
		iSLMedFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SLMedFilter_process(e);       
			}
		});
		*/
		
//---------------------------------------------------------------------------------------------------
    	Container contentPane = getContentPane();		
    	  	
    	JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    	//JSplitPane splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);     
    	imagePanelL = new ImagePanel(imageL);
        scrollPaneL = new JScrollPane(imagePanelL); 
    	imagePanelR = new ImagePanel(imageR);
        scrollPaneR = new JScrollPane(imagePanelR);

        splitPane.setDividerLocation(435);
        splitPane.setLeftComponent(scrollPaneL);
    	splitPane.setRightComponent(scrollPaneR);
        contentPane.add(splitPane, BorderLayout.CENTER);
       // scrollPaneL.setBackground(Color.RED);
       // splitPane.setBackground(Color.RED);
       // jpright.add(contentPane);
        chooser = new JFileChooser();
      // imagePreviewer = new ImagePreviewer(chooser);
      // fileView = new ImageFileView();
	   
        /*
        bmpFilter = new ImageFileFilter("bmp", "BMP Image Files");
	    jpgFilter = new ImageFileFilter("jpg", "JPEG Compressed Image Files");
		//gifFilter = new ImageFileFilter("gif", "GIF Image Files");
		bothFilter = new ImageFileFilter(new String[] {"bmp", "jpg", "gif"}, "BMP, JPEG and GIF Image Files");
	    chooser.addChoosableFileFilter(jpgFilter);
	    chooser.addChoosableFileFilter(gifFilter);
	    chooser.addChoosableFileFilter(bmpFilter);
        chooser.addChoosableFileFilter(bothFilter);
        
        */
        //chooser.setAccessory(imagePreviewer);
      // chooser.setFileView(fileView);
        chooser.setAcceptAllFileFilterUsed(true);
         		
		mb = new JMenuBar();
		mb.setForeground(Color.BLACK);
		setJMenuBar(mb);
		
		fileMenu = new JMenu(" file ");
		
		mb.add(fileMenu);
		//fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(clearItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		simpleMenu = new JMenu(" simple ");
		mb.add(simpleMenu);	
		
		geometryMenu = new JMenu(" geometry ");
		mb.add(geometryMenu);
		
		contrastMenu = new JMenu(" contrast ");
		mb.add(contrastMenu);	
		
		equalizationMenu = new JMenu(" equalization ");
		mb.add(equalizationMenu);	
		
		filterMenu = new JMenu(" filter ");
		mb.add(filterMenu);	
		
		edgeMenu = new JMenu(" edge&sharping ");
		mb.add(edgeMenu);	
		
		imageSegMenu = new JMenu(" imageSeg ");
		mb.add(imageSegMenu);
		
		
		simpleMenu.add(iInvert);		
		simpleMenu.add(iExposure);		
		
		geometryMenu.add(iTranslate);
		geometryMenu.add(mScale);
		geometryMenu.add(mRotate);		
		
		contrastMenu.add(iEnforce);
		contrastMenu.add(iEnforceLog);
		
		equalizationMenu.add(mHistogram);
		equalizationMenu.add(iRGBtoHIS);
		
		filterMenu.add(mSpatialfilter);
		filterMenu.add(mSequencingfilter);
		
		edgeMenu.add(mRoberts);
		edgeMenu.add(mPrewitt);
		edgeMenu.add(mSobel);
		edgeMenu.add(mLaplace);
			
        	imageSegMenu.add(iOTSU);		
		imageSegMenu.add(iBestSeg);
		imageSegMenu.add(iMinusSeg);
		
		mScale.add(iScale);
		mScale.add(iScaleLine);
		mScale.add(iScaleNext);
		mRotate.add(iRotate);
		mRotate.add(iRotateLine);
		mRotate.add(iRotateNext);
		//mEnforce.add(iEnforce);
		//mEnforce.add(iEnforceLog);
		mHistogram.add(iHisGray);
		mHistogram.add(iHisEqualize);
		mSpatialfilter.add(iAvgFilter);
		mSpatialfilter.add(iGeoAvgFilter);
		mSpatialfilter.add(iHarmonicFilter);
		mSequencingfilter.add(iMinFilter);	
		mSequencingfilter.add(iMaxFilter);
		mSequencingfilter.add(iMedFilter);
		mSequencingfilter.add(iMidFilter);
		mRoberts.add(iEdgeR);	
		mRoberts.add(iSharpeningR);
		mPrewitt.add(iEdgeP);	
		mPrewitt.add(iSharpeningP);
		mSobel.add(iEdgeS);	
		mSobel.add(iSharpeningS);
		mLaplace.add(iEdgeL);	
		mLaplace.add(iSharpeningL);
//---------------------------------------------------------------------------------------------------
		
  }
       
    private void exit(WindowEvent e) {
        System.exit(0);
    } 
    void openFile(ActionEvent e) {
    	chooser.setDialogType(JFileChooser.OPEN_DIALOG);
    	if(chooser.showDialog(this, null) == JFileChooser.APPROVE_OPTION) {
    		try { imageL = ImageIO.read(chooser.getSelectedFile()); }
        	catch(Exception ex) { return ;}
        	//imagePanel.setImage(image); 
    		imagePanelL.setImage(imageL);
        	imagePanelR.repaint();	
    	}
    }
    void Screenshot_process(ActionEvent e) {
    	 hhScreenShot screenshot = new hhScreenShot();
	     GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	     gd.setFullScreenWindow(screenshot);
    }
    void AddText_process(ActionEvent e) throws IOException {
   	    //AddText text = new AddText();   	    
    	//String location=JOptionPane.showInputDialog("Please enter the horizontal and vertical coordinates of the text watermark and separate them with commas"); 	
    	//String[] str=input.split(",");
    	//int a = Integer.parseInt(str[0]);
    	//int b = Integer.parseInt(str[1]);
    	String location = JOptionPane.showInputDialog("Please enter the horizontal and vertical coordinates of the text position, separated by commas. Example: 20,40");
    	String xAndy[] = location.split(",");
    	int x = Integer.parseInt(xAndy[0]);
    	int y = Integer.parseInt(xAndy[1]);
    	
 	    String str=JOptionPane.showInputDialog("Please enter text content");
 	    imageR=hhAddText.addText(imageL,a,b,c,d,str,x,y);
 	    imagePanelR.setImage(imageR);
 	    imagePanelR.repaint();	 	        
   }
    void saveFile(ActionEvent e) throws IOException {    	
    	    	
       // /*
            chooser.setDialogType(JFileChooser.SAVE_DIALOG)	;
            if(chooser.showDialog(this, null) == JFileChooser.APPROVE_OPTION) {
        		try { ImageIO.write(imageR,"jpg",chooser.getSelectedFile()); }
            	catch(Exception ex) { return ;}      	
        	}
      //  */
    	
    	/*

    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
    	String name="pic"+sdf.format(new Date());
    	File path=FileSystemView.getFileSystemView().getHomeDirectory();
    	String format="jpg";
    	File f=new File(path+File.separator+name+"."+format);
    	ImageIO.write(imageR,format,f);
    	*/
    } 
    void clear_rImage(ActionEvent e) {
     	imagePanelR.setImage(null);
    	imagePanelR.repaint();	
    }  
    
    void exit(ActionEvent e) {
        System.exit(0);
    }

//----------------------------------------------------------------------------------------------------
    
      void imageAdd(ActionEvent e) {
    	BufferedImage image1=null;
       	chooser.setDialogType(JFileChooser.OPEN_DIALOG);
    	if(chooser.showDialog(this, null) == JFileChooser.APPROVE_OPTION) {
    		try { image1 = ImageIO.read(chooser.getSelectedFile()); }
        	catch(Exception ex) { 
        		return ;
        		}
    	}  	
      	imageR=aaEditImage.image_add(imageL,image1,0.5);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();
    }    
    void Invert_process(ActionEvent e) {
      	imageR=aaInvert.image_invert(imageL);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();  	   	
    }  
    void Scale_process(ActionEvent e) {
    	String input=JOptionPane.showInputDialog("Please enter the scaling ratio"); 
		 double a = Double.parseDouble(input);
    	imageR=bbScale.image_scale(imageL,a);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();   	
    }
    void Rotate_process(ActionEvent e) {
		String input=JOptionPane.showInputDialog("Please enter the rotation angle"); 
		int a = Integer.parseInt(input);
    	imageR=bbRotate.image_rotate(imageL,a);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint(); 	
    }
    void Translate_process(ActionEvent e) {
    	String input=JOptionPane.showInputDialog("Please enter the x and y values ​​of the translation separated by commas");     	
    	String[] str=input.split(",");
    	int a = Integer.parseInt(str[0]);
    	int b = Integer.parseInt(str[1]);
    	imageR=bbTranslate.image_translate(imageL,a,b);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();	
    }
    void Enforce_process(ActionEvent e) {
    	imageR=ccEnforce.image_enforce(imageL);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();   	
    }
    void EnforceLog_process(ActionEvent e) {
    	imageR=ccEnforceLog.image_enforcelog(imageL);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();
    	
    }
    void HisGray_process(ActionEvent e) {
    	imageR=ddHisGray.image_hisgray(imageL);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();
    }
    void HisEqualize_process(ActionEvent e) {  	
	    ddHistogram his = new ddHistogram(imageL);
	    his.setTitle("直方图");
	    his.setSize(800, 600);
	    his.setLocationRelativeTo(null);
	    his.setVisible(true);
    }
    void ScaleLine_process(ActionEvent e) {
    	String input=JOptionPane.showInputDialog("Please enter the scaling ratio"); 
		double a = Double.parseDouble(input);  	
    	imageR=bbScaleLine.image_scaleline(imageL,a);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();  	
    }
    void ScaleNext_process(ActionEvent e) {
    	String input=JOptionPane.showInputDialog("Please enter the scaling ratio"); 
		double a = Double.parseDouble(input);  	
    	imageR=bbScaleNext.image_scalenext(imageL,a);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();
    }
    void RotateLine_process(ActionEvent e) {
    	String input=JOptionPane.showInputDialog("Please enter the rotation angle"); 
		double a = Double.parseDouble(input);  	
    	imageR=bbRotateLine.image_rotateline(imageL,a);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();  	
    }
    void RotateNext_process(ActionEvent e) {
    	String input=JOptionPane.showInputDialog("Please enter the rotation angle"); 
		double a = Double.parseDouble(input);  	
    	imageR=bbRotateNext.image_rotatenext(imageL,a);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint(); 	
    }
    void Exposure_process(ActionEvent e) {    	
         BufferedImage image1=null;    	
       	chooser.setDialogType(JFileChooser.OPEN_DIALOG);
    	if(chooser.showDialog(this, null) == JFileChooser.APPROVE_OPTION) {
    		try { image1 = ImageIO.read(chooser.getSelectedFile()); }
        	catch(Exception ex) { return ;}
    	}           	    	
    	String input=JOptionPane.showInputDialog("Please enter the exposure factor for the first image"); 
		double a = Double.parseDouble(input);  	
    	imageR=aaEditImage.image_add(imageL,image1,a);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();   	
   }
    void AvgFilter_process(ActionEvent e) {    	
     	imageR=eeAvgFilter.image_avgfilter(imageL);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();   	
   }
    void GeoAvgFilter_process(ActionEvent e) {    	
       	imageR=eeGeoAvgFilter.image_geoavgfilter(imageL);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();  
   }
    void HarmonicFilter_process(ActionEvent e) {    	
        imageR=eeHarmonicFilter.image_harmonicfilter(imageL);          
        imagePanelR.setImage(imageR);
        imagePanelR.repaint();   	
   }
    void MedFilter_process(ActionEvent e) {    	
        imageR=eeMedFilter.image_medfilter(imageL,1);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();   	
   }
    void MaxFilter_process(ActionEvent e) {    	
        imageR=eeMedFilter.image_medfilter(imageL,2);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
   }
    void MinFilter_process(ActionEvent e) {    	
        imageR=eeMedFilter.image_medfilter(imageL,3);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
   }
    void MidFilter_process(ActionEvent e) {    	
        imageR=eeMedFilter.image_medfilter(imageL,4);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
   }
    void RobertsE_process(ActionEvent e) {  
    	imageR=ffRoberts.image_roberts(imageL,1);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
   }
    void RobertsS_process(ActionEvent e) { 
        imageR=ffRoberts.image_roberts(imageL,2);
        imagePanelR.setImage(imageR);
        imagePanelR.repaint();   	
    }
    void PrewittE_process(ActionEvent e) {
        imageR=ffPrewitt.image_prewitt(imageL,1);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
    }
     void PrewittS_process(ActionEvent e) {    	
        imageR=ffPrewitt.image_prewitt(imageL,2);
        imagePanelR.setImage(imageR);
        imagePanelR.repaint();   	
    }
     void SobelE_process(ActionEvent e) {    	
        imageR=ffSobel.image_sobel(imageL,1);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
    }
      void SobelS_process(ActionEvent e) {    	
        imageR=ffSobel.image_sobel(imageL,2);
        imagePanelR.setImage(imageR);
        imagePanelR.repaint();   	
    }
     void LaplaceE_process(ActionEvent e) {    	
        imageR=ffLaplace.image_laplace(imageL,1);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
   } 
      void LaplaceS_process(ActionEvent e) {    	
        imageR=ffLaplace.image_laplace(imageL,2);
        imagePanelR.setImage(imageR);
        imagePanelR.repaint();   	
   }     
    void RGBtoHIS_process(ActionEvent e) {    	
    	imageR=ddRGBtoHIS.image_rgbtohis(imageL);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
   }
    void OTSU_process(ActionEvent e) {    	
        imageR=ggOtsuSeg.image_otsu(imageL);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
   }
    void BestSeg_process(ActionEvent e) {    	
        imageR=ggBestSeg.image_bestseg(imageL);
       	imagePanelR.setImage(imageR);
       	imagePanelR.repaint();   	
   }
    void MinusSeg_process(ActionEvent e) {      	
        BufferedImage image1=null;    	
       	chooser.setDialogType(JFileChooser.OPEN_DIALOG);
    	if(chooser.showDialog(this, null) == JFileChooser.APPROVE_OPTION) {
    		try { image1 = ImageIO.read(chooser.getSelectedFile()); }
        	catch(Exception ex) { 
        		return ;
        		}
    	}
      	imageR=ggMinusSeg.image_minusseg(imageL,image1);
    	imagePanelR.setImage(imageR);
    	imagePanelR.repaint();
   }  
}