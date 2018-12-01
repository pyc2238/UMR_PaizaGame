package winterPro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class GameBoard extends GameCommandCenter { // winterEventBox Ŭ���� ���

	public GameBoard() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/�츶�������.png")); // �ڹ� ������ ����

		setTitle("play to game");
		setSize(900, 800);
		setLocationRelativeTo(null); // �߾����
		setResizable(false); // ����ڰ� ������ ���� �Ұ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel4 = new JPanel() {
			ImageIcon i = new ImageIcon("img/���Ӻ���.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 900, 800, null);
			}
		};

		panel4.setLayout(null);

		pointLabel = new JLabel("����Ʈ: 0");

		//// �ҽ��ڵ� ��� �κ� ////

		tArea = new JTextArea(600, 743);// height,width
		tArea.setFont(new Font("Dialog", Font.BOLD, 15));
		test_change();

		JScrollPane scroll = new JScrollPane(tArea); // scroll ��ü ����
		panel4.add(scroll);
		scroll.setBounds(10, 10, 600, 743);

		//// ���� �Է� �� �ð����� �޴� �κ� ////

		countPanel = new JPanel() {
			ImageIcon i = new ImageIcon("img/�ð��׵θ�.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 270, 350, null);
			}
		};// ī���� �ð��� ���Ե� �г�
		inputPanel = new JPanel();// ���� �Է� �޴� �г�
		button5 = new JButton("���"); // �����Է� ��ư
		resetBtn = new JButton("����");
		spBtn = new JButton("�����");
		spBtn.addMouseListener(this); // spBtn�� MouseListener
		tField = new JTextField(); // �����Է� �ؽ�Ʈ

		inputCountLabel = new JLabel("���Ƚ�� : 0");
		inputPanel.setLayout(null);
		inputPanel.add(resetBtn);
		inputPanel.add(tField);
		inputPanel.add(button5); // ���� �Է¹�ư
		inputPanel.add(spBtn);
		inputPanel.add(inputCountLabel);

		inputCountLabel.setFont(f4);
		tField.setBounds(10, 300, 170, 25); // ��,��,����,����
		button5.setBounds(190, 300, 70, 25); // �Է� ��ư ��ġ ����
		resetBtn.setBounds(190, 240, 70, 25); // �ʱ�ȭ ��ư ��ġ ����
		spBtn.setBounds(185, 210, 80, 25);
		inputCountLabel.setBounds(28, 237, 200, 50);

		inputPanel.setBackground(Color.ORANGE);
		inputPanel.setBounds(617, 402, 270, 350);

		//// �޺��ڽ�////
		umrList = new JComboBox(umrFriends);
		umrList.setSelectedIndex(0);
		umrList.addActionListener(this);

		comboLabel = new JLabel();
		comboLabel.setHorizontalAlignment(JLabel.CENTER);
		changePicture(umrFriends[umrList.getSelectedIndex()]);

		comboPanel = new JPanel();
		comboPanel.setLayout(null);
		comboPanel.add(umrList);
		comboPanel.add(comboLabel);
		umrList.setBounds(32, 0, 150, 30);
		comboLabel.setBounds(5, 35, 205, 185);
		comboPanel.setBackground(Color.ORANGE);
		comboPanel.setBounds(30, 15, 210, 230);

		inputPanel.add(comboPanel);
		panel4.add(inputPanel);

		//// �ð� ī��Ʈ �κ� ////

		button6 = new JButton("����"); // �ð� ���� ��ư
		timeLabel = new JLabel(); // ���� �ð��� ��Ÿ���� label
		countPanel.setLayout(null);
		inputPanel.setLayout(null);
		button6.setBounds(190, 270, 70, 25); // ���� ��ư ��ġ����
		timeLabel.setFont(f2);
		timeLabel.setBounds(22, 125, 300, 25); // Ÿ�Ӷ� ��ġ����
		pointLabel.setFont(f2);
		pointLabel.setBounds(30, 180, 300, 25);

		inputPanel.add(button6);
		countPanel.add(timeLabel);
		countPanel.add(pointLabel);
		countPanel.setBounds(617, 15, 270, 350);
		panel4.add(countPanel);

		spBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == spBtn) {
					if (point <= 2) {
						JOptionPane.showMessageDialog(null, shortagePoint_message);
						return;
					} else if (point >= 3) {
						point -= 3;
						minute += 5;
						second += 0;
						time += 300;
						inputCount = 0;
						inputCountLabel.setText("���Ƚ�� : " + inputCount);
						pointLabel.setText("����Ʈ: " + point);

					}
				}
			}
		});

		

		button6.addActionListener(new ActionListener() { // button6�� ����(=�͸�)Ŭ����
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button6) {
					if (point == 0) {
						JOptionPane.showMessageDialog(null, shortagePoint_message);
						return;
					} else if (point > 0) {
						point--;
						minute += 1;
						second += 20;
						time += 80;
						if (second >= 60) {
							second -= 60;
							minute++;
						}
						pointLabel.setText("����Ʈ: " + point);
					} else {
						JOptionPane.showMessageDialog(null, shortagePoint_message);
					}
				}
			}
		}); // end of anonymous class

		resetBtn.addActionListener(new ActionListener() { // resetBtn�� ����(=�͸�)Ŭ����
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == resetBtn) {
					if (point == 0) {
						JOptionPane.showMessageDialog(null, shortagePoint_message);
						return;
					} else if (point > 0) {
						point--;
						inputCount = 0;
						inputCountLabel.setText("���Ƚ�� : " + inputCount);
						pointLabel.setText("����Ʈ: " + point);
					}
				}

			}
		});

		button5.addActionListener(new ActionListener() { // button5�� ����(=�͸�)Ŭ����
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button5) {
					if (randomValue == 1) {
						if (tField.getText().equals(test.test[0][1])) {
							second = 0;
							pointLabel.setText("����Ʈ: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("���Ƚ�� : " + inputCount);
							test_change();

						} else {
							inputCountLabel.setText("���Ƚ�� : " + (++inputCount));

						}
					} else if (randomValue == 2) {
						if (tField.getText().equals(test.test[1][1])) {
							second = 0;
							pointLabel.setText("����Ʈ: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("���Ƚ�� : " + inputCount);
							test_change();

						} else {
							inputCountLabel.setText("���Ƚ�� : " + (++inputCount));
						}
					} else if (randomValue == 3) {
						if (tField.getText().equals(test.test[2][1])) {
							second = 0;
							pointLabel.setText("����Ʈ: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("���Ƚ�� : " + inputCount);
							test_change();

						} else {
							inputCountLabel.setText("���Ƚ�� : " + (++inputCount));
						}
					} else if (randomValue == 4) {
						if (tField.getText().equals(test.test[3][1])) {
							second = 0;
							pointLabel.setText("����Ʈ: " + (++point));
							tField.setText("");
							pointCount++;
							inputCountLabel.setText("���Ƚ�� : " + inputCount);
							inputCount = 0;
							test_change();
						} else {
							inputCountLabel.setText("���Ƚ�� : " + (++inputCount));
						}
					} else if (randomValue == 5) {
						if (tField.getText().equals(test.test[4][1])) {
							second = 0;
							pointLabel.setText("����Ʈ: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("���Ƚ�� : " + inputCount);
							test_change();
						} else {
							inputCountLabel.setText("���Ƚ�� : " + (++inputCount));
						}
					} else if (randomValue == 6) {
						if (tField.getText().equals(test.test[5][1])) {
							second = 0;
							pointLabel.setText("����Ʈ: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("���Ƚ�� : " + inputCount);
							test_change();
						} else {
							inputCountLabel.setText("���Ƚ�� : " + (++inputCount));
						}
					} else if (randomValue == 7) {
						if (tField.getText().equals(test.test[6][1])) {
							second = 0;
							pointLabel.setText("����Ʈ: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("���Ƚ�� : " + inputCount);
							test_change();
						} else {
							inputCountLabel.setText("���Ƚ�� : " + (++inputCount));
						}
					}
				}
			}
		});

		add(panel4);
		setVisible(true);

		TimeClass tc = new TimeClass();
		Thread tr = new Thread(tc); // ������ Ŭ������ �����ڿ� �־����� start�޼ҵ带 �̿��� ����
		tr.start();

	} // end of winterGameGui()

	class TimeClass implements Runnable { // ������ ��� Ŭ����(innerClass)
		public void run() {
			for (; time >= 0; time--) { // 600�� ���� 0�ʰ� �ɶ� ���� �ݺ�
				second--; // time������ 1�� ���ҵɶ����� second�������� 1����
				if (second == -1) { // second�������� 0���� �۾����� minute(=��) -1
					second = 59; // �ٽ� 59�ʷ� ����
					minute--; // 1�а���
				}
				if (pointCount >= 7) {// 7������ Ǯ������ ����Ŭ����
					minute = 0;
					second = 0;
					setVisible(false);

				}
				if (inputCount == 3) {// 3ȸ �̻� ����� ��������
					minute = 0;
					second = 0;
					time = 0;

				}

				if (minute < 10) { // �ܼ��� �����ڸ��� 0�� �߰��ϱ����� ����
					space_1 = "0";
				} else if (minute > 10) { // ���� 10 �ʰ��϶� �����ڸ� �������� ä��
					space_1 = "";
				}

				if (second < 10) { // �ܼ��� �����ڸ��� 0�� �߰��ϱ����� ����
					space_2 = "0";
				} else if (second > 10) { // �ʰ� 10 �ʰ��϶� �����ڸ� �������� ä��
					space_2 = "";
				}

				timeLabel.setText(
						"�����ð�: " + space_1 + Integer.toString(minute) + ":" + space_2 + Integer.toString(second) + "��");
				if (time == 0) {
					point = 0;
					button5.setEnabled(false); // time 0�ʰ� �Ǿ��� �� '�Է�'��ư ��Ȱ��ȭ
					button6.setEnabled(false); // time 0�ʰ� �Ǿ��� �� '����'��ư ��Ȱ��ȭ
					new TimeOut(); // �����尡 0�ʰ� �Ǹ� TimeOut ������ ���
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.err.println(e.toString());
				}

			}
		}// end of run()

	}// end of TimeClass Class

	////�޺��ڽ� �׼Ǹ�����////
	public void actionPerformed(ActionEvent e) {
		JComboBox cd = (JComboBox) e.getSource();
		String name = (String) cd.getSelectedItem();
		changePicture(name);

	}

	@Override
	public void mousePressed(MouseEvent e) { // ���콺 Ŭ���� ��ư ȿ���� �߻�
		JButton btn = (JButton) e.getSource();
		String indexTemp = umrFriends[umrList.getSelectedIndex()]; 
		// �޺��ڽ����� ���õǾ��ִ� ÷�ڰ��� umrFrineds�� ������� ���� ���õǾ��ִ� ĳ���͸� �����ϴµ� �� ���� ���� �ؿ��� ���ϰ� �ȴ�.
		
		if (point >= 3) {
			try {
				if (indexTemp == "�츶��.png") { // ���� ���õǾ� �ִ� ĳ���Ͱ� �츶��.png �϶�
					System.out.println("[�츶�� ����]");
					FileInputStream fileInputStream = new FileInputStream("�츶��.mp3"); // File ������ mp3���� ����
					Player player = new Player(fileInputStream);
					player.play();
				} else if (indexTemp == "����.png") { // ���� ���õǾ� �ִ� ĳ���Ͱ� ����.png �϶�
					System.out.println("[���� ����]");
					FileInputStream fileInputStream = new FileInputStream("����.mp3"); // File ������ mp3���� ����
					Player player = new Player(fileInputStream);
					player.play();
				} else if (indexTemp == "����.png") { // ���� ���õǾ� �ִ� ĳ���Ͱ� ����.png �϶� 
					System.out.println("[���� ����]");
					FileInputStream fileInputStream = new FileInputStream("����.mp3"); // File ������ mp3���� ����
					Player player = new Player(fileInputStream);
					player.play();
				} else if (indexTemp == "Ű����.png") { // ���� ���õǾ� �ִ� ĳ���Ͱ� Ű����.png �϶�
					System.out.println("[Ű���� ����]");
					FileInputStream fileInputStream = new FileInputStream("Ű����.mp3"); // File ������ mp3���� ����
					Player player = new Player(fileInputStream);
					player.play();
				}
			} catch (FileNotFoundException s) {
				s.printStackTrace();

			} catch (JavaLayerException s) {
				s.printStackTrace();
			}
		}

	}// end of MousePressed()

}// end of winterGameGui Class