package edu.theobird;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    static JTextField messageField = new JTextField(33);
    static JButton send = new JButton("Send");
    static JPanel container = new JPanel();
    static JScrollPane scrollPane = new JScrollPane();


    public Interface() {
        super("Chat Room");
        setSize(500, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));


        scrollPane.setViewportView(container);

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // gb layout for scrollpane
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(scrollPane, gbc);



        buttonPanel.add(messageField);
        buttonPanel.add(send);

        // gb layout for buttonpanel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(buttonPanel, gbc);



        // Add mainPanel to the frame
        add(mainPanel);
        setVisible(true);
    }



}
