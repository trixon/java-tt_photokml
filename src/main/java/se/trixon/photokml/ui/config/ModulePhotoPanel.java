/*
 * Copyright 2017 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.trixon.photokml.ui.config;

import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import se.trixon.almond.util.Dict;
import se.trixon.almond.util.icons.material.MaterialIcon;
import se.trixon.photokml.profile.Profile;
import se.trixon.photokml.profile.ProfilePhoto;
import se.trixon.photokml.profile.ProfilePhoto.Reference;

/**
 *
 * @author Patrik Karlsson
 */
public class ModulePhotoPanel extends ModulePanel {

    private ProfilePhoto mProfilePhoto = new ProfilePhoto(mProfile);

    /**
     * Creates new form ModulePhotoPanel
     */
    public ModulePhotoPanel() {
        initComponents();
        mTitle = Dict.PHOTO.toString();
        init();
    }

    @Override
    public StringBuilder getHeaderBuilder() {
        StringBuilder sb = new StringBuilder();

        sb.append(mTitle).append("\n");

        optAppend(sb, mProfilePhoto.isLimitWidth(), String.format("%s: %s", widthCheckBox.getText(), mProfilePhoto.getWidthLimit()));
        optAppend(sb, mProfilePhoto.isLimitHeight(), String.format("%s: %s", heightCheckBox.getText(), mProfilePhoto.getHeightLimit()));
        optAppend(sb, lowerCaseExtCheckBox.isSelected(), lowerCaseExtCheckBox.getText());
//        optAppend(sb, mProfilePhoto.isBaseUrl(), String.format("%s: %s",
//                urlCheckBox.getText(),
//                urlTextField.getText()));

        sb.append("\n");

        return sb;
    }

    @Override
    public ImageIcon getIcon() {
        return MaterialIcon._Image.PHOTO.get(ICON_SIZE, getIconColor());
    }

    @Override
    public boolean hasValidSettings() {
        return true;
    }

    private void init() {

        urlTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveOption();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveOption();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saveOption();
            }

            private void saveOption() {
                mProfilePhoto.setBaseUrlValue(urlTextField.getText());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        referenceButtonGroup = new javax.swing.ButtonGroup();
        widthCheckBox = new javax.swing.JCheckBox();
        widthSpinner = new javax.swing.JSpinner();
        heightCheckBox = new javax.swing.JCheckBox();
        heightSpinner = new javax.swing.JSpinner();
        urlTextField = new javax.swing.JTextField();
        lowerCaseExtCheckBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        referenceLabel = new javax.swing.JLabel();
        relativeRadioButton = new javax.swing.JRadioButton();
        absoluteRadioButton = new javax.swing.JRadioButton();
        absolutePathRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("se/trixon/photokml/ui/config/Bundle"); // NOI18N
        widthCheckBox.setText(bundle.getString("ModulePhotoPanel.widthCheckBox.text")); // NOI18N
        widthCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widthCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(widthCheckBox, gridBagConstraints);

        widthSpinner.setModel(new javax.swing.SpinnerNumberModel(400, 1, null, 1));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, widthCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), widthSpinner, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        widthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                widthSpinnerStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(widthSpinner, gridBagConstraints);

