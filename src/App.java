import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                            persons.add(new Person.Employee.Clerk(name, age, months, salary));
                        } else if(rb.equals(rbManager)) {
                            int months = Integer.parseInt(tfMonths.getText());
                            double salary = Double.parseDouble(tfSalary.getText());
                            occ = "Manager";
                            persons.add(new Person.Employee.Manager(name, age, months, salary));
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
