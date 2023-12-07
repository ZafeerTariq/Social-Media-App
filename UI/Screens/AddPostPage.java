package UI.Screens;

import java.awt.Image;

import javax.swing.ImageIcon;

import main.SocialMedia;

public class AddPostPage extends BasePage {
    public AddPostPage() {
        initComponents();
		errorLabel.setVisible(false);;
    }

    private void initComponents() {
        pageHeading = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        postTextArea = new javax.swing.JTextArea();
        postButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pageHeading.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        pageHeading.setText("Add Post");

        ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/back icon.png"));
        backButton.setIcon(
            new ImageIcon(backIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH))
        );
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        postTextArea.setColumns(20);
        postTextArea.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        postTextArea.setLineWrap(true);
        postTextArea.setRows(5);
        postTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(postTextArea);

        postButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        postButton.setText("Post");
        postButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(204, 0, 51));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(482, 482, 482)
                .addComponent(pageHeading)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(postButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(530, 530, 530))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(434, 434, 434))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pageHeading))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(backButton)))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(postButton)
                .addGap(72, 72, 72)
                .addComponent(errorLabel)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
		SocialMedia.states.changeState(new HomePage());
	}

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String postText = postTextArea.getText();
        if (postText.isEmpty()) {
			errorLabel.setText("Post content cannot be empty");
			errorLabel.setVisible(true);
		}
		else {
			if (SocialMedia.db.addPost(SocialMedia.getCurrentUser().getID(), postText)) {
				errorLabel.setText("Posted Successfully");
				errorLabel.setVisible(true);
			}
			else {
				errorLabel.setText("Could not post due to an error");
				errorLabel.setVisible(true);
			}
		}
	}

	// Variables declaration - do not modify
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pageHeading;
    private javax.swing.JButton postButton;
    private javax.swing.JTextArea postTextArea;
	private javax.swing.JLabel errorLabel;
    // End of variables declaration
}
