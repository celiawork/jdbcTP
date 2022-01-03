package fr.diginamic.jdbc;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Graphic {

	/**
	 * Méthode pour faire de l'art ASCII.
	 * 
	 * @param str Caractères que vous souhaitez transformer en art ASCII
	 * @renvoie le caractère StringBuilder devenu art ASCII
	 */
	public static StringBuilder createAscii(String str) {

		// La taille du graphique à générer
		int height = 30;
		int width = 200;
		// Position de départ du dessin
		int startX = 2;
		int stratY = 20;

		// Définir la police
		Font font = new Font("Arial", Font.BOLD, 14);
		StringBuilder sysout = new StringBuilder("\n");

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();

		// Convertir le texte en graphique
		Graphics2D g = (Graphics2D) graphics;
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(font);
		g.drawString(str, startX, stratY);

		// Transcrit en art ASCII basé sur le graphique
		for (int y = 0; y < height; y++) {
			StringBuilder stringBuilder = new StringBuilder();

			for (int x = 0; x < width; x++) {
				stringBuilder.append(bufferedImage.getRGB(x, y) == -16777216 ? " " : "@");
			}
			if (stringBuilder.toString().trim().isEmpty()) {
				continue;
			}
			sysout.append("\n" + stringBuilder);
		}
		sysout.append("\n");
		return sysout;
	}

}
