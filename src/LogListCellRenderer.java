import javax.swing.*;
import java.awt.*;

public class LogListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Exercise) {
            setText(((Exercise)value).getName());
            setToolTipText("<html>Description: " + ((Exercise)value).getDescription() + "<br />Weight: " + ((Exercise) value).getWeight() + "<br />Sets: " + ((Exercise) value).getSets() + "<br />Reps: " + ((Exercise) value).getReps() + "</html>");
        }
        return this;
    }
}
