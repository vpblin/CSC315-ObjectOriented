import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;


public class new_class extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_class frame = new new_class();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public new_class() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(636, Short.MAX_VALUE)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 0, 117, 29);
		layeredPane.add(btnNewButton);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(0, 24, 117, 29);
		layeredPane.add(btnStop);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(0, 51, 117, 29);
		layeredPane.add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(0, 76, 117, 29);
		layeredPane.add(btnSave);
		contentPane.setLayout(gl_contentPane);
	}
}
