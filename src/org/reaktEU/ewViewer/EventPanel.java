/*
 * Copyright (C) 2014 by gempa GmbH - http://gempa.de
 * License: http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 */
package org.reaktEU.ewViewer;

import org.reaktEU.ewViewer.data.EventData;
import org.reaktEU.ewViewer.data.EventTimeListener;
import org.reaktEU.ewViewer.data.GeoCalc;
import org.reaktEU.ewViewer.data.POI;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import static java.lang.Math.abs;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Stephan Herrnkind <herrnkind@gempa.de>
 */
public class EventPanel extends javax.swing.JPanel implements EventTimeListener {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        javax.swing.JLabel eventCaptionLabel = new javax.swing.JLabel();
        eventLabel = new javax.swing.JLabel();
        javax.swing.JLabel timeCaptionLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        javax.swing.JLabel magnitudeCaptionLabel = new javax.swing.JLabel();
        magnitudeLabel = new javax.swing.JLabel();
        javax.swing.JLabel lacationCaptionLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        javax.swing.JLabel depthCaptionLabel = new javax.swing.JLabel();
        depthLabel = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        javax.swing.JLabel targetCaptionLabel = new javax.swing.JLabel();
        targetCombo = new javax.swing.JComboBox();
        javax.swing.JLabel timeRemainingCaptionLabel = new javax.swing.JLabel();
        timeRemainingLabel = new javax.swing.JLabel();
        javax.swing.JLabel pgaCaptionLabel = new javax.swing.JLabel();
        pgaLabel = new javax.swing.JLabel();
        javax.swing.JLabel pgvCaptionLabel = new javax.swing.JLabel();
        pgvLabel = new javax.swing.JLabel();
        javax.swing.JLabel psaCaptionLabel = new javax.swing.JLabel();
        psaLabel = new javax.swing.JLabel();
        javax.swing.JLabel intensityCaptionLabel = new javax.swing.JLabel();
        intensityLabel = new javax.swing.JLabel();
        javax.swing.JLabel likelihoodCaptionLabel = new javax.swing.JLabel();
        likelihoodLabel = new javax.swing.JLabel();

        setEnabled(false);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        setLayout(layout);

        eventCaptionLabel.setLabelFor(eventLabel);
        eventCaptionLabel.setText("Event");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(eventCaptionLabel, gridBagConstraints);

