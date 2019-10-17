package demos.countdown;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;


public class CountDownUI {
    public static CountDownUI ui;
    public static CountDown chrono;
    private JFrame frame;
    private JLabel hours;
    private JLabel minutes;
    private JLabel seconds;
    private JProgressBar progressBar;
    private JSpinner hourSpinner;
    private JSpinner minuteSpinner;
    private JSpinner secondSpinner;
    
    public CountDownUI() {
        initComponents();
    }
    
    private void initComponents() {
        setLookAndFeel();
        frame = new JFrame();
        
        frame.setTitle("Chrono");
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new MigLayout("", "[grow,center][14.00,grow,center][grow,center][center][grow,center]", "[grow,fill][][][fill]"));
        
        hours = new JLabel("00");
        frame.getContentPane().add(hours, "cell 0 0");
        
        JLabel label_1 = new JLabel(":");
        frame.getContentPane().add(label_1, "cell 1 0");
        
        minutes = new JLabel("00");
        frame.getContentPane().add(minutes, "cell 2 0");
        
        JLabel label_3 = new JLabel(":");
        frame.getContentPane().add(label_3, "cell 3 0");
        
        seconds = new JLabel("00");
        frame.getContentPane().add(seconds, "cell 4 0");
        
        hourSpinner = new JSpinner();
        hourSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
        frame.getContentPane().add(hourSpinner, "cell 0 1,growx");
        
        minuteSpinner = new JSpinner();
        minuteSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(59), new Integer(1)));
        frame.getContentPane().add(minuteSpinner, "cell 2 1,growx");
        
        secondSpinner = new JSpinner();
        secondSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(59), new Integer(1)));
        frame.getContentPane().add(secondSpinner, "cell 4 1,growx");
        
        progressBar = new JProgressBar();
        frame.getContentPane().add(progressBar, "cell 0 3 4 1");
        
        JButton btnRun = new JButton("RUN");
        btnRun.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chrono instanceof CountDown) {
                    chrono.stop();
                }
                
                int hours = Integer.parseInt(hourSpinner.getModel().getValue().toString());
                int minutes = Integer.parseInt(minuteSpinner.getModel().getValue().toString());
                int seconds = Integer.parseInt(secondSpinner.getModel().getValue().toString());
                
                chrono = new CountDown(hours, minutes, seconds);
                progressBar.setMaximum(chrono.toSeconds());
                progressBar.setValue(0);
                
                chrono.start();
            }
        });
        
        frame.getContentPane().add(btnRun, "cell 4 3");
        frame.pack();
        frame.setVisible(true);
    }
    
    public void updateBar() {
        progressBar.setValue( progressBar.getValue() + 1);
    }
    
    public void setHours(int hours) {
        this.hours.setText(String.valueOf(hours));
    }
    
    public void setMinutes(int minutes) {
        this.minutes.setText(String.valueOf(minutes));
    }
    
    public void setSeconds(int seconds) {
        this.seconds.setText(String.valueOf(seconds));
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
    
    public static void main(String[] args) {
        // Lanzar UI
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ui = new CountDownUI();
            }
        });
    }
}
