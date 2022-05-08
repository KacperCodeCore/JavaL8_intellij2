import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainFrame extends JFrame {
    private JTextField textFieldName;
    private JRadioButton manRadioMan;
    private JRadioButton womanRadioWoman;
    private JButton button1;
    private JPanel mainPanel;
    private JTextField textFieldNick;
    private JTextField textFieldSurname;
    private JTextField textFieldMail;

    public MainFrame() {

        manRadioMan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (manRadioMan.isSelected()){
                    womanRadioWoman.setSelected(false);
                }
                else {
                    womanRadioWoman.setSelected(true);
                }

            }
        });
        womanRadioWoman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (womanRadioWoman.isSelected()){
                    manRadioMan.setSelected(false);
                }
                else {
                    manRadioMan.setSelected(true);
                }
            }
        });

        textFieldNick.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                try{
                    OwnExceptions.nick(textFieldNick.getText());
                }
                catch (IllegalArgumentException exc)
                {
                    JOptionPane.showMessageDialog(textFieldNick,exc.getMessage());
                }
            }
        });

        textFieldName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                try{
                    OwnExceptions.nameorsurname(textFieldName.getText());
                }
                catch (IllegalArgumentException exc)
                {
                    JOptionPane.showMessageDialog(textFieldName,exc.getMessage());
                }

            }
        });


        textFieldSurname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try{
                    OwnExceptions.nameorsurname(textFieldName.getText());
                }
                catch (IllegalArgumentException exc)
                {
                    JOptionPane.showMessageDialog(textFieldName,exc.getMessage());
                }
            }
        });
        //textFieldMail
        textFieldSurname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try{
                    OwnExceptions.nameorsurname(textFieldName.getText());
                }
                catch (IllegalArgumentException exc)
                {
                    JOptionPane.showMessageDialog(textFieldName,exc.getMessage());
                }
            }
        });

        textFieldSurname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try{
                    OwnExceptions.mail(textFieldMail.getText());
                }
                catch (IllegalArgumentException exc)
                {
                    JOptionPane.showMessageDialog(textFieldMail,exc.getMessage());
                }
            }
            });

    }


    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setContentPane(mf.mainPanel);
        mf.setSize(400,250);
        mf.setVisible(true);
        mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
}
