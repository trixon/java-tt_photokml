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

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import org.apache.commons.lang3.StringUtils;
import se.trixon.almond.util.Dict;
import se.trixon.almond.util.swing.SwingHelper;
import se.trixon.photokml.DescriptionManager;
import se.trixon.photokml.DescriptionManager.DescriptionSegment;
import se.trixon.photokml.profile.Profile;
import se.trixon.photokml.profile.ProfileDescription;

/**
 *
 * @author Patrik Karlsson
 */
public class ModuleDescriptionPanel extends ModulePanel {

    private ProfileDescription mDescription;
    private final DescriptionManager mDescriptionManager = DescriptionManager.getInstance();
    private PhotoDescriptionMonitor mPhotoDescriptionMonitor;

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
        StringBuilder sb = new StringBuilder(Dict.DESCRIPTION.toString()).append("\n");

        if (mDescription.isCustom()) {
            final String customValue = mDescription.getCustomValue();
            if (!StringUtils.isEmpty(customValue)) {
                sb.append(MULTILINE_DIVIDER).append("\n");
                sb.append(customValue).append("\n");
                sb.append(MULTILINE_DIVIDER);
            }
        } else {
            optAppend(sb, mDescription.hasPhoto(), Dict.PHOTO.toString());
            optAppend(sb, mDescription.hasFilename(), Dict.FILENAME.toString());
            optAppend(sb, mDescription.hasDate(), Dict.DATE.toString());
            optAppend(sb, mDescription.hasCoordinate(), Dict.COORDINATE.toString());
            optAppend(sb, mDescription.hasAltitude(), Dict.ALTITUDE.toString());
            optAppend(sb, mDescription.hasBearing(), Dict.BEARING.toString());
            optAppend(sb, mDescription.isCustom(), Dict.CUSTOM_TEXT.toString());
        }
        sb.append("\n");

