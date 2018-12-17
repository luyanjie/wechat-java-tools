package com.xinba.wechat.common.util.fs;

import com.alibaba.fastjson.util.IOUtils;

import java.io.*;
import java.nio.file.Files;

/**
 * @author jokin
 * @date 2018/12/17 15:57
 */
public class FileUtils {

    private static final int CACHE_SIZE = 1024;

    /**
     * 创建临时文件.
     *
     * @param inputStream 输入文件流
     * @param name        文件名
     * @param ext         扩展名
     * @param tmpDirFile  临时文件夹目录
     */
    public static File createTmpFile(InputStream inputStream, String name, String ext, File tmpDirFile) throws IOException {
        File resultFile = File.createTempFile(name, '.' + ext, tmpDirFile);

        resultFile.deleteOnExit();
        OutputStream out = null;
        try {
            out = openOutputStream(resultFile,false);
            byte[] cache = new byte[CACHE_SIZE];
            int nRead = 0;
            while ((nRead = inputStream.read(cache)) != -1) {
                out.write(cache, 0, nRead);
                out.flush();
            }
            out.close();
        }
        finally {
            if(out!=null){
                out.close();
            }
        }
        return resultFile;
    }

    public static FileOutputStream openOutputStream(File file, boolean append) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }

            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parent = file.getParentFile();
            if (parent != null && !parent.mkdirs() && !parent.isDirectory()) {
                throw new IOException("Directory '" + parent + "' could not be created");
            }
        }

        return new FileOutputStream(file, append);
    }

    /**
     * 创建临时文件.
     *
     * @param inputStream 输入文件流
     * @param name        文件名
     * @param ext         扩展名
     */
    public static File createTmpFile(InputStream inputStream, String name, String ext) throws IOException {
        return createTmpFile(inputStream, name, ext, Files.createTempDirectory("weixin-java-tools-temp").toFile());
    }
}
