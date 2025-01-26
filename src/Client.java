import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
	JFrame JF = new JFrame("Chat Application");
	JTextField sendMessage = new JTextField(40);
	JTextArea messageTextArea = new JTextArea(8, 40);
	BufferedReader bufferReader;
	PrintWriter printWriter;

	public Client() {
		sendMessage.setEditable(false);
		messageTextArea.setEditable(false);
		JF.getContentPane().add(sendMessage, "North");
		JF.getContentPane().add(messageTextArea, "Center");
		JF.pack();

		sendMessage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printWriter.println(sendMessage.getText());
				sendMessage.setText("");

			}
		});

	}

	@SuppressWarnings("resource")
	public void connect() {
		String serverAddress = JOptionPane.showInputDialog(JF, "Enter the Server IP: ", "Connect to the Server",
				JOptionPane.QUESTION_MESSAGE);
		try {
			Socket socket = new Socket(serverAddress, 4444);
			bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String line = bufferReader.readLine();
				if (line.startsWith("SUBMITNAME")) {
					String name = JOptionPane.showInputDialog(JF, "Enter your name:", "Name Selection",
							JOptionPane.PLAIN_MESSAGE);
					printWriter.println(name);
				} else if (line.startsWith("NAMEACCEPTED")) {
					sendMessage.setEditable(true);
				} else if (line.startsWith("MESSAGE")) {
					messageTextArea.append(line.substring(7) + "\n");
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.JF.setVisible(true);
		client.connect();

	}

}
