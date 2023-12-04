package UI.Templates;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Models.Post;

public class PostTemplate extends JPanel {
	private JLabel username;
	private JTextArea postText;
	private int width = 550;
	private int height = 200;
	private int y = 150;

	public PostTemplate(Post post, int n) {
		String name = post.getSharedBy().getName();
		String text = post.getText();

		username = new JLabel(name);
		postText = new JTextArea();

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		postText.setLineWrap(true);
		postText.setWrapStyleWord(true);
		postText.setText(text);
		postText.setEditable(false);

		// make username clickable to go to user's page
		username.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        username.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				//TODO goto user's page
                System.out.println("username clicked");
            }
        });

		JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.add(username);
		add(usernamePanel);
		add(postText);

		setBounds(1280 / 2 - width / 2, y + (height + 10) * n, width, height);
		setBorder(new LineBorder(Color.BLACK, 2));
	}

	public PostTemplate(String name, String text) {
		username = new JLabel(name);
		postText = new JTextArea();

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		postText.setLineWrap(true);
		postText.setWrapStyleWord(true);
		postText.setText(text);
		postText.setEditable(false);

		// make username clickable to go to user's page
		username.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        username.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				//TODO goto user's page
                System.out.println("username clicked");
            }
        });

		JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.add(username);
		add(usernamePanel);
		add(postText);

		setBounds(1280 / 2 - width / 2, y, width, height);
		setBorder(new LineBorder(Color.BLACK, 2));
	}

	public PostTemplate(String name, String text, int width, int height, int y) {
		this(name, text);
		this.width = width;
		this.height = height;
		this.y = y;
		setBounds(1280 / 2 - width / 2, y, width, height);
	}
}