        eventLabel.setText("gfz2014abcd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        add(eventLabel, gridBagConstraints);

        timeCaptionLabel.setLabelFor(timeLabel);
        timeCaptionLabel.setText("Time");
        timeCaptionLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(timeCaptionLabel, gridBagConstraints);

        timeLabel.setText("2014-11-01 01:02:45.123 (7.8s ago)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        add(timeLabel, gridBagConstraints);

        magnitudeCaptionLabel.setLabelFor(magnitudeLabel);
        magnitudeCaptionLabel.setText("Magnitude");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(magnitudeCaptionLabel, gridBagConstraints);

        magnitudeLabel.setText("3.4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(magnitudeLabel, gridBagConstraints);

        lacationCaptionLabel.setLabelFor(locationLabel);
        lacationCaptionLabel.setText("Location");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(lacationCaptionLabel, gridBagConstraints);

        locationLabel.setText("52.123N 11.678E");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(locationLabel, gridBagConstraints);

        depthCaptionLabel.setLabelFor(depthLabel);
        depthCaptionLabel.setText("Depth");
        depthCaptionLabel.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(depthCaptionLabel, gridBagConstraints);

        depthLabel.setText("3.4km");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(depthLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(separator, gridBagConstraints);

        targetCaptionLabel.setLabelFor(targetCombo);
        targetCaptionLabel.setText("Target");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(targetCaptionLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(targetCombo, gridBagConstraints);

        timeRemainingCaptionLabel.setLabelFor(timeRemainingLabel);
        timeRemainingCaptionLabel.setText("Time remaining");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(timeRemainingCaptionLabel, gridBagConstraints);

        timeRemainingLabel.setText("10.4s");
        timeRemainingLabel.setToolTipText("estimated arrival of S wave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(timeRemainingLabel, gridBagConstraints);

        pgaCaptionLabel.setLabelFor(pgaLabel);
        pgaCaptionLabel.setText("PGA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(pgaCaptionLabel, gridBagConstraints);

        pgaLabel.setText("2.3m/s²");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(pgaLabel, gridBagConstraints);

        pgvCaptionLabel.setLabelFor(pgvLabel);
        pgvCaptionLabel.setText("PGV");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(pgvCaptionLabel, gridBagConstraints);

        pgvLabel.setText("3m/s");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(pgvLabel, gridBagConstraints);

        psaCaptionLabel.setLabelFor(psaLabel);
        psaCaptionLabel.setText("PSA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(psaCaptionLabel, gridBagConstraints);

        psaLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(psaLabel, gridBagConstraints);

        intensityCaptionLabel.setLabelFor(intensityLabel);
        intensityCaptionLabel.setText("Intensity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(intensityCaptionLabel, gridBagConstraints);

        intensityLabel.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(intensityLabel, gridBagConstraints);

        likelihoodCaptionLabel.setLabelFor(likelihoodLabel);
        likelihoodCaptionLabel.setText("Likelihood");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(likelihoodCaptionLabel, gridBagConstraints);

        likelihoodLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(likelihoodLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel depthLabel;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JLabel intensityLabel;
    private javax.swing.JLabel likelihoodLabel;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel magnitudeLabel;
    private javax.swing.JLabel pgaLabel;
    private javax.swing.JLabel pgvLabel;
    private javax.swing.JLabel psaLabel;
    private javax.swing.JSeparator separator;
    private javax.swing.JComboBox targetCombo;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeRemainingLabel;
    // End of variables declaration//GEN-END:variables

    private final List<POI> targets;
    private EventData event;
    private final DateFormat df;

    private SpectrumPlot graph = null;
    private ComboBoxModel targetComboModel = null;

    /**
     * Creates new form EventPanel1
     *
     * @param targets
     */
    public EventPanel(List<POI> targets) {
        this.targets = targets;
        event = null;
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

        initComponents();

        targetCombo.setEnabled(!targets.isEmpty());
        if (!targets.isEmpty()) {
            targetComboModel = new javax.swing.DefaultComboBoxModel(targets.toArray());
            targetCombo.setModel(targetComboModel);
            targetCombo.addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    if (e.getWheelRotation() < 0) {
                        int i = targetCombo.getSelectedIndex() - 1;
                        if (i >= 0) {
                            targetCombo.setSelectedIndex(i);
                        }
                    } else {
                        int i = targetCombo.getSelectedIndex() + 1;
                        if (i < targetComboModel.getSize()) {
                            targetCombo.setSelectedIndex(i);
                        }
                    }
                }
            });
        }

        processEventTime(null, null);

        List<Integer> scores = Arrays.asList(42, 13, 5, 19, 33, 65, 11, 12, 14, 15);

        graph = new SpectrumPlot(scores);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 26;
        c.gridwidth = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.anchor = java.awt.GridBagConstraints.WEST;
        c.weighty = 1.0;

        add(graph, c);
    }

    @Override
    synchronized public void processEventTime(EventData event, Long originTimeOffset) {
        boolean enabled = event != null;
        this.event = event;
        for (Component c : getComponents()) {
            c.setEnabled(enabled);
        }

        if (event == null) {
            eventLabel.setText("-");
            timeLabel.setText("-");
            magnitudeLabel.setText("-");
            locationLabel.setText("-");
            depthLabel.setText("-");

            timeRemainingLabel.setText("-");
            pgaLabel.setText("-");
            pgvLabel.setText("-");
            psaLabel.setText("-");
            intensityLabel.setText("-");
            likelihoodLabel.setText("-");

        } else {
            eventLabel.setText(event.eventID);

            if (originTimeOffset == null) {
                timeLabel.setText(df.format(event.time));
            } else {
                timeLabel.setText(String.format("%s (%.2fs ago)",
                                                df.format(event.time),
                                                (double) originTimeOffset / 1000.0));
            }

            magnitudeLabel.setText(String.format("%.1f", event.magnitude));
            locationLabel.setText(String.format("%.2f%s %.2f%s",
                                                abs(event.latitude),
                                                event.latitude < 0 ? "S" : "N",
                                                abs(event.longitude),
                                                event.longitude < 0 ? "W" : "E"));
            depthLabel.setText(String.format("%.1fkm", event.depth));

            if (targetCombo.getSelectedItem() != null && originTimeOffset != null) {
                POI target = (POI) targetCombo.getSelectedItem();
                double vs = 3.3; // km/s
                double[] pEvent = GeoCalc.Geo2Cart(event.latitude, event.longitude, -event.depth * 1000);
                double[] pTarget = GeoCalc.Geo2Cart(target.latitude, target.longitude, target.altitude);
                double distance = GeoCalc.Distance3D(pEvent, pTarget);
//                System.out.println(Arrays.toString(pEvent) + "  -  "
//                                   + Arrays.toString(pTarget) + "  -  "
//                                   + distance);
                double eta = distance / vs - originTimeOffset;
                timeRemainingLabel.setText(String.format("%.1fs", eta / 1000.0));
            } else {
                timeRemainingLabel.setText("-");
            }
        }
    }

}
