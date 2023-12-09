package UI.Templates;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Models.Object;
import Models.User;
import UI.Screens.ProfilePage;
import main.SocialMedia;

public class UserButton extends JLabel {
	private User user;

	public UserButton(Object obj) {
		this.user = SocialMedia.searchUserByID(obj.getID());
		setText(user.getName());
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				SocialMedia.states.changeState(new ProfilePage(user));
            }
        });
	}
}
