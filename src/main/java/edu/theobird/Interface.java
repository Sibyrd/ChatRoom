package edu.theobird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Interface extends JFrame {
    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JTextField username = new JTextField(5);
    JTextField messageField = new JTextField(25);
    JButton send = new JButton("Send");
    JPanel container = new JPanel();
    JScrollPane scrollPane = new JScrollPane();


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

        username.setText("Username");
        username.setForeground(Color.GRAY);
        messageField.setText("Message");
        messageField.setForeground(Color.GRAY);


        buttonPanel.add(username);
        buttonPanel.add(messageField);
        buttonPanel.add(send);

        // gb layout for buttonpanel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(buttonPanel, gbc);

        send.addActionListener(e -> {
            JPanel messagebox = new JPanel();
            JLabel message = new JLabel("test message");
            messagebox.setMaximumSize(new Dimension(getSize().width, 50));
            messagebox.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            messagebox.setBackground(Color.decode("#dbdbdb"));
            messagebox.setAlignmentX(Component.LEFT_ALIGNMENT);

            messagebox.add(message);



            container.add(messagebox);
            container.add(Box.createRigidArea(new Dimension(0, 5)));
            container.revalidate();
            container.repaint();

            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        });

        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (username.getText().equals("Username")) {
                    username.setText("");
                    username.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (username.getText().isEmpty()) {
                    username.setText("Username");
                    username.setForeground(Color.GRAY);
                }
            }
        });

        messageField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (messageField.getText().equals("Message")) {
                    messageField.setText("");
                    messageField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (messageField.getText().isEmpty()) {
                    messageField.setText("Message");
                    messageField.setForeground(Color.GRAY);
                }
            }
        });


        // Add mainPanel to the frame
        add(mainPanel);
        setVisible(true);
    }



}
