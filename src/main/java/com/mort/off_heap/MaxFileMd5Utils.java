package com.mort.off_heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

public class MaxFileMd5Utils {

    private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    private static final Logger logger = LoggerFactory.getLogger(MaxFileMd5Utils.class);


    /**
     * Caused by: java.lang.IllegalArgumentException: Size exceeds Integer.MAX_VALUE
     * 	at sun.nio.ch.FileChannelImpl.map(FileChannelImpl.java:868)
     */

    /**
     * 获取文件的md5值  支持超过Integer.MAX_VALUE大小文件读取  堆外内存读取
     *
     * @param filePath
     * @return
     */
    public String getMd5ByFilePath(String filePath) {
        String value = null;
        File file = new File(filePath);

        try (FileInputStream in = new FileInputStream(file)) {
            FileChannel channel = in.getChannel();
            long fileSize = channel.size();
            long chunkSize = Integer.MAX_VALUE;
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //分块读取文件 防止一次性读取 报错
            for (long offset = 0; offset < fileSize; offset += chunkSize) {
                long size = Math.min(chunkSize, fileSize - offset);
                md5.update(channel.map(FileChannel.MapMode.READ_ONLY, offset, size));
            }

            value = encodeHex(md5.digest());
            return value;
        } catch (Exception e) {
            logger.error("getMd5ByFilePath error", e);
            throw new IllegalStateException(e);
        }
    }

    private static String encodeHex(byte[] bytes) {
        char[] chars = new char[32];

        for (int i = 0; i < chars.length; i += 2) {
            byte b = bytes[i / 2];
            chars[i] = HEX_CHARS[b >>> 4 & 15];
            chars[i + 1] = HEX_CHARS[b & 15];
        }

        return (new String(chars)).toUpperCase();
    }
}
