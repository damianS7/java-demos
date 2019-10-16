package demos.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class ChatUI {
    private JFrame frame;
    private JTextField search;
    
    public ChatUI() {
        initComponents();
    }
    
    private void initComponents() {
        setLookAndFeel();
        frame = new JFrame();
        

        frame.setSize(900, 600);
        frame.setTitle("Amazing UI");
        frame.setResizable(false);
        frame.setUndecorated(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        
        JPanel panelLeft = new JPanel();
        panelLeft.setBounds(0, 0, 48, 600);
        panelLeft.setBackground(new Color(50, 50, 55));
        frame.getContentPane().add(panelLeft);
        panelLeft.setLayout(new MigLayout("", "[32px,grow,fill]", "[32px,grow][grow][32px,grow][grow][44.00,grow][292.00,grow]"));
        
        JPanel panelCenter = new JPanel();
        panelCenter.setBounds(48, 0, 240, 600);
        panelCenter.setBackground(new Color(67, 69, 83));
        frame.getContentPane().add(panelCenter);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setViewportBorder(null);
        scrollPane.setBounds(6, 51, 234, 549);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        
        JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setModel(new AbstractListModel() {
            String[] values = new String[] {"sdfsdfsdf", "sdfsdf", "sdf", "sdf", "sdf", "sdf", "sdf", "sdfsdfsdfsdf", "sdfsdf", "sdf", "sdf", "sdf", "sdf", "sdf", "sdfsdfsdfsdf", "sdfsdf", "sdf", "sdf", "sdf", "sdf", "sdf", "sdfsdfsdfsdf", "sdfsdf", "sdf", "sdf", "sdf", "sdf", "sdf", "sdf", "sdfsdf", "sdf", "sdf", "dsf", "d", "fssd", "fdsf", "dsf", "dsf", "dsf", "dsf"};
            public int getSize() {
                return values.length;
            }
            public Object getElementAt(int index) {
                return values[index];
            }
        });
        list.setBackground(new Color(0, 0, 0, 0));
        scrollPane.setViewportView(list);
        
        search = new JTextField();
        
        search.setBounds(12, 6, 216, 39);
        search.setBackground(new Color(108, 104, 110)); // 696c75
        //search.setBorder(new LineBorder(Color.BLUE, 1, true));
        search.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelCenter.setLayout(null);
        panelCenter.add(scrollPane);
        
        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(ChatUI.class.getResource("/images/36x36-search.png")));
        label_1.setBounds(192, 6, 36, 39);
        panelCenter.add(label_1);
        panelCenter.add(search);
        
        JPanel panelRight = new JPanel();
        panelRight.setBounds(288, 0, 612, 600);
        panelRight.setBackground(new Color(245, 245, 245));
        frame.getContentPane().add(panelRight);
        panelRight.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 612, 73);
        panel_2.setBackground(new Color(245, 245, 245));
        panelRight.add(panel_2);
        panel_2.setLayout(null);
        
        JButton button = new JButton("");
        button.setIcon(new ImageIcon(ChatUI.class.getResource("/images/36x36-close.png")));
        button.setBounds(558, 0, 54, 53);
        panel_2.add(button);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        //button.setBorderPainted(false);
        //button.setRolloverEnabled(false);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        JLabel lblJavaChat = new JLabel();
        lblJavaChat.setIcon(new ImageIcon(ChatUI.class.getResource("/images/128x128-avatar.png")));
        lblJavaChat.setFont(new Font("Expansiva", Font.BOLD, 36));
        lblJavaChat.setBounds(12, 12, 128, 49);
        panel_2.add(lblJavaChat);
        
        JLabel label = new JLabel("Chatting with Johanna");
        label.setFont(new Font("Ubuntu", Font.BOLD, 18));
        label.setBounds(152, 12, 388, 33);
        panel_2.add(label);
        
        JLabel lblNewLabel = new JLabel("last message 21:36");
        lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        lblNewLabel.setForeground(Color.GRAY);
        lblNewLabel.setBounds(162, 40, 378, 16);
        panel_2.add(lblNewLabel);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setBounds(10, 77, 590, 432);
        panelRight.add(scrollPane_1);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane_1.setViewportView(textArea);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 515, 588, 73);
        panelRight.add(panel);
        panel.setLayout(null);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(0, 0, 471, 73);
        panel.add(scrollPane_2);
        
        JTextArea inputArea = new JTextArea();
        inputArea.setBorder(new EmptyBorder(15, 15, 15, 15));
        scrollPane_2.setViewportView(inputArea);
        
        JButton btnNewButton = new JButton("SEND");
        btnNewButton.setBorder(new EmptyBorder(5,5,5,5));
        btnNewButton.setIcon(new ImageIcon(ChatUI.class.getResource("/images/36x36-send.png")));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(483, 0, 105, 73);
        panel.add(btnNewButton);
        
        // Menu
        JButton buttonMenu = new JButton("");
        buttonMenu.setContentAreaFilled(false);
        buttonMenu.setBorder(null);
        //button.setBorderPainted(false);
        //button.setRolloverEnabled(false);
        buttonMenu.setFocusPainted(false);
        buttonMenu.setIcon(new ImageIcon(ChatUI.class.getResource("/images/36x36-menu.png")));
        panelLeft.add(buttonMenu, "cell 0 0");
        
        // Conectar al servidor
        JButton buttonConnect = new JButton("");
        buttonConnect.setIcon(new ImageIcon(ChatUI.class.getResource("/images/36x36-connect.png")));
        buttonConnect.setFocusPainted(false);
        buttonConnect.setContentAreaFilled(false);
        buttonConnect.setBorder(null);
        panelLeft.add(buttonConnect, "cell 0 1");
        
        // Conversaciones reciente
        JButton buttonChat = new JButton("");
        buttonChat.setIcon(new ImageIcon(ChatUI.class.getResource("/images/36x36-chat.png")));
        buttonChat.setFocusPainted(false);
        buttonChat.setContentAreaFilled(false);
        buttonChat.setBorder(null);
        panelLeft.add(buttonChat, "cell 0 2");
        
        // Rooms
        JButton buttonRooms = new JButton("");
        buttonRooms.setIcon(new ImageIcon(ChatUI.class.getResource("/images/36x36-chatroom.png")));
        buttonRooms.setFocusPainted(false);
        buttonRooms.setContentAreaFilled(false);
        buttonRooms.setBorder(null);
        panelLeft.add(buttonRooms, "cell 0 3");
        
        // Configuracion
        JButton buttonConfig = new JButton("");
        buttonConfig.setIcon(new ImageIcon(ChatUI.class.getResource("/images/36x36-config.png")));
        buttonConfig.setFocusPainted(false);
        buttonConfig.setContentAreaFilled(false);
        buttonConfig.setBorder(null);
        panelLeft.add(buttonConfig, "cell 0 4");
        frame.setVisible(true);
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InstantiationException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
