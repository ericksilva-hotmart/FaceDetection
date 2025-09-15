package com.example;

import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_objdetect.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FaceDetectionExample {
    private static final Logger log = LoggerFactory.getLogger(FaceDetectionExample.class);
    
    public static void main(String[] args) {
        try {
            // Carrega o classificador Haar Cascade do resources
            String cascadePath = extractResourceToTemp("haarcascade_frontalface_default.xml");
            CascadeClassifier faceDetector = new CascadeClassifier(cascadePath);

            if (faceDetector.empty()) {
                log.info("Erro ao carregar o classificador Haar Cascade");
                return;
            }

            // Carrega uma imagem para detecção facial do resources
            String imagePath = extractResourceToTemp("foto1.jpg");
            Mat image = imread(imagePath);

            if (image.empty()) {
                log.info("Não foi possível carregar a imagem");
                return;
            }

        // Armazena as faces detectadas
        RectVector faceDetections = new RectVector();

        // Detecta as faces na imagem
        faceDetector.detectMultiScale(image, faceDetections);

        log.info("Número de rostos detectados: {}", faceDetections.size());

        // Desenha retângulos em volta dos rostos detectados
        for (int i = 0; i < faceDetections.size(); i++) {
            Rect rect = faceDetections.get(i);
            rectangle(image, rect, new Scalar(0, 255, 0, 0), 3, LINE_8, 0);
        }

        // Salva a imagem com as detecções
        imwrite("foto1_detect.jpg", image);

        log.info("Imagem salva com as detecções.");
        } catch (Exception e) {
            log.error("Erro durante a execução: {}", e.getMessage());
        }
    }

    private static String extractResourceToTemp(String resourceName) throws Exception {
        InputStream inputStream = FaceDetectionExample.class.getClassLoader().getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new RuntimeException("Recurso não encontrado: " + resourceName);
        }
        
        Path tempFile = Files.createTempFile("opencv_", "_" + resourceName);
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();
        
        return tempFile.toString();
    }
}

