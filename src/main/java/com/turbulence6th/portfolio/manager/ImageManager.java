package com.turbulence6th.portfolio.manager;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public class ImageManager {

    private BufferedImage[] pages;

    public ImageManager() throws IOException {
        PDDocument document = PDDocument.load(new ClassPathResource("/static/cv.pdf").getFile());
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        int numberOfPages = document.getNumberOfPages();
        pages = new BufferedImage[numberOfPages];
        for (int i = 0; i < numberOfPages; i++) {
            pages[i] = pdfRenderer.renderImageWithDPI(i, 300, ImageType.RGB);
        }

        document.close();
    }

    public BufferedImage[] getPages() {
        return pages;
    }
}
