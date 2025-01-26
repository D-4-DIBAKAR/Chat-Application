# Java Chat Application

A simple and intuitive chat application built in Java using **Swing** for the graphical user interface (GUI) and **Socket Programming** for client-server communication. This application supports **group chat**, **user list synchronization**, and **private messaging**, making it ideal for learning basic networking and GUI concepts.

---

## Features

- **Real-time Group Chat**: Chat with multiple users in a single room.
- **User List**: Displays a list of all connected users.
- **Private Messaging**: Send direct messages to specific users.
- **File Sharing**: Exchange files with other users (can be implemented later as a feature).
- **Thread-Safe Communication**: Handles multiple clients using threads.
- **Enhanced UI**: Split layout with chat and user list for a better experience.

---

## Screenshots

### 1. **Client Interface**
![Client Interface](https://github.com/user-attachments/assets/9566683b-b58c-43de-9184-3c1d22a2071a)

![Client Interface](https://github.com/user-attachments/assets/838308b0-b624-4f44-8624-d8a3b93b9628)

### 2. **User Joining**
![User Joining](https://github.com/user-attachments/assets/69eb4854-55c9-47b6-ba7c-a341367cd12e)

![User Joining](https://github.com/user-attachments/assets/30ab64a8-4e94-426a-b565-f4f1c41b327e)

---

## How It Works

### 1. **Server**
The server handles:
- Accepting client connections.
- Broadcasting messages to all connected clients.
- Maintaining a synchronized list of connected users.
  
### 2. **Client**
The client application:
- Connects to the server.
- Allows users to send and receive messages.
- Updates the user list dynamically when users join or leave.

---

## Getting Started

### Prerequisites
- **Java Development Kit (JDK)** installed (version 8 or higher).
- **IDE** like IntelliJ IDEA, Eclipse, or NetBeans (optional).

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/D-4-DIBAKAR/Chat-Application.git
   cd Chat-Application
   ```
2. Compile the code:
   ```bash
   javac Server.java Client.java ClientHandler.java
   ```
3. Run the server:
   ```bash
   java Server
   ```
4. Run the client:
   ```bash
   java Client
   ```

---

## Usage

### Starting the Server
1. Run `Server.java`.
2. The server starts on port `4444`.

### Connecting a Client
1. Run `Client.java`.
2. Enter the server IP address in the prompt.
3. Choose a username to join the chat.

### Sending Messages
1. Type your message in the text field.
2. Press "Send" or hit `Enter`.

---

## Code Architecture

### 1. **Server.java**
- Listens for client connections.
- Maintains a list of connected clients and their names.
- Broadcasts messages to all clients.

### 2. **ClientHandler.java**
- Handles communication between the server and a specific client.
- Manages user authentication and message handling.

### 3. **Client.java**
- Provides the GUI for users to interact with the chat application.
- Handles sending and receiving messages to/from the server.

---

## Future Enhancements
- **File Sharing**: Allow clients to exchange files.
- **Private Messaging**: Add functionality for direct messages.
- **Improved UI**: Modernize the interface with better layouts and styling.
- **User Authentication**: Add login functionality.

---

## Contributing
Contributions are welcome! Please open an issue or submit a pull request with improvements.

