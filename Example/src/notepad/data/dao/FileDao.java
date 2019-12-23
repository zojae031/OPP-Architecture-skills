package notepad.data.dao;

import javax.swing.*;

public class FileDao {
    public final JMenu fileMenu = new JMenu("파일");

    public final JMenuItem newItem = new JMenuItem("새 문서");
    public final JMenuItem saveItem = new JMenuItem("저장");
    public final JMenuItem openItem = new JMenuItem("열기");
    public final JMenuItem closeItem = new JMenuItem("닫기");
}
