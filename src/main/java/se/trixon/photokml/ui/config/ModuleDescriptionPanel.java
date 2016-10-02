/*
 * Copyright 2016 Patrik Karlsson.
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

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import org.apache.commons.lang3.StringUtils;
import se.trixon.almond.util.Dict;
import se.trixon.photokml.profile.Profile;
import se.trixon.photokml.profile.ProfileDescription;

/**
 *
 * @author Patrik Karlsson <patrik@trixon.se>
 */
public class ModuleDescriptionPanel extends ModulePanel {

    private ProfileDescription mDescription;

    /**
     * Creates new form ModuleDescriptionPanel
     */
    public ModuleDescriptionPanel() {
        initComponents();
        mTitle = Dict.DESCRIPTION.toString();
        init();
        externalFileCheckBox.setVisible(false);
        externalFileTextField.setVisible(false);
    }

    @Override
    public StringBuilder getHeaderBuilder() {
        StringBuilder sb = new StringBuilder();

        sb.append(Dict.DESCRIPTION.toString()).append("\n");
        optAppend(sb, mDescription.isPhoto(), Dict.PHOTO.toString());
        optAppend(sb, mDescription.isFilename(), Dict.FILENAME.toString());
        optAppend(sb, mDescription.isDate(), Dict.DATE.toString());
        optAppend(sb, mDescription.isCoordinate(), Dict.COORDINATE.toString());
        optAppend(sb, mDescription.isAltitude(), Dict.ALTITUDE.toString());
        optAppend(sb, mDescription.isBearing(), Dict.BEARING.toString());
        optAppend(sb, mDescription.isCustom(), Dict.CUSTOM_TEXT.toString());

        if (mDescription.isExternalFile() && !StringUtils.isEmpty(mDescription.getExternalFileValue())) {
            optAppend(sb, true, mBundle.getString("ModuleDescriptionPanel.externalFileCheckBox.text"));
            sb.deleteCharAt(sb.length() - 1);
            sb.append(": ");
            sb.append(mDescription.getCustomValue()).append("\n"); //TODO Verify if this is ok
        }

        if (mDescription.isCustom() && !StringUtils.isEmpty(mDescription.getCustomValue())) {
            sb.append(MULTILINE_DIVIDER).append("\n");
            sb.append(mDescription.getCustomValue()).append("\n");
            sb.append(MULTILINE_DIVIDER);
        }

        sb.append("\n");

        return sb;
    }

    @Override
    public boolean hasValidSettings() {
        return true;
    }

    private void init() {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveOption(e.getDocument());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saveOption(e.getDocument());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveOption(e.getDocument());
            }

