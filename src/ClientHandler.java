import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

	Socket clientSocket;
	BufferedReader bufferReader;
	PrintWriter printWriter;
	Server server;

	public ClientHandler(Socket clientSocket, Server server) {
		this.clientSocket = clientSocket;
		this.server = server;
		try {
			this.bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			this.printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		String name = "";
		while (true) {
			printWriter.println("SUBMITNAME");
			try {
				name = bufferReader.readLine();
				if (name == null)
					return;
				if (!name.isEmpty())
					break;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		printWriter.println("NAMEACCEPTED");
		server.broadcast(name + " has connected");
		while (true) {
			try {
				String userMessage = bufferReader.readLine();
				if (userMessage == null)
					return;
				server.broadcast("MESSAGE " + name + " : " + userMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
