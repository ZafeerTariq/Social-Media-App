package UI.Templates;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Models.Object;
import main.SocialMedia;

public class UserButton extends JLabel {
	private Object poster;

	public UserButton(Object obj) {
		this.poster = SocialMedia.searchObjectByID(obj.getID());
		setText(poster.getName());
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
