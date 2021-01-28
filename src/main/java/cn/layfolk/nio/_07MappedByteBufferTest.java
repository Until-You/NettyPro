package cn.layfolk.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author 王津
 * @Date 2020/9/23
 * @Version 1.0
 */
public class _07MappedByteBufferTest {
    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

        //获取对应的通道
        FileChannel fileChannel = randomAccessFile.getChannel();

        /**
         *
         * 参数1：FileChannel.MapMode.READ_WRITE 使用的读写模式
         * 参数2：0，可以直接修改的起始位置
         * 参数3：5，是映射到内存的大小（不是索引位置），即将1.txt的多少个字节映射到内存
         * 可以直接修改的范围就是0-5
         * 实际类型DirectByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');
        mappedByteBuffer.put(5, (byte) 'y'); //IndexOutOfBoundsException

        randomAccessFile.close();
        System.out.println("修改成功。。");

    }
}
