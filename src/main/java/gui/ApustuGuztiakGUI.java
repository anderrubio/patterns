package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import adapter.ApustuTaula;
import businesslogic.BLFacade;
import domain.Registered;
import domain.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApustuGuztiakGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
    private JTable table;
    private JFrame thisw;
    public ApustuGuztiakGUI(User u) {
    	thisw = this;
        frame = new JFrame();
        frame.setBounds(100,100,650, 500);

        BLFacade facade = MainGUI.getBusinessLogic();
        Registered per = facade.getRegisteredFromUser(u);
        ApustuTaula model = new ApustuTaula(per);


        setBounds(100, 100, 896, 642);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 10, 810, 280);
        scrollPane.setPreferredSize(new Dimension(580,480));
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 882, 605);
        panel.setLayout(null);
        panel.add(scrollPane);
        getContentPane().add(panel);
        
        JButton atzeraButton = new JButton("Back");
        atzeraButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		thisw.setVisible(false);
        	}
        });
        atzeraButton.setBounds(607, 530, 176, 45);
        panel.add(atzeraButton);

    }

}