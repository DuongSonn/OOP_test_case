package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import config.Constant;
import models.WiderDropDownCombo;
import test.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import javax.swing.ScrollPaneConstants;
import java.awt.Rectangle;

public class main {

	private JFrame frame;
	private String testCase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel labelPanel = new JPanel();
		
		JPanel formPanel = new JPanel();
		
		JPanel testCasePanel = new JPanel();
		
		JPanel buttonPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(labelPanel, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
				.addComponent(formPanel, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
				.addComponent(testCasePanel, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
				.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(labelPanel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(formPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(testCasePanel, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
		);
		
		JLabel lblTestCase = new JLabel("Select Test Case");
		lblTestCase.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblSource = new JLabel("Select Source");
		
		JComboBox comboSource = new JComboBox();
		for (int i = 0; i < Constant.SOURCES.length; i++) {
			comboSource.addItem(Constant.SOURCES[i]);
		}
		
		JLabel lblAPI = new JLabel("Select API");
		
		JComboBox comboApi = new JComboBox();
		comboSource.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	comboApi.removeAllItems();
            	String index = String.valueOf(comboSource.getSelectedItem());
            	switch(index) {
            	  case "http://it4895.herokuapp.com/":
            		for (int i = 0; i < Constant.APIS_SOURCE_1.length; i++) {
            			comboApi.addItem(Constant.APIS_SOURCE_1[i]);
        		  	}
        		  	break;
            	  case "https://luandz.cf/":
    		  		for (int i = 0; i < Constant.APIS_SOURCE_2.length; i++) {
    		  			comboApi.addItem(Constant.APIS_SOURCE_2[i]);
    		  		}
    		  		break;
            	  case "https://bk-it4895.herokuapp.com/":
            		for (int i = 0; i < Constant.APIS_SOURCE_3.length; i++) {
            			comboApi.addItem(Constant.APIS_SOURCE_3[i]);
          		  	}
          		  	break;
            	  case "https://hust-fb-it4895.herokuapp.com/":
            		for (int i = 0; i < Constant.APIS_SOURCE_4.length; i++) {
            			comboApi.addItem(Constant.APIS_SOURCE_4[i]);
          		  	}
          		  	break;
            	  case "https://it4895-nhom5.herokuapp.com/":
            		for (int i = 0; i < Constant.APIS_SOURCE_5.length; i++) {
            			comboApi.addItem(Constant.APIS_SOURCE_5[i]);
          		  	}
          		  	break;
            	  case "https://project-facebook-clone.herokuapp.com/it4788/user/":
            		for (int i = 0; i < Constant.APIS_SOURCE_6.length; i++) {
            			comboApi.addItem(Constant.APIS_SOURCE_6[i]);
          		  	}
          		  	break;
            	  default:
            	    break;
            	}
            }
		});
		
		GroupLayout gl_formPanel = new GroupLayout(formPanel);
		gl_formPanel.setHorizontalGroup(
			gl_formPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAPI, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(lblSource, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboApi, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboSource, 0, 436, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_formPanel.setVerticalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSource)
						.addComponent(comboSource, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboApi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAPI))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		formPanel.setLayout(gl_formPanel);
		labelPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblGroup = new JLabel("Group 2 API Test Case");
		lblGroup.setHorizontalAlignment(SwingConstants.CENTER);
		labelPanel.add(lblGroup);
		
		WiderDropDownCombo  comboTestCase = new WiderDropDownCombo();
		comboApi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	comboTestCase.removeAllItems();
            	testCase = String.valueOf(comboApi.getSelectedItem());
            	if (testCase.contains("get_comment")) {
            		for (int i = 0; i < Constant.TEST_CASES_GET_COMMENT.length; i++) {
            			comboTestCase.addItem(Constant.TEST_CASES_GET_COMMENT[i]);
        		  	}
            		comboTestCase.setSelectedItem(Constant.TEST_CASES_GET_COMMENT[0]);
            		comboTestCase.setWide(true);
            	} else if (testCase.contains("get_post")) {
            		for (int i = 0; i < Constant.TEST_CASES_GET_POST.length; i++) {
	          			comboTestCase.addItem(Constant.TEST_CASES_GET_POST[i]);
	      		  	}
	          		comboTestCase.setSelectedItem(Constant.TEST_CASES_GET_POST[0]);
	          		comboTestCase.setWide(true);
            	} else {
            		
            	}
            }
		});
		
		JLabel lblResult = new JLabel("Result");
		
		JTextArea textResult = new JTextArea();
		textResult.setEnabled(false);
		
		JLabel lblResponse = new JLabel("Response");
		
		JTextArea textResponse = new JTextArea();
		textResponse.setEnabled(false);
		JScrollPane scroll = new JScrollPane(textResponse);
		scroll.setEnabled(false);
		GroupLayout gl_testCasePanel = new GroupLayout(testCasePanel);
		gl_testCasePanel.setHorizontalGroup(
			gl_testCasePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_testCasePanel.createSequentialGroup()
					.addGroup(gl_testCasePanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_testCasePanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_testCasePanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_testCasePanel.createSequentialGroup()
									.addComponent(lblTestCase, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblResponse, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_testCasePanel.createSequentialGroup()
									.addComponent(comboTestCase, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.LEADING, gl_testCasePanel.createSequentialGroup()
							.addGap(293)
							.addGroup(gl_testCasePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textResult, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
								.addComponent(lblResult, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_testCasePanel.setVerticalGroup(
			gl_testCasePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_testCasePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_testCasePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTestCase)
						.addComponent(lblResponse))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_testCasePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboTestCase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(lblResult)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textResult, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addContainerGap())
		);
		testCasePanel.setLayout(gl_testCasePanel);
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnRun = new JButton("Run");
		btnRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (testCase.contains("get_comment")) {
            		String testNumber = String.valueOf(comboTestCase.getSelectedItem());
            		for (int i = 0; i < Constant.TEST_CASES_GET_COMMENT.length; i++) {
            			if (testNumber == Constant.TEST_CASES_GET_COMMENT[i]) {
            				int testCaseNum = i + 1;
            				GetComment.run(testCaseNum, textResult, textResponse);
            				break;
            			}
            		}
            	} else if (testCase.contains("get_post")) {
            		String testNumber = String.valueOf(comboTestCase.getSelectedItem());
            		for (int i = 0; i < Constant.TEST_CASES_GET_POST.length; i++) {
            			if (testNumber == Constant.TEST_CASES_GET_POST[i]) {
            				int testCaseNum = i + 1;
            				GetPost.run(testCaseNum, textResult, textResponse);
            				break;
            			}
            		}
            	} else {
            		
            	}
			}
		});
		buttonPanel.add(btnRun);
		
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
