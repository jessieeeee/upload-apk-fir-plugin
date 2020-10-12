package com.demo.plugin

import java.text.NumberFormat
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import java.util.concurrent.Executors
import com.jcraft.jsch.SftpProgressMonitor

public class SftpMonitor implements SftpProgressMonitor, Runnable {

    private long maxCount = 0 // 文件总大小
    public long startTime = 0L // 开始上传时间
    private long uploaded = 0
    private boolean isScheduled = false

    ScheduledExecutorService executorService

    public SftpMonitor(long maxCount) {
        this.maxCount = maxCount
    }

    @Override
    public void run() {
        NumberFormat format = NumberFormat.getPercentInstance()
        format.setMaximumFractionDigits(2)
        format.setMinimumFractionDigits(2)
        String value = format.format((uploaded / (double) maxCount))
        println("已传输：" + uploaded / 1024 + "KB,传输进度：" + value)
        if (uploaded == maxCount) {
            stop()
            long endTime = System.currentTimeMillis()
            println("传输完成！用时：" + (endTime - startTime) / 1000 + "s")
        }
    }

    /**
     * 输出每个时间段的上传大小
     */
    @Override
    public boolean count(long count) {
        if (!isScheduled) {
            createThread()
        }
        uploaded += count
        if (count > 0) {
            return true
        }
        return false
    }

    /**
     * 文件上传结束时调用
     */
    @Override
    public void end() {
        // println("文件传输结束");
    }

    /**
     * 文件上传时开始调用
     */
    @Override
    public void init(int op, String src, String dest, long max) {
        println("开始上传文件：$src 至远程：$dest 文件总大小 ${maxCount/ 1024}KB")
		startTime = System.currentTimeMillis()
	}

	public void createThread() {
		executorService = Executors.newSingleThreadScheduledExecutor()
                executorService.scheduleWithFixedDelay(this, 1, 2, TimeUnit.SECONDS)
                isScheduled = true
    }


    public void stop() {
        boolean isShutdown = executorService.isShutdown()
        if (!isShutdown) {
            executorService.shutdown()
        }
    }

}