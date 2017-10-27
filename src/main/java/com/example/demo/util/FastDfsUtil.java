package com.example.demo.util;


import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.*;


public class FastDfsUtil {

    public static String uploadImg(InputStream in) {

        try {
            String conf_filename = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath() + "fastfds_client.properties";
            ClientGlobal.init(conf_filename);
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);

            NameValuePair[] metaList = new NameValuePair[1];
            metaList[0] = new NameValuePair("fileName", "");
            String fileId = client.upload_file1(input2byte(in), "jpg", metaList);
            System.out.println("upload success. file id is: " + fileId);

            trackerServer.close();
            return fileId;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

    }

    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }


    public static byte[] imageToByteArray(String imgPath) {
        BufferedInputStream in;
        try {
            in = new BufferedInputStream(new FileInputStream(imgPath));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int size = 0;
            byte[] temp = new byte[1024];
            while ((size = in.read(temp)) != -1) {
                out.write(temp, 0, size);
            }
            in.close();
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        File file = new File("E:\\tupian\\2.jpg");
        try {
            InputStream input = new FileInputStream(file);
            String id = uploadImg(input);
            System.out.println(id);
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        }

    }
}
