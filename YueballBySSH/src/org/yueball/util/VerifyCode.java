package org.yueball.util;
import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics;  
import java.awt.image.BufferedImage;  
import java.io.ByteArrayInputStream;  
import java.io.ByteArrayOutputStream;  
import java.util.Random;  
  
import javax.imageio.ImageIO;  
import javax.imageio.stream.ImageOutputStream;  
  
public class VerifyCode {  
    private ByteArrayInputStream image;// ͼ��  
    private String str;// ��֤��  
    private static final int WIDTH = 60;  
    private static final int HEIGHT = 25;  
  
    public static void main(String[] arg) {  
        VerifyCode vcu = VerifyCode.Instance();  
        System.err.println(vcu.getVerificationCodeValue());  
    }  
  
    /** 
     * ���ܣ���ȡһ����֤�����ʵ�� 
     *  
     * @return 
     */  
    public static VerifyCode Instance() {  
        return new VerifyCode();  
    }  
  
    private VerifyCode() {  
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,  
                BufferedImage.TYPE_INT_RGB);  
        int randomNum = new Random().nextInt(3);  
        if (randomNum == 0) {  
            initNumVerificationCode(image);  
        } else{  
            initLetterAndNumVerificationCode(image);  
        }  
    }  
  
    /** 
     * ���ܣ����õ�һ����֤������� 
     */  
    public void initNumVerificationCode(BufferedImage image) {  
  
        Random random = new Random(); // ���������  
        Graphics g = initImage(image, random);  
        String sRand = "";  
        for (int i = 0; i < 4; i++) {  
            String rand = String.valueOf(random.nextInt(10));  
            sRand += rand;  
            // ����֤����ʾ��ͼ����  
            g.setColor(new Color(20 + random.nextInt(110), 20 + random  
                    .nextInt(110), 20 + random.nextInt(110)));  
            // ���ú�����������ɫ��ͬ����������Ϊ����̫�ӽ�������ֻ��ֱ������  
            g.drawString(rand, 13 * i + 6, 16);  
        }  
        this.setStr(sRand);/* ��ֵ��֤�� */  
        // ͼ����Ч  
        g.dispose();  
        this.setImage(drawImage(image));  
    }  
  
    /** 
     * ���ܣ����õڶ�����֤������ 
     */  
    public void initLetterAndNumVerificationCode(BufferedImage image) {  
  
        Random random = new Random(); // ���������  
        Graphics g = initImage(image, random);  
        String[] letter = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",  
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
                "W", "X", "Y", "Z" };  
        String sRand = "";  
        for (int i = 0; i < 4; i++) {  
            String tempRand = "";  
            if (random.nextBoolean()) {  
                tempRand = String.valueOf(random.nextInt(10));  
            } else {  
                tempRand = letter[random.nextInt(25)];  
                if (random.nextBoolean()) {// ���������ĸ���Сд  
                    tempRand = tempRand.toLowerCase();  
                }  
            }  
            sRand += tempRand;  
            g.setColor(new Color(20 + random.nextInt(10), 20 + random  
                    .nextInt(110), 20 + random.nextInt(110)));  
            g.drawString(tempRand, 13 * i + 6, 16);  
        }  
        this.setStr(sRand);/* ��ֵ��֤�� */  
        g.dispose(); // ͼ����Ч  
        this.setImage(drawImage(image));  
    }  
  
    /** 
     * ���ܣ����õ�������֤������ ������+��=24 
     */  
    // public void initChinesePlusNumVerificationCode(BufferedImage image) {  
    // String[] cn = { "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��", "ʰ" };  
    // Random random = new Random(); // ���������  
    // Graphics g = initImage(image, random);  
    // int x = random.nextInt(10) + 1;  
    // int y = random.nextInt(30);  
    // this.setStr(String.valueOf(y));  
    // g.setFont(new Font("����", Font.PLAIN, 14));// �趨����  
    // g.setColor(new Color(20 + random.nextInt(10), 20 + random.nextInt(110),  
    // 20 + random.nextInt(110)));  
    // g.drawString(cn[x - 1], 1 * 1 + 6, 16);  
    // g.drawString("+", 22, 16);  
    // g.drawString("��", 35, 16);  
    // g.drawString("=", 48, 16);  
    // g.drawString(String.valueOf(x + y), 61, 16);  
    // g.dispose(); // ͼ����Ч  
    // this.setImage(drawImage(image));  
    //  
    // }  
  
    public Graphics initImage(BufferedImage image, Random random) {  
        Graphics g = image.getGraphics(); // ��ȡͼ��������  
        g.setColor(getRandColor(200, 250));// �趨����ɫ  
        g.fillRect(0, 0, WIDTH, HEIGHT);  
        g.setFont(new Font("Times New Roman", Font.PLAIN, 14));// �趨����  
        g.setColor(getRandColor(160, 200)); // �������165�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽  
        for (int i = 0; i < 165; i++) {  
            int x = random.nextInt(WIDTH);  
            int y = random.nextInt(HEIGHT);  
            int xl = random.nextInt(12);  
            int yl = random.nextInt(12);  
            g.drawLine(x, y, x + xl, y + yl);  
        }  
        return g;  
    }  
  
    public ByteArrayInputStream drawImage(BufferedImage image) {  
        ByteArrayInputStream input = null;  
        ByteArrayOutputStream output = new ByteArrayOutputStream();  
        try {  
            ImageOutputStream imageOut = ImageIO  
                    .createImageOutputStream(output);  
            ImageIO.write(image, "JPEG", imageOut);  
            imageOut.close();  
            input = new ByteArrayInputStream(output.toByteArray());  
        } catch (Exception e) {  
            System.out.println("��֤��ͼƬ�������ִ���" + e.toString());  
        }  
        return input;  
    }  
  
    /* 
     * ���ܣ�������Χ��������ɫ 
     */  
    private Color getRandColor(int fc, int bc) {  
        Random random = new Random();  
        if (fc > 255)  
            fc = 255;  
        if (bc > 255)  
            bc = 255;  
        int r = fc + random.nextInt(bc - fc);  
        int g = fc + random.nextInt(bc - fc);  
        int b = fc + random.nextInt(bc - fc);  
        return new Color(r, g, b);  
    }  
  
    /** 
     * ���ܣ���ȡ��֤����ַ���ֵ 
     *  
     * @return 
     */  
    public String getVerificationCodeValue() {  
        return this.getStr();  
    }  
  
    /** 
     * ���ܣ�ȡ����֤��ͼƬ 
     *  
     * @return 
     */  
    public ByteArrayInputStream getImage() {  
        return this.image;  
    }  
  
    public String getStr() {  
        return str;  
    }  
  
    public void setStr(String str) {  
        this.str = str;  
    }  
  
    public void setImage(ByteArrayInputStream image) {  
        this.image = image;  
    }  
  
}