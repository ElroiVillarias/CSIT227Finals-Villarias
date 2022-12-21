import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame{
    private JPanel pnlMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextArea taPersons;
    private JButton btnSave;
    private JTextField tfAge;
    private JTextField tfMonths;
    private JTextField tfSalary;
    private JButton btnClear;
    private JTextField tfLoad;
    private JButton btnLoad;
    private JButton btnSayHi;
    private JButton btnSavePerson;
    private JButton btnLoadPerson;
    private JButton btnReward;

    private final List<JRadioButton> Job;
    private List<Person> persons;

    public App() {
        //for peps
        persons = new ArrayList<>();

        //for job buttons
        Job = new ArrayList<>();
        Job.add(rbClerk);
        Job.add(rbCustomer);
        Job.add(rbManager);
        // TODO add implementations for all milestones here

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cnt = 0;
                try{
                    Integer.parseInt(tfAge.getText());
                    cnt++;
                    Integer.parseInt(tfMonths.getText());
                    cnt++;
                    Double.parseDouble(tfSalary.getText());
                } catch (Exception x) {
                    if(cnt == 0){
                        JOptionPane.showMessageDialog(pnlMain, "The inputted age is not valid.");
                    }else if(cnt == 1) {
                        JOptionPane.showMessageDialog(pnlMain, "The inputted months of work is not valid.");
                    }else{
                        JOptionPane.showMessageDialog(pnlMain, "The inputted salary is not valid.");
                    }
                    clear();
                }


                String name = tfName.getText();
                int age = Integer.parseInt(tfAge.getText());
                String occ = "Job";
                for(JRadioButton rb : Job) {
                    if(rb.isSelected()) {
                        if(rb.equals(rbCustomer)){
                            occ = "Customer";
                            persons.add(new Person.Customer(name, age));
                        } else if(rb.equals(rbClerk)) {
                            int months = Integer.parseInt(tfMonths.getText());
                            double salary = Double.parseDouble(tfSalary.getText());
                            occ = "Clerk";
                            persons.add(new Employee.Clerk(name, age, months, salary));
                        } else if(rb.equals(rbManager)) {
                            int months = Integer.parseInt(tfMonths.getText());
                            double salary = Double.parseDouble(tfSalary.getText());
                            occ = "Manager";
                            persons.add(new Employee.Manager(name, age, months, salary));
                        }
                    }
                }

                int counter = 0;
                for(Person p : persons){
                    counter++;
                }

                taPersons.setText(counter + ". " + occ + " - " + name + " (" + age + ")");
                clear();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer.parseInt(tfLoad.getText());
                }catch (Exception x){
                    JOptionPane.showMessageDialog(pnlMain, "The Load input is not valid.");
                    clear();
                }
                int load = Integer.parseInt(tfLoad.getText());
                int cnt = 1;
                for(Person p : persons){
                    if(load == cnt){
                        tfName.setText(p.name);
                        tfAge.setText(String.valueOf(p.age));
                        if(p instanceof Employee){
                            tfMonths.setText(String.valueOf(((Employee) p).months_worked));
                            tfSalary.setText(String.valueOf(((Employee) p).salary));
                        }
                        break;
                    }
                    cnt++;
                }
            }
        });

        btnSayHi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Person p : persons){
                    System.out.println(p);
                }
            }
        });
    }

    public static void main(String[] args) {
        App app = new App();
        app.setContentPane(app.pnlMain);
        app.setSize(750, 500);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void clear() {
        tfName.setText("");
        tfAge.setText("");
        tfMonths.setText("");
        tfSalary.setText("");
        tfLoad.setText("");
    }

    static void giveReward(int n) {

    }

}
