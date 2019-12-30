package chat.client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiChatController extends Thread {
    private final Ui view;
    private final MultiChatData chatData;
    private Socket socket;
    private BufferedReader inMsg = null;
    private PrintWriter outMsg = null;
    private Gson gson = new Gson();
    private Message msg = new Message("", "", "", "");
    private boolean status = true;
    Thread thread;

    public MultiChatController(MultiChatData chatData, Ui view) {
        this.view = view;
        this.chatData = chatData;
    }

    void appMain() {
        chatData.addObj(view.msgOut);

        view.addButtonActionListener(e -> {
            Object obj = e.getSource();
            if (obj == view.exitButton) {
                System.exit(0);
            } else if (obj == view.loginButton) {
                view.id = view.idInput.getText();
                view.outLabel.setText(" 대화명 : " + view.id);
                view.cardLayout.show(view.tab, "logout");
                connectServer();
            } else if (obj == view.logoutButton) {
                outMsg.println(gson.toJson(new Message(view.id, "", "", "logout")));
                view.msgOut.setText("");
                view.cardLayout.show(view.tab, "login");
                outMsg.close();
                try {
                    inMsg.close();
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                status = false;
            } else if (obj == view.msgInput) {
                String inputData = view.msgInput.getText();
                String data = null;
                if (inputData.startsWith("/w")) {
                    String[] strings = inputData.split(" ");
                    if (strings.length == 3) {
                        data = gson.toJson(new Message(view.id, "", strings[2], "whisper", strings[1]));
                        view.msgInput.setText("");
                    } else {
                        view.msgInput.setText("올바르지 않은 귓속말 형태입니다.");
                    }
                } else {
                    data = gson.toJson(new Message(view.id, "", view.msgInput.getText(), "chat"));
                    view.msgInput.setText("");
                }
                outMsg.println(data);

            }

        });
    }

    public void connectServer() {
        try {
            socket = new Socket("127.0.0.1", 8888);
            inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outMsg = new PrintWriter(socket.getOutputStream(), true);
            msg = new Message(view.id, "", "", "login");
            outMsg.println(gson.toJson(msg));
            thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String m;
        status = true;
        while (status) {
            try {
                m = inMsg.readLine();
                msg = gson.fromJson(m, Message.class);

                if (!msg.msg.equals("")) {
                    if (msg.type.equals("whisper")) {
                        chatData.refreshData(msg.id + " 님의 귓속말 : " + msg.msg + "\n");
                    } else {
                        chatData.refreshData(msg.id + " > " + msg.msg + "\n");
                    }

                }
                view.msgOut.setCaretPosition(view.msgOut.getDocument().getLength());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MultiChatController app = new MultiChatController(new MultiChatData(), new Ui());
        app.appMain();
    }
}
