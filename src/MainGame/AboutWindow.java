package MainGame;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class AboutWindow extends JPanel {
    private JFrame windowFrame = new JFrame("About Game");
    private JScrollPane textScrollPane;
    private JTextArea textArea;
    private IconButton closeButton;

    public AboutWindow(){
        double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        windowFrame.setLocation((int)(screenWidth/2) - 180, (int)(screenHeight/2) - 240);
        windowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        windowFrame.setResizable(false);
        windowFrame.setSize(360,480);
        windowFrame.setContentPane(this);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Assets/README_LB.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        String text = null;
        String finalText = "";
        try {
            while ((text = reader.readLine()) != null) {
                finalText += text + "\n";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        textArea = new JTextArea(finalText);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);
        //textArea.setSize(new Dimension(360-40, 480-60));

        textScrollPane = new JScrollPane(textArea, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
        textScrollPane.setMaximumSize(new Dimension(360, 480-80));
        textScrollPane.setMinimumSize(new Dimension(360, 480-80));
        textScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        textScrollPane.setBorder(BorderFactory.createEmptyBorder());

        try {
            closeButton = new CloseButton(this, windowFrame);
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeButton.setMaximumSize(new Dimension(64,64));
        closeButton.setMinimumSize(new Dimension(64,64));
        closeButton.setPreferredSize(new Dimension(64,64));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(textScrollPane);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(Box.createRigidArea(new Dimension(windowFrame.getWidth()/2 - 48, 64)));
        buttonPanel.add(closeButton);

        this.setLayout(new BorderLayout());
        this.add(textPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.PAGE_END);
        windowFrame.setVisible(true);
    }
}
