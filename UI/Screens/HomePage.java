package UI.Screens;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import Models.Post;
import Models.User;
import UI.Templates.PostTemplate;
import main.SocialMedia;

public class HomePage extends BasePage {
    public HomePage() {
        initComponents();

        loadUserPosts();

        //Bring the view to the start of page
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                scrollPane.getViewport().setViewPosition(new Point(0, 0));
            }
        });
    }

    private void loadUserPosts() {
        User user = SocialMedia.getCurrentUser();
        if (user != null) {
            // if (posts != null) {
            //     container.setPreferredSize(new Dimension(1280, (posts.size() + 1) * (200 + 10)));

            //     for (int i = 0; i < posts.size(); i++) {
            //         container.add(new PostTemplate(posts.get(i), i));
            //     }
            // }
        }
    }

    private void initComponents() {
        scrollPane = new javax.swing.JScrollPane();
        container = new javax.swing.JPanel();
        pageHeading = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        settingsButton = new javax.swing.JButton();
        addPostButton = new javax.swing.JButton();

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new java.awt.Dimension(1270, 720));

        pageHeading.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        pageHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageHeading.setText("Social Media");

        ImageIcon settingsIcon = new ImageIcon(getClass().getResource("/images/settings icon.png"));
        settingsButton.setIcon(
            new ImageIcon(settingsIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH))
        );
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        addPostButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        addPostButton.setText("Add Post");
        addPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPostButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(pageHeading)
                        .addGap(829, 829, 829)
                        .addComponent(addPostButton)
                        .addGap(18, 18, 18)
                        .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(1590, Short.MAX_VALUE))))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pageHeading)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(addPostButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1037, Short.MAX_VALUE))
        );

        scrollPane.setViewportView(container);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("settings button pressed");
        SocialMedia.states.changeState(new SettingsPage());
    }

    private void addPostButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        SocialMedia.states.changeState(new AddPostPage());
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel container;
    private javax.swing.JLabel pageHeading;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton settingsButton;
    private javax.swing.JButton addPostButton;
    // End of variables declaration
}
