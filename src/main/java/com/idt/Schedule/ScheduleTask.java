package com.idt.Schedule;

import com.idt.Socket.Client;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class ScheduleTask {
    @Scheduled(cron = "0/20 * * * * ?")
    private void configureTasks(){

        String msg="{\"head\":\"EOOaciT3XmY7QAXsC9pFwFukY4DDmnR+s/rL98WS6u/SbwONksJYBrU2zBXRNE+/TwtuvMoaWIQaMzisSUNy/8BULVSnkp//vvA+b/5bdSfDqM+3Jm9VLrqwfvU76cZJO/6Nbbyq2NUZTmpk9q1WoSnStmWmTv1Z0YObu1YAbac=\",\"body\":\"Jhh80l4WRF4OKjSC72ehbmdgxCXojtcyj5tOlvKXJE9rWDPLkiPKSgVwLq/W7QEOOXzlWV8oSgvOGpeTRSQF93+SlsOKhJgtD7dpWwIB2vY6YsaWBp3wGpz58A0ELtyALED26Gc1uXMj6yJ32UkXm9uN2AIU2uF7/io8M4XsX08zou91h1djMgjt0lsWwhHQ5XkGKLz17aRzRYXATn1l5Ckx2fbaOA3yA7+v2nvDy8U/1T18vMavsBT+wFYScxKQT2mapU937fOGle1FhlyoxjtaCLZXz/XQSxjIXvJhMkDBwcjAHCU7ta0WLCetIu6zhJ0qltKQ2DQHLOF370Wy3m1pzbobz3BnWGjIPQwOhDYacLGyE21mFDeAaHVejC9rm4Amt80nLmbYrevHL80Q28s2XY6KQdsq1W7zCKfQ/qMqxYQCtTPbVRQoSDQpw0uTNCYVTUUg7uuB93bLDEVbDC8lWjaEULXb+GGfG/AFUlc=\"}@@";
        try {
            System.out.println("当前执行时间："+LocalDateTime.now());
            System.out.println("传输数据："+msg);
            Client.sendMsg(msg.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
