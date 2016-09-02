package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;


//****************************************************************************
//
//   Main Entry Point
//
//****************************************************************************

public class Spirograph extends JFrame 
{

    private static final long serialVersionUID = 1L;

    final static int SCREEN_WIDTH = 640;
    final static int SCREEN_HEIGHT = 480;
    
    public Spirograph() 
    {

        add( new Spyro() );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
        setLocationRelativeTo( null );
        setTitle( "Spyro" );
        setResizable( false );
        setVisible( true );
        
    }

    public static void main(String[] args) 
    {
        new Spirograph();
    }
}


class Spyro extends JPanel 
{
    private static final long serialVersionUID = 1L;

    private double theta1 = 0;      //\
    private double theta2 = 5;      // \
    private double phi1 = 8.0;      //  \  try to play with the
    private double phi2 = 1.5;      //  /  values here
    private double radius1 = 150;   // /
    private double radius2 = 230;   ///
    private double x;
    private double y;
    
    public Spyro() 
    {
        x = Spirograph.SCREEN_WIDTH/2;
        y = Spirograph.SCREEN_HEIGHT/2;
    }
    public void paint(Graphics g)
    {
      super.paint(g);
      
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.RED);
      RenderingHints rh =
              new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                 RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);

        g2.setRenderingHints(rh);

      theta1 = 0;
      theta2 = 0;
      int max = 600;
      for( int i = 0; i < max; i++ )
      {
          theta1 += phi1;
          theta2 += phi2;
          int ax1 = (int) (x + Math.cos(theta1*Math.PI/180.0) * radius2); 
          int ay1 = (int) (y + Math.sin(theta1*Math.PI/180.0) * radius1); 
          int ax2 = (int) (x + Math.cos(theta2*Math.PI/180.0) * radius1); 
          int ay2 = (int) (y + Math.sin(theta2*Math.PI/180.0) * radius2); 
          g2.drawLine(ax1, ay1, ax2, ay2);
          
      }
      
      g2.setColor(Color.BLUE);
      g2.drawString( " Anya Therese B. Lope ", 10, 10 );

    }
    
}

