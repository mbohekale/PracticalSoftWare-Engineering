package javaconnect4;


import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Connect4UI {
    JFrame fr;
    JPanel p;
    int initialSize;
    final BoardDrawing board;
    final GameState state;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton reset;
    
  public Connect4UI(){
      state=new GameState();
      board=new BoardDrawing(state,initialSize);
      button1 = new JButton("1");
      button1.addActionListener(
              new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              state.move(1);
              board.repaint();
          }
      });
      button2 = new JButton("2");
      button2.addActionListener(
              new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              state.move(2);
              board.repaint();
          }
      });
      button3 = new JButton("3");
      button3.addActionListener(
              new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              state.move(3);
              board.repaint();
          }
      });
      button4 = new JButton("4");
      button4.addActionListener(
              new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              state.move(4);
              board.repaint();
          }
      });
      button5 = new JButton("5");
      button5.addActionListener(
              new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              state.move(5);
              board.repaint();
          }
      });
      button6 = new JButton("6");
      button6.addActionListener(
              new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              state.move(6);
              board.repaint();
          }
      });
      button7 = new JButton("7");
      button7.addActionListener(
              new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              state.move(7);
              board.repaint();
          }
      });
      reset = new JButton("Reset");
      reset.addActionListener(
              new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              state.restart();
              board.repaint();
          }
      });
      p=new JPanel();
      p.add(board);
      p.add(button1);
      p.add(button2);
      p.add(button3);
      p.add(button4);
      p.add(button5);
      p.add(button6);
      p.add(button7);
      p.add(reset);
        initFrame();
    }
  private void initFrame() {
        fr= new JFrame("Connect4");
        fr.setSize(600, 600);
        fr.add(board,BorderLayout.CENTER);
        fr.add(p , BorderLayout.SOUTH);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        //fr.pack();
        fr.setVisible(true);
    }

   
    
}
