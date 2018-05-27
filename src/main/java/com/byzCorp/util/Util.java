package com.byzCorp.util;

import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Util {

    public static final String dateFormat = "dd/MM/yyyy";
    public static final String dateTimeFormat = "dd/MM/yyyy HH:mm";
    public static final String timeFormat = "HH:mm";

    public static Boolean getBoolean(JSONObject obj, String param, Boolean defaultVal) {
        if (obj.has(param) && obj.get(param) != null && !obj.get(param).equals("") && !obj.get(param).equals("null")) {
            return obj.getBoolean(param);
        }
        return defaultVal;
    }

    public static String getString(JSONObject obj, String param, String defaultVal) {
        if (obj != null) {
            if (obj.has(param) && obj.get(param) != null && !obj.get(param).equals("") && !obj.get(param).equals("null")) {
                return obj.getString(param);
            }
        }
        return defaultVal;
    }

    public static Integer getInteger(JSONObject obj, String param, Integer defaultVal) {
        if (obj != null) {
            if (obj.has(param) && obj.get(param) != null && !obj.get(param).equals("") && !obj.get(param).equals("null")) {
                return obj.getInt(param);
            }
        }
        return defaultVal;
    }

    public static Long getLong(JSONObject obj, String param, Long defaultVal) {
        if (obj != null) {
            if (obj.has(param) && obj.get(param) != null && !obj.get(param).equals("") && !obj.get(param).equals("null")) {
                return obj.getLong(param);
            }
        }
        return defaultVal;
    }

    public static Date getDate(JSONObject obj, String param, Date defaultVal, String format) {
        if (obj.has(param) && obj.get(param) != null && !obj.get(param).equals("") && !obj.get(param).equals("null")) {
            SimpleDateFormat sdf;
            if (format == null) {
                sdf = new SimpleDateFormat(dateFormat);
            } else {
                sdf = new SimpleDateFormat(format);
            }
            try {
                return sdf.parse(obj.getString(param));
            } catch (ParseException e) {
                return null;
            }
        }
        return defaultVal;
    }


    public static Integer reqInteger(String requestString, Integer defaultValue) {
        if (requestString != null && !requestString.equals("") && !requestString.equals("null")) {
            return Integer.valueOf(requestString);
        }
        return defaultValue;
    }

    public static Date reqDate(String reqStr, Date defaultVal, String format) {
        if (reqStr != null && !reqStr.equals("")) {
            SimpleDateFormat sdf;
            if (format == null) {
                sdf = new SimpleDateFormat(dateFormat);
            } else {
                sdf = new SimpleDateFormat(format);
            }
            try {
                return sdf.parse(reqStr);
            } catch (ParseException e) {
                return null;
            }
        }
        return defaultVal;
    }
    public static Long reqLong(String reqStr, Long defaultVal) {
        if (reqStr != null && !reqStr.equals("")) {
            return Long.valueOf(reqStr);
        }
        return defaultVal;
    }

    public static String reqString(String reqStr, String defaultVal) {
        if (reqStr != null && !reqStr.equals("")) {
            return reqStr;
        }
        return defaultVal;
    }

    public static Boolean reqBoolean(String reqStr, Boolean defaultVal) {
        try {
            if (reqStr != null && !reqStr.equals("")) {
                return Boolean.valueOf(reqStr);
            }
        } catch (Exception e) {
            return null;
        }
        return defaultVal;
    }

    public static BigDecimal reqBigDecimal(String reqStr, BigDecimal defaultVal) {
        if (reqStr != null && !reqStr.equals("")) {
            return new BigDecimal(reqStr);
        }
        return defaultVal;
    }

    public static byte[] getByteArrayImageUpload(HttpServletRequest request) throws IOException {
        Boolean base64 = Util.reqBoolean(request.getParameter("base64"), null);
        String base64Encoded = Util.reqString(request.getParameter("shapshot"), null);

        byte[] fileByteArray;

        if (base64 != null && base64 && base64Encoded != null && !base64Encoded.equals("")) {
            BASE64Decoder decoder = new BASE64Decoder();
            fileByteArray = decoder.decodeBuffer(base64Encoded);
        } else {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            String fileName = "";
            for (Iterator iterator = multipartRequest.getFileNames(); iterator.hasNext(); ) {
                Object type = iterator.next();
                fileName = type.toString();
            }
            MultipartFile file = multipartRequest.getFile(fileName);
            fileByteArray = file.getBytes();
        }

        return fileByteArray;
    }

    public static byte[] scaleImage(byte[] fileByteArray) {
        try {
            ImageInfo imageInfo = new ImageInfo(fileByteArray);

            int newWidth = imageInfo.getWidth();
            int newHeight = imageInfo.getHeight();

            if (newWidth > Constans.MAX_IMAGE_WIDTH || newHeight > Constans.MAX_IMAGE_HEIGHT) {

                float xScaleFactor; // width
                float yScaleFactor; // height
                float avrScaleFactor;

                xScaleFactor = (float) newWidth / (float) Constans.MAX_IMAGE_WIDTH;
                yScaleFactor = (float) newHeight / (float) Constans.MAX_IMAGE_HEIGHT;

                if (xScaleFactor > yScaleFactor) {
                    avrScaleFactor = xScaleFactor;
                } else {
                    avrScaleFactor = yScaleFactor;
                }

                newWidth = (int) (newWidth / avrScaleFactor);
                newHeight = (int) (newHeight / avrScaleFactor);
            }

            java.io.InputStream in = new ByteArrayInputStream(fileByteArray);
            BufferedImage originalImage = ImageIO.read(in);
            in.close();

            BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = newImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2.drawImage(originalImage, 0, 0, newWidth, newHeight, null);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(newImage, "jpg", baos);
            baos.flush();

            byte[] imageInByte = baos.toByteArray();
            baos.close();

            return imageInByte;
        } catch (IOException e) {
            //log.error(e.getMessage());
            return null;
        }
    }
}
