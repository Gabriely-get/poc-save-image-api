package com.image.upload.tcc.Image.base64;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    public Image saveImage(String base64) throws IOException {
        Image image = new Image();
        image.setBase64(base64);
        image.setCreatedAt(new Date());

        imageRepository.save(image);

        return image;
    }

    public String getImage(Long id) throws IOException {
        Image image = imageRepository.findById(id).get();
        return image.getBase64();

        /*
        CONVERT IMAGE SAVED ON DISK IN BASE64
        String path = image.getPath();
        Path file = Paths.get(path);
        byte[] bytes = Files.readAllBytes(file);

        String bytesToBase64 = Base64.getEncoder().encodeToString(bytes);
        InputStream inputStream = new ByteArrayInputStream(Base64.getDecoder().decode(bytesToBase64));
        BufferedImage bufferedImage = ImageIO.read(inputStream);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);

        */
    }

    public List<String> getImage() throws IOException {
        Iterable<Image> image = imageRepository.findAll();
        List<String> images = new ArrayList<>();

        image.forEach(image1 -> images.add(image1.getBase64()));
        return images;

        /*
        for (Image img:
             image) {


            String path = img.getBase64();
            Path file = Paths.get(path);
            byte[] bytes = Files.readAllBytes(file);

            String bytesToBase64 = Base64.getEncoder().encodeToString(bytes);
            InputStream inputStream = new ByteArrayInputStream(Base64.getDecoder().decode(bytesToBase64));
            BufferedImage bufferedImage = ImageIO.read(inputStream);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            images.add(baos.toByteArray());
            i
        } */
    }

    /* create hash as image name when saving image on disk
    private String createPath(String base64) {
        String hash = DigestUtils.sha256Hex(base64);

        return String.format("%s/%s.png", image_directory, hash);
    } */

}
