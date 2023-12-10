package UI.Templates;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Models.Object;
import Models.Page;
import Models.User;
import UI.Screens.ProfilePage;
import main.SocialMedia;

public class UserButton extends JLabel {
	private Object object;

	public UserButton(Object obj) {
		this.object = obj;

		setText(object.getName());
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				if (object.getID().charAt(0) == 'u')
					SocialMedia.states.changeState(new ProfilePage(SocialMedia.searchUserByID(object.getID())));
				else
					System.out.println("transition to view page page");
					// SocialMedia.states.changeState(new ViewPagePage(SocialMedia.searchPageByID(object.getID())));
            }
        });
	}
}
