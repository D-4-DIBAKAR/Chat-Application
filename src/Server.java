import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	ArrayList<Socket> sockets = new ArrayList<Socket>();

	public void broadcast(String message) {
		for (Socket socket : sockets) {
			try {
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
				writer.println(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(4444);
			System.out.println("Server started on port 4444");
			while (true) {
				Socket clienSocket = serverSocket.accept();
				sockets.add(clienSocket);
				System.out.println("Client Connected");

				ClientHandler clientHandler = new ClientHandler(clienSocket, this);
				new Thread(clientHandler).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server().run();

	}

}
