package chat.server;

import chat.client.Message;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

public class MultiChatServer {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();

    Logger logger;

    public static void main(String[] args) {
        new MultiChatServer().start();
    }

    public void start() {
        logger = Logger.getLogger(this.getClass().getName());
        try {
            serverSocket = new ServerSocket(8888);
            logger.info("chat.server.MultiChatServer start");
            while (true) {
                socket = serverSocket.accept();
                ChatThread chat = new ChatThread();
                chatThreads.add(chat);
                chat.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class ChatThread extends Thread {
        private String msg;
        private Message m;
        private Gson gson = new Gson();
        private final BufferedReader inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        private final PrintWriter outMsg = new PrintWriter(socket.getOutputStream(), true);
        private boolean status = true;
        public String id = null;

        ChatThread() throws IOException {
        }

        @Override
        public void run() {
            while (status) {
                try {
                    System.out.println("server thread runnging");
                    msg = inMsg.readLine();
                    m = gson.fromJson(msg, Message.class);
                    if (m.type.equals("logout")) {
                        chatThreads.remove(this);
                        msgSendAll(gson.toJson(new Message(m.id, "", "님이 종료했습니다.", "chat")));
                        status = false;
                    }
                    if (m.type.equals("login")) {
                        if (id == null) id = m.id;
                        msgSendAll(gson.toJson(new Message(m.id, "", "님이 로그인했습니다.", "chat")));
                    } else if (m.type.equals("whisper")) {
                        for (ChatThread ct : chatThreads) {
                            if (ct.id.equals(m.target)) {
                                ct.outMsg.println(gson.toJson(new Message(id, "", m.msg, "whisper")));
                            }
                        }
                    } else {
                        msgSendAll(msg);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    status = false;
                }

            }
            this.interrupt();
            logger.info(this.getName() + " 종료됨!!");
        }

        void msgSendAll(String msg) {
            for (ChatThread ct : chatThreads) {
                ct.outMsg.println(msg);
            }
        }
    }
}
