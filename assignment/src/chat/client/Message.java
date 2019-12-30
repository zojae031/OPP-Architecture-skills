package chat.client;

public class Message {
    public String id;
    public String pw;
    public String msg;
    public String type;
    public String target = "";

    public Message(String id, String pw, String msg, String type) {
        this.id = id;
        this.pw = pw;
        this.msg = msg;
        this.type = type;
    }

    public Message(String id, String pw, String msg, String type, String target) {
        this.id = id;
        this.pw = pw;
        this.msg = msg;
        this.type = type;
        this.target = target;
    }
}
