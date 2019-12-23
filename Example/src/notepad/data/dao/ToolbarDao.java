package notepad.data.dao;

import javax.swing.*;

public class ToolbarDao {
    public final JToolBar toolBar = new JToolBar();
    public final JButton newItem = new JButton("새 문서");
    public final JButton saveItem = new JButton("저장");
    public final JButton openItem = new JButton("열기");
    public final JButton closeItem = new JButton("닫기");
    public final JButton small = new JButton("작게");
    public final JButton normal = new JButton("보통");
    public final JButton larger = new JButton("크게");
    public final JButton info = new JButton("프로그램 정보");
}
