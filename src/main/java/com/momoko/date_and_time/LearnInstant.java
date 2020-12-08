package com.momoko.date_and_time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by momoko on 2019/12/6
 *
 * @author momoko
 */
public class LearnInstant {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());

        //以指定时间戳创建Instant
        Instant instant = Instant.ofEpochSecond(1575615891);
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        System.out.println(zdt);

        /*
          对于某一个时间戳，给它关联上指定的ZoneId，就得到了ZonedDateTime，
          继而可以获得了对应时区的LocalDateTime
          LocalDateTime，ZoneId，Instant，ZonedDateTime和long都可以互相转换：
          ┌─────────────┐
          │LocalDateTime│────┐
          └─────────────┘    │    ┌─────────────┐
                             ├───>│ZonedDateTime│
          ┌─────────────┐    │    └─────────────┘
          │   ZoneId    │────┘           ▲
          └─────────────┘      ┌─────────┴─────────┐
                               │                   │
                               ▼                   ▼
                        ┌─────────────┐     ┌─────────────┐
                        │   Instant   │<───>│    long     │
                        └─────────────┘     └─────────────┘

         */
    }
}
