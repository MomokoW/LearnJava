package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by momoko on 2020/3/24.
 */
public class FileUtils {
    public static void main(String[] args) {
        File file =  new File("E:/360Downloads/test.pdf");
        try {
            String[] names = divideFile(file.getAbsolutePath(),1000,".pdf");
            for(int i = 0;i < names.length;i++) {
                System.out.println(names[i]);
            }
            uniteFile(names,"E:/test.pdf");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 分割文件
     * @param fileName 待分割的文件名
     * @param size 小文件的大小，以字节为单位
     * @param suffix 生成的文件名后缀
     * @return  分割后的小文件的文件名
     * @throws Exception 分割过程中可能抛出的异常
     */
    public static String[] divideFile(String fileName, long size, String suffix) throws Exception {
        File inFile = new File(fileName);
        if (!inFile.exists() || inFile.isDirectory()) {
            throw new Exception("not found file.");
        }
        File parentFile = inFile.getParentFile();
        long fileLength = inFile.length();
        if (size <= 0) {
            size = fileLength / 2;
        }
        int num = (int) ((fileLength + size - 1) / size);
        String[] outFileNames = new String[num];
        FileInputStream in = new FileInputStream(inFile);
        long inEndIndex = 0;
        int inBeginIndex = 0;
        for (int outFileIndex = 0; outFileIndex < num; outFileIndex++) {
            File outFile = new File(parentFile, inFile.getName() + outFileIndex + suffix);
            FileOutputStream out = new FileOutputStream(outFile);
            inEndIndex += size;
            inEndIndex = (inEndIndex > fileLength) ? fileLength : inEndIndex;
            for (; inBeginIndex < inEndIndex; inBeginIndex++) {
                out.write(in.read());
            }
            out.close();
            outFileNames[outFileIndex] = outFile.getAbsolutePath();
        }
        in.close();
        return outFileNames;
    }

    /**
     * 合并文件
     * @param fileNames 待合并的文件名，是一个数组
     * @param targetFileName 目标文件名
     * @return  目标文件的全路径
     * @throws Exception 合并过程中可能抛出的异常
     */
    public static String uniteFile(String[] fileNames, String targetFileName) throws Exception {
        File inFile = null;
        File outFile = new File(targetFileName);
        FileOutputStream out = new FileOutputStream(outFile);
        for (int i = 0; i < fileNames.length; i++) {
            inFile = new File(fileNames[i]);
            FileInputStream in = new FileInputStream(inFile);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
        }
        out.close();
        return outFile.getAbsolutePath();
    }
}