package clase;

import javax.swing.*;

public class CatalogList extends JList {
    DefaultListModel model = new DefaultListModel<>();

    public CatalogList() {
        String title = "<html><u><font color='red'>" +
                "Catalog Graphs" + "</font></u></html>";
        this.setBorder(BorderFactory.createTitledBorder(title));
        this.setModel(model);

    }
    public void addGraph(String item) {
        model.addElement(item);
    }
}