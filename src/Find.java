import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;

public class Find extends JFrame implements Function
{
    JTextPane main_textPane , target_textPane;

    @Override
    public java.lang.reflect.Type accept(Vistor v) {
        return v.visit(this);
    }
    public Find(){
        super("尋找");
    }
    public void feature(String input_text){

        String ip[];
        ip = input_text.split("\n");
        setSize(250,300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        Container pn = getContentPane();
        //設定成FlowLayout
        FlowLayout fy = new FlowLayout();
        pn.setLayout(fy);

        JLabel l = new JLabel("請輸入想尋找的文字");
        pn.add(l);
        //文字輸入欄位//
        JTextField jTextField = new JTextField();
        jTextField.setColumns(10);
        pn.add(jTextField);

        //確定跟取消按鈕//
        JPanel bt = new JPanel();
        JButton confirm = new JButton("確定");
        JTextArea INDEX = new JTextArea(5,10);
        INDEX.setLineWrap(true);
        INDEX.setEditable(false);
        JScrollPane sp = new JScrollPane(INDEX, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        confirm.addActionListener(new ActionListener() {
            int  temp = 0 , index = 0 , n  , count;
            String t ="";
            public void actionPerformed(ActionEvent e) {
                INDEX.setText("");
                t = "";
                n = 0;
                count = 0;
                while (n < ip.length) {
                    if(n != 0)
                        t += "\n第" + (n+1) + "行: ";
                    else
                        t += "第" + (n+1)  + "行: ";
                    index = ip[n].indexOf(jTextField.getText(), temp);
                    t +=  (index+1);
                    if(index != -1)
                        count++;

                    while (index != -1) {
                        temp = index + 1;
                        index = ip[n].indexOf(jTextField.getText(), temp);
                        if (index == -1)
                            break;
                        t += "," + (index+1);
                        count++;
                    }
                    temp = 0;
                    n++;
                }
                t += "\n共" + count + "個";
                INDEX.setText(t);
            }
        });
        bt.add(confirm);

        JButton cancel = new JButton("取消");
        bt.add(cancel);
        pn.add(bt,BorderLayout.SOUTH);
        pn.add(sp);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setContentPane(pn);
    }
}
