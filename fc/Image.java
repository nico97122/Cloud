/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.awt.image.BufferedImage;

/**
 *
 * @author nicol
 */
public class Image {

    private BufferedImage img;
    private String id;
    private String NumArchivage;

    public Image(BufferedImage img, String id, String NumArchivage) {
        this.id=id;
        this.img=img;
        this.NumArchivage=NumArchivage;
    }
}
