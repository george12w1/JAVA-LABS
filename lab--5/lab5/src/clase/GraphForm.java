package clase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphForm extends JPanel {
    private final CatalogFrame frame;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    JLabel titleLabel = new JLabel("Name of graph");
    JLabel pathLabel = new JLabel("Path of the definition file");
    JLabel imgLabel = new JLabel("Path of the image file");
    JLabel grhtypeLabel = new JLabel("Graph type");
    JLabel verticesLabel = new JLabel("Number of vertices");
    JLabel edgesLabel = new JLabel("Number of edges");

    JTextField titleField = new JFormattedTextField();
    JTextField pathField = new JFormattedTextField();
    JTextField imgField = new JFormattedTextField();

    String[] tipuri = {"simple", "directed","complete"};
    JComboBox grhtypeField = new JComboBox(tipuri);

    JSpinner verticesField = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
    JSpinner edgesField = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));


    JButton addButton = new JButton("Add to repository");



    public GraphForm(CatalogFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Add graph"));
        this.frame = frame;
        init();

        this.setLayout(new GridLayout(0, 1));
    }

    private void init() {

        frame.setPreferredSize(new Dimension(500, 600));
        frame.setLocation(screenSize.width/3-frame.getSize().width, screenSize.height/6-frame.getSize().height);

        add(titleLabel);
        add(titleField);

        add(pathLabel);
        add(pathField);

        add(imgLabel);
        add(imgField);

        add(grhtypeLabel);
        add(grhtypeField);

        add(verticesLabel);
        add(verticesField);

        add(edgesLabel);
        add(edgesField);

        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGraph();
                titleField.setText("");
                pathField.setText("");
                imgField.setText("");
                verticesField.setValue(0);
                edgesField.setValue(0);
            }
        });
    }
        private void addGraph () {
        String graph = titleField.getText() + ", " + grhtypeField.getSelectedItem() +
                       ", n=" + verticesField.getValue() + ", m=" + edgesField.getValue()
                       + "[" + pathField.getText() + "]";
            frame.list.addGraph(graph);
        }
}
