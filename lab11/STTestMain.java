import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class STTestMain extends JFrame{
    STDrawingArea drawingArea = new STDrawingArea();
    
    public STTestMain()
    {
        //JFrame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Spelling Trainer");
        setResizable(false);
        setVisible(true);


        //Panel of buttons
        JPanel buttonContainer = new JPanel();
        JButton btnRedPen = new JButton("Red Pen");
        JButton btnGreenPen = new JButton("Green Pen");
        JButton btnBluePen = new JButton("Blue Pen");
        JButton btnClear = new JButton("Clear");
        buttonContainer.add(btnRedPen);
        buttonContainer.add(btnGreenPen);
        buttonContainer.add(btnBluePen);
        buttonContainer.add(btnClear);
        
        //Drawing Area instantiation


        KeyListener keyListener = new KeyListener(){

            public void keyPressed(KeyEvent e){


                Boolean toggleRed = false;
                Boolean toggleBlue = false;
                Boolean toggleGreen = false;

                Color red = Color.RED;
                Color green = Color.GREEN;
                Color blue = Color.BLUE;
                Color redGreen = new Color(100, 100, 0);
                Color redBlue = new Color(100, 0, 100);
                Color blueGreen = new Color(0, 100, 100);
                Color all = new Color(100, 100, 100);

                char ch = 'A';
                
                while(true){
                    ch = e.getKeyChar();
                    if (ch == 'R') {
                        toggleRed = !toggleRed;
                    }

                    if (ch == 'G') {
                        toggleGreen = !toggleGreen; 
                    }

                    if (ch == 'B') {
                        toggleBlue = !toggleBlue;
                    }
                    if (toggleRed && toggleBlue && toggleGreen) {
                        setColor(all);
                    }
                    else if (toggleRed && !toggleBlue && toggleGreen) {
                        setColor(redGreen);
                    }
                    else if (toggleRed && toggleBlue && !toggleGreen) {
                        setColor(redBlue);
                    }
                    else if (!toggleRed && toggleBlue && toggleGreen) {
                        setColor(blueGreen);
                    }
                    else if (toggleRed && !toggleBlue && !toggleGreen) {
                        setColor(red);
                    }
                    else if (!toggleRed && toggleBlue && !toggleGreen) {
                        setColor(blue);
                    }
                    else if (!toggleRed && !toggleBlue && toggleGreen) {
                        setColor(green);
                    }
                    else {
                        setColor(Color.BLACK);
                    }
                }

                
            }

            public void keyReleased(KeyEvent e){}

            public void keyTyped(KeyEvent e){}
        };
       

        addKeyListener(keyListener);
        //Adding things to JFrame
        getContentPane().add(drawingArea);
        getContentPane().add(buttonContainer,BorderLayout.PAGE_END);
        pack();


        //button listener
        btnRedPen.addActionListener(new ActionListener() {

            Boolean toggleRed = false;
            Boolean toggleBlue = false;
            Boolean toggleGreen = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                toggleRed = !toggleRed;

                if (toggleRed) {
                    drawingArea.setCurrentColor(Color.RED);
                    btnRedPen.setForeground(Color.RED);
                    btnBluePen.setForeground(Color.BLACK);
                    btnGreenPen.setForeground(Color.BLACK);
                }else{
                    drawingArea.setCurrentColor(Color.BLACK);
                    btnRedPen.setForeground(Color.BLACK);
                }
            }
        });

        btnGreenPen.addActionListener(new ActionListener() {

            Boolean toggleRed = false;
            Boolean toggleBlue = false;
            Boolean toggleGreen = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                toggleGreen = !toggleGreen;   

                if (toggleGreen) {
                    drawingArea.setCurrentColor(Color.GREEN);
                    btnGreenPen.setForeground(Color.GREEN);
                    btnBluePen.setForeground(Color.BLACK);
                    btnRedPen.setForeground(Color.BLACK);
                }else{
                    drawingArea.setCurrentColor(Color.BLACK);
                    btnGreenPen.setForeground(Color.BLACK);
                }
            }
        });

        btnBluePen.addActionListener(new ActionListener() {

            Boolean toggleRed = false;
            Boolean toggleBlue = false;
            Boolean toggleGreen = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
               
                toggleBlue = !toggleBlue;

                if (toggleBlue) {
                    drawingArea.setCurrentColor(Color.BLUE);
                    btnBluePen.setForeground(Color.BLUE);
                    btnRedPen.setForeground(Color.BLACK);
                    btnGreenPen.setForeground(Color.BLACK);
                }else{
                    drawingArea.setCurrentColor(Color.BLACK);
                    btnBluePen.setForeground(Color.BLACK);
                }
                
            }
        });

        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                drawingArea.clearDrawings();
            }
        });





    }

    public void setColor(Color color){
        drawingArea.setCurrentColor(color);
    }


    public static void main(String args[])
    {
        STTestMain test = new STTestMain();
    }

    

}
