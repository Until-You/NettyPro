package cn.layfolk.nio;

import java.nio.ByteBuffer;

/**
 * @Author 王津
 * @Date 2020/9/23
 * @Version 1.0
 */
public class _05NIOByteBufferPutGet {

    public static void main(String[] args) {

        //创建一个Buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        //类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(8);
        buffer.putChar('小');
        buffer.putShort((short) 4);

        //取出
        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());

    }
}
