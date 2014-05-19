import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AdminFrame extends JFrame
{
    static JTextField adminHistorySize;
    static JCheckBox adminSearchRegir;
    static JButton acceptButton;
    static JButton cancelButton;
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
        adminSearchDeph = new JSlider(JSlider.HORIZONTAL, 1, 5,KMTUser.getSearchDeph());
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


        setTitle("KMT Music search");
        setSize(340,200);
        setVisible(true);
        setResizable(true);
        acceptButton.addActionListener(hendler);
        cancelButton.addActionListener(hendler);


    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public class eHendler implements ActionListener{


        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==acceptButton){
                KMTUser.setSearchDeph(adminSearchDeph.getValue());
                KMTUser.setHistorySize(Integer.parseInt(adminHistorySize.getText()));
                KMTUser.setSearchRigor(adminSearchRegir.isSelected());
                KMTUser.saveSettings();
            }

            if(e.getSource()==cancelButton) dispose();

        }
    }
}