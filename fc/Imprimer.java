/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author nguil
 */
public class Imprimer implements Printable {

    public Imprimer(JTextArea panel) {

        documentTitle = "";
        this.panel = panel;
        initPrintablePanel();
    }

    public void initPrintablePanel() {

        showPrintZone = false;
        fitIntoPage = false;
        wrapComponent = false;
        printJob = PrinterJob.getPrinterJob();
        pageFormat = printJob.defaultPage();
        pageFormat.setOrientation(1);
    }

    /**
     * Permet d'orienter la page a imprimer
     *
     * @param orientation prend un int
     */
    public void setOrientation(int orientation) {
        pageFormat.setOrientation(orientation);
    }

    public void setPrintZoneVisible(boolean status) {
        showPrintZone = status;
    }

    public void setWrapComponent(boolean status) {
        wrapComponent = status;
    }

    public void setFitIntoPage(boolean status) {
        fitIntoPage = status;
    }

    /**
     * Permet d'obtenir la largeur de la page
     *
     * @return un int, la largeur
     */
    public int getPageWidth() {
        return (int) pageFormat.getImageableWidth();
    }

    /**
     * Permet d'obtenir la taille de la marge en haut
     *
     * @return un double, la taille
     */
    public double getMarginTop() {
        return pageFormat.getImageableY();
    }

    /**
     * Permet d'obtenir la taille de la marge gauche
     *
     * @return un double, la taille
     */
    public double getMarginLeft() {
        return pageFormat.getImageableX();
    }

    /**
     * Permet de definir la taille des marges du document, a gauche et a droite
     *
     * @param margin prend un int, la taille des marges
     */
    public void setLRMargins(int margin) {
        Paper paper = pageFormat.getPaper();
        paper.setImageableArea(paper.getImageableX() - (double) (margin / 2), paper.getImageableY(), paper.getImageableWidth() + (double) (margin / 2), paper.getImageableHeight());
        pageFormat.setPaper(paper);
    }

    /**
     * Permet de definir la taille des marges du document, en haut et en bas
     *
     * @param margin prend un int, la taille des marges
     */
    public void setTBMargins(int margin) {
        Paper paper = pageFormat.getPaper();
        paper.setImageableArea(paper.getImageableX(), paper.getImageableY() - (double) (margin / 2), paper.getImageableWidth(), paper.getImageableHeight() + (double) (margin / 2));
        pageFormat.setPaper(paper);
    }

    /**
     * Permet de definir le titre d'un document
     *
     * @param title prend un String, le titre
     */
    public void setDocumentTitle(String title) {
        documentTitle = title;
    }

    /**
     * Methode permettant d'imprimer
     *
     * @param g prend des Graphics
     * @param pf prend un PageFormat
     * @param pageIndex prend un int
     * @return un int, 0
     * @throws PrinterException ??
     */
    public int print(Graphics g, PageFormat pf, int pageIndex)
            throws PrinterException {
        Dimension tailleDoc = panel.getSize();
        double hauteurDocu = tailleDoc.getHeight();
        double hauteurPage = pf.getImageableHeight();
        double largeurDocu = tailleDoc.getWidth();
        double largeurPage = pf.getImageableWidth();
        int totalNumPages = (int) Math.ceil(hauteurDocu / hauteurPage);
        if (wrapComponent) {
            totalNumPages = taillePages.size();
        } else if (fitIntoPage) {
            totalNumPages = 1;
        }
        double scaleX = largeurPage / largeurDocu;
        double scaleY = hauteurPage / hauteurDocu;
        if (pageIndex >= totalNumPages) {
            return 1;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        if (fitIntoPage) {
            double ratio = Math.min(scaleX, scaleY);
            g2d.scale(ratio, ratio);
        } else if (wrapComponent) {
            if (pageIndex > 0) {
                g2d.translate(0.0D, -((Double) taillePages.get(pageIndex - 1)).doubleValue());
            }
        } else {
            g2d.translate(0.0D, (double) (-pageIndex) * hauteurPage);
        }
        panel.paint(g2d);
        if (wrapComponent) {
            double hauteurBlanc = ((Double) taillePages.get(pageIndex)).doubleValue();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, (int) hauteurBlanc, (int) largeurPage, (int) hauteurBlanc + (int) hauteurPage);
        }
        if (wrapComponent) {
            if (pageIndex > 0) {
                g2d.translate(0.0D, ((Double) taillePages.get(pageIndex - 1)).doubleValue());
            }
        } else {
            g2d.translate(0.0D, (double) pageIndex * hauteurPage);
        }
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Verdanna", 2, 10));
        g2d.drawString(documentTitle + " - [" + (pageIndex + 1) + "/" + totalNumPages + "]", 0, (int) pf.getImageableHeight() - 20);
        return 0;
    }

    /**
     * Methode lancant l'impression
     */
    public void print() {

        printJob.setPrintable(this, pageFormat);
        try {
            if (printJob.printDialog()) {
                if (wrapComponent) {
                    calculatePages();
                }
                Paper paper = pageFormat.getPaper();
                Paper save = pageFormat.getPaper();
                paper.setImageableArea(paper.getImageableX(), paper.getImageableY(), paper.getWidth() - paper.getImageableX(), paper.getHeight() - paper.getImageableY());
                pageFormat.setPaper(paper);
                printJob.setPrintable((Printable) this, pageFormat);
                printJob.print();
                pageFormat.setPaper(save);
            }
        } catch (PrinterException pe) {
            System.out.println("Erreur lors de l'impression du document: " + toString());
        }
    }

    /**
     * Calcule le nombre de pages a imprimer
     */
    private void calculatePages() {
        taillePages = new Vector();
        double hauteurPage = pageFormat.getImageableHeight();
        double hauteurTotal = 0.0D;
        double hauteurCumul = 0.0D;
        for (int i = 0; i < panel.getComponentCount(); i++) {
            int gridBagInsets = 0;
            if (panel.getLayout() instanceof GridBagLayout) {
                gridBagInsets = ((GridBagLayout) panel.getLayout()).getConstraints(panel.getComponent(i)).insets.bottom + ((GridBagLayout) panel.getLayout()).getConstraints(panel.getComponent(i)).insets.top;
            }
            double hauteurComponent = panel.getComponent(i).getSize().getHeight() + (double) gridBagInsets;
            if (hauteurComponent > hauteurPage) {
                wrapComponent = false;
                return;
            }
            hauteurTotal += hauteurComponent;
            if (hauteurTotal > hauteurPage) {
                hauteurTotal -= hauteurComponent;
                hauteurCumul += hauteurTotal;
                taillePages.add(new Double(hauteurCumul));
                hauteurTotal = hauteurComponent;
            }
        }

        hauteurCumul += hauteurTotal;
        taillePages.add(new Double(hauteurCumul));
    }

    private JTextArea panel;
    private boolean showPrintZone;
    private boolean fitIntoPage;
    private boolean wrapComponent;
    private PageFormat pageFormat;
    private PrinterJob printJob;
    private Vector taillePages;
    private String documentTitle;
    public static final int PORTRAIT = 1;
    public static final int LANDSCAPE = 0;
}
