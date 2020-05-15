package NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Author:  lining17
 * Date :  2020-04-04
 */
public class ByteBufferFileIO {

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/mort/Downloads/处理器虚拟化技术.pdf");
            FileOutputStream fileOutputStream = new FileOutputStream("./copy.pdf");
            ByteBuffer bf = ByteBuffer.allocateDirect(1024);
            FileChannel inChannel = fileInputStream.getChannel();
            FileChannel outChannel = fileOutputStream.getChannel();

            while(true){
                int eof = inChannel.read(bf);
                bf.flip();
                if(eof == -1 ) break;
                outChannel.write(bf);
                bf.clear();
            }
            inChannel.close();
            outChannel.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException io){

        }catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
