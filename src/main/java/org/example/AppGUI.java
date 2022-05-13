package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AppGUI extends JFrame{
    private JPanel mainPanel;
    private JTextField srcTextField;
    private JTextField dstTextField;
    private JButton submitBtn;
    private JTextField numOfPagesTextField;

    private String srcFilePath, dstFilePath;
    private int numOfPages;

    public AppGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                srcFilePath = srcTextField.getText().trim();
                dstFilePath = dstTextField.getText().trim();
                numOfPages = Integer.parseInt(numOfPagesTextField.getText());
                try {
                    Launcher launcher = new Launcher(srcFilePath, dstFilePath, numOfPages);
                    launcher.activateSequence();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new AppGUI("HSBC Bank Statement Converter");
        frame.setVisible(true);


    }

}
