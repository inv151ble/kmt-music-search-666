import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminFrame extends JFrame
{
    static JTextField adminHistorySize;
    static JCheckBox adminSearchRegir;
    static JButton acceptButton;
    static JButton cancelButton;
    static JButton clearButton;
    static JSlider adminSearchDeph;
    eHendler hendler = new eHendler();

    public AdminFrame()
    {
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(AdminFrame.DISPOSE_ON_CLOSE);
    }



    void setupGUI()
    {
        adminSearchDeph = new JSlider(JSlider.HORIZONTAL, 5, 10,KMTUser.getSearchDeph());
        adminSearchDeph.setMajorTickSpacing(1);
        adminSearchDeph.setPaintTicks(true);
        adminSearchDeph.setPaintLabels(true);
        adminSearchDeph.setLocation(20,20);
        adminSearchDeph.setSize(103,40);
        getContentPane().add(adminSearchDeph);

        adminHistorySize = new JTextField();
        adminHistorySize.setLocation(140,20);
        adminHistorySize.setSize(99, 25);
        adminHistorySize.setText(String.valueOf(KMTUser.getHistorySize()));
        adminHistorySize.setColumns(10);
        getContentPane().add(adminHistorySize);

        adminSearchRegir = new JCheckBox();
        adminSearchRegir.setLocation(260,20);
        adminSearchRegir.setSize(20,20);
        adminSearchRegir.setSelected(KMTUser.isSearchRigor());
        getContentPane().add(adminSearchRegir);

        acceptButton = new JButton();
        acceptButton.setLocation(100,100);
        acceptButton.setSize(80,20);
        acceptButton.setText("Accept");
        getContentPane().add(acceptButton);

        cancelButton = new JButton();
        cancelButton.setLocation(190,100);
        cancelButton.setSize(80,20);
        cancelButton.setText("Cancel");
        getContentPane().add(cancelButton);


        clearButton = new JButton();
        clearButton.setLocation(100,135);
        clearButton.setSize(170,20);
        clearButton.setText("Clear History");
        getContentPane().add(clearButton);


        setTitle("KMT Music search options");
        setSize(340,210);
        setVisible(true);
        setResizable(true);
        acceptButton.addActionListener(hendler);
        cancelButton.addActionListener(hendler);
        clearButton.addActionListener(hendler);


    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public class eHendler implements ActionListener{


        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==acceptButton){
                KMTUser.setMidSearchDeph(adminSearchDeph.getValue());
                KMTUser.setMidHistorySize(Integer.parseInt(adminHistorySize.getText()));
                KMTUser.setMidSearchRigor(adminSearchRegir.isSelected());
                KMTUser.saveSettings();

            }

            if(e.getSource()==cancelButton) dispose();

            if(e.getSource()==clearButton) {
            SearchHist.clearHist();
            WindowFrame.userHistory.removeAllItems();
            };

        }
    }
}