        return sb;
    }

    @Override
    public boolean hasValidSettings() {
        return true;
    }

    public void setPhotoDescriptionMonitor(PhotoDescriptionMonitor photoDescriptionMonitor) {
        mPhotoDescriptionMonitor = photoDescriptionMonitor;
    }

    private void descriptionModeChanged() {
        final boolean dynamic = dynamicRadioButton.isSelected();
        mDescription.setCustom(dynamic);
        customTextArea.setEnabled(dynamic);
        SwingHelper.enableComponents(staticPanel, !dynamic);
        notifyPhotoDescriptionListener();
    }

    private void init() {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveOption(e.getDocument());
                notifyPhotoDescriptionListener();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saveOption(e.getDocument());
                notifyPhotoDescriptionListener();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveOption(e.getDocument());
                notifyPhotoDescriptionListener();
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

    private void notifyPhotoDescriptionListener() {
        boolean hasPhoto = (photoCheckBox.isSelected() && photoCheckBox.isEnabled())
                || (dynamicRadioButton.isSelected() && StringUtils.containsIgnoreCase(customTextArea.getText(), "+photo"));

        mPhotoDescriptionMonitor.onPhotoDescriptionChange(hasPhoto);
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

        externalFileCheckBox = new javax.swing.JCheckBox();
        externalFileTextField = new javax.swing.JTextField();
        buttonGroup = new javax.swing.ButtonGroup();
        staticRadioButton = new javax.swing.JRadioButton();
        staticPanel = new javax.swing.JPanel();
        photoCheckBox = new javax.swing.JCheckBox();
        filenameCheckBox = new javax.swing.JCheckBox();
        dateCheckBox = new javax.swing.JCheckBox();
        coordinateCheckBox = new javax.swing.JCheckBox();
        altitudeCheckBox = new javax.swing.JCheckBox();
        bearingCheckBox = new javax.swing.JCheckBox();
        dynamicRadioButton = new javax.swing.JRadioButton();
        customScrollPane = new javax.swing.JScrollPane();
        customTextArea = new javax.swing.JTextArea();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("se/trixon/photokml/ui/config/Bundle"); // NOI18N
        externalFileCheckBox.setText(bundle.getString("ModuleDescriptionPanel.externalFileCheckBox.text")); // NOI18N
        externalFileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                externalFileCheckBoxActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, externalFileCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), externalFileTextField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        setLayout(new java.awt.GridBagLayout());

        buttonGroup.add(staticRadioButton);
        staticRadioButton.setText(Dict.STATIC.toString());
        staticRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staticRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(staticRadioButton, gridBagConstraints);

        staticPanel.setLayout(new javax.swing.BoxLayout(staticPanel, javax.swing.BoxLayout.PAGE_AXIS));

        photoCheckBox.setText(Dict.PHOTO.getString());
        photoCheckBox.setToolTipText(DescriptionSegment.PHOTO.toString());
        photoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoCheckBoxActionPerformed(evt);
            }
        });
        staticPanel.add(photoCheckBox);

        filenameCheckBox.setText(Dict.FILENAME.getString());
        filenameCheckBox.setToolTipText(DescriptionSegment.FILENAME.toString());
        filenameCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filenameCheckBoxActionPerformed(evt);
            }
        });
        staticPanel.add(filenameCheckBox);

        dateCheckBox.setText(Dict.DATE.getString());
        dateCheckBox.setToolTipText(DescriptionSegment.DATE.toString());
        dateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateCheckBoxActionPerformed(evt);
            }
        });
        staticPanel.add(dateCheckBox);

        coordinateCheckBox.setText(Dict.COORDINATE.getString());
        coordinateCheckBox.setToolTipText(DescriptionSegment.COORDINATE.toString());
        coordinateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coordinateCheckBoxActionPerformed(evt);
            }
        });
        staticPanel.add(coordinateCheckBox);

        altitudeCheckBox.setText(Dict.ALTITUDE.getString());
        altitudeCheckBox.setToolTipText(DescriptionSegment.ALTITUDE.toString());
        altitudeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altitudeCheckBoxActionPerformed(evt);
            }
        });
        staticPanel.add(altitudeCheckBox);

        bearingCheckBox.setText(Dict.BEARING.getString());
        bearingCheckBox.setToolTipText(DescriptionSegment.BEARING.toString());
        bearingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearingCheckBoxActionPerformed(evt);
            }
        });
        staticPanel.add(bearingCheckBox);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(staticPanel, gridBagConstraints);

        buttonGroup.add(dynamicRadioButton);
        dynamicRadioButton.setText(Dict.DYNAMIC.toString());
        dynamicRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(dynamicRadioButton, gridBagConstraints);

        customTextArea.setColumns(20);
        customTextArea.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JCheckBox(), org.jdesktop.beansbinding.ELProperty.create("${selected}"), customTextArea, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        customScrollPane.setViewportView(customTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(customScrollPane, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

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
        notifyPhotoDescriptionListener();
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

    private void dynamicRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicRadioButtonActionPerformed
        descriptionModeChanged();
    }//GEN-LAST:event_dynamicRadioButtonActionPerformed

    private void staticRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staticRadioButtonActionPerformed
        descriptionModeChanged();
    }//GEN-LAST:event_staticRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox altitudeCheckBox;
    private javax.swing.JCheckBox bearingCheckBox;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JCheckBox coordinateCheckBox;
    private javax.swing.JScrollPane customScrollPane;
    private javax.swing.JTextArea customTextArea;
    private javax.swing.JCheckBox dateCheckBox;
    private javax.swing.JRadioButton dynamicRadioButton;
    private javax.swing.JCheckBox externalFileCheckBox;
    private javax.swing.JTextField externalFileTextField;
    private javax.swing.JCheckBox filenameCheckBox;
    private javax.swing.JCheckBox photoCheckBox;
    private javax.swing.JPanel staticPanel;
    private javax.swing.JRadioButton staticRadioButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load(Profile profile) {
        mProfile = profile;
        mDescription = mProfile.getDescription();
        staticRadioButton.setSelected(true);
        altitudeCheckBox.setSelected(mDescription.hasAltitude());
        bearingCheckBox.setSelected(mDescription.hasBearing());
        coordinateCheckBox.setSelected(mDescription.hasCoordinate());
        dynamicRadioButton.setSelected(mDescription.isCustom());
        dateCheckBox.setSelected(mDescription.hasDate());
        photoCheckBox.setSelected(mDescription.hasPhoto());
        filenameCheckBox.setSelected(mDescription.hasFilename());
        externalFileCheckBox.setSelected(mDescription.hasExternalFile());
        externalFileTextField.setText(mDescription.getExternalFileValue());
        customTextArea.setText(mDescription.getCustomValue());

        descriptionModeChanged();
    }

    public interface PhotoDescriptionMonitor {

        void onPhotoDescriptionChange(boolean hasPhoto);
    }
}
