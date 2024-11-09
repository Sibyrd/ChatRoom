package edu.theobird;

import javax.swing.*;
import java.awt.*;

import static edu.theobird.Interface.container;
import static edu.theobird.Interface.scrollPane;

public class MessageManager {
    public static void createMessage(String msg) {
        JPanel messagebox = new JPanel();
        messagebox.setLayout(new BoxLayout(messagebox, BoxLayout.Y_AXIS));

        JTextArea message = new JTextArea(msg);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setEditable(false);
        message.setOpaque(false);
        message.setBackground(null);

        message.setSize(container.getWidth() - 20, Short.MAX_VALUE);
        Dimension preferredSize = message.getPreferredSize();
        message.setPreferredSize(new Dimension(container.getWidth() - 20, preferredSize.height));
        message.setMaximumSize(new Dimension(container.getWidth() - 20, preferredSize.height));

        messagebox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        messagebox.setBackground(Color.decode("#dbdbdb"));
        messagebox.setAlignmentX(Component.LEFT_ALIGNMENT);

        messagebox.add(message);

        container.add(messagebox);
        container.add(Box.createRigidArea(new Dimension(0, 5)));
        container.revalidate();
        container.repaint();

        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
    }
}
