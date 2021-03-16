import javax.swing.*;
import java.awt.*;

public class ExerciseListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Exercise) {
            setText(((Exercise)value).getName());
            setToolTipText(((Exercise)value).getDescription());
        }
        return this;
    }
}
