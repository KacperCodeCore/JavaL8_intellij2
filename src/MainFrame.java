import Exceptions.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainFrame extends JFrame {
    private JTextField textFieldName;
    private JRadioButton manRadioMan;
    private JRadioButton womanRadioWoman;
    private JButton button1;
    private JPanel mainPanel;
    private JTextField textFieldNick;
    private JTextField textFieldSurname;
    private JTextField textFieldMail;
    private JTextField textFieldError;

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
                    MethodsForExceptions.nick(textFieldNick.getText());
                    textFieldError.setText("");
                }
                catch (NickException exc)
                {
                    textFieldError.setText(exc.getMessage());
                }
            }
        });

        textFieldName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                try{
                    MethodsForExceptions.nameorsurname(textFieldName.getText());
                    if (manRadioMan.isSelected()) {
                        MethodsForExceptions.manRegex(textFieldName.getText());
                    }
                    else if (womanRadioWoman.isSelected()) {
                        MethodsForExceptions.womanRegex(textFieldName.getText());
                    }
                    else {
                        MethodsForExceptions.nullGenderChose("s");
                    }
                    textFieldError.setText("");
                }
                catch (NameSurnameException e1)
                {
                    textFieldError.setText(e1.getMessage());
                }
                catch (GenderManException e2){
                    textFieldError.setText(e2.getMessage());
                }
                catch (GenderWomanException e3){
                    textFieldError.setText(e3.getMessage());
                }
                catch (GenderNullException e4){
                    textFieldError.setText(e4.getMessage());
                }


            }
        });


        textFieldSurname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try{
                    MethodsForExceptions.nameorsurname(textFieldSurname.getText());
                    textFieldError.setText("");
                }
                catch (NameSurnameException exc)
                {
                    textFieldError.setText(exc.getMessage());
                }
            }
        });

        textFieldMail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try{
                    MethodsForExceptions.mail(textFieldMail.getText());
                    textFieldError.setText("");
                }
                catch (MailException exc)
                {
                    textFieldError.setText(exc.getMessage());
                }
            }
            });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    MethodsForExceptions.nick(textFieldNick.getText());
                    MethodsForExceptions.nameorsurname(textFieldName.getText());
                    MethodsForExceptions.nameorsurname(textFieldSurname.getText());
                    if (manRadioMan.isSelected()) {
                        MethodsForExceptions.manRegex(textFieldName.getText());
                    }
                    else if (womanRadioWoman.isSelected()) {
                        MethodsForExceptions.womanRegex(textFieldName.getText());
                    }
                    else {
                        MethodsForExceptions.nullGenderChose("s");
                    }
                    MethodsForExceptions.mail(textFieldMail.getText());
                    textFieldError.setText("All Correct");
                }
                catch (NickException e1)
                {
                    textFieldError.setText(e1.getMessage());
                }
                catch (NameSurnameException e2)
                {
                    textFieldError.setText(e2.getMessage());
                }
                catch (GenderManException e3){
                    textFieldError.setText(e3.getMessage());
                }
                catch (GenderWomanException e4){
                    textFieldError.setText(e4.getMessage());
                }
                catch (GenderNullException e5){
                    textFieldError.setText(e5.getMessage());
                }
                catch (MailException e6) {
                    textFieldError.setText(e6.getMessage());
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