            private void saveOption(Document document) {
                if (document == customTextArea.getDocument()) {
                    mDescription.setCustomValue(customTextArea.getText());
                } else if (document == externalFileTextField.getDocument()) {
                    mDescription.setExternalFileValue(externalFileTextField.getText());
                }
            }
        };

        customTextArea.getDocument().addDocumentListener(documentListener);
        externalFileTextField.getDocument().addDocumentListener(documentListener);
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

        bearingCheckBox = new javax.swing.JCheckBox();
        coordinateCheckBox = new javax.swing.JCheckBox();
        dateCheckBox = new javax.swing.JCheckBox();
        photoCheckBox = new javax.swing.JCheckBox();
        filenameCheckBox = new javax.swing.JCheckBox();
        altitudeCheckBox = new javax.swing.JCheckBox();
        externalFileCheckBox = new javax.swing.JCheckBox();
        externalFileTextField = new javax.swing.JTextField();
        customCheckBox = new javax.swing.JCheckBox();
        customScrollPane = new javax.swing.JScrollPane();
        customTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        bearingCheckBox.setText(Dict.BEARING.getString());
        bearingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearingCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        add(bearingCheckBox, gridBagConstraints);

        coordinateCheckBox.setText(Dict.COORDINATE.getString());
        coordinateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coordinateCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(coordinateCheckBox, gridBagConstraints);

        dateCheckBox.setText(Dict.DATE.getString());
        dateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        add(dateCheckBox, gridBagConstraints);

        photoCheckBox.setText(Dict.PHOTO.getString());
        photoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(photoCheckBox, gridBagConstraints);

        filenameCheckBox.setText(Dict.FILENAME.getString());
        filenameCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filenameCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        add(filenameCheckBox, gridBagConstraints);

        altitudeCheckBox.setText(Dict.ALTITUDE.getString());
        altitudeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altitudeCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        add(altitudeCheckBox, gridBagConstraints);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("se/trixon/photokml/ui/config/Bundle"); // NOI18N
        externalFileCheckBox.setText(bundle.getString("ModuleDescriptionPanel.externalFileCheckBox.text")); // NOI18N
        externalFileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                externalFileCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(externalFileCheckBox, gridBagConstraints);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, externalFileCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), externalFileTextField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(externalFileTextField, gridBagConstraints);

        customCheckBox.setText(Dict.CUSTOM_TEXT.getString());
        customCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        add(customCheckBox, gridBagConstraints);

        customTextArea.setColumns(20);
        customTextArea.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), customTextArea, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        customScrollPane.setViewportView(customTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(customScrollPane, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void customCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customCheckBoxActionPerformed
        mDescription.setCustom(customCheckBox.isSelected());
        customTextArea.setEnabled(customCheckBox.isSelected());
    }//GEN-LAST:event_customCheckBoxActionPerformed

    private void bearingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bearingCheckBoxActionPerformed
        mDescription.setBearing(bearingCheckBox.isSelected());
    }//GEN-LAST:event_bearingCheckBoxActionPerformed

    private void coordinateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coordinateCheckBoxActionPerformed
        mDescription.setCoordinate(coordinateCheckBox.isSelected());
    }//GEN-LAST:event_coordinateCheckBoxActionPerformed

    private void dateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateCheckBoxActionPerformed
        mDescription.setDate(dateCheckBox.isSelected());
    }//GEN-LAST:event_dateCheckBoxActionPerformed

    private void photoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoCheckBoxActionPerformed
        mDescription.setPhoto(photoCheckBox.isSelected());
    }//GEN-LAST:event_photoCheckBoxActionPerformed

    private void altitudeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altitudeCheckBoxActionPerformed
        mDescription.setAltitude(altitudeCheckBox.isSelected());
    }//GEN-LAST:event_altitudeCheckBoxActionPerformed

    private void filenameCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filenameCheckBoxActionPerformed
        mDescription.setFilename(filenameCheckBox.isSelected());
    }//GEN-LAST:event_filenameCheckBoxActionPerformed

    private void externalFileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_externalFileCheckBoxActionPerformed
        mDescription.setExternalFile(externalFileCheckBox.isSelected());
        externalFileTextField.setEnabled(externalFileCheckBox.isSelected());
    }//GEN-LAST:event_externalFileCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox altitudeCheckBox;
    private javax.swing.JCheckBox bearingCheckBox;
    private javax.swing.JCheckBox coordinateCheckBox;
    private javax.swing.JCheckBox customCheckBox;
    private javax.swing.JScrollPane customScrollPane;
    private javax.swing.JTextArea customTextArea;
    private javax.swing.JCheckBox dateCheckBox;
    private javax.swing.JCheckBox externalFileCheckBox;
    private javax.swing.JTextField externalFileTextField;
    private javax.swing.JCheckBox filenameCheckBox;
    private javax.swing.JCheckBox photoCheckBox;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load(Profile profile) {
        mProfile = profile;
        mDescription = mProfile.getDescription();

        altitudeCheckBox.setSelected(mDescription.isAltitude());
        bearingCheckBox.setSelected(mDescription.isBearing());
        coordinateCheckBox.setSelected(mDescription.isCoordinate());
        customCheckBox.setSelected(mDescription.isCustom());
        dateCheckBox.setSelected(mDescription.isDate());
        photoCheckBox.setSelected(mDescription.isPhoto());
        filenameCheckBox.setSelected(mDescription.isFilename());
        externalFileCheckBox.setSelected(mDescription.isExternalFile());
        externalFileTextField.setText(mDescription.getExternalFileValue());
        customTextArea.setText(mDescription.getCustomValue());
    }
}
