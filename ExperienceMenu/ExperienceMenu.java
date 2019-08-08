import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ExperienceMenu
{
    private JFrame frame;
    private JMenuBar menuBar;
    private JPanel contentPane;
    
    // radio buttons and button group
    private JRadioButton noneButton;
    private JRadioButton littleButton;
    private JRadioButton someButton;
    private JRadioButton moderateButton;
    private JRadioButton quiteABitButton;
    private JRadioButton lotsButton;
    private ButtonGroup experienceButtonGroup;
    
    // check boxes
    private JCheckBox javaBox;
    private JCheckBox scratchBox;
    private JCheckBox processingBox;
    private JCheckBox cPlusPlusBox;
    private JCheckBox pythonBox;
    private JCheckBox otherBox;
    
    // courses check box
    private JCheckBox algebraOneBox;
    private JCheckBox geometryBox;
    private JCheckBox algebraTwoBox;
    private JCheckBox compSciFundamentalsBox;
    private JCheckBox compSciOneBox;
    private JCheckBox compSciTwoBox;
    private JCheckBox apCompSciBox;
    private JCheckBox apPrinciplesBox;
    
    // text fields
    private JTextField classPeriodText;
    private JTextField computerNumberText;
    private JTextField nameText;
    private JTextField courseText;
    private JTextField phoneText;

    public static void main (String[] args) 
    {
      ExperienceMenu gui = new ExperienceMenu();
      gui.start();
    }

    public void start() 
    {
      frame = new JFrame("Computer Science Experience");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container contentPane = frame.getContentPane();
      makeMenus(); 
      makeContent();
           
      frame.pack();
      frame.setVisible(true);
    }
    
    public void makeMenus()
    {
      makeMenuBar();
      makeFileMenu();
      makeHelpMenu();
    }
    
    private void makeMenuBar()
    {
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
    }            
    
    private void makeFileMenu()
    {
        JMenu menu;
        JMenuItem menuItem;
        
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);
        
        menuItem = new JMenuItem("Reset");
        menuItem.setMnemonic(KeyEvent.VK_R);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
                               Event.CTRL_MASK));
        menuItem.addActionListener(new resetListener());
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Save");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                               Event.CTRL_MASK));
        menuItem.addActionListener(new saveListener());
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                               Event.CTRL_MASK));
        menuItem.addActionListener(new exitListener());
        menu.add(menuItem);
    }
    
    private void makeHelpMenu()
    {
        JMenu menu;
        JMenuItem menuItem;
        
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(menu);
        
        menuItem = new JMenuItem("About Computer Science Experience");
        menuItem.setMnemonic(KeyEvent.VK_A);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                               Event.CTRL_MASK));
        menuItem.addActionListener(new aboutListener());
        menu.add(menuItem);
    }
    private void makeContent()
    {
       contentPane = (JPanel)frame.getContentPane();
       contentPane.setLayout(new BorderLayout(6,6)); 
       
       makeNorthRegion();
       makeWestRegion();
       makeCenterRegion();
       makeEastRegion();
       makeSouthRegion();
    }
    
    private void makeNorthRegion() 
    {
        JLabel imgLabel = new JLabel(new ImageIcon("CompSci.jpg"), JLabel.CENTER);
        contentPane.add(imgLabel, BorderLayout.NORTH);
    }
      
    private void makeWestRegion()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Programming Experience?"));
        panel.setPreferredSize(new Dimension(175,180));
        
        experienceButtonGroup = new ButtonGroup();
        
        noneButton = new JRadioButton("None", true);
        experienceButtonGroup.add(noneButton);
        panel.add(noneButton);
        
        littleButton = new JRadioButton("Little", true);
        experienceButtonGroup.add(littleButton);
        panel.add(littleButton);
        
        someButton = new JRadioButton("Some", true);
        experienceButtonGroup.add(someButton);
        panel.add(someButton);
        
        moderateButton = new JRadioButton("Moderate", true);
        experienceButtonGroup.add(moderateButton);
        panel.add(moderateButton);
        
        quiteABitButton = new JRadioButton("Quite a Bit", true);
        experienceButtonGroup.add(quiteABitButton);
        panel.add(quiteABitButton);
        
        lotsButton = new JRadioButton("Lots", true);
        experienceButtonGroup.add(lotsButton);
        panel.add(lotsButton);
        
        contentPane.add(panel, BorderLayout.WEST);
    }
    
    private void makeCenterRegion()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Select all courses completed"));
        
        algebraOneBox = new JCheckBox("Algebra 1", false);
        panel.add(algebraOneBox);
        
        geometryBox = new JCheckBox("Geometry", false);
        panel.add(geometryBox);
        
        algebraTwoBox = new JCheckBox("Algebra 2", false);
        panel.add(algebraTwoBox);
        
        compSciFundamentalsBox = new JCheckBox("Comp. Sci. Fundamentals", false);
        panel.add(compSciFundamentalsBox);
        
        compSciOneBox = new JCheckBox("Comp. Science 1", false);
        panel.add(compSciOneBox);
        
        compSciTwoBox = new JCheckBox("Comp. Science 2", false);
        panel.add(compSciTwoBox);
        
        apCompSciBox = new JCheckBox("AP Computer Science", false);
        panel.add(apCompSciBox);
        
        apPrinciplesBox = new JCheckBox("Comp. Sci. Principles", false);
        panel.add(apPrinciplesBox);
        
        contentPane.add(panel, BorderLayout.CENTER);
    }
    
    private void makeEastRegion()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(175,180));
        panel.setBorder(BorderFactory.createTitledBorder("Select all languages used"));
        
        javaBox = new JCheckBox("Java", false);
        panel.add(javaBox);
        
        scratchBox = new JCheckBox("Scratch", false);
        panel.add(scratchBox);
        
        processingBox = new JCheckBox("Processing", false);
        panel.add(processingBox);
        
        cPlusPlusBox = new JCheckBox("C++", false);
        panel.add(cPlusPlusBox);
        
        pythonBox = new JCheckBox("Python", false);
        panel.add(pythonBox);
        
        otherBox = new JCheckBox("Other", false);
        panel.add(otherBox);
        
        contentPane.add(panel, BorderLayout.EAST);
    }
    
    private void makeSouthRegion()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Student Information"));
    
        JPanel smallPanel = new JPanel();   //label subpanel
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.Y_AXIS));
        smallPanel.add(new JLabel("Name:"));
        smallPanel.add(new JLabel("Course:"));
        smallPanel.add(new JLabel("Phone Number:"));
        smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        panel.add(smallPanel);
        
        smallPanel = new JPanel();  //text input subpannel
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.Y_AXIS));
        nameText = new JTextField();
        courseText = new JTextField();
        phoneText = new JTextField();
        smallPanel.add(nameText);
        smallPanel.add(courseText);
        smallPanel.add(phoneText);
        smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        panel.add(smallPanel);
        
        contentPane.add(panel, BorderLayout.SOUTH);
    }
         
    private class resetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            noneButton.setSelected(true); 
            javaBox.setSelected(false);
            scratchBox.setSelected(false);
            processingBox.setSelected(false);
            cPlusPlusBox.setSelected(false);
            pythonBox.setSelected(false);
            otherBox.setSelected(false);
            algebraOneBox.setSelected(false);
            geometryBox.setSelected(false);
            algebraTwoBox.setSelected(false);
            compSciFundamentalsBox.setSelected(false);
            compSciOneBox.setSelected(false);
            compSciTwoBox.setSelected(false);
            apCompSciBox.setSelected(false);
            apPrinciplesBox.setSelected(false);
            nameText.setText("");
            courseText.setText("");
            phoneText.setText("");
        }
    }
       
    private class saveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String studentInfo = "****Student Information****\r\n"+
                "===========================\r\nContact Info\r\n";
            //Student Info First
            if (nameText.getText().isEmpty() ||
               courseText.getText().isEmpty() ||
               phoneText.getText().isEmpty())
               JOptionPane.showMessageDialog(frame, 
               "Information fields may not be empty.",
               "Information Error", 
               JOptionPane.ERROR_MESSAGE);
            else
            {
               studentInfo += "\tName: \t" + nameText.getText() + "\r\n";
               studentInfo += "\tCourse: \t" + courseText.getText() + "\r\n";
               studentInfo += "\tPhone:\t" + phoneText.getText() + "\r\n";
            }
            
            // Now Experience
            studentInfo += "Prior Programming Experience: \r\n";
            if (noneButton.isSelected())
               studentInfo +="\tNo Experience\r\n";
            else if (littleButton.isSelected())
                studentInfo +="\tLittle Experience\r\n";
            else if (someButton.isSelected())
                studentInfo +="\tSome Experience\r\n";
            else if (moderateButton.isSelected())
                studentInfo +="\tModerate Experience\r\n";
            else if (quiteABitButton.isSelected())
                studentInfo +="\tQuite A Bit of Experience\r\n";
            else if (lotsButton.isSelected())
                studentInfo +="\tLots of Experice\r\n";
            else
                JOptionPane.showMessageDialog(frame, 
                    "You must select an experience level!",
                     "Experience Error", 
                     JOptionPane.ERROR_MESSAGE);
                     
            // Courses Taken
            studentInfo += "Courses Taken: \r\n";
            if (algebraOneBox.isSelected())
                studentInfo += "\tAlgebra 1\r\n";
            if (geometryBox.isSelected())
                studentInfo += "\tGeometry\r\n";
            if (algebraTwoBox.isSelected())
                studentInfo += "\tAlgebra 2\r\n";
            if (compSciFundamentalsBox.isSelected())
                studentInfo += "\tComputer Science Fundamentals\r\n";
            if (compSciOneBox.isSelected())
                studentInfo += "\tComputer Science 1\r\n";
            if (compSciTwoBox.isSelected())
                studentInfo += "\tComputer Science 2\r\n";
            if (apPrinciplesBox.isSelected())
                studentInfo += "\tAP Principles\r\n";
                
            // Languages Known
            studentInfo += "Languages Known: \r\n";
            if (javaBox.isSelected())
                studentInfo += "\tJava\r\n";
            if (scratchBox.isSelected())
                studentInfo += "\tScratch\r\n";
            if (processingBox.isSelected())
                studentInfo += "\tProcessing\r\n";
            if (cPlusPlusBox.isSelected())
                studentInfo += "\tC++\r\n";
            if (pythonBox.isSelected())
                studentInfo += "\tPython\r\n";
            if (otherBox.isSelected())
                studentInfo += "\tOther\r\n";
                
            //now write the file
            try
            {
               FileWriter fileWriter = new FileWriter ("StudentInfo.txt", true);
               PrintWriter outputFile = new PrintWriter(fileWriter);
               outputFile.print(studentInfo);
               outputFile.close();
            }
            catch(IOException ioe)
            {
               System.out.println("\r\n*** I/O Error ***\r\n" + ioe);
            }
        }
    }
    
    private class aboutListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String aboutString = "";
            
            aboutString = "Computer Science Experience Survey \r\n \r\n " +
                "Version 1.0 \r\n" +
                "Build B20190706-001 \r\n\r\n" +
                "(c) Copyright Irene McCartney 2019 \r\n" +
                "All right reserved \r\n\r\n";
            JOptionPane.showMessageDialog(frame, 
                    aboutString, 
                    "About Computer Science Experience", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private class exitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    
}