        heightCheckBox.setText(bundle.getString("ModulePhotoPanel.heightCheckBox.text")); // NOI18N
        heightCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 3, 0);
        add(heightCheckBox, gridBagConstraints);

        heightSpinner.setModel(new javax.swing.SpinnerNumberModel(400, 1, null, 1));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, heightCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), heightSpinner, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        heightSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                heightSpinnerStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(heightSpinner, gridBagConstraints);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, absolutePathRadioButton, org.jdesktop.beansbinding.ELProperty.create("${selected}"), urlTextField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 24, 3, 0);
        add(urlTextField, gridBagConstraints);

        lowerCaseExtCheckBox.setText(bundle.getString("ModulePhotoPanel.lowerCaseExtCheckBox.text")); // NOI18N
        lowerCaseExtCheckBox.setToolTipText(bundle.getString("ModulePhotoPanel.lowerCaseExtCheckBox.toolTipText")); // NOI18N
        lowerCaseExtCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowerCaseExtCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 3, 0);
        add(lowerCaseExtCheckBox, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel2, gridBagConstraints);

        referenceLabel.setText(Dict.FILE_REFERENCE.toString());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(referenceLabel, gridBagConstraints);

        referenceButtonGroup.add(relativeRadioButton);
        relativeRadioButton.setText(Dict.RELATIVE.toString());
        relativeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relativeRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(relativeRadioButton, gridBagConstraints);

        referenceButtonGroup.add(absoluteRadioButton);
        absoluteRadioButton.setText(Dict.ABSOLUTE.toString());
        absoluteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absoluteRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(absoluteRadioButton, gridBagConstraints);

        referenceButtonGroup.add(absolutePathRadioButton);
        absolutePathRadioButton.setText(bundle.getString("ModulePhotoPanel.absolutePathRadioButton.text")); // NOI18N
        absolutePathRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absolutePathRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(absolutePathRadioButton, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void widthCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widthCheckBoxActionPerformed
        mProfilePhoto.setLimitWidth(widthCheckBox.isSelected());
    }//GEN-LAST:event_widthCheckBoxActionPerformed

    private void heightCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightCheckBoxActionPerformed
        mProfilePhoto.setLimitHeight(heightCheckBox.isSelected());
    }//GEN-LAST:event_heightCheckBoxActionPerformed

    private void lowerCaseExtCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowerCaseExtCheckBoxActionPerformed
        mProfilePhoto.setForceLowerCaseExtension(lowerCaseExtCheckBox.isSelected());
    }//GEN-LAST:event_lowerCaseExtCheckBoxActionPerformed

    private void widthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_widthSpinnerStateChanged
        mProfilePhoto.setWidthLimit((Integer) widthSpinner.getModel().getValue());
    }//GEN-LAST:event_widthSpinnerStateChanged

    private void heightSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_heightSpinnerStateChanged
        mProfilePhoto.setHeightLimit((Integer) heightSpinner.getModel().getValue());
    }//GEN-LAST:event_heightSpinnerStateChanged

    private void relativeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relativeRadioButtonActionPerformed
        mProfilePhoto.setReference(Reference.RELATIVE);
    }//GEN-LAST:event_relativeRadioButtonActionPerformed

    private void absoluteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absoluteRadioButtonActionPerformed
        mProfilePhoto.setReference(Reference.ABSOLUTE);
    }//GEN-LAST:event_absoluteRadioButtonActionPerformed

    private void absolutePathRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absolutePathRadioButtonActionPerformed
        mProfilePhoto.setReference(Reference.ABSOLUTE_PATH);
    }//GEN-LAST:event_absolutePathRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton absolutePathRadioButton;
    private javax.swing.JRadioButton absoluteRadioButton;
    private javax.swing.JCheckBox heightCheckBox;
    private javax.swing.JSpinner heightSpinner;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox lowerCaseExtCheckBox;
    private javax.swing.ButtonGroup referenceButtonGroup;
    private javax.swing.JLabel referenceLabel;
    private javax.swing.JRadioButton relativeRadioButton;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JCheckBox widthCheckBox;
    private javax.swing.JSpinner widthSpinner;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load(Profile profile) {
        mProfilePhoto = profile.getPhoto();
        heightCheckBox.setSelected(mProfilePhoto.isLimitHeight());
        heightSpinner.setValue(mProfilePhoto.getHeightLimit());

        widthCheckBox.setSelected(mProfilePhoto.isLimitWidth());
        widthSpinner.setValue(mProfilePhoto.getWidthLimit());

        lowerCaseExtCheckBox.setSelected(mProfilePhoto.isForceLowerCaseExtension());

        urlTextField.setText(mProfilePhoto.getBaseUrlValue());
        switch (mProfilePhoto.getReference()) {
            case ABSOLUTE:
                absoluteRadioButton.setSelected(true);
                absoluteRadioButtonActionPerformed(null);
                break;

            case ABSOLUTE_PATH:
                absolutePathRadioButton.setSelected(true);
                absolutePathRadioButtonActionPerformed(null);
                break;

            case RELATIVE:
                relativeRadioButton.setSelected(true);
                relativeRadioButtonActionPerformed(null);
                break;
        }
    }
}
