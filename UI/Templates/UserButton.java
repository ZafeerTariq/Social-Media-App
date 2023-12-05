package UI.Templates;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Models.Object;

public class UserButton extends JLabel {
	private Object user;

	public UserButton(Object u) {
		this.user = u;
		setText(user.getName());
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				//TODO goto user's page
                System.out.println("username clicked");
            }
        });
	}
}
