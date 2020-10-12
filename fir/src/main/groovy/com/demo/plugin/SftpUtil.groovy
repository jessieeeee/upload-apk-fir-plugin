package com.demo.plugin

import com.jcraft.jsch.Channel
import com.jcraft.jsch.ChannelSftp
import com.jcraft.jsch.JSch
import com.jcraft.jsch.JSchException
import com.jcraft.jsch.Session
import com.jcraft.jsch.SftpException

/**
 * @author: JessieKate
 * @date: 2020/10/10
 * @email: lyj1246505807@gmail.com
 * @description:
 */

public class SftpUtil {
    private ChannelSftp sftp

    private Session session
    /** FTP 登录用户名*/
    private String username
    /** FTP 登录密码*/
    private String password
    /** FTP 服务器地址IP地址*/
    private String host
    /** FTP 端口*/
    private int port


    /**
     * 构造基于密码认证的sftp对象
     * @param username
     * @param password
     * @param host
     * @param port
     */
    SftpUtil(String username, String password, String host, int port) {
        this.username = username
        this.password = password
        this.host = host
        this.port = port
    }


    /**
     * 连接sftp服务器
     *
     * @throws Exception
     */
    void login(){
        try {
            JSch jsch = new JSch()
            System.out.println("sftp connect by host:"+host+"username:"+username)

            session = jsch.getSession(username, host, port)
            System.out.println("Session is build")
            if (password != null) {
                session.setPassword(password)
            }
            Properties config = new Properties()
            config.put("StrictHostKeyChecking", "no")

            session.setConfig(config)
            session.connect()
            System.out.println("Session is connected")

            Channel channel = session.openChannel("sftp")
            channel.connect()
            System.out.println("channel is connected")

            sftp = (ChannelSftp) channel
            System.out.println(String.format("sftp server host:[%s] port:[%s] is connect successfull", host, port))
        } catch (JSchException e) {
            System.out.println("Cannot connect to specified sftp server:"+ e.getMessage() )
        }
    }

    /**
     * 关闭连接 server
     */
    void logout(){
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect()
                System.out.println("sftp is closed already")
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect()
                System.out.println("sshSession is closed already")
            }
        }
    }

    /**
     * 将输入流的数据上传到sftp作为文件
     *
     * @param directory
     *            上传到该目录
     * @param sftpFileName
     *            sftp端文件名
     * @param input
     *            输入流
     * @throws SftpException
     * @throws Exception
     */
    void upload(String directory, File file) throws SftpException {
        try {
            sftp.cd(directory)
        } catch (SftpException e) {
            System.out.println("directory is not exist")
            sftp.mkdir(directory)
            sftp.cd(directory)
        }
        sftp.put(new FileInputStream(file), file.getName(), new SftpMonitor(file.length()))
        System.out.println("upload successful")
    }

    /**
     * 上传单个文件
     *
     * @param directory
     *            上传到sftp目录
     * @param uploadFile
     *            要上传的文件,包括路径
     * @throws FileNotFoundException
     * @throws SftpException
     * @throws Exception
     */
    void upload(String directory, String uploadFile) throws FileNotFoundException, SftpException{
        File file = new File(uploadFile)
        upload(directory, file)
    }


}