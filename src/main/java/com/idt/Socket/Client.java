package com.idt.Socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Client {
    //客户端
    public static boolean sendMsg(byte[] message) throws Exception{
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedReader bufferedReader = null;
        //创建Socket对象
        Socket socket=new Socket("localhost",5203);
        try {
            //根据输入输出流和服务端连接
            outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息

            int length = 1024;//定义每次发送的数组长度
            byte[] bytes = new byte[length];
            System.out.println(message.length/length);
            int sendnum = message.length/length+1;
            //循环发送
            for (int i = 0; i <sendnum; i++) {
                if ((i+1)*length<=message.length-1) {
                    if (i == 0) {
                        bytes = Arrays.copyOfRange(message, i*length, (i+1)*length);
                    }else {
                        bytes = Arrays.copyOfRange(message, i*length+1, (i+1)*length+1);
                    }
                }else {
                    System.out.println(i*length);
                    System.out.println(message.length-1);
                    if (i == 0) {
                        bytes = Arrays.copyOfRange(message, i*length, message.length);
                    }else {
                        bytes = Arrays.copyOfRange(message, i*length+1, message.length);
                    }

                }
                outputStream.write(bytes,0,bytes.length);
            }
            socket.shutdownOutput();//关闭输出流

            inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
            bufferedReader=new BufferedReader(inputStreamReader);//缓冲区
            String info="";
            String temp=null;//临时变量
//            System.out.println("服务端的回执数据："+bufferedReader.readLine());
            if (bufferedReader.readLine().indexOf("I got it")!=-1) {
                System.out.println("成功");
                return true;
            }else {
                System.out.println("失败");
                return false;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭相对应的资源
            bufferedReader.close();
            inputStream.close();
//            printWriter.close();
            outputStream.close();
            socket.close();
        }
        return false;
    }
}
