package UI.Templates;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Models.Post;

public class PostTemplate extends JPanel {
	private Post post;
	private JLabel username;
	private JTextArea postText;
	private int width = 550;
	private int height = 200;
	private int y = 150;

	public PostTemplate(Post post, int n) {
		this.post = post;
		String name = this.post.getSharedBy().getName();
		String text = this.post.getText();

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

		JButton likeButton = new JButton();
		likeButton.setText("Like");
		likeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				likeButtonActionPerformed(evt);
            }
        });

		JButton commentButton = new JButton();
		commentButton.setText("Comment");
		commentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentButtonActionPerformed(evt);
            }
        });

		JPanel bar = new JPanel();
		bar.add(likeButton);
		bar.add(commentButton);

		add(usernamePanel);
		add(postText);
		add(bar);

		setBounds(1280 / 2 - width / 2, y + (height + 10) * n, width, height);
		setBorder(new LineBorder(Color.BLACK, 2));
	}

	private void likeButtonActionPerformed(ActionEvent evt) {
		//TODO Like post
		System.out.println("like button pressed");
	}

	private void commentButtonActionPerformed(ActionEvent evt) {
		//TODO open comment box
		System.out.println("comment button pressed");
	}
